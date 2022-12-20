package com.example.fmssfinalproject.dto.request;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateUpdateAddressRequest {

    @NotBlank(message = "Address should not blank.")
    private String addressLine;

    @NotNull(message = "City must not null.")
    private String city;

    @NotNull(message = "Country must not null.")
    private String country;

    @NotBlank(message = "Postal code should not blank")
    private int postalCode;

}
