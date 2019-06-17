package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.OrganizerDTO;
import com.museumsgide.demo.persistece.entity.Exhibitions;
import com.museumsgide.demo.persistece.entity.Organizer;
import com.museumsgide.demo.persistece.repository.ExhibitionsRepository;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrganizerMapper {
    private ExhibitionsRepository exhibitionsRepository;

    @Autowired
    public OrganizerMapper(ExhibitionsRepository exhibitionsRepository) {
        this.exhibitionsRepository = exhibitionsRepository;
    }

    public Organizer createOrganizer(OrganizerDTO organizerDTO){
        Organizer organizer = new Organizer();
        organizer.setId(organizerDTO.getId());
        organizer.setName(organizerDTO.getName());
        List<Exhibitions> exhibitions = Lists.newArrayList(exhibitionsRepository.findAllById(organizerDTO.getExhibitionIds()));
        organizer.setExhibitions(exhibitions);
        return organizer;
    }

    public OrganizerDTO createOrganizerDTO(Organizer organizer){
        OrganizerDTO organizerDTO = new OrganizerDTO();
        organizerDTO.setId(organizer.getId());
        organizerDTO.setName(organizer.getName());
        organizerDTO.setExhibitionIds(organizer.getExhibitions().stream().map(Exhibitions::getId).collect(Collectors.toList()));
        return organizerDTO;
    }
    public List<OrganizerDTO> createOrganizerDTOList(List<Organizer> organizerList){
        List<OrganizerDTO> organizerDTOS = new ArrayList<>();
        for (Organizer organizer : organizerList){
            organizerDTOS.add(createOrganizerDTO(organizer));
        }
        return organizerDTOS;
    }
}
