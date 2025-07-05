package com.aira.sehirlerin_enerjisi.data;

import com.aira.sehirlerin_enerjisi.model.Reactor;
import com.aira.sehirlerin_enerjisi.repository.ReactorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor
public class ReactorDataLoader implements CommandLineRunner {

    private final ReactorRepository reactorRepository;

    @Override
    public void run(String... args) throws Exception {
        InputStream is = getClass().getResourceAsStream("/reactors.csv");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                Reactor reactor = new Reactor();
                reactor.setName(tokens[0]);
                reactor.setCountry(tokens[1]);
                reactor.setLatitude(Double.parseDouble(tokens[2]));
                reactor.setLongitude(Double.parseDouble(tokens[3]));
                reactor.setType(tokens[4]);
                reactor.setThermalPower(Double.parseDouble(tokens[5]));
                reactor.setActive(Boolean.parseBoolean(tokens[6]));
                reactorRepository.save(reactor);
            }
        }
    }
}