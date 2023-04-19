package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.EmployeeBO;
import in.ineuron.dao.IEmployeeDao;
import in.ineuron.dto.EmployeeDTO;

@Service("service")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;

	@Override
	public String save(EmployeeDTO dto) {

		EmployeeBO bo = new EmployeeBO();
		bo.setEname(dto.getEname());
		bo.setEage(dto.getEage());
		bo.setEaddress(dto.getEaddress());

		return dao.save(bo);
	}

	@Override
	public List<EmployeeDTO> findAllEmployees() {
		List<EmployeeBO> employeesBO = dao.findAllEmployees();
		List<EmployeeDTO> employeeDTO = new ArrayList<EmployeeDTO>();
		for (EmployeeBO bo : employeesBO) {

			EmployeeDTO dto = new EmployeeDTO();
			dto.setEid(bo.getEid());
			dto.setEname(bo.getEname());
			dto.setEage(bo.getEage());
			dto.setEaddress(bo.getEaddress());

			employeeDTO.add(dto);
		}
		return employeeDTO;
	}

	@Override
	public EmployeeDTO findById(Integer eid) {
		dao.findById(eid);
		return null;
	}

	@Override
	public String updateById(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "EmployeeServiceImpl [dao=" + dao + "]";
	}

}
