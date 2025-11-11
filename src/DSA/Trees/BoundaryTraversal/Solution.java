package DSA.Trees.BoundaryTraversal;


import java.util.ArrayList;
import java.util.Collections;

class Solution {

    private boolean isleaf(Node root){
        return (root.left==null && root.right==null);
    }

    private void findLeft(Node root,ArrayList<Integer>ans){
        Node curr= root.left;

        while(curr!=null){
            if (!isleaf(curr)) ans.add(curr.data);

            if(curr.left!=null) curr= curr.left;
            else curr= curr.right;
        }
    }

    private void findRight(Node root,ArrayList<Integer> ans){

        ArrayList<Integer> temp= new ArrayList<>();
        Node curr= root.right;
        while(curr!=null){
            if(!isleaf(curr)) temp.add(curr.data);
            if (curr.right!=null) curr= curr.right;
            else curr= curr.left;
        }

        Collections.reverse(temp);
        ans.addAll(temp);
    }

    private void findLeaves(Node root,ArrayList<Integer> ans ){
        if (root==null)  return ;
        if (isleaf(root)) ans.add(root.data);

        findLeaves(root.left,ans);
        findLeaves(root.right,ans);

    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer>ans= new ArrayList<>();

        if (root == null) return ans;

        if (!isleaf(root)) ans.add(root.data);


        findLeft(root,ans);
        findLeaves(root,ans);
        findRight(root,ans);

        return ans;

    }
}
