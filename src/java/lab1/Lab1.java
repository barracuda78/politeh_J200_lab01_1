package lab1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Lab1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //кодировку реквеста нужно установить:
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("Имя");
        String email = request.getParameter("Email");
        String send = request.getParameter("send");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Lab1</title>");
//            //ДОБАВКА:
//            out.println("<style>");
//                out.println("body{background-color: #AAAAFF;}");
//                out.println("#box{");
//                    out.println("position: absolute;");
//                    out.println("top: 50%;");
//                    out.println("left: 50%;");
//                    out.println("margin: -75px 0px 0px -193px;");
//                    out.println("padding: 10px;");
//
//                    out.println("width: 800px;");
//                    out.println("height: 400px;");
//
//                    out.println("border: dotted blue 1px;");
//                out.println("}");
//                out.println("td{");
//                    out.println("text-align:center;");
//                out.println("}");
//            out.println("</style>");   
//            //КОНЕЦ ДОБАВКИ.
//            out.println("</head>");
//            out.println("<body>");
                out.println("<div id=\"box\">");  
                if(send != null){
                        if((name == null || "".equals(name)) || (email == null || "".equals(email))){
                                        //ДОБАВКА:
                            out.println("<style>");
                                out.println("body{background-color: #AAAAFF;}");
                                out.println("#box{");
                                    out.println("position: absolute;");
                                    out.println("top: 50%;");
                                    out.println("left: 50%;");
                                    out.println("margin: -75px 0px 0px -193px;");
                                    out.println("padding: 10px;");

                                    out.println("width: 800px;");
                                    out.println("height: 130px;");

                                    out.println("border: dotted blue 1px;");
                                out.println("}");
                                out.println("td{");
                                    out.println("text-align:center;");
                                out.println("}");
                            out.println("</style>");   
                            //КОНЕЦ ДОБАВКИ.
                            out.println("</head>");
                            out.println("<body>");
                            //ошибка:
                            out.print("<p> Вы не ввели имя и/или e-mail!</p>");
                            //вывести форму снова:
                            //форма первоначальная:
                            out.println("<form action=\"Lab1\" method=\"GET\" >");
                            out.println("<p><b> Имя   : </b>");
                            out.println("<input type=\"text\" name=\"Имя\" size=30 /></p>");
                            out.println("<p><b> Email : </b>");
                            out.println("<input type=\"text\" name=\"Email\" size=50 />");
                            //кнопочка:
                            out.println("<input type=\"submit\" name=\"send\" value=\"Отправить\" />");
                            out.println("</p></form>");
                            //возврат:
                            return;
                        }
                        
                        if(!isNameCorrect(name) || !isEmailCorrect(email)){
                                        //ДОБАВКА:
                            out.println("<style>");
                                out.println("body{background-color: #AAAAFF;}");
                                out.println("#box{");
                                    out.println("position: absolute;");
                                    out.println("top: 50%;");
                                    out.println("left: 50%;");
                                    out.println("margin: -75px 0px 0px -193px;");
                                    out.println("padding: 10px;");

                                    out.println("width: 800px;");
                                    out.println("height: 230px;");

                                    out.println("border: dotted blue 1px;");
                                out.println("}");
                                out.println("td{");
                                    out.println("text-align:center;");
                                out.println("}");
                            out.println("</style>");   
                            //КОНЕЦ ДОБАВКИ.
                            out.println("</head>");
                            out.println("<body>");
                            //ошибка:
                            out.print("<p> Ошибка: </p>");     
                            out.print("<p> Соблюдайте условия: </p>");   
                            out.print("<p> Имя содержит не менее одной буквы и не длиннее 30 символов. </p>");   
                            out.print("<p> Email выглядит как корректный email и не длиннее 50  символов. </p>");  
                            
                            //форма предзаполненная неправильными значениями:
                            out.println("<form action=\"Lab1\" method=\"GET\" >");
                            out.println("<p><b> Имя   : </b>");
                            out.println("<input type=\"text\" name=\"Имя\" value=\"" + name + "\" size=30 /></p>");
                            out.println("<p><b> Email : </b>");
                            out.println("<input type=\"text\" name=\"Email\" value=\"" + email + "\" size=50 />");
                            //кнопочка:
                            out.println("<input type=\"submit\" name=\"send\" value=\"Отправить\" />");
                            out.println("</p></form>");
                            //возврат:
                            return;
                        }
                        else{
                                        //ДОБАВКА:
                            out.println("<style>");
                                out.println("body{background-color: #AAAAFF;}");
                                out.println("#box{");
                                    out.println("position: absolute;");
                                    out.println("top: 50%;");
                                    out.println("left: 50%;");
                                    out.println("margin: -75px 0px 0px -193px;");
                                    out.println("padding: 10px;");

                                    out.println("width: 800px;");
                                    out.println("height: 100px;");

                                    out.println("border: dotted blue 1px;");
                                out.println("}");
                                out.println("td{");
                                    out.println("text-align:center;");
                                out.println("}");
                            out.println("</style>");   
                            //КОНЕЦ ДОБАВКИ.
                            out.println("</head>");
                            out.println("<body>");
                            //Если оба условия выполнены, вывести страницу с фразой.
                            //<<Имя>>, Ваш email <<Email>> будет добавлен в список рассылки.
                            out.print("<h1>" + name + ", Ваш email " + email + " будет добавлен в список рассылки. </h1>");
                            return;
                        }

                }else{
                                //ДОБАВКА:
                out.println("<style>");
                    out.println("body{background-color: #AAAAFF;}");
                    out.println("#box{");
                        out.println("position: absolute;");
                        out.println("top: 50%;");
                        out.println("left: 50%;");
                        out.println("margin: -75px 0px 0px -193px;");
                        out.println("padding: 10px;");

                        out.println("width: 600px;");
                        out.println("height: 120px;");

                        out.println("border: dotted blue 1px;");
                    out.println("}");
                    out.println("td{");
                        out.println("text-align:center;");
                    out.println("}");
                out.println("</style>");   
                //КОНЕЦ ДОБАВКИ.
                out.println("</head>");
                out.println("<body>");
                //форма первоначальная:
                out.println("<form action=\"Lab1\" method=\"GET\" >");
                out.println("<p><b> Имя   : </b>");
                out.println("<input type=\"text\" name=\"Имя\" size=30 /></p>");
                out.println("<p><b> Email : </b>");
                out.println("<input type=\"text\" name=\"Email\" size=50 />");
                //кнопочка:
                out.println("<input type=\"submit\" name=\"send\" value=\"Отправить\" />");
                out.println("</p></form>");
                }
                
                out.println("<br></br><br></br>");
                out.println("<div>");
                               
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private boolean isNameCorrect(String name){
        //1) Имя содержит не менее одной буквы и не длиннее 30 символов.
        if(name.length() < 1 || name.length() > 30)
            return false;
        
        return true;
    }
    
    private boolean isEmailCorrect(String email){
        //2) Email выглядит как корректный email и не длиннее 50  символов.
        if(email.length() > 50) 
            return false;
        
        return email.matches("[^@]+@[^@]+\\.[^@]{2,}"); //имеется ввиду, что в домене первого уровня может быть только 2 и более символа.
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
