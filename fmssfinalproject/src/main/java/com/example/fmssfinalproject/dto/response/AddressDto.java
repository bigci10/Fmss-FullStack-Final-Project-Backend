package com.example.fmssfinalproject.dto.response;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AddressDto {



    private String adress;

    private String city;

    private String country;

    private int postalCode;

}
