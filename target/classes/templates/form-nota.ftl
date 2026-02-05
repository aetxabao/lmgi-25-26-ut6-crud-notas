<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if agregar>Crear Nota<#else>Editar Nota</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <h1>
        <#if agregar>
            CREAR NOTA
        <#else>
            EDITAR NOTA
        </#if>
    </h1>
    <a href="../lista-notas">Regresar al listado</a>
    <br/><br/>

    <#if mensajeError??>
        <div class="error">${mensajeError}</div>
    <#else>
        <!-- TIENE QUE SER POST -->
        
        <#if agregar>
            <form action="/crea-nota" method="POST">
        <#else>
            <form action="/edita-nota/${nota.id}" method="POST">
        </#if>

            <div class="container">
                <div class="w75">
                    <label for="titulo">Título</label>
                    <input type="text" name="titulo" value="${nota.titulo}">
                </div>
                <div class="w25 center">
                    <label for="id">ID</label>
                    <input type="text" name="id" value="${nota.id}" disabled="disabled">
                </div>
            </div>

            <label for="contenido">Contenido</label>
            <textarea name="contenido">${nota.contenido}</textarea>

            <div class="container">
                <div class="w50 center">
                    <label for="creado">Creado</label>
                    <input type="text" name="creado" value="${nota.creado}" disabled="disabled">
                </div>
                <div class="w50 center">
                    <label for="creado">Actualizado</label>
                    <input type="text" name="creado" value="${nota.modificado}" disabled="disabled">
                </div>
            </div>

            <input type="submit" value="Guardar">
        </form>
    </#if>

    <br/>

</body>
</html>