package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners implements ITestListener {

    @Override
    public void onStart(ITestContext arg) {


        System.out.println("onStart - Tum testlerden once 1 sefer cagrilir -> "+ arg.getName());

    }

    @Override
    public void onFinish(ITestContext arg) {


        System.out.println("onFinish -  Tm testlerden sonra 1 sefer cagrilir->"+ arg.getName() );
    }

    @Override
    public void onTestStart(ITestResult arg) {


        System.out.println("onTestStart -Method sayisi kadar,  Her bir @Test annotation dan once 1 kez calisir ->"+arg.getName());

    }

    @Override
    public void onTestSuccess(ITestResult arg) {

        System.out.println("onTestSuccess - PASS olan method sayisi kadar, ve PASS edilen Methodlardan SONRA bir kez calisir ->"+arg.getName());
        try {
            ReusableMethods.getScreenshot(arg.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult arg) {

        System.out.println("onTestSkipped - Skipped edilen method sayisi kadar, ve skipped edilen Methodlardan SONRA bir kez calisir ->"+arg.getName());

        try {
            ReusableMethods.getScreenshot(arg.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onTestFailure(ITestResult arg) {


        System.out.println("onTestFailuru - Failed edilen method sayisi kadar, ve failed edilen Methodlardan SONRA bir kez calisir ->"+arg.getName());

        try {
            ReusableMethods.getScreenshot(arg.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
