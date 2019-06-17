package com.museumsgide.demo.service;

import com.museumsgide.demo.dto.CountryDTO;
import com.museumsgide.demo.mapper.CountryMapper;
import com.museumsgide.demo.persistece.entity.Country;
import com.museumsgide.demo.persistece.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private CountryMapper countryMapper;
    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryMapper countryMapper, CountryRepository countryRepository) {
        this.countryMapper = countryMapper;
        this.countryRepository = countryRepository;
    }

    public CountryDTO save(CountryDTO countryDTO){
        Country country = countryMapper.createCountry(countryDTO);
        country = countryRepository.save(country);
        return countryMapper.createCantryDTO(country);
    }

    public String delete(Long id){
        Country country = countryRepository.findById(id).orElse(null);
        if (country != null) {
            countryRepository.delete(country);
            return "success";
        } else {
            return "failure";
        }
    }

    public CountryDTO update(CountryDTO countryDTO){
        if (countryRepository.existsById(countryDTO.getId())) {
            return save(countryDTO);
        } else {
            return null;
        }
    }


    public List<CountryDTO> searchByAll(){
        List<Country> list = countryRepository.findAll();
        return countryMapper.createCountryDTOList(list);
    }
}
