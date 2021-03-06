package http.server.c3;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletProcessor {

	public void process(Request request, Response response) {

		URLClassLoader loader = null;

		try {
			URL[] urls = new URL[1];
			URLStreamHandler streamHandler = null;

			//File classPath = new File(Constants.WEB_ROOT);
			
			File classPath = new File("/home/haojy/gitlab/loan_conf");
			String repository = (new URL("file", null, classPath.getCanonicalFile() + File.separator)).toString();

			urls[0] = new URL(null, repository, streamHandler);
			loader = new URLClassLoader(urls);

		} catch (IOException e) {
			e.printStackTrace();
		}

		Class myclass = null;
		try {
			myclass = loader.loadClass("http.server.c2.PrimitiveServlet");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Servlet servlet = null;
		try {
			servlet = (Servlet) myclass.newInstance();
			RequestFacade requestFacade= new RequestFacade(request);
			ResponseFacade responseFacade = new ResponseFacade(response);
			
			try {
				servlet.service((ServletRequest) requestFacade, (ServletResponse) responseFacade);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) throws MalformedURLException, IOException, ClassNotFoundException {
		
		URL[] urls = new URL[1];
		URLStreamHandler streamHandler = null;
		File classPath = new File("/home/haojy/gitlab/loan_conf");
		//File classPath = new File(System.getProperty("user.dir"));
		String repository = (new URL("file", null, classPath.getCanonicalFile() + File.separator)).toString();

		urls[0] = new URL(null, repository, streamHandler);
		URLClassLoader loader = new URLClassLoader(urls);
		Class myclass = loader.loadClass("http.server.c2.PrimitiveServlet");
		
		System.out.println(myclass.getClassLoader().toString());
		System.out.println(myclass);
	}

}
