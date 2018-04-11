package filter;

import java.io.IOException;

import javax.servlet.*;

public class MySessionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}/*

    private static final String regex=".*(css|html|ico|html|jpg|jpeg|png|gif|js)";

    @Autowired
    private SessionShareService sessionShareService;
    @Override
    public void init(FilterConfig config) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String sessionId=getSessionId(request);
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        String requestedUri=httpRequest.getRequestURL().toString();
//        System.out.println(requestedUri);
        if(requestedUri.matches(regex)){
            chain.doFilter(request, response);
            return;
        }
        SessionWrapper wrapperRequest=new SessionWrapper(httpRequest,sessionId,sessionShareService);
        //HttpSession httpSession=wrapperRequest.getSession();
        chain.doFilter(wrapperRequest, response);
    }

    @Override
    public void destroy() {
    }

    private static String getSessionId(ServletRequest request){
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        String sessionId="";
//        Cookie cookie =WebUtils.getCookie(httpRequest, "PHPSESSID");
//        if(cookie!=null){
//            return cookie.getValue();
//        }
        Cookie cookie = WebUtils.getCookie(httpRequest, "JSESSIONID");
        if(cookie!=null){
            sessionId= cookie.getValue();
        }
        return sessionId;
    }
*/}
