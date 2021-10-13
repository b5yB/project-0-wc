package com.project0.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.project0.dao.EmployeeDao;
import com.project0.dao.UserDao;
import com.project0.exceptions.InvalidCredentialsException;
import com.project0.exceptions.UsernameAlreadyExistsException;
import com.project0.logging.Logging;
import com.project0.models.Application;
import com.project0.models.Employee;
import com.project0.models.User;

public class EmployeeService {
	
	private EmployeeDao eDao;
	
	public EmployeeService(EmployeeDao e) {
		this.eDao = e;
	}
	
	public Employee signIn(String username, String password) throws InvalidCredentialsException{
		
		Employee e = eDao.getEmployeeByUsername(username);
		
		if(!e.getPassword().equals(password)) {
			Logging.logger.warn("Employee tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("Employee was logged in");
			return e;
		}
		
	}
	
	public void employeeDashboard() {
		
	}
	
	public void adminDashboard() {
		
		boolean done = false;
		
		while (done != true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please press '1' to view applications, '2' to access users, or '3' to logout."); 
			int choice = Integer.parseInt(scan.nextLine());
			if (choice == 1) {
				
				List<Application> appList = eDao.getApplications();
				for(Application apps: appList) {
					System.out.println(apps);
				}
				System.out.println("Please press '1' to approve applications, '2' to deny applications, or '3' to return");
				int choice2 = Integer.parseInt(scan.nextLine());
				if (choice2 == 1) {
					System.out.println("Please enter the Application number of the applicant you would like to approve.");
					int appnum = Integer.parseInt(scan.nextLine());
					System.out.println("Please enter the applicant username.");
					String username = scan.nextLine();
					System.out.println("Please enter your Banker ID");
					int bankerid = Integer.parseInt(scan.nextLine());
					
					
					try {
						eDao.approveApplication(appnum, username, bankerid);
						System.out.println("Application approved!");
						continue;
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				else if (choice2 ==2) {
					continue;
				}
				else {
					continue;
				}
				
			}
			else if (choice == 2) {
				continue;
			}
			else {
				Logging.logger.info("Admin was logged out");
				System.out.println("Goodbye");
				done = true;
				
			}
		scan.close();
		}
	}
	
}
