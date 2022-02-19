import org.w3c.dom.Node;

import java.util.List;

public class TreeConsec {
    private  int ans = 0;
    class Node{
        int data;
        List<Node> childList;
    }
    private void maxConsecutiveInTree (Node node, int max){
        //checking null
        if(node == null){
            return ;
        }
        //leaf node
        if(node.childList.size() == 0){
            return ;
        } else {
            int currentEle = node.data;
            for(int i=0; i<node.childList.size();i++){
                Node childNode = node.childList.get(i);
                if(childNode.data+1 == currentEle){
                    ans = Math.max(ans, max+1);
                    maxConsecutiveInTree(childNode, max+1);
                } else {
                    maxConsecutiveInTree(childNode, 1);
                }
            }
        }
    }


    public static void main(String [] args){
        if(root == null){
            return 0;
        } else if (root.childList.size() == 0){
            return 1;
        }
        maxConsecutiveInTree(root, 1);
    }
}

1->2->3->4->5->7.






