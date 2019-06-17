package com.museumsgide.demo.service;

import com.museumsgide.demo.shared.dto.ExhibitionsDTO;
import com.museumsgide.demo.shared.dto.ObjectsDTO;
import com.museumsgide.demo.shared.mapper.ExhibitionsMapper;
import com.museumsgide.demo.shared.mapper.ObjectsMapper;
import com.museumsgide.demo.persistece.entity.Exhibitions;
import com.museumsgide.demo.persistece.entity.Objects;
import com.museumsgide.demo.persistece.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ObjectsService {
    private ObjectsMapper objectsMapper;
    private ObjectRepository objectRepository;
    private ExhibitionsMapper exhibitionsMapper;

    @Autowired
    public ObjectsService(ObjectsMapper objectsMapper, ObjectRepository objectRepository, ExhibitionsMapper exhibitionsMapper) {
        this.objectsMapper = objectsMapper;
        this.objectRepository = objectRepository;
        this.exhibitionsMapper = exhibitionsMapper;
    }

    public ObjectsDTO save(ObjectsDTO objectsDTO){
        Objects objects = objectsMapper.createObjects(objectsDTO);
        objects = objectRepository.save(objects);
        return objectsMapper.createObjectsDTO(objects);
    }

    public String delete(Long id){
        Objects objects = objectRepository.findById(id).orElse(null);
        if (objects != null) {
            objectRepository.delete(objects);
            return "success";
        } else {
            return "failure";
        }
    }

    public ObjectsDTO update(ObjectsDTO objectsDTO){
        if (objectRepository.existsById(objectsDTO.getId())) {
            return save(objectsDTO);
        } else {
            return null;
        }
    }

    public List<ObjectsDTO> searchByAll(){
        List<Objects> objectsList = objectRepository.findAll();
        return objectsMapper.createObjectsDTOList(objectsList);
    }

    public List<ObjectsDTO> searchByName(String name){
        List<Objects> objectsList = objectRepository.findAllByName(name);
        if (objectsList != null) {
            return objectsMapper.createObjectsDTOList(objectsList);
        } else {
            return null;
        }
    }

    public List<ObjectsDTO> searchByDate(Date date) {
        List<Objects> objectsList = objectRepository.findAllByDate(date);
        if (objectsList != null) {
            return objectsMapper.createObjectsDTOList(objectsList);
        } else {
            return null;
        }
    }

    public List<ObjectsDTO> searchByCatObject_Name(String name){
        List<Objects> objectsList = objectRepository.findAllByCatObject_Name(name);
        if (objectsList != null) {
            return objectsMapper.createObjectsDTOList(objectsList);
        } else {
            return null;
        }
    }

    public List<ObjectsDTO> searchByAuthor_Name(String name){
        List<Objects> objectsList = objectRepository.findAllByAuthor_NameContaining(name);
        if (objectsList != null) {
            return objectsMapper.createObjectsDTOList(objectsList);
        } else {
            return null;
        }
    }
    public List<ExhibitionsDTO> searchExhibitionsByObjectName(String name){
        List<Objects> objectsList = objectRepository.findAllByName(name);
        List<Exhibitions> exhibitionsList = null;
        if (objectsList != null) {
            for(Objects objects : objectsList){
                exhibitionsList = objects.getExhibitions();
            }
            return exhibitionsMapper.createExhibitionsDTOList(exhibitionsList);
        } else {
            return null;
        }
    }
}
