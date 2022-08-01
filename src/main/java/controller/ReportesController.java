package controller;

import model.dao.ComprasDeLiderDao;
import model.dao.DeudasPorProyectoDao;
import model.dao.ProyectoBancoDao;
import model.vo.ComprasDeLiderVo;
import model.vo.DeudasPorProyectoVo;
import model.vo.ProyectoBancoVo;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReportesController {

    private ProyectoBancoDao proyectoBancoDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ComprasDeLiderDao comprasDeLiderDao;
    public ReportesController() {
        this.proyectoBancoDao = new ProyectoBancoDao();
        this.deudasPorProyectoDao = new DeudasPorProyectoDao();
        this.comprasDeLiderDao = new ComprasDeLiderDao();
    }

    public ArrayList<ProyectoBancoVo> consultarProyectoBancoVos() throws SQLException {
        return this.proyectoBancoDao.listaDeBancos();
    }

    public ArrayList<DeudasPorProyectoVo> consultarDeudasProyectos() throws SQLException {
        return this.deudasPorProyectoDao.deudasProyectos();
    }

    public ArrayList<ComprasDeLiderVo> consultarLiderMasCompradores() throws SQLException {
        return this.comprasDeLiderDao.listadoComprasLider();
    }
}
