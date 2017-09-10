/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;



/**
 *
 * @author Rafael
 */
public class BancoDeDadosInfoAluno {
    
    private int NumeroDeAlunos;
    
    private InfoAluno Head_nome;
    private InfoAluno Head_sobrenome;
    private InfoAluno Head_nusp;
    
    
    // O Banco de dados é incializado com os Heads nulos
    
    public BancoDeDadosInfoAluno(){
        NumeroDeAlunos = 0;
        Head_nome = null;
        Head_sobrenome = null;
        Head_nusp = null;
    }
    
    
    //o Construtor a seguir recebe um arquivo e faz sua leitura. O formato do arquivo deve ser:
    //nome
    //nome do meio
    //sobrenome
    //número usp
    //endereço
    //complemento
    //cep
    //linha em branco (para melhorar a formatação e vizualizar melhor os alunos individualmente)
    
    
    public BancoDeDadosInfoAluno (String arquivo) throws IOException{
        NumeroDeAlunos = 0;
        FileReader arq;
        BufferedReader ler; 
                
        try{
            arq = new FileReader(arquivo);
            ler = new BufferedReader(arq);
        }
        catch (IOException e){
            System.out.println("Nao foi possivel abrir o arquivo.");  
            return;
        }
        String nome2, nomedomeio2, sobrenome2, nusp2, endereco2, complemento2, cep2, espaco;
        //espaco é para deixar a formatação mais agradavel
        try{
            while((nome2=ler.readLine())!=null){
                nomedomeio2 = ler.readLine();
                sobrenome2 = ler.readLine();
                nusp2 = ler.readLine();
                endereco2 = ler.readLine();
                complemento2 = ler.readLine();
                cep2 = ler.readLine();
                espaco = ler.readLine();
                this.InsereAluno(nome2, nomedomeio2, sobrenome2, nusp2, endereco2, complemento2, cep2);
            }           
        }
        catch (IOException e){
            System.out.println("Houve um erro na leitura do arquivo.");
        }
        arq.close();
        
    }
    
    protected int PegaNumeroDeAlunos(){
        return NumeroDeAlunos;
    }
    
    private void ColocaHead_nome(InfoAluno Head_nome){
        this.Head_nome = Head_nome;        
    }
    
    protected InfoAluno PegaHead_nome(){
        return(this.Head_nome);
    }
    
    private void ColocaHead_sobrenome(InfoAluno Head_sobrenome){
        this.Head_sobrenome = Head_sobrenome;        
    }
    
    protected InfoAluno PegaHead_sobrenome(){
        return(this.Head_sobrenome);
    }
    
    private void ColocaHead_nusp(InfoAluno Head_nusp){
        this.Head_nusp = Head_nusp;        
    }
    
    protected InfoAluno PegaHead_nusp(){
        return(this.Head_nusp);
    }
    
    protected void IncrementaNumeroDeAlunos(){
        NumeroDeAlunos++;
    }
    
    protected void DecrementaNumeroDeAlunos(){
        NumeroDeAlunos--;
    }
    
    
    //A função InsereAluno procura a melhor posição para o novo aluno em cada uma das listas ligadas
    //Para isso, são mantido dois alunos, um atual e outro anterior, atualizados a cada passagem do loop.
    //Para manter o anterior, basta começar no primeiro loop como o Head mas não ser atualizado da primeira vez
    //Quando a posição for encontrada, o Next do Aluno sendo inserido vira o Atual e o next do Anterior vira o Novo
    
    public void InsereAluno(String inpnome, String inpnomedomeio, String inpsobrenome, 
            String inpnusp, String inpendereco, String inpcomplemento, String inpcep){
        InfoAluno Novo = new InfoAluno(inpnome, inpnomedomeio, inpsobrenome, inpnusp, inpendereco, inpcomplemento, inpcep);
        if (NumeroDeAlunos == 0){   
            Head_nome = Novo;
        }
        else if(NumeroDeAlunos >0){
            InfoAluno Atual = Head_nome;
            InfoAluno Anterior = Head_nome;
            boolean colocou = false;
            int i = 0;
            while (i<NumeroDeAlunos && colocou == false){
                if(Novo.PegaNome().compareTo(Atual.PegaNome())<0){
                    if(i==0){
                        Novo.ColocaNext_nome(Atual);
                        ColocaHead_nome(Novo);
                        colocou = true;
                    }                    
                    else if(i>0){
                        Novo.ColocaNext_nome(Atual);
                        Anterior.ColocaNext_nome(Novo);
                        colocou = true;
                    }    
                } 
                else {
                    if (i==(NumeroDeAlunos-1)){
                        Atual.ColocaNext_nome(Novo);
                        colocou = true;
                    }
                    else if(i==0) Atual = Atual.PegaNext_nome();
                    else {
                        Atual = Atual.PegaNext_nome();
                        Anterior = Anterior.PegaNext_nome();
                    }             
                }
                i++;
            
            }           
        }
        if (NumeroDeAlunos == 0){
            Head_sobrenome = Novo;
        }
        else if(NumeroDeAlunos >0){
            InfoAluno Atual = Head_sobrenome;
            InfoAluno Anterior = Head_sobrenome;
            boolean colocou = false;
            int j = 0;
            while (j<NumeroDeAlunos && colocou == false){
                if(Novo.PegaSobrenome().compareTo(Atual.PegaSobrenome())<0){
                    if(j==0){
                        Novo.ColocaNext_sobrenome(Atual);
                        ColocaHead_sobrenome(Novo);
                        colocou = true;
                    }                    
                    else if(j>0){
                        Novo.ColocaNext_sobrenome(Atual);
                        Anterior.ColocaNext_sobrenome(Novo);
                        colocou = true;
                    }    
                } 
                else {
                    if (j==(NumeroDeAlunos-1)){
                        Atual.ColocaNext_sobrenome(Novo);
                        colocou = true;
                    }
                    else if(j==0) Atual = Atual.PegaNext_sobrenome();
                    else {
                        Atual = Atual.PegaNext_sobrenome();
                        Anterior = Anterior.PegaNext_sobrenome();
                    }             
                }
                j++;
            
            }           
        }
        if (NumeroDeAlunos == 0){
            Head_nusp = Novo;
        }
        else if(NumeroDeAlunos >0){
            InfoAluno Atual = Head_nusp;
            InfoAluno Anterior = Head_nusp;
            boolean colocou = false;
            int k = 0;
            while (k<NumeroDeAlunos && colocou == false){
                if(Novo.PegaNUSP().compareTo(Atual.PegaNUSP())<0){
                    if(k==0){
                        Novo.ColocaNext_nusp(Atual);
                        ColocaHead_nusp(Novo);
                        colocou = true;
                    }                    
                    else if(k>0){
                        Novo.ColocaNext_nusp(Atual);
                        Anterior.ColocaNext_nusp(Novo);
                        colocou = true;
                    }    
                } 
                else {
                    if (k==(NumeroDeAlunos-1)){
                        Atual.ColocaNext_nusp(Novo);
                        colocou = true;
                    }
                    else if(k==0) Atual = Atual.PegaNext_nusp();
                    else {
                        Atual = Atual.PegaNext_nusp();
                        Anterior = Anterior.PegaNext_nusp();
                    }             
                }
                k++;
            
            }           
        }
        IncrementaNumeroDeAlunos();
        
    }
    
    
    //A função DeletaAluno percorre cada uma das listas
    //A função também possui um Anterior e um Atual
    //Quando o Atual tem o número USP desejado, a referência next do anterior passa para o próximo
    //Assim, o atual perde sua referência. Isso é feito para cada uma das listas
    
    public void DeletaAluno(String nusp){
        InfoAluno Atual = Head_nusp;
        InfoAluno Anterior = Head_nusp;
        boolean apagou = false;
        int i = 0;
        while (i<NumeroDeAlunos && apagou == false){
            if(Atual.PegaNUSP().compareTo(nusp) == 0){
                if(i==0){
                    ColocaHead_nusp(Head_nusp.PegaNext_nusp());
                    apagou = true;
                }
                else if (i == (NumeroDeAlunos-1)){
                    Anterior.ColocaNext_nusp(null);
                    apagou = true;
                }
                else {
                    Anterior.ColocaNext_nusp(Atual.PegaNext_nusp());
                    apagou = true;
                    
                }
            }
            else {                    
                    if(i==0) Atual = Atual.PegaNext_nusp();
                    else {
                        Atual = Atual.PegaNext_nusp();
                        Anterior = Anterior.PegaNext_nusp();
                    }             
                }
            i++;
        }
        Atual = Head_nome;
        Anterior = Head_nome;
        apagou = false;
        int j= 0;
        while (j<NumeroDeAlunos && apagou == false){
            if(Atual.PegaNUSP().compareTo(nusp) == 0){
                if(j==0){
                    ColocaHead_nome(Head_nome.PegaNext_nome());
                    apagou = true;
                }
                else if (j == (NumeroDeAlunos-1)){
                    Anterior.ColocaNext_nome(null);
                    apagou = true;
                }
                else {
                    Anterior.ColocaNext_nome(Atual.PegaNext_nome());
                    apagou = true;
                    
                }
            }
            else {                    
                    if(j==0) Atual = Atual.PegaNext_nome();
                    else {
                        Atual = Atual.PegaNext_nome();
                        Anterior = Anterior.PegaNext_nome();
                    }             
                }
            j++;
        }
        Atual = Head_sobrenome;
        Anterior = Head_sobrenome;
        apagou = false;
        int k = 0;
        while (k<NumeroDeAlunos && apagou == false){
            if(Atual.PegaNUSP().compareTo(nusp) == 0){
                if(k==0){
                    ColocaHead_sobrenome(Head_sobrenome.PegaNext_sobrenome());
                    apagou = true;
                }
                else if (k == (NumeroDeAlunos-1)){
                    Anterior.ColocaNext_sobrenome(null);
                    apagou = true;
                }
                else {
                    Anterior.ColocaNext_sobrenome(Atual.PegaNext_sobrenome());
                    apagou = true;
                    
                }
            }
            else {                    
                    if(k==0) Atual = Atual.PegaNext_sobrenome();
                    else {
                        Atual = Atual.PegaNext_sobrenome();
                        Anterior = Anterior.PegaNext_sobrenome();
                    }             
                }
            k++;
        }
        if (apagou) DecrementaNumeroDeAlunos();
        else System.out.println("Não existe um aluno com Número USP "+nusp +" para ser apagado.");
    }
    
    //A função BuscaAluno percorre a lista de nomes até achar um aluno com os parâmetros inseridos
    public InfoAluno BuscaAluno(String tipo, String x){
        
        InfoAluno Atual = Head_nome;
        for(int i = 0; i<NumeroDeAlunos; i++){
            if(tipo.compareToIgnoreCase("nome")==0){                
                if(Atual.PegaNome().compareTo(x)==0) return Atual;
            }
            else if(tipo.compareToIgnoreCase("sobrenome")==0){
                if(Atual.PegaSobrenome().compareTo(x)==0) return Atual;                
            }
            else if(tipo.compareToIgnoreCase("nusp")==0){
                if(Atual.PegaNUSP().compareTo(x)==0) return Atual; 
            }    
            else{
                Atual = Atual.PegaNext_nome();
            }         
        
        }
        System.out.println("Aluno não encontrado na busca.");
        return(null);
    }
    
    //A função ArmazenaEmrquivo salva em D:\\ (pode ser editado) o arquivo com as três listas ligadas
        //de modo similiar a como é impresso no main()
    
    public void ArmazenaEmArquivo(String arquivo) throws IOException{
        FileWriter arq;
        try {
            arq = new FileWriter("d:\\"+arquivo+".txt");
        }
        catch(IOException e){
            System.out.println("Não foi possível abrir o arquivo");
            return;
        }
        PrintWriter gravarArq = new PrintWriter(arq);
        InfoAluno Atual = PegaHead_nome();
        gravarArq.println("Lista em ordem de nomes: ");
        for(int i = 0; i<NumeroDeAlunos; i++){
            gravarArq.print("  " + Atual.PegaNome()+" ");
            gravarArq.print(Atual.PegaNomeDoMeio()+" ");
            gravarArq.print(Atual.PegaSobrenome()+", ");
            gravarArq.print(Atual.PegaNUSP()+", ");
            gravarArq.print(Atual.PegaEndereco()+", ");
            gravarArq.print(Atual.PegaComplemento()+", ");
            gravarArq.println(Atual.PegaCEP()+".");
            Atual = Atual.PegaNext_nome();            
        }
        Atual = PegaHead_sobrenome();
        gravarArq.println("Lista em ordem de sobrenomes: ");
        for(int i = 0; i<NumeroDeAlunos; i++){
            gravarArq.print("  " + Atual.PegaNome()+" ");
            gravarArq.print(Atual.PegaNomeDoMeio()+" ");
            gravarArq.print(Atual.PegaSobrenome()+", ");
            gravarArq.print(Atual.PegaNUSP()+", ");
            gravarArq.print(Atual.PegaEndereco()+", ");
            gravarArq.print(Atual.PegaComplemento()+", ");
            gravarArq.println(Atual.PegaCEP()+".");
            Atual = Atual.PegaNext_sobrenome();
        }
        Atual = PegaHead_nusp();
        gravarArq.println("Lista em ordem de nusp: ");
        for(int i = 0; i<NumeroDeAlunos; i++){
            gravarArq.print("  " + Atual.PegaNome()+" ");
            gravarArq.print(Atual.PegaNomeDoMeio()+" ");
            gravarArq.print(Atual.PegaSobrenome()+", ");
            gravarArq.print(Atual.PegaNUSP()+", ");
            gravarArq.print(Atual.PegaEndereco()+", ");
            gravarArq.print(Atual.PegaComplemento()+", ");
            gravarArq.println(Atual.PegaCEP()+".");
            Atual = Atual.PegaNext_nusp();
        }
        arq.close();
        
    }
        
    }