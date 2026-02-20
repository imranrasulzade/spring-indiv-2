package com.example.springindiv2.mapper;

import com.example.springindiv2.dto.AddressDto;
import com.example.springindiv2.entity.Address;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {

    @Mapping(source = "state", target = "bolge")
    public abstract AddressDto toDto(Address address);

    @Mapping(source = "bolge", target = "state", qualifiedByName = "mapState")
    public abstract Address toEntity(AddressDto addressDto);

    @Named(value = "mapState")
    public String mapState(String bolge) {
        return bolge.toUpperCase();
    }
}
