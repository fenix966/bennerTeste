/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashSet;

/**
 *
 * @author fenix
 */
public class No {
    //numero descrição do nó
    private int numero;
    //HashSet para fazer a conexao do nó 
    private HashSet<Integer> conexao = new HashSet<Integer>();

    public No(int i) {
        this.numero = i;
    }   
    

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return the conexao
     */
    public HashSet<Integer> getConexao() {
        return conexao;
    }

    /**
     * @param nrConexao
     */
    public void setConexao(int nrConexao) {
        this.conexao.add(nrConexao);
    }
    
    public int getQTDConexao(){
        return this.conexao.size();
    }
    
}
