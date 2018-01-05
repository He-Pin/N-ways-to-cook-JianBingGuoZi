package reactive.shared;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class 煎饼果子工厂 {
    public static 煎饼果子 做煎饼果子(鸡蛋煎饼 鸡蛋煎饼一张, 生菜 生菜若干, 火腿肠 火腿肠一根){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new 煎饼果子(鸡蛋煎饼一张,生菜若干, 火腿肠一根);
    }
}
