import java.util.Comparator;

public class PersonComparator implements Comparator<Person>
{


    @Override
    public int compare(Person o1, Person o2) {

        if ( o1.getPersonNumber() < o2.getPersonNumber() )
            {
            return -1;
        }
        else if ( o1.getPersonNumber() > o2.getPersonNumber() )
        {
            return 1;
        }
        else
        {
            return 0;
        }

    }
}
