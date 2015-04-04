
$(document).ready(function(){
    
    $('#cedul').focus();
    $('#insertarlogin').click(function() {
        var cedulaVar = $('#cedul').val();
        var passVar   = $('#pass').val();
        if (cedulaVar !== '' && passVar !== '') {
            $.ajax({type: 'POST',
                data: {accion: 'login', cedul: cedulaVar, pass:passVar},
                url: 'Crud',
                success: function(objetoResult){
                    if(objetoResult.length===1){
                     var Session=objetoResult
                    $.each(Session, function(key, valores) {
                        var cedula = valores.cedula;
                        var pass = valores.contraseña;
                        var nombre=valores.nombre;
                        var apellido=valores.apellido;
                        if(cedula===cedulaVar && pass===passVar){
                            window.location=paginas.MenuPP;
                            sessionStorage.setItem("cedulaUsr",cedula);
                            sessionStorage.setItem("nombreUsr",nombre);
                            sessionStorage.setItem("apellidoUsr",apellido);
                            
                        }else{
                            $('#errorLogin').html('Cedula ó contraseña invalida');
                        }
                });  
                }else{
                  $('#errorLogin').html('Cedula ó contraseña invalida');
                  } 
                }
            });
        }else{
            $('#Vacio').html('LLENE LOS CAMPOS' )
        }
    });
});






