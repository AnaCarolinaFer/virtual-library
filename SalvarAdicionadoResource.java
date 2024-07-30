/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import javax.ws.rs.*;

@Path("/salvaradicionado")
public class SalvarAdicionadoResource {
    @GET
    @Produces("text/html")
    public String salvar(@QueryParam("nome") @DefaultValue("") String nome, @QueryParam("tipo") @DefaultValue("") String tipo,
                         @QueryParam("tematica") @DefaultValue("") String tematica,@QueryParam("ano") @DefaultValue("") String ano,
                         @QueryParam("autores") @DefaultValue("") String autores, @QueryParam("sinopse") @DefaultValue("") String sinopse,
                         @QueryParam("estado") @DefaultValue("") String estado, @QueryParam("estrelas") @DefaultValue("") String estrelas,
                         @QueryParam("cor") @DefaultValue("") String cor,@QueryParam("filename") @DefaultValue("") String filename) {
        Itens item = new Itens();
        item.setItens(nome, tipo, autores, tematica, ano, sinopse, estado, estrelas, cor);
        item.setArquivo(filename);
        String css = "<style> *{ font-family:Cambria, Geneva, sans-serif;} html{  height: 100%;} body{ background-color: #88935F;padding: 0; margin: 0;} .header{width: 100%; height:80px; background-color:#374401; color: white; padding:10px;font-size: 50px;} .header a{float:right; text-decoration: none; color: white; padding-right: 20px;font-size: 20px; margin-top:25;} .header a:hover{color:#A3B171;}</style>";
        if (item.verifItem()) {
            for(Itens i : ItemApplication.listaItens){
                if (i.equals(item)) {
                    String html = "<html><head>$style<meta charset=\"UTF-8\"><title>Erro!</title></head>";
                    html += "<body><div class=\"header\">Biblioteca Virtual";
                    html +="<a href=\"listar\">Voltar à Lista</a></div>";
                    html += "<body><h2>Erro ao adicionar!</h2><p>" + item.nome + " já esta presente na lista!</p></body></html>";
                    html = html.replace("$style", css);
                    return html;
                }
            }
            ItemApplication.listaItens.add(item);
            item.setCodigo(ItemApplication.listaItens.indexOf(item));
            String html = "<html><head>$style<meta charset=\"UTF-8\"><title>Sucesso!</title></head>";
            html += "<body><div class=\"header\">Biblioteca Virtual";
            html +="<a href=\"listar\">Voltar à Lista</a></div>";
            html += "<h1>Novo item adicionado!</h1><p>"+item.nome+" foi adicionado à lista.</p></body></html>";
            html = html.replace("$style", css);
            return html;
        } else {
            String html = "<html><head>$style<meta charset=\"UTF-8\"><title>Erro!</title></head>";
            html += "<body><div class=\"header\">Biblioteca Virtual";
            html +="<a href=\"listar\">Voltar à Lista</a></div>";
            html += "<body><h2>Erro ao adicionar!</h2><p>Verifique se há alguma informação faltando ou se algum dado foi preenchido incorretamente.</p></body></html>";
            html = html.replace("$style", css);
            return html;
        }
    }

}
