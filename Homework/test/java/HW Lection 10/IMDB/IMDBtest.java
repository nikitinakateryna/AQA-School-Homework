package IMDB;

import org.testng.Assert;

import org.testng.annotations.Test;

import java.io.IOException;


import static com.codeborne.selenide.Selenide.*;

public class IMDBtest extends Response {

    @Test(dataProvider = "top100Movies", dataProviderClass = Response.class)
    public void testMoviesDetails(String movieLink, String year, String title, String rating) throws IOException {
        open(movieLink);

        Assert.assertTrue(title.contains($("[data-testid='hero__primary-text']").getText()), "No match by title.");
        Assert.assertEquals(year, $$(".ipc-link.ipc-link--baseAlt.ipc-link--inherit-color").get(5).getText(), "No match by year.");
        Assert.assertTrue(rating.contains($(".sc-bde20123-1.cMEQkK").getText()), "No match by title.");

    }

}