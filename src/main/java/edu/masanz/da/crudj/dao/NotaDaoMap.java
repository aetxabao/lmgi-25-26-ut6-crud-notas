package edu.masanz.da.crudj.dao;

import edu.masanz.da.crudj.dto.Nota;

import java.util.*;

public class NotaDaoMap implements INotaDao {

    private static final int NUMERO_NOTAS = 12;


    private static Map<Long, Nota> mapaNotas = new TreeMap<>();

    {
        for (int i = 1; i <= NUMERO_NOTAS; i++) {
            mapaNotas.put((long) i, new Nota((long) i));
        }
    }

    public int obtenerNumeroNotas() {
        return mapaNotas.size();
    }

    public List<Nota> obtenerNotas(int pagina, int notasPorPagina) {
//        List<Nota> listaNotas = mapaNotas.values().stream().toList();//inmutable
        List<Nota> listaNotas = new ArrayList<>(mapaNotas.values().stream().toList());//mutable
        Collections.reverse(listaNotas);//ordenar de forma descendente
        List<Nota> resultado = new ArrayList<>();
        int desde = (pagina-1)*notasPorPagina + 1;
        if (desde > listaNotas.size()) { return resultado; }
        int hasta = pagina*notasPorPagina;
        if (hasta > listaNotas.size()) {
            hasta = listaNotas.size();
        }
        for (int i = desde; i <= hasta; i++) {
            resultado.add(listaNotas.get(i-1));
        }
        return resultado;
    }

    public Nota obtenerNota(long idNota) {
        Nota nota = mapaNotas.get(idNota);
        if (nota == null) {
            nota = new Nota();
        }
        return nota;
    }

    public Nota guardarNota(Nota nota) {
        TreeSet cjto = new TreeSet(mapaNotas.keySet());
        long id = (long) cjto.last() + 1;
        nota.setId(id);
        mapaNotas.put(id, nota);
        return nota;
    }

    public boolean actualizarNota(Nota nota) {
        long idNota = nota.getId();
        Nota notaOriginal = obtenerNota((int)idNota);
        nota.setCreado(notaOriginal.getCreado());
        mapaNotas.put(idNota, nota);
        return true;
    }

    public boolean eliminarNota(long idNota) {
        mapaNotas.remove(idNota);
        return true;
    }

}
