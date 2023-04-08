import java.util.*;

public class Main {
    static final int max = 4; // Define o tamanho da cache com 4 posições

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> cache = new LinkedHashMap<Integer, String>() { // Criação da cache
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) { // Função que remove o último adicionado
                return size() > max; // Se o tamanho da cache for maior que 4, a função executará
            }
        };
        Scanner in = new Scanner(System.in);
        String dado;
        int escolha;
        int key = -1;

        if (cache.size() < max) {
            do {
                System.out.print("Digite para armazenar na memória: ");
                dado = in.next();
                if (cache.containsValue(dado)){ //Confere se o dado já esta armazenado na cache
                    System.out.println("A cache já possui esta entrada.");
                }
                else{
                    key++;
                    cache.put(key, dado);
                    System.out.println(cache.values());
                }
            } while (cache.size() < max);
        }

        if (cache.size() == max) {
            System.out.println("Espaço de armazenamento esgotado, você quer continuar armazenando dados?");
            System.out.println("[1] - Sim, continuar");
            System.out.println("[2] - Não, sair");
            escolha = in.nextInt();
            while(escolha == 1){
                System.out.print("Digite para armazenar na memória: ");
                dado = in.next();
                if (cache.containsValue(dado)){//Confere se o dado já esta armazenado na cache
                    System.out.println("A cache já possui esta entrada.");
                }
                else{
                    key++;
                    cache.put(key, dado);
                    System.out.println(cache.value());
                    System.out.println();
                    System.out.println("Você quer continuar armazenando dados?");
                    System.out.println("[1] - Sim, continuar");
                    System.out.println("[2] - Não, sair");
                    escolha = in.nextInt();
                }
             }
        }
    }
}
