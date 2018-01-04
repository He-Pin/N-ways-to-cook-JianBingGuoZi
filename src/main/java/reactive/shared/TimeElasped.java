package reactive.shared;

/**
 * 虎鸣 ,hepin.p@alibaba-inc.com
 **/
public class TimeElasped {
    public static final void run(Action action)  {
        System.out.println("开始计时");
        long start = System.currentTimeMillis();
        try {
            action.justDoIt();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + ((end -start) / 1000) + " 秒");
    }
}
