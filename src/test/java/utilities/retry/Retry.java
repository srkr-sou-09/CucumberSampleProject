package utilities.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int maxRetryCount = 3;
    ThreadLocal<Integer> intialRetryCount = ThreadLocal.withInitial(()->0);

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()
                && intialRetryCount.get()<maxRetryCount) {

            intialRetryCount.set(intialRetryCount.get()+1);
                return true;
            }
        return false;
    }
}
