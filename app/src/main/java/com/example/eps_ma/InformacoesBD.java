package com.example.eps_ma;

public class InformacoesBD {

    private String curso;
    private String inicio;
    private String termino;
    private String ch;
    private String alunos_formados;

    public InformacoesBD (String curso, String inicio, String termino, String ch, String alunos_formados){
        this.curso = curso;
        this.inicio = inicio;
        this.termino = termino;
        this.ch = ch;
        this.alunos_formados = alunos_formados;

    }

    public InformacoesBD (){

    }

    public String getcurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getAlunos_formados() {
        return alunos_formados;
    }

    public void setAlunos_formados(String alunos_formados) {
        this.alunos_formados = alunos_formados;
    }
}
