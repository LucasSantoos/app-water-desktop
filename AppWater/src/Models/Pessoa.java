package Models;

import java.time.LocalDate;

public class Pessoa {

    private int id;
    private String nome;
    private String cpf;
    private LocalDate dtNasc;

    public Pessoa() {
        this.setId(0);
        this.setNome("padrão");
    }

    public Pessoa(int id, String nome, String cpf, LocalDate dtNasc) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setDtNasc(dtNasc);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty() ? "PADRÃO" : nome.toUpperCase();
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty() ? "000000000" : cpf;
    }

    public void setDtNasc(LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }
}
