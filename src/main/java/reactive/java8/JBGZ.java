package reactive.java8;

import reactive.shared.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class JBGZ {
    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    public static void main(String[] args){
        TimeElasped.run(() -> {
            CompletableFuture<煎饼> 煎饼一张Future = CompletableFuture.supplyAsync(煎饼工厂::做煎饼);
            CompletableFuture<鸡蛋> 鸡蛋一个Future = CompletableFuture.supplyAsync(鸡蛋工厂::打鸡蛋);
            CompletableFuture<生菜> 生菜若干Future = CompletableFuture.supplyAsync(生菜工厂::切生菜);
            CompletableFuture<火腿肠> 火腿肠一根Future = CompletableFuture.supplyAsync(火腿肠工厂::撕火腿肠);
            CompletableFuture<煎饼果子> 煎饼果子Future  = CompletableFuture
                    .allOf(煎饼一张Future,鸡蛋一个Future,生菜若干Future,火腿肠一根Future)
                    .thenApply(notUsed -> {
                        煎饼果子 好吃的煎饼果子 = 煎饼果子工厂.做煎饼果子(
                                煎饼一张Future.join(),
                                鸡蛋一个Future.join(),
                                生菜若干Future.join(),
                                火腿肠一根Future.join());
                        return 好吃的煎饼果子;
                    });


            System.out.println(煎饼果子Future.join());
        });
        executorService.shutdown();
    }
}
