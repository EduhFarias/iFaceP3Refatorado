package Menu;

import Functions.View;
import Principal.Community;
import Principal.Person;

import java.util.*;

public class ActionMenu {
    public ActionMenu(){}

    public void cadastro(ArrayList<Person> users, ArrayList<Community> communities){
        Person logged;
        try{
            logged = Person.novoCadastro(users);
            View.menuLogged(communities, users, logged);
        } catch (NullPointerException e){
            System.out.println("Não foi possível fazer login, tente novamente");
            logged = Person.novoCadastro(users);
            View.menuLogged(communities, users, logged);
        }
    }

    public void login(ArrayList<Person> users, ArrayList<Community> communities){
        Person logged;
        try{
            logged = Principal.Person.fazerLogin(users);
            View.menuLogged(communities, users, logged);
        } catch (NullPointerException e){
            System.out.println("Não foi possível fazer login, tente novamente");
        }
    }

    public void viewCommunities(ArrayList<Person> users, ArrayList<Community> communities){
        try{
            for(Community current : communities){
                System.out.println(current.getName());
            }
        } catch (NullPointerException e){
            System.out.println("Sem comunidades cadastradas");
        }
    }
}
