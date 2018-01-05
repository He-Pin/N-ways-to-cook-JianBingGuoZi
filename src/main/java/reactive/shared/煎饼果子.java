package reactive.shared;

/**
 * kerr
 **/
public class 煎饼果子 {
    private final 鸡蛋煎饼 鸡蛋煎饼一张;
    private final 生菜 生菜若干;
    private final 火腿肠 火腿肠一根;

    public 煎饼果子(鸡蛋煎饼 鸡蛋煎饼一张, 生菜 生菜若干, 火腿肠 火腿肠一根) {
        this.鸡蛋煎饼一张 = 鸡蛋煎饼一张;
        this.生菜若干 = 生菜若干;
        this.火腿肠一根 = 火腿肠一根;
    }

    public 鸡蛋煎饼 get鸡蛋煎饼一张() {
        return 鸡蛋煎饼一张;
    }

    public 生菜 get生菜若干() {
        return 生菜若干;
    }

    public 火腿肠 get火腿肠一根() {
        return 火腿肠一根;
    }

    @Override
    public String toString() {
        return "好吃的煎饼果子勒";
    }
}
