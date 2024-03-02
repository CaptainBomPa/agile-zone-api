package com.edu.pm.backend.controller

import com.edu.pm.backend.commons.dto.auth.AuthenticationRequest
import com.edu.pm.backend.commons.dto.auth.AuthenticationResponse
import com.edu.pm.backend.service.AuthenticationService
import org.springframework.http.HttpStatus
import spock.lang.Specification

class AuthenticationControllerTest extends Specification {

    AuthenticationService authenticationService = Mock(AuthenticationService)
    AuthenticationController authenticationController = new AuthenticationController(authenticationService)

    def "authenticate method returns token on successful authentication"() {
        given: "An authentication request and a mock response"
        def request = new AuthenticationRequest(username: "user", password: "password")
        def expectedResponse = new AuthenticationResponse(token: "mockedToken")
        authenticationService.authenticate(request) >> expectedResponse

        when: "authenticate is called with the request"
        def result = authenticationController.authenticate(request)

        then: "Service is called and correct response is returned"
        result.statusCode == HttpStatus.OK
        result.body.token == "mockedToken"
    }
}

