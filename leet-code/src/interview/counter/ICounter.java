package interview.counter;

/**
 * 通用计数器模块接口ICounter，用于系统内部的请求量计数，
 * 多个线程会频繁调用hit()方法进行计数
 *
 * 请实现ICounter接口(请关注接口实现，不需要写测试用例)，并满足以下要求：
 *  1.功能实现
 *  2.性能问题
 *  3.线程安全
 *  4.连续运行一年，内存不溢出
 */
public interface ICounter {

    // 调用一次，计数加1
    void hit();

    // 获取当前的计数统计状态
    StatData getStat();
}
