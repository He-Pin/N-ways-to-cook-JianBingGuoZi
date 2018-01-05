package reactive.shared;

/**
 * kerr
 **/
public class 生菜工厂 {
    public static 生菜 切生菜(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new 生菜();
    }
}
