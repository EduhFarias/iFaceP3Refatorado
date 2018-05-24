package Principal;

import java.util.*;

public class Community extends Entity{

    private String name;
    private String description;
    private ArrayList<Person> users;
    private String loginOfOwner;
    private ArrayList<Functions.Message> mensagens;


    public Community(String name, String description,Person user) {
        this.name = name;
        this.description = description;
        this.users.add(user);
        this.loginOfOwner = user.getLogin();
    }

    public static Community createComunidade(Person user) {
        System.out.println("Opcao de criacao de comunidade selecionada!");
        String name, description;
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome da nova comunidade:");
        name = input.nextLine();

        System.out.println("Digite a descricao da nova comunidade:");
        description = input.nextLine();

        Community novaComunidade = new Community(name, description, user);

        System.out.println("Comunidade criada com sucesso!");
        user.getMinhasComunidades().add(novaComunidade);

        return novaComunidade;
    }

    public Community addMember(Community comunidade, Person user) {
        if (isMember(comunidade, user))System.out.printf("O usuario ja pertence a comunidade", comunidade.getName());
        else {
            comunidade.users.add(user);
            user.getMinhasComunidades().add(comunidade);
            System.out.printf("Usuario %s adicionado a comunidade %s", user.getName(), comunidade.getName());
        }
        return comunidade;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isMember(Community comunidade, Person user) {
        for (int i = 0; i < comunidade.users.size(); i++) {
            if(comunidade.users.get(i).getLogin().equals(user.getLogin())) {
                return true;
            }
        } return false;
    }

    public void setMensagens(ArrayList<Functions.Message> mensagens) {
        this.mensagens = mensagens;
    }

    public ArrayList<Functions.Message> getMensagens() {
        return this.mensagens;
    }

}
