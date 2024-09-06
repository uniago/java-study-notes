package $13_threading.$08_future.demo01;


import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        // 定义任务:
        Callable<String> task = new Task();
        // 提交任务并获得Future:
        Future<String> future = executor.submit(task);
        // 从Future获取异步执行返回的结果:
        try {
            // String result = future.get(); // 可能阻塞
            String result = future.get(3, TimeUnit.SECONDS); // 可能阻塞
            System.out.println("result = " + result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}
