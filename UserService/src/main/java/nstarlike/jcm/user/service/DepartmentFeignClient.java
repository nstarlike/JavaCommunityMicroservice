package nstarlike.jcm.user.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

import nstarlike.jcm.user.dto.DepartmentDto;

@FeignClient(value="department-service", url="http://localhost:8081")
public interface DepartmentFeignClient {
	@GetMapping(value="/api/departments/{id}")
	DepartmentDto getById(@PathVariable("id") Long id);
}
