package com.museumsgide.demo.shared.mapper;

import com.museumsgide.demo.shared.dto.OwnersDTO;
import com.museumsgide.demo.persistece.entity.Owners;
import com.museumsgide.demo.persistece.repository.CatOwnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OwnersMapper {
    private CatOwnersRepository catOwnersRepository;

    @Autowired
    public OwnersMapper(CatOwnersRepository catOwnersRepository) {
        this.catOwnersRepository = catOwnersRepository;
    }

    public Owners createOwners(OwnersDTO ownersDTO){
        Owners owners = new Owners();
        owners.setId(ownersDTO.getId());
        owners.setName(ownersDTO.getName());
        owners.setDateOfReg(ownersDTO.getDateOfReg());
        owners.setCatOwners(catOwnersRepository.findById(ownersDTO.getId()).orElse(null));
        return owners;
    }

    public OwnersDTO createOwnersDTO(Owners owners){
        OwnersDTO ownersDTO = new OwnersDTO();
        ownersDTO.setId(owners.getId());
        ownersDTO.setName(owners.getName());
        ownersDTO.setDateOfReg(owners.getDateOfReg());
        ownersDTO.setCatOwnersId(owners.getCatOwners().getId());
        return ownersDTO;
    }
}
