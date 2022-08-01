package view;

import controller.ReportesController;
import model.vo.ComprasDeLiderVo;
import model.vo.DeudasPorProyectoVo;
import model.vo.ProyectoBancoVo;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ReportesView {
    
    private static final ReportesController reporterController = new ReportesController();
    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s",
                    "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            // TODO Imprimir en pantalla la información del proyecto

            if (banco.equals("Conavi")) {
                try {
                    ArrayList<ProyectoBancoVo> bancoVos = reporterController.consultarProyectoBancoVos();
                    for (ProyectoBancoVo proyectoBancoVo: bancoVos) {
                        System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s",
                                proyectoBancoVo.getId(),
                                proyectoBancoVo.getConstructora(),
                                proyectoBancoVo.getCuidad(),
                                proyectoBancoVo.getClasificacion(),
                                proyectoBancoVo.getEstrato(),
                                proyectoBancoVo.getLider())
                        );
                        /** proyectoBancoVo.getId();
                         proyectoBancoVo.getConstructora();
                         proyectoBancoVo.getCuidad();
                         proyectoBancoVo.getClasificacion();
                         proyectoBancoVo.getEstrato();
                         proyectoBancoVo.getLider();*/
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Ha ocurrido un error" + e);
                }
            }
        }
    }

    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %15s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));
            // TODO Imprimir en pantalla la información del total adeudado
            try {
                ArrayList<DeudasPorProyectoVo> deudasPorProyectos = reporterController.consultarDeudasProyectos();
                for (DeudasPorProyectoVo listadoDeudas: deudasPorProyectos) {
                    double numeroSinFormato = listadoDeudas.getValor();

                    DecimalFormat formato = new DecimalFormat("#,###.0");
                    String valorFormateado = formato.format(numeroSinFormato);

                    System.out.println(String.format("%3s %15s",
                            listadoDeudas.getId(),
                            valorFormateado
                    ));
                }
            } catch (Exception e) {
                throw new RuntimeException("Ha ocurrido un error al consultar las deudas de los proyectos" + e);
            }
        }
    }

    public void lideresQueMasGastan() {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %15s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));
        // TODO Imprimir en pantalla la información de los líderes
        try {
            ArrayList<ComprasDeLiderVo> comprasLideres = reporterController.consultarLiderMasCompradores();
            for (ComprasDeLiderVo listaLideres: comprasLideres) {
                double valorSinFormato = listaLideres.getValor();

                DecimalFormat nuevoformato = new DecimalFormat("#,###.0");
                String nuevoValorFormateado = nuevoformato.format(valorSinFormato);

                System.out.println(String.format("%-25s %15s",
                        listaLideres.getLider(),
                        nuevoValorFormateado
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ocurrio un error consultando los lides que mas compran" + e);
        }
    }
}
