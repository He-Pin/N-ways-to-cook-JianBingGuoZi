package reactive.actor;

import reactive.shared.煎饼;

/**
 * kerr
 **/
public interface 命令 {
    public static class 做煎饼 implements 命令 {
    }

    public static class 鸡蛋打在煎饼上 implements 命令 {
        private final 煎饼 煎饼一张;

        public 鸡蛋打在煎饼上(煎饼 煎饼一张) {
            this.煎饼一张 = 煎饼一张;
        }

        public 煎饼 get煎饼一张() {
            return 煎饼一张;
        }
    }

    public static class 切生菜 implements 命令 {
    }

    public static class 撕火腿肠 implements 命令 {
    }

    public static class 煎饼果子来一个 implements 命令 {
    }

    public static class 做个煎饼果子 implements 命令 {
    }

    public static class 做鸡蛋煎饼 implements 命令 {
    }


}



