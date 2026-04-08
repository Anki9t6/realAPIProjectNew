package api.utilities;
import org.testng.*;
import com.aventstack.extentreports.*;
import base.Base;

public class ExtentListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = Base.extent.createTest(result.getMethod().getMethodName());
        Base.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Base.getTest().pass("Test Passed ✅");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Base.getTest().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Base.getTest().skip("Test Skipped ⚠️");
    }
}
