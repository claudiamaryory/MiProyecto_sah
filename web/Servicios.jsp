<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicios</title>
        <link rel="stylesheet" href="css/jquery.dataTables.css">
        <link rel="stylesheet" href="css/jquery-ui-1.8.23.custom.css">
        <link rel="stylesheet" href="css/reveal.css"><!--css para el modal -->
        <link rel="stylesheet" href="css/menu/style.css"><!--css para el menu -->
        <script src="js/menu/script.min.js"></script><!--js para el menu -->
        <script src="js/jquery-1.8.1.min.js"></script>
        <script src="js/jquery-ui-1.8.23.custom.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/jquery.reveal.js"></script><!---js para el modal -->
        <script src="js/Servicios.js"></script>
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
                    <center><h1>VER LOS SERVICIOS</h1></center><br> 
                    <div id="login"></div>
                    <a href="Reportes" target="_blank" class='nuevoreg button'></a>  
                    <table id="PersonTableContainer" class='select' class='display dataTable' style="margin-top: 5px"></table>
                        <div id="ForM" class="reveal-modal close"> 
                            <form id="registro" align="center" method="POST">
                                <input type="TEXT" id="servicio"/>
                                 <input type="text" id="cedula"/>
                                <p> MODIFICACION DE SERVICIOS</p>
                                <div id="cerrarR" class="cerrarModal"><a href="">Salir</a></div>
                                <div id="Vacio" class="errorCampos"></div>
                                <div id="ok" class="mensajeok"></div>
                                <table border="0" align="center">
                                    <tbody>
                                        <tr>
                                            <td>Nombre:</td>
                                            <td><input type="text" id="nom" name="nombre"></td>
                                        </tr>
                                        <tr>
                                            <td>Apellido.</td>
                                            <td><input type="text" id="ape" name="apellido"></td>
                                        </tr>
                                        <tr>
                                            <td>Direccion:</td>
                                            <td><input type="text" id="dir" name="direc"></td>
                                        </tr>
                                        <tr>
                                            <td>Telefono:</td>
                                            <td><input type="text" id="tel" name="tel"></td>
                                        </tr>
                                        <tr>
                                            <td>Servicios :</td>
                                            <td><select name="servicios" id="servi"></select></td>
                                        </tr>
                                        <tr>
                                            <td>Fecha:</td>
                                            <td><input type="text" id="fec" name="fecha" ></td>
                                        </tr>
                                         <tr>
                                            <td>Estado:</td>
                                            <td><select name="estado" id="esta">
                                                    <option >Seleccione el Estado :</option>
                                                </select> </td>
                                        </tr>
                                        <tr>
                                            <td>Usuario:</td>
                                            <td><select name="rol" id="rol">
                                                    <option >Seleccione el Usuario:</option>
                                                </select> </td>
                                        </tr>
                                        <tr>
                                            <td><input type="button" id="actualizar" value="Enviar"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                    </div>
                    
                    
                    <!--Eliminar-->
                  <!--<div id="ForB" class="reveal-modal">
                       <form  align="center" method="POST">
                           <p>ELIMINAR SERVICIO</p>
                           <div id="cerrarR" class="cerrarModal"><a href="">Salir</a></div>
                           <div id="eliminarok" class="mensajeok"></div>
                           <input type="hidden" id="servicio"/>
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
        </div>-->   
    </body>
</html>
