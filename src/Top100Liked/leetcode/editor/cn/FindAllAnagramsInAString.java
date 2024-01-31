// 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
//
//
//
// 示例 1:
//
//
// 输入: s = "cbaebabacd", p = "abc"
// 输出: [0,6]
// 解释:
// 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
// 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//
//
// 示例 2:
//
//
// 输入: s = "abab", p = "ab"
// 输出: [0,1,2]
// 解释:
// 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
// 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
// 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//
//
//
//
// 提示:
//
//
// 1 <= s.length, p.length <= 3 * 10⁴
// s 和 p 仅包含小写字母
//
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1372 👎 0

package Top100Liked.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            char[] sCharArray = s.toCharArray(), pCharArray = p.toCharArray();
            int right = 0, sLength = sCharArray.length, pLength = pCharArray.length;
            List<Integer> result = new ArrayList<>();
            if (pLength > sLength || 0 == sLength) {
                return result;
            }
            int[] sArr = new int[26], pArr = new int[26];
            for (int i = 0; i < pLength; i++) {
                pArr[pCharArray[i] - 'a']++;
                sArr[sCharArray[i] - 'a']++;
            }
            if (Arrays.equals(pArr, sArr)) {
                result.add(0);
            }
            for (int i = 0; i < (sCharArray.length - pLength); i++) {
                sArr[sCharArray[i] - 'a']--;
                sArr[sCharArray[i + pLength] - 'a']++;
//                String string = IntStream.range(0, sArr.length)
//                        .filter(index -> sArr[index] != 0)
//                        .mapToObj(index -> String.valueOf((char) (index + 'a')))
//                        .collect(Collectors.joining());
                if (Arrays.equals(pArr, sArr)) {
                    result.add(i + 1);
                }
            }
            return result;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
