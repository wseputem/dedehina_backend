package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.CatExhibitionsDTO;
import com.museumsgide.demo.persistece.entity.CatExhibitions;
import org.springframework.stereotype.Component;

@Component
public class CatExhebitionsMapper {
    public CatExhibitions createCatExhibitions(CatExhibitionsDTO catExhibitionsDTO){
        CatExhibitions catExhibitions = new CatExhibitions();
        catExhibitions.setId(catExhibitionsDTO.getId());
        catExhibitions.setName(catExhibitionsDTO.getName());
        return catExhibitions;
    }

    public CatExhibitionsDTO createCatExhibitionsDTO(CatExhibitions catExhibitions){
        CatExhibitionsDTO catExhibitionsDTO = new CatExhibitionsDTO();
        catExhibitionsDTO.setId(catExhibitions.getId());
        catExhibitionsDTO.setName(catExhibitions.getName());
        return catExhibitionsDTO;
    }
}
