package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.ObjectsDTO;
import com.museumsgide.demo.persistece.entity.Objects;
import com.museumsgide.demo.persistece.repository.AuthorRepository;
import com.museumsgide.demo.persistece.repository.CatObjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectsMapper {
    private AuthorRepository authorRepository;
    private CatObjectsRepository catObjectsRepository;

    @Autowired
    public ObjectsMapper(AuthorRepository authorRepository, CatObjectsRepository catObjectsRepository) {
        this.authorRepository = authorRepository;
        this.catObjectsRepository = catObjectsRepository;
    }

    public Objects createObjects(ObjectsDTO objectsDTO){
        Objects objects = new Objects();
        objects.setId(objectsDTO.getId());
        objects.setName(objectsDTO.getName());
        objects.setAuthor(authorRepository.findById(objectsDTO.getAuthorId()).orElse(null));
        objects.setCatObject(catObjectsRepository.findById(objectsDTO.getCatObjectsId()).orElse(null));
        objects.setDate(objectsDTO.getDate());
        return objects;
    }

    public  ObjectsDTO createObjectsDTO(Objects objects){
        ObjectsDTO objectsDTO = new ObjectsDTO();
        objectsDTO.setId(objects.getId());
        objectsDTO.setName(objects.getName());
        objectsDTO.setAuthorId(objects.getAuthor().getId());
        objectsDTO.setCatObjectsId(objects.getCatObject().getId());
        objectsDTO.setDate(objects.getDate());
        return objectsDTO;
    }
}
