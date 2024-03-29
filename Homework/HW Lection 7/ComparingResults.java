import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class ComparingResults {
    public static void main(String[] args){

        List<User> dataList = new ArrayList<>();
        dataList.add(new User("Vadym", 18, "Kyiv"));
        dataList.add(new User("Kate", 18, "Lviv"));


        User data1 = dataList.get(0);
        User data2 = dataList.get(1);


        Comparator<User> ageComparator = Comparator.comparing(User::getAge);
        int result = ageComparator.compare(data1, data2);

        if (result < 0) {
            System.out.println(data1.getName() + " younger than " + data2.getName());
        } else if (result > 0) {
            System.out.println(data1.getName() + " older than " + data2.getName());
        } else {
            System.out.println(data1.getName() + " and " + data2.getName() + " have the same age");
        }
    }
}



