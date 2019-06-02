package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.UsersDTO;
import com.museumsgide.demo.persistece.entity.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersMapper {
    public Users createUsers(UsersDTO usersDTO){
        Users users = new Users();
        users.setId(usersDTO.getId());
        users.setName(usersDTO.getName());
        users.setPassword(usersDTO.getPassword());
        users.setEmail(usersDTO.getEmail());
        return users;
    }

    public UsersDTO createUsersDTO(Users users){
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(users.getId());
        usersDTO.setName(users.getName());
        usersDTO.setPassword(users.getPassword());
        usersDTO.setEmail(users.getEmail());
        return usersDTO;
    }

    public List<UsersDTO> createUsersDTOList(List<Users> usersList){
        List<UsersDTO> usersDTOList = new ArrayList<>();
        for(Users users: usersList){
            usersDTOList.add(createUsersDTO(users));
        }
        return usersDTOList;
    }
}
