import view.ReportesView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class App {
    public static void main(String[] args) {
        System.out.println("hola mundo");
        ReportesView view1 = new ReportesView();
        var limiteInferior = 50_000d;
        view1.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);

        ReportesView view2  = new ReportesView();
        var banco = "Conavi";
        view2.proyectosFinanciadosPorBanco(banco);

        ReportesView view3 = new ReportesView();
        view3.lideresQueMasGastan();

        /*var reportesView = new ReportesView();
        var banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco);*/

     /*   double numero = 4874647.0/3;
        NumberFormat formatoNumero = NumberFormat.getNumberInstance();
        System.out.println(formatoNumero.format(numero));
        //Muestra 1.624.882,333
        formatoNumero.setMaximumFractionDigits(1);
        System.out.println(formatoNumero.format(numero));
        //Muestra 1.624.882,3*/

        // Creación de un formato con separadores de decimales y millares, con 2 decimales
        // DecimalFormat formato = new DecimalFormat("#,###.00");
        // String valorFormateado = formato.format(123456.789);
        // Muestra en pantalla el valor 123.456,79 teniendo en cuenta que se usa la puntuación española
        // System.out.println(valorFormateado);
    }
}
