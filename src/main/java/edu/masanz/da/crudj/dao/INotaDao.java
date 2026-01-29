package edu.masanz.da.crudj.dao;

import edu.masanz.da.crudj.dto.Nota;

import java.util.List;

public interface INotaDao {

    int obtenerNumeroNotas();

    List<Nota> obtenerNotas(int pagina, int notasPorPagina);

    Nota obtenerNota(long idNota);

    Nota guardarNota(Nota nota);

    boolean actualizarNota(Nota nota);

    boolean eliminarNota(long idNota);

}
