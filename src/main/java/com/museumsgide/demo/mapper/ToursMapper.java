package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.ToursDTO;
import com.museumsgide.demo.persistece.entity.Tours;
import com.museumsgide.demo.persistece.repository.ExhibitionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToursMapper {
    private ExhibitionsRepository exhibitionsRepository;

    @Autowired
    public ToursMapper(ExhibitionsRepository exhibitionsRepository) {
        this.exhibitionsRepository = exhibitionsRepository;
    }

    public Tours createTours(ToursDTO toursDTO){
        Tours tours = new Tours();
        tours.setId(toursDTO.getId());
        tours.setName(toursDTO.getName());
        tours.setPrice(toursDTO.getPrice());
        tours.setDuration(toursDTO.getDuration());
        tours.setExhibitions(exhibitionsRepository.findById(toursDTO.getId()).orElse(null));
        return tours;
    }

    public  ToursDTO createToursDTO(Tours tours){
        ToursDTO toursDTO = new ToursDTO();
        toursDTO.setId(tours.getId());
        toursDTO.setName(tours.getName());
        toursDTO.setPrice(tours.getPrice());
        toursDTO.setDuration(tours.getDuration());
        toursDTO.setExhibitionsId(tours.getExhibitions().getId());
        return toursDTO;
    }
    public List<ToursDTO> createToursDTOList(List<Tours> toursList){
        List<ToursDTO> toursDTOS = new ArrayList<>();
        for (Tours tours : toursList){
            toursDTOS.add(createToursDTO(tours));
        }
        return toursDTOS;
    }
}
