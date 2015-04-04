var _GlobalArrayDatos = new Array();
var _select =new Array();

$(document).ready(function() {
    
    var tabla = "<table><thead>" +
            "<tr>" +
            "<th style='width:50px'>CEDULA</th><th style='width:50px'>SERVICIO</th><th style='width:50px'>MEDICION</th><th style='width:50px'>OBSERVACION</th><th style='width:20px'>EDITAR</th><th style='width:20px'>ELIMINAR</th>" +
            "</tr></thead>";
    $.ajax({
        type: 'POST',
        data: {accion:'verMedicionServicio'},
        url: 'Crud',
        async: true,
        success: function(ArrayDatos) {
            _GlobalArrayDatos = ArrayDatos;
            
            if (_GlobalArrayDatos.length !== 0) {
                $.each(_GlobalArrayDatos, function(key, valores) {
                    var idmedserVar = valores.idmedserv;
                    var cedclienteVar = valores.cedulacliente;
                    var idservicioVar = valores.idservicio;
                    var idtmedicionVar = valores.idtipmedicion;
                    var observacionVar = valores.observacion;
                    tabla += "<tr>" +
                            "<td>"+cedclienteVar+"</td><td>"+idservicioVar+"</td><td>"+idtmedicionVar+"</td><td>"+observacionVar+"</td>" +
                            "<td width='25' align='center'>" +
                            "<a href='#' class='actualizar' data-reveal-id='ForM' idmedserv="+idmedserVar+"></a>" +
                            "</td>" +
                            "<td width='25' align='center'>" +
                            "<a href='#' class='eliminar' data-reveal-id='ForB' idmedserv="+idmedserVar+"></a>" +
                            "</td>" +
                            "</tr>";
                });
                $('#PersonTableContainer').html(tabla);
                dataTableCrear();
            } else {
                $('#PersonTableContainer').html(tabla +"<table width='50%' align='center'><tr bgcolor='#A4A4A4'><th >No hay datos para mostrar</th></tr></table>");
            }
            $('.actualizar').on("click", function() {
                var idmedser = $(this).attr('idmedserv');
                verIntModalActualizar(idmedser, _GlobalArrayDatos);
            });

            $('.eliminar').on('click', function() {
                var medicion = $(this).attr('cedclienteVar');
                btnModalEliminar(medicion, _GlobalArrayDatos);
            });
        }
    });
    //guardarMediServi();
    actualizarMediServicio()
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
        ]
    });
}

//function btnModalEliminar(int, DatosInt) {
//    var encontro = false;
//    for (var idInt in DatosInt) {
//        if (DatosInt[idInt].cedula == int) {
//            $('#inclient').val(DatosInt[idInt].cedula);
//            encontro = true;
//            break;
//        }
//    }
//}
//
function verIntModalActualizar(cedcliente, datos) {
    var encontrado = false;
    for (var i in datos) {
        if (datos [i].idmedserv === cedcliente) {
            $("#idmedser").val(datos[i].idmedserv);
            $("#ced").val(datos[i].cedulacliente);
            $("#servi").val(datos[i].idservicio);
            $("#medi").val(datos[i].idtipmedicion);
            $("#obser").val(datos[i].observacion);
            encontrado = true;
            break;
        }
    }

}



function actualizarMediServicio() {
    $('#actualizar').click(function(){
    var idmedserVar = $("#idmedser").val();    
    var cedulaVar = $("#ced").val();
    var servicioVar = $("#servi").val();
    var medicionVar = $("#medi").val();
    var observacionVar =$("#obser").val();
        if ( cedulaVar !== '' && servicioVar !== '' && medicionVar !=='' && observacionVar !=='') {
            $.ajax({type: 'POST',
                data: {accion: 'actualizarMedicionServicio', idmedser: idmedserVar, ced: cedulaVar, servi:servicioVar, medi:medicionVar, obser:observacionVar },
                url: 'Crud',
                success: function(result) {
                    if (result === true) {
                        $('#Ok').html('Modificacion Exitosa');
                    } else if (result === false) {
                        $('#Ok').html('No se Modifico');
                    }
                }
            });
        } else {
            $('#Vacio').html('No dejes campos vacios');
        }
    });
}

//function guardarMediServi() {
//    $('#ced').focus();
//    $('#guardar').click(function() {
//        var cedulaVar    = $('#ced').val();
//        var servicioVar = $('#servi').val();
//        var medicionVar    = $('#medi').val();
//        var observVar = $('#obser').val();
//        if (cedulaVar !== '' && servicioVar !== '' && medicionVar !== '' && observVar!=='') {
//            $.ajax({type: 'POST',
//                data: {accion: '', ced: cedulaVar, servi: servicioVar, 
//                medi: medicionVar,obser:observVar},
//                url: 'Crud',
//                success: function(result) {
//                    if (result === true) {
//                        $('#guardarok').html('Registro exitoso');
//                        $('#registro').each(function() {
//                            this.reset();
//                        });
//                    } else if (result === false) {
//                        $('#guardarok').html('No guardo ningun registro');
//                    }
//                }
//            });
//        }else{
//            $('#Vacio').html('LLENE LOS CAMPOS' )
//        }
//
//    });
//}
