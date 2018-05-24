import Functions.Message;
import Principal.Community;
import Principal.Person;

import java.util.*;

public class Main {
     public static void main(String[] args) {
         ArrayList<Principal.Person> users = new ArrayList<Person>();
         ArrayList<Principal.Community> communities = new ArrayList<Community>();
         Scanner input = new Scanner(System.in);
         int control = 1;
         String aux;
         Person logged = null;

         while(control != 0)
         {
             Functions.View.showMenu();
             control = input.nextInt();

             switch(control)
             {
                 case 1:
                     logged = Person.novoCadastro(users);
                     menuLogged(communities, users, logged);
                     break;
                 case 2:
                     logged = Principal.Person.fazerLogin(users);
                     menuLogged(communities, users, logged);
                     break;
                 case 3:
                     for(Community current : communities){
                         System.out.println(current.getName());
                     }
                     break;
                }
                Functions.View.showMenu();
                control = input.nextInt();
            }

        }

        public static void menuLogged(ArrayList<Community> communities, ArrayList<Person> users, Person logged) {
            Scanner input = new Scanner(System.in);
            boolean condition = true;

            while (condition) {
                Functions.View.showMenuPrincipal();
                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        Person.editCadastro(logged);
                        break;
                    case 2:
                        communities.add(Community.createComunidade(logged));
                        break;
                    case 3:
                        sendMessage(logged, users, communities);
                        break;
                    case 4:
                        Person.displayMensagens(logged);
                        break;
                    case 5:
                        Person.displayPedidos(logged);
                        break;
                    case 6:
                        community(logged, communities);
                        break;
                    default:
                        condition = false;
                }
            }
        }

        public static void sendMessage(Person logged, ArrayList<Person> users, ArrayList<Community> communities){
            Scanner input = new Scanner(System.in);
            int control;

            System.out.println("Digite 1 para mandar mensagem para um usuario ou 2 para mandar para uma comunidade.");
            control = input.nextInt();

            if(control == 1)
                Message.enviarMensagemP(logged, users);

            else if(control == 2)
                Message.enviarMensagemC(logged, communities);
            else
                System.out.println("Comando invalido.");
        }

        public static void community(Person logged, ArrayList<Community> communities){
            Scanner input = new Scanner(System.in);
            System.out.println("Qual comunidade desejas entrar?");
            String choice = input.nextLine();

            for (Community current : communities) {
                if(current.getName().equals(choice)) {
                    current.addMember(current, logged);
                    return;
                }
            }
            System.out.println("Não foi possivel achar a comunidade desejada");
        }
    }
