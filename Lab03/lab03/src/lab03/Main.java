package lab03;
import java.util.*;

/**
 * 
 * @author Raiany Rufino - 118110466
 *
 */
public class Main {
    
    static Agenda agenda = new Agenda();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int posicao;
        String nome, sobrenome, telefone, opcao;
        
        do {
            menu();
            opcao = in.nextLine();
            
            switch(opcao) {

            case "C":
                System.out.print("Posição: ");
                posicao = in.nextInt();
                in.nextLine();
                System.out.print("Nome: ");
                nome = in.nextLine();
                System.out.print("Sobrenome: ");
                sobrenome = in.nextLine();
                System.out.print("Telefone: ");
                telefone = in.nextLine();
                
                try {
                    System.out.println(agenda.cadastraContato(nome, sobrenome, telefone, posicao));
                    System.out.println();
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
                
                break;
            
            case "L":
                System.out.println(agenda.listaContatos());
                break;
                
            case "E":
                try {
                posicao = in.nextInt();
                in.nextLine();
                System.out.println(agenda.buscaContato(posicao));
                } catch(RuntimeException e) {
                    System.out.println(e.getMessage());
                  }
                break;
            
            default:
                if (!opcao.equals("S")) {
                System.out.println("Opção inválida!\n");}
                
                break;}
            
            } while(!opcao.equals("S"));
           
                
        }
    
    public static void menu() {
        System.out.println("(C)adastrar Contato");
        System.out.println("(L)istar Contatos");
        System.out.println("(E)xibir Contato");
        System.out.println("(S)air\n");
        
        System.out.print("Opção> ");
    }
    }
