package visitor;

public class Employee {
	int sickDays, vacDays;
	float salary;
	String Name;

	public Employee(String name, float salary, int vacdays, int sickdays) {
		this.vacDays = vacdays;
		this.sickDays = sickdays;
		this.salary = salary;
		this.Name = name;
	}

	public String getName() {
		return Name;
	}

	public int getSickdays() {
		return sickDays;
	}

	public int getVacDays() {
		return vacDays;
	}

	public float getSalary() {
		return salary;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}
}
