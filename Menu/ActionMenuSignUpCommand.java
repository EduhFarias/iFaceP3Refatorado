package Menu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public class ActionMenuSignUpCommand implements CommandMenu {
    ActionMenu actionMenu;

    public ActionMenuSignUpCommand(ActionMenu actionMenu) {
        this.actionMenu = actionMenu;
    }

    public void execute(ArrayList<Person> users, ArrayList<Community> communities){
        actionMenu.cadastro(users, communities);
    }
}
