package Testes;

import Controllers.CidadeDAO;
import Controllers.PessoaDAO;
import Controllers.PessoaEnderecoDAO;

import Models.Cidade;
import Models.Estado;
import Models.Pessoa;
import Models.PessoaEndereco;
import java.sql.SQLException;
import java.time.LocalDate;

public class TesteCategoria {

    public static void main(String[] args) {

        CidadeDAO cidadeDAO = new CidadeDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();
        PessoaEnderecoDAO pessoaEnderecoDAO = new PessoaEnderecoDAO();

        Cidade cidade = new Cidade(1, "", new Estado());

        Pessoa pessoa = new Pessoa(1, "", "", LocalDate.now());
        
        PessoaEndereco pessoaEndereco = new PessoaEndereco("di", "dad", "df", pessoa, cidade);
        
        try {
            System.out.println(pessoaEnderecoDAO.add(pessoaEndereco));

        } catch (SQLException ex) {
            System.out.println("ERRO:" + ex.getMessage());
        }

    }
};