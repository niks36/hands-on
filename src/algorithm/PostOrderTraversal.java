package algorithm;

import java.util.ArrayList;
import java.util.List;
/*
 Problem Statement:
 Input: { { i { j { k k } { j g } } { h k {l m }}}
 Every Brace represent scope, need to print from depth element with post order
 Output :
    ---kk
    ---jg
    --j
    ---lm
    --hk
    -i
 */
public class PostOrderTraversal {

    // ---kk
    // --j
    // -i
    public static void main(String[] args) {
        String data = "{ i { j { k k } { j g } } { h k {l m { n o }}}}";
        Node node = new Node();
        for(Character ch : data.toCharArray()){
            if(ch == '{'){
                Node newNode  = new Node();
                newNode.pre = node;
                node.childs.add(newNode);
                node = newNode;
            }else if(ch == '}'){
                node = node.pre;
            }else if(ch != ' '){
                node.characters.add(ch);
            }

        }
        System.out.println(node);
        printNode("",node);

    }

    public static void printNode(String str,Node node){
        for(Node childs: node.childs){
            printNode(str+ "-",childs);
        }
        System.out.print(str);
        node.characters.forEach(System.out::print);
        System.out.println();
    }
}



class Node{
    @Override
    public String toString() {
        return "Node{" +
                "characters=" + characters +
                ", childs=" + childs +
                '}';
    }

    List<Character> characters = new ArrayList<>();
    Node pre;
    List<Node> childs = new ArrayList<>();

}