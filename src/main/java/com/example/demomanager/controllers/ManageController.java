package com.example.demomanager.controllers;

import com.example.demomanager.models.Department;
import com.example.demomanager.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class ManageController {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/manage")
    public String processFindByName(Department dept, BindingResult result, Map<String, Object> model){
        if(dept.getName() == "" || dept.getName() == null){
            return "manage";
        }
        else{
            List<Department> departments = departmentRepository.findByName(dept.getName());
            if(departments.isEmpty()){
                return "manage";
            }
            else{
                model.put("results", departments);
                return "manageList";
            }
        }
    }

    @GetMapping("manage/add")
    public String initAddPage(Map<String, Object> model){
        model.put("department", new Department());
        return "manageModify";
    }

    @PostMapping("manage/add")
    public String add(@Valid Department department, BindingResult result){
        if(result.hasErrors()){
            return "manageModify";
        }
        else{
            this.departmentRepository.save(department);
            return "redirect:/manage/" + department.getNumber();
        }
    }

    @GetMapping("manage/{deptNumber}/modify")
    public String initUpdatePage(@PathVariable("deptNumber") Long deptNumber, Model model){
        model.addAttribute(departmentRepository.findByNumber(deptNumber));
        return "manageModify";
    }

    @PostMapping("manage/{deptNumber}/modify")
    public String update(@Valid Department department, @PathVariable("deptNumber") Long deptNumber, BindingResult result){
        if(result.hasErrors()){
            return "manageModify";
        }
        else {
            department.setNumber(deptNumber);
            departmentRepository.save(department);
            return "redirect:/manage/" + department.getNumber();
        }
    }

    @GetMapping("manage/{deptNumber}")
    public ModelAndView departmentInfo(@PathVariable("deptNumber") Long deptNumber){
        ModelAndView view = new ModelAndView("deptInfo");
        view.addObject(departmentRepository.findByNumber(deptNumber));
        return view;
    }

    @PostMapping("manage/{deptNumber}")
    public String delete(@PathVariable Long deptNumber){
        this.departmentRepository.deleteById(deptNumber);
        return "redirect:/manage";
    }

}
