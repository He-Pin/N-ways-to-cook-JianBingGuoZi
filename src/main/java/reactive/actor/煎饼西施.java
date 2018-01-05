package reactive.actor;

import akka.actor.AbstractActor;
import reactive.shared.煎饼;
import reactive.shared.煎饼工厂;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class 煎饼西施 extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(命令.做煎饼.class,(msg) -> {
                    煎饼 煎饼一张 = 煎饼工厂.做煎饼();
                    System.out.println("西施，做煎饼");
                    getSender().tell(new 事件.煎饼做好了(煎饼一张),getSelf());
                })
                .build();
    }
}
