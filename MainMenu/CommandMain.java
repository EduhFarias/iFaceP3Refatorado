package MainMenu;

import Principal.Community;
import Principal.Person;

import java.util.ArrayList;

public interface CommandMain {
    public void execute(Person logged, ArrayList<Person> users, ArrayList<Community> communities);
}
