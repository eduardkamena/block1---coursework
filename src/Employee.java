import java.util.Objects;

// Создание класса Employee с информацией о сотрудниках
public class Employee {
    private static int counter = 101; // Добавляем статический счетчик id сотрудника
    private final String lastName; // Фамилия сотрудника
    private final String firstName; // Имя сотрудника
    private final String middleName; // Отчество сотрудника
    private final int id; // id сотрудника
    private int department; // Отделы компании
    private int salary; // Зарплата сотрудника

    // Метод для создания объектов
    public Employee(String lastName, String firstName, String middleName, int department, int salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    // Геттеры
    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getName() {
        return this.lastName + " " + this.firstName + " " + this.middleName;
    }

    public int getId() {
        return id;
    }

    public int getDepartment() {
        return this.department;
    }

    public int getSalary() {
        return this.salary;
    }

    // Сеттеры отдела компании и зарплаты сотрудника
    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Реализация в классе Employee контракты equals, hashCode и toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department
                && salary == employee.salary && Objects.equals(lastName, employee.lastName)
                && Objects.equals(firstName, employee.firstName) && Objects.equals(middleName, employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, id, department, salary);
    }

    @Override
    public String toString() {
        return "Сотрудник: " +
                "Фамилия - " + lastName +
                ", Имя - " + firstName +
                ", Отчество - " + middleName +
                ", id - " + id +
                ", Отдел - " + department +
                ", ЗП - " + salary;
    }

}
