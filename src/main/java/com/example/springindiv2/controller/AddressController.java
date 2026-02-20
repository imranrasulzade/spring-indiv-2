package com.example.springindiv2.controller;

import com.example.springindiv2.dto.AddressDto;
import com.example.springindiv2.service.AddressService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {


    private final AddressService addressService;

    @Tag(name = "addr")
    @PostMapping()
    public void add(@RequestBody AddressDto dto) {
        addressService.add(dto);
    }

    @Tag(name = "addr")
    @GetMapping("{id}")
    public AddressDto get(@PathVariable Integer id) {
        return addressService.getById(id);
    }

}
