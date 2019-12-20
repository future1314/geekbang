import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WrittenTest {

    /*
    1. 2个大数相加
    解法分析：
    1. 使用BigDecimal，最简单，但应该不是出题的本意（放弃）
    2. 两个正整数相加（根据示例得出），允许超出BigInteger的最大值（采用）

    解题思路：
    1. 从低位往高位相加
    2. 每次相加前正确处理前一次运算是否有进位

    复杂度分析：
    时间复杂度 O(n)
    空间复杂度 O(n) 使用了数组、StringBuilder

    参考资料：
    大数相加算法实现 https://blog.csdn.net/YQS_Love/article/details/79210062
    两数相加 https://leetcode-cn.com/problems/add-two-numbers/
     */
    public String bigAdd(String val1, String val2) {
        if (val1 == null || "".equals(val1)) {
            return val2;
        }
        if (val2 == null || "".equals(val2)) {
            return val1;
        }

        int length1 = val1.length();
        int length2 = val2.length();
        int maxLength = length2;
        int minLength = length1;
        char[] maxArr = val2.toCharArray();
        char[] minArr = val1.toCharArray();

        if (length1 > length2) {
            maxLength = length1;
            minLength = length2;
            maxArr = val1.toCharArray();
            minArr = val2.toCharArray();
        }

        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        char zero = '0';
        boolean isCarry = false; // true 发生进位
        int[] resultArr = new int[maxLength + 1]; // +1因为可能进一位
        int resultIndex = resultArr.length - 1;
        int j = minLength - 1;
        for (int i = maxLength - 1; i > -1; i--) {
            int moreValue = maxArr[i];
            int lessValue = j > -1 ? minArr[j--] : 0;
            // 避免使用Integer因自动拆装带来的性能损失
            int addVaue = nums[moreValue - zero] + nums[lessValue - zero];
            if (isCarry) {
                addVaue++;
            }

            if (addVaue > 9) {
                isCarry = true;
            } else {
                isCarry = false;
            }
            resultArr[resultIndex--] = addVaue % 10;
        }

        if (isCarry) {
            resultArr[0] = 1;
        }

        StringBuilder resStr = new StringBuilder();
        for (int i = isCarry ? 0 : 1; i < resultArr.length; i++) {
            resStr.append(resultArr[i]);
        }

        return resStr.toString();
    }

    /*
    2. 以1970/1/1 00:00:00 为基准，输入任意秒数，输出该秒数对应的日期
     */
    public String getDate(Long elapseTime) {
        if (elapseTime < 0) {
            return "时间戳必须大于0";
        }
        Instant instant = Instant.ofEpochMilli(elapseTime);
        ZoneId zone = ZoneOffset.UTC; // 0时区
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.ofInstant(instant, zone).format(formatter);
    }

    /*
    3. 对一个Java文件，提取该文件中的class类包含的所有方法名，不包含内部类
    解法分析：
    1. 通过分析Java文件得到结果，工作量大（放弃）
    2. 将Java文件转换成class文件后，通过类加载器进行加载；再通过反射获取结果（采用）
     */

    /**
     * 省略Java转class的过程
     * 根据class文件获取文件中的所有方法
     *
     * @param path
     * @param className
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public List<String> getMethods(String path, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader mcl = new MyClassLoader(path);
        Class<?> c1 = Class.forName(className, true, mcl);

        Method[] methods = c1.getDeclaredMethods();
        List<String> records = new ArrayList<>(methods.length);
        for (Method method : methods) {
            records.add(method.getName());
        }
        return records;
    }

    /**
     * 自定义类加载器
     */
    static class MyClassLoader extends ClassLoader {

        /**
         * class文件路径
         */
        private String path;

        public MyClassLoader(String path) {
            this.path = path;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            File file = new File(path);
            try {
                byte[] bytes = getClassBytes(file);
                Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
                return c;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return super.findClass(name);
        }

        private byte[] getClassBytes(File file) throws Exception {
            // 这里要读入.class的字节，因此要使用字节流
            FileInputStream fis = new FileInputStream(file);
            FileChannel fc = fis.getChannel();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            WritableByteChannel wbc = Channels.newChannel(baos);
            ByteBuffer by = ByteBuffer.allocate(1024);

            while (true) {
                int i = fc.read(by);
                if (i == 0 || i == -1)
                    break;
                by.flip();
                wbc.write(by);
                by.clear();
            }

            fis.close();

            return baos.toByteArray();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        WrittenTest test = new WrittenTest();

        // 1. 2个大数相加测试
        System.out.println("第一题测试");
        System.out.println("2".equals(test.bigAdd("1", "1")) ? "OK" : "ERROR");
        System.out.println("246".equals(test.bigAdd("123", "123")) ? "OK" : "ERROR");
        System.out.println("240".equals(test.bigAdd("120", "120")) ? "OK" : "ERROR");
        System.out.println("500".equals(test.bigAdd("250", "250")) ? "OK" : "ERROR");
        System.out.println("4294967294".equals(test.bigAdd(Integer.MAX_VALUE + "", Integer.MAX_VALUE + "")) ? "OK" : "ERROR");
        System.out.println("18446744073709551614".equals(test.bigAdd(Long.MAX_VALUE + "", Long.MAX_VALUE + "")) ? "OK" : "ERROR");
        System.out.println("22222222222222222222222222222222222222222222222222"
                .equals(test.bigAdd("11111111111111111111111111111111111111111111111111",
                        "11111111111111111111111111111111111111111111111111")) ? "OK" : "ERROR");
        System.out.println("22222222222222222222222222222222222222222222222238"
                .equals(test.bigAdd("11111111111111111111111111111111111111111111111119",
                        "11111111111111111111111111111111111111111111111119")) ? "OK" : "ERROR");
        System.out.println("30222222222222222222222222222222222222222222222238"
                .equals(test.bigAdd("15111111111111111111111111111111111111111111111119",
                        "15111111111111111111111111111111111111111111111119")) ? "OK" : "ERROR");

        System.out.println();
        System.out.println("第二题测试");
        System.out.println("1970-01-01 00:00:00".equals(test.getDate(0L)) ? "OK" : "ERROR");

        System.out.println();
        System.out.println("第三题测试");
        List<String> methods = test.getMethods("../WrittenTest.class", "WrittenTest");
        for (String method : methods) {
            System.out.println(method);
        }
    }
}
