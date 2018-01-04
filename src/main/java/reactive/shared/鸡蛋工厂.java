package reactive.shared;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class 鸡蛋工厂 {
    public static 鸡蛋 打鸡蛋(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new 鸡蛋();
    }
}
