package org.imdb.tests.ui;


import org.imdb.pages.HomePage;
import org.imdb.pages.SearchResultsPage;
import org.imdb.tests.BaseClasses.BaseAPIUITests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class HomePageTests extends BaseAPIUITests
{

    @Test
    public void testSearchMovieByTitle()
    {
        HomePage homePage=getHomePage();
        homePage.getSearchBox().sendKeys("Selenium HQ");
        homePage.getSearchButton().click();
        SearchResultsPage searchResultsPage = getSearchResultsPage();
        List<String> links = searchResultsPage.getLinks();

        AtomicInteger index = new AtomicInteger();
        for (String link : links) {
            if (link.toLowerCase().contains("wikipedia"))
                break;
         index.getAndIncrement();
        }

        if (links.size() == index.get()) {
            System.out.println("Wikipedia Page not found");
        } else {
            System.out.println(searchResultsPage.getText(index.get()));
        }
    }
}
