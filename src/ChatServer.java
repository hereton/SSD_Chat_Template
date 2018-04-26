import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import network.Message;

public class ChatServer {

	private Server server;
	private List<Connection> connections;

	public ChatServer() throws IOException {
		this.server = new Server();
		this.connections = new ArrayList<>();
		server.addListener(new ServerListener());

		server.getKryo().register(Message.class);

		server.start();
		server.bind(54333);
		System.out.println("Server started");
		;
	}

	class ServerListener extends Listener {

		@Override
		public void connected(Connection connection) {
			super.connected(connection);
			connections.add(connection);
			System.out.println("new client connected");
		}

		@Override
		public void disconnected(Connection connection) {
			// TODO Auto-generated method stub
			super.disconnected(connection);
			connections.remove(connection);
			System.out.println("Client disconnected");
		}

		@Override
		public void received(Connection connection, Object o) {
			super.received(connection, o);
			if (o instanceof Message) {
				Message message = (Message) o;
				System.out.println("Server gets message: " + message.text);
			}

		}
	}

	public static void main(String[] args) {

		try {
			ChatServer chatServer = new ChatServer();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
