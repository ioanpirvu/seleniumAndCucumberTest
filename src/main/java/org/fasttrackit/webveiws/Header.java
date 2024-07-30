package org.fasttrackit.webveiws;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class Header {

    @FindBy(id = "search")
    private WebElement searchField;

    public WebElement getSearchField() {
        return searchField;
    }

    public void search(String keyword) {
        searchField.clear ();
        searchField.sendKeys (keyword + Keys.ENTER);
    }
}
