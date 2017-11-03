package view.Adjustments;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataAdjustment {

    public static Date regulaData(int mes, int ano) throws ParseException {
        String valor = "/"+mes+"/"+ano;

        Date data = new SimpleDateFormat("dd/MM/yyyy").parse("15"+valor);

        return data;
    }

    public static String regulaData(java.util.Date data){
        String data2 = new SimpleDateFormat("MM/yyyy").format(data);
        return data2;
    }


    public static java.sql.Date converte(Date data) {
        return new java.sql.Date(data.getTime());
    }

}
