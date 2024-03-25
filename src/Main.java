public class Main {

    // Реализация поля, которое выполняет роль "хранилища" для записей о сотрудниках (массив)
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        // Наполнение массива данными о сотрудниках
        employees[0] = new Employee("Егорова", "Арина", "Юрьевна", 1, 110000);
        employees[1] = new Employee("Васильев", "Андрей", "Иванович", 2, 134000);
        employees[2] = new Employee("Егоров", "Александр", "Романович", 3, 123000);
        employees[3] = new Employee("Ерохин", "Сергей", "Николаевич", 5, 160000);
        employees[4] = new Employee("Рудь", "Ирина", "Сергеевна", 4, 113000);
        employees[5] = new Employee("Морозова", "Марина", "Александровна", 5, 99000);
        employees[6] = new Employee("Боголюбов", "Валерий", "Сергеевич", 2, 87000);
        employees[7] = new Employee("Лаврентьев", "Михаил", "Михайлович", 3, 143000);
        employees[8] = new Employee("Пакуличев", "Дмитрий", "Юрьевич", 1, 136000);
        employees[9] = new Employee("Симонян", "Карина", "Денисовна", 4, 101000);

        // Вызов метода для печати всех сотрудников со всеми свойствами
        printEmployees();
        System.out.println();

        // Вызов метода для суммирования ЗП сотрудников
        calculateMonthSalary();
        System.out.println();

        // Вызов метода для поиска сотрудника с минимальной ЗП
        findMinSalary();
        System.out.println();

        // Вызов метода для поиска сотрудника с максимальной ЗП
        findMaxSalary();
        System.out.println();

        // Вызов метода для подсчета среднего значение зарплат
        findAverageSalary();
        System.out.println();

        // Вызов метода для печати ФИО всех сотрудников (метод ничего)
        printEmployeesNames();
        System.out.println();
    }

    // Метод для вывода списка всех сотрудников со всеми имеющимися по ним данными
    public static void printEmployees() {
        System.out.println("Сотрудники всех отделов:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // Метод для суммирования ЗП сотрудников
    public static int calculateMonthSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        System.out.println("Сумма затрат на ЗП в месяц составляет - " + sum + " рублей");
        return sum;
    }

    // Метод для поиска сотрудника с минимальной ЗП
    public static int findMinSalary() {
        int min = employees[0].getSalary();
        String minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                minSalaryEmployee = employee.getName();
            }
        }
        System.out.println("Минимальная ЗП у сотрудника - " + min + " рублей (" + minSalaryEmployee + ")");
        return min;
    }

    // Метод для поиска сотрудника с максимальной ЗП
    public static int findMaxSalary() {
        int max = employees[0].getSalary();
        String maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                maxSalaryEmployee = employee.getName();
            }
        }
        System.out.println("Минимальная ЗП у сотрудника - " + max + " рублей (" + maxSalaryEmployee + ")");
        return max;
    }

    // Метод для подсчета среднего значение зарплат
    public static int findAverageSalary() {
        int average = 0;
        for (Employee employee : employees) {
            average += employee.getSalary();
        }
        average = average / employees.length;
        System.out.println("Среднее значение ЗП составляет - " + average + " рублей");
        return average;
    }

    // Метод для печати ФИО всех сотрудников (метод ничего)
    public static void printEmployeesNames() {
        System.out.println("Сотрудники всех отделов пофамильно:");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

    }

}