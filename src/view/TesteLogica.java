/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.Network;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author fenix
 */
public class TesteLogica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Network net = null;
        int count = 0;
        Scanner scan = new Scanner(System.in);
        
        do{            
            if(count == 0){
                System.out.println("Bem vindo");
                System.out.println("Informe a quantidade de Nós:");
                try {
                int qtd = scan.nextInt();
                
                net = new Network(qtd);
                }catch (InputMismatchException e1) {
                    System.out.println(e1);
                    scan = new Scanner(System.in);
                     count --;
                }catch (Exception ex) {
                    System.out.println(ex);
                    scan = new Scanner(System.in);
                    count --;
                }
            

                count ++;
            }else{
                
                System.out.println("Se deseja fazer uma conexão digite 1");
                System.out.println("Se deseja verificar se existe conexão entre os nós digite 2");
                System.out.println("Sair do sistema digite 3");
                try {
                    int valor = scan.nextInt();
                
                    switch(valor) {
                        case 1:

                            try {
                                System.out.println("informar o nó de origem:");
                                int qtd = scan.nextInt() - 1;

                                System.out.println("informar o nó de destino:");
                                int qtd2 = scan.nextInt() - 1;
                                
                                net.connect(qtd, qtd2);
                                System.out.println( net.no[qtd].getConexao());
                                System.out.println( net.no[qtd2].getConexao());                        

                                
                            } catch (Exception ex) {
                                System.out.println(ex);
                                scan = new Scanner(System.in);

                            }

                          break;
                        case 2:
                            try {
                                System.out.println("informar o nó de origem:");
                                int qtd = scan.nextInt() - 1;

                                System.out.println("informar o nó de destino:");
                                int qtd2 = scan.nextInt() - 1;

                                if(net.query(qtd, qtd2)){
                                    System.out.println("Possui conexão");
                                }else{
                                    System.out.println("Não possui conexão");
                                }
                            } catch (Exception ex) {
                                scan = new Scanner(System.in);
                                System.out.println(ex);
                            }
                          break;
                        case 3:
                          System.exit(0);
                          break;
                        default:
                            System.out.println("favor informar um valor 1 ou 2");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                    scan = new Scanner(System.in);
                }
            }
            
        }while(true);
        
    }
    
}
