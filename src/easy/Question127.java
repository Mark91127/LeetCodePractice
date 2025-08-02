package easy;

import java.util.*;

public class Question127 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladderLength("hit", "cog", list));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordlist1 = new HashSet<>(wordList);
        if (!wordlist1.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> searched = new HashSet<>();
        searched.add(beginWord);
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                List<String> list = possibleTransform(poll, wordList);
                for (String transForm : list) {
                    if (transForm.equals(endWord))
                        return steps + 1;
                    if (!searched.contains(transForm)) {
                        queue.add(transForm);
                        searched.add(transForm);
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    private static List<String> possibleTransform(String poll, List<String> wordList) {
        List<String> possible = new ArrayList<>();
        wordList.forEach(v -> {
            int notSame = 0;
            for (int i = 0; i < v.length(); i++) {
                if (v.charAt(i) != poll.charAt(i))
                    notSame++;
            }
            if (notSame == 1)
                possible.add(v);
        });
        return possible;
    }
}
