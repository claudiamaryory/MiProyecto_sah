<%-- 
    Document   : index
    Created on : 15/01/2015, 09:00:56 PM
    Author     : casa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/jquery.dataTables.css">
        <link rel="stylesheet" href="css/jquery-ui-1.8.23.custom.css">
        <link rel="stylesheet" href="css/reveal.css"><!--css para el modal -->
        <script src="js/jquery-1.8.1.min.js"></script>
        <script src="js/jquery-ui-1.8.23.custom.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/jquery.reveal.js"></script><!---js para el modal -->
        <script src="js/Login.js"></script>
        <script src="js/Redirec.js"></script>
        
    </head>
    <body>
            <div id="main-container">
                <section class="page-container" id="page-container"> 
                    <center><h1>BIENVENIDO AL SISTEMA SAH</h1></center><br>
                    <center><a href="#" class="" data-reveal-id="ForN">Inicio Session</a></center> 
                        <div id="ForN" class="reveal-modal">
                            <form id="registro" align="center" method="POST">
                                <p>NUEVO REGISTRO</p>
                                <div id="cerrarR" class="cerrarModal"><a href="">Salir</a></div>
                                <div id="Vacio" class="errorCampos"></div>
                                <div id="errorLogin" class="errorCampos"></div>
                                <table border="0" align="center">
                                    <tbody>
                                         <tr>
                                            <td>Cedula:</td>
                                            <td><input type="text" id="cedul" name="ema" ></td>
                                        </tr>
                                        <tr>
                                            <td>Contraseña:</td>
                                            <td><input type="password" id="pass" name="pas" ></td>
                                        </tr>
                                        
                                        <tr>
                                            <td><input type="button" id="insertarlogin" value="Enviar"></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                    </div>
                 
            </section>
        </div>   
    </body>
</html>
