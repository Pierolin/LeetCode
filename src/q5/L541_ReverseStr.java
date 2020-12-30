package q5;

/**
 * 541. 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class L541_ReverseStr {

    public class ReverseStr {
        /**
         * 方法一：双指针
         * TC: O(n)
         * SC: O(n)
         * 解题关键：
         * 1. 转换为 char 数组，直接交换数组里的元素，最后再把反转后的数组转换回字符串
         * 2. 注意最后一组转换的右指针边界，通过 Math.min 巧妙取得每组转换的边界
         */
        public String reverseStr_1(String s, int k) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i += 2 * k) {
                int l = i;
                int r = Math.min(l + k - 1, chars.length - 1);
                while (l < r) {
                    char temp = chars[l];
                    chars[l++] = chars[r];
                    chars[r--] = temp;
                }
            }
            return new String(chars);
        }

        /**
         * 方法二：重组字符串
         * TC: O(n)
         * SC: O(n)
         * 解题关键：
         * 1. 转换为 char 数组，通过 StringBuilder 重建字符串;
         * 2. 如题可知每隔 k 个字符就可始反转，用 ！reversable 判断当前组是否要反转;
         * 3. 最后一组长度如果小于 k, 则把 k 修改为 最后 1 组的长度。
         */
        public String reverseStr_2(String s, int k) {
            if (s == null) return null;
            if (k < 2) return s;

            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();

            boolean reversable = true;
            for (int i = 0; i < chars.length; i += k) {
                if (i + k > chars.length) k = chars.length % k;
                for (int j = 0; j < k; j++) {
                    if (reversable) {
                        sb.append(chars[i + k - 1 - j]);
                    } else {
                        sb.append(chars[i + j]);
                    }
                }
                reversable = !reversable;
            }
            return sb.toString();
        }
    }
}

