package ExtentUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentUtils {
    private static ExtentReports extent;
    private static ExtentTest testReport;
    private static final String pathToProject =  System.getProperty("user.dir") + "/target/extentReports/";

    private static void createDirectory() {
        File directory = new File(pathToProject);
        if(!directory.isDirectory()) {
            directory.mkdirs();
        }
    }

    public static void initiateReport() {
        createDirectory();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(pathToProject + "ExtentReport.html");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void attachReportLog(String attachType, String message) {
        if(attachType.equals(ReportStep.INFO_STEP)) {
            testReport.log(Status.INFO, message);
        }
        if(attachType.equals(ReportStep.PASS_STEP)) {
            testReport.log(Status.PASS, message);
        }
        if(attachType.equals(ReportStep.FAIL_STEP)) {
            testReport.log(Status.FAIL, message);
        }
    }

    public static void startTest(String testName) {
        testReport = extent.createTest(testName + " - report");
        attachReportLog(ReportStep.INFO_STEP, "----Start test---- " + testName);
    }

    public static void endTest(String testName) {
        attachReportLog(ReportStep.INFO_STEP, "----End test---- " + testName);
    }

    public static void generateReport(){
        extent.flush();
    }
}
