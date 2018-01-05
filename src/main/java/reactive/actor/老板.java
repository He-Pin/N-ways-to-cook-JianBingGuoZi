package reactive.actor;

import akka.actor.AbstractActor;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.Creator;
import akka.util.Timeout;
import reactive.shared.煎饼果子;

import javax.xml.transform.Source;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static akka.pattern.PatternsCS.ask;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class 老板 extends AbstractActor {
    private final ActorRef 煎饼西施Ref;
    private final ActorRef 鸡蛋煎饼太郎Ref;
    private final ActorRef 生菜小二哥Ref;
    private final ActorRef 火腿肠大叔Ref;
    private final ActorRef 煎饼果子大侠Ref;

    public 老板() {
        煎饼西施Ref = context().actorOf(Props.create(煎饼西施.class),"jbxs");
        鸡蛋煎饼太郎Ref = context().actorOf(Props.create(鸡蛋煎饼太郎.class,煎饼西施Ref),
                "jdjbtl");
        生菜小二哥Ref = context().actorOf(Props.create(生菜小二哥.class),"scxer");
        火腿肠大叔Ref = context().actorOf(Props.create(火腿肠大叔.class),"htcds");
        煎饼果子大侠Ref = context().actorOf(Props.create(煎饼果子大侠.class,
                (Creator<煎饼果子大侠>) () ->
                        new 煎饼果子大侠(鸡蛋煎饼太郎Ref,生菜小二哥Ref,火腿肠大叔Ref)),
                "jbgzdx");
    }

    @Override
    public Receive createReceive() {
        //TODO forward pattern ?
        return receiveBuilder()
                .match(命令.煎饼果子来一个.class,(cmd) -> {
                    ActorRef sender = getSender();
                    ActorRef self = getSelf();
                    System.out.println("老板，煎饼果子来一个");
                    快点做煎饼果子().thenAccept((新鲜的煎饼果子) -> {
                        sender.tell(新鲜的煎饼果子,self);
                    });
                })
                .build();
    }

    private static final Timeout 最多等你一分钟 = Timeout.apply(1, TimeUnit.MINUTES);

    private CompletableFuture<煎饼果子> 快点做煎饼果子(){
        //ask pattern
       return ask(煎饼果子大侠Ref,new 命令.做个煎饼果子(), 最多等你一分钟)
               .toCompletableFuture()
               .thenApply(r -> {
                   System.out.println("老板：大侠已经做好了啊？！");
                   return ((事件.煎饼果子做好了)r).get煎饼果子一份();
               });
    }
}
