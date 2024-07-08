import javax.swing.*;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        String [] options = {"Dolar", "Euro", "Yenes", "Libras", "Franco Suizo"};
        String selection;
        double amount;
        do{
            amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad de pesos (MXN) a convertir: "));
            selection = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda a la que se desea convertir", "Conversor de monedas", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            switch (selection){
                case "Dolar":
                    Convertor(amount, "USD"); break;
                case "Euro":
                    Convertor(amount, "EUR"); break;
                case "Yenes":
                    Convertor(amount, "JPY"); break;
                case "Libras":
                    Convertor(amount, "GBP"); break;
                case "Franco Suizo":
                    Convertor(amount,"CHF"); break;
                default:
                    JOptionPane.showMessageDialog(null,"Ingrese una opcion valida");
            }

            int op = JOptionPane.showOptionDialog(null, "¿Desea hacer otra conversión?", "Exit", 0, 3,null, new String[] {"Si", "No"}, new String[] {"Si", "No"});
            if(op == 1) selection = "Salir";

        }while(!selection.equals("Salir"));
        JOptionPane.showMessageDialog(null,"Gracias por usar el programa :))");
    }

    public static void Convertor(double amount, String targetCode){
        Request request = new Request();
        double conversion = request.requestCurrency(targetCode).conversion_rate();
        double result = amount * conversion;
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        JOptionPane.showMessageDialog(null, "MXN <--> "+targetCode+"\n"+nf.format(amount)+" = "+nf.format(result));
    }
}