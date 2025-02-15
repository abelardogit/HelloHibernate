import daos.StudentDAO;
import daos.UserDAO;
import entities.Address;
import entities.Student;
import entities.User;
import utils.HibernateUtil;

public class HelloHibernateApp {
    public static void main(String[] args) {
        //singleEntity();
        oneToOne();
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
}
