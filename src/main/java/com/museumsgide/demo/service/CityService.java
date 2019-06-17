package com.museumsgide.demo.service;

import com.museumsgide.demo.dto.CityDTO;
import com.museumsgide.demo.mapper.CityMapper;
import com.museumsgide.demo.persistece.entity.City;
import com.museumsgide.demo.persistece.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private CityMapper cityMapper;
    private CityRepository cityRepository;

    @Autowired
    public CityService(CityMapper cityMapper, CityRepository cityRepository) {
        this.cityMapper = cityMapper;
        this.cityRepository = cityRepository;
    }

    public CityDTO save(CityDTO cityDTO){
        City city = cityMapper.createCity(cityDTO);
        city = cityRepository.save(city);
        return cityMapper.createCityDTO(city);
    }

    public String delete(Long id){
        City city = cityRepository.findById(id).orElse(null);
        if (city != null) {
            cityRepository.delete(city);
            return "success";
        } else {
            return "failure";
        }
    }

    public CityDTO update(CityDTO cityDTO){
        if (cityRepository.existsById(cityDTO.getId())) {
            return save(cityDTO);
        } else {
            return null;
        }
    }


    public List<CityDTO> searchByAll(){
        List<City> list = cityRepository.findAll();
        return cityMapper.createCityDTOList(list);
    }
}
