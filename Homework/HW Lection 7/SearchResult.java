import java.util.List;

public class SearchResult<T> {
    private List<T> data;
    private Pagination pagination;

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<T> getData () {
        return data;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
    public SearchResult(List<T> data, Pagination pagination) {
        this.data = data;
        this.pagination = pagination;
    }


}
