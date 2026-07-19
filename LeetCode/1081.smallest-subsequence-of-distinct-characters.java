import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] used = new boolean[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']--;

            if (used[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peekLast() > c
                    && freq[stack.peekLast() - 'a'] > 0) {
                used[stack.pollLast() - 'a'] = false;
            }

            stack.offerLast(c);
            used[c - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pollFirst());
        }

        return ans.toString();
    }
}