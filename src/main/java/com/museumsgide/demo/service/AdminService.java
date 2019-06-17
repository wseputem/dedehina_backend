package com.museumsgide.demo.service;

import com.museumsgide.demo.persistece.entity.Users;
import com.museumsgide.demo.persistece.repository.UsersRepository;
import com.museumsgide.demo.shared.dto.AdminDTO;
import com.museumsgide.demo.shared.dto.UsersDTO;
import com.museumsgide.demo.shared.mapper.AdminMapper;
import com.museumsgide.demo.persistece.entity.Admin;
import com.museumsgide.demo.persistece.repository.AdminRepository;
import com.museumsgide.demo.shared.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private UsersMapper usersMapper;
    private UsersRepository usersRepository;
    private AdminMapper adminMapper;
    private AdminRepository adminRepository;

    @Autowired
    public AdminService(UsersMapper usersMapper, UsersRepository usersRepository, AdminMapper adminMapper, AdminRepository adminRepository) {
        this.usersMapper = usersMapper;
        this.usersRepository = usersRepository;
        this.adminMapper = adminMapper;
        this.adminRepository = adminRepository;
    }

    public AdminDTO save(AdminDTO adminDTO){
        Admin admin = adminMapper.creatAdmin(adminDTO);
        admin = adminRepository.save(admin);
        return adminMapper.createAdminDTO(admin);
    }

    public String delete(Long id){
        Admin objects = adminRepository.findById(id).orElse(null);
        if (objects != null) {
            adminRepository.delete(objects);
            return "success";
        } else {
            return "failure";
        }
    }

    public AdminDTO update(AdminDTO adminDTO){
        if (adminRepository.existsById(adminDTO.getId())) {
            return save(adminDTO);
        } else {
            return null;
        }
    }

    public List<AdminDTO> searchByAll(){
        List<Admin> list = adminRepository.findAll();
        return adminMapper.createAdminDTOList(list);
    }

    public UsersDTO check(Long id){
        Admin admin = adminRepository.findAllByUsers_Id(id);
        Users users = usersRepository.findAllById(admin.getUsers().getId());
        if (users != null) {
            return usersMapper.createUsersDTO(users);
        } else {
            return null;
        }
    }
}
