package models.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataService {

    public static Date regulaData(int mes, int ano) throws ParseException {
        String valor = "/"+mes+"/"+ano;

        Date data = new SimpleDateFormat("dd/MM/yyyy").parse("15"+valor);

        return data;
    }

    public static java.sql.Date converte(java.util.Date data) {
        return new java.sql.Date(data.getTime());
    }

}
