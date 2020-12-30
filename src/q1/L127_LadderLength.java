package q1;

import java.util.*;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 */
public class L127_LadderLength {
    /**
     * 方法一：BFS
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionarySet = new HashSet<>(wordList);
        if (wordList.size() == 0 && !dictionarySet.contains(endWord)) {
            return 0;
        }
        dictionarySet.remove(beginWord);

        Set<String> visitedSet = new HashSet<>();
        Deque<String> wordQueue = new ArrayDeque<>();
        visitedSet.add(beginWord);
        wordQueue.add(beginWord);

        int steps = 1;

        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();
            for (int i = 0; i < size; i++) {
                String word = wordQueue.poll();
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == chars[j]) continue;
                        chars[j] = c;
                        String tempWord = String.valueOf(chars);
                        if (tempWord.equals(endWord)) return steps + 1;
                        if (visitedSet.contains(tempWord)) continue;
                        if (dictionarySet.contains(tempWord)) {
                            wordQueue.add(tempWord);
                            visitedSet.add(tempWord);
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            steps++;
        }
        return 0;
    }

}
