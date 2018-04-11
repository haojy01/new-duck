package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class SessionWrapper extends HttpServletRequestWrapper {

	public SessionWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}/*

    private String sessionId;

    private SessionShareService sessionShareService;

    public SessionWrapper(HttpServletRequest request) {
        super(request);
        this.sessionId = super.getRequestedSessionId();
    }

    public SessionWrapper(HttpServletRequest request,String sessionId,SessionShareService service) {
        super(request);
        this.setSessionId(sessionId);
        this.sessionShareService = service;
    }
    @Override
    public HttpSession getSession() {
        MyHttpSession session = sessionShareService.getSessionBySessionId(sessionId);
        HttpSession httpSession = null;
        if(session == null) {
            session = new MyHttpSession();
            httpSession =  super.getSession(true);
            this.sessionId = httpSession.getId();
            session.setSessionId(httpSession.getId());
            httpSession.invalidate();
            sessionShareService.saveOrUpdateSession(session);
        } else {
            sessionShareService.saveOrUpdateSession(session);
        }
//        return session;
        return ShareSessionHandler.getInstance(session,sessionShareService);
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


*/}