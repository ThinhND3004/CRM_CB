package com.cybersoft.crm.services;

import com.cybersoft.crm.dto.UserDTO;
import com.cybersoft.crm.entities.RoleEntity;
import com.cybersoft.crm.entities.UserEntity;
import com.cybersoft.crm.responsitory.RoleRepository;
import com.cybersoft.crm.responsitory.UserResponsitory;
import com.cybersoft.crm.services.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserService implements UserServiceImp {

    private static final int ROLE_USER_ID = 3;

    @Autowired
    private UserResponsitory userResponsitory;

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public RoleEntity getRoleByIdUser(int id) {
        UserEntity user = userResponsitory.getById(id);

        RoleEntity roleOfUser = user.getRoleEntity();

        return roleOfUser;
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        UserEntity user =  userResponsitory.getByEmail(email);
        return user;
    }

    @Override
    public List<UserEntity> getAllUser() {

        List<UserEntity> userEntities = userResponsitory.findAll();

        return userEntities;
    }

    @Override
    public String checkRegister(UserDTO userDTO) {
        String result = "";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        String fullNameRegex = "^[a-zA-Z\\s]{1,30}$";

        if(!Pattern.matches(emailRegex, userDTO.getEmail()))
        {
            result = "Invalid Email!";
        } else if (!Pattern.matches(fullNameRegex, userDTO.getFullName())) {
            result = "Invalid Fullname!";
        } else if (userDTO.getPassword().length() > 30) {
            result = "Invalid Password!";
        }
        return result;
    }

    @Override
    public boolean save(UserEntity user) {
        boolean check = false;
        UserEntity userEntity = userResponsitory.save(user);

        if(userEntity != null)
        {
            check = true;
        }

        return check;
    }

    @Override
    public boolean saveNewUserToDB(UserDTO userDTO)
    {
        boolean check = false;

        UserEntity user = new UserEntity();
        RoleEntity role = null;

        try {
            role = roleRepository.getById(ROLE_USER_ID);

            user.setEmail(userDTO.getEmail());
            user.setFullname(userDTO.getFullName());
            user.setPassword(userDTO.getPassword());
            user.setRoleEntity(role);

            save(user);

            check = true;
        } catch (Exception e)
        {
            System.out.println("ERROR: " + e.toString());
        }

        return check;
    }

}
