package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.ExhibitionsDTO;
import com.museumsgide.demo.dto.ObjectsDTO;
import com.museumsgide.demo.persistece.entity.Exhibitions;
import com.museumsgide.demo.persistece.entity.Objects;
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
    private ObjectsMapper objectsMapper;

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
        exhibitions.setObjectsList(objectsMapper.createObjectsList(exhibitionsDTO.getObjectsDTOList()));
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
        exhibitionsDTO.setObjectsDTOList(objectsMapper.createObjectsDTOList(exhibitions.getObjectsList()));
        return exhibitionsDTO;
    }


    public List<ExhibitionsDTO> createExhibitionsDTOList(List<Exhibitions> exhibitionsList){
        List<ExhibitionsDTO> exhibitionsDTOList = new ArrayList<>();
        for (Exhibitions exhibitions : exhibitionsList){
            exhibitionsDTOList.add(createExhibitionsDTO(exhibitions));
        }
        return exhibitionsDTOList;
    }

    public List<Exhibitions> createExhibitionsList(List<ExhibitionsDTO> exhibitionsDTOList){
        List<Exhibitions> exhibitionsList = new ArrayList<>();
        for (ExhibitionsDTO exhibitionsDTO : exhibitionsDTOList){
            exhibitionsList.add(createExhibitions(exhibitionsDTO));
        }
        return exhibitionsList;
    }
}
