package http.server.c4;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpConnector implements Runnable {

	boolean stopped;
	private String scheme = "http";

	public void start() {

		Thread thread = new Thread(this);
		thread.run();
	}

	@Override
	public void run() {

		ServerSocket serverSocket = null;
		int port = 8080;

		try {
			serverSocket = new ServerSocket(port, 1, Inet4Address.getByName("127.0.0.1"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		while (!stopped) {
			Socket scoket = null;
			try {
				scoket = serverSocket.accept();
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
			HtpProcesssor processor = new HtpProcesssor(this);
			processor.process(scoket);
		}

	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

}
