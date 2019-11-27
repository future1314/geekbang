public class ValidPalindrome125 {

    public boolean isPalindrome(String s) {
        if(s.isEmpty() || s.length() < 2){
            return true;
        }

        char[] chars = new char[s.length()];
        int tail = 0;
        for (char c : s.toCharArray()){
            if(!Character.isLetterOrDigit(c)){
                continue;
            }

            chars[tail++] = Character.toLowerCase(c);
        }

        if (tail < 2){
            return true;
        }

        int head = 0;
        tail--;
        while (head <= tail){
            if(chars[head++] != chars[tail--]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome125 v = new ValidPalindrome125();

        System.out.println(v.isPalindrome(
                "A man, a plan, a canal: Panama"));
    }

}
