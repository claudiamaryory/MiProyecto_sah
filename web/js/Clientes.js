var _GlobalArrayDatos = new Array();
var _select =new Array();

$(document).ready(function() {
    
    var tabla = "<table><thead>" +
            "<tr>" +
            "<th style='width:300px'>NOMBRE</th><th style='width:300px'>APELLIDO</th><th style='width:150px'>CEDULA</th><th style='width:200px'>DIRECCION</th><th style='width:200px'>BARRIO</th><th style='width:80px'>TELE</th><th style='width:100px'>CELULAR</th><th style='width:200px'>EMAIL</th><th style='width:20px'>EDIT</th>" +
            "</tr></thead>";
    $.ajax({
        type: 'POST',
        data: {accion: 'verClientes'},
        url: 'Crud',
        async: true,
        success: function(ArrayDatos) {
            _GlobalArrayDatos = ArrayDatos;
            
            if (_GlobalArrayDatos.length !== 0) {
                $.each(_GlobalArrayDatos, function(key, valores) {
                    var nombre = valores.nombre;
                    var apellido = valores.apellido;
                    var cedula = valores.cedula;
                    var direccion=valores.direccion;
                    var barrio=valores.barrio;
                    var telefono=valores.telefono;
                    var celular=valores.celular;
                    var email=valores.email;
                    tabla += "<tr>" +
                            "<td><label nombre="+nombre+"></label>"+nombre+"</td><td>"+apellido+"</td><td>"+cedula+"</td><td>"+direccion+"</td><td>"+barrio+"</td><td>"+telefono+"</td><td>"+celular+"</td><td>"+email+"</td>" +
                            "<td>" +
                            "<a href='#' class='actualizar' data-reveal-id='ForM' cedula="+cedula+"></a>" +
                            "</td>" +
//                           "<td>" +
//                            "<a href='#' class='eliminar' data-reveal-id='ForB' cedula="+cedula+"></a>" +
//                            "</td>" +
                            "</tr>";
                });
                $('#PersonTableContainer').html(tabla);
                dataTableCrear();
            } else {
                $('#PersonTableContainer').html(tabla +"<table width='50%' align='center'><tr bgcolor='#A4A4A4'><th >No hay datos para mostrar</th></tr></table>");
            }
            $('.actualizar').on("click", function() {
                var cedulaInt = $(this).attr('cedula');
                verIntModalActualizar(cedulaInt, _GlobalArrayDatos);
            });

//            $('.eliminar').on('click', function() {
//                var integrante = $(this).attr('cedula');
//                btnModalEliminar(integrante, _GlobalArrayDatos);
//            });
        }
    });
    guardarClientes();
    actualizarClientes();
//    eliminarClientes();
    llenarSelect();
    
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
            }, {
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
//            }
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

function verIntModalActualizar(cliente, datos) {
    var encontrado = false;
    for (var i in datos) {
        if (datos [i].cedula == cliente) {
            $("#nomb").val(datos[i].nombre);
            $("#apel").val(datos[i].apellido);
            $("#cedu").val(datos[i].cedula);
            $("#dire").val(datos[i].direccion);
            $("#barr").val(datos[i].barrio);
            $("#tele").val(datos[i].telefono);
            $("#celu").val(datos[i].celular);
            $("#emai").val(datos[i].email);
            $("#integrante").val(cliente);
            encontrado = true;
            break;
        }
    }

}

function guardarClientes() {
    $('#nom').focus();
    $('#guardar').click(function() {
        var nombreVar    = $('#nom').val();
        var apellidoVar  = $('#ape').val();
        var cedulaVar    = $('#ced').val();
        var direccionVar = $('#dir').val();
        var barrioVar    = $('#bar').val();
        var telefonoVar  = $('#tel').val();
        var celularVar   = $('#cel').val();
        var emailVar     = $('#ema').val();
        var servicioVar     = $('#servicios').val();
        if (nombreVar !== '' && celularVar !== '' && emailVar !== '') {
            $.ajax({type: 'POST',
                data: {accion: 'guardarClientes', nom: nombreVar, ape: apellidoVar, 
                ced: cedulaVar, dir: direccionVar, bar: barrioVar, 
                tel: telefonoVar, cel: celularVar, ema: emailVar,servicios:servicioVar},
                url: 'Crud',
                success: function(result) {
                    if (result === true) {
                        $('#guardarok').html('Registro exitoso');
                        $('#registro').each(function() {
                            this.reset();
                        });
                    } else if (result === false) {
                        $('#guardarok').html('No guardo ningun registro');
                    }
                }
            });
        }else{
            $('#Vacio').html('LLENE LOS CAMPOS' )
        }

    });
}

function actualizarClientes() {
    $('#actualizar').click(function() {
        var nomVar  = $('#nomb').val();
        var apeVar  = $('#apel').val();
        var cedVar  = $('#cedu').val();
        var dirVar  = $('#dire').val();
        var barVar  = $('#barr').val();
        var telVar  = $('#tele').val();
        var celVar  = $('#celu').val();
        var emaVar  = $('#emai').val();
        if ( nomVar !== '' && apeVar !== '' && cedVar !=='' && dirVar !=='' && barVar !=='' && telVar !=='' && celVar!=='' && emaVar !=='') {
            $.ajax({type: 'POST',
                data: {accion: 'actualizarClientes', nomb: nomVar, apel: apeVar, cedu:cedVar, dire:dirVar, barr:barVar, tele:telVar, celu:celVar, emai:emaVar },
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

//function eliminarClientes(){
//    $('#eliminar').click(function() {
//        var cedVar = $('#inclient').val();
//        $.ajax({
//            type: 'POST',
//            data:{accion:'eliminarClientes', inclient:cedVar},
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

function llenarSelect(){
    $('.nuevoreg').click(function(){
        $.ajax({
        type: 'POST',
        data: {accion: 'llenarSelect'},
        url: 'Crud',
        async: true,
        success: function(DatosSelect) {
            _select = DatosSelect;
            
            if (_select.length !== 0) {
                $.each(_select, function(key, valores) {
                    var idServicio = valores.tipoServicio;
                    var nombre = valores.nombre;
                    $('#servicios').append('<option value='+idServicio+'>'+nombre+'</option>');
                });
            }
        }
    });
    });
}


