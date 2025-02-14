package Collectionandstreams;

public class Employee implements Comparable<Employee>{
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	private int id;
	private String name;
	private int salary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public int compareTo(Employee o) {
		
		int nameCompare = this.name.compareTo(o.name);
		if(nameCompare == 0) {
			return Integer.compare(o.salary, this.salary);
		}
		
		return nameCompare;
	}
	

	
	
}
