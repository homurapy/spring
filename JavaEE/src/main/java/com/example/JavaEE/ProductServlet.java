package com.example.JavaEE;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "productServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private Product[] products;

    public void init() {
        products = new Product[]{new Product(1,"говядина", 700), new Product(2, "свинина",400),
                new Product(3, "курятина",250), new Product(4, "индюшатина",450),
                new Product(5, "крольчатина",800), new Product(6, "медвежатина",1500),
                new Product(7, "помидор",199),new Product(8, "картофель",50),
                new Product(9, "макароны",100),new Product(10, "лук",25)};
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (Product product : products) {
            out.println("<p>" + product.getId()+ ". " + product.getTitle() +" - " + product.getCost() + "</p>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}