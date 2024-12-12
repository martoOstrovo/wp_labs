//package mk.ukim.finki.wp.lab.web.Servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.model.Artist;
//import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.service.ArtistService;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name="artistServlet", urlPatterns = "/artist")
//public class ArtistServlet extends HttpServlet {
//    private final SpringTemplateEngine templateEngine;
//    private final ArtistService artistService;
//    private final SongService songService;
//
//    public ArtistServlet(SpringTemplateEngine templateEngine, ArtistService artistService, SongService songService) {
//        this.templateEngine = templateEngine;
//        this.artistService = artistService;
//        this.songService = songService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req,resp);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("artists", artistService.listArtists());
//        String songId = (String)req.getSession().getAttribute("selectedSongID");
//        context.setVariable("songID", songId);
//        templateEngine.process("artistsList.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String artistID = req.getParameter("artistId");
//        Artist selectedArtist = artistService.findById(Long.parseLong(artistID));
//        String songID = (String)req.getSession().getAttribute("selectedSongID");
//        Song selectedSong = songService.findByTrackId(songID);
//        songService.addArtistToSong(selectedArtist, selectedSong);
//        resp.sendRedirect("/details");
//    }
//}
