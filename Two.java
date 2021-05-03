package home.work;

import java.util.Random;

public class Two {
    private static final int EMPLOYEE_COUNT = 5;
    private static final int MIN_AGE = 40;
    private static final Random ageRandomize = new Random();

    public static void  main(String[] args) {
        Employee[] employees = new Employee[EMPLOYEE_COUNT];
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            employees[i] = addEmployee(i);
        }

        for (Employee employee : employees) {
            if (employee.getAge() > MIN_AGE) {
                employee.printinfo();
            }
        }
    }

    private static Employee addEmployee(int i) {
        return new Employee("name" + i, "surname" + i, "two" + i + "@mail.com", "+9999999999" + i, "Manager lvl " + i, ageRandomize.nextInt(25) + 25, 2000 * i * 100);
    }
}
