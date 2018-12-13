package stringmanipulation;

/**
 * Remove Consecutive characters from string.
 *
 * Input: ahfijgwdexyz
 * Output: ah
 *  1.Remove consecutive char i,j -> ahfgwdexyz
 *  2.Remove consecutive char f,g -> ahwdexyz
 *  3.Remove consecutive char d,w -> ahwxyz
 *  4.Remove consecutive char w,x,y,z -> ah
 *
 *  Input: abcdefgh
 *  Output: empty
 *
 *  Input: aherks
 *  Output: aherks
 */
public class RemoveConsecutiveChar {
    public static void main(String[] args) {
        String s = "aghijwzyz";
        char[] charArr = s.toCharArray();
        boolean bFound = true;
        while (bFound) {
            bFound = false;
            for (int i = 0; i < charArr.length; i++) {
                int currentIndex = i;
                while (charArr.length > i + 1 && checkForConsecutive(charArr[i], charArr[i + 1])) {
                    i = i + 1;
                }
                if (currentIndex != i) {
                    bFound = true;
                    char[] newArr = new char[charArr.length - (i + 1 - currentIndex)];
                    System.arraycopy(charArr, 0, newArr, 0, currentIndex);
                    System.arraycopy(charArr, i + 1, newArr, currentIndex, charArr.length - i - 1);
                    charArr = newArr;
                    break;
                }

            }
        }
        for (int i = 0; i < charArr.length; i++) {
            System.out.print(charArr[i]);
        }
    }

    private static boolean checkForConsecutive(int current, int next) {
        return next - current == 1;
    }

}
