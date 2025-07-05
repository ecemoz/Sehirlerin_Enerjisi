package com.aira.sehirlerin_enerjisi.service;

import com.aira.sehirlerin_enerjisi.dto.ImpactRequestDto;
import com.aira.sehirlerin_enerjisi.dto.ImpactResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ImpactServiceTest {

    @Autowired
    private ImpactService impactService;

    @Test
    public void testImpactCalculationReturnsResults() {
        ImpactRequestDto request = new ImpactRequestDto();
        request.setLatitude(39.92);    // Ankara
        request.setLongitude(32.85);

        List<ImpactResponseDto> results = impactService.calculateImpact(request);

        assertFalse(results.isEmpty(), "Sonuç listesi boş olmamalı");
        assertTrue(results.get(0).getDistanceKm() > 0, "Mesafe 0'dan büyük olmalı");
        assertNotNull(results.get(0).getImpactLevel(), "Etki seviyesi boş olmamalı");
    }
}
