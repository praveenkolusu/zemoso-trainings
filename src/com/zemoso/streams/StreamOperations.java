package src.com.zemoso.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {
        List<Student> studentList = createStudentList();

        printDepartments(studentList);
        printNamesEnrolledAfter2018(studentList);
        printMaleStudentsInCS(studentList);
        countMaleAndFemaleStudents(studentList);
        calculateAverageAgeByGender(studentList);
        printStudentWithHighestPercentage(studentList);
        countStudentsByDepartment(studentList);
        calculateAveragePercentageByDepartment(studentList);
        printYoungestMaleStudentInElectronic(studentList);
        countMaleAndFemaleStudentsInCS(studentList);
    }

    private static void printDepartments(List<Student> studentList) {
        System.out.println("Departments in the college:");
        studentList.stream()
                .map(Student::getEngDepartment)
                .distinct()
                .forEach(System.out::println);
        System.out.println();
    }

    private static void printNamesEnrolledAfter2018(List<Student> studentList) {
        System.out.println("Names of students enrolled after 2018:");
        List<String> namesEnrolledAfter2018 = studentList.stream()
                .filter(student -> student.getYearOfEnrollment() > 2018)
                .map(Student::getName)
                .collect(Collectors.toList());
        namesEnrolledAfter2018.forEach(System.out::println);
        System.out.println();
    }

    private static void printMaleStudentsInCS(List<Student> studentList) {
        System.out.println("Details of male students in the Computer Science department:");
        List<Student> maleStudentsInCS = studentList.stream()
                .filter(student -> student.getGender().equals("Male") && student.getEngDepartment().equals("Computer Science"))
                .collect(Collectors.toList());
        maleStudentsInCS.forEach(System.out::println);
        System.out.println();
    }

    private static void countMaleAndFemaleStudents(List<Student> studentList) {
        Map<String, Long> genderCount = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        System.out.println("Number of male students: " + genderCount.get("Male"));
        System.out.println("Number of female students: " + genderCount.get("Female"));
        System.out.println();
    }

    private static void calculateAverageAgeByGender(List<Student> studentList) {
        Map<String, Double> averageAgeByGender = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println("Average age of male students: " + averageAgeByGender.get("Male"));
        System.out.println("Average age of female students: " + averageAgeByGender.get("Female"));
        System.out.println();
    }

    private static void printStudentWithHighestPercentage(List<Student> studentList) {
        Optional<Student> studentWithHighestPercentage = studentList.stream()
                .max(Comparator.comparingDouble(Student::getPerTillDate));
        studentWithHighestPercentage.ifPresent(System.out::println);
        System.out.println();
    }

    private static void countStudentsByDepartment(List<Student> studentList) {
        Map<String, Long> studentCountByDepartment = studentList.stream()
                .collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.counting()));
        System.out.println("Number of students in each department:");
        studentCountByDepartment.forEach((department, count) -> System.out.println(department + ": " + count));
        System.out.println();
    }

    private static void calculateAveragePercentageByDepartment(List<Student> studentList) {
        Map<String, Double> averagePercentageByDepartment = studentList.stream()
                .collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.averagingDouble(Student::getPerTillDate)));
        System.out.println("Average percentage achieved in each department:");
        averagePercentageByDepartment.forEach((department, averagePercentage) -> System.out.println(department + ": " + averagePercentage));
        System.out.println();
    }

    private static void printYoungestMaleStudentInElectronic(List<Student> studentList) {
        System.out.println("Details of the youngest male student in the Electronic department:");
        Optional<Student> youngestMaleStudentInElectronic = studentList.stream()
                .filter(student -> student.getGender().equals("Male") && student.getEngDepartment().equals("Electronic"))
                .min(Comparator.comparingInt(Student::getAge));
        youngestMaleStudentInElectronic.ifPresent(System.out::println);
        System.out.println();
    }

    private static void countMaleAndFemaleStudentsInCS(List<Student> studentList) {
        Map<String, Long> genderCountInCS = studentList.stream()
                .filter(student -> student.getEngDepartment().equals("Computer Science"))
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        System.out.println("Number of male students in Computer Science: " + genderCountInCS.get("Male"));
        System.out.println("Number of female students in Computer Science: " + genderCountInCS.get("Female"));
    }

    private static List<Student> createStudentList() {
        return List.of(
                new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8),
                new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2),
                new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3),
                new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80),
                new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70),
                new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70),
                new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70),
                new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80),
                new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85),
                new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82),
                new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83),
                new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4),
                new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6),
                new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8),
                new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4),
                new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4),
                new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5)
        );
    }
}
