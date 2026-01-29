package edu.masanz.da.crudj.service;

import edu.masanz.da.crudj.dao.INotaDao;
import edu.masanz.da.crudj.dao.NotaDaoDb;
import edu.masanz.da.crudj.dto.Nota;
import edu.masanz.da.crudj.dao.NotaDaoMap;

import java.util.*;

public class NotaService {

    private INotaDao notaDao;

    public NotaService(){
        notaDao = new NotaDaoMap();
        //notaDao = new NotaDaoDb();
    }

    public int obtenerNumeroNotas() {
        return notaDao.obtenerNumeroNotas();
    }

    public List<Nota> obtenerNotas(int pagina, int notasPorPagina) {
        return notaDao.obtenerNotas(pagina, notasPorPagina);
    }

    public Nota obtenerNota(long idNota) {
        return notaDao.obtenerNota(idNota);
    }

    public Nota guardarNota(Nota nota) {
        return notaDao.guardarNota(nota);
    }

    public boolean actualizarNota(Nota nota) {
        return notaDao.actualizarNota(nota);
    }

    public boolean eliminarNota(int idNota) {
        return notaDao.eliminarNota(idNota);
    }

}
