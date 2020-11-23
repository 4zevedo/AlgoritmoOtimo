package AlgOtimo;

import java.util.ArrayList;

public class AlgOtimo{

    /*  OBJETIVO:
        A primeira parte do código consiste na criação de 2 vetores e de um contador que irá contar 
        a quantidade de alocações de página, o primeiro vetor contém os dados a serem alocados e o 
        segundo o vetor que representará as 3 posições de memória para alocação dos dados do vetor principal. 
        
		Quando um vetor é criado em Java,exemplo um vetor do tipo Inteiro, as posições são guardadas com o valor 0. 
        O contador guarda o número 3 em sua inicialização, pois como não tem nenhum dado na memória, então o 
        algoritmo não precisa verificar por meio de uma comparação, se o espaço na memoria esa alocado ou não.
     */
	 
    static int[] vPrincipal = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
    static int[] vSecundario = new int[3];
    static int quadPagina = 3;

    //Método principal, primeiro método que o sistema procurará executar quando iniciado.
    public static void main(String[] args) {

        //Laço de repetição que faz as três primeiras alocações de memória e já exibe o resultado em tela.
        for (int i = 0; i < vSecundario.length; i++) {
            System.out.print("[ ");
            vSecundario[i] = vPrincipal[i];

            for (int j = 0; j < vSecundario.length; j++) {
                System.out.printf("%s ", vSecundario[j]);
            }

            System.out.printf("]%n");
        }

        //Laço de repetição que chama o método para alocação de memória.
        for (int i = 3; i < vPrincipal.length; i++) {

            alocMemoria(i, vPrincipal[i]);

        }

        //Exibição da quantidade de Page Hint.
        System.out.printf("total Page Hints alocadas %d %n", quadPagina);

    }

    //Método que recebe a posição da memória para ser alocada.
    static void alocMemoria(int posicao, int numero) {

        //Estrutura de seleção que realiza a verificação(se NÃO existe espaço na memória, para alocar ou não).
        if (!(vSecundario[0] == numero || vSecundario[1] == numero || vSecundario[2] == numero)) {

            //variável que recebe a posição que deve alocar.
            int posicao = compara(posicao, vSecundario[0], vSecundario[1], vSecundario[2]);

            vSecundario[posicao] = numero;
            quadPagina++;

            //Exibição do estado atual da memória.
            System.out.print("[ ");
            for (int j = 0; j < vSecundario.length; j++) {
                System.out.printf("%s ", vSecundario[j]);
            }
            System.out.println("]");

        }

    }

    //Método que compara qual o dado da posição de memória que irá demorar a ser utilizada, e fazendo a substituição desse dado para o novo dado
    static int compara(int posicao, int numero, int numero2, int numero3) {

        int contA = 0;
        int contB = 0;
        int contC = 0;

        for (int i = posicao; i < vPrincipal.length; i++) {

            contA++;
            if (numero == vPrincipal[i]) {
                break;
            }
        }

        for (int i = posicao; i < vPrincipal.length; i++) {

            contB++;
            if (numero2 == vPrincipal[i]) {
                break;
            }
        }

        for (int i = posicao; i < vPrincipal.length; i++) {

            contC++;
            if (numero3 == vPrincipal[i]) {
                break;
            }
        }

        if (contA > contB) {
            if (contA >= contC) {
                return 0;
            }
        }
        if (contB > contA) {
            if (contB >= contC) {
                return 1;
            }
        }
        if (contC > contA) {
            if (contC >= contB) {
                return 2;
            }
        }

        return -1;

    }

}
