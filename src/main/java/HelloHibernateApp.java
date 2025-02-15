import daos.StudentDAO;
import entities.Student;
import utils.HibernateUtil;

public class HelloHibernateApp {
    public static void main(String[] args) {
        singleEntity();
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
}
