package MainMenu;

import Functions.View;
import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public class ActionMainMenu {
    public void edit(Person logged){
        Person.editCadastro(logged);
    }

    public void createCommunity(Person logged, ArrayList<Person> users, ArrayList<Community> communities){
        communities.add(Community.createComunidade(logged));
    }

    public void sendMessage(Person logged, ArrayList<Person> users, ArrayList<Community> communities){
        View.sendMessage(logged, users, communities);
    }

    public void displayMessages(Person logged){
        Person.displayMensagens(logged);
    }

    public void displayRequest(Person logged){
        Person.displayPedidos(logged);
    }

    public void joinCommunity(Person logged, ArrayList<Community> communities){
        View.community(logged, communities);
    }
}
