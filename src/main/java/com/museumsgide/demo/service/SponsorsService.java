package com.museumsgide.demo.service;

import com.museumsgide.demo.shared.dto.SponsorsDTO;
import com.museumsgide.demo.shared.mapper.SponsorsMapper;
import com.museumsgide.demo.persistece.entity.Sponsors;
import com.museumsgide.demo.persistece.repository.SponsorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorsService {
    private SponsorsMapper sponsorsMapper;
    private SponsorsRepository sponsorsRepository;

    @Autowired
    public SponsorsService(SponsorsMapper sponsorsMapper, SponsorsRepository sponsorsRepository) {
        this.sponsorsMapper = sponsorsMapper;
        this.sponsorsRepository = sponsorsRepository;
    }

    public SponsorsDTO save(SponsorsDTO sponsorsDTO){
        Sponsors sponsors = sponsorsMapper.createSponsors(sponsorsDTO);
        sponsors = sponsorsRepository.save(sponsors);
        return sponsorsMapper.createSponsorsDTO(sponsors);
    }

    public String delete(Long id){
        Sponsors sponsors = sponsorsRepository.findById(id).orElse(null);
        if (sponsors != null) {
            sponsorsRepository.delete(sponsors);
            return "success";
        } else {
            return "failure";
        }
    }

    public SponsorsDTO update(SponsorsDTO sponsorsDTO){
        if (sponsorsRepository.existsById(sponsorsDTO.getId())) {
            return save(sponsorsDTO);
        } else {
            return null;
        }
    }


    public List<SponsorsDTO> searchByAll(){
        List<Sponsors> list = sponsorsRepository.findAll();
        return sponsorsMapper.createSponsorsDTOList(list);
    }
}
