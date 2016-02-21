public class Person {

    public static final String SINGLE = "SINGLE";
    public static final String MARRIED = "MARRIED";

    private int personNumber;
    private String name;
    private int age;
    private String status;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static String getSINGLE() {
        return SINGLE;
    }

    public static String getMARRIED() {
        return MARRIED;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personNumber=" + personNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
