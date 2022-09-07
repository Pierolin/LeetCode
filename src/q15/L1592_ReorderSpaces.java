package q15;

/**
 * 1592. 重新排列单词间的空格
 * Rearrange Spaces Between Words
 * https://leetcode.cn/problems/rearrange-spaces-between-words/
 */
public class L1592_ReorderSpaces {
    /**
     * 方法一：正则表达洁 (虽然简洁但执行效率不高)
     * TC: O(n)
     * SC: O(n)
     */

    public String reorderSpaces_2(String text) {
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;
        int spaceCount = (int) text.chars().filter(x -> x == ' ').count();
        if (wordCount == 1) return words[0].concat(" ".repeat(spaceCount));

        String splitSpaces = " ".repeat(spaceCount / (wordCount - 1));
        String restSpaces = " ".repeat(spaceCount % (wordCount - 1));
        return String.join(splitSpaces, words).concat(restSpaces);
    }

    /**
     * 方法一：遍历模拟
     * TC: O(n)
     * SC: O(n)
     */
    public String reorderSpaces(String text) {
        int len = text.length();
        int spaceCount = 0;
        int wordCount = 0;
        for (int i = 0; i < len; i++) {
            char letter = text.charAt(i);
            if (letter == ' ') {
                spaceCount++;
                if (i > 0 && text.charAt(i - 1) != ' ') {
                    wordCount++;
                }
            } else {
                if (i == len - 1) wordCount++;
            }
        }

        int betweenSpaceCount = (wordCount > 1 ? spaceCount / (wordCount - 1) : spaceCount);
        int remainSpaceCount = (wordCount > 1 ? spaceCount % (wordCount - 1) : spaceCount);
        StringBuffer sbSpace = new StringBuffer();
        for (int i = 0; i < betweenSpaceCount; i++) sbSpace.append(" ");
        String spaces = sbSpace.toString();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            char letter = text.charAt(i);
            if (letter == ' ') {
                if (i > 0 && text.charAt(i - 1) != ' ' && sb.length() + remainSpaceCount < len) {
                    sb.append(spaces);
                }
            } else {
                sb.append(letter);
            }
        }

        for (int i = 0; i < remainSpaceCount; i++) sb.append(" ");
        return sb.toString();
    }
}
