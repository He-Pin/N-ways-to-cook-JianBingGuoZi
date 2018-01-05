package reactive.actor;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.util.Timeout;
import reactive.shared.煎饼;
import reactive.shared.鸡蛋工厂;
import reactive.shared.鸡蛋煎饼;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static akka.pattern.PatternsCS.ask;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class 鸡蛋煎饼太郎 extends AbstractActor {
    private final ActorRef 煎饼西施Ref;

    public 鸡蛋煎饼太郎(ActorRef 煎饼西施Ref) {
        this.煎饼西施Ref = 煎饼西施Ref;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(命令.做鸡蛋煎饼.class,(jb) -> {
                    System.out.println("太郎,做鸡蛋煎饼");
                    ActorRef sender = getSender();
                    ActorRef self= getSelf();
                    做鸡蛋煎饼().thenAccept((刚刚做好的鸡蛋煎饼) -> {
                        sender.tell(new 事件.鸡蛋煎饼做好了(刚刚做好的鸡蛋煎饼),self);
                    });
                })
                .build();
    }
    private static final Timeout 可以等你40秒 = Timeout.apply(40, TimeUnit.SECONDS);

    private CompletableFuture<鸡蛋煎饼> 做鸡蛋煎饼(){
        CompletableFuture<煎饼> 煎饼CompletableFuture =
                ask(煎饼西施Ref,new 命令.做煎饼(),可以等你40秒)
                .thenApply(r -> ((事件.煎饼做好了)r).get煎饼一张())
                .toCompletableFuture();
        return 煎饼CompletableFuture.thenApply(西施做的煎饼 -> {
            System.out.println("太郎：我在做鸡蛋煎饼");
            return 鸡蛋工厂.鸡蛋打在煎饼上(西施做的煎饼);
        });
    }
}
