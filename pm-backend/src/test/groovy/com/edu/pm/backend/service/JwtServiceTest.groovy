package com.edu.pm.backend.service

import com.edu.pm.backend.model.User
import com.edu.pm.backend.model.enums.Role
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import spock.lang.Specification

import java.util.stream.Collectors

class JwtServiceTest extends Specification {

    JwtService jwtService = new JwtService()

    def "generate token and validate token successfully"() {
        given: "A user with roles"
        UserDetails user = User.builder()
                .username("testUser")
                .roles([Role.EDITING])
                .accountActivated(true)
                .build()

        when: "Token is generated for the user"
        String token = jwtService.generateToken(user)

        then: "Token is not null"
        token != null

        and: "Extracted username from token matches the user's username"
        jwtService.extractUsername(token) == user.getUsername()

        and: "Token is valid for the user"
        jwtService.isTokenValid(token, user)
    }

    def "ExpiredJwtException is thrown for expired token"() {
        given: "A user and an expired token"
        User user = new User(username: 'expiredUser', accountActivated: true, roles: [Role.EDITING])
        String expiredToken = generateTokenWithPastExpirationDate(user)

        when: "isTokenValid is called with expired token"
        jwtService.isTokenValid(expiredToken, user)

        then: "ExpiredJwtException is thrown"
        thrown(ExpiredJwtException)
    }

    private String generateTokenWithPastExpirationDate(UserDetails user) {
        Map<String, Object> claims = new HashMap<>()
        claims.put("role", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(", ")))
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24))
                .setExpiration(new Date(System.currentTimeMillis() - 1000 * 60 * 60))
                .signWith(jwtService.getSignInKey(), SignatureAlgorithm.HS256)
                .compact()
    }
}

