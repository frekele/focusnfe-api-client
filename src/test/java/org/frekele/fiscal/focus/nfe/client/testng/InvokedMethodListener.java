package org.frekele.fiscal.focus.nfe.client.testng;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * @author frekele - Leandro Kersting de Freitas
 */
public class InvokedMethodListener implements IInvokedMethodListener {

    static {
        String path = InvokedMethodListener.class.getClassLoader().getResource("logging.properties").getFile();
        System.setProperty("java.util.logging.config.file", path);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println(this.getTestClassAndMethodName(method) + " Start method --->");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        long duration = testResult.getEndMillis() - testResult.getStartMillis();
        System.out.println(this.getTestClassAndMethodName(method) + " Duration: [ " + duration + "ms ];");
        System.out.println(this.getTestClassAndMethodName(method) + " <--- End method.\n");
    }

    private String getTestClassAndMethodName(IInvokedMethod method) {
        return this.getTestClassName(method) + "[" + this.getMethodName(method) + "]";
    }

    private String getTestClassName(IInvokedMethod method) {
        return method.getTestResult().getInstanceName();
    }

    private String getMethodName(IInvokedMethod method) {
        return method.getTestMethod().getMethodName();
    }
}
