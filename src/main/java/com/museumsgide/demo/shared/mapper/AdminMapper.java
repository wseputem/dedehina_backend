package com.museumsgide.demo.shared.mapper;

import com.museumsgide.demo.shared.dto.AdminDTO;
import com.museumsgide.demo.persistece.entity.Admin;
import com.museumsgide.demo.persistece.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminMapper {
    private UsersRepository usersRepository;

    @Autowired
    public AdminMapper(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Admin creatAuthor(AdminDTO adminDTO){
        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        admin.setUsers(usersRepository.findAllById(adminDTO.getUsersId()));
        return admin;
    }

    public AdminDTO createAuthorDTO(Admin admin){
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setUsersId(admin.getUsers().getId());
        return adminDTO;
    }

    public List<AdminDTO> createAdminDTOList(List<Admin> admins){
        List<AdminDTO> adminDTOS= new ArrayList<>();
        for (Admin admin : admins){
            adminDTOS.add(createAuthorDTO(admin));
        }
        return adminDTOS;
    }

}
