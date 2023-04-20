package nstarlike.jcm.department.service;

import nstarlike.jcm.department.model.Department;

public interface DepartmentService {
	Department save(Department department);
	Department getById(Long id);
}
