package com.cucumber.runner;

import com.cucumber.constants.DriverType;
import com.cucumber.constants.EnvType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions
        (plugin = {"pretty", "html:target/cucumber-report/cucumber.html", "json:target/cucumber-report/cucumber.json"},
                snippets = CAMELCASE,
                glue = {"com.cucumber.stepdefinitions", "com.cucumber.hooks", "com.cucumber.customtype"},
                features = "src/test/resources/features"
        )
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
