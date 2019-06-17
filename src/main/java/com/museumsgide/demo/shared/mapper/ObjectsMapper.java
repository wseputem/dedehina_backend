package com.museumsgide.demo.shared.mapper;

import com.museumsgide.demo.shared.dto.ObjectsDTO;
import com.museumsgide.demo.persistece.entity.Exhibitions;
import com.museumsgide.demo.persistece.entity.Objects;
import com.museumsgide.demo.persistece.repository.AuthorRepository;
import com.museumsgide.demo.persistece.repository.CatObjectsRepository;
import com.museumsgide.demo.persistece.repository.ExhibitionsRepository;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ObjectsMapper {
    private AuthorRepository authorRepository;
    private CatObjectsRepository catObjectsRepository;
    private ExhibitionsRepository exhibitionsRepository;


    @Autowired
    public ObjectsMapper(AuthorRepository authorRepository, CatObjectsRepository catObjectsRepository, ExhibitionsRepository exhibitionsRepository) {
        this.authorRepository = authorRepository;
        this.catObjectsRepository = catObjectsRepository;
        this.exhibitionsRepository = exhibitionsRepository;
    }



    public Objects createObjects(ObjectsDTO objectsDTO){
        Objects objects = new Objects();
        objects.setId(objectsDTO.getId());
        objects.setName(objectsDTO.getName());
        objects.setAuthor(authorRepository.findById(objectsDTO.getAuthorId()).orElse(null));
        objects.setCatObject(catObjectsRepository.findById(objectsDTO.getCatObjectsId()).orElse(null));
        objects.setDate(objectsDTO.getDate());
        List<Exhibitions> exhibitions = Lists.newArrayList(exhibitionsRepository.findAllById(objectsDTO.getExhibitionIds()));
        objects.setExhibitions(exhibitions);
        return objects;
    }

    public  ObjectsDTO createObjectsDTO(Objects objects){
        ObjectsDTO objectsDTO = new ObjectsDTO();
        objectsDTO.setId(objects.getId());
        objectsDTO.setName(objects.getName());
        objectsDTO.setAuthorId(objects.getAuthor().getId());
        objectsDTO.setCatObjectsId(objects.getCatObject().getId());
        objectsDTO.setDate(objects.getDate());
        objectsDTO.setExhibitionIds(objects.getExhibitions().stream().map(Exhibitions::getId).collect(Collectors.toList()));
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
