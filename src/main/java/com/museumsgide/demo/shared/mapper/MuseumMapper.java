package com.museumsgide.demo.shared.mapper;

import com.museumsgide.demo.shared.dto.MuseumDTO;
import com.museumsgide.demo.persistece.entity.Museum;
import com.museumsgide.demo.persistece.repository.CatMuseumsRepository;
import com.museumsgide.demo.persistece.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MuseumMapper {
    private CityRepository cityRepository;
    private CatMuseumsRepository catMuseumsRepository;

    @Autowired
    public MuseumMapper(CityRepository cityRepository, CatMuseumsRepository catMuseumsRepository) {
        this.cityRepository = cityRepository;
        this.catMuseumsRepository = catMuseumsRepository;
    }

    public Museum createMuseum (MuseumDTO museumDTO){
        Museum museum = new Museum();
        museum.setId(museumDTO.getId());
        museum.setName(museumDTO.getName());
        museum.setDescription(museumDTO.getDescription());
        museum.setCity(cityRepository.findById(museumDTO.getCityId()).orElse(null));
        museum.setCatMuseums(catMuseumsRepository.findById(museumDTO.getCatMuseumsId()).orElse(null));
        museum.setEntrancePrice(museumDTO.getEntrancePrice());
        museum.setUrl(museumDTO.getUrl());
        return museum;
    }

    public MuseumDTO createMuseumsDTO (Museum museum){
        MuseumDTO museumDTO = new MuseumDTO();
        museumDTO.setId(museum.getId());
        museumDTO.setName(museum.getName());
        museumDTO.setDescription(museum.getDescription());
        museumDTO.setCityId(museum.getCity().getId());
        museumDTO.setCatMuseumsId(museum.getCatMuseums().getId());
        museumDTO.setEntrancePrice(museum.getEntrancePrice());
        museumDTO.setUrl(museum.getUrl());
        return museumDTO;
    }

    public List<MuseumDTO> createMuseumDTOList(List<Museum> museumList){
        List<MuseumDTO> museumDTOList = new ArrayList<>();
        for (Museum museum : museumList) {
            museumDTOList.add(createMuseumsDTO(museum));
        }
        return museumDTOList;
    }
}
