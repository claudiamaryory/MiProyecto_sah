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
        <script src="js/MedicionServicio.js"></script>
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
                    <center><h1>VER LOS DATOS DE MEDICION DE SERVICIO</h1></center><br> 
                    <div id="login"></div>
                    <table id="PersonTableContainer" class='select' class='display dataTable' style="margin-top: 5px"></table>
                        <div id="ForM" class="reveal-modal close"> 
                            <form id="registro" align="center" method="POST">
                                <input type="hidden" id="servicio"/>
                                <p> MODIFICACION DE MEDICION DE SERVICIO</p>
                                <div id="cerrarR" class="cerrarModal"><a href="">Salir</a></div>
                                <div id="Vacio" class="errorCampos"></div>
                                <div id="guardarok" class="mensajeok"></div>
                                <input type="hidden" id="idmedser"/>
                                <table border="0" align="center">
                                    <tbody>
                                        <tr>
                                            <td>Cedula:</td>
                                            <td><input type="text" id="ced" name="ced" ></td>
                                        </tr>
                                        <tr>
                                            <td>Servicios :</td>
                                            <td><input type="text" name="servicios" id="servi" ></td>
                                        </tr>
                                        <tr>
                                            <td>Medicion :</td>
                                            <td><input type="text" name="servicios" id="medi" ></td>
                                        </tr>
                                        <tr>
                                            <td>Observacion:</td>
                                            <td><textarea id="obser" name="ced" rows="4" cols="20"></textarea></td>
                                        </tr>
                                        <tr>
                                             <td><input type="button" id="actualizar" value="Enviar"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                    </div>
    </body>
</html>
