/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedados;

/**
 *
 * @author Rafael
 */
public class InfoAluno {
    
    private String nome, nomedomeio, sobrenome, nusp, endereco, complemento, cep;
    
    private InfoAluno Next_nome;
    private InfoAluno Next_sobrenome;
    private InfoAluno Next_nusp;
    
    //As funções Pega e Coloca são padrões
    //Há dois construtores, um com parâmetros e outro sem
    //O construtor com parâmetros recebe todas as informações do aluno e já o cria
    //O construtor sem parâmetros cria um InfoAluno sem informações, que podem ser inseridas pelas
                // funções Coloca
    //Em ambos os casos, o InfoAluno é inicializado com os Nexts iguais a null
    
    protected InfoAluno(String nome1, String nomedomeio1, String sobrenome1, 
            String nusp1, String endereco1, String complemento1, String cep1){
        this.nome = nome1;
        this.nomedomeio = nomedomeio1;
        this.sobrenome = sobrenome1;
        this.nusp = nusp1;
        this.endereco = endereco1;
        this.complemento = complemento1;
        this.cep = cep1;
        this.Next_nome = null;
        this.Next_sobrenome = null;
        this.Next_nusp = null;
               
    }
    
    protected InfoAluno(){
        this.nome = null;
        this.nomedomeio = null;
        this.sobrenome = null;
        this.nusp = null;
        this.endereco = null;
        this.complemento = null;
        this.cep = null;
        this.Next_nome = null;
        this.Next_sobrenome = null;
        this.Next_nusp = null;
    }
    
    protected void ColocaNome(String n){
        nome = n;
    }
    
    protected String PegaNome(){
        return(nome);
    }
            
    protected void ColocaNomeDoMeio(String n){
        nomedomeio = n;
    }
    
    protected String PegaNomeDoMeio(){
        return(nomedomeio);
    }
    
    protected void ColocaSobrenome(String n){
        sobrenome = n;
    }
    
    protected String PegaSobrenome(){
        return(sobrenome);
    }
    
    protected void ColocaNUSP(String n){
        nusp = n;
    }
    
    protected String PegaNUSP(){
        return(nusp);
    }
    
    protected void ColocaEndereco(String n){
        endereco = n;
    }
    
    protected String PegaEndereco(){
        return(endereco);
    }
    
    protected void ColocaComplemento(String n){
        complemento = n;
    }
    
    protected String PegaComplemento(){
        return(complemento);
    }
    
    protected void ColocaCEP(String n){
        cep = n;
    }
    
    protected String PegaCEP(){
        return(cep);
    }
    
    protected void ColocaNext_nome(InfoAluno Next_nome){
        this.Next_nome = Next_nome;
    }
    
    protected InfoAluno PegaNext_nome(){
        return(Next_nome);        
    }
    
    protected void ColocaNext_sobrenome(InfoAluno Next_sobrenome){
        this.Next_sobrenome = Next_sobrenome;
    }
    
    protected InfoAluno PegaNext_sobrenome(){
        return(Next_sobrenome);        
    }
    
    protected void ColocaNext_nusp(InfoAluno Next_nusp){
        this.Next_nusp = Next_nusp;
    }
    
    protected InfoAluno PegaNext_nusp(){
        return(Next_nusp);        
    }
}
