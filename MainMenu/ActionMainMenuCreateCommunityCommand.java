package MainMenu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public class ActionMainMenuCreateCommunityCommand implements CommandMain{
    ActionMainMenu actionMainMenu;

    public ActionMainMenuCreateCommunityCommand(ActionMainMenu actionMainMenu) {
        this.actionMainMenu = actionMainMenu;
    }

    public void execute(Person logged, ArrayList<Person> users, ArrayList<Community> communities){
        actionMainMenu.createCommunity(logged, users, communities);
    }
}
