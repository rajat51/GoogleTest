package org.imdb.pages;

import org.imdb.BaseClasses.BasePage;
import org.imdb.customWebElem.ExWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SearchResultsPage extends BasePage {

    By searchResults =By.cssSelector(".hlcw0c > .g");
    By searchResultsText=By.cssSelector(".hlcw0c > .g > div > div > div:nth-child(2)");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public List<String> getLinks() {
        return new ExWebElement(driver, searchResults).findAllElements().stream().map(WebElement::getText).collect(toList());
    }

    public String getText(int index) {
        List<WebElement> allElements = new ExWebElement(driver, searchResultsText).findAllElements();
        return allElements.get(index).findElement(By.tagName("span")).getText();
    }

}
