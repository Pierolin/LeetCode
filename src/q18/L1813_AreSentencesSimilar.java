package q18;

public class L1813_AreSentencesSimilar {
    /**
     * 方法一： 使用 startsWith 和 endsWith 进行判断
     * TC: O(min(m, n)) m 和 n 为两个句子的长度
     * SC: O(1)
     */
    public boolean areSentencesSimilar_1(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) return true;
        if (sentence1.length() < sentence2.length()) return areSentencesSimilar_1(sentence2, sentence1);
        if (sentence1.startsWith(sentence2 + " ") || sentence1.endsWith(" " + sentence2)) return true;
        for (int i = 0; i < sentence2.length(); i++) {
            if (sentence2.charAt(i) == ' ') {
                if (sentence1.startsWith(sentence2.substring(0, i + 1)) && sentence1.endsWith(sentence2.substring(i)))
                    return true;
            }
        }
        return false;
    }


    /**
     * 方法二：双指针
     * TC: O(m + n) m 和 n 为两个句子的单词个数
     * SC: O(m + n) m 和 n 为两个句子的单词个数
     */
    public boolean areSentencesSimilar_2(String sentence1, String sentence2) {
        if (sentence1.length() < sentence2.length()) return areSentencesSimilar_2(sentence2, sentence1);
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        int n1 = arr1.length;
        int n2 = arr2.length;
        int l = 0;
        int r = 0;
        while (l < n2 && arr2[l].equals(arr1[l])) l++;
        while (r < n2 && arr2[n2 - 1 - r].equals(arr1[n1 - 1 - r])) r++;
        return l + r >= n2;
    }
}
