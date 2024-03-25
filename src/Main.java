
public class Main {

    // Реализация поля, которое выполняет роль "хранилища" для записей о сотрудниках (массив)
    private static final Employee[] employees = new Employee[10];

    // Переменная отдела (я инициализировал одну переменную для методов решения задач по отделу)
    // Чтобы не вводить ее каждый раз
    private static final int department = 3; // Номер отдела по условиям 1-5

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

        // Вызов метода для индексирования зарплаты (изменение зп у всех сотрудников на величину аргумента в %)
        // percent - устанавливаемый % индексирования
        indexingSalary(10);
        System.out.println();

        // Вызов метода для поиска сотрудника с минимальной ЗП в отделе
        findMinSalaryDepartment();
        System.out.println();

        // Вызов метода для поиска сотрудника с максимальной ЗП в отделе
        findMaxSalaryDepartment();
        System.out.println();

        // Вызов метода для получения суммы затрат на ЗП по отделу
        calculateMonthDepartmentSalary();
        System.out.println();

        // Вызов метода для получения средней суммы затрат на ЗП по отделу
        findAverageDepartmentSalary();
        System.out.println();

        // Вызов метода индексации зарплат всех сотрудников отдела на процент
        // percent - устанавливаемый % индексирования
        indexingDepartmentSalary(20);
        System.out.println();

        // Вызов метода печати всех сотрудников отдела (все данные, кроме отдела)
        printDepartmentEmployees();
        System.out.println();

        // Вызов метода вывода всех сотрудников с ЗП меньше средней
        printBelowAverageEmployees();
        System.out.println();

        // Вызов метода вывода всех сотрудников с ЗП больше или равно средней
        printOverAverageEmployees();
        System.out.println();

        // Вызов метода с числом в качестве параметра и выводом всех сотрудников с ЗП меньше числа
        printBelowIntEmployees(111_100);
        System.out.println();

        // Вызов метода с числом в качестве параметра и выводом всех сотрудников с ЗП больше или равному числу
        printOverIntEmployees(111_100);
        System.out.println();

    }

    // Метод проверки номера отдела для сокращения кода и вывода ошибки
    public static boolean checkDepartment() {
        boolean i = department > 0 && department <= 5;
        if (i) {
        } else {
            throw new IllegalArgumentException("Укажите правильный номер отдела");
        }
        return i;
    }

    // Метод для вывода списка всех сотрудников со всеми имеющимися по ним данными
    public static void printEmployees() {
        System.out.println("Сотрудники всех отделов компании:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // Метод для суммирования ЗП сотрудников
    public static double calculateMonthSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        System.out.println("Сумма затрат компании на ЗП в месяц составляет - " + sum + " рублей");
        return sum;
    }

    // Метод для поиска сотрудника с минимальной ЗП
    public static double findMinSalary() {
        double min = employees[0].getSalary();
        String minSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                minSalaryEmployee = employee.getName();
            }
        }
        System.out.println("Минимальная ЗП у сотрудника компании - " + min + " рублей (" + minSalaryEmployee + ")");
        return min;
    }

    // Метод для поиска сотрудника с максимальной ЗП
    public static double findMaxSalary() {
        double max = employees[0].getSalary();
        String maxSalaryEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                maxSalaryEmployee = employee.getName();
            }
        }
        System.out.println("Максимальная ЗП у сотрудника компании - " + max + " рублей (" + maxSalaryEmployee + ")");
        return max;
    }

    // Метод для подсчета среднего значение зарплат
    public static double findAverageSalary() {
        double average = 0;
        for (Employee employee : employees) {
            average += employee.getSalary();
        }
        average = average / employees.length;
        System.out.println("Среднее значение ЗП в компании составляет - " + average + " рублей");
        return average;
    }

    // Метод для печати ФИО всех сотрудников (метод ничего)
    public static void printEmployeesNames() {
        System.out.println("Сотрудники всех отделов компании пофамильно:");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    // Метод индексирования зарплаты (изменение зп у всех сотрудников на величину аргумента в %)
    public static double indexingSalary(double percent) {
        double indexedSalary = 0;
        System.out.println("Сотрудники всех отделов компании после индексирования зарплаты:");
        for (Employee employee : employees) {
            indexedSalary = employee.getSalary() + employee.getSalary() / 100 * percent;
            employee.setSalary(indexedSalary);
            System.out.println(employee);
        }
        return indexedSalary;
    }

    // Метод получения в качестве параметра номера отдела и поиска сотрудника с минимальной ЗП в нем
    public static double findMinSalaryDepartment() {
        /*
         Сослался на метод поиска максимального значения ЗП findMaxSalary() как максимальное значение ЗП
         (если убрать из метода печать в консоль, то моя логика работает)
         Если есть более правильное решение, то прошу написать для осознания
         */
        double min = findMaxSalary();
        String minSalaryDepartmentEmployee = null;
        if (checkDepartment()) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department && employee.getSalary() < min) {
                    min = employee.getSalary();
                    minSalaryDepartmentEmployee = employee.getName();
                }
            }
            System.out.println("Минимальная ЗП у сотрудника отдела № " + department + " - "
                    + min + " рублей (" + minSalaryDepartmentEmployee + ")");
        }
        return min;
    }

    // Метод получения в качестве параметра номера отдела и поиска сотрудника с максимальной ЗП в нем
    public static double findMaxSalaryDepartment() {
        /*
         По аналогии сослался на метод поиска минимального значения ЗП findMinSalary() как минимального значение ЗП
         (если убрать из метода печать в консоль, то моя логика работает)
         Если есть более правильное решение, то прошу написать для осознания
         */
        double max = findMinSalary();
        String maxSalaryDepartmentEmployee = null;
        if (checkDepartment()) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department && employee.getSalary() > max) {
                    max = employee.getSalary();
                    maxSalaryDepartmentEmployee = employee.getName();
                }
            }
            System.out.println("Максимальная ЗП у сотрудника отдела № " + department + " - "
                    + max + " рублей (" + maxSalaryDepartmentEmployee + ")");
        }
        return max;
    }

    // Метод получения суммы затрат на ЗП по отделу
    public static double calculateMonthDepartmentSalary() {
        double sum = 0;
        if (checkDepartment()) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    sum += employee.getSalary();
                }
            }
            System.out.println("Сумма затрат на ЗП в месяц по отделу № " + department + " составляет - "
                    + String.format("%.2f", sum) + " рублей");
        }
        return sum;
    }

    // Метод вычисления средней ЗП по отделу (учесть, что количество людей в отделе отличается от employees.length)
    public static double findAverageDepartmentSalary() {
        double average = 0;
        int count = 0;
        if (checkDepartment()) {
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    average += employee.getSalary();
                    ++count;
                }
            }
            average = average / count;
            System.out.println("Средняя сумма затрат на ЗП в месяц по отделу № " + department + " составляет - "
                    + String.format("%.2f", average) + " рублей");
        }
        return average;
    }

    // Метод индексации зарплат всех сотрудников отдела на процент, который приходит в качестве параметра
    public static double indexingDepartmentSalary(double percent) {
        double indexedDepartmentSalary = 0;
        if (checkDepartment()) {
            System.out.println("Сотрудники отдела компании № " + department + " после индексирования зарплаты:");
            for (Employee employee : employees) {
                if (checkDepartment() && employee.getDepartment() == department) {
                    indexedDepartmentSalary = employee.getSalary() + employee.getSalary() / 100 * percent;
                    employee.setSalary(indexedDepartmentSalary);
                    System.out.println(employee);
                }
            }
        }
        return indexedDepartmentSalary;
    }

    // Метод печати всех сотрудников отдела (все данные, кроме отдела)
    public static void printDepartmentEmployees() {
        if (checkDepartment()) {
            System.out.println("Сотрудники отдела компании № " + department + " после индексирования зарплаты:");
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    System.out.println(employee.getDataEmployeeWithoutDepartment());
                }
            }
        }
    }

    // Метод вывода всех сотрудников с ЗП меньше средней по компании (распечатать id, фио и зп в консоль)
    public static void printBelowAverageEmployees() {
        System.out.println("Сотрудники компании с ЗП меньше средней после индексирования:");
        double average = findAverageSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < average) {
                System.out.println(employee.getDataEmployeeWithoutDepartment());
            }
        }
    }

    // Метод вывода всех сотрудников с ЗП больше средней по компании (распечатать id, фио и зп в консоль)
    public static void printOverAverageEmployees() {
        System.out.println("Сотрудники компании с ЗП больше средней после индексирования:");
        double average = findAverageSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() >= average) {
                System.out.println(employee.getDataEmployeeWithoutDepartment());
            }
        }
    }

    // Метод с числом в качестве параметра и выводом всех сотрудников с ЗП меньше числа (распечатать id, фио и зп в консоль)
    public static void printBelowIntEmployees(double salary) {
        System.out.println("Сотрудники компании с ЗП меньше " + salary + " рублей после индексирования:");
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println(employee.getDataEmployeeWithoutDepartment());
            }
        }
    }

    // Метод с числом в качестве параметра и выводом всех сотрудников с ЗП больше или равному числу (распечатать id, фио и зп в консоль)
    public static void printOverIntEmployees(double salary) {
        System.out.println("Сотрудники компании с ЗП больше или равно " + salary + " рублей после индексирования:");
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println(employee.getDataEmployeeWithoutDepartment());
            }
        }
    }

}
