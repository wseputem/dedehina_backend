package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.CatMuseumsDTO;
import com.museumsgide.demo.persistece.entity.CatMuseums;
import org.springframework.stereotype.Component;

@Component
public class CatMuseumsMapper {
        public CatMuseums createCatMuseums(CatMuseumsDTO catMuseumsDTO){
            CatMuseums catMuseums = new CatMuseums();
            catMuseums.setId(catMuseumsDTO.getId());
            catMuseums.setName(catMuseums.getName());
            return catMuseums;
        }

        public CatMuseumsDTO createCatMuseumsDTO (CatMuseums catMuseums){
            CatMuseumsDTO catMuseumsDTO = new CatMuseumsDTO();
            catMuseumsDTO.setId(catMuseums.getId());
            catMuseumsDTO.setName(catMuseums.getName());
            return catMuseumsDTO;
        }
}
