<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/jquery.dataTables.css">
        <link rel="stylesheet" href="css/jquery-ui-1.8.23.custom.css">
        <link rel="stylesheet" href="css/reveal.css"><!--css para el modal -->
        <link rel="stylesheet" href="css/menu/style.css"><!--css para el menu -->
        <script src="js/menu/script.min.js"></script><!--js para el menu -->
        <script src="js/jquery-1.8.1.min.js"></script>
        <script src="js/jquery-ui-1.8.23.custom.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/jquery.reveal.js"></script><!---js para el modal -->
        <script src="js/Usuarios.js"></script>
        <script src="js/GeneralSesion.js"></script>
        <script src="js/Redirec.js"></script>
      
    </head>
        <body>
            <header class="main">
		<h3 class="logo">BIENVENIDO SAH</h3>
		<a href="#menu" class="menu-trigger ss-icon">&#xED50;</a>
		<nav>
			<ul>
				<li><a href="#">...Menu...</a></li>
                                <li><a href="MenuPrincipal.jsp">Inicio</a></li>
				<li><a href="Clientes.jsp">Clientes</a></li>
				<li><a href="Usuarios.jsp">Usuarios</a></li>
				<li><a href="Servicios.jsp">Servicios</a></li>
				<li><a href="MedicionServicio.jsp">Medicion</a></li>
			</ul>
		</nav>
	</header>
            <div id="login" class="login"></div>    
            <div id="main-container">
                <section class="page-container" id="page-container"> 
                    <center><h1>VER LOS DATOS DE LOS USUARIOS</h1></center><br>
                    <div id="login"></div>
                     <a href='#' class='nuevoreg button' data-reveal-id='ForN'></a>   
                    <table id="PersonTableContainer" class='display dataTable' style="margin-top: 5px"></table>
                        <div id="ForN" class="reveal-modal">
                            <form id="registro" align="center" method="POST">
                                <p>NUEVO USUARIO</p>
                                <div id="cerrarR" class="cerrarModal"><a href="">Salir</a></div>
                                <div id="Vacio" class="errorCampos"></div>
                                <div id="guardarok" class="mensajeok"></div>
                                <table border="0" align="center">
                                    <tbody>
                                        <tr>
                                            <td>Nombre:</td>
                                            <td><input type="text" id="nomb" name="nom"></td>
                                        </tr>
                                        <tr>
                                            <td>Apellido:</td>
                                            <td><input type="text" id="apel" name="ape"></td>
                                        </tr>
                                        <tr>
                                            <td>Cedula:</td>
                                            <td><input type="text" id="cedu" name="ced" ></td>
                                        </tr>
                                         <tr>
                                            <td>Direccion:</td>
                                            <td><input type="text" id="dire" name="dir" ></td>
                                        </tr>
                                         <tr>
                                            <td>Barrio:</td>
                                            <td><input type="text" id="barr" name="bar" ></td>
                                        </tr>
                                         <tr>
                                            <td>Telefono:</td>
                                            <td><input type="text" id="tele" name="tel" ></td>
                                        </tr>
                                         <tr>
                                            <td>Celular:</td>
                                            <td><input type="text" id="cele" name="cel" ></td>
                                        </tr>
                                         <tr>
                                            <td>Email:</td>
                                            <td><input type="text" id="emai" name="ema" ></td>
                                        </tr>
                                        <tr>
                                            <td>Contraseña:</td>
                                            <td><input type="password" id="pass" name="ema" ></td>
                                        </tr>
                                        <tr>
                                            <td>Rol:</td>
                                            <td><select id="rol">
                                                    <option value="1">Seleccione un rol:</option>
                                                    <option value="2">ADMI</option>
                                                    <option value="3">ASIST</option>
                                                    <option value="4">TECNICO</option>
                                                </select></td>
                                        </tr>
                                        <tr>
                                            <td><input type="button" id="guardarUsuario" value="Enviar"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                    </div>
                 <!--Actualizar-->
                    <div id="ForM" class="reveal-modal close">
                        <form  align="center" method="POST">
                            <p>MODIFICAR USUARIO</p>
                            <div id="cerrarA" class="cerrarModal"><a href="">Salir</a></div>
                            <div id="Vacio" class="errorCampos"></div>
                            <div id="Ok" class="mensajeok"></div>
                            <input type="hidden" id="integrante"/>
                            <table border="0" align="center">
                                <tbody>
                                    <tr>
                                        <td>Nombre</td>
                                        <td><input type="text" id="nom"></td>
                                    </tr>
                                    <tr>
                                        <td>Apellido</td>
                                        <td><input type="text" id="ap"></td>
                                    </tr>
                                     <tr>
                                        <td>Cedula:</td>
                                        <td><input type="text" id="ce" name="ced" readonly="true" ></td>
                                    </tr>
                                    <tr>
                                        <td>Direccion:</td>
                                        <td><input type="text" id="di" name="dir" ></td>
                                    </tr>
                                        <tr>
                                        <td>Barrio:</td>
                                    <td><input type="text" id="bar" name="bar" ></td>
                                    </tr>
                                    <tr>
                                        <td>Telefono:</td>
                                        <td><input type="text" id="tel" name="tel" ></td>
                                    </tr>
                                    <tr>
                                        <td>Celular:</td>
                                        <td><input type="text" id="cel" name="cel" ></td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td><input type="text" id="em" name="ema" ></td>
                                     </tr>
                                     <tr>
                                        <td>Contraseña:</td>
                                        <td><input type="password" id="pas" name="ema" ></td>
                                     </tr>
                                      <tr>
                                        <td>Rol:</td>
                                        <td><select id="ro">
                                            <option value="1">Seleccione un rol:</option>
                                            <option value="2">ADMI</option>
                                            <option value="3">ASIST</option>
                                            <option value="4">TECNICO</option>
                                        </select></td>
                                       </tr>
                                    <tr>
                                        <td><input type="submit" id="modificar" value="Enviar"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                    <!--Eliminar-->
                   <div id="ForB" class="reveal-modal">
                       <form  align="center" method="POST">
                           <p>ELIMINAR USUARIO</p>
                           <div id="cerrarR" class="cerrarModal"><a href="">Salir</a></div>
                           <div id="eliminarok" class="mensajeok"></div>
                           <input type="hidden" id="inusu"/>
                        <table border="0" align="center">
                            <tbody>
                                <tr>
                                    <td><input type="button" id="eliminar" value="Aceptar"></td>
                                    <td><input type="button" id="cerrar"  value="Cancelar"></td>
                                </tr>
                            </tbody>
                        </table>
                    </form>
                 </div>
            </section>
        </div>   
    </body>
</html>

