package nstarlike.jcm.department.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

import nstarlike.jcm.department.model.Department;
import nstarlike.jcm.department.service.DepartmentService;

@RestController
@RequestMapping("api/department")
@AllArgsConstructor
public class DepartmentController {
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<Department> save(@RequestBody Department department){
		Department savedDepartment = departmentService.save(department);
		return new ResponseEntity<Department>(savedDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Department> getById(@PathVariable("id") Long id){
		Department department = departmentService.getById(id);
		return ResponseEntity.ok(department);
	}
}
