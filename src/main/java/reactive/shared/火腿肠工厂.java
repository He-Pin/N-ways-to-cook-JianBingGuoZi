package reactive.shared;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class 火腿肠工厂 {
    public static 火腿肠 撕火腿肠(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new 火腿肠();
    }
}
