package com.museumsgide.demo.service;

import com.museumsgide.demo.dto.MuseumDTO;
import com.museumsgide.demo.mapper.MuseumMapper;
import com.museumsgide.demo.persistece.entity.Museum;
import com.museumsgide.demo.persistece.repository.MuseumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuseumService {
    private MuseumsRepository museumsRepository;
    private MuseumMapper museumMapper;

    @Autowired
    public MuseumService(MuseumsRepository museumsRepository, MuseumMapper museumMapper){
        this.museumsRepository = museumsRepository;
        this.museumMapper = museumMapper;
    }

    public MuseumDTO save(MuseumDTO museumDTO){
        Museum museum = museumMapper.createMuseum(museumDTO);
        museum = museumsRepository.save(museum);
        return museumMapper.createMuseumsDTO(museum);
    }

    public String delete(Long id){
        Museum museum = museumsRepository.findById(id).orElse(null);
        if (museum != null) {
            museumsRepository.delete(museum);
            return "success";
        } else {
            return "failure";
        }
    }

    public MuseumDTO update(MuseumDTO museumDTO){
        if (museumsRepository.existsById(museumDTO.getId())) {
            return save(museumDTO);
        } else {
            return null;
        }
    }

    public List<MuseumDTO> searchByAll(){
        List<Museum> list = museumsRepository.findAll();
        return museumMapper.createMuseumDTOList(list);
    }

    public List<MuseumDTO> searchByName(String name){
        List<Museum> list = museumsRepository.findAllByName(name);
        if (list != null) {
            return museumMapper.createMuseumDTOList(list);
        } else {
            return null;
        }
    }

    public List<MuseumDTO> searchByCityId(Long id){
        List<Museum> list = museumsRepository.findAllByCityId(id);
        if (list != null) {
            return museumMapper.createMuseumDTOList(list);
        } else {
            return null;
        }
    }

    public List<MuseumDTO> searchByCityName(String name){
        List<Museum> list = museumsRepository.findAllByCity_Name(name);
        if (list != null) {
            return museumMapper.createMuseumDTOList(list);
        } else {
            return null;
        }
    }

    public List<MuseumDTO> searchByCatMuseumsId(Long id){
        List<Museum> list = museumsRepository.findAllByCatMuseumsId(id);
        if (list != null) {
            return museumMapper.createMuseumDTOList(list);
        } else {
            return null;
        }
    }
    public List<MuseumDTO>  searchByCatMuseumsName(String name){
        List<Museum> list = museumsRepository.findAllByCatMuseums_Name(name);
        if (list != null) {
            return museumMapper.createMuseumDTOList(list);
        } else {
            return null;
        }
    }

    public List<MuseumDTO>  searchByDescription(String descr){
        List<Museum> list = museumsRepository.findAllByDescriptionContaining(descr);
        if (list != null) {
            return museumMapper.createMuseumDTOList(list);
        } else {
            return null;
        }
    }


    public List<MuseumDTO>  searchByEntrancePriceIsGreaterThan(Long entrancePrice){
        List<Museum> list = museumsRepository.findAllByEntrancePriceIsGreaterThan(entrancePrice);
        if (list != null) {
            return museumMapper.createMuseumDTOList(list);
        } else {
            return null;
        }
    }

    public List<MuseumDTO>  searchByEntrancePriceIsLessThan(Long entrancePrice){
        List<Museum> list = museumsRepository.findAllByEntrancePriceIsLessThan(entrancePrice);
        if (list != null) {
            return museumMapper.createMuseumDTOList(list);
        } else {
            return null;
        }
    }
}

