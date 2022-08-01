package model.vo;

public class ComprasDeLiderVo {
    private String lider;
    private double valor;

    public ComprasDeLiderVo() {

    }

    public ComprasDeLiderVo(String lider, double valor) {
        this.lider = lider;
        this.valor = valor;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
