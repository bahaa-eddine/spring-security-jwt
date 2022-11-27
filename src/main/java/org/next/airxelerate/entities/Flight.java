package org.next.airxelerate.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Flight {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column
    @Size(max = 3, message = "invalid iataCarrierCode, should be less than 3 letters")
    private String iataCarrierCode;
    @NotNull
    @Column
    @Size(max = 3, message = "invalid originAirportCode, should be less than 3 letters")
    private String originAirportCode;
    @NotNull
    @Column
    @Size(max = 3, message = "invalid destinationAirportCode, should be less than 3 letters")
    private String destinationAirportCode;
    @NotNull
    @Column
    private Date departureDate;
    @Column
    @NotNull
    private Integer number;
}