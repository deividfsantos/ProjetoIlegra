package DAO;

import java.sql.Connection;

public class UsuarioDAO {

        private Connection con;//objeto connection que será usado nos métodos abaixo

        /*
        * Construtor que recebe como parametro uma conexao com o banco de dado.
        */
        public UsuarioDAO(Connection con) {
            this.con = con;
        }



}
