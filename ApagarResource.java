/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import javax.ws.rs.*;

@Path("/apagar")
public class ApagarResource{
    @GET
    @Produces("text/html")
    public String apagar(@QueryParam("codigo") @DefaultValue(" ") String cod) {
        Integer codigo = Integer.parseInt(cod);
        String nome = ItemApplication.getItem(codigo).nome;
        ItemApplication.listaItens.remove(ItemApplication.getItem(codigo));
        for(int i=codigo; i<ItemApplication.listaItens.size(); i++){
            ItemApplication.getItem(i+1).setCodigo(i);
        }
        String css = "<style> *{ font-family:Cambria, Geneva, sans-serif;} html{  height: 100%;} body{ background-color: #88935F;padding: 0; margin: 0;} .header{width: 100%; height:80px; background-color:#374401; color: white; padding:10px;font-size: 50px;} .header a{float:right; text-decoration: none; color: white; padding-right: 20px;font-size: 20px; margin-top:25;} .header a:hover{color:#A3B171;}</style>";
        String html = "<html><head>$style<meta charset=\"UTF-8\"><title>Sucesso!</title></head>";
        html += "<body><div class=\"header\">Biblioteca Virtual";
        html +="<a href=\"listar\">Voltar à Lista</a></div>";
        html += "<h2>Item removido!</h2><p>"+nome+" foi removido da lista.</p></body></html>";
        html = html.replace("$style", css);
        return html;

    }
}
