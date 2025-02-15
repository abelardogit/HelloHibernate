import daos.*;
import entities.*;
import utils.HibernateUtil;

import java.util.HashSet;
import java.util.Set;

public class HelloHibernateApp {
    public static void main(String[] args) {
        // singleEntity();
        // oneToOne();
        // oneToMany();
        manyToMany();
    }

    private static void singleEntity() {
        StudentDAO studentDAO = new StudentDAO();

        Student aStudent = new Student(
                "NombreEstudiante",
                "email@estudiante.com",
                7.75f
        );

        studentDAO.saveStudent(aStudent);

        // Más operaciones ...

        // Cerramos la sesión que se abrió en el DAO
        HibernateUtil.shutdown();
    }

    private static void oneToOne() {
        UserDAO userDAO = new UserDAO();

        Address calleDecepcion = new Address();
        calleDecepcion.setFullDescription("Calle de la decepción, 13");

        User user = new User(
                "NombreUsuario",
                (byte) 18,
                calleDecepcion
        );

        userDAO.saveUser(user);

        // Más operaciones ...

        // Cerramos la sesión que se abrió en el DAO
        HibernateUtil.shutdown();
    }

    private static void oneToMany() {
        CartDAO cartDAO = new CartDAO();
        ItemDAO itemDAO = new ItemDAO();

        // Create new students
        Cart cart1 = new Cart();
        cart1.setName("Regalo de cumpleaños");

        Item item = new Item();
        item.setName("Balón de baloncesto");

        Item item2 = new Item();
        item2.setName("Canasta");

        Set<Item> items = new HashSet<>();
        items.add(item); items.add(item2);

        cart1.addItems(items);

        cartDAO.saveCart(cart1);

        itemDAO.saveItem(item);
        itemDAO.saveItem(item2);

        // Shut down the SessionFactory
        HibernateUtil.shutdown();
    }

    private static void manyToMany() {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        Project accesoADatos = new Project();
        accesoADatos.setFullDescription("Acceso a Datos");

        Project desarrolloApps = new Project();
        desarrolloApps.setFullDescription("Desarrollo apps");

        Set<Project> dam2 = new HashSet<>();
        dam2.add(accesoADatos); dam2.add(desarrolloApps);



        // Relation management
        Employee employee1 = new Employee();
        employee1.setName("Fulanito");
        employee1.setProjects(dam2);
        for (Project proj : dam2) {
            Set<Employee> employeesPerProject = proj.getEmployees();
            employeesPerProject.add(employee1);
        }

        Employee employee2 = new Employee();
        employee2.setName("Menganito");
        employee2.setProjects(dam2);
        for (Project proj : dam2) {
            Set<Employee> employeesPerProject = proj.getEmployees();
            employeesPerProject.add(employee2);
        }

        employeeDAO.saveEmployees(new Employee[]{employee1, employee2});

        // Shut down the SessionFactory
        HibernateUtil.shutdown();
    }
}
