package reactive.shared;

/**
 * kerr
 **/
public class 煎饼工厂 {
    public static 煎饼 做煎饼(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new 煎饼();
    }
}
