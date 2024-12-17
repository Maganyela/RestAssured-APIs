package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    static ExtentReports report;
    public static ExtentTest test;
    public static ExtentReports extent;

    @Before
    public static void Setup(){
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
    @After
    public static void cleanup(){
        extent.flush();
    }
}
