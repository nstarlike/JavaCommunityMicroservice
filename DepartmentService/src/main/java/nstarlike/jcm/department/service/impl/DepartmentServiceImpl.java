package nstarlike.jcm.department.service.impl;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import nstarlike.jcm.department.model.Department;
import nstarlike.jcm.department.repository.DepartmentRepository;
import nstarlike.jcm.department.service.DepartmentService;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentRepository repository;
	
	@Override
	public Department save(Department department) {
		return repository.save(department);
	}

	@Override
	public Department getById(Long id) {
		return repository.findById(id).get();
	}

}
