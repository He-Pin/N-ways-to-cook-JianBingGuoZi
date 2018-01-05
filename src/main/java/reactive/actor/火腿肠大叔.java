package reactive.actor;

import akka.actor.AbstractActor;
import reactive.shared.火腿肠;
import reactive.shared.火腿肠工厂;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class 火腿肠大叔 extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(命令.撕火腿肠.class,(cmd) -> {
                    火腿肠 火腿肠一根 = 火腿肠工厂.撕火腿肠();
                    System.out.println("大叔，撕火腿肠");
                    getSender().tell(new 事件.火腿撕好了(火腿肠一根),getSelf());
                })
                .build();
    }
}
