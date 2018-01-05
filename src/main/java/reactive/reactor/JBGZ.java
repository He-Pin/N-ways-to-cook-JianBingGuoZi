package reactive.reactor;

import akka.NotUsed;
import akka.stream.javadsl.Source;
import reactive.shared.*;
import reactor.core.publisher.Flux;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * kerr
 **/
public class JBGZ {
    public static void main(String[] args) {
        Flux<String> reqFlux = Flux.fromIterable(Collections.singleton("来一个煎饼果子"));

        Flux<煎饼> 煎饼Flux = Flux.fromIterable(new AbstractList<煎饼>() {
            @Override
            public 煎饼 get(int index) {
                System.out.println("生产煎饼:"+index);
                return 煎饼工厂.做煎饼();
            }

            @Override
            public int size() {
                return 100;
            }
        });

        Flux<鸡蛋煎饼> 鸡蛋煎饼Flux = 煎饼Flux.map(煎饼 -> {
            System.out.println("鸡蛋打在煎饼上");
            return 鸡蛋工厂.鸡蛋打在煎饼上(煎饼);
        });


        Flux<生菜> 生菜Flux = Flux.fromIterable(new AbstractList<生菜>() {
            @Override
            public 生菜 get(int index) {
                System.out.println("生产生菜:"+index);
                return 生菜工厂.切生菜();
            }

            @Override
            public int size() {
                return 1;
            }
        });

        Flux<火腿肠> 火腿肠Flux = Flux.fromIterable(new AbstractList<火腿肠>() {
            @Override
            public 火腿肠 get(int index) {
                System.out.println("生产火腿肠:"+index);
                return 火腿肠工厂.撕火腿肠();
            }

            @Override
            public int size() {
                return 1;
            }
        });

        Flux<煎饼果子> 煎饼果子Flux = reqFlux.flatMap(req -> {
            System.out.println(req);
            List<Flux<食材>> fluxs = new ArrayList<>();
            fluxs.add(鸡蛋煎饼Flux.cast(食材.class));
            fluxs.add(生菜Flux.cast(食材.class));
            fluxs.add(火腿肠Flux.cast(食材.class));
            return Flux.zip(fluxs, 1, (Function<Object[], 煎饼果子>) 食材List -> {
                鸡蛋煎饼 鸡蛋煎饼一张 = (鸡蛋煎饼) 食材List[0];
                生菜  生菜若干 = (生菜) 食材List[1];
                火腿肠  火腿肠一根 = (火腿肠) 食材List[2];
                煎饼果子 好吃的煎饼果子 = 煎饼果子工厂.做煎饼果子(鸡蛋煎饼一张,生菜若干,火腿肠一根);
                return 好吃的煎饼果子;
            });
        });

        TimeElasped.run(() -> {
            煎饼果子 好吃的煎饼果子 = 煎饼果子Flux.blockFirst();
            System.out.println(好吃的煎饼果子);
        });
    }
}
