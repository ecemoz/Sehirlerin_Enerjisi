package com.aira.sehirlerin_enerjisi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.aira.sehirlerin_enerjisi.model.Reactor;

@Data
@AllArgsConstructor
public class ImpactResponseDto {
    private Reactor reactor;
    private double distanceKm;
    private double impactScore;
    private String impactLevel;
}