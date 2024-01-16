public class JsonRequest <T> {
    private Filter filter;
    private Pagination pagination;
    private Sorting sorting;

    public void setFilter(Filter filter){
        this.filter = filter;
    }

    public void setPagination(Pagination pagination){
        this.pagination = pagination;
    }

    public void setSorting(Sorting sorting){
        this.sorting = sorting;
    }

}


class Filter {
    private int age;
    private String city;

    public Filter(int age, String city) {
        this.age = age;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}

class Sorting {

    private String registration;
    public Sorting(String registration) {
        this.registration = registration;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

}