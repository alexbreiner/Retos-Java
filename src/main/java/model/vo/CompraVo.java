/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.vo;

/**
 *
 * @author Alex Delago
 */
public class CompraVo {
    private int id;
    private String constructora, bancoVinculado;

    public CompraVo() {}
    
    public CompraVo(int id, String constructora, String bancoVinculado) {
        this.id = id;
        this.constructora = constructora;
        this.bancoVinculado = bancoVinculado;
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

    public String getBancoVinculado() {
        return bancoVinculado;
    }

    public void setBancoVinculado(String bancoVinculado) {
        this.bancoVinculado = bancoVinculado;
    }
    
}
