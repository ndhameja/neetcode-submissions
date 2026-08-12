class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(Character c: word.toCharArray()){
            curr.children.putIfAbsent(c,new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isEndOfWord=true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(Character c: word.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
            curr=curr.children.get(c);
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(Character c : prefix.toCharArray()){
            if(!curr.children.containsKey(c))
                return false;
        curr=curr.children.get(c);
        }
        return true;
        
    }

    class TrieNode{
        boolean isEndOfWord;
        HashMap<Character,TrieNode> children;
        public TrieNode(){
            isEndOfWord = false;
            children = new HashMap<>();
        }
    }
}
