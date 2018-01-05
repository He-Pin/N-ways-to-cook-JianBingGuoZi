package reactive.actor;

import akka.actor.ActorRef;
import akka.util.Timeout;
import reactive.shared.煎饼果子;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static akka.pattern.PatternsCS.ask;

/**
 * kerr
 **/
public class 门店 {
    private final ActorRef 老板Ref;

    public 门店(ActorRef 老板Ref) {
        this.老板Ref = 老板Ref;
    }
    private static final Timeout 最多等你两分钟 = Timeout.apply(2, TimeUnit.MINUTES);

    public CompletableFuture<煎饼果子> 买好吃美味的西施煎饼果子勒(BigDecimal moneyInYuan){

        return ask(老板Ref,new 命令.煎饼果子来一个(),最多等你两分钟)
                .toCompletableFuture()
                .thenApply(r -> (煎饼果子)r);
    }
}
