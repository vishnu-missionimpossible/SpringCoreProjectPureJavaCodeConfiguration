package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.EmployeeDTO;

public interface IEmployeeService {
	String save(EmployeeDTO vo);

	List<EmployeeDTO> findAllEmployees();

	EmployeeDTO findById(Integer eid);

	String updateById(Integer eid);

	String deleteById(Integer eid);
}
