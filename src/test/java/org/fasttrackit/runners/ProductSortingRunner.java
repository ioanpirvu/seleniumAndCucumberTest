package org.fasttrackit.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        plugin = {"html:target/cucumber", "json:target/json-reports/product-sorting.json"},
        glue = {"org.fasttrackit"},
        features = {"src/test/resources/features/product-sorting.feature"}
)
@RunWith (Cucumber.class)

public class ProductSortingRunner {
}
