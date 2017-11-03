
import view.Adjustments.DataAdjustment;
import org.junit.Test;

import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTest {

    @Test
    public void TestaRegulaData() throws ParseException {
        int mes = 11;
        int ano = 2017;

        Date esperado = new SimpleDateFormat("dd/MM/yyyy").parse("15/11/2017");
        Date date = DataAdjustment.regulaData(mes, ano);
        assertEquals(esperado, date);
    }
}
