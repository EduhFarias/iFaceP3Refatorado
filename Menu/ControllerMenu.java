package Menu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public class ControllerMenu {
    private CommandMenu choice;

    public ControllerMenu(){}

    public void setChoice(CommandMenu choice) {
        this.choice = choice;
    }

    public void choiceWasSelected(ArrayList<Person> users, ArrayList<Community> communities){
        choice.execute(users, communities);
    }
}
