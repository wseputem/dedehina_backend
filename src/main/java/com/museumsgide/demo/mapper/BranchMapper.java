package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.BranchDTO;
import com.museumsgide.demo.persistece.entity.Branch;
import com.museumsgide.demo.persistece.repository.MuseumsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper {
    private MuseumsRepository museumsRepository;

    @Autowired
    public BranchMapper(MuseumsRepository museumsRepository) {
        this.museumsRepository = museumsRepository;
    }

    public Branch createBranch(BranchDTO branchDTO){
        Branch branch = new Branch();
        branch.setId(branchDTO.getId());
        branch.setName(branchDTO.getName());
        branch.setMuseum(museumsRepository.findById(branchDTO.getMuseumId()).orElse(null));
        return branch;
    }

    public BranchDTO createBranchDTO(Branch branch){
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setId(branch.getId());
        branchDTO.setName(branch.getName());
        branchDTO.setMuseumId(branch.getMuseum().getId());
        return branchDTO;
    }
}
