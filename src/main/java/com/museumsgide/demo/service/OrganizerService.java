package com.museumsgide.demo.service;

import com.museumsgide.demo.dto.OrganizerDTO;
import com.museumsgide.demo.mapper.OrganizerMapper;
import com.museumsgide.demo.persistece.entity.Organizer;
import com.museumsgide.demo.persistece.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {
    private OrganizerMapper organizerMapper;
    private OrganizerRepository organizerRepository;

    @Autowired
    public OrganizerService(OrganizerMapper organizerMapper, OrganizerRepository organizerRepository) {
        this.organizerMapper = organizerMapper;
        this.organizerRepository = organizerRepository;
    }

    public OrganizerDTO save(OrganizerDTO organizerDTO){
        Organizer organizer = organizerMapper.createOrganizer(organizerDTO);
        organizer = organizerRepository.save(organizer);
        return organizerMapper.createOrganizerDTO(organizer);
    }

    public String delete(Long id){
        Organizer organizer = organizerRepository.findById(id).orElse(null);
        if (organizer != null) {
            organizerRepository.delete(organizer);
            return "success";
        } else {
            return "failure";
        }
    }

    public OrganizerDTO update(OrganizerDTO organizerDTO){
        if (organizerRepository.existsById(organizerDTO.getId())) {
            return save(organizerDTO);
        } else {
            return null;
        }
    }


    public List<OrganizerDTO> searchByAll(){
        List<Organizer> list = organizerRepository.findAll();
        return organizerMapper.createOrganizerDTOList(list);
    }


}
