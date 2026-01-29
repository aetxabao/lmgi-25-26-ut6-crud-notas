package edu.masanz.da.crudj;

import edu.masanz.da.crudj.controller.NotaController;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("ARRANCANDO APLICACION");

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(8080);

        app.get("/", NotaController::servirIndice);
        app.get("/lista-notas", NotaController::servirLista);
        app.get("/nota/{id}", NotaController::servirNota);
        app.get("/crea-nota", NotaController::servirCrearNota);
        app.post("/crea-nota", NotaController::crearNota);
        app.get("/edita-nota/{id}", NotaController::servirEditarNota);
        app.post("/edita-nota/{id}", NotaController::editarNota);
        app.get("/elimina-nota/{id}", NotaController::servirEliminarNota);
        app.post("/elimina-nota/{id}", NotaController::eliminarNota);
        app.get("/error", NotaController::servirError);

    }

}