package org.frekele.fiscal.focus.nfe.client.testng;

public class FocusTestNGUtils {

    public static void sleep(long seconds) {
        try {
            long millis = seconds * 1000;
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // Restore interrupted state...
            Thread.currentThread().interrupt();
        }
    }
}
