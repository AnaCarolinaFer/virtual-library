/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/api/download/*")
public class FileDownloadService extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/pdf");
        PrintWriter out = response.getWriter();

        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");

        Path path = Paths.get(filename);

        String filepath = path.toAbsolutePath().toString();


        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");

        FileInputStream fileInputStream = new FileInputStream(filepath+ ".pdf");

        int i;
        while ((i=fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }
}