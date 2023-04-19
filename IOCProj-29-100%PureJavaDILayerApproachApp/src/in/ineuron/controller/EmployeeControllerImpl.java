package in.ineuron.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.dto.EmployeeDTO;
import in.ineuron.service.IEmployeeService;
import in.ineuron.vo.EmployeeVO;

@Component("controller")
public class EmployeeControllerImpl implements IEmployeeController {
	static {
		System.out.println("EmployeeControllerImpl.class file is loading...");
	}
	public EmployeeControllerImpl() {
		System.out.println("EmployeeControllerImpl object is instantiated:: Zero param constructor");
	}

	@Autowired
	private IEmployeeService service;

	@Override
	public String save(EmployeeVO vo) {

		EmployeeDTO dto = new EmployeeDTO();
		dto.setEaddress(vo.getEaddress());
		dto.setEage(Integer.parseInt(vo.getEage()));
		dto.setEname(vo.getEname());
		return service.save(dto);
	}

	@Override
	public List<EmployeeVO> findAllEmployees() {
		List<EmployeeDTO> employeeDTO = service.findAllEmployees();
		List<EmployeeVO> employeeVo = new ArrayList<EmployeeVO>();
		for (EmployeeDTO dto : employeeDTO) {

			EmployeeVO vo = new EmployeeVO();
			vo.setEname(dto.getEname());
			vo.setEage(String.valueOf(dto.getEage()));
			vo.setEaddress(dto.getEaddress());
			vo.setEid(String.valueOf(dto.getEid()));

			employeeVo.add(vo);
		}

		return employeeVo;
	}

	@Override
	public EmployeeVO findById(Integer eid) {
		service.findById(eid);
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
		return "EmployeeControllerImpl [service=" + service + "]";
	}

}
