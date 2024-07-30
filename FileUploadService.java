/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@WebServlet("/api/upload")
@MultipartConfig
public class FileUploadService extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        String filename = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        File uploads = new File("./");//Caminho da pasta em que os arquivos upados serão salvos
        File file = new File(uploads, filename+".pdf");
        try (InputStream fileContent = filePart.getInputStream()) {
            Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            response.sendRedirect("/bibliotecavirtual2-1.0-SNAPSHOT/api/incluir?filename=" + filename);
        } catch (IOException e) {
            response.sendRedirect("/bibliotecavirtual2-1.0-SNAPSHOT/api/erroupload");
        }
    }

}
