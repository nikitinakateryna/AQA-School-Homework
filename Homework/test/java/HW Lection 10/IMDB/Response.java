package IMDB;

import  okhttp3.ResponseBody;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.*;


public class Response {
    public static RestClient client = new RestClient();


    public static ResponseBody receiveTopChartResponse() throws IOException {
        return client.movies.receiveTopChart().execute().body();

    }

    public static LinkedHashMap<String, List<Object>> receiveTopCharts() throws IOException {
        var html = receiveTopChartResponse().string();
        var document = Jsoup.parse(html);
        var movieData = document.select("li");

        LinkedHashMap<String, List<Object>> movies = new LinkedHashMap<>();


        for (Element movieElement : movieData) {
            var unsortedData = movieElement.select(".ipc-metadata-list-summary-item__c").first();
            if (unsortedData != null) {
                String href = unsortedData.select("a").attr("href");
                String title = unsortedData.select("h3").text();
                String year = unsortedData.select(".sc-1e00898e-8.hsHAHC.cli-title-metadata-item").first().text();
                String rating = unsortedData.select(".ipc-rating-star.ipc-rating-star--base.ipc-rating-star--imdb.ratingGroup--imdb-rating").attr("aria-label");
                String link = RestClient.BASE_URL + href;

                List<Object> moviesInfo = new ArrayList<>();

                moviesInfo.add(year);
                moviesInfo.add(title);
                moviesInfo.add(rating);

                movies.put(link, moviesInfo);
            }
        }
        return movies;

    }

    public List<Map.Entry<String, List<Object>>> getTop100Films() throws IOException {
        return receiveTopCharts().entrySet().stream().limit(100).toList();
    }

    @DataProvider(name = "top100Movies")
    public Iterator<Object[]> top100MoviesDataProvider() throws IOException {
        List<Map.Entry<String, List<Object>>> top100Movies = getTop100Films();
        List<Object[]> data = new ArrayList<>();

        for (Map.Entry<String, List<Object>> movieEntry : top100Movies) {
            String movieLink = movieEntry.getKey();
            List<Object> movieInfo = movieEntry.getValue();
            String year = (String) movieInfo.get(0);
            String title = (String) movieInfo.get(1);
            String rating = (String) movieInfo.get(2);

            data.add(new Object[]{movieLink, year, title, rating});
        }

        return data.iterator();
    }




}





