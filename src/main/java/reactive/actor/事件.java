package reactive.actor;

import reactive.shared.*;

/**
 * kerr
 **/
public interface 事件 {
    public static class 煎饼做好了 implements 事件 {
        private final 煎饼 煎饼一张;

        public 煎饼做好了(煎饼 煎饼一张) {
            this.煎饼一张 = 煎饼一张;
        }

        public 煎饼 get煎饼一张() {
            return 煎饼一张;
        }
    }

    public static class 鸡蛋煎饼做好了 implements 事件 {
        private final 鸡蛋煎饼 鸡蛋煎饼一张;

        public 鸡蛋煎饼做好了(鸡蛋煎饼 鸡蛋煎饼一张) {
            this.鸡蛋煎饼一张 = 鸡蛋煎饼一张;
        }

        public 鸡蛋煎饼 get鸡蛋煎饼一张() {
            return 鸡蛋煎饼一张;
        }
    }

    public static class 生菜切好了 implements 事件 {
        private final 生菜 生菜若干;

        public 生菜切好了(生菜 生菜若干) {
            this.生菜若干 = 生菜若干;
        }

        public 生菜 get生菜若干() {
            return 生菜若干;
        }
    }

    public static class 火腿撕好了 implements 事件 {
        private final 火腿肠 火腿肠一根;

        public 火腿撕好了(火腿肠 火腿肠一根) {
            this.火腿肠一根 = 火腿肠一根;
        }

        public 火腿肠 get火腿肠一根() {
            return 火腿肠一根;
        }
    }

    public static class 煎饼果子做好了 implements 事件 {
        private final 煎饼果子 煎饼果子一份;

        public 煎饼果子做好了(煎饼果子 煎饼果子一份) {
            this.煎饼果子一份 = 煎饼果子一份;
        }

        public 煎饼果子 get煎饼果子一份() {
            return 煎饼果子一份;
        }
    }
}
