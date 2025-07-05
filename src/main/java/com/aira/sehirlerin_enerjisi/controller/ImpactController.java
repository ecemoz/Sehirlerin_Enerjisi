package com.aira.sehirlerin_enerjisi.controller;

import com.aira.sehirlerin_enerjisi.dto.ImpactRequestDto;
import com.aira.sehirlerin_enerjisi.dto.ImpactResponseDto;
import com.aira.sehirlerin_enerjisi.service.ImpactService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/impact")
@CrossOrigin(origins = "*")
public class ImpactController {

    private final ImpactService impactService;

    public ImpactController(ImpactService impactService) {
        this.impactService = impactService;
    }

    @PostMapping
    public List<ImpactResponseDto> calculateImpact(@Valid @RequestBody ImpactRequestDto request) {
        return impactService.calculateImpact(request);
    }
}

