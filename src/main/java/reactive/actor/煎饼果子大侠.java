package reactive.actor;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.util.Timeout;
import reactive.shared.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static akka.pattern.PatternsCS.ask;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class 煎饼果子大侠 extends AbstractActor {
    private final ActorRef 鸡蛋煎饼太郎Ref;
    private final ActorRef 生菜小二哥Ref;
    private final ActorRef 火腿肠大叔Ref;

    public 煎饼果子大侠(ActorRef 鸡蛋煎饼太郎Ref, ActorRef 生菜小二哥Ref, ActorRef 火腿肠大叔Ref) {
        this.鸡蛋煎饼太郎Ref = 鸡蛋煎饼太郎Ref;
        this.生菜小二哥Ref = 生菜小二哥Ref;
        this.火腿肠大叔Ref = 火腿肠大叔Ref;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(命令.做个煎饼果子.class,(cmd) -> {
                    ActorRef sender = getSender();
                    ActorRef self = getSelf();
                    System.out.println("大侠，做个煎饼果子");
                    做一个煎饼果子().thenAccept(刚做好的煎饼果子 -> {
                        sender.tell(new 事件.煎饼果子做好了(刚做好的煎饼果子),self);
                    });
                })
                .build();
    }
    private static final Timeout 最多等你半分钟 = Timeout.apply(30, TimeUnit.SECONDS);

    private CompletableFuture<煎饼果子> 做一个煎饼果子(){
        //TODO stack based?
        CompletableFuture<鸡蛋煎饼> 鸡蛋煎饼Future =
                ask(鸡蛋煎饼太郎Ref,new 命令.做鸡蛋煎饼(),最多等你半分钟)
                .toCompletableFuture()
                .thenApply(r -> ((事件.鸡蛋煎饼做好了)r).get鸡蛋煎饼一张());

        CompletableFuture<生菜> 生菜若干Future =
                ask(生菜小二哥Ref,new 命令.切生菜(),最多等你半分钟)
                .toCompletableFuture()
                .thenApply(r -> ((事件.生菜切好了)r).get生菜若干());

        CompletableFuture<火腿肠> 火腿肠一根Future =
                ask(火腿肠大叔Ref,new 命令.撕火腿肠(),最多等你半分钟)
                .toCompletableFuture()
                .thenApply(r -> ((事件.火腿撕好了)r).get火腿肠一根());
        return CompletableFuture
                .allOf(鸡蛋煎饼Future,生菜若干Future,火腿肠一根Future)
                .thenApply(notUsed -> {
                    System.out.println("大侠：我在开始做煎饼果子了");
                    煎饼果子 好吃的煎饼果子 = 煎饼果子工厂.做煎饼果子(
                            鸡蛋煎饼Future.join(),
                            生菜若干Future.join(),
                            火腿肠一根Future.join());
                    return 好吃的煎饼果子;
                });
    }
}
