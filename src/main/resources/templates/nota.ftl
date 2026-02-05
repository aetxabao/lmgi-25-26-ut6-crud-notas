<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Nota</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <#if eliminar>
    <h1>Eliminar la Nota</h1>
    <#else>
    <h1>Vista de la Nota</h1>
    </#if>

    <a href="../lista-notas">Volver a la lista</a>
    <br/><br/>

    <#if mensajeError??>

        <div class="error">${mensajeError}</div>

    <#else>

    <table id="notas">
        <tbody><tr>
            <th>ID</th>
            <td>${nota.id}</td>
        </tr>
        <tr>
            <th>Título</th>
            <td>${nota.titulo}</td>
        </tr>
        <tr>
            <th>Contenido</th>
            <td>${nota.contenido}</td>
        </tr>
        <tr>
            <th>Creado</th>
            <td>${nota.creado}</td>
        </tr>
        <tr>
            <th>Modificado</th>
            <td>${nota.modificado}</td>
        </tr>
        </tbody>
    </table>

    <br/><br/>


        <#if eliminar>
            <!-- TIENE QUE SER POST -->
            <form action="../elimina-nota/${nota.id}" method="POST">
                ¿Seguro que desea eliminar la nota? <input type="submit" value="Confirmar" />
            </form>
        <#else>
            <div>
                <a href="../elimina-nota/${nota.id}">Eliminar</a> <!-- GET -->
                <a href="../edita-nota/${nota.id}">Editar</a>
            </div>
        </#if>
        
    </#if>
</body>
</html>