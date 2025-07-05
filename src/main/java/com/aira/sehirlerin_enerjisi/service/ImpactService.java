package com.aira.sehirlerin_enerjisi.service;

import com.aira.sehirlerin_enerjisi.dto.ImpactRequestDto;
import com.aira.sehirlerin_enerjisi.dto.ImpactResponseDto;
import com.aira.sehirlerin_enerjisi.model.Reactor;
import com.aira.sehirlerin_enerjisi.repository.ReactorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImpactService {

    private final ReactorRepository reactorRepository;

    public List<ImpactResponseDto> calculateImpact(ImpactRequestDto request) {
        List<Reactor> reactors = reactorRepository.findAll();

        return reactors.stream().map(reactor -> {
            double distance = haversine(
                    request.getLatitude(), request.getLongitude(),
                    reactor.getLatitude(), reactor.getLongitude());

            double score = Math.max(0, 1 - distance / 500);
            String level = score > 0.66 ? "HIGH" : score > 0.33 ? "MEDIUM" : "LOW";

            return new ImpactResponseDto(reactor, distance, score, level);
        }).collect(Collectors.toList());
    }


    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(Math.toRadians(lat1)) *
                        Math.cos(Math.toRadians(lat2)) *
                        Math.pow(Math.sin(dLon / 2), 2);

        return 2 * R * Math.asin(Math.sqrt(a));
    }
}
