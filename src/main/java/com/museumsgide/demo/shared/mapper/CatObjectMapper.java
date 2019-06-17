package com.museumsgide.demo.shared.mapper;

import com.museumsgide.demo.shared.dto.CatObjectDTO;
import com.museumsgide.demo.persistece.entity.CatObject;
import org.springframework.stereotype.Component;

@Component
public class CatObjectMapper {
    public CatObject createCatObject(CatObjectDTO catObjectDTO){
        CatObject catObject = new CatObject();
        catObject.setId(catObjectDTO.getId());
        catObject.setName(catObjectDTO.getName());
        return catObject;
    }

    public CatObjectDTO createCatObjectDTO(CatObject catObject){
        CatObjectDTO catObjectDTO = new CatObjectDTO();
        catObjectDTO.setId(catObject.getId());
        catObjectDTO.setName(catObject.getName());
        return catObjectDTO;
    }
}
