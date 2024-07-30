/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import javax.ws.rs.*;

@Path("/incluir")
public class Incluir{
    @GET
    @Produces("text/html")
    public String incluir(@QueryParam("filename") @DefaultValue("") String filename) {
        String html = "<html><head><style>$css</style><meta charset=\"UTF-8\"><title>Adicionar Dados</title></head>";
        html += "<body><div class=\"header\">Biblioteca Virtual<a href=\"listar\">Cancelar</a></div><div id=\"container\"><h1>Adicionar Dados</h1>";
        html+= "$formincluir$arquivo<body></html>";
        html = html.replace("$formincluir",htmlForm());
        html = html.replace("$arquivo", htmlSelect(filename));
        String css ="*{ font-family:Cambria, Geneva, sans-serif;} html{  height: 100%;} body{ background-color: #88935F;padding: 0; margin: 0;} .header{width: 100%; height:80px; background-color:#374401; color: white; padding:10px;font-size: 50px;} .header a{float:right; text-decoration: none; color: white; padding-right: 20px;font-size: 20px; margin-top:25;} .header a:hover{color:#A3B171;} input[type=text]{border: 2px solid darkgreen; border-radius: 4px; width: 50%; height: 30px;} #container{margin-left: auto; margin-right: auto; text-align:center; color:white; } .categoria{font-size: 25px;} .select{font-size:20px;}";
        html = html.replace("$css", css);

        return html;
    }

    private String htmlSelect(String filename) {
        String selecthtml = "<select name=\"filename\" size=\"1\" form=\"incluindo\">";
        selecthtml += "<option value="+ filename + " selected> Arquivo: "+filename+" </option></select>";
        return selecthtml;
    }


    private String htmlForm() {
        String formhtml = "<form method=\"GET\" action=\"salvaradicionado\" id=\"incluindo\">";
        formhtml += "<label for:\"nome\" class=\"categoria\">Nome:</label><br>";
        formhtml += "<input type=\"text\" name=\"nome\"></input><br>";
        formhtml += "<label for:\"tematica\" class=\"categoria\">Tematica:</label><br>";
        formhtml +="<select name=\"tematica\"><option value=\"\" selected=\"selected\">Selecione uma temática</option>";
        formhtml +="<option value=\"Fantasia, Horror e Ficção Científica\">Fantasia, Horror e Ficção Científica</option>";
        formhtml +="<option value=\"Romance\">Romance</option>";
        formhtml +="<option value=\"Policial, Suspense e Mistério\">Policial, Suspense e Mistério</option>";
        formhtml +="<option value=\"Aventura\">Aventura</option>";
        formhtml +="<option value=\"Inglês e Outras Línguas\">Inglês e Outras Línguas</option>";
        formhtml +="<option value=\"LGBTQ+\">LGBTQ+</option>";
        formhtml +="<option value=\"Arte, Cinema e/ou Fotografia\">Arte, Cinema e/ou Fotografia</option>";
        formhtml +="<option value=\"Biografia e/ou Histórias Reais\">Biografia e/ou Histórias Reais</option>";
        formhtml +="<option value=\"Educação, Referência e/ou Didáticos\">Educação, Referência e/ou Didáticos</option>";
        formhtml +="<option value=\"Infantis\">Infantis</option>";
        formhtml +="<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option>";
        formhtml +="<option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
        formhtml +="<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option>";
        formhtml +="<option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
        formhtml +="<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select><br>";
        formhtml += "<label for:\"ano\" class=\"categoria\">Ano:</b><br>";
        formhtml += "<input type=\"text\" name=\"ano\"></input><br>";
        formhtml += "<label for:\"autores\" class=\"categoria\">Autores:</b><br>";
        formhtml += "<input type=\"text\" name=\"autores\"></input><br>";
        formhtml += "<label for:\"sinopse\" class=\"categoria\">Sinopse:</b><br>";
        formhtml += "<input type=\"text\" name=\"sinopse\"></input></td><br>";
        formhtml += "<label class=\"categoria\">Tipo:</label><br>";
        formhtml += "<input type=\"radio\" id=\"livro\" name=\"tipo\" value=\"livro\">";
        formhtml += "<label for=\"livro\" class=\"select\">Livro</label>";
        formhtml += "<input type=\"radio\" id=\"artigo\" name=\"tipo\" value=\"artigo\">";
        formhtml += "<label for=\"artigo\" class=\"select\">Artigo</label>";
        formhtml += "<input type=\"radio\" id=\"revista\" name=\"tipo\" value=\"revista\">";
        formhtml += "<label for=\"revista\" class=\"select\">Revista</label><br>";
        formhtml += "<label class=\"categoria\">Estado:</label><br>";
        formhtml += "<input type=\"radio\" id=\"quero ler\" name=\"estado\" value=\"Quero Ler\">";
        formhtml += "<label for=\"quero ler\" class=\"select\">Quero Ler</label>";
        formhtml += "<input type=\"radio\" id=\"lendo\" name=\"estado\" value=\"Lendo\">";
        formhtml += "<label for=\"lendo\" class=\"select\">Lendo</label>";
        formhtml += "<input type=\"radio\" id=\"lido\" name=\"estado\" value=\"Lido\">";
        formhtml += "<label for=\"lido\" class=\"select\">Lido</label><br>";
        formhtml += "<label class=\"categoria\">Qualidade:</label><br>";
        formhtml += "<input type=\"radio\" id=\"ruim\" name=\"estrelas\" value=\"Ruim\">";
        formhtml += "<label for=\"ruim\" class=\"select\">Ruim</label>";
        formhtml += "<input type=\"radio\" id=\"razoavel\" name=\"estrelas\" value=\"Razoável\">";
        formhtml += "<label for=\"razoavel\" class=\"select\">Razoável</label>";
        formhtml += "<input type=\"radio\" id=\"bom\" name=\"estrelas\" value=\"Bom\">";
        formhtml += "<label for=\"bom\" class=\"select\">Bom</label>";
        formhtml += "<input type=\"radio\" id=\"otimo\" name=\"estrelas\" value=\"Ótimo\">";
        formhtml += "<label for=\"otimo\" class=\"select\">Ótimo</label>";
        formhtml += "<input type=\"radio\" id=\"perfeito\" name=\"estrelas\" value=\"Perfeito\">";
        formhtml += "<label for=\"perfeito\" class=\"select\">Perfeito</label><br>";
        formhtml +="<input type=\"color\" id=\"cor\" name=\"cor\"value=\"#e66465\"><label for=\"cor\">Cor do Item</label><br>";
        formhtml += "<input type=\"submit\" value=\"Incluir\"></input></form></div>";

        return formhtml;
    }
}
