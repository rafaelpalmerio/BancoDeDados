/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados;

import java.io.IOException;

/**
 *
 * @author Rafael
 */
public class BancoDeDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BancoDeDadosInfoAluno Banco = new BancoDeDadosInfoAluno("D:\\Banco.txt"); // colocar o local correto de onde o arquivo está
        //BancoDeDadosInfoAluno Banco = new BancoDeDadosInfoAluno();
        //Usar o construtor acima quando não for lido um arquivo
        Banco.InsereAluno("Abelardo", "Da", "Silva", "8581111", "Avenida Ibirapuera", "139", "04461-010");
        Banco.InsereAluno("Milena", "De", "Paula", "8581113", "Rua Teleco", "9", "04141-010");
        Banco.InsereAluno("Matheus", "Mello", "Bonini", "8581112", "Rua das Aves", "312", "01201-010");
        Banco.DeletaAluno("8581114");
        InfoAluno Busca = Banco.BuscaAluno("nome", "Abelardo");
        if (Busca != null){ //Mostra os resultados da busca
            System.out.print("Resultado da busca: " + Busca.PegaNome()+" ");
            System.out.print(Busca.PegaNomeDoMeio()+" ");
            System.out.print(Busca.PegaSobrenome()+", ");
            System.out.print(Busca.PegaNUSP()+", ");
            System.out.print(Busca.PegaEndereco()+", ");
            System.out.print(Busca.PegaComplemento()+", ");
            System.out.println(Busca.PegaCEP()+".");
        }
        InfoAluno Atual = Banco.PegaHead_nome();
        System.out.println("Lista em ordem de nomes: ");
        for(int i = 0; i<Banco.PegaNumeroDeAlunos(); i++){ //os próximos laços imprimem as três listas ligadas
            System.out.print("  " + Atual.PegaNome()+" ");
            System.out.print(Atual.PegaNomeDoMeio()+" ");
            System.out.print(Atual.PegaSobrenome()+", ");
            System.out.print(Atual.PegaNUSP()+", ");
            System.out.print(Atual.PegaEndereco()+", ");
            System.out.print(Atual.PegaComplemento()+", ");
            System.out.println(Atual.PegaCEP()+".");
            Atual = Atual.PegaNext_nome();            
        }
        Atual = Banco.PegaHead_sobrenome();
        System.out.println("Lista em ordem de sobrenomes: ");
        for(int i = 0; i<Banco.PegaNumeroDeAlunos(); i++){
            System.out.print("  " + Atual.PegaNome()+" ");
            System.out.print(Atual.PegaNomeDoMeio()+" ");
            System.out.print(Atual.PegaSobrenome()+", ");
            System.out.print(Atual.PegaNUSP()+", ");
            System.out.print(Atual.PegaEndereco()+", ");
            System.out.print(Atual.PegaComplemento()+", ");
            System.out.println(Atual.PegaCEP()+".");
            Atual = Atual.PegaNext_sobrenome();
        }
        Atual = Banco.PegaHead_nusp();
        System.out.println("Lista em ordem de nusp: ");
        for(int i = 0; i<Banco.PegaNumeroDeAlunos(); i++){
            System.out.print("  " + Atual.PegaNome()+" ");
            System.out.print(Atual.PegaNomeDoMeio()+" ");
            System.out.print(Atual.PegaSobrenome()+", ");
            System.out.print(Atual.PegaNUSP()+", ");
            System.out.print(Atual.PegaEndereco()+", ");
            System.out.print(Atual.PegaComplemento()+", ");
            System.out.println(Atual.PegaCEP()+".");
            Atual = Atual.PegaNext_nusp();
        }
        try{
            Banco.ArmazenaEmArquivo("Banco de dados");
        }
        catch(IOException e){
            System.out.println("O armazenamento falhou");
        }
        
    
    }
}
