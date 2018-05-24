package Functions;

import MainMenu.*;
import Principal.Community;
import Principal.Person;
import Menu.*;

import java.util.*;


public class View {
    public static void run(){
    ArrayList<Person> users = new ArrayList<Person>();
    ArrayList<Principal.Community> communities = new ArrayList<Community>();
    ControllerMenu controller = new ControllerMenu();
    ActionMenu actionMenu = new ActionMenu();
    ActionMenuCommunitiesCommand menuViewCommunities = new ActionMenuCommunitiesCommand(actionMenu);
    ActionMenuSignUpCommand menuSignUp = new ActionMenuSignUpCommand(actionMenu);
    ActionMenuLoginCommand menuLogin = new ActionMenuLoginCommand(actionMenu);

    Scanner input = new Scanner(System.in);
    int control = -1;

    while(control != 0) {
        Functions.View.showMenu();
        control = input.nextInt();

        switch(control) {
            case 1:
                controller.setChoice(menuSignUp);
                controller.choiceWasSelected(users, communities);
                break;
            case 2:
                controller.setChoice(menuLogin);
                controller.choiceWasSelected(users, communities);
                break;
            case 3:

                controller.setChoice(menuViewCommunities);
                controller.choiceWasSelected(users, communities);
                break;
        }
    }

}

    public static void menuLogged(ArrayList<Community> communities, ArrayList<Person> users, Person logged) {
        ControllerMain controllerMain = new ControllerMain();
        ActionMainMenu actionMainMenu = new ActionMainMenu();
        ActionMainMenuEditCommand mainMenuEdit = new ActionMainMenuEditCommand(actionMainMenu);
        ActionMainMenuCreateCommunityCommand mainMenuCreateCommunity = new ActionMainMenuCreateCommunityCommand(actionMainMenu);
        ActionMainMenuSendMessageCommand mainMenuSendMessage = new ActionMainMenuSendMessageCommand(actionMainMenu);
        ActionMainMenuDisplayMessageCommand mainMenuDisplayMessage = new ActionMainMenuDisplayMessageCommand(actionMainMenu);
        ActionMainMenuDisplayRequestCommand mainMenuDisplayRequest = new ActionMainMenuDisplayRequestCommand(actionMainMenu);
        ActionMainMenuJoinCommunityCommand mainMenuJoinCommunity = new ActionMainMenuJoinCommunityCommand(actionMainMenu);

        Scanner input = new Scanner(System.in);
        boolean condition = true;

        while (condition) {
            Functions.View.showMainMenu();
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    execute(mainMenuEdit, logged, users, communities);
                    break;
                case 2:
                    execute(mainMenuCreateCommunity, logged, users, communities);
                    break;
                case 3:
                    execute(mainMenuSendMessage, logged, users, communities);
                    break;
                case 4:
                    execute(mainMenuDisplayMessage, logged, users, communities);
                    break;
                case 5:
                    execute(mainMenuDisplayRequest, logged, users, communities);
                    break;
                case 6:
                    execute(mainMenuJoinCommunity, logged, users, communities);
                    break;
                default:
                    condition = false;
            }
        }
    }

    public static void execute(CommandMain commandMain, Person logged, ArrayList<Person> users, ArrayList<Community> communities){
        ControllerMain controllerMain = new ControllerMain();
        controllerMain.setChoice(commandMain);
        controllerMain.choiceWasSelected(logged, users, communities);
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

    public static void showMenu(){
        System.out.println("Bem vindo ao iFace!");
        System.out.println("O que desejas fazer:");
        System.out.println("    1. Cadastrar-se");
        System.out.println("    2. Fazer login");
        System.out.println("    3. Ver comunidades");
        System.out.println("    0. Encerrar o programa");
    }

    public static void showMainMenu(){
        System.out.println("O que desejas fazer:");
        System.out.println("    1. Editar cadastro");
        System.out.println("    2. Criar uma comunidade");
        System.out.println("    3. Enviar mensagem");
        System.out.println("    4. Mostrar sua mensagens");
        System.out.println("    5. Pedidos de amizade");
        System.out.println("    6. Entrar em uma comunidade");
        System.out.println("    0. Encerrar o programa");
    }
}
