package IMDB;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IMDBSetup {
    @GET("chart/top")
    @Headers({"user-agent: Mozilla/5.0", "Accept-Language: en-US"})
    Call<ResponseBody> receiveTopChart();

}


