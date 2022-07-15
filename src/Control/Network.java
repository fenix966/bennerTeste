/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.HashSet;
import model.No;

/**
 *
 * @author fenix
 */
public class Network  {
        public No[] no;
        private int qtdNos;
    
    public Network (int qtd) throws Exception{
        String checa = String.valueOf(qtd);
        //verifica se os valores são inteiros positivos e numeros
        if(Network.isInteger(checa)){
            this.qtdNos = qtd;
            no = new No[qtd];
            for(int i=0;i<qtd;i++){
                this.no[i] = new No(i);                
            }
        }else{
            throw new Exception("Quantidade deve ser maior que zero e numérico");
        }        
        
    }
    
    //metodo para conectar os nos
    public void connect(int no1, int no2) throws Exception{
        
        String checa = String.valueOf(no1);
        String checa2 = String.valueOf(no2);
        
        //verifica se os valores são inteiros positivos e numeros
        if(Network.isInteger(checa) && Network.isInteger(checa2)){
            if(no1 < qtdNos && no1 >= 0 && no2 < qtdNos && no2 >= 0){
                this.no[no1].setConexao(no2);
                this.no[no2].setConexao(no1); 
            }else{
                throw new Exception("Quantidade deve ser maior que zero e menor que " + qtdNos);
            }
        }else{
            throw new Exception("Quantidade deve ser maior que zero e numérico");
        }               
    }
    
    //verifica se os nos estao connectados diretamente(nivel1) ou indiretamente(maior que nivel 1)
    //return true se está conectado diretamente ou indiretamente
    //return false se nao esta conectado
    public boolean query(int no1, int no2) throws Exception{
        String checa = String.valueOf(no1);
        String checa2 = String.valueOf(no2);
        
        //verifica se os valores são inteiros positivos e numeros
        if(Network.isInteger(checa) && Network.isInteger(checa2)){
                //retorna direto
                if(no[no1].getConexao().equals(no2)){
                    return true;
                }         
                // verifica se não possui conexao no no1
                if(no[no1].getConexao().isEmpty()){
                    return false;
                }
                // verifica se não possui conexao no no2
                if(no[no2].getConexao().isEmpty()){
                    return false;
                }
                
                HashSet<Integer> checados = new HashSet<Integer>();
                checados.add(no1);
                return verificaIndireto(no1,no2,checados);
            
        }else{
            throw new Exception("Quantidade deve ser maior que zero e numérico");
        }         
        
    }
    
    public boolean verificaIndireto(int no1, int no2, HashSet<Integer> checados){
        
        for (int noConexao : no[no1].getConexao()) {
            System.out.println(noConexao);
            if (checados.contains(noConexao)) {
                continue;
            } else {
                checados.add(noConexao);
                if (noConexao == no2) {
                    return true;
                }else {
                    return verificaIndireto(noConexao, no2,checados);
                }
            }
        }
        
        return false;
    }
    
    public static boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }
    
}
