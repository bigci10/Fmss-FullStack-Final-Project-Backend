package com.example.fmssfinalproject.mapper.impl;

import com.example.fmssfinalproject.dto.request.CreateUpdateAddressRequest;
import com.example.fmssfinalproject.dto.response.AddressDto;
import com.example.fmssfinalproject.exception.ResourceNotFoundException;
import com.example.fmssfinalproject.mapper.IAddressMapper;
import com.example.fmssfinalproject.model.Address;
import com.example.fmssfinalproject.model.Employee;
import com.example.fmssfinalproject.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddressMapperImpl implements IAddressMapper {

    private EmployeeRepository employeeRepository;

    @Override
    public AddressDto addressToDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto.AddressDtoBuilder<?, ?> addressDto = AddressDto.builder();

        addressDto.adress(address.getAdress());
        addressDto.city( address.getCity() );
        addressDto.country( address.getCountry() );
        addressDto.postalCode( address.getPostalCode() );

        return addressDto.build();
    }

    @Override
    public Address createAddressFromCreateAddresRequest(CreateUpdateAddressRequest createAddressRequest) {
        if ( createAddressRequest == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.adress( createAddressRequest.getAddressLine() );
        address.city( createAddressRequest.getCity() );
        address.country( createAddressRequest.getCountry() );
        address.postalCode( createAddressRequest.getPostalCode() );

        return address.build();
    }

    @Override
    public Address updateAddress(Address address, CreateUpdateAddressRequest updateAddressRequest) {
        if ( updateAddressRequest == null ) {
            return null;
        }

        address.setAdress( updateAddressRequest.getAddressLine() );
        address.setCity( updateAddressRequest.getCity() );
        address.setCountry( updateAddressRequest.getCountry() );
        address.setPostalCode( updateAddressRequest.getPostalCode() );

        return address;
    }

}
