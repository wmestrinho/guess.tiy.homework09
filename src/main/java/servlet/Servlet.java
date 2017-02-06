package servlet;

import data.GuessGame;
import data.Player;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WagnerMestrinho on 2/4/17.
 */
@WebServlet(name = "Servlet", urlPatterns = "/guess")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int guessedNumber = Integer.parseInt(request.getParameter("txtGuessedNumber"));
        Player player = (Player) request.getSession().getAttribute("player");
        if (player == null) {
            player = new Player();
            request.getSession().setAttribute("player", player);
        }
        GuessGame myGame = (GuessGame) request.getSession().getAttribute("myGame");
        if (myGame == null) {
            myGame = new GuessGame();
            player.setNoOfGamePlayed(player.getNoOfGamePlayed() + 1);
            request.getSession().setAttribute("myGame", myGame);

        }
    }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {


            Player player = (Player) request.getSession().getAttribute("player");
            if (player == null) {
                player = new Player();
                request.getSession().setAttribute("player", player);


                GuessGame myGame = new GuessGame();

                request.getSession().setAttribute("player",player);
                String nextJSP = "/index.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                dispatcher.forward(request,response);



            }
        }