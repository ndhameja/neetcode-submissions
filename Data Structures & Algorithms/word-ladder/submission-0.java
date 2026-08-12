class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level =1;
        while(!queue.isEmpty()){
            int size= queue.size();

            for(int i=0;i<size;i++){
                String curr = queue.poll();
                if(curr.equals(endWord)){
                    return level;
                }

                char[] wordChars = curr.toCharArray();
                for(int j=0;j<wordChars.length;j++){
                    char orgChar = wordChars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == orgChar) continue;

                        wordChars[j]=c;
                        String newWord = new String(wordChars);
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // Mark as visited
                        }
                    }
                    wordChars[j] = orgChar; // Revert character
                }
            }
            level++;
        }
        return 0;
    }
}
