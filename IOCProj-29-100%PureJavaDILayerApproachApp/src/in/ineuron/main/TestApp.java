package in.ineuron.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.cfg.AppConfig;
import in.ineuron.controller.IEmployeeController;
import in.ineuron.vo.EmployeeVO;

public class TestApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		IEmployeeController controller = null;
		controller = factory.getBean("controller", IEmployeeController.class);

		int choice = 0;
		String ename = null, eage = null, eaddress = null;
		List<EmployeeVO> employees = null;
		Scanner scanner = new Scanner(System.in);
		try {
			while (true) {
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. READALLRECORDS");
				System.out.println("4. UPDATERECORD");
				System.out.println("5. DELETERECORD");
				System.out.println("6. EXIT");
				System.out.print("Enter ur choice:: ");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					System.out.print("Enter the EmployeeName :: ");
					ename = scanner.next();

					System.out.print("Enter the EmployeeAge :: ");
					eage = scanner.next();

					System.out.print("Enter the EmployeeAddress :: ");
					eaddress = scanner.next();

					EmployeeVO employeeVO = new EmployeeVO();
					employeeVO.setEname(ename);
					employeeVO.setEaddress(eaddress);
					employeeVO.setEage(eage);

					String status = controller.save(employeeVO);
					System.out.println(status);
					break;
					
				case 2:
					break;
					
				case 3:
					employees = controller.findAllEmployees();
					employees.forEach(System.out::println);
					break;
				case 4:
					break;
				case 5:
					
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice.. Try agin with valid inputs[1,2,3,4,5,6");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			((AbstractApplicationContext)factory).close();
			scanner.close();
		}
	  
	}
}
