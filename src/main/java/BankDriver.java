import java.util.Scanner;

import com.project0.dao.EmployeeDao;
import com.project0.dao.EmployeeDaoDB;
import com.project0.dao.UserDao;
import com.project0.dao.UserDaoDB;
import com.project0.services.EmployeeService;
import com.project0.services.UserService;
import com.project0.models.Application;
import com.project0.models.Employee;
import com.project0.models.User;

public class BankDriver {
	
	private static UserDao uDao = new UserDaoDB();
	private static UserService uServ = new UserService(uDao);
	private static EmployeeDao eDao = new EmployeeDaoDB();
	private static EmployeeService eServ = new EmployeeService(eDao);

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		User u = null;
		Employee employee = null;
		Application a = new Application();
		
		Boolean done = false;
		
		/*employee = eDao.getEmployeeByUsername("test1");
		System.out.println(employee);*/
		
		while (!done) {
			
		System.out.println("Welcome! Please press '1' for customer login, or '2' for employee login.");
		int prechoice = Integer.parseInt(scan.nextLine());
			
			if (prechoice == 1) {
			
				if(u == null) {
					System.out.println("Please press '1' to login, or '2' to apply.");
					int choice = Integer.parseInt(scan.nextLine());
					if(choice == 1) {
						System.out.print("Please enter your username: ");
						String username = scan.nextLine();
						System.out.print("Please enter you password: ");
						String password = scan.nextLine();
						
						try {
							u = uServ.signIn(username, password);
							System.out.println("Welcome back, " + u.getUsername());
							uServ.userDashboard();
							done = true;
						} 
						
						catch(Exception e) {
							System.out.println("Username or password was incorrect, please try again.");
						}
					} 
					
					else {
						System.out.print("Please enter your user name: ");
						String username = scan.nextLine();
						System.out.print("Please enter your password: ");
						String password = scan.nextLine();
						System.out.print("Please enter you first name: ");
						String firstN = scan.nextLine();
						System.out.print("Please enter you last name: ");
						String lastN = scan.nextLine();
						System.out.print("Please enter you ssn: ");
						int ssn = Integer.parseInt(scan.nextLine());
						System.out.print("Please enter you email: ");
						String email = scan.nextLine();
						
						try { 
							uServ.apply(username, password, firstN, lastN, ssn, email);
							System.out.println("Thank you for applying! You can expect our decision via email within 24 hours. ");
							done = true;
						}
						
						catch(Exception e) {
							e.printStackTrace();
							System.out.println("Sorry, that username is already taken. Please try again");
						}
					}
				}
			}
			else if (prechoice == 2) {
					
				System.out.print("Please enter your username: ");
				String username = scan.nextLine();
				System.out.print("Please enter you password: ");
				String password = scan.nextLine();
					
				try {
					employee = eServ.signIn(username, password);
					System.out.println("Welcome back, " + employee.getUsername());
					int admin = employee.getAdminid();
					if (admin != 0) {
						eServ.adminDashboard();
						done = true;
					}
					else {
						eServ.employeeDashboard();
						done = true;
					}	
				}
				catch(Exception e) {
					System.out.println("Username or password was incorrect, please try again.");
				}
			}
		}
		scan.close();
	}
}
	

