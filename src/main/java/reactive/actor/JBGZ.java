package reactive.actor;

import akka.actor.ActorSystem;
import akka.actor.Props;
import reactive.shared.TimeElasped;
import reactive.shared.煎饼果子;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.math.BigDecimal;
import java.util.concurrent.TimeoutException;

/**
 * kerr
 **/
public class JBGZ {
    private static final ActorSystem ACTOR_SYSTEM = ActorSystem.apply();

    public static void main(String[] args) throws TimeoutException, InterruptedException {
        门店 煎饼果子专营店 = new 门店(
                ACTOR_SYSTEM.actorOf(Props.create(老板.class),"manager")
        );
        TimeElasped.run(() -> {
            煎饼果子 西施煎饼果子 = 煎饼果子专营店
                    .买好吃美味的西施煎饼果子勒(new BigDecimal(7))
                    .join();
            System.out.println(西施煎饼果子);
        });
        Await.ready(ACTOR_SYSTEM.terminate(), Duration.Inf());
    }
}
