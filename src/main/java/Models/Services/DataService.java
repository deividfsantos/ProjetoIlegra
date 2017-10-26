package Models.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataService {

    private int mes;
    private int ano;

    public DataService(int mes, int ano) {
        this.mes = mes;
        this.ano = ano;
    }

    public static Date regulaData(int mes, int ano) throws ParseException {
        String valor = ""+mes+"/"+ano;

        Date data = new SimpleDateFormat("MM/yyyy").parse(valor);

        return data;

    }
}
