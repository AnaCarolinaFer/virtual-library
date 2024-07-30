/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import javax.ws.rs.*;

@Path("/erroupload")
public class ErroUpload {
    @GET
    @Produces("text/html")
    public String listar() {
        String html = "<html><head><meta charset=\"UTF-8\"><title>Erro!</title></head>";
        html += "<body><h2>Erro ao adicionar!</h2><p>Houve um erro no upload do arquivo. Tente novamente.</p><p><a href=\"listar\">Voltar à lista</a></p></body></html>";
        return html;
    }
}
