package interview.counter;

import java.util.concurrent.atomic.AtomicLong;

public class Counter implements ICounter {

    /*
    1. 用一个环形数组，保存1小时内的数据（3600秒 = 数组长度3600）
      hit(）：
        判断在数组的哪个索引位置 +1
        判断数组的哪个位置失效，置0
      getStat()：
        根据需要从数组中取得数据计算

     0 3599
     1 3598
     2 3597

     3599 3598
     3598 3597
     */

    private AtomicLong[] timeCircular;

    private int TIME_CIRCULAR_SIZE = 3600;

    /**
     * 时间环的头、尾、当前指针
     * 根据index可以计算head、tail
     */
    private volatile int head, tail, index;

    private static Counter counter;

    static {
        counter = new Counter();
    }

    private Counter() {
        this.timeCircular = new AtomicLong[TIME_CIRCULAR_SIZE];
        this.index = 0;
        this.head = 0;
        this.tail = 0;
        initTimeBucket();
        startTimer();
    }

    public static Counter getInstance() {
        return counter;
    }

    @Override
    public void hit() {
        timeCircular[index].incrementAndGet();
    }

    @Override
    public StatData getStat() {
        return null;
    }

    public static void doStat(){

    }

    private void initTimeBucket() {
        for (int i = 0; i < timeCircular.length; i++) {
            timeCircular[i] = new AtomicLong(0L);
        }
    }

    /**
     * 开始计时
     */
    private void startTimer(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000L);
                        index++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public static void main(String[] args) {
//        Counter counter = Counter.getInstance();
        System.out.println(Integer.MAX_VALUE / 31_556_926);
        for (int i = 0; i < 7200; i++) {
            int index = i % 3600;
            System.out.println(i + "  " + index);
        }
    }
}
