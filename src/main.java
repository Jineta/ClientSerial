import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Human receivedHuman = null;
        ArrayList<Human> humanArrayList = new ArrayList<>();
        ArrayList<Human> humanArrayListReturned = new ArrayList<>();
        humanArrayList.add(new Human("Sergio", "m", 20));
        humanArrayList.add(new Human("Anna", "f", 10));
        humanArrayList.add(new Human("Peter", "m", 90));

        ClientSocket clientSocket = new ClientSocket();
        for (Human hum : humanArrayList) {
            clientSocket.sendHuman(hum);
        }


        try {
              while ((receivedHuman = clientSocket.readHuman()) != null) {
                    humanArrayListReturned.add(receivedHuman);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

    }


}
