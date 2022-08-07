package model.consultas;

public class Consultas {

    public String consultaBancos(String banco) {
        String consulta1 =
                "SELECT ID_Proyecto AS ID, Constructora, Ciudad, Proyecto.Clasificacion, Estrato,\n" +
                        "Nombre ||' '||Primer_Apellido ||' '|| Segundo_Apellido AS LIDER\n" +
                        "FROM Proyecto JOIN Tipo USING (ID_Tipo) JOIN Lider USING (ID_LIDER)\n" +
                        "WHERE Banco_Vinculado= '"+banco+"'\n" +
                        "ORDER BY Fecha_Inicio DESC, Ciudad ASC, Constructora;";

        return consulta1;
    }

    public String consultasAdeudados(double limiteInferior) {
        String consulta2 = "select p.ID_Proyecto, SUM(c.Cantidad * mc.Precio_Unidad) AS VALOR\n"
                + "FROM Proyecto p JOIN Compra c ON c.ID_Proyecto  = p.ID_Proyecto JOIN MaterialConstruccion mc on mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion\n"
                + "WHERE c.Pagado = 'No'\n"
                + "GROUP BY p.ID_Proyecto\n"
                + "HAVING VALOR >"+limiteInferior+"\n"
                + "order by VALOR DESC";
        return consulta2;
    }

    public String consultasAllCompras(){
        String consulta3 = "SELECT l.Nombre ||' '|| l.Primer_Apellido ||' '|| l.Segundo_Apellido AS LIDER, SUM(c.Cantidad * mc.Precio_Unidad) AS VALOR \n" +
                "FROM Proyecto p \n" +
                "JOIN Lider l ON l.ID_Lider  = p.ID_Lider \n" +
                "JOIN Compra c ON  C.ID_Proyecto =  p.ID_Proyecto \n" +
                "JOIN MaterialConstruccion mc ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion\n" +
                "GROUP BY LIDER \n" +
                "ORDER BY VALOR DESC \n" +
                "LIMIT 10;";
        return consulta3;
    }

    public String informe1() {
        String consulta4 = "SELECT  ID_Lider, Nombre , Primer_Apellido,  Ciudad_Residencia  \n" +
                "FROM Lider \n" +
                "GROUP BY ID_Lider\n" +
                "ORDER BY Ciudad_Residencia ASC ;";
        return consulta4;
    }

    public String informe2() {
        String consulta5 ="SELECT ID_Proyecto,Constructora, Numero_Habitaciones, Ciudad , Clasificacion \n" +
                            "FROM Proyecto \n" +
                            "WHERE Clasificacion = 'Casa Campestre' \n" +
                            "AND Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla');";
        return consulta5;
    }

    public String informe3() {
        String consulta5 = "SELECT ID_Compra, Proyecto.Constructora , Proyecto.Banco_Vinculado  \n" +
                "FROM Compra   \n" +
                "JOIN Proyecto  USING (ID_Proyecto) \n" +
                "WHERE Proveedor = 'Homecenter' \n" +
                "AND Proyecto.Ciudad  = 'Salento';\n" ;
        return consulta5;
    }

}
