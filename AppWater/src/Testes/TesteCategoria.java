package Testes;

import Controllers.EstadoDAO;
import Controllers.PaisDAO;

import Models.Estado;
import Models.Pais;
import java.sql.SQLException;

public class TesteCategoria {

    public static void main(String[] args) {

        EstadoDAO dao = new EstadoDAO();      
        
        PaisDAO paisDao = new PaisDAO();


        Pais c1 = new Pais(12,"Brasil");
        

        try {
            System.out.println(dao.getList());
            
                        System.out.println(paisDao.getList());


        } catch (SQLException ex) {
            System.out.println("ERRO:" + ex.getMessage());
        }

    }
};