package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.CityDTO;
import com.museumsgide.demo.persistece.entity.City;
import com.museumsgide.demo.persistece.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityMapper {
    private CountryRepository countryRepository;

    @Autowired
    public CityMapper(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public City createCity(CityDTO cityDTO){
        City city = new City();
        city.setId(cityDTO.getId());
        city.setName(cityDTO.getName());
        city.setCountry(countryRepository.findById(cityDTO.getCountryId()).orElse(null));
        return city;
    }

    public CityDTO createCityDTO(City city){
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setCountryId(city.getCountry().getId());
        return cityDTO;
    }
    public List<CityDTO> createCityDTOList(List<City> cities){
        List<CityDTO> cityDTOS = new ArrayList<>();
        for (City city : cities){
            cityDTOS.add(createCityDTO(city));
        }
        return cityDTOS;
    }

}
