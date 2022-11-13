import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket {
    private Socket sock;
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 4343;

    private Human receivedHuman;

    public ClientSocket() {
        try {
            this.sock = new Socket(SERVER_IP, SERVER_PORT);

        } catch (Exception ex) {
            System.out.println("Couldn't connect, enjoy the loneliness.");
        }
    }

    public ObjectOutputStream getOut() {
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(sock.getOutputStream());
            return out;
        } catch (Exception ex) {
            System.out.println("Couldn't get OUT.");
            return null;
        }
    }

    public ObjectInputStream getIn() {
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(sock.getInputStream());
            return in;
        } catch (Exception ex) {
            System.out.println("Couldn't connect get IN");
            return null;
        }
    }

    public void sendHuman(Human human) {
        try {
            ObjectOutputStream out = this.getOut();
            out.writeObject(human);
            out.flush();
            //out.close();
            System.out.println("object send to server");
            System.out.println(human.toString());
        } catch (Exception ex) {
            System.out.println("Uuuups... Couldn't send it to server.");
        }

    }

    public Human readHuman() {
        try {
            ObjectInputStream in = this.getIn();
            receivedHuman = (Human) in.readObject();
            System.out.println("object received from server");
            System.out.println(receivedHuman.toString());
            return receivedHuman;
        } catch (Exception ex) {
            System.out.println("Uuuups... Couldn't receive it from server.");
            return null;
        }

    }
}