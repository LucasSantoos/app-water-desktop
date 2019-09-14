
package Enums;

public enum Siglas {
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    PR("Paraná"),
    SP("São Paulo"),
    RJ("Rio de Janeiro"),
    MG("Minas Gerais"),
    ES("Espírito Santo");
    //
    private String descricao;
    //
    private Siglas(String descricao) {
        this.descricao = descricao;
    }
    //
    public String toString(){
        return descricao;
    }
    
}
