public class Trie {
     
    public static  class Node{
        Node []child=new Node[26];
        boolean ew;
        Node(){
            for(int i=0;i<26;i++){
                child[i]=null;
            }
        }
    }

    public static Node root = new Node();

    public void insert(String word){
        Node curr=root;
        for (int i = 0; i < word.length(); i++) {
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            curr=curr.child[idx];
        }
        curr.ew=true;
    }
    public boolean search(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
        }
        return curr.ew==true;
    }
     public static void main(String[] args) {
        Trie t=new Trie();
        String word[]={"apple","app","mango","man","woman"};
        for(String s:word){
            t.insert(s);
        }
        System.out.println(t.search("app"));
     }
   
}
