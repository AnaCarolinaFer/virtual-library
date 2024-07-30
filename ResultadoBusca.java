/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import static java.util.Collections.sort;

@Path("/resultadobusca")
public class ResultadoBusca {
    @GET
    @Produces("text/html")
    public String resultadoBusca(@QueryParam("filtro") @DefaultValue("") String filtro, @QueryParam("texto") @DefaultValue("") String texto) {
        ArrayList<Integer> lista = new ArrayList<>();
        switch (filtro){
            case "tipo":
                for(Itens item : ItemApplication.listaItens){
                    if(item.tipo.equals(texto.toLowerCase(Locale.ROOT))){
                        lista.add(item.codigo);
                    }
                }
                break;

            case "tematica":
                for(Itens item : ItemApplication.listaItens){
                    if(item.tematica.toLowerCase(Locale.ROOT).contains(texto.toLowerCase(Locale.ROOT))){
                        lista.add(item.codigo);
                    }
                }
                break;

            case "nome":
                for(Itens item : ItemApplication.listaItens){
                    if(item.nome.toLowerCase(Locale.ROOT).contains(texto.toLowerCase(Locale.ROOT))){
                        lista.add(item.codigo);
                    }
                }
                break;

            case "autores":
                for(Itens item : ItemApplication.listaItens){
                    if(item.autores.toLowerCase(Locale.ROOT).contains(texto.toLowerCase(Locale.ROOT))){
                        lista.add(item.codigo);
                    }
                }
                break;

            case "ano":
                for(Itens item : ItemApplication.listaItens){
                    if(item.ano.equals(texto)){
                        lista.add(item.codigo);
                    }
                }
                break;

            case "estrelas":
                for(Itens item : ItemApplication.listaItens){
                    if(item.estrelas.equals(texto)){
                        lista.add(item.codigo);
                    }
                }
                break;

            case "estado":
                for(Itens item : ItemApplication.listaItens){
                    if(item.estado.equals(texto.toLowerCase(Locale.ROOT))){
                        lista.add(item.codigo);
                    }
                }
                break;

        }


        if(lista.size()>0) {
            String css = "<style> *{ font-family:Cambria, Geneva, sans-serif;} html{  height: 100%;} body{ background-color: #88935F;padding: 0; margin: 0;} .header{width: 100%; height:80px; background-color:#374401; color: white; padding:10px;font-size: 50px;} .header a{float:right; text-decoration: none; color: white; padding-right: 20px;font-size: 20px; margin-top:25;} .header a:hover{color:#A3B171;}</style>";
            String html = "<html><head>$style<meta charset=\"UTF-8\"><title>Sucesso!</title></head>";
            html += "<body><div class=\"header\">Biblioteca Virtual";
            html +="<a href=\"listar\">Voltar à Lista</a></div>";
            html+="<h2>Sucesso!</h2><p><a href=\"listar\">Voltar ao menu</a></p></body></html>";
            for(int i = 0; i < lista.size(); ++i) {
                html += "<p><a href=\"visualisar?item=" + String.valueOf(lista.get(i)) + "\">"+ ItemApplication.listaItens.get(lista.get(i)).nome + "</a></p>";
            }
            html = html.replace("$style", css);
            return html;
        } else{
            String css = "<style> *{ font-family:Cambria, Geneva, sans-serif;} html{  height: 100%;} body{ background-color: #88935F;padding: 0; margin: 0;} .header{width: 100%; height:80px; background-color:#374401; color: white; padding:10px;font-size: 50px;} .header a{float:right; text-decoration: none; color: white; padding-right: 20px;font-size: 20px; margin-top:25;} .header a:hover{color:#A3B171;}</style>";
            String html = "<html><head>$style<meta charset=\"UTF-8\"><title>Erro!</title></head>";
            html += "<body><div class=\"header\">Biblioteca Virtual";
            html +="<a href=\"listar\">Voltar à Lista</a></div>";
            html += "<h2>Erro!</h2><p>" + texto + " não esta presente na biblioteca.</p><p><a href=\"listar\">Voltar ao menu</a></p></body></html>";
            html = html.replace("$style", css);
            return html;
        }
    }
}
