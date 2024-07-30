/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.*;

@ApplicationPath("/api")
public class ItemApplication extends Application {
    protected static ArrayList<Itens> listaItens = new ArrayList<>();

    protected static Itens getItem(Integer codigo){
        for(Itens item : ItemApplication.listaItens){
            if(item.codigo.equals(codigo)){
                return item;
            }
        }
        return null;
    }

    protected static String itensToHTML() {

        String html = "<div class=\"estante\">$livros</div>";


        String livros = "";
        for (int i=0;i<listaItens.size();++i) {
            livros += "<a href=\"visualisar?item=" + String.valueOf(listaItens.get(i).codigo) + "\">" + "<div class=\"book\" style=\"background-color:"+listaItens.get(i).cor+"; border-left: 2px solid #2F1B04;\"><h2>"+listaItens.get(i).nome+"</h2></div>" +"</a>";
        }
        html = html.replace("$livros", livros);
        return html;
    }

}
