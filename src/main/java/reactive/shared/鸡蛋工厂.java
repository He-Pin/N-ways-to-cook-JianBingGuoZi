package reactive.shared;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class 鸡蛋工厂 {
    public static 鸡蛋煎饼 鸡蛋打在煎饼上(煎饼 煎饼一张){
        鸡蛋 鸡蛋一个 = new 鸡蛋();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new 鸡蛋煎饼(鸡蛋一个,煎饼一张);
    }
}
