package reactive.sequential;

import reactive.shared.*;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class JBGZ {
    public static void main(String[] args) {
     TimeElasped.run(() -> {
         煎饼 煎饼一张 = 煎饼工厂.做煎饼();
         鸡蛋煎饼 鸡蛋煎饼一张 = 鸡蛋工厂.鸡蛋打在煎饼上(煎饼一张);
         生菜 生菜若干 = 生菜工厂.切生菜();
         火腿肠 火腿肠一根 = 火腿肠工厂.撕火腿肠();
         煎饼果子 好吃的煎饼果子 = 煎饼果子工厂.做煎饼果子(鸡蛋煎饼一张,生菜若干,火腿肠一根);
         System.out.println(好吃的煎饼果子);
     });
    }
}
