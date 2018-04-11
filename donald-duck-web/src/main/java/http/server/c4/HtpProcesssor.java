package http.server.c4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HtpProcesssor {

	HttpRequest request = null;
	HttpResponse response = null;

	public HtpProcesssor(HttpConnector httpConnector) {
	}

	public void process(Socket scoket) {/*
		SocketInputStream input = null;
		OutputStream output = null;

		try {
			input = new SocketInputStream(scoket.getInputStream(), 2048);
			output = scoket.getOutputStream();

			request = new HttpRequest(input);
			response = new HttpResponse(output);
			response.setHeader("server", "Pyrmont Servlet Container");

			parseRequest(input, output);
			parseHeaders(input);

			if (request.getRequestURI().startsWith("/servlet/")) {
				ServletProcessor processor = new ServletProcessor();
				processor.process(request, response);
			}else{
				StaticResourceProcessor processor=new StaticResourceProcessor();
				processor.process(request, response);
			}

			scoket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	*/}

	private void parseHeaders(SocketInputStream input) {

	}

	private void parseRequest(SocketInputStream input, OutputStream output) {

	}

}
