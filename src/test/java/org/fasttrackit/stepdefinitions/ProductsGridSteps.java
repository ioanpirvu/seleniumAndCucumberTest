package org.fasttrackit.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fasttrackit.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.fasttrackit.webveiws.ProductsGrid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProductsGridSteps extends TestBase {

    private final ProductsGrid productsGrid = PageFactory.initElements (driver, ProductsGrid.class);
    private List<Double> ArrayList;

    @When("I select the option ”Price” in the Sort By list")
    public void iSelectTheOptionPriceInTheSortByList(String sortCriteria) {
        productsGrid.getSortByList ( ).selectByVisibleText (sortCriteria);
    }

    @And("I sort the products in (.+) direction")
    public void iSortTheProducts(String sortDirection) {
        String classAttribute;

        if (sortDirection.equals ("descending")) {
            classAttribute = "--asc";
        } else {
            classAttribute = "--desc";
        }

        if (productsGrid.getSortDirectionButton ( ).getAttribute ("class").contains ("classAttribute")) {
            productsGrid.getSortDirectionButton ( ).click ( );
        }
    }

    @Then("the  products are ordered by price in (.+) order")
    public void theProductsAreOrderedByPriceInDescendingOrder(String sortDirection) {
        List<Double> prices = new ArrayList<> ( );

        for (WebElement priceContainer : productsGrid.getProductPrices ( )) {
            String priceText = priceContainer.getText ( );

            Pattern pattern = Pattern.compile ("(\\d+,\\d+).*");
            Matcher matcher = pattern.matcher (priceText);

            if (matcher.find ( )) {
                double price = Double.parseDouble (matcher.group (1).replace (",", "."));
                prices.add (price);
            }

        }

        assertThat ("No product prices could be extracted.", prices, hasSize (greaterThan (0)));

        List<Double> sortedPrices = new ArrayList<> (prices);

        Comparator<Double> comparator;

        if (sortDirection.equals ("ascending")) {
            comparator = Comparator.naturalOrder ( );
        } else {
            comparator = Comparator.reverseOrder ( );
        }

        sortedPrices.sort (comparator);

        assertThat ("Products are not order correctly.", prices, equalTo (sortedPrices));
    }
}
