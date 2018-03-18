package servlet;

import dao.GoodsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class insert extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest requset, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response); // why should  I redirect this response to the doPost session?
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");  //set encoding as "UTF-8"
//        response.setContentType("text/html;charset=UTF-8");  //set encoding as "UTF-8"

        System.out.println(request.getParameter("price"));

        String gname = request.getParameter("gname");
        int gnum = Integer.parseInt(request.getParameter("gnum"));
        double price = Double.parseDouble(request.getParameter("price"));

        GoodsDAO goodsDAO = new GoodsDAO(); //Make the DAO
        goodsDAO.easyAdd(gname, gnum, price); // Insertion execute

        response.sendRedirect("./servlet.insert"); // redirect to the preview page before insertion
    }
}
