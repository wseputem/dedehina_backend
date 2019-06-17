package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.SponsorsDTO;
import com.museumsgide.demo.persistece.entity.Exhibitions;
import com.museumsgide.demo.persistece.entity.Sponsors;
import com.museumsgide.demo.persistece.repository.ExhibitionsRepository;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SponsorsMapper {
    private ExhibitionsRepository exhibitionsRepository;

    @Autowired
    public SponsorsMapper(ExhibitionsRepository exhibitionsRepository) {
        this.exhibitionsRepository = exhibitionsRepository;
    }

    public Sponsors createSponsors(SponsorsDTO sponsorsDTO){
       Sponsors sponsors = new Sponsors();
       sponsors.setId(sponsorsDTO.getId());
       sponsors.setName(sponsorsDTO.getName());
       List<Exhibitions> exhibitions = Lists.newArrayList(exhibitionsRepository.findAllById(sponsorsDTO.getExhibitionIds()));
       sponsors.setExhibitions(exhibitions);
       return sponsors;
    }

    public SponsorsDTO createSponsorsDTO (Sponsors sponsors){
        SponsorsDTO sponsorsDTO = new SponsorsDTO();
        sponsorsDTO.setId(sponsors.getId());
        sponsorsDTO.setName(sponsors.getName());
        sponsorsDTO.setExhibitionIds(sponsors.getExhibitions().stream().map(Exhibitions::getId).collect(Collectors.toList()));
        return sponsorsDTO;
    }
    public List<SponsorsDTO> createSponsorsDTOList(List<Sponsors> sponsorsList){
        List<SponsorsDTO> sponsorsDTOS = new ArrayList<>();
        for (Sponsors sponsors : sponsorsList){
            sponsorsDTOS.add(createSponsorsDTO(sponsors));
        }
        return sponsorsDTOS;
    }
}
