package hard;

import java.util.*;

public class Question127 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladderLength("hit", "cog", list));
    }

    /**
     * Returns the length of the shortest transformation sequence from beginWord to endWord.
     * Each transformation must change exactly one letter and exist in the word list.
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Use a HashSet for quick lookups
        Set<String> wordlist1 = new HashSet<>(wordList);
        if (!wordlist1.contains(endWord)) {
            return 0;
        }
        // BFS setup
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> searched = new HashSet<>();
        searched.add(beginWord);
        int steps = 1; // initial step includes beginWord

        while (!queue.isEmpty()) {
            int size = queue.size(); // Ensure we process one level at a time
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                // Generate all valid one-letter transformations
                List<String> list = possibleTransform(poll, wordList);
                for (String transForm : list) {
                    if (transForm.equals(endWord))
                        return steps + 1; // Found path, and the endWord is in the next level, so we should plus one
                    if (!searched.contains(transForm)) {
                        queue.add(transForm);
                        searched.add(transForm);
                    }
                }
            }
            steps++;
        }
        return 0;  // No valid path found
    }

    /**
     * Returns a list of words from wordList that differ from the given word by exactly one character.
     */
    private static List<String> possibleTransform(String poll, List<String> wordList) {
        List<String> possible = new ArrayList<>();
        wordList.forEach(v -> {
            int notSame = 0;
            for (int i = 0; i < v.length(); i++) {
                if (v.charAt(i) != poll.charAt(i))
                    notSame++;
            }
            // Add word if it differs by exactly one character
            if (notSame == 1)
                possible.add(v);
        });
        return possible;
    }
}
