package com.museumsgide.demo.service;

import com.museumsgide.demo.persistece.entity.Branch;
import com.museumsgide.demo.persistece.entity.Museum;
import com.museumsgide.demo.persistece.repository.BranchRepository;
import com.museumsgide.demo.persistece.repository.MuseumsRepository;
import com.museumsgide.demo.shared.dto.ExhibitionsDTO;
import com.museumsgide.demo.shared.dto.MuseumDTO;
import com.museumsgide.demo.shared.dto.ObjectsDTO;
import com.museumsgide.demo.shared.mapper.ExhibitionsMapper;
import com.museumsgide.demo.shared.mapper.ObjectsMapper;
import com.museumsgide.demo.persistece.entity.Exhibitions;
import com.museumsgide.demo.persistece.entity.Objects;
import com.museumsgide.demo.persistece.repository.ExhibitionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExhibitionsService {
    private ExhibitionsRepository exhibitionsRepository;
    private ExhibitionsMapper exhibitionsMapper;
    private ObjectsMapper objectsMapper;
    private MuseumsRepository museumsRepository;
    private BranchRepository branchRepository;

    @Autowired
    public ExhibitionsService(ExhibitionsRepository exhibitionsRepository, ExhibitionsMapper exhibitionsMapper, ObjectsMapper objectsMapper, MuseumsRepository museumsRepository, BranchRepository branchRepository) {
        this.exhibitionsRepository = exhibitionsRepository;
        this.exhibitionsMapper = exhibitionsMapper;
        this.objectsMapper = objectsMapper;
        this.museumsRepository = museumsRepository;
        this.branchRepository = branchRepository;
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

    public List<ExhibitionsDTO> searchByCatExhibitionsName(String name) {
        List<Exhibitions> list = exhibitionsRepository.findAllByCatExhibitionsName(name);
        if (list != null) {
            return exhibitionsMapper.createExhibitionsDTOList(list);
        } else {
            return null;
        }
    }

    public List<ObjectsDTO> searchObjectsByExhibitionsName(String name){
        List<Exhibitions> list = exhibitionsRepository.findAllByName(name);
        List<Objects> objectsList= null;
        if (list != null) {
            for(Exhibitions exhibitions : list){
                objectsList = exhibitions.getObjects();
            }
            return objectsMapper.createObjectsDTOList(objectsList);
        } else {
            return null;
        }
    }

    public List<ExhibitionsDTO> searchMuseums(Long id){
        Branch branch = branchRepository.findAllByMuseum_Id(id);
        List<Exhibitions> list = exhibitionsRepository.findAllByBranchId(branch.getId());
        if (list != null) {
            return exhibitionsMapper.createExhibitionsDTOList(list);
        } else {
            return null;
        }
    }
}
