
package Enums;

public enum TipoPessoa {
    FUNCIONARIO("Funcionário"),
    CLIENTE("Cliente");

    private String descricao;    
    private TipoPessoa(String descricao) {
        this.descricao = descricao;
    }
    
    public String toString(){
        return descricao;
    }
    
}
