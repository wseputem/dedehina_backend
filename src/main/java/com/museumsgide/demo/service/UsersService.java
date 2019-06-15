package com.museumsgide.demo.service;

import com.museumsgide.demo.dto.UsersDTO;
import com.museumsgide.demo.mapper.UsersMapper;
import com.museumsgide.demo.persistece.entity.Users;
import com.museumsgide.demo.persistece.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersService {
    private UsersRepository usersRepository;
    private UsersMapper usersMapper;

    @Autowired
    public UsersService(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    public UsersDTO create(UsersDTO usersDTO){
        Users users = usersMapper.createUsers(usersDTO);
        users = usersRepository.save(users);
        return usersMapper.createUsersDTO(users);
    }

    public String delete(Long id){
        Users users = usersRepository.findById(id).orElse(null);
        if (users != null) {
            usersRepository.delete(users);
            return "success";
        } else {
            return "failure";
        }
    }

    public UsersDTO update(UsersDTO usersDTO){
        if (usersRepository.existsById(usersDTO.getId())) {
            return create(usersDTO);
        } else {
            return null;
        }
    }

    public List<UsersDTO> searchByAll(){
        List<Users> list = usersRepository.findAll();
        return usersMapper.createUsersDTOList(list);
    }

    public List<UsersDTO> searchByName(String name){
        List<Users> list = usersRepository.findAllByName(name);
        if (list != null) {
            return usersMapper.createUsersDTOList(list);
        } else {
            return null;
        }
    }

    public Long searchForAut(UsersDTO usersDTO){
        Users users = usersRepository.findByNameAndPassword(usersDTO.getName(), usersDTO.getPassword());
        if (users != null) {
            return usersMapper.createUsersDTO(users).getId();
        } else {
            return null;
        }
    }
}
