package Principal;

import java.util.*;

public class Person {

    private String login;
    private String password;
    private String name;
    private Functions.Friendship friendships;
    private ArrayList<Functions.Message> mensagens = new ArrayList<>();
    private ArrayList<Community> minhasComunidades = new ArrayList<>();



    public Person(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.friendships = new Functions.Friendship();
    }

    public static Person novoCadastro(ArrayList<Person> usuarios) {
        System.out.println("Digite seu nome:");
        Scanner input = new Scanner(System.in);
        String nome = input.nextLine();
        System.out.println("Digite como deseja que seja seu login:");
        String login = input.nextLine();
        System.out.println("Digite como deseja que seja sua senha:");
        String senha = input.nextLine();

        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getName().equals(nome)) {
                System.out.println("Nome já utilizado! Tente novamente.");
                return null;
            }
            if(usuarios.get(i).getLogin().equals(login)) {
                System.out.println("Login já utilizado! Tente novamente.");
                return null;
            }
            if(usuarios.get(i).getPassword().equals(senha)) {
                System.out.println("Senha já utilizada! Tente novamente.");
                return null;
            }
        }

        Person newPerson = new Person(login, senha, nome);
        usuarios.add(newPerson);
        return newPerson;
    }

    public static Person fazerLogin(ArrayList<Person> usuarios) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu login:");
        String login = input.nextLine();
        System.out.println("Digite sua senha:");
        String senha = input.nextLine();
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getLogin().equals(login) && usuarios.get(i).getPassword().equals(senha))
            {
                System.out.println("Login efetuado com sucesso");
                return usuarios.get(i);
            }
        }
        return null;
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getLogin()
    {
        return this.login;
    }

    public Functions.Friendship getFriendships()
    {
        return this.friendships;
    }

    public void setMensagens(ArrayList<Functions.Message> mensagens)
    {
        this.mensagens = mensagens;
    }

    public ArrayList<Functions.Message> getMensagens()
    {
        return this.mensagens;
    }

    public ArrayList<Community> getMinhasComunidades()
    {
        return this.minhasComunidades;
    }

    public void setMinhasComunidades(ArrayList<Community> comunidades)
    {
        this.minhasComunidades = comunidades;
    }

    public static void editCadastro(Person usuario){
        System.out.println("Opicao de Edicao de cadastro selecionada:");
        String string;
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o novo login:");
        string = input.nextLine();
        usuario.setLogin(string);

        System.out.println("Digite o novo password:");
        string = input.nextLine();
        usuario.setPassword(string);

        System.out.println("Digite o novo nome:");
        string = input.nextLine();
        usuario.setName(string);

    }

    public boolean loginExistente(ArrayList<Person> users, Person user) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getLogin().equals(user.getLogin())) {
                return true;
            }
        }
        return false;
    }

    public boolean NameExistente(ArrayList<Person> users, Person user) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getName().equals(user.getName())) {
                return true;
            }
        }
        return false;
    }

    public static void displayPedidos(Person user) {
        if(user.friendships.getRequested().size() == 0) {
            System.out.println("Nao ha novos pedidos de amizade.");
        }
        else {
            boolean control;
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < user.friendships.getRequested().size(); i++) {
                System.out.printf("%s deseja te adicionar como amigo. Deseja aceitar? (true - se sim ou false - se nao)", user.friendships.getRequested().get(i).getRequestedBy());
                control = input.nextBoolean();
                if(control) {
                    user.getFriendships().aceitarPedido(user.getFriendships().getRequested().get(i));
                    user.getFriendships().excluirPedido(i);
                } else {
                    System.out.println("Deseja ecluir o pedido? (true - se sim ou false - se nao)");
                    control = input.nextBoolean();
                    if (control) {
                        user.getFriendships().excluirPedido(i);
                        System.out.println("Pedido de amizade excluido");
                    }
                }
            }
        }
    }

    public static void displayMensagens(Person user) {
        if(user.mensagens.size() == 0) {
            System.out.println("Nao existem mensagens.");
        } else {
            boolean control;
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < user.mensagens.size(); i++) {
                try{
                    System.out.printf("Mensagem de %s para %s: %s\n Deseja excluir?(true - se sim ou false - se nao)", user.mensagens.get(i).getSendBy(), user.mensagens.get(i).getSendToCommunity(), user.mensagens.get(i).getMessage());
                    control = input.nextBoolean();
                    if(control) {
                        user.getMensagens().remove(i);
                    }
                }catch (NullPointerException e){
                    System.out.printf("Mensagem de %s para %s: %s\n Deseja excluir?(true - se sim ou false - se nao)", user.mensagens.get(i).getSendBy(), user.mensagens.get(i).getSendToUser(), user.mensagens.get(i).getMessage());
                    control = input.nextBoolean();
                    if (control) {
                        user.getMensagens().remove(i);
                    }
                }
            }
        }
    }
}
