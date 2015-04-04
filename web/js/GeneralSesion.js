
$(document).ready(function(){
//    var dataBase = indexedDB.open("SHA", "1.0");
//    dataBase.onupgradeneeded =function(e){
//         var db = event.target.result;
//        var objectStore = db.createObjectStore("customers", {keyPath: "id"});
//        for (var i in customerData) {
//                objectStore.add(customerData[i]);       
//        }
//    };
//    dataBase.onsuccess=function(e){
//        alert('La db se creo exitosamente');
//    }
    pintarLogin();
});

function pintarLogin(){
   var nombreUser=sessionStorage.getItem('nombreUsr');
   var apellidoUser=sessionStorage.getItem('apellidoUsr');
   if(nombreUser===null && apellidoUser===null){
       window.location=paginas.inicio;
       //$(window.location).attr('href','index.jsp');
   }else{
      var cerrar="<a href='#' cerrar="+nombreUser+" class='cerrarSession'>Salir</a>";
   $('#login').html("<tr><td>"+nombreUser+''+apellidoUser+''+cerrar+"</td></tr>"); 
   }
   
   //se cierra la session
   $('.cerrarSession').on("click", function(){
     window.location=paginas.inicio;
     sessionStorage.clear();
    });
}




