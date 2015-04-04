<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <link rel="stylesheet" href="css/jquery.dataTables.css">
        <link rel="stylesheet" href="css/jquery-ui-1.8.23.custom.css">
        <link rel="stylesheet" href="css/reveal.css"><!--css para el modal -->
        <link rel="stylesheet" href="css/menu/style.css"><!--css para el menu -->
        <script src="js/menu/script.min.js"></script><!--js para el menu -->
        <script src="js/jquery-1.8.1.min.js"></script>
        <script src="js/jquery-ui-1.8.23.custom.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/jquery.reveal.js"></script><!---js para el modal -->
        <script src="js/Clientes.js"></script>
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
                    <div class="tituloSer">Clientes Registrados</div><br>
                    <div></div><br>
                    <div></div><br>
                     <a href='#' class='nuevoreg button' data-reveal-id='ForN'></a>  
                    
                    <table id="PersonTableContainer" class='display dataTable' style="margin-top: 50px"></table>
                        <div id="ForN" class="reveal-modal">
                            <form id="registro" align="center" method="POST">
                                <p>NUEVO SERVICIO</p>
                                <div id="cerrarR" class="cerrarModal"><a href="">Salir</a></div>
                                <div id="Vacio" class="errorCampos"></div>
                                <div id="guardarok" class="mensajeok"></div>
                                <table border="0" align="center">
                                    <tbody>
                                        <tr>
                                            <td>Nombre:</td>
                                            <td><input type="text" id="nom" name="nom"></td>
                                        </tr>
                                        <tr>
                                            <td>Apellido:</td>
                                            <td><input type="text" id="ape" name="ape"></td>
                                        </tr>
                                        <tr>
                                            <td>Cedula:</td>
                                            <td><input type="text" id="ced" name="ced" ></td>
                                        </tr>
                                         <tr>
                                            <td>Direccion:</td>
                                            <td><input type="text" id="dir" name="dir" ></td>
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
                                            <td><input type="text" id="ema" name="ema" ></td>
                                        </tr>
                                        <tr>
                                            <td>Servicios :</td>
                                            <td><select name="servicios" id="servicios">
                                                    <option>Seleccione el servicio :</option>
                                                </select> </td>
                                        </tr>
                                        <tr>
                                            <td><input type="button" id="guardar" value="Enviar"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                    </div>
                 <!--Actualizar-->
                    <div id="ForM" class="reveal-modal close">
                        <form  align="center" method="POST">
                            <p>MODIFICAR CLIENTE</p>
                            <div id="cerrarA" class="cerrarModal"><a href="">Salir</a></div>
                            <div id="Vacio" class="errorCampos"></div>
                            <div id="Ok" class="mensajeok"></div>
                            <input type="hidden" id="integrante"/>
                            <table border="0" align="center">
                                <tbody>
                                    <tr>
                                        <td>Nombre</td>
                                        <td><input type="text" id="nomb"></td>
                                    </tr>
                                    <tr>
                                        <td>Apellido</td>
                                        <td><input type="text" id="apel"></td>
                                    </tr>
                                     <tr>
                                        <td>Cedula:</td>
                                        <td><input type="text" id="cedu" name="ced" readonly="true" ></td>
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
                                        <td><input type="text" id="celu" name="cel" ></td>
                                    </tr>
                                    <tr>
                                        <td>Email:</td>
                                        <td><input type="text" id="emai" name="ema" ></td>
                                     </tr>
                                    <tr>
                                        <td><input type="submit" id="actualizar" value="Enviar"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                    <!--Eliminar-->
                   <!--<div id="ForB" class="reveal-modal">
                       <form  align="center" method="POST">
                           <p>ELIMINAR CLIENTE</p>
                           <div id="cerrarR" class="cerrarModal"><a href="">Salir</a></div>
                           <div id="eliminarok" class="mensajeok"></div>
                           <input type="hidden" id="inclient"/>
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
        </div> -->  
    </body>
</html>
