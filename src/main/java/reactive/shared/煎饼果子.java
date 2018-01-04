package reactive.shared;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class 煎饼果子 {
    public final 煎饼 煎饼一张;
    public final 鸡蛋 鸡蛋一个;
    public final 生菜 生菜若干;
    public final 火腿肠 火腿肠一根;

    public 煎饼果子(煎饼 煎饼一张, 鸡蛋 鸡蛋一个, 生菜 生菜若干, 火腿肠 火腿肠一根) {
        this.煎饼一张 = 煎饼一张;
        this.鸡蛋一个 = 鸡蛋一个;
        this.生菜若干 = 生菜若干;
        this.火腿肠一根 = 火腿肠一根;
    }

    @Override
    public String toString() {
        return "好吃的煎饼果子勒";
    }
}
