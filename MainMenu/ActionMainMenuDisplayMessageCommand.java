package MainMenu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public class ActionMainMenuDisplayMessageCommand implements CommandMain{
    ActionMainMenu actionMainMenu;

    public ActionMainMenuDisplayMessageCommand(ActionMainMenu actionMainMenu) {
        this.actionMainMenu = actionMainMenu;
    }

    public void execute(Person logged, ArrayList<Person> users, ArrayList<Community> communities){
        actionMainMenu.displayMessages(logged);
    }
}
