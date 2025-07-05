package com.aira.sehirlerin_enerjisi.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ImpactRequestDto {

    @NotNull(message = "Latitude boş olamaz")
    @Min(value = -90, message = "Latitude -90'dan küçük olamaz")
    @Max(value = 90, message = "Latitude 90'dan büyük olamaz")
    private Double latitude;

    @NotNull(message = "Longitude boş olamaz")
    @Min(value = -180, message = "Longitude -180'den küçük olamaz")
    @Max(value = 180, message = "Longitude 180'den büyük olamaz")
    private Double longitude;
}
