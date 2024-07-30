/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import javax.ws.rs.*;

@Path("/listar")
public class ItemResource {
    @GET
    @Produces("text/html")
    public String listar() {

        String css = "<style> *{ font-family:Cambria, Geneva, sans-serif;} html{  height: 100%;} body{ background-color: #88935F;padding: 0; margin: 0;} .header{width: 100%; height:80px; background-color:#374401; color: white; padding:10px;font-size: 50px;} .header a{float:right; text-decoration: none; color: white; padding-right: 20px;font-size: 20px; margin-top:25;} .header a:hover{color:#A3B171;} .estante{ height:100%; width:80%; margin-top: 80px; margin-left:auto; margin-right:auto; border: 10px #A87328 solid; overflow: hidden; background-image: linear-gradient(#2F1B04,#2F1B04 220px, #A87328 220px, #A87328 222px, #A87328 222px, #A87328 228px,#2F1B04 228px,#2F1B04 230px); background-size: 10px 230px;} .book{height: 200px; width: 40px; float: left; color: white; font-size: 0.9em; margin-bottom: 10px; margin-top: 20px; transition: transform 0.4s ease;} .book-green{ background-color: darkgreen; border-left: 2px solid green;} .book h2{ padding: 0; font-size: 1em; transform-origin: 0% 0%;transform: rotate(0.25turn) translateY(-35px); width: 170px;} .book:hover{transform: scale(1.05);}</style>";

        String html = "<html><head>$style<meta charset=\"UTF-8\"><title>Página Principal</title></head>";
        html += "<body><div class=\"header\">Biblioteca Virtual";
        html += "<a href=\"preupload\">Incluir novo item</a>";
        html += "<a href=\"buscarfiltro\">Buscar</a>";
        html += "<a href=\"listacompleta?filtro=nenhum\">Biblioteca Completa</a>";
        html+="</div>$listaitens";
        html+="</body></html>";
        html = html.replace("$style", css);
        html = html.replace("$listaitens",ItemApplication.itensToHTML());
        return html;
    }
}
