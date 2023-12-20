import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class ComparingResults {
    public static void main(String[] args){
        JsonResponse<Data> response = new JsonResponse<>();
        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data("Vadym", 18, "Kyiv"));
        dataList.add(new Data("Kate", 28, "Lviv"));

        response.setData(dataList);

        List<Data> newData = response.getData();
        Data data1 = dataList.get(0);
        Data data2 = dataList.get(1);


        Comparator<Data> ageComparator = Comparator.comparing(Data::getAge);
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



