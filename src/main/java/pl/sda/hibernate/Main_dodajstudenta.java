package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

public class Main_dodajstudenta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie studenta");
        String imie = scanner.nextLine();
        System.out.println("Podaj nazwisko studenta");
        String nazwisko = scanner.nextLine();
        System.out.println("Podaj rok rozpoczecia studiow ");
        String rokRozpoczeciaStudioww = scanner.nextLine();

        int rokRozpoczeciaStudiow=Integer.parseInt(rokRozpoczeciaStudioww);
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            // CREATE
            // READ
            // UPDATE
            // DELETE

            // Tworzymy studenta
//            Student student = new Student();
//            student.setImie("Paweł");
//            student.setDataUrodzenia(LocalDate.of(1990, 1, 3));
//            student.setKierunekNauczania("Informatyka");
//            student.setIndeks("123123");

//            Student student = new Student("Paweł", LocalDate.of(1990, 1, 3), "Informatyka", "123123");
            Student student = Student.builder()
                    .imie(imie)
                    .nazwisko(nazwisko)
                    .rokRozpoczeciaStudiow(rokRozpoczeciaStudiow)
                    .build();

            // SQL: INSERT INTO 'student' values (...)
            // zapisujemy studenta
            // Merge:
            //  - służy do aktualizacji,
            //  - wymaga podania id, co jest kryterium aktualizacji (aktualizujemy obiekt o podanym id)
            // Persist:
            //  - służy do wstawiania NOWYCH rekordów do bazy,
            //  - przeważnie nie podaje się ID ponieważ jest generowane
            session.persist(student);

            // zatwierdzamy transakcję
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy: " + ioe);
        }
    }
    }

