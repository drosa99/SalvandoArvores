public class ArvoreBinaria{
    Node raiz;

    public int profundidaMaxima(Node nodo){
        if (nodo == null) { return 0; }
        else {
            int esqProfundidade = profundidaMaxima(nodo.esquerda);
            int dirProfundidade = profundidaMaxima(nodo.direita);

            if (esqProfundidade > dirProfundidade) { return (esqProfundidade + 1);}
            else { return (dirProfundidade +1);}
        }
    }
    
    public static void main(String[] args) 
    {
        ArvoreBinaria arvore = new ArvoreBinaria();
  
        arvore.raiz = new Node("a");
        arvore.raiz.esquerda = new Node("b");
        arvore.raiz.direita = new Node("c");
        arvore.raiz.esquerda.esquerda = new Node("d");
        arvore.raiz.direita.direita = new Node("e");
  
        System.out.println("Height of tree is : " + 
                                      arvore.profundidaMaxima(arvore.raiz));
    }
}
    
    
    // Node root;
  
    // /* Compute the "maxDepth" of a tree -- the number of 
    //    nodes along the longest path from the root node 
    //    down to the farthest leaf node.*/
    // int maxDepth(Node node) 
    // {
    //     if (node == null)
    //         return 0;
    //     else
    //     {
    //         /* compute the depth of each subtree */
    //         int lDepth = maxDepth(node.left);
    //         int rDepth = maxDepth(node.right);
  
    //         /* use the larger one */
    //         if (lDepth > rDepth)
    //             return (lDepth + 1);
    //          else
    //             return (rDepth + 1);
    //     }
    // }
