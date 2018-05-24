package MainMenu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public class ActionMainMenuSendMessageCommand implements CommandMain{
    ActionMainMenu actionMainMenu;

    public ActionMainMenuSendMessageCommand(ActionMainMenu actionMainMenu) {
        this.actionMainMenu = actionMainMenu;
    }

    public void execute(Person logged, ArrayList<Person> users, ArrayList<Community> communities){
        actionMainMenu.sendMessage(logged, users, communities);
    }
}
