package model.vo;

public class ProyectoBancoVo {
    private int id;
    private String constructora;
    private String cuidad;
    private String clasificacion;
    private int estrato;
    private String lider;

    public ProyectoBancoVo() {

    }

    public ProyectoBancoVo(int id, String constructora, String cuidad, String clasificacion, int estrato, String lider) {
        this.id = id;
        this.constructora = constructora;
        this.cuidad = cuidad;
        this.clasificacion = clasificacion;
        this.estrato = estrato;
        this.lider = lider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }
}
