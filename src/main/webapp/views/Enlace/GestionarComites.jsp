<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html lang="en">
<head>
    <link rel="shortcut icon" href="${context}/assets/img/logo_poder_ejecutivo_2018-2024_25.jpg">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Lucía Zamudio, Julio Gutierrez, Isaac Galindo, Gonzalez Fernanda, Solís Pablo">
    <meta name="generator" content="ASCOVE">
    <link rel="stylesheet" href="${context}/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/css/styles.css">
    <title>Gestion de Comités</title>
</head>

<body class="text-center fondo texto">
<main>
    <div id="cabezera" class="any">
        <img src="${context}/assets/img/logo_poder_ejecutivo_2018-2024_25.jpg" class="izquierda" alt="No encontrado">
        <img src="${context}/assets/img/image_750x_5e93e4dd3fa46.jpg" class="derecha" alt = "No Encontrado">
        <h1>ASCOVE</h1>
        <h2>Atención de Solicitudes de Comités Vecinales</h2>
        <br>
        <h4>-Gestión de Comités-</h4>
    </div>

    <nav class="navbar alinear margen7">
        <div class="container-fluid">
            <form class="d-flex">
                <button class="btn boton img.izquierda" type="submit">Cerrar sesión</button>
            </form>
        </div>
    </nav>

    <div class="alinear margen3">
        <a type="button" class="btn boton" data-bs-toggle="modal" data-bs-target="#register"> Agregar comité</a>
        <input  restrict="reject" class="ng-pristine ng-untouched ng-valid ng-empty" id="numEnlace" placeholder="# Enlace">
        <button class="btn boton" type="button">Buscar</button>
    </div>
    <div class="alinear3 texto2">
        <table class="table table2">
            <thead class="table-dark">
            <tr>
                <th># Comité</th>
                <th>Colonia</th>
                <th>Rol</th>
                <th>Teléfono</th>
                <th>Acción</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ listComite }" var="comite" varStatus="status">
                <tr>
                    <<td>${ comite.idComite }</td>
                    <td>${ comite.colonia}</td>
                    <td>${ comite.nombre }</td>
                    <td>${ comite.telefono}</td>
                    <td>
                        <form action="${context}/deleteUser" method="POST">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="rolUsuario" value="">
                            <input type="hidden" name="idUser" value="">
                            <button id="btn-delete" name="action" value="delete" type="submit" class="btn btn-outline-danger" data-bs-toggle="modal"><i class="fas fa-trash"></i> Eliminar</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>


<!--MODAL REGISTRAR-->
<form method="POST">
    <div class="modal fade" id="register" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Agregar Comité</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-12">
                                <form method="POST" action="${context}/createComite">
                                    <label>Rol</label>
                                    <select class="form-select" name="rol">
                                        <option value="1">Presidente</option>
                                        <option value="2">Integrante</option>
                                    </select>
                                    <br>
                                <label>Colonia</label>
                                <input class="form-control" type="text" name="colonia" />
                                <br>
                                <label>Número integrantes</label>
                                <input class="form-control" type="number" id="num" name="numInt" />
                                    <div class="modal-body" action="">
                                        <label>Nombre:</label>
                                        <input class="form-control" type="text" name="nombre" />
                                        <br>
                                        <label>Apellido Paterno</label>
                                        <input class="form-control" type="text" name="aPaterno" />
                                        <br>
                                        <label>Apellido Materno</label>
                                        <input class="form-control" type="text" name="aMaterno" />
                                        <br>
                                        <label>Teléfono</label>
                                        <input class="form-control" type="number" name="telefono" />
                                        <br>
                                    <button type="reset" class="btn btn-secondary" ><i class="fas fa-times"></i> Cancelar</button>
                                        <button type="submit" class="btn btn-success" name="action" value="createComite"><i class="fas fa-plus"></i> Agregar</button>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<!--MODAL ELIMINAR-->
<form method="POST">
    <div class="modal fade" id="delete" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <input type="hidden" name="action" value="delete">
                <div class="modal-header">
                    <h5 class="modal-title">Deshabilitar Enlace</h5>
                    <button type="submit" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <label>¿Deshabilitar?</label>
                    <h5 id="text-delete"></h5>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                    <button type="submit" class="btn btn-danger"><i class="fas fa-trash"></i> Eliminar</button>
                </div>
            </div>
        </div>
    </div>
</form>

<!--MODAL DETALLES-->
<form method="POST">
    <div class="modal fade" id="details" tabindex="-1" ria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Detalles de Comité</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <h5># Comité:</h5>
                    <label id="lbl_id"></label>
                    <br>
                    <h5>Colonia</h5>
                    <label id="lbl_colonia"></label>
                    <br>
                    <h5>Presidente:</h5>
                    <label id="lbl_presidente"></label>
                    <br>
                    <h5># Integrantes:</h5>
                    <label id="lbl_integrantes"></label>
                    <br>
                    <h5>Teléfono:</h5>
                    <label id="lbl_telefono"></label>
                    <br>
                    <h5>Estado:</h5>
                    <label id="lbl_estado"></label>
                    <br>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                </div>
            </div>
        </div>
    </div>
</form>

<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</body>
</html>
