package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidades.Cliente;
import Entidades.Usuarios;
import Entidades.Servicio;
import Entidades.TipoServicio;
import Entidades.TipoEstado;
import Entidades.TipoUsuario;
import Entidades.MedicionServicio;
import Modelo.Sql;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class Crud extends HttpServlet {
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
      
        String accion=(String)request.getParameter("accion");
        //Acciones del formulario clientes
        if(accion.equals("verClientes")){verClientes(response);

        }else if(accion.equals("guardarClientes")){guardarClientes(request,response); 

        }else if(accion.equals("actualizarClientes")){ actualizarClientes(request,response);

        }//else if(accion.equals("eliminarClientes")){ eliminarClientes(request,response);}
        
         //Acciones del formulario usuarios
         else if(accion.equals("verUsuarios")){verUsuarios(response);

        }else if(accion.equals("guardarUsuarios")){guardarUsuarios(request,response);

        }else if(accion.equals("modificarUsuario")){modificarUsuario(request,response);

        }else if(accion.equals("eliminarUsuario")){eliminarUsuario(request,response);

        }else if(accion.equals("login")){login(request,response);
        }
        //Acciones del formulario  servicios
         else if(accion.equals("verServicio")){verServicio(response);

        }else if(accion.equals("modificarServcio")){ modificarServcio(request,response);

        }// else if(accion.equals("eliminarServicio")){eliminarServicio(request,response);}
        //Llenar selects de tipo de servicio
         else if(accion.equals("llenarSelect")){ llenarSelect(request,response);

        }else if(accion.equals("llenarSelectServicio")){ llenarSelectServicio(request,response);
            
        }else if (accion.equals("llenarSelectEstado")){llenarSelectEstado(request,response);
            
        }else if (accion.equals("llenarSelectTipUsuario")){llenarSelectTipUsuario(request,response);
        
        }else if(accion.equals("verMedicionServicio")){verMedicionServicio(response);
        
        }else if(accion.equals("actualizarMedicionServicio")){actuaMediServicio(request,response);
        
        }
    }
    
    private void guardarClientes(HttpServletRequest request, HttpServletResponse response) throws IOException {
                
            Gson gson=new Gson();
            response.setContentType("application/json");

            String nom=request.getParameter("nom").toUpperCase();
            String ape=request.getParameter("ape").toUpperCase();
            String ced=request.getParameter("ced");
            String dir=request.getParameter("dir").toUpperCase();
            String bar=request.getParameter("bar").toUpperCase();
            String tel=request.getParameter("tel");
            String cel=request.getParameter("cel");
            String ema=request.getParameter("ema").toUpperCase();
            String serv=request.getParameter("servicios");
            
            Cliente cl=new Cliente(nom, ape, ced, dir, bar, tel, cel, ema, serv);
                boolean res =Sql.guardarClientes(cl);
                JsonElement elemento=gson.toJsonTree(res);
                boolean result =elemento.getAsBoolean();
                response.getWriter().print(result);
    }

    private void verClientes(HttpServletResponse response) throws IOException {
        List<Cliente> verClientes= new ArrayList<Cliente>();
        Gson gson=new Gson();
        response.setContentType("application/json");
        verClientes=Sql.verClientes();
        //Convertimos java en un objeto Json
        JsonElement element = gson.toJsonTree(verClientes, new TypeToken<List<Cliente>>() {}.getType());
        JsonArray jsonArray=element.getAsJsonArray();
        String muestraDato=jsonArray.toString();			
        //listaDatos="{\"Resultado\":\"OK\",\"Datos\":"+listaDatos+"}";
        response.getWriter().print(muestraDato);
    }

    private void actualizarClientes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson=new Gson();
        response.setContentType("application/json");
        
        String nomb=request.getParameter("nomb").toUpperCase();
        String apellido=request.getParameter("apel").toUpperCase();
        String cedula=request.getParameter("cedu");
        String direccion=request.getParameter("dire").toUpperCase();
        String barrio=request.getParameter("barr").toUpperCase();
        String telefono=request.getParameter("tele");
        String celular=request.getParameter("celu");
        String email=request.getParameter("emai").toUpperCase();
        String serv=request.getParameter("servicios");
        
        Cliente cli=new Cliente(nomb, apellido, cedula, direccion, barrio, telefono, celular, email, serv);
            boolean resu=Sql.actualizarClientes(cli);
            JsonElement elemento = gson.toJsonTree(resu);
            boolean result=elemento.getAsBoolean();			
            response.getWriter().print(result);
    }

//    private void eliminarClientes(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Gson gson=new Gson();
//        response.setContentType("application/json");
//        
//        String ced=request.getParameter("inclient");
//        Cliente clie=new Cliente(ced, ced, ced, ced, ced, ced, ced, ced, ced);
//        boolean rs=Sql.eliminarClientes(clie);
//        JsonElement element=gson.toJsonTree(rs);
//        boolean res=element.getAsBoolean();
//        response.getWriter().print(res);
//    }

      //Acciones del formulario usuarios
    private void verUsuarios(HttpServletResponse response) throws IOException {
        
        List<Usuarios> verUsuarios= new ArrayList<Usuarios>();
        Gson gson=new Gson();
        response.setContentType("application/json");
        
        verUsuarios=Sql.verUsuarios();
        //Convertimos java en un objeto Json
        JsonElement element = gson.toJsonTree(verUsuarios, new TypeToken<List<Usuarios>>() {}.getType());
        JsonArray jsonArray=element.getAsJsonArray();
        String muestraDato=jsonArray.toString();			
        //listaDatos="{\"Resultado\":\"OK\",\"Datos\":"+listaDatos+"}";
        response.getWriter().print(muestraDato);
    } 
    
    private void guardarUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson=new Gson();
        response.setContentType("application/json");
        
        String nom=request.getParameter("nomb").toUpperCase();
        String ape=request.getParameter("apel").toUpperCase();
        String ced=request.getParameter("cedu");
        String dir=request.getParameter("dire").toUpperCase();
        String bar=request.getParameter("barr").toUpperCase();
        String tel=request.getParameter("tele");
        String cel=request.getParameter("cele");
        String ema=request.getParameter("emai").toUpperCase();
        String contraseña=request.getParameter("pass");
        String rol=request.getParameter("rol");
        
        Usuarios us=new Usuarios(nom, ape, ced, dir, bar, tel, cel, ema, contraseña, rol);
            boolean res =Sql.InsertarUsuario(us);
            JsonElement elemento=gson.toJsonTree(res);
            boolean result =elemento.getAsBoolean();
            response.getWriter().print(result); 
        
    }

    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response)throws IOException{
        Gson gson=new Gson();
        response.setContentType("application/json");
        
        String nomb=request.getParameter("nom").toUpperCase();
        String apellido=request.getParameter("ap").toUpperCase();
        String cedula=request.getParameter("ce");
        String direccion=request.getParameter("di").toUpperCase();
        String barrio=request.getParameter("bar").toUpperCase();
        String telefono=request.getParameter("tel");
        String celular=request.getParameter("cel");
        String email=request.getParameter("em").toUpperCase();
        String contraseña=request.getParameter("pas");
        String rol=request.getParameter("ro");
        
        Usuarios us=new Usuarios(nomb, apellido, cedula, direccion, barrio, telefono, celular, email, contraseña, rol);
            boolean resu=Sql.modificarUsuario(us);
            JsonElement elemento = gson.toJsonTree(resu);
            boolean result=elemento.getAsBoolean();			
            response.getWriter().print(result);
    }
    
    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson=new Gson();
        response.setContentType("application/json");
        
        String ced=request.getParameter("inusu");
        Usuarios us=new Usuarios(ced, ced, ced, ced, ced, ced, ced, ced, ced, ced);
        boolean rs=Sql.eliminarUsuario(us);
        JsonElement element=gson.toJsonTree(rs);
        boolean res=element.getAsBoolean();
        response.getWriter().print(res);
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Usuarios> user=new ArrayList<Usuarios>();
        Gson gson=new Gson();
        response.setContentType("application/json");

        String ced=request.getParameter("cedul");
        String contraseña=request.getParameter("pass");
        Usuarios us=new Usuarios(ced, ced, ced, ced, ced, ced, ced, ced, contraseña, ced);
        
        user=Sql.login(us);
        //Convertimos java en un objeto Json
        JsonElement element = gson.toJsonTree(user, new TypeToken<List<Usuarios>>() {}.getType());
        JsonArray jsonArray=element.getAsJsonArray();
        String muestraDato=jsonArray.toString();			
        //listaDatos="{\"Resultado\":\"OK\",\"Datos\":"+listaDatos+"}";
        response.getWriter().print(muestraDato);

    }
    
     //Acciones del formulario servicios
    private void verServicio(HttpServletResponse response) throws IOException {
        List<Servicio> verServicio= new ArrayList<Servicio>();
        Gson gson=new Gson();
        response.setContentType("application/json");
        
        verServicio=Sql.verServicio();
       //Convertimos java en un objeto Json
        JsonElement element = gson.toJsonTree(verServicio, new TypeToken<List<Usuarios>>() {}.getType());
        JsonArray jsonArray=element.getAsJsonArray();
        String verS=jsonArray.toString();			
        //listaDatos="{\"Resultado\":\"OK\",\"Datos\":"+listaDatos+"}";
        response.getWriter().print(verS);
        
    }
    
    private void modificarServcio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson=new Gson();
        response.setContentType("application/json");
        try{
        String id=request.getParameter("servicio");
        String nombre=request.getParameter("nom").toUpperCase();
        String apellido=request.getParameter("ape").toUpperCase();
        String direccion=request.getParameter("dir").toUpperCase();
        String telefono=request.getParameter("tel");
        String servicio=request.getParameter("servi");
        String fecha=request.getParameter("fec");
        String estado =request.getParameter("esta");
        String user=request.getParameter("rol");
        String cedula=request.getParameter("cedula");
        
        Servicio servicios= new Servicio(id, nombre, apellido, direccion, telefono, servicio, fecha, estado, user, cedula);
        boolean resu=Sql.modificarServicio(servicios);
        JsonElement elemento = gson.toJsonTree(resu);
        boolean result=elemento.getAsBoolean();			
        response.getWriter().print(result);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

//    private void eliminarServicio(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Gson gson=new Gson();
//        response.setContentType("application/json");
//        
//        String estado=request.getParameter("servicio");
//        Servicio ser=new Servicio(estado, estado, estado, estado, estado, estado, estado, estado, estado, estado);
//        boolean rs=Sql.eliminarServcio(ser);
//        JsonElement element=gson.toJsonTree(rs);
//        boolean res=element.getAsBoolean();
//        response.getWriter().print(res);
//        
//    }
//    
    private void llenarSelect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<TipoServicio> llenarSelect= new ArrayList<TipoServicio>();
        Gson gson=new Gson();
        response.setContentType("application/json");
        
        llenarSelect=Sql.verTipoServicio();
       //Convertimos java en un objeto Json
        JsonElement element = gson.toJsonTree(llenarSelect, new TypeToken<List<Usuarios>>() {}.getType());
        JsonArray jsonArray=element.getAsJsonArray();
        String verS=jsonArray.toString();			
        //listaDatos="{\"Resultado\":\"OK\",\"Datos\":"+listaDatos+"}";
        response.getWriter().print(verS);
    }
    
    private void llenarSelectServicio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<TipoServicio> llenarSelectServicio= new ArrayList<TipoServicio>();
        Gson gson=new Gson();
        response.setContentType("application/json");
        
        llenarSelectServicio=Sql.verTiServ();
       //Convertimos java en un objeto Json
        JsonElement element = gson.toJsonTree(llenarSelectServicio, new TypeToken<List<Usuarios>>() {}.getType());
        JsonArray jsonArray=element.getAsJsonArray();
        String verTs=jsonArray.toString();			
        //listaDatos="{\"Resultado\":\"OK\",\"Datos\":"+listaDatos+"}";
        response.getWriter().print(verTs);
    }
    
    private void llenarSelectEstado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<TipoEstado> llenarSelectEstado= new ArrayList<TipoEstado>();
        Gson gson=new Gson();
        response.setContentType("application/json");
        
        llenarSelectEstado=Sql.verTiest();
       //Convertimos java en un objeto Json
        JsonElement element = gson.toJsonTree(llenarSelectEstado, new TypeToken<List<Usuarios>>() {}.getType());
        JsonArray jsonArray=element.getAsJsonArray();
        String verTe=jsonArray.toString();			
        //listaDatos="{\"Resultado\":\"OK\",\"Datos\":"+listaDatos+"}";
        response.getWriter().print(verTe);
    }
    
    private void llenarSelectTipUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<TipoUsuario> llenarSelectTipUsuario= new ArrayList<TipoUsuario>();
        Gson gson=new Gson();
        response.setContentType("application/json");
        
        llenarSelectTipUsuario=Sql.verTiUsu();
       //Convertimos java en un objeto Json
        JsonElement element = gson.toJsonTree(llenarSelectTipUsuario, new TypeToken<List<Usuarios>>() {}.getType());
        JsonArray jsonArray=element.getAsJsonArray();
        String verUs=jsonArray.toString();			
        //listaDatos="{\"Resultado\":\"OK\",\"Datos\":"+listaDatos+"}";
        response.getWriter().print(verUs);
    }
  
    private void verMedicionServicio(HttpServletResponse response) throws IOException {
        List<MedicionServicio> verMedicionServicio= new ArrayList<MedicionServicio>();
        Gson gson=new Gson();
        response.setContentType("application/json");
        
        verMedicionServicio = Sql.vermedservi();
       //Convertimos java en un objeto Json
        JsonElement element = gson.toJsonTree(verMedicionServicio, new TypeToken<List<MedicionServicio>>() {}.getType());
        JsonArray jsonArray=element.getAsJsonArray();
        String verMS=jsonArray.toString();			
        //listaDatos="{\"Resultado\":\"OK\",\"Datos\":"+listaDatos+"}";
        response.getWriter().print(verMS);
        
    }
    
    private void actuaMediServicio(HttpServletRequest request, HttpServletResponse response) throws IOException {
       Gson gson=new Gson();
       response.setContentType("application/json");

       String idmedserv=request.getParameter("idmedser");
       String cedula=request.getParameter("ced");
       String servicio=request.getParameter("servi");
       String medicion=request.getParameter("medi");
       String observaciono=request.getParameter("obser");
       
       MedicionServicio ms = new MedicionServicio(idmedserv, cedula, servicio, medicion, observaciono);
        boolean resu=Sql.modificarMedServ(ms);
        JsonElement elemento = gson.toJsonTree(resu);
        boolean result=elemento.getAsBoolean();			
        response.getWriter().print(result);
   }

     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

}
    


