package com.cybersoft.crm.controllers;

import com.cybersoft.crm.entities.RoleEntity;
import com.cybersoft.crm.services.Imp.RoleServiceImp;
import com.cybersoft.crm.services.Imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        RoleEntity roleEntity = roleServiceImp.getById(id);

        model.addAttribute("roleName", roleEntity.getName());
        model.addAttribute("desc", roleEntity.getDescription());
        model.addAttribute("roleID", roleEntity.getId());
        model.addAttribute("listRole", roleEntities);
        return "change-info";
    }


    @PostMapping("/changeInfo/{id}")
    public String fixRoleProcess(RedirectAttributes redirectAttributes, @PathVariable int id, @RequestParam String desc, @RequestParam String roleName)
    {
        String error = null;
        boolean check = false;
        RoleEntity roleEntity = roleServiceImp.getById(id);
        if(!roleName.equals("") && !desc.equals(""))
        {
            roleEntity.setDescription(desc);
            roleEntity.setName(roleName);
            error = roleServiceImp.save(roleEntity);
        }

        if(error == null)
        {
            check = true;
        }
        redirectAttributes.addFlashAttribute("CHANGE_INFO_MESSAGE", check);
        return "redirect:/role/changeInfo/" + id;
    }

    @GetMapping("/addRole")
    public String addRole()
    {

        return "role-add";
    }

    @PostMapping("/addRole")
    public String addRoleProcess(RedirectAttributes redirectAttributes, @RequestParam String desc, @RequestParam String roleName)
    {
        String check = null;
        RoleEntity newRole = null;
        boolean message = false;

        if(!roleName.equals("") && !desc.equals(""))
        {
            newRole = new RoleEntity(roleName, desc);
            check = roleServiceImp.save(newRole);
        }
        if(check == null)
        {
            message = true;
        }
        redirectAttributes.addFlashAttribute("ADD_ROLE_MESSAGE", message);
        return "redirect:/role/addRole";
    }

    @GetMapping("/deleteRole/{id}")
    public String deleteRoleProcess(@PathVariable int id, RedirectAttributes redirectAttributes)
    {
        String check = null;
        RoleEntity role = roleServiceImp.getById(id);

        if(role != null)
        {
            check = roleServiceImp.delete(role);
        }

        redirectAttributes.addFlashAttribute("DELETE_ROLE_MESSAGE", check);
        return "redirect:/role/table";
    }
}
