package com.museumsgide.demo.service;

import com.museumsgide.demo.dto.ObjectsDTO;
import com.museumsgide.demo.mapper.ObjectsMapper;
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

    @Autowired
    public ObjectsService(ObjectsMapper objectsMapper, ObjectRepository objectRepository) {
        this.objectsMapper = objectsMapper;
        this.objectRepository = objectRepository;
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
}
