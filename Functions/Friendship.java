package Functions;

import Principal.Person;

import java.util.*;

public class Friendship {
    private ArrayList<Principal.Person> friends;
    private ArrayList<FriendshipRequest> requested;


    public Friendship() {
        this.friends = new ArrayList<Person>();
        this.requested = new ArrayList<FriendshipRequest>();
    }

    public ArrayList<Principal.Person> getFriends()
    {
        return this.friends;
    }

    public void setFriends(ArrayList<Principal.Person> friends)
    {
        this.friends = friends;
    }

    public void addFriends(Principal.Person friend)
    {
        this.friends.add(friend);
    }

    public ArrayList<FriendshipRequest> getRequested()
    {
        return this.requested;
    }

    public void setRequested(ArrayList<FriendshipRequest> pedido)
    {
        this.requested = pedido;
    }

    public void addRequest(FriendshipRequest request)
    {
        this.requested.add(request);
    }

    public void aceitarPedido(FriendshipRequest pedido) {
        pedido.getRequestedBy().getFriendships().addFriends(pedido.getRequestedBy());
        pedido.getRequestedTo().getFriendships().addFriends(pedido.getRequestedBy());
        System.out.printf("Agora %s e %s sao amigos", pedido.getRequestedTo().getName(), pedido.getRequestedBy().getName());
    }

    public void excluirPedido(int i) {
        this.requested.remove(i);
        System.out.println("Pedido de amizade removido");
    }
}
