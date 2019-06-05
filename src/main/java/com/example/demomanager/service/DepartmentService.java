package com.example.demomanager.service;

import com.example.demomanager.models.Department;
import com.example.demomanager.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    //create
    public void add(Department department){
        Objects.requireNonNull(department);
        departmentRepository.save(department);
    }

    //delete
    public void remove(Department department){
        departmentRepository.delete(department);
    }

    //delete
    public void removeByNumber(long number){
        departmentRepository.deleteById(number);
    }

    //read
    public List<Department> findByName(String name){
        return departmentRepository.findByName(name.toUpperCase());
    }

    //read
    public List<Department> findByLocation(String location){
        return departmentRepository.findByLocation(location.toUpperCase());
    }

    //read
    public Optional<Department> findByNumber(long number){
        return departmentRepository.findById(number);
    }

    //update
    public boolean update(Department department) {
        Objects.requireNonNull(department);
        if (departmentRepository.existsById(department.getNumber())) {
            departmentRepository.save(department);
            return true;
        }
        else return false;
    }
}
