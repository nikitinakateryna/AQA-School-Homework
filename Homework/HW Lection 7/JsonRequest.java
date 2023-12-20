public class JsonRequest <T> {
    private T filter;
    private T pagination;
    private T sorting;

    public void setFilter(T filter){
        this.filter = filter;
    }

    public void setPagination(T pagination){
        this.pagination = pagination;
    }

    public void setSorting(T sorting){
        this.sorting = sorting;
    }

}


class Filter {
    private int age;

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

    private String city;

    public Filter(int age, String city) {
        this.age = age;
        this.city = city;
    }
}

class Sorting {
    public Sorting(String registration) {
        this.registration = registration;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    private String registration;
}