/*
Integrantes do grupo:
Gustavo Vilares Mariz de Oliveira - 121073784
Ana Carolina Ferreira de Figueiredo - 121044191
Andrew da Silva Faria - 121081559
 */

package br.ufrj.ic.bibliotecavirtual2;

import java.util.*;

public class Itens extends ItemApplication{

    public String nome;
    public String tipo;
    public Set<String> tipos;
    public String autores;
    public String tematica;
    public Set<String> tematicas;
    public String ano;
    public String sinopse;
    public Integer codigo;
    public String estado;
    public String estrelas;
    public String cor;
    public String arquivo;


    public void setItens(String nome, String tipo, String autores, String tematica,  String ano,String sinopse, String estado, String estrelas, String cor){
        this.nome = nome;
        this.tipo=tipo;
        this.tipos = new HashSet<>();
        this.tipos.add("livro");
        this.tipos.add("revista");
        this.tipos.add("artigo");
        this.autores=autores;
        this.ano = ano;
        this.tematica=tematica;
        this.tematicas = new HashSet<>();
        this.tematicas.add("Fantasia, Horror e Ficção Científica");
        this.tematicas.add("Romance");
        this.tematicas.add("Policial, Suspense e Mistério");
        this.tematicas.add("Aventura");
        this.tematicas.add("Inglês e Outras Línguas");
        this.tematicas.add("LGBTQ+");
        this.tematicas.add("Arte, Cinema e/ou Fotografia");
        this.tematicas.add("Biografia e/ou Histórias Reais");
        this.tematicas.add("Educação, Referência e/ou Didáticos");
        this.tematicas.add("Infantis");
        this.tematicas.add("Religião e/ou Espiritualidade");
        this.tematicas.add("Esportes e/ou recreação ao ar livre ativa");
        this.tematicas.add("Informática e/ou Tecnologia da Informação");
        this.tematicas.add("Saúde, Relacionamentos e/ou Autoajuda");
        this.tematicas.add("Qs, Mangás e/ou Graphic Novels");
        this.sinopse=sinopse;
        this.estado = estado;
        this.estrelas = estrelas;
        this.cor = cor;
    }

    public void setCodigo(Integer codigo){
        this.codigo = codigo;
    }
    public void setArquivo(String arquivo){this.arquivo = arquivo;}

    public boolean verifItem(){
        if(this.nome==null){
            return false;
        }
        if(!(this.tipos.contains(this.tipo))){
            return false;
        }
        if(!(this.tematicas.contains(this.tematica))){
            return false;
        }
        if(this.autores==null){
            return false;
        }
        if(this.sinopse==null){
            return false;
        }

        if(this.ano==null){
            return false;
        }
        if(this.estrelas==null){
            return false;
        }

        return true;
    }

}
