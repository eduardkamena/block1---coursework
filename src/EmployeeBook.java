public class EmployeeBook {
    private final Employee[] employees; // Объявление массива для записей о сотрудниках

    // Переменная отдела (я инициализировал одну переменную для методов решения задач по отделу)
    // Чтобы не вводить ее каждый раз
    public int department; // Номер отдела (значение присваивается в main)

    public String name; // Переменная для метода поиска по ФИО

    public EmployeeBook() {
        this.employees = new Employee[10]; // Длина массива — 10

        // Наполнение массива данными сотрудников компании
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
    }

    // Методы для управления внутренним массивом по работе с сотрудниками

    // Метод для поиска сотрудника по id
    public void findEmployeeId(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("Найден сотрудник по id - {" + employee + "}");
                return;
            }
        }
        System.out.println("Сотрудник по id {" + id + "} не найден (укажите существующий id)");
    }

    // Метод для поиска сотрудника по ФИО (указать полное ФИО)
    public void findEmployeeName() {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                System.out.println("Найден сотрудник по ФИО - {" + employee + "}");
                return;
            }
        }
        System.out.println("Сотрудник {" + name + "} не найден (укажите полное ФИО)");
    }

    // Метод изменения данных сотрудника после поиска по ФИО
    public void changeEmployeeData(int newDepartment, double newSalary) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && newDepartment > 0 && newDepartment <= 5) {
                employee.setDepartment(newDepartment);
                employee.setSalary(newSalary);
                System.out.println("Данные о сотруднике изменены!");
                System.out.println("Переведен в отдел {" + newDepartment + "} и назначена новая ЗП {" + newSalary + "}");
                return;
            }
        }
        throw new IllegalArgumentException("Укажите правильный номер отдела для перевода сотрудника (1-5)");
    }

    // Метод удаления сотрудника по id из базы
    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                System.out.println("Удаленный сотрудник по id - {" + employees[i] + "}");
                employees[i] = null;
                return;
            }
        }
        System.out.println("Невозможно удалить сотрудника по id {" + id + "} (укажите существующий id)");
    }

    // Метод проверки свободной ячейки для записи сотрудника и вывода результата (true/false) в консоль
    public boolean checkAddEmployeeTrue() {
        for (Employee employee : employees) {
            if (employee == null) return true;
        }
        return false;
    }

    // Метод записи нового сотрудника, если ячейка свободна (с поиском сначала массива)
    public void addEmployee(String lastName, String firstName, String middleName, int department, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                Employee newEmployee = new Employee(lastName, firstName, middleName, department, salary);
                employees[i] = newEmployee;
                System.out.println("Записан новый сотрудник - {" + newEmployee + "} - в ячейку массива - " + i);
                return;
            }
        }
        System.out.println("Чтобы записать нового сотрудника, сначала удалите старого");
    }


    // Методы по работе с сотрудниками компании

    // Метод для вывода списка всех сотрудников со всеми имеющимися по ним данными
    public void printEmployees() {
        System.out.println("Сотрудники всех отделов компании:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // Метод для печати ФИО всех сотрудников
    public void printEmployeesNames() {
        System.out.println("Сотрудники всех отделов компании пофамильно:");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    // Метод для суммирования ЗП сотрудников
    public double calculateMonthSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        System.out.println("Сумма затрат компании на ЗП в месяц составляет - " + sum + " рублей");
        return sum;
    }

    // Метод для подсчета среднего значение зарплат
    public double findAverageSalary() {
        double average = 0;
        for (Employee employee : employees) {
            average += employee.getSalary();
        }
        average = average / employees.length;
        System.out.println("Среднее значение ЗП в компании составляет - " + average + " рублей");
        return average;
    }

    // Метод для поиска сотрудника с минимальной ЗП
    public double findMinSalary() {
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
    public double findMaxSalary() {
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

    // Метод индексирования зарплаты (изменение зп у всех сотрудников на величину аргумента в %)
    public double indexingSalary(double percent) {
        double indexedSalary = 0;
        System.out.println("Сотрудники всех отделов компании после индексирования зарплаты:");
        for (Employee employee : employees) {
            indexedSalary = employee.getSalary() + employee.getSalary() / 100 * percent;
            employee.setSalary(indexedSalary);
            System.out.println(employee);
        }
        return indexedSalary;
    }

    // Метод вывода всех сотрудников с ЗП меньше средней по компании (распечатать id, фио и зп в консоль)
    public void printBelowAverageEmployees() {
        System.out.println("Сотрудники компании с ЗП меньше средней после индексирования:");
        double average = findAverageSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < average) {
                System.out.println(employee.getDataEmployeeWithoutDepartment());
            }
        }
    }

    // Метод вывода всех сотрудников с ЗП больше средней по компании (распечатать id, фио и зп в консоль)
    public void printOverAverageEmployees() {
        System.out.println("Сотрудники компании с ЗП больше средней после индексирования:");
        double average = findAverageSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() >= average) {
                System.out.println(employee.getDataEmployeeWithoutDepartment());
            }
        }
    }

    // Метод с числом в качестве параметра и выводом всех сотрудников с ЗП меньше числа (распечатать id, фио и зп в консоль)
    public void printBelowIntEmployees(double salary) {
        System.out.println("Сотрудники компании с ЗП меньше " + salary + " рублей после индексирования:");
        for (Employee employee : employees) {
            if (employee.getSalary() < salary) {
                System.out.println(employee.getDataEmployeeWithoutDepartment());
            }
        }
    }

    // Метод с числом в качестве параметра и выводом всех сотрудников с ЗП больше или равному числу (распечатать id, фио и зп в консоль)
    public void printOverIntEmployees(double salary) {
        System.out.println("Сотрудники компании с ЗП больше или равно " + salary + " рублей после индексирования:");
        for (Employee employee : employees) {
            if (employee.getSalary() >= salary) {
                System.out.println(employee.getDataEmployeeWithoutDepartment());
            }
        }
    }


    // Методы по работе с сотрудниками компании по отделам

    // Метод проверки номера отдела для сокращения кода и вывода ошибки
    public boolean checkDepartment() {
        boolean i = department > 0 && department <= 5;
        if (i) {
        } else {
            throw new IllegalArgumentException("Укажите правильный номер отдела");
        }
        return i;
    }

    // Метод печати всех сотрудников отдела (все данные, кроме отдела)
    public void printDepartmentEmployees() {
        if (checkDepartment()) {
            System.out.println("Сотрудники отдела компании № " + department + " после индексирования зарплаты:");
            for (Employee employee : employees) {
                if (employee.getDepartment() == department) {
                    System.out.println(employee.getDataEmployeeWithoutDepartment());
                }
            }
        }
    }

    // Метод получения суммы затрат на ЗП по отделу
    public double calculateMonthDepartmentSalary() {
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
    public double findAverageDepartmentSalary() {
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

    // Метод получения в качестве параметра номера отдела и поиска сотрудника с минимальной ЗП в нем
    public double findMinSalaryDepartment() {
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
    public double findMaxSalaryDepartment() {
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

    // Метод индексации зарплат всех сотрудников отдела на процент, который приходит в качестве параметра
    public double indexingDepartmentSalary(double percent) {
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

}
