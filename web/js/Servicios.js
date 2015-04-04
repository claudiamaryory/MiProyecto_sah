var _GlobalArrayDatos = new Array();
var _select =new Array();

$(document).ready(function() {
   
    var tabla = "<table><thead>" +
            "<tr>" +
            "<th style='width:350px'>NOMBRE</th><th style='width:350px'>APELLIDO</th><th style='width:350px'>DIRECCION</th><th style='width:350px'>TELEFONO</th><th style='width:350px'>SERVICIO</th><th style='width:350px'>FECHA</th><th style='width:350px'>ESTADO</th><th style='width:350px'>USUARIO</th><th style='width:20px'>EDIT</th>" +
            "</tr></thead>";
    $.ajax({
        type: 'POST',
        data: {accion:'verServicio'},
        url: 'Crud',
        async: true,
        success: function(ArrayDatos) {
            _GlobalArrayDatos = ArrayDatos;
            
            if (_GlobalArrayDatos.length !== 0) {
                $.each(_GlobalArrayDatos, function(key, valores) {
                    var idserviVar = valores.idcliente;
                    var nombreVar = valores.nombre;
                    var apellidoVar = valores.apellido;
                    var direccionVar = valores.direccion;
                    var telefonoVar = valores.telefono;
                    var servicioVar = valores.servicio;
                    var fechaVar = valores.fecha;
                    var estadoVar = valores.estado;
                    var userVar = valores.user;
                    var cedulaVar = valores.cedula;
                    tabla += "<tr>" +
                    "<td>"+nombreVar+"</td><td>"+apellidoVar+"</td><td>"+direccionVar+"</td><td>"+telefonoVar+"</td><td>"+servicioVar+"</td><td>"+fechaVar+"</td><td>"+estadoVar+"</td><td>"+userVar+"</td>" +
                    "<td width='25' align='center'>" +
                    "<a href='#' class='actualizar' data-reveal-id='ForM' cedula="+cedulaVar+" idservi="+idserviVar+"></a>" +
                    "</td>" +
//                    "<td width='25' align='center'>" +
//                    "<a href='#' class='eliminar' data-reveal-id='ForB' cedula="+cedulaVar+" idservi="+idserviVar+"></a>" +
//                    "</td>" +
                    "</tr>";
                });
                $('#PersonTableContainer').html(tabla);
                dataTableCrear();
            } else {
                $('#PersonTableContainer').html(tabla +"<table width='50%' align='center'><tr bgcolor='#A4A4A4'><th >No hay datos para mostrar</th></tr></table>");
            }
            $('.actualizar').on("click", function() {
                var idServicio = $(this).attr('idservi');
                verIntModalActualizar(idServicio, _GlobalArrayDatos);
            });
//
//            $('.eliminar').on('click', function() {
//                var servicio = $(this).attr('idVar');
//                btnModalEliminar(servicio, _GlobalArrayDatos);
//            });
        }
    });
//    guardarClientes();
      actualizarServicio();
      llenarSelectserv();
      llenarSelectEstado();
      llenarSelectTUsuario();
//      eliminarServicio();
    
});

function dataTableCrear() {
    $("#PersonTableContainer").dataTable({
        "aaSorting": [[0, "asc"]],
        "aoColumns": [
            {
                "bSortable": true
            },
            {
                "bSortable": true
            },
            {
                "bSortable": true
            }, 
            {
                "bSortable": false
            },
            {
                "bSortable": false
            },
            {
                "bSortable": false
            },
            {
                "bSortable": false
            },
            {
                "bSortable": false
            },
            {
                "bSortable": false
     },
//            {
//                "bSortable": false
//            },
     ]
    });
}

//function btnModalEliminar(int, DatosInt) {
//    var encontro = false;
//    for (var idInt in DatosInt) {
//        if (DatosInt[idInt].id == int) {
//            $('#servicio').val(DatosInt[idInt].id);
//            encontro = true;
//            break;
//        }
//    }
//}

function verIntModalActualizar(idServicio, datos) {
     $("#fec").datepicker();
    var encontrado = false;
    for (var i in datos) {
        if (datos [i].idcliente == idServicio) {
            $("#nom").val(datos[i].nombre);
            $("#ape").val(datos[i].apellido);
            $("#dir").val(datos[i].direccion);
            $("#tel").val(datos[i].telefono);
            $("#servi").val(datos[i].servicio);
            $("#fec").val(datos[i].fecha);
            $("#esta").val(datos[i].estado);
            $("#rol").val(datos[i].user);
            $("#cedula").val(datos[i].cedula);
            $("#servicio").val(idServicio);
            encontrado = true;
            break;
        }
    }
    }

function actualizarServicio() {
    $('#actualizar').click(function() {
        var idVar  = $('#servicio').val();
        var nomVar  = $('#nom').val();
        var apeVar  = $('#ape').val();
        var direcVar  = $('#dir').val();
        var teleVar  = $('#tel').val();
        var tipserVar  = $('#servi').val();
        var fechaVar  = $('#fec').val();
        var estVar  = $('#esta').val();
        var userVar  = $('#rol').val();
        var cedulaVar =$('#cedula').val();
        if ( nomVar !== '' && apeVar !== '' && direcVar !=='' && teleVar !=='' && tipserVar !=='' && fechaVar !=='' && estVar!==''  && userVar !=='') {
            $.ajax({type: 'POST',
                data: {accion: 'modificarServcio',servicio:idVar, nom: nomVar, ape: apeVar, dir:direcVar, 
                                tel:teleVar,servi:tipserVar, fec:fechaVar, esta:estVar, rol:userVar,cedula:cedulaVar},
                url: 'Crud',
                success: function(result) {
                    if (result === true) {
                        $('#ok').html('Modificacion Exitosa');
                    } else if (result === false) {
                        $('#Vacio').html('No se Modifico');
                    }
                }
            });
        } else {
            $('#Vacio').html('No dejes campos vacios');
        }
    });
}

function llenarSelectserv(){
    $('.select').click(function(){
        $.ajax({
        type: 'POST',
        data: {accion:'llenarSelectServicio'},
        url: 'Crud',
        async: true,
        success: function(DatosSelect) {
            _select = DatosSelect;
            
            if (_select.length !== 0) {
                $.each(_select, function(key, valores) {
                    var idServicio = valores.tipoServicio;
                    var nombre = valores.nombre;
                    
                    $('#servi').html('<option value='+idServicio+'>'+nombre+'</option>');
                });
            }
        }
    });
    });
}

function llenarSelectEstado(){
    $('.select').click(function(){
        $.ajax({
        type: 'POST',
        data: {accion:'llenarSelectEstado'},
        url: 'Crud',
        async: true,
        success: function(DatosSelect) {
            _select = DatosSelect;
            
            if (_select.length !== 0) {
                $.each(_select, function(key, valores) {
                    var idEstado = valores.idtipoestado;
                    var nombre = valores.nombre;
                    $('#esta').append('<option value='+idEstado+'>'+nombre+'</option>');
                });
            }
        }
    });
    });
}

function llenarSelectTUsuario(){
    $('.select').click(function(){
        $.ajax({
        type: 'POST',
        data: {accion:'llenarSelectTipUsuario'},
        url: 'Crud',
        async: true,
        success: function(DatosSelect) {
            _select = DatosSelect;
            
            if (_select.length !== 0) {
                $.each(_select, function(key, valores) {
                    var idRol = valores.idrol;
                    var nombre = valores.nombre;
                    $('#rol').append('<option value='+idRol+'>'+nombre+'</option>');
                });
            }
        }
    });
    });
}

//function eliminarServicio(){
//    $('#eliminar').click(function() {
//        var idVar = $('#servicio').val();
//        $.ajax({
//            type: 'POST',
//            data:{accion:'eliminarServicio', servicio:idVar},
//            url:'Crud',
//             success: function(result) {
//                if (result == true) {
//                    $('#eliminarok').html('Registro eliminado');
//                    $('#eliminar').hide();
//                    $('#cerrar').hide();
//                } else if (result == false) {
//                    $('#borrarok').html('Error al eliminar');
//
//                }
//            }
//        });
//    });
//}


