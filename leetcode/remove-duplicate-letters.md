<!-- problem:start -->

# [Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters)

## Description

<!-- description:start -->

<p>Given a string <code>s</code>, remove duplicate letters so that every letter appears once and only once. You must make sure your result is <span data-keyword="lexicographically-smaller-string"><strong>the smallest in lexicographical order</strong></span> among all possible results.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;bcabc&quot;
<strong>Output:</strong> &quot;abc&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cbacdcbc&quot;
<strong>Output:</strong> &quot;acdb&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as 1081: <a href="https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/" target="_blank">https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/</a></p>


<!-- description:end -->

## Solutions

<!-- solution:start -->

<!-- tabs:start -->

#### Java

```java
class Solution {
    public String removeDuplicateLetters(String s) {
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
```

<!-- tabs:end -->

<!-- solution:end -->

<!-- problem:end -->
