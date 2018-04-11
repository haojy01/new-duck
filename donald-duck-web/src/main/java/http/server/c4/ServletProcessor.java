package http.server.c4;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLStreamHandler;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletProcessor {

	public void process(HttpRequest request, HttpResponse response) {

		try {
			URL[] urls = new URL[1];
			URLStreamHandler streamHandler = null;
			File classPath = new File("/home/haojy/gitlab/loan_conf");
			String repository = (new URL("file", null, classPath.getCanonicalFile() + File.separator)).toString();
			urls[0] = new URL(null, repository, streamHandler);

		} catch (IOException e) {
			e.printStackTrace();
		}

		Servlet servlet = null;
		try {
			servlet = (Servlet) (Class.forName("http.server.c2.PrimitiveServlet").newInstance());
			RequestFacade requestFacade = new RequestFacade(request);
			ResponseFacade responseFacade = new ResponseFacade(response);
			servlet.service((ServletRequest) requestFacade, (ServletResponse) responseFacade);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
