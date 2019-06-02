package com.museumsgide.demo.service;

import com.museumsgide.demo.dto.ExhibitionsDTO;
import com.museumsgide.demo.mapper.ExhibitionsMapper;
import com.museumsgide.demo.persistece.entity.CatExhibitions;
import com.museumsgide.demo.persistece.entity.Exhibitions;
import com.museumsgide.demo.persistece.repository.ExhibitionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExhibitionsService {
    ExhibitionsRepository exhibitionsRepository;
    ExhibitionsMapper exhibitionsMapper;

    @Autowired
    public ExhibitionsService(ExhibitionsRepository exhibitionsRepository, ExhibitionsMapper exhibitionsMapper) {
        this.exhibitionsRepository = exhibitionsRepository;
        this.exhibitionsMapper = exhibitionsMapper;
    }

    public ExhibitionsDTO save(ExhibitionsDTO exhibitionsDTO){
        Exhibitions exhibitions = exhibitionsMapper.createExhibitions(exhibitionsDTO);
        exhibitions = exhibitionsRepository.save(exhibitions);
        return exhibitionsMapper.createExhibitionsDTO(exhibitions);
    }

    public String delete(Long id){
        Exhibitions exhibitions = exhibitionsRepository.findById(id).orElse(null);
        if (exhibitions != null) {
            exhibitionsRepository.delete(exhibitions);
            return "success";
        } else {
            return "failure";
        }
    }

    public ExhibitionsDTO update(ExhibitionsDTO exhibitionsDTO){
        if (exhibitionsRepository.existsById(exhibitionsDTO.getId())) {
            return save(exhibitionsDTO);
        } else {
            return null;
        }
    }

    public List<ExhibitionsDTO> searchByAll(){
        List<Exhibitions> list = exhibitionsRepository.findAll();
        return exhibitionsMapper.createExhibitionsDTOList(list);
    }

    public List<ExhibitionsDTO> searchByName(String name){
        List<Exhibitions> list = exhibitionsRepository.findAllByName(name);
        if (list != null) {
            return exhibitionsMapper.createExhibitionsDTOList(list);
        } else {
            return null;
        }
    }

    public List<ExhibitionsDTO> searchByStartDate(Date date){
        List<Exhibitions> list = exhibitionsRepository.findAllByStartDate(date);
        if (list != null) {
            return exhibitionsMapper.createExhibitionsDTOList(list);
        } else {
            return null;
        }
    }

    public List<ExhibitionsDTO> searchByCompletionDate(Date date){
        List<Exhibitions> list = exhibitionsRepository.findAllByCompletionDate(date);
        if (list != null) {
            return exhibitionsMapper.createExhibitionsDTOList(list);
        } else {
            return null;
        }
    }

    public List<ExhibitionsDTO> searchByBranchId(Long id){
        List<Exhibitions> list = exhibitionsRepository.findAllByBranchId(id);
        if (list != null) {
            return exhibitionsMapper.createExhibitionsDTOList(list);
        } else {
            return null;
        }
    }

    public List<ExhibitionsDTO> searchByCatExhibitionsId(Long id){
        List<Exhibitions> list = exhibitionsRepository.findAllByCatExhibitionsId(id);
        if (list != null) {
            return exhibitionsMapper.createExhibitionsDTOList(list);
        } else {
            return null;
        }
    }

    public List<ExhibitionsDTO> searchByCatExhibitionsName(String name){
        List<Exhibitions> list = exhibitionsRepository.findAllByCatExhibitionsName(name);
        if (list != null) {
            return exhibitionsMapper.createExhibitionsDTOList(list);
        } else {
            return null;
        }
    }
}
