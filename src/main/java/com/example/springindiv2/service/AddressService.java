package com.example.springindiv2.service;

import com.example.springindiv2.dto.AddressDto;
import com.example.springindiv2.entity.Address;
import com.example.springindiv2.mapper.AddressMapper;
import com.example.springindiv2.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public AddressDto getById(Integer id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        AddressDto addressDto = addressMapper.toDto(address);
//        addressDto.setId(address.getId());
//        addressDto.setStreet(address.getStreet());
//        addressDto.setCity(address.getCity());
//        addressDto.setState(address.getState());
//        addressDto.setStateAndCity(address.getState() + " " + address.getCity());
        return addressDto;
    }

    public void add(AddressDto addressDto) {
        Address address = addressMapper.toEntity(addressDto);
//        address.setStreet(addressDto.getStreet());
//        address.setCity(addressDto.getCity());
//        address.setState(addressDto.getState());
//        address.setCity(addressDto.getStateAndCity().split(" ")[1]);
//        address.setState(addressDto.getStateAndCity().split(" ")[0]);
        addressRepository.save(address);
    }

}
