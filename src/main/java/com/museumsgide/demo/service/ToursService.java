package com.museumsgide.demo.service;

import com.museumsgide.demo.dto.ToursDTO;
import com.museumsgide.demo.mapper.ToursMapper;
import com.museumsgide.demo.persistece.entity.Tours;
import com.museumsgide.demo.persistece.repository.ToursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToursService {
    private ToursMapper toursMapper;
    private ToursRepository toursRepository;

    @Autowired
    public ToursService(ToursMapper toursMapper, ToursRepository toursRepository) {
        this.toursMapper = toursMapper;
        this.toursRepository = toursRepository;
    }


    public ToursDTO save(ToursDTO toursDTO){
        Tours tours = toursMapper.createTours(toursDTO);
        tours = toursRepository.save(tours);
        return toursMapper.createToursDTO(tours);
    }

    public String delete(Long id){
        Tours tours = toursRepository.findById(id).orElse(null);
        if (tours != null) {
            toursRepository.delete(tours);
            return "success";
        } else {
            return "failure";
        }
    }

    public ToursDTO update(ToursDTO toursDTO){
        if (toursRepository.existsById(toursDTO.getId())) {
            return save(toursDTO);
        } else {
            return null;
        }
    }


    public List<ToursDTO> searchByAll(){
        List<Tours> list = toursRepository.findAll();
        return toursMapper.createToursDTOList(list);
    }
}
