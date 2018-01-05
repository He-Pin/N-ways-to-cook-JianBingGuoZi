package reactive.actor;

import akka.actor.AbstractActor;
import reactive.shared.生菜;
import reactive.shared.生菜工厂;

/**
 * kerr
 **/
public class 生菜小二哥 extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(命令.切生菜.class,(cmd) -> {
                    System.out.println("小二哥，切生菜");
                    生菜 生菜若干 = 生菜工厂.切生菜();
                    getSender().tell(new 事件.生菜切好了(生菜若干),getSelf());
                })
                .build();
    }
}
