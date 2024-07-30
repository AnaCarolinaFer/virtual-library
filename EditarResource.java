package br.ufrj.ic.bibliotecavirtual2;
/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */


import javax.ws.rs.*;

@Path("/editar")
public class EditarResource {
    @GET
    @Produces("text/html")
    public String editar(@QueryParam("nome") @DefaultValue(" ") String nome) {
        Integer codigo = Integer.parseInt(nome);
        String html = "<html><head><style>$style</style><meta charset=\"UTF-8\"><title>Editar Item</title></head>";
        html += "<body><div class=\"header\">Biblioteca Virtual";
        html +="<a href=\"listar\">Voltar à Lista</a></div>";
        html+= "<h2>  Editar Item: " + ItemApplication.getItem(codigo).nome + "</h2><p><div >$formeditar$cod</div><p><a href=\"listar\">Cancelar</a></p></body></html>";
        html = html.replace("$formeditar", htmlForm(codigo));
        html = html.replace("$cod", htmlSelect(codigo));
        String css ="*{ font-family:Cambria, Geneva, sans-serif;} html{  height: 100%;} body{ background-color: #88935F;padding: 0; margin: 0;} .header{width: 100%; height:80px; background-color:#374401; color: white; padding:10px;font-size: 50px;} .header a{float:right; text-decoration: none; color: white; padding-right: 20px;font-size: 20px; margin-top:25;} .header a:hover{color:#A3B171;} input[type=text]{border: 2px solid darkgreen; border-radius: 4px; width: 50%; height: 30px;} #container{margin-left: auto; margin-right: auto; text-align:center; color:white; } .categoria{font-size: 25px;} .select{font-size:20px;}";
        html = html.replace("$style", css);
        return html;
    }

    private String htmlSelect(Integer codigo) {
        String selecthtml = "<select name=\"codigo\" size=\"1\" form=\"editando\" style=\"visibility: hidden;\">";
        selecthtml += "<option value=" + codigo.toString() + " selected> Codigo </option></select>";
        return selecthtml;
    }

    private String htmlTipo(Integer codigo) {
        String formhtml="";
        if (ItemApplication.getItem(codigo).tipo.equals("livro")) {
            formhtml += "<td align=\"left\"><select name=\"tipo\" form=\"editando\"><option value=\"revista\">Revista</option>";
            formhtml += "<option value=\"livro\" selected>Livro</option><option value=\"artigo\">Artigo</option></select></td>";
        }
        if (ItemApplication.getItem(codigo).tipo.equals("artigo")) {
            formhtml += "<td align=\"left\"><select name=\"tipo\" form=\"editando\"><option value=\"revista\">Revista</option>";
            formhtml += "<option value=\"livro\">Livro</option><option value=\"artigo\" selected>Artigo</option></select></td>";
        }
        if (ItemApplication.getItem(codigo).tipo.equals("revista")) {
            formhtml += "<td align=\"left\"><select name=\"tipo\" form=\"editando\"><option value=\"revista\" selected>Revista</option>";
            formhtml += "<option value=\"livro\">Livro</option><option value=\"artigo\">Artigo</option></select></td>";
        }
        return formhtml;
    }

    private String htmlEstado(Integer codigo) {
        String formhtml = "";
        if(ItemApplication.getItem(codigo).estado.equals("Quero Ler")) {
            formhtml += "<td align=\"left\"><select name=\"estado\" form=\"editando\"><option value=\"Lendo\">Lendo</option>";
            formhtml += "<option value=\"Quero Ler\" selected>Quero Ler</option><option value=\"Lido\">Lido</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).estado.equals("Lendo")){
            formhtml += "<td align=\"left\"><select name=\"estado\" form=\"editando\"><option value=\"Lendo\" selected>Lendo</option>";
            formhtml += "<option value=\"Quero Ler\" >Quero Ler</option><option value=\"Lido\">Lido</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).estado.equals("Lido")){
            formhtml += "<td align=\"left\"><select name=\"estado\" form=\"editando\"><option value=\"Lendo\">Lendo</option>";
            formhtml += "<option value=\"Quero Ler\" >Quero Ler</option><option value=\"Lido\" selected>Lido</option></select></td>";
        }
        return formhtml;
    }

    private String htmlEstrelas(Integer codigo){
        String formhtml = "";
        if(ItemApplication.getItem(codigo).estrelas.equals("Perfeito")){
            formhtml += "<td align=\"left\"><select name=\"estrelas\" form=\"editando\"><option value=\"Perfeito\" selected>Perfeito</option>";
            formhtml += "<option value=\"Ótimo\" s>Ótimo</option><option value=\"Bom\">Bom</option>";
            formhtml += "<option value=\"Razoável\">Razoável</option><option value=\"Ruim\">Ruim</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).estrelas.equals("Ótimo")){
            formhtml += "<td align=\"left\"><select name=\"estrelas\" form=\"editando\"><option value=\"Perfeito\" >Perfeito</option>";
            formhtml += "<option value=\"Ótimo\" selected>Ótimo</option><option value=\"Bom\">Bom</option>";
            formhtml += "<option value=\"Razoável\">Razoável</option><option value=\"Ruim\">Ruim</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).estrelas.equals("Bom")){
            formhtml += "<td align=\"left\"><select name=\"estrelas\" form=\"editando\"><option value=\"Perfeito\" >Perfeito</option>";
            formhtml += "<option value=\"Ótimo\" >Ótimo</option><option value=\"Bom\" selected>Bom</option>";
            formhtml += "<option value=\"Razoável\">Razoável</option><option value=\"Ruim\">Ruim</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).estrelas.equals("Razoável")){
            formhtml += "<td align=\"left\"><select name=\"estrelas\" form=\"editando\"><option value=\"Perfeito\" >Perfeito</option>";
            formhtml += "<option value=\"Ótimo\">Ótimo</option><option value=\"Bom\">Bom</option>";
            formhtml += "<option value=\"Razoável\" selected>Razoável</option><option value=\"Ruim\">Ruim</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).estrelas.equals("Ruim")){
            formhtml += "<td align=\"left\"><select name=\"estrelas\" form=\"editando\"><option value=\"Perfeito\" >Perfeito</option>";
            formhtml += "<option value=\"Ótimo\" >Ótimo</option><option value=\"Bom\">Bom</option>";
            formhtml += "<option value=\"Razoável\">Razoável</option><option value=\"Ruim\" selected>Ruim</option></select></td>";
        }
        return formhtml;
    }

    private String htmlTematica(Integer codigo){
        String formhtml = "";
        if(ItemApplication.getItem(codigo).tematica.equals("Fantasia, Horror e Ficção Científica")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" selected>Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\">Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\">Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\">Inglês e Outras Línguas</option><option value=\"LGBTQ+\">LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\">Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\">Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\">Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Romance")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" selected>Romance</option><option value=\"Policial, Suspense e Mistério\">Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\">Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\">Inglês e Outras Línguas</option><option value=\"LGBTQ+\">LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\">Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\">Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\">Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Policial, Suspense e Mistério")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" selected>Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\">Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\">Inglês e Outras Línguas</option><option value=\"LGBTQ+\">LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\">Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\">Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\">Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Aventura")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" selected>Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\">Inglês e Outras Línguas</option><option value=\"LGBTQ+\">LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\">Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\">Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\">Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Inglês e Outras Línguas")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" >Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\" selected>Inglês e Outras Línguas</option><option value=\"LGBTQ+\">LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\">Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\">Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\">Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("LGBTQ+")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" >Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\" >Inglês e Outras Línguas</option><option value=\"LGBTQ+\" selected>LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\">Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\">Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\">Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Arte, Cinema e/ou Fotografia")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" >Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\" >Inglês e Outras Línguas</option><option value=\"LGBTQ+\" >LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\" selected>Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\">Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\">Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Biografia e/ou Histórias Reais")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" >Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\" >Inglês e Outras Línguas</option><option value=\"LGBTQ+\" >LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\" >Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\" selected>Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\">Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Educação, Referência e/ou Didáticos")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" >Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\" >Inglês e Outras Línguas</option><option value=\"LGBTQ+\" >LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\" >Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\" >Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\" selected>Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Infantis")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" >Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\" >Inglês e Outras Línguas</option><option value=\"LGBTQ+\" >LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\" >Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\" >Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\" >Educação, Referência e/ou Didáticos</option><option value=\"Infantis\" selected>Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Religião e/ou Espiritualidade")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" >Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\" >Inglês e Outras Línguas</option><option value=\"LGBTQ+\" >LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\" >Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\" >Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\" >Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\" selected>Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Esportes e/ou recreação ao ar livre ativa")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" >Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\" >Inglês e Outras Línguas</option><option value=\"LGBTQ+\" >LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\" >Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\" >Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\" >Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\" selected>Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Informática e/ou Tecnologia da Informação")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" >Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\" >Inglês e Outras Línguas</option><option value=\"LGBTQ+\" >LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\" >Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\" >Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\" >Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\" selected>Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\">Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Saúde, Relacionamentos e/ou Autoajuda")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" >Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\" >Inglês e Outras Línguas</option><option value=\"LGBTQ+\" >LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\" >Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\" >Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\" >Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\" selected>Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\">Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        if(ItemApplication.getItem(codigo).tematica.equals("Qs, Mangás e/ou Graphic Novels")){
            formhtml += "<td align=\"left\"><select name=\"tematica\" form=\"editando\"><option value=\"Fantasia, Horror e Ficção Científica\" >Fantasia, Horror e Ficção Científica</option>";
            formhtml += "<option value=\"Romance\" >Romance</option><option value=\"Policial, Suspense e Mistério\" >Policial, Suspense e Mistério</option>";
            formhtml += "<option value=\"Aventura\" >Aventura</option>";
            formhtml += "<option value=\"Inglês e Outras Línguas\" >Inglês e Outras Línguas</option><option value=\"LGBTQ+\" >LGBTQ+</option>";
            formhtml += "<option value=\"Arte, Cinema e/ou Fotografia\" >Arte, Cinema e/ou Fotografia</option><option value=\"Biografia e/ou Histórias Reais\" >Biografia e/ou Histórias Reais</option>";
            formhtml += "<option value=\"Educação, Referência e/ou Didáticos\" >Educação, Referência e/ou Didáticos</option><option value=\"Infantis\">Infantis</option>";
            formhtml += "<option value=\"Religião e/ou Espiritualidade\">Religião e/ou Espiritualidade</option><option value=\"Esportes e/ou recreação ao ar livre ativa\">Esportes e/ou recreação ao ar livre ativa</option>";
            formhtml += "<option value=\"Informática e/ou Tecnologia da Informação\">Informática e/ou Tecnologia da Informação</option><option value=\"Saúde, Relacionamentos e/ou Autoajuda\" >Saúde, Relacionamentos e/ou Autoajuda</option>";
            formhtml += "<option value=\"Qs, Mangás e/ou Graphic Novels\" selected>Qs, Mangás e/ou Graphic Novels</option></select></td>";
        }
        return formhtml;
    }

    private String htmlForm(Integer codigo) {
        String formhtml = "<form method=\"GET\" action=\"salvareditado\" id=\"editando\">";
        formhtml+= "<b>Nome:</b><br>";
        formhtml += "<input type=\"text\" name=\"nome\" value=\""+ ItemApplication.getItem(codigo).nome +"\"></input><br>";
        formhtml+= "<form><b>Tipo:</b><br>$tipo<br>";
        formhtml+= "<form><b>Tematica:</b><br>$tematica<br>";
        formhtml+= "<form><b>Ano:</b><br>";
        formhtml += "<input type=\"text\" name=\"ano\" value=\""+ItemApplication.getItem(codigo).ano + "\"></input><br>";
        formhtml+= "<form><b>Autores:</b><br>";
        formhtml += "<input type=\"text\" name=\"autores\" value=\""+ItemApplication.getItem(codigo).autores + "\"></input><br>";
        formhtml+= "<form><b>Sinopse:</b><br>";
        formhtml += "<input type=\"text\" name=\"sinopse\" value=\""+ItemApplication.getItem(codigo).sinopse + "\"></input><br>";
        formhtml += "<form><b>Estado:</b><br>$estado<br>";
        formhtml += "<form><b>Qualidades:</b><br>$estrelas<br>";
        formhtml += "<input type=\"color\" id=\"cor\" name=\"cor\" value=\""+ ItemApplication.getItem(codigo).cor+"\"><label for=\"cor\">Cor do Item</label><br>";
        formhtml += "<input type=\"submit\" value=\"Editar\"></input></form>";
        formhtml = formhtml.replace("$tipo", htmlTipo(codigo));
        formhtml = formhtml.replace("$estado", htmlEstado(codigo));
        formhtml = formhtml.replace("$estrelas", htmlEstrelas(codigo));
        formhtml = formhtml.replace("$tematica", htmlTematica(codigo));
        return formhtml;
    }
}
