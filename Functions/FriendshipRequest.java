package Functions;

import java.util.*;

public class FriendshipRequest {
    private Principal.Person requestedBy;
    private Principal.Person requestedTo;

    public FriendshipRequest(Principal.Person by, Principal.Person to) {
        this.requestedBy = by;
        this.requestedTo = to;
    }

    public void enviarPedido(Principal.Person user, ArrayList<Principal.Person> users)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome para quem sera o pedido de amizade");
        String name = input.nextLine();

        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getName().equals(name)) {
                FriendshipRequest pedido = new FriendshipRequest(user, users.get(i));
                users.get(i).getFriendships().addRequest(pedido);
                return;
            }
        } System.out.printf("Nao foi possivel enviar um pedido de amizade, pois nao existe usuario cadastrado com o nome de %s", name);
    }

    public Principal.Person getRequestedBy()
    {
        return this.requestedBy;
    }
    public void setRequestedBy(Principal.Person user)
    {
        this.requestedBy = user;
    }

    public Principal.Person getRequestedTo()
    {
        return this.requestedTo;
    }
    public void setRequestedTo(Principal.Person user)
    {
        this.requestedBy = user;
    }
}
