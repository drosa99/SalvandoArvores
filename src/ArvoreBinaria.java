import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.charset.Charset;

public class ArvoreBinaria {
   // Node raiz;
    static int preIndex = 0;

    public static int profundidaMaxima(Node nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int esqProfundidade = profundidaMaxima(nodo.esquerda) + 1;
            int dirProfundidade = profundidaMaxima(nodo.direita) + 1;

            if (esqProfundidade > dirProfundidade) {
                return (esqProfundidade );
            } else {
                return (dirProfundidade );
            }
        }
    }

    // inicio comeca com 0; fim comeca com tamanho-1
    public static Node constroiArvore(ArrayList<String> central, ArrayList<String> pre, int inicio, int fim) {

        if (inicio > fim) {
            return null;
        }
        Node tNode = new Node(pre.get(preIndex++));
        if (inicio == fim) {
            return tNode;
        }
        int centralIndex = central.indexOf(tNode.elemento);
        tNode.esquerda = constroiArvore(central, pre, inicio, centralIndex - 1);
        tNode.direita = constroiArvore(central, pre, centralIndex + 1, fim);
        return tNode;
    }


    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();

        ArrayList<String> pre = new ArrayList<>();
        ArrayList<String> central = new ArrayList<>();

        Path arq = Paths
                .get("/Users/daniela/Desktop/PUCRS/Algoritmos2/Trabalho1/SalvandoArvores/CasosTeste/caso50.txt");
        System.out.println(arq);
        try (Scanner sc = new Scanner(Files.newBufferedReader(arq, Charset.forName("utf8")))) {
            String aux = "";
            String arvPreAux[] = sc.nextLine().split(" ");
            String arvCen2Aux[] = sc.nextLine().split(" ");

            for (int x = 0; x < arvPreAux.length; x++) {
                pre.add(arvPreAux[x]);
                central.add(arvCen2Aux[x]);
            }
        } catch (IOException x) {
            System.err.format("Erro de E/S: %s%n", x);
        }

        Node nodo = constroiArvore(central, pre, 0, (central.size() - 1));

        int altura = profundidaMaxima(nodo);

        long time2 = System.currentTimeMillis();
        long tempo = time2-time1;

        System.out.println("Altura da arvore:" + altura + "\n Tempo:" + tempo + "ms");

    }
}
