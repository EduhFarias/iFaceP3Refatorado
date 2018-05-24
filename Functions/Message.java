package Functions;

import java.util.*;

public class Message {

    private Principal.Person sendBy;
    private Principal.Person sendToUser;
    private Principal.Community sendToCommunity;
    private String message;

    public Message(Principal.Person sendBy, Principal.Person sendTo, String message) {
        this.sendBy = sendBy;
        this.sendToUser = sendTo;
        this.sendToCommunity = null;
        this.message = message;
    }
    public Message(Principal.Person sendBy, Principal.Community sendTo, String message) {
        this.sendBy = sendBy;
        this.sendToUser = null;
        this.sendToCommunity = sendTo;
        this.message = message;
    }

    public Principal.Person getSendBy() {
        return this.sendBy;
    }
    public Principal.Person getSendToUser() {
        return this.sendToUser;
    }
    public Principal.Community getSendToCommunity() {
        return this.sendToCommunity;
    }
    public String getMessage() {
        return this.message;
    }

    public static void enviarMensagemP(Principal.Person user, ArrayList<Principal.Person> users) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome para quem sera a mensagem");
        String name = input.nextLine();
        String txt;

        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getName().equals(name)) {
                System.out.println("Conteudo da mensagem:");
                txt = input.nextLine();
                Message mensagem = new Message(user, users.get(i), txt);
                users.get(i).getMensagens().add(mensagem);
                user.getMensagens().add(mensagem);
                return;
            }
        } System.out.printf("Usuario com nome de %s nao encontrado", name);
    }

    public static void enviarMensagemC(Principal.Person user, ArrayList<Principal.Community> comunidades) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome para que comunidade sera a mensagem");
        String name = input.nextLine();
        String txt;

        for (int i = 0; i < comunidades.size(); i++) {
            if(comunidades.get(i).getName().equals(name)) {
                System.out.println("Conteudo da mensagem:");
                txt = input.nextLine();
                Message mensagem = new Message(user, comunidades.get(i), txt);
                comunidades.get(i).getMensagens().add(mensagem);
                user.getMensagens().add(mensagem);
                return;
            }
        } System.out.printf("Usuario com nome de %s nao encontrado", name);
    }

}
