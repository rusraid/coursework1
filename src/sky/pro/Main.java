package sky.pro;

public class Main {

	private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {



		addEmployee(new Employee("Ivan1", "Ivanov1", "Ivanovich1", 1, 60000));
		addEmployee(new Employee("Ivan2", "Ivanov2", "Ivanovich2", 2, 70000));
		addEmployee(new Employee("Ivan3", "Ivanov3", "Ivanovich3", 3, 80000));
		addEmployee(new Employee("Ivan4", "Ivanov4", "Ivanovich4", 4, 90000));
		addEmployee(new Employee("Ivan5", "Ivanov5", "Ivanovich5", 5, 50000));

		printEmployees();
		System.out.println("Сумма затрат на зарплаты в месяц: " + calculateTotalSalaryPerMonth() + " рублей");
		System.out.println("Cотрудник с минимальной зарплатой: " + findEmployeeWithMinSalary());
		System.out.println("Cотрудник с максимальной зарплатой: " + findEmployeeWithMaxSalary());
		System.out.println("Cреднее значение зарплат: " + averageValueOfSalary() + " рублей");
		printFullNames();
	}


	public static void printEmployees() {
		for (Employee employee : employees) {
			if (employee != null) {
				System.out.println(employee);
			}
		}
	}

	public static int calculateTotalSalaryPerMonth() {

		int sum = 0;
		for (Employee employee : employees) {
			if (employee != null) {
				sum = sum + employee.getSalary();
			}
		}
		return sum;
	}

	public static Employee findEmployeeWithMinSalary() {

		Employee result = null;
		int minSalary = Integer.MAX_VALUE;
		for (Employee employee : employees) {
			if (employee != null && employee.getSalary() < minSalary) {
				minSalary = employee.getSalary();
				result = employee;
			}
		}
		return result;
	}

	public static Employee findEmployeeWithMaxSalary() {
		Employee result = null;
		int maxSalary = Integer.MIN_VALUE;

		for (Employee employee : employees) {
			if (employee != null && employee.getSalary() > maxSalary) {
				maxSalary = employee.getSalary();
				result = employee;
			}
		}
		return result;
	}

	public static float averageValueOfSalary() {
		int employeeCount = 0;
		for (Employee employee: employees) {
			if (employee != null) {
				employeeCount++;
			}
		}
		return (float) calculateTotalSalaryPerMonth() / employeeCount;
	}

	public static void printFullNames() {
		System.out.println("Ф. И. О. всех сотрудников: ");
		for (Employee employee : employees) {
			if (employee != null) {
				System.out.println(employee.getFullName());
			}
		}
	}

	private static boolean addEmployee(Employee newEmployee) {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] == null) {
				employees[i] = newEmployee;
				return true;
			}
		}
		return false;
	}
}
