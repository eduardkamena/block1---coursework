public class Main {

    public static void main(String[] args) {

        // Создание экземпляра класса
        EmployeeBook employeeBook = new EmployeeBook();

        // Методы для управления внутренним массивом по работе с сотрудниками

        // Вызов метода для поиска сотрудника по id
        employeeBook.findEmployeeId(1022);
        System.out.println();

        // Вызов метода для поиска сотрудника по ФИО
        // fullName - полное ФИО сотрудника
        employeeBook.findEmployeeName("Боголюбов Валерий Сергеевич");
        System.out.println();

        // Вызов метода изменения данных сотрудника по ФИО
        employeeBook.changeEmployeeData("Боголюбов Валерий Сергеевич", 1, 70_000);
        System.out.println();

        // Вызов метода для удаления сотрудника по id из базы
        employeeBook.removeEmployee(1071);
        System.out.println();

        // Вызов метода для проверки свободной ячейки для записи сотрудника и вывода результата (true/false) в консоль
        employeeBook.checkAddEmployeeTrue();
        System.out.println("Есть свободное место для записи нового сотрудника? да - true, нет - false :");
        System.out.println(employeeBook.checkAddEmployeeTrue());
        System.out.println();

        // Вызов метода записи нового сотрудника, если ячейка свободна (с поиском сначала массива)
        employeeBook.addEmployee("Молчанов", "Кирилл", "Сергеевич", 3, 150_000);
        System.out.println();


        // Методы по работе с сотрудниками компании

        // Вызов метода для вывода списка всех сотрудников со всеми имеющимися по ним данными
        employeeBook.printEmployees();
        System.out.println();

        // Вызов метода для печати ФИО всех сотрудников
        employeeBook.printEmployeesNames();
        System.out.println();

        // Вызов метода для суммирования ЗП сотрудников
        employeeBook.calculateMonthSalary();
        System.out.println();

        // Вызов метода для подсчета среднего значение зарплат
        employeeBook.findAverageSalary();
        System.out.println();

        // Вызов метода для поиска сотрудника с минимальной ЗП
        employeeBook.findMinSalary();
        System.out.println();

        // Вызов метода для поиска сотрудника с максимальной ЗП
        employeeBook.findMaxSalary();
        System.out.println();

        // Вызов метода для индексирования зарплаты (изменение зп у всех сотрудников на величину аргумента в %)
        // percent - устанавливаемый % индексирования
        employeeBook.indexingSalary(10);
        System.out.println();

        // Вызов метода вывода всех сотрудников с ЗП меньше средней по компании (распечатать id, фио и зп в консоль)
        employeeBook.printBelowAverageEmployees();
        System.out.println();

        // Вызов метода вывода всех сотрудников с ЗП больше средней по компании (распечатать id, фио и зп в консоль)
        employeeBook.printOverAverageEmployees();
        System.out.println();

        // Вызов метода с числом в качестве параметра и выводом всех сотрудников с ЗП меньше числа (распечатать id, фио и зп в консоль)
        employeeBook.printBelowIntEmployees(111_100);
        System.out.println();

        // Вызов метода с числом в качестве параметра и выводом всех сотрудников с ЗП больше или равному числу (распечатать id, фио и зп в консоль)
        employeeBook.printOverIntEmployees(111_100);
        System.out.println();


        // Методы по работе с сотрудниками компании по отделам

        // Вызов метода печати всех сотрудников отдела (все данные, кроме отдела)
        employeeBook.printDepartmentEmployees(4);
        System.out.println();

        // Вызов метода для получения суммы затрат на ЗП по отделу
        employeeBook.calculateMonthDepartmentSalary(2);
        System.out.println();

        // Вызов метода для получения средней суммы затрат на ЗП по отделу
        employeeBook.findAverageDepartmentSalary(3);
        System.out.println();

        // Вызов метода для поиска сотрудника с минимальной ЗП в отделе
        employeeBook.findMinSalaryDepartment(3);
        System.out.println();

        // Вызов метода для поиска сотрудника с максимальной ЗП в отделе
        employeeBook.findMaxSalaryDepartment(3);
        System.out.println();

        // Вызов метода индексации зарплат всех сотрудников отдела на процент
        // department - номер отдела
        // percent - устанавливаемый % индексирования
        employeeBook.indexingDepartmentSalary(2, 20);
        System.out.println();

    }

}
