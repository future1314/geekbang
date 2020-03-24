package interview.counter;

import java.util.List;

public class StatData {

    // 最近10秒的每秒平均计数量
    public long last10SecondAverage;

    // 最近10分钟的每分钟平均计数量
    public long last10MinuteAverage;

    // 最近60分钟的每分钟平均计数量
    public long last60MinuteAverage;

    // 最近60秒的每秒计数量的集合
    public List<Long> last60SecondHistory;
}
