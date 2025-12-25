public class FindPrefix {
    public static class Node{
        Node child[]=new Node[26];
        boolean ewo;
        int fre;
        public Node(){
            for(int i=0;i<26;i++){
                child[i]=null;
            }
            fre=1;
            ewo=false;
        }
    }
    public static Node root=new Node();
    public void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            else{
                curr.child[idx].fre++;
            }

        }
        curr.ewo=true;
    }
    public static void FindPrefix(Node root,String ans){
        if(root==null){
            return;
        }
        if(root.fre==1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<26;i++){
            if(root.child[i]!=null){
                FindPrefix(root.child[i], ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        String words[]={"zebra","dog","duck","dove"};
        FindPrefix t=new FindPrefix();
        for(String s:words){
            t.insert(s);
        }
        FindPrefix(root,"");
    }
}
