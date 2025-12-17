package Hooks;

import ExtentUtility.ExtentUtils;
import LoggerUtility.LoggerUtility;
import PropertyUtils.PropertyUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Hooks {

    private String testName;
    public PropertyUtils propertyUtils;

    @BeforeSuite
    public void prepareSuite() {
        ExtentUtils.initiateReport();
    }

    @BeforeMethod
    public void prepareTest() {
        testName = this.getClass().getSimpleName();
        LoggerUtility.startTestCase(testName);
        ExtentUtils.startTest(testName);
    }

    @AfterMethod
    public void clearTest() {
        LoggerUtility.finishTestCase(testName);
        ExtentUtils.endTest(testName);
    }

    @AfterSuite
    public void clearSuite() {
        ExtentUtils.generateReport();
    }
}
