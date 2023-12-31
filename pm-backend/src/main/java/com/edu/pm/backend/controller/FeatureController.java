package com.edu.pm.backend.controller;

import com.edu.pm.backend.commons.dto.FeatureDTO;
import com.edu.pm.backend.commons.dto.FeatureFullDTO;
import com.edu.pm.backend.service.entity.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class FeatureController {

    private final FeatureService featureService;

    @GetMapping(value = "/feature")
    public ResponseEntity<Collection<FeatureDTO>> getAll() {
        return ResponseEntity.ok(featureService.findAll());
    }

    @PutMapping(value = "/feature", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FeatureDTO> update(@RequestBody FeatureDTO dto) {
        if (dto.getId() != null) {
            return ResponseEntity.ok(featureService.update(dto));
        }
        return ResponseEntity.ok(featureService.add(dto));
    }

    @GetMapping(value = "/feature/stories")
    public ResponseEntity<Collection<FeatureFullDTO>> getAllWithStories() {
        return ResponseEntity.ok(featureService.findAllWithStories());
    }

}
