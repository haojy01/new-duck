package http.server.c4;

public class Bootstarp {

	public static void main(String[] args) {

		HttpConnector connector = new HttpConnector();
		connector.start();
	}
}
