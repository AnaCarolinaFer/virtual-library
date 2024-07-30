/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import javax.ws.rs.*;

@Path("/visualisar")
public class VisualizarResource {
    @GET
    @Produces("text/html")
    public String visualizar(@QueryParam("item") @DefaultValue("") String item) {
        Integer codigo = Integer.parseInt(item);
        String html = "<html><head>$style<meta charset=\"UTF-8\"><title>" + ItemApplication.getItem(codigo).nome +"</title></head>";
        html += "<body><div class=\"header\">Biblioteca Virtual";
        html +="<a href=\"listar\">Voltar à Lista</a></div>";
        html += "<div class=\"container\"><h2>" + ItemApplication.getItem(codigo).nome +"&nbsp;&nbsp;&nbsp;<a href=\"editar?nome=" + item + "\"><img src=\"https://cdn-icons-png.flaticon.com/512/1159/1159633.png\" alt=\"Editar\" width=\"20\"height=\"20\"></img></a>";
        html += "&nbsp;&nbsp;&nbsp;<a href=\"apagar?codigo=" + item + "\"><img src=\"https://cdn-icons-png.flaticon.com/512/1483/1483063.png\" alt=\"Apagar\" width=\"20\"height=\"20\"></img></a></h2>";
        html += "<p>Autor(es): " + ItemApplication.getItem(codigo).autores +"</p>";
        html+= "<p>Tipo: " + ItemApplication.getItem(codigo).tipo +"</p>";
        html+= "<p>Tematica: " + ItemApplication.getItem(codigo).tematica +"</p>";
        html+= "<p>Ano de publicação: " + ItemApplication.getItem(codigo).ano +"</p>";
        html+= "<p>Sinopse: " + ItemApplication.getItem(codigo).sinopse +"</p>";
        html+= "<p>Estado: " + ItemApplication.getItem(codigo).estado +"</p>";
        html+= "<p>Qualidade: " + ItemApplication.getItem(codigo).estrelas +"</p>";
        html += "</p>";
        html += "<p>Arquivo: " + ItemApplication.getItem(codigo).arquivo +"</p>";
        html += " <br><div id=\"download-div\">" +
                "<form method=\"GET\" action=\"download\\" + ItemApplication.getItem(codigo).arquivo + "\">" +
                "<input id=\"download-image\" type=\"submit\" value=\"Download\">\n" +
                "</form><br>" +
                "</div></div></body></html>";
        String css = "<style> *{ font-family:Cambria, Geneva, sans-serif;} html{  height: 100%;} body{ background-color: #88935F;padding: 0; margin: 0;} .header{width: 100%; height:80px; background-color:#374401; color: white; padding:10px;font-size: 50px;} .header a{float:right; text-decoration: none; color: white; padding-right: 20px;font-size: 20px; margin-top:25;} .header a:hover{color:#A3B171;}.container{text-align: center; margin-left:auto; margin-right:auto; margin-top:40px; height: 500px; width:500px; background-color: white; padding:15px; border-style:solid; border-color:" +ItemApplication.getItem(codigo).cor + ";border-radius:10px;}</style>";
        html = html.replace("$style", css);
        return html;
    }
}
