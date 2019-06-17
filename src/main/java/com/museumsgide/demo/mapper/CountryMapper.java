package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.CountryDTO;
import com.museumsgide.demo.persistece.entity.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryMapper {
    public Country createCountry(CountryDTO countryDTO){
        Country country = new Country();
        country.setId(countryDTO.getId());
        country.setName(countryDTO.getName());
        return country;
    }

    public CountryDTO createCantryDTO(Country country){
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());
        return countryDTO;
    }
    public List<CountryDTO> createCountryDTOList(List<Country> countries){
        List<CountryDTO> countryDTOS = new ArrayList<>();
        for (Country country : countries){
            countryDTOS.add(createCantryDTO(country));
        }
        return countryDTOS;
    }
}
