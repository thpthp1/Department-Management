package com.example.demomanager.repositories;

import com.example.demomanager.models.Department;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.function.Predicate;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    List<Department> findByLocation(String location);

    List<Department> findByName(String name);

    Department findByNumber(Long number);
}
