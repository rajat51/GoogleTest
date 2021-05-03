package org.imdb.pages;

import org.imdb.BaseClasses.BasePage;
import org.imdb.customWebElem.ExWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends BasePage {

    By searchBox=By.cssSelector("[name*='q']");
    By searchButton=By.cssSelector("input[name*='btnK']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ExWebElement getSearchBox(){
        return new ExWebElement(driver,searchBox);
    }

    public ExWebElement getSearchButton() {return new ExWebElement(driver,searchButton);}

}
