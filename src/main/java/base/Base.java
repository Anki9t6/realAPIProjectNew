package base;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.*;
import api.utilities.*;
import io.restassured.RestAssured;

public class Base {
	public static String base_uri;

    @BeforeClass
    public void setup() {

        // Read version from system property (default = v3)
        String version = System.getProperty("version", "v3");

        if (version.equalsIgnoreCase("v2")) {
            base_uri = "https://petstore.swagger.io/v2";
        } 
        else if (version.equalsIgnoreCase("v3")) {
            base_uri = "https://petstore3.swagger.io/api/v3";
        } 
        else {
            throw new RuntimeException("Invalid API version: " + version);
        }

        // Set in RestAssured
        RestAssured.baseURI = base_uri;

        System.out.println("Running tests on version: " + version);
        System.out.println("Base URI: " + base_uri);
    }
	public static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getInstance();
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush(); // generate report
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

}
