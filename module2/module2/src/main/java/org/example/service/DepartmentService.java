package org.example.service;

import org.example.entity.Department;
import org.example.exception.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DepartmentService {

    private final List<Department> departments = new java.util.ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Department> getAllDepartments(){
        return departments;
    }

    public Department getDepartmentById(Long id){
        return departments.stream()
                .filter(d-> d.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new DepartmentNotFoundException("Department not found with id: " + id));

    }

    public Department createDepartment(Department department) {
        department.setId(idCounter.getAndIncrement());
        department.setCreatedAt(LocalDateTime.now());
        departments.add(department);
        return department;
    }

    public Department updateDepartment(Long id, Department updatedDept){
        Department existing = getDepartmentById(id);
        existing.setTitle(updatedDept.getTitle());
        existing.setActive(updatedDept.isActive());
        return  existing;
    }

    public void DeleteDepartment(Long id){
        Department existing = getDepartmentById(id);
        departments.remove(existing);
    }
}
