import com.esotericsoftware.kryonet.Client;

public class ChatClient {

	private ClientGui gui;
	private Client client;

	public ChatClient() {
		gui = new ClientGui(this);
		client = new Client();
	}

	public void sendMessage(String text) {

	}

	public static void main(String[] args) {
		new ChatClient();
	}

}
