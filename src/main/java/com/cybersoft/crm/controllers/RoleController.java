package com.cybersoft.crm.controllers;

import com.cybersoft.crm.entities.RoleEntity;
import com.cybersoft.crm.services.Imp.RoleServiceImp;
import com.cybersoft.crm.services.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceImp roleServiceImp;

    @Autowired
    private UserServiceImp userServiceImp;



    @GetMapping("/table")
    public String roleTable(Model model)
    {
        List<RoleEntity> roles = roleServiceImp.getAllRoles();

        model.addAttribute("roleList", roles);
        return "role-table";
    }

    @GetMapping("/changeInfo/{id}")
    public String changeInfo(@PathVariable int id, Model model)
    {
        List<RoleEntity> roleEntities = roleServiceImp.getAllRoles();
        RoleEntity roleEntity = userServiceImp.getRoleByIdUser(id);

        model.addAttribute("roleName", roleEntity.getName());
        model.addAttribute("desc", roleEntity.getDescription());
        model.addAttribute("roleID", roleEntity.getId());
        model.addAttribute("listRole", roleEntities);
        return "change-info";
    }
}
