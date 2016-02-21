import java.util.ArrayList;
import java.util.List;

public class PersonDataLoader {


    public static List<Person> getPersonList()
    {
        Person p1 = new Person();
        p1.setPersonNumber(1);
        p1.setName("Dileepa");
        p1.setAge(28);
        p1.setStatus(Person.SINGLE);
        p1.setSalary(190.00);

        Person p2 = new Person();
        p2.setPersonNumber(2);
        p2.setName("Madawa");
        p2.setAge(28);
        p2.setStatus(Person.SINGLE);
        p2.setSalary(150.00);

        Person p3 = new Person();
        p3.setPersonNumber(3);
        p3.setName("Janaki");
        p3.setAge(30);
        p3.setStatus(Person.SINGLE);
        p3.setSalary(120.00);

        Person p4 = new Person();
        p4.setPersonNumber(4);
        p4.setName("Tharindu");
        p4.setAge(30);
        p4.setStatus(Person.MARRIED);
        p4.setSalary(100.00);

        Person p5 = new Person();
        p5.setPersonNumber(5);
        p5.setName("Umesh");
        p5.setAge(32);
        p5.setStatus(Person.MARRIED);
        p5.setSalary(110.00);

        Person p6 = new Person();
        p6.setPersonNumber(6);
        p6.setName("Tharani");
        p6.setAge(27);
        p6.setStatus(Person.SINGLE);
        p6.setSalary(100.00);

        List<Person> persons = new ArrayList<Person>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);
        persons.add(p6);
        return persons;
    }


}
