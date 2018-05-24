package MainMenu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public class ActionMainMenuJoinCommunityCommand implements CommandMain{
    ActionMainMenu actionMainMenu;

    public ActionMainMenuJoinCommunityCommand(ActionMainMenu actionMainMenu) {
        this.actionMainMenu = actionMainMenu;
    }

    public void execute(Person logged, ArrayList<Person> users, ArrayList<Community> communities){
        actionMainMenu.joinCommunity(logged, communities);
    }
}
