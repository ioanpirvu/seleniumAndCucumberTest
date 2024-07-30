package org.fasttrackit.stepdefinitions;

import io.cucumber.java.en.And;
import org.fasttrackit.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.fasttrackit.webveiws.Header;

public class HeaderSteps extends TestBase {

    private final Header header = PageFactory.initElements (driver, Header.class);

    @And("I search products by ”new arrivals”")
    public void iSearchProductsByNewArrivals() {

        String iSearchProductsByNewArrivals = "";
        header.search (iSearchProductsByNewArrivals);

    }


}
