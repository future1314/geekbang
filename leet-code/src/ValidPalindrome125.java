import java.util.concurrent.ConcurrentHashMap;

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
        int result = (1 + 6) % 7;
        System.out.println(result);
        ConcurrentHashMap concurrentHashMap;
    }

}
