import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ValidPalindrome125 {

    public boolean isPalindrome(String s) {
        if(s.isEmpty() || s.length() < 2){
            return true;
        }

        char[] chars = s.toCharArray();
        int head = 0;
        int tail = chars.length - 1;

        char cHead, cTail;
        boolean usedHead = false;
        boolean usedTail = false;

        while (head <= tail){
            cHead = chars[head];
            cTail = chars[tail];

            boolean flagHead = true;
            boolean flagTail = true;
            if(!Character.isLetterOrDigit(cHead)){
                head++;
                flagHead = false;
            }
            if(!Character.isLetterOrDigit(cTail)){
                tail--;
                flagTail = false;
            }
            if (flagHead && flagTail && Character.toLowerCase(cHead) != Character.toLowerCase(cTail)){
                return false;
            }

            head++;
            tail--;
        }

        return true;
    }

    public static void main(String[] args) {
        int result = 6 % 5;
        System.out.println(result);
        AtomicInteger atomicInteger;
        ArrayQueue arrayQueue;
        HashMap hashMap = new HashMap(9);
        hashMap.put("", "");
        System.out.println();

    }

}
