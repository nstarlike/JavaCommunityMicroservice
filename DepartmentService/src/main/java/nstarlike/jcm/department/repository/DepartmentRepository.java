package nstarlike.jcm.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import nstarlike.jcm.department.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
