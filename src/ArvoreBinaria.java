import java.util.*;

public class ArvoreBinaria{
    Node raiz;
    static int preIndex = 0;

    public static int profundidaMaxima(Node nodo){
        if (nodo == null) { return 0; }
        else {
            int esqProfundidade = profundidaMaxima(nodo.esquerda);
            int dirProfundidade = profundidaMaxima(nodo.direita);

            if (esqProfundidade > dirProfundidade) { return (esqProfundidade + 1);}
            else { return (dirProfundidade +1);}
        }
    }
    //inicio comeca com 0; fim comeca com tamanho-1
    public static Node constroiArvore(ArrayList<String> central, ArrayList<String> pre, int inicio, int fim ) {
        if (inicio > fim) {return null;}
        Node tNode = new Node(pre.get(preIndex++));
        if (inicio == fim) {return tNode;}
        int centralIndex = procura(central, inicio, fim, tNode.elemento);
        tNode.esquerda = constroiArvore(central, pre, inicio, centralIndex - 1);
        tNode.direita = constroiArvore(central, pre, centralIndex + 1, fim);
        return tNode;
    }

    public static int procura(ArrayList<String> arr, int inicio, int fim, String value) 
    {
        int i;
        for (i = inicio; i <= fim; i++) 
        {
            if (arr.get(i) == value)
                return i;
        }
        return i;
    }


    
    public static void main(String[] args) 
    {
        ArvoreBinaria arvore = new ArvoreBinaria();
  
        arvore.raiz = new Node("a");
        arvore.raiz.esquerda = new Node("b");
        arvore.raiz.direita = new Node("c");
        arvore.raiz.esquerda.esquerda = new Node("d");
        arvore.raiz.direita.direita = new Node("e");
        arvore.raiz.direita.esquerda = new Node ("f");
        arvore.raiz.esquerda.esquerda.esquerda = new Node ("g");
  
        System.out.println("Altura da arvore: " + arvore.profundidaMaxima(arvore.raiz));
        
    //     ArrayList <String> pre = new ArrayList<>();
    //     ArrayList <String> central = new ArrayList<>();
        
    //     pre.add("xzpv"); pre.add("xay"); pre.add("xb"); pre.add("v4"); pre.add("rz"); pre.add("s3");
    //     central.add("v4"); central.add("xb"); central.add("s3"); central.add("rz"); central.add("xay"); central.add("xzpv");
        
    //     Node nodo = constroiArvore(central,pre, 0, 5);

    //     int altura = profundidaMaxima(nodo);

    //     System.out.println("Altura da arvore:" + altura);
    // }
}
}
    
    
    