package Models;

import Enums.TipoPessoa;
import java.time.LocalDate;

public class Pessoa {

    private int id;
    private String nome;
    private String cpf;
    private LocalDate dtNasc;
    private TipoPessoa tipoPessoa;

    public Pessoa(int id, String nome, String cpf, LocalDate dtNasc, TipoPessoa tipoPessoa) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
        this.setDtNasc(dtNasc);
        this.setTipoPessoa(tipoPessoa);
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
        return this.nome + " - " + this.getCpf() + " - " + this.getTipoPessoa().toString();
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

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
