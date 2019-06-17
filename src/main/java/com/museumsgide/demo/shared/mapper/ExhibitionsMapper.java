package com.museumsgide.demo.shared.mapper;

import com.museumsgide.demo.shared.dto.ExhibitionsDTO;
import com.museumsgide.demo.persistece.entity.Exhibitions;
import com.museumsgide.demo.persistece.entity.Objects;
import com.museumsgide.demo.persistece.entity.Organizer;
import com.museumsgide.demo.persistece.entity.Sponsors;
import com.museumsgide.demo.persistece.repository.*;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExhibitionsMapper {
    private CatExhibitionsRepository catExhibitionsRepository;
    private BranchRepository branchRepository;
    private ObjectRepository objectRepository;
    private SponsorsRepository sponsorsRepository;
    private OrganizerRepository organizerRepository;

    @Autowired
    public ExhibitionsMapper(CatExhibitionsRepository catExhibitionsRepository, BranchRepository branchRepository, ObjectRepository objectRepository, SponsorsRepository sponsorsRepository, OrganizerRepository organizerRepository) {
        this.catExhibitionsRepository = catExhibitionsRepository;
        this.branchRepository = branchRepository;
        this.objectRepository = objectRepository;
        this.sponsorsRepository = sponsorsRepository;
        this.organizerRepository = organizerRepository;
    }

    public Exhibitions createExhibitions(ExhibitionsDTO exhibitionsDTO){
        Exhibitions exhibitions = new Exhibitions();
        exhibitions.setId(exhibitionsDTO.getId());
        exhibitions.setName(exhibitionsDTO.getName());
        exhibitions.setStartDate(exhibitionsDTO.getStartDate());
        exhibitions.setCompletionDate(exhibitionsDTO.getCompletionDate());
        exhibitions.setCatExhibitions(catExhibitionsRepository.findById(exhibitionsDTO.getCatExhibitionsId()).orElse(null));
        exhibitions.setBranch(branchRepository.findById(exhibitionsDTO.getBranchId()).orElse(null));
        List<Objects> objects = Lists.newArrayList(objectRepository.findAllById(exhibitionsDTO.getObjectIds()));
        exhibitions.setObjects(objects);
        List<Sponsors> sponsors = Lists.newArrayList(sponsorsRepository.findAllById(exhibitionsDTO.getSponsorIds()));
        exhibitions.setSponsors(sponsors);
        List<Organizer> organizers = Lists.newArrayList(organizerRepository.findAllById(exhibitionsDTO.getOrganizerIds()));
        exhibitions.setOrganizers(organizers);
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
        exhibitionsDTO.setObjectIds(exhibitions.getObjects().stream().map(Objects::getId).collect(Collectors.toList()));
        exhibitionsDTO.setSponsorIds(exhibitions.getSponsors().stream().map(Sponsors::getId).collect(Collectors.toList()));
        exhibitionsDTO.setOrganizerIds(exhibitions.getOrganizers().stream().map(Organizer::getId).collect(Collectors.toList()));
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
