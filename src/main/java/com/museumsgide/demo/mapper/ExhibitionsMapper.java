package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.ExhibitionsDTO;
import com.museumsgide.demo.persistece.entity.Exhibitions;
import com.museumsgide.demo.persistece.repository.BranchRepository;
import com.museumsgide.demo.persistece.repository.CatExhibitionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExhibitionsMapper {
    private CatExhibitionsRepository catExhibitionsRepository;
    private BranchRepository branchRepository;

    @Autowired
    public ExhibitionsMapper(CatExhibitionsRepository catExhibitionsRepository, BranchRepository branchRepository) {
        this.catExhibitionsRepository = catExhibitionsRepository;
        this.branchRepository = branchRepository;
    }

    public Exhibitions createExhibitions(ExhibitionsDTO exhibitionsDTO){
        Exhibitions exhibitions = new Exhibitions();
        exhibitions.setId(exhibitionsDTO.getId());
        exhibitions.setName(exhibitionsDTO.getName());
        exhibitions.setStartDate(exhibitionsDTO.getStartDate());
        exhibitions.setCompletionDate(exhibitionsDTO.getCompletionDate());
        exhibitions.setCatExhibitions(catExhibitionsRepository.findById(exhibitionsDTO.getCatExhibitionsId()).orElse(null));
        exhibitions.setBranch(branchRepository.findById(exhibitionsDTO.getBranchId()).orElse(null));
        return exhibitions;
    }

    public ExhibitionsDTO createExhibitionsDTO(Exhibitions exhibitions){
        ExhibitionsDTO exhibitionsDTO = new ExhibitionsDTO();
        exhibitionsDTO.setId(exhibitions.getId());
        exhibitionsDTO.setName(exhibitions.getName());
        exhibitionsDTO.setStartDate(exhibitions.getStartDate());
        exhibitionsDTO.setCompletionDate(exhibitions.getCompletionDate());
        exhibitionsDTO.setCatExhibitionsId(exhibitions.getCatExhibitions().getId());
        exhibitionsDTO.setBranchId(exhibitions.getBranch().getId());
        return exhibitionsDTO;
    }

    public List<ExhibitionsDTO> createExhibitionsDTOList(List<Exhibitions> exhibitionsList){
        List<ExhibitionsDTO> exhibitionsDTOList = new ArrayList<>();
        for (Exhibitions exhibitions : exhibitionsList){
            exhibitionsDTOList.add(createExhibitionsDTO(exhibitions));
        }
        return exhibitionsDTOList;
    }
}
