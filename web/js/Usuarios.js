var _GlobalArrayDatos = new Array();

$(document).ready(function() {
    
    var tabla = "<table><thead>" +
            "<tr>" +
            "<th style='width:440px'>NOMBRE</th><th style='width:390px'>APELLIDO</th><th style='width:250px'>CEDULA</th><th style='width:280px'>DIRECCION</th><th style='width:350px'>BARRIO</th><th style='width:140px'>TELEFONO</th><th style='width:100px'>CELULAR</th><th style='width:350px'>EMAIL</th><th style='width:80px'>ROL</th><th style='width:20px'>EDIT</th><th style='width:20px'>ELI</th>" +
            "</tr></thead>";
    $.ajax({
        type: 'POST',
        data: {accion: 'verUsuarios'},
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
                    var rol=valores.rol;
                    tabla += "<tr>" +
                            "<td><label nombre="+nombre+"></label>"+nombre+"</td><td>"+apellido+"</td><td>"+cedula+"</td><td>"+direccion+"</td><td>"+barrio+"</td><td>"+telefono+"</td><td>"+celular+"</td><td>"+email+"</td><td>"+rol+"</td>" +
                            "<td width='25' align='center'>" +
                            "<a href='#' class='actualizar' data-reveal-id='ForM' cedula="+cedula+"></a>" +
                            "</td>" +
                            "<td width='25' align='center'>" +
                            "<a href='#' class='eliminar' data-reveal-id='ForB' cedula="+cedula+"></a>" +
                            "</td>" +
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

            $('.eliminar').on('click', function() {
                var integrante = $(this).attr('cedula');
                btnModalEliminar(integrante, _GlobalArrayDatos);
            });
        }
    });
    guardarUsuarios();
    actualizarUsuario();
    eliminarUsuario();
    
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
            {
                "bSortable": false
            },
            {
                "bSortable": false
            }
        ]
    });
}

function btnModalEliminar(int, DatosInt) {
    var encontro = false;
    for (var idInt in DatosInt) {
        if (DatosInt[idInt].cedula == int) {
            $('#inusu').val(DatosInt[idInt].cedula);
            encontro = true;
            break;
        }
    }
}

function verIntModalActualizar(usuarios, datos) {
    var encontrado = false;
    for (var i in datos) {
        if (datos [i].cedula == usuarios) {
            $("#nom").val(datos[i].nombre);
            $("#ap").val(datos[i].apellido);
            $("#ce").val(datos[i].cedula);
            $("#di").val(datos[i].direccion);
            $("#bar").val(datos[i].barrio);
            $("#tel").val(datos[i].telefono);
            $("#cel").val(datos[i].celular);
            $("#em").val(datos[i].email);
            $("#pas").val(datos[i].contraseña);
            $("#ro") .val(datos[i].rol);
            $("#integrante").val(usuarios);
            encontrado = true;
            break;
        }
    }

}

function guardarUsuarios() {
    $('#nomb').focus();
    $('#guardarUsuario').click(function() {
        var nombreVar    = $('#nomb').val();
        var apellidoVar  = $('#apel').val();
        var cedulaVar    = $('#cedu').val();
        var direccionVar = $('#dire').val();
        var barrioVar    = $('#barr').val();
        var telefonoVar  = $('#tele').val();
        var celularVar   = $('#cele').val();
        var emailVar     = $('#emai').val();
        var contraseñaVar   = $('#pass').val();
        var rolVar          = $('#rol') .val();
        if (nombreVar !== '' && celularVar !== '' && emailVar !== '' && contraseñaVar!=='' && rolVar!=='') {
            $.ajax({type: 'POST',
                data: {accion: 'guardarUsuarios', nomb: nombreVar, apel: apellidoVar, 
                cedu: cedulaVar, dire: direccionVar, barr: barrioVar, 
                tele: telefonoVar, cele: celularVar, emai: emailVar, pass:contraseñaVar, rol:rolVar},
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

function actualizarUsuario() {
    $('#modificar').click(function() {
        var nomVar  = $('#nom').val();
        var apeVar  = $('#ap').val();
        var cedVar  = $('#ce').val();
        var dirVar  = $('#di').val();
        var barVar  = $('#bar').val();
        var telVar  = $('#tel').val();
        var celVar  = $('#cel').val();
        var emaVar  = $('#em').val();
        var contraseñaVar =$('#pas').val();
        var rolVar  = $('#ro').val();
        if ( nomVar !== '' && apeVar !== '' && cedVar !=='' && dirVar !=='' && barVar !=='' && telVar !=='' && celVar!=='' && emaVar !=='' && contraseñaVar!=='' && rolVar!=='') {
            $.ajax({type: 'POST',
                data: {accion: 'modificarUsuario', nom: nomVar, ap: apeVar, ce:cedVar, di:dirVar, bar:barVar, tel:telVar, cel:celVar, em:emaVar, pas:contraseñaVar, ro:rolVar},
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

function eliminarUsuario(){
    $('#eliminar').click(function() {
        var cedVar = $('#inusu').val();
        $.ajax({
            type: 'POST',
            data:{accion:'eliminarUsuario', inusu:cedVar},
            url:'Crud',
             success: function(result) {
                if (result == true) {
                    $('#eliminarok').html('Registro eliminado');
                    $('#eliminar').hide();
                    $('#cerrar').hide();
                } else if (result == false) {
                    $('#borrarok').html('Error al eliminar');

                }
            }
        });
    });
}




