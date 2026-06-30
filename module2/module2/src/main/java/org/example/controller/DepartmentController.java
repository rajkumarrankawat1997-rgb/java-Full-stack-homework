package org.example.controller;

import jakarta.validation.Valid;
import org.example.entity.Department;
import org.example.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        return  ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department){
        Department created = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id,@Valid @RequestBody Department department){
        Department updated = departmentService.updateDepartment(id, department);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping
    public ResponseEntity<Department> deleteDepartment(@PathVariable Long id){
        departmentService.getDepartmentById(id);
        return ResponseEntity.noContent().build();
    }

}
