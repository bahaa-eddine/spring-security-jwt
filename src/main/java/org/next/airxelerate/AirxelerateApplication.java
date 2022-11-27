package org.next.airxelerate;

import org.next.airxelerate.configurations.RsakeysConfig;
import org.next.airxelerate.entities.Flight;
import org.next.airxelerate.repositories.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(RsakeysConfig.class)
public class AirxelerateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirxelerateApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner runner(
            FlightRepository flightRepository
    ) {
        return args -> {
            List.of("XA1","XA2", "XA3").forEach(iata -> flightRepository.save(Flight.builder()
                    .iataCarrierCode(iata)
                    .destinationAirportCode("MAR")
                    .originAirportCode("FAR")
                    .departureDate(new Date())
                    .number((int) (Math.random()*100))
                    .build()));

        };
    }
}
