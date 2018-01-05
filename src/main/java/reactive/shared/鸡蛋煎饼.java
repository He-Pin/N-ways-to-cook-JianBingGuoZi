package reactive.shared;

/**
 * kerr
 **/
public class 鸡蛋煎饼 implements 食材 {
    private final 鸡蛋 鸡蛋一个;
    private final 煎饼 煎饼一张;

    public 鸡蛋煎饼(鸡蛋 鸡蛋一个, 煎饼 煎饼一张) {
        this.鸡蛋一个 = 鸡蛋一个;
        this.煎饼一张 = 煎饼一张;
    }

    public 鸡蛋 get鸡蛋一个() {
        return 鸡蛋一个;
    }

    public 煎饼 get煎饼一张() {
        return 煎饼一张;
    }
}
