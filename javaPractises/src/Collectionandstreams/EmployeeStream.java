package Collectionandstreams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStream {

    public static void main(String args[]) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Prathamesh", 45000));
        employeeList.add(new Employee(2, "pratik", 50000));
        employeeList.add(new Employee(3, "Piyush", 12000));
        employeeList.add(new Employee(4, "Aditya", 24000));
        employeeList.add(new Employee(5, "Nishank", 21000));
        employeeList.add(new Employee(6, "Nishank", 37000));

        List<Employee> filterEmployees = employeeList.stream()
                .filter((e) -> e.getSalary() < 25000)
                .map((e) -> new Employee(e.getId(), e.getName(), e.getSalary()+ e.getSalary() / 100 * 25))
                .collect(Collectors.toList());

        for (Employee employee : filterEmployees) {
            System.out.println("Employee id :"+employee.getId()+"\t Emp Name :"+ employee.getName() + "\t salary :"+ employee.getSalary());
        }
        
        Calculator subCalculator = (a, b) ->{
        	if(a<b) {
        		throw new RuntimeException("first value not greater than second value");
        	}else {
        		return a - b;
        	}
        	
        };
        
        System.out.println(subCalculator.subtract(8, 5));
        
        Collections.sort(employeeList);
        
        System.out.println(employeeList);
        
       
    }
}

class EmployeeNameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		int namecompare =  o2.getName().compareTo(o1.getName());
		
		if(namecompare == 0) {
			return Integer.compare(o2.getId(), o1.getId());
		}
		
		return namecompare;
	}
	
}


