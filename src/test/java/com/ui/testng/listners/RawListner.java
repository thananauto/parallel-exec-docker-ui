package com.ui.testng.listners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.ui.testng.report.ExtentTestManager;
import com.ui.testng.test.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class RawListner extends Base implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
         ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), iTestResult.getMethod().getDescription());
    }
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        OnTestRun(iTestResult);
    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        OnTestRun(iTestResult);
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        OnTestRun(iTestResult);
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }
    @Override
    public void onStart(ITestContext iTestContext) {


    }
    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On Finish"+ iTestContext.getName());
        ExtentTestManager.flush();
    }


    public void OnTestRun(ITestResult result){
       ExtentTest extentTest = ExtentTestManager.getTest();
        if(result.getStatus()==ITestResult.FAILURE){
            extentTest.assignCategory(result.getInstanceName());
            extentTest.log(Status.FAIL,"Details: "+result.getMethod().getDescription());
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("FAILED test case name is:"+""+result.getName(),ExtentColor.RED));
            Reporter.log("Failed Report"+"",true);
            extentTest.log(Status.FAIL,MarkupHelper.createLabel("Testcase FAILED due to below issues:"+"", ExtentColor.RED));
            extentTest.fail(result.getThrowable());
            extentTest.log(Status.FAIL,"ParamsPassed:");
            for(int i=0;i<result.getParameters().length;i++){
                extentTest.log(Status.FAIL,result.getParameters()[i].toString());
            }
        }
        else if(result.getStatus()==ITestResult.SUCCESS){
            extentTest.log(Status.PASS,"TestClass:"+result.getClass().getName()+" : "+result.getMethod().getDescription());
        }
        else if(result.getStatus()==ITestResult.SKIP){
            extentTest.log(Status.SKIP,"TestCaseSKIPPEDis"+""+result.getMethod().getDescription());
        }
    }
}
