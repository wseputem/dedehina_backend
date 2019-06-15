package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.ObjectsDTO;
import com.museumsgide.demo.persistece.entity.Objects;
import com.museumsgide.demo.persistece.repository.AuthorRepository;
import com.museumsgide.demo.persistece.repository.CatObjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ObjectsMapper {
    private AuthorRepository authorRepository;
    private CatObjectsRepository catObjectsRepository;
    private ExhibitionsMapper exhibitionsMapper;

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
        objects.setExhibitionsList(exhibitionsMapper.createExhibitionsList(objectsDTO.getExhibitionsDTOList()));
        return objects;
    }

    public  ObjectsDTO createObjectsDTO(Objects objects){
        ObjectsDTO objectsDTO = new ObjectsDTO();
        objectsDTO.setId(objects.getId());
        objectsDTO.setName(objects.getName());
        objectsDTO.setAuthorId(objects.getAuthor().getId());
        objectsDTO.setCatObjectsId(objects.getCatObject().getId());
        objectsDTO.setDate(objects.getDate());
        objectsDTO.setExhibitionsDTOList(exhibitionsMapper.createExhibitionsDTOList(objects.getExhibitionsList()));
        return objectsDTO;
    }


    public List<ObjectsDTO> createObjectsDTOList(List<Objects> objectsList){
        List<ObjectsDTO> objectsDTOList = new ArrayList<>();
        for (Objects objects : objectsList) {
            objectsDTOList.add(createObjectsDTO(objects));
        }
        return objectsDTOList;
    }

    public List<Objects> createObjectsList(List<ObjectsDTO> objectsDTOList){
        List<Objects> objectsList = new ArrayList<>();
        for (ObjectsDTO objectsDTO : objectsDTOList) {
            objectsList.add(createObjects(objectsDTO));
        }
        return objectsList;
    }
}
