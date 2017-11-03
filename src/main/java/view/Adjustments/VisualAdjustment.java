package view.Adjustments;

import java.text.DecimalFormat;

public class VisualAdjustment {
    public static String converteTipo(String tipo) {
        if (tipo.equalsIgnoreCase("r")) {
            return "Renda";
        } else {
            return "Despesa";
        }
    }

    public static String converteTipoParcelas(String tipoParcelas) {
        if (tipoParcelas.equalsIgnoreCase("f")) {
            return "Fixo";
        } else if (tipoParcelas.equalsIgnoreCase("a")) {
            return "A vista";
        } else {
            return "Parcelado";
        }
    }

    public static String ajustaPrint(String valor, int tamanho) {
        while (valor.length() < tamanho) {
            valor = valor + " ";
        }
        return valor;
    }

    public static String ajustaDouble(double valor) {
        DecimalFormat df = new DecimalFormat("0.##");
        String dx = df.format(valor);
        return dx;
    }
}