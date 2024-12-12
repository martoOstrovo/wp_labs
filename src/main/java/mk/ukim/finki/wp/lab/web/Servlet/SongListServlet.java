//package mk.ukim.finki.wp.lab.web.Servlet;
//
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.service.Implementation.SongServiceImplementation;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name="SongListServlet" , urlPatterns = "/list/Songs")
//public class SongListServlet extends HttpServlet {
//    private final SpringTemplateEngine templateEngine;
//    private final SongServiceImplementation songService;
//
//    public SongListServlet(SpringTemplateEngine templateEngine, SongServiceImplementation songService) {
//        this.templateEngine = templateEngine;
//        this.songService = songService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext webContext = new WebContext(webExchange);
//        webContext.setVariable("songs", songService.listSongs());
//        templateEngine.process("listSongs.html", webContext, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String trackId = req.getParameter("trackId");
//        req.getSession().setAttribute("selectedSongID", trackId);
//        resp.sendRedirect(req.getContextPath() + "/artist");
//    }
//}
