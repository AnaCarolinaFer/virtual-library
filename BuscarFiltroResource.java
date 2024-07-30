/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import javax.ws.rs.*;

@Path("/buscarfiltro")
public class BuscarFiltroResource {
    @GET
    @Produces("text/html")
    public String buscarfiltro() {
        String css = "<style> *{ font-family:Cambria, Geneva, sans-serif;} html{  height: 100%;} body{ background-color: #88935F;padding: 0; margin: 0;} .header{width: 100%; height:80px; background-color:#374401; color: white; padding:10px;font-size: 50px;} .header a{float:right; text-decoration: none; color: white; padding-right: 20px;font-size: 20px; margin-top:25;} .header a:hover{color:#A3B171;}</style>";
        String html = "<html><head>$style<meta charset=\"UTF-8\"><title>Buscar Item</title></head>";
        html += "<body><div class=\"header\">Biblioteca Virtual";
        html +="<a href=\"listar\">Voltar à Lista</a></div><h2>Buscar Item</h2>";
        html+="$formtexto$selectfiltro</body></html>";
        html = html.replace("$selectfiltro", htmlSelect());
        html = html.replace("$formtexto", htmlForm());
        html = html.replace("$style", css);
        return html;
    }
    private String htmlSelect() {
        String selecthtml = "<select name=\"filtro\" form=\"buscando\"><option value=\"\" selected=\"selected\">Selecione o filtro de busca:</option>";
        selecthtml += "<option value=\"nome\">Nome</option>";
        selecthtml += "<option value=\"tipo\">Tipo</option>";
        selecthtml += "<option value=\"ano\">Ano</option>";
        selecthtml += "<option value=\"autores\">Autor(es)</option>";
        selecthtml += "<option value=\"estrelas\">Qualidade</option>";
        selecthtml += "<option value=\"estado\">Estado</option>";
        selecthtml += "<option value=\"tematica\">Tematica</option></select>";
        return selecthtml;
    }

    private String htmlForm() {
        String formhtml ="<form method=\"GET\" action=\"resultadobusca\"id=\"buscando\">";
        formhtml += "<input type=\"text\" name=\"texto\"></input>";
        formhtml += "<input type=\"submit\" value=\"Buscar\"></input></form>";
        return formhtml;
    }

}
