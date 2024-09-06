package $13_threading.$08_future.demo01;

import java.util.concurrent.Callable;

class Task implements Callable<String> {
    public String call() throws Exception {
        return longTimeCalculation(); 
    }

    private String longTimeCalculation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "longTimeCalculation";
    }
}