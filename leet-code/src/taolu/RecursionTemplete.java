package taolu;

/**
 * 递归模板
 */
public class RecursionTemplete {

    /*
    学习要点：
    1. 避免人肉递归（初学时可以手动画递归状态树），要从函数本身开始写
    2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
    3. 数学归纳法思维
     */

    public void recursion(int level, int param) {
        // 1. terminator 终结条件
        if (level > MAX_LEVEL) {
            // process result
            return;
        }

        // 2. process current logic 处理当前层逻辑
        process(level, param);

        // 3. drill down 进入下一层
        recursion(level + 1, param + 1);

        // 4. restore current status 必要的时候清理当前层状态
    }

    private void process(int level, int param) {
    }

    private int MAX_LEVEL = 9;
}
