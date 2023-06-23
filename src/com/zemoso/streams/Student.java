package src.com.zemoso.streams;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String engDepartment;
    private int yearOfEnrollment;
    private double perTillDate;

    public Student(int id, String name, int age, String gender, String engDepartment, int yearOfEnrollment, double perTillDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.yearOfEnrollment = yearOfEnrollment;
        this.perTillDate = perTillDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEngDepartment() {
        return engDepartment;
    }

    public void setEngDepartment(String engDepartment) {
        this.engDepartment = engDepartment;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public void setYearOfEnrollment(int yearOfEnrollment) {
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public double getPerTillDate() {
        return perTillDate;
    }

    public void setPerTillDate(double perTillDate) {
        this.perTillDate = perTillDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", engDepartment='" + engDepartment + '\'' +
                ", yearOfEnrollment=" + yearOfEnrollment +
                ", perTillDate=" + perTillDate +
                '}';
    }
}
