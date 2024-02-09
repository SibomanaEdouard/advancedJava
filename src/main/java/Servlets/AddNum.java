package Servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddNum extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        try{
            String num1Str = req.getParameter("num1");
            String num2Str = req.getParameter("num2");
            String operation=req.getParameter("operation");
            if(num2Str != null  && num1Str !=null){
                int num1=Integer.parseInt(num1Str);
                int num2=Integer.parseInt(num2Str);
                int diff=num1-num2;
                int sum=num1+num2;
                res.setContentType("text/html");
                if("add".equals(operation)) {
                    out.println("The sum of " + num1 + " and " + num2 + " is " + sum);
                    System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);
                } else if ("minus".equals(operation)) {
                    out.println("The difference between " + num1 + " and " + num2 + " is " + diff);

                } else if ("divide".equals(operation)) {
                    if (num2 != 0) {
                        // Ensure num2 is not zero to avoid division by zero
                        double quotient = (double) num1 / num2;
                        out.println(num1 + " divided by " + num2 + " is " + quotient);
                    } else {
                        out.println("It is impossible to divide number by zero !");
                    }

                } else if ("mut".equals(operation)) {
                    out.println(num1 + " multiply  " + num2 + " is " + num1*num2 );
                } else if ("mod".equals(operation)) {
                    out.println(num1 + " modulus " + num2 + " is " + num1%num2);

                } else {
                    out.println("Invalid operator ");
                }
            }else {
                System.out.println("Please insert the first number and the second number then make operation ! ");
                out.println("Please insert the first number and the second number then  make the operation");
        }
        }catch (Exception e){
            out.println("Internal server error  ... ");
            System.out.println("Error : " + e.getMessage());

        }
    }
}


