<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Listado de notas</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1>Listado de notas</h1>
<div>
    <a class="btn" href="/">Volver al inicio</a>
    <a class="btn" href="crea-nota">Añadir nota</a>
</div>
<br/><br/>
<div>
    <table id="notas">
        <tbody><tr>
            <th>ID</th>
            <th>Título</th>
            <th>Contenido</th>
            <th>Creado</th>
            <th>Modificado</th>
            <th>Actualizar</th>
            <th>Eliminar</th>
        </tr>

        <#list notas as nota>

        <tr>
            <td><a href="nota/${nota.id}">${nota.id}</a></td>
            <td>${nota.titulo}</td>
            <td>${nota.contenido}</td>
            <td>${nota.creado}</td>
            <td>${nota.modificado}</td>
            <td><a href="${'edita-nota/' + nota.id}">Editar</a></td>
            <td><a href="${'elimina-nota/' + nota.id}">Borrar</a></td>
        </tr>

        </#list>

        </tbody>
    </table>
</div>
<br/><br/>
<div>
    <nobr>
        <#if tieneAnterior>
            <a class="btn" href="lista-notas?pagina=${paginaAnterior}">Anterior</a>&nbsp;&nbsp;&nbsp;
        </#if>
        <#if tieneSiguiente>
            <a class="btn" href="lista-notas?pagina=${paginaSiguiente}">Siguiente</a>
        </#if>
    </nobr>
</div>
</body>
</html>