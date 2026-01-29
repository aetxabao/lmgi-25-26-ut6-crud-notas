package edu.masanz.da.crudj.controller;

import edu.masanz.da.crudj.dto.Nota;
import edu.masanz.da.crudj.service.NotaService;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotaController {
    private static final Logger logger = LogManager.getLogger(NotaController.class);

    private static final int NOTAS_POR_PAGINA = 5;

    private static NotaService notaService = new NotaService();


    public static void servirIndice(Context context){
        Map<String, Object> model = new HashMap<>();
        model.put("titulo", "Notas");
        model.put("encabezado", "Ejemplo CRUD con Spark y FreeMarker");
        context.render("templates/index.ftl", model);
    }

    public static void servirLista(Context context){
        Map<String, Object> model = new HashMap<>();
        Integer numeroPagina = 1;
        try {
            numeroPagina = Integer.parseInt(context.queryParam("pagina"));
        } catch (NumberFormatException e) { }
        int numeroNotas = notaService.obtenerNumeroNotas();
        Boolean tieneAnterior = numeroPagina > 1;
        Boolean tieneSiguiente = (numeroPagina * NOTAS_POR_PAGINA) < numeroNotas;

        model.put("numeroPagina", numeroPagina);
        model.put("tieneAnterior", tieneAnterior);
        model.put("paginaAnterior", numeroPagina - 1);
        model.put("tieneSiguiente", tieneSiguiente);
        model.put("paginaSiguiente", numeroPagina + 1);

        model.put("notas", notaService.obtenerNotas(numeroPagina, NOTAS_POR_PAGINA));

        context.render("templates/lista-notas.ftl", model);
    }

    public static void servirNota(Context context){
        int idNota = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Nota nota = notaService.obtenerNota(idNota);
        model.put("eliminar", false);
        model.put("nota", nota);
        if (nota.getId() == 0) {
            model.put("mensajeError", "Nota no encontrada");
        }
        context.render("templates/nota.ftl", model);
    }

    public static void servirCrearNota(Context context){
        Map<String, Object> model = new HashMap<>();
        Nota nota = new Nota();
        model.put("agregar", true);
        model.put("nota", nota);
        context.render("templates/form-nota.ftl", model);
    }

    public static void crearNota(Context context){
        String titulo = context.formParam("titulo");
        String contenido = context.formParam("contenido");
        Nota nota = new Nota(titulo, contenido);
        nota = notaService.guardarNota(nota);
        if (nota.getId() != 0) {
            context.redirect("/lista-notas");
//            response.redirect("/nota/" + nota.getId());
        }else {
            context.redirect("/error");
        }
    }

    public static void servirEditarNota(Context context){
        int idNota = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Nota nota = notaService.obtenerNota(idNota);
        model.put("agregar", false);
        model.put("nota", nota);
        if (nota.getId() == 0) {
            model.put("mensajeError", "Nota no encontrada");
        }
        context.render("templates/form-nota.ftl", model);
    }

    public static void editarNota(Context context){
        int idNota = Integer.parseInt(context.pathParam("id"));
        String titulo = context.formParam("titulo");
        String contenido = context.formParam("contenido");
        Nota nota = new Nota((long) idNota, titulo, contenido);
        if (notaService.actualizarNota(nota)) {
            context.redirect("/nota/" + nota.getId());
        }else {
            context.redirect("/error");
        }
    }

    public static void servirEliminarNota(Context context){
        int idNota = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Nota nota = notaService.obtenerNota(idNota);
        model.put("eliminar", true);
        model.put("nota", nota);
        if (nota.getId() == 0) {
            model.put("mensajeError", "Nota no encontrada");
        }
        context.render("templates/nota.ftl", model);
    }

    public static void eliminarNota(Context context){
        int idNota = Integer.parseInt(context.pathParam("id"));
        if (notaService.eliminarNota(idNota)) {
            context.redirect("/lista-notas");
        }else {
            context.redirect("/error");
        }
    }

    public static void servirError(Context context){
        Map<String, Object> model = new HashMap<>();
        context.render("templates/error.ftl", model);
    }

}