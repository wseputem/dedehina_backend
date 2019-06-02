package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.CatOwnersDTO;
import com.museumsgide.demo.persistece.entity.CatOwners;
import org.springframework.stereotype.Component;

@Component
public class CatOwnersMapper {
    public CatOwners createCatOwners(CatOwnersDTO catOwnersDTO){
        CatOwners catOwners = new CatOwners();
        catOwners.setId(catOwnersDTO.getId());
        catOwners.setName(catOwnersDTO.getName());
        return catOwners;
    }

    public CatOwnersDTO createCatOwnersDTO(CatOwners catOwners){
        CatOwnersDTO catOwnersDTO = new CatOwnersDTO();
        catOwnersDTO.setId(catOwners.getId());
        catOwnersDTO.setName(catOwners.getName());
        return catOwnersDTO;
    }
}
