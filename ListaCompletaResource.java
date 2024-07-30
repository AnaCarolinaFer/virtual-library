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

@Path("/listacompleta")
public class ListaCompletaResource {
    @GET
    @Produces("text/html")
    public String listacompleta(@QueryParam("filtro") String filtro) {

        ArrayList<Integer> lista = new ArrayList<>();

        switch (filtro) {
            case "nenhum":
                for (Itens item : ItemApplication.listaItens) {
                    lista.add(item.codigo);
                }
                break;

            case "nome":
                ArrayList<String> nome = new ArrayList<>();
                for (Itens item : ItemApplication.listaItens) {
                    nome.add(item.nome.toLowerCase(Locale.ROOT));
                }
                Collections.sort(nome);
                for (int i = 0; i < nome.size(); i++) {
                    for (Itens item : ItemApplication.listaItens) {
                        if (item.nome.toLowerCase(Locale.ROOT).equals(nome.get(i))) {
                            lista.add(item.codigo);
                        }
                    }
                }
                break;

            case "autores":
                ArrayList<String> autores = new ArrayList<>();
                for (Itens item : ItemApplication.listaItens) {
                    autores.add(item.autores.toLowerCase(Locale.ROOT));
                }
                Collections.sort(autores);
                for (int i = 0; i < autores.size(); i++) {
                    for (Itens item : ItemApplication.listaItens) {
                        if (item.autores.toLowerCase(Locale.ROOT).equals(autores.get(i))) {
                            lista.add(item.codigo);
                        }
                    }
                }
                break;

            case "ano":
                ArrayList<String> ano = new ArrayList<>();
                for (Itens item : ItemApplication.listaItens) {
                    ano.add(item.ano);
                }
                Collections.sort(ano);
                for (int i = 0; i < ano.size(); i++) {
                    for (Itens item : ItemApplication.listaItens) {
                        if (item.ano.equals(ano.get(i))) {
                            lista.add(item.codigo);
                        }
                    }
                }
                break;

            case "livro":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tipo.equals("livro")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case "revista":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tipo.equals("revista")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case "artigo":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tipo.equals("artigo")) {
                        lista.add(item.codigo);
                    }
                }
                break;


            case "Fantasia, Horror e Ficção Científica":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Fantasia, Horror e Ficção Científica")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case "Romance":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Romance")) {
                        lista.add(item.codigo);
                    }
                }
                break;
            case "Policial, Suspense e Mistério":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Policial, Suspense e Mistério")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case"Aventura":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Aventura")) {
                        lista.add(item.codigo);
                    }
                }
                break;


            case"Inglês e Outras Línguas":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Inglês e Outras Línguas")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case"LGBTQ+":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("LGBTQ+")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case"Arte, Cinema e/ou Fotografia":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Arte, Cinema e/ou Fotografia")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case"Biografia e/ou Histórias Reais":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Biografia e/ou Histórias Reais")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case"Educação, Referência e/ou Didáticos":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Educação, Referência e/ou Didáticos")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case"Infantis":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Infantis")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case"Religião e/ou Espiritualidade":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Religião e/ou Espiritualidade")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case"Esportes e/ou recreação ao ar livre ativa":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Esportes e/ou recreação ao ar livre ativa")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case"Informática e/ou Tecnologia da Informação":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Informática e/ou Tecnologia da Informação")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case"Saúde, Relacionamentos e/ou Autoajuda":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Saúde, Relacionamentos e/ou Autoajuda")) {
                        lista.add(item.codigo);
                    }
                }
                break;

            case"Qs, Mangás e/ou Graphic Novels":
                for (Itens item : ItemApplication.listaItens) {
                    if (item.tematica.equals("Qs, Mangás e/ou Graphic Novels")) {
                        lista.add(item.codigo);
                    }
                }
                break;

        }

        if (lista.size() > 0) {
            String css = "<style> *{ font-family:Cambria, Geneva, sans-serif;} html{  height: 100%;} body{ background-color: #88935F;padding: 0; margin: 0;} .header{width: 100%; height:80px; background-color:#374401; color: white; padding:10px;font-size: 50px;} .header a{float:right; text-decoration: none; color: white; padding-right: 20px;font-size: 20px; margin-top:25;} .header a:hover{color:#A3B171;}</style>";
            String html = "<html><head>$style<meta charset=\"UTF-8\"><title>Sucesso!</title></head>";
            html += "<body><div class=\"header\">Biblioteca Virtual";
            html +="<a href=\"listar\">Voltar à Lista</a></div>";
            html += "<h2>Biblioteca</h2><form method=\"GET\" action=\"listacompleta\">";
            html += "<select name=\"filtro\" size=\"10\">";
            html += "<option value=\"nenhum\" selected> Lista Completa</option>";
            html += "<option value=\"nome\" selected> Ordem Alfabética: Nome </option>";
            html += "<option value=\"ano\"> Ordem Cronológica: Ano </option>";
            html += "<option value=\"autores\"> Ordem Alfabética: Autor(es) </option>";
            html += "<optgroup label=\"Temáticas\"><option value=\"Fantasia, Horror e Ficção Científica\"> Fantasia, Horror e Ficção Científica </option><option value=\"Romance\"> Romance </option>";
            html += "<option value=\"Policial, Suspense e Mistério\"> Policial, Suspense e Mistério </option><option value=\"Aventura\"> Aventura</option>";
            html += "<option value=\"Inglês e Outras Línguas\"> Inglês e Outras Línguas </option><option value=\"LGBTQ+\"> LGBTQ+</option><option value=\"Arte, Cinema e/ou Fotografia\"> Arte, Cinema e/ou Fotografia </option>";
            html += "<option value=\"Biografia e/ou Histórias Reais\"> Biografia e/ou Histórias Reais </option><option value=\"Educação, Referência e/ou Didáticos\"> Educação, Referência e/ou Didáticos</option><option value=\"Infantis\"> Infantis </option>";
            html += "<option value=\"Religião e/ou Espiritualidade\"> Religião e/ou Espiritualidade </option><option value=\"Esportes e/ou recreação ao ar livre ativa\"> Esportes e/ou recreação ao ar livre ativa </option><option value=\"Informática e/ou Tecnologia da Informação\"> Informática e/ou Tecnologia da Informação</option>";
            html += "<option value=\"Saúde, Relacionamentos e/ou Autoajuda\"> Saúde, Relacionamentos e/ou Autoajuda </option><option value=\"Qs, Mangás e/ou Graphic Novels\"> Qs, Mangás e/ou Graphic Novels </option>";
            html += "<optgroup label=\"Tipo\"> <option value=\"livro\"> Livro </option> <option value=\"revista\"> Revista </option> <option value=\"artigo\"> Artigo </option>";
            html += "</select><input type=\"submit\" value=\"Buscar\"></input></form>";
            for (int i = 0; i < lista.size(); ++i) {
                html += "<p><a href=\"visualisar?item=" + String.valueOf(lista.get(i)) + "\">" + ItemApplication.listaItens.get(lista.get(i)).nome + "</a></p>";
            }
            html += "<p><a href=\"listar\">Voltar ao menu</a></p></body></html>";
            html = html.replace("$style", css);
            return html;
        } else {
            String css = "<style> *{ font-family:Cambria, Geneva, sans-serif;} html{  height: 100%;} body{ background-color: #88935F;padding: 0; margin: 0;} .header{width: 100%; height:80px; background-color:#374401; color: white; padding:10px;font-size: 50px;} .header a{float:right; text-decoration: none; color: white; padding-right: 20px;font-size: 20px; margin-top:25;} .header a:hover{color:#A3B171;}</style>";
            String html = "<html><head>$style<meta charset=\"UTF-8\"><title>Erro!</title></head>";
            html += "<body><div class=\"header\">Biblioteca Virtual";
            html +="<a href=\"listar\">Voltar à Lista</a></div>";
            html += "<h2>Lista Vazia!</h2><p>Não há itens desta categoria.</p><p><a href=\"listar\">Voltar ao menu</a></p></body></html>";
            html = html.replace("$style", css);
            return html;
        }
    }
}
