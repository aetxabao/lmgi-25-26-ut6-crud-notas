package edu.masanz.da.crudj.dao;

import edu.masanz.da.crudj.database.ConnectionManager;
import edu.masanz.da.crudj.dto.Nota;

import java.util.*;

public class NotaDaoDb implements INotaDao {

    public NotaDaoDb() {
        ConnectionManager.conectar("crud_db", "proy", "password");
    }

    public int obtenerNumeroNotas() {
        String sql = "SELECT COUNT(*) FROM notas";
        Object[] params = {};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado != null && resultado.length == 1) {
            int numeroNotas = Integer.parseInt(resultado[0][0].toString());
            return numeroNotas;
        }
        return 0;
    }


    public List<Nota> obtenerNotas(int pagina, int notasPorPagina) {
        String sql = "SELECT id, titulo, contenido, creado, modificado " +
                     "FROM notas ORDER BY id DESC LIMIT ? OFFSET ?";
        Long limite = (long) notasPorPagina;
        Long offset = (long) ((pagina-1)*notasPorPagina);
        Object[] params = {limite, offset};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        List<Nota> notas = new ArrayList<>();
        if (resultado != null) {
            for (Object[] fila : resultado) {
                Nota nota = new Nota();

                nota.setId((Long) fila[0]);
                nota.setTitulo((String) fila[1]);
                nota.setContenido((String) fila[2]);
                nota.setCreado((String) fila[3]);
                nota.setModificado((String) fila[4]);

                notas.add(nota);
            }
        }
        return notas;
    }

    public Nota obtenerNota(long idNota) {
        String sql = "SELECT id, titulo, contenido, creado, modificado " +
                "FROM notas WHERE id = ? ORDER BY id DESC LIMIT 1";
        Object[] params = {idNota};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado != null && resultado.length == 1) {
            Nota nota = new Nota();

            nota.setId((Long) resultado[0][0]);
            nota.setTitulo((String) resultado[0][1]);
            nota.setContenido((String) resultado[0][2]);
            nota.setCreado((String) resultado[0][3]);
            nota.setModificado((String) resultado[0][4]);

            return nota;
        }
        return null;
    }

    public Nota guardarNota(Nota nota) {
        String sql = "INSERT INTO notas (titulo, contenido, creado, modificado) VALUES (?, ?, ?, ?)";
        Object[] params = {nota.getTitulo(), nota.getContenido(), nota.getCreado(), nota.getModificado()};
        long id = ConnectionManager.ejecutarInsertSQL(sql, params);
        if (id > 0){
            nota.setId(id);
        }
        return nota;
    }

    public boolean actualizarNota(Nota nota) {
        String sql = "UPDATE notas SET titulo = ?, contenido = ?, modificado = ? WHERE id = ?";
        Object[] params = {nota.getTitulo(), nota.getContenido(), nota.getModificado(), nota.getId()};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
        return true;
    }

    public boolean eliminarNota(long idNota) {
        String sql = "DELETE FROM notas WHERE id = ?";
        Object[] params = {idNota};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
        return true;
    }

}
