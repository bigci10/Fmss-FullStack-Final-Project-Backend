package com.example.fmssfinalproject.mapper;

import com.example.fmssfinalproject.dto.request.CreateUpdateAddressRequest;
import com.example.fmssfinalproject.dto.response.AddressDto;
import com.example.fmssfinalproject.model.Address;

public interface IAddressMapper {

    AddressDto addressToDto(Address address);

    Address createAddressFromCreateAddresRequest(CreateUpdateAddressRequest createAddressRequest);

    Address updateAddress(Address address, CreateUpdateAddressRequest updateAddressRequest);

}
