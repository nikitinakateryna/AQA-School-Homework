import java.util.List;

public class JsonResponse<T> {

    public JsonResponse() {
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData () {
        return data;
    }
    private List<T> data;

    public void setPagination(T pagination) {
        this.pagination = pagination;
    }
    private T pagination;

    public JsonResponse(List<T> data, T pagination) {
        this.data = data;
        this.pagination = pagination;
    }


}
