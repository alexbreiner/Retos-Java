package controller;

import model.dao.ComprasDeLiderDao;
import model.dao.DeudasPorProyectoDao;
import model.dao.ProyectoBancoDao;
import model.vo.ComprasDeLiderVo;
import model.vo.DeudasPorProyectoVo;
import model.vo.ProyectoBancoVo;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.dao.LiderDao;

public class ReportesController {

    private ProyectoBancoDao proyectoBancoDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ComprasDeLiderDao comprasDeLiderDao;
    private LiderDao liderDao;
    
    public ReportesController() {
        this.proyectoBancoDao = new ProyectoBancoDao();
        this.deudasPorProyectoDao = new DeudasPorProyectoDao();
        this.comprasDeLiderDao = new ComprasDeLiderDao();
        this.liderDao = new LiderDao();
    }

    public ArrayList<ProyectoBancoVo> consultarProyectoBancoVos(String banco) throws SQLException {
        return this.proyectoBancoDao.listaDeBancos(banco);
    }

    public ArrayList<DeudasPorProyectoVo> consultarDeudasProyectos(Double limiteInferior) throws SQLException {
        return this.deudasPorProyectoDao.deudasProyectos(limiteInferior);
    }

    public ArrayList<ComprasDeLiderVo> consultarLiderMasCompradores() throws SQLException {
        return this.comprasDeLiderDao.listadoComprasLider();
    }
    
    public DefaultTableModel consultarLideres() throws SQLException {
        return this.liderDao.getDatosGui();
    }
}
