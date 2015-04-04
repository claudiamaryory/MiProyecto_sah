package Modelo;

import Entidades.Cliente;
import Entidades.Usuarios;
import Entidades.Servicio;
import Entidades.TipoServicio;
import Entidades.TipoUsuario;
import Entidades.TipoEstado;
import Entidades.MedicionServicio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

public class Sql {
    
  public static List<Cliente> verClientes(){

       List<Cliente> us=new ArrayList<Cliente>();
       try{
           Connection con=Conexion.getConexion();
           CallableStatement cst=con.prepareCall("{call SAH.LISTARCLIENTE(?)}");
           cst.registerOutParameter(1,OracleTypes.CURSOR);
           cst.executeQuery();
           ResultSet res= (ResultSet)cst.getObject(1);
          while(res.next()){
             Cliente cli=new Cliente(null, null, null, null, null, null, null, null, null);
              cli.setNombre(res.getString(2));
              cli.setApellido(res.getString(3));
              cli.setCedula(res.getString(4));
              cli.setDireccion(res.getString(5));
              cli.setBarrio(res.getString(6));
              cli.setTelefono(res.getString(7));
              cli.setCelular(res.getString(8));
              cli.setEmail(res.getString(9));
              us.add(cli);
    //           Object[] array=us.toArray();// asi pasamos los datos de un ArrayList a un Array normal
    //           System.out.println(array);
          }
       }catch(SQLException e){
           e.printStackTrace();
       }
       return us;
    }

  public static boolean guardarClientes(Cliente cl){

       boolean res=false;
       try{
           Connection con=Conexion.getConexion();
           CallableStatement call=con.prepareCall("{call SAH.INSERTARCLIENTE(?,?,?,?,?,?,?,?,?,?)}");
           call.setString(1, cl.getNombre());
           call.setString(2, cl.getApellido());
           call.setString(3, cl.getCedula());
           call.setString(4, cl.getDireccion());
           call.setString(5, cl.getBarrio());
           call.setString(6, cl.getTelefono());
           call.setString(7, cl.getCelular());
           call.setString(8, cl.getEmail());
           call.setString(9, cl.getServi());
           call.registerOutParameter(10, OracleTypes.CHAR);
           call.executeUpdate();
           String result=call.getString(10);

           int rst=Integer.parseInt(result);
           if(rst==1){
               res=true;
           }else{
               res=false;
           }


       }catch(NumberFormatException e){
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
        }
        return res;
    }

  public static boolean actualizarClientes(Cliente cl){
        
        boolean act=false;
        try{
           Connection con=Conexion.getConexion();
           CallableStatement cs=con.prepareCall("{call SAH.ACTUALIZARCLIENTE(?,?,?,?,?,?,?,?,?)}");
           cs.setString(1, cl.getNombre());
           cs.setString(2, cl.getApellido());
           cs.setString(3, cl.getCedula());
           cs.setString(4, cl.getDireccion());
           cs.setString(5, cl.getBarrio());
           cs.setString(6, cl.getTelefono());
           cs.setString(7, cl.getCelular());
           cs.setString(8, cl.getEmail());
           cs.registerOutParameter(9, OracleTypes.CHAR);
           cs.executeUpdate();
           String resul=cs.getString(9);
           int rs=Integer.parseInt(resul);
            if(rs==1){
                act=true;
            }else if(rs==0){
                act=false;
            }
        }catch(NumberFormatException ex){
           ex.printStackTrace();
        }   catch (SQLException ex) {
            ex.printStackTrace();
            }
        return act;
    }

//    public static boolean eliminarClientes(Cliente cli){
//       boolean elimino=false;
//       try{
//           Connection con=Conexion.getConexion();
//           CallableStatement cll=con.prepareCall("{call SAH.ELIMINARCLIENTE(?,?)}");
//           cll.setString(1, cli.getCedula());
//           cll.registerOutParameter(2,OracleTypes.CHAR);
//           cll.executeUpdate();
//           String res=cll.getString(2);
//           int i=Integer.parseInt(res);
//           if(i==1){
//               elimino=true;
//           }else{
//           elimino=false;
//       }
//       }catch(Exception e){
//           e.printStackTrace();
//       }
//       return elimino;
//    }

    //Acciones del formulario usuarios
  public static ArrayList<Usuarios> verUsuarios(){

    ArrayList<Usuarios> us=new ArrayList<Usuarios>();
    try{
       Connection con=Conexion.getConexion();
       CallableStatement cst=con.prepareCall("{call SAH.LISTARUSUARIO(?)}");
       cst.registerOutParameter(1,OracleTypes.CURSOR);
       cst.executeQuery();
       ResultSet res= (ResultSet)cst.getObject(1);
      while(res.next()){
         Usuarios use=new Usuarios(null, null, null, null, null, null, null, null, null, null);
          use.setNombre(res.getString(1));
          use.setApellido(res.getString(2));
          use.setCedula(res.getString(3));
          use.setDireccion(res.getString(4));
          use.setBarrio(res.getString(5));
          use.setTelefono(res.getString(6));
          use.setCelular(res.getString(7));
          use.setEmail(res.getString(8));
          use.setContraseña(res.getString(9));
          use.setRol(res.getString(10));
          us.add(use);
      }

    }catch(SQLException e){
       e.printStackTrace();
    }
    return us;
    }

  public static boolean InsertarUsuario(Usuarios usu){
        
        boolean res=false;
        try{
           Connection con=Conexion.getConexion();
           CallableStatement call=con.prepareCall("{call SAH.INSERTARUSUARIO(?,?,?,?,?,?,?,?,?,?,?)}");
                call.setString(1, usu.getNombre());
                call.setString(2, usu.getApellido());
                call.setString(3, usu.getCedula());
                call.setString(4, usu.getDireccion());
                call.setString(5, usu.getBarrio());
                call.setString(6, usu.getTelefono());
                call.setString(7, usu.getCelular());
                call.setString(8, usu.getEmail());
                call.setString(9, usu.getContraseña());
                call.setString(10,usu.getRol());
                call.registerOutParameter(11, OracleTypes.CHAR);
                call.executeUpdate();
           String result=call.getString(11);

           int rst=Integer.parseInt(result);
           if(rst==1){
               res=true;
           }else{
               res=false;
           }


        }catch(Exception e){
           e.printStackTrace();
        }
        return res;
    }

  public static boolean modificarUsuario(Usuarios usu){
        
        boolean act=false;
        try{
        Connection con=Conexion.getConexion();
        CallableStatement cs=con.prepareCall("{call SAH.MODIFICARUSUARIO(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, usu.getNombre());
            cs.setString(2, usu.getApellido());
            cs.setString(3, usu.getCedula());
            cs.setString(4, usu.getDireccion());
            cs.setString(5, usu.getBarrio());
            cs.setString(6, usu.getTelefono());
            cs.setString(7, usu.getCelular());
            cs.setString(8, usu.getEmail());
            cs.setString(9, usu.getContraseña());
            cs.setString(10,usu.getRol());
            cs.registerOutParameter(11, OracleTypes.CHAR);
            cs.executeUpdate();
        String resul=cs.getString(11);
        int rs=Integer.parseInt(resul);
        if(rs==1){
           act=true;
        }else if(rs==0){
           act=false;
        }
        }catch(Exception ex){
        ex.printStackTrace();
        }
        return act;
    }

  public static boolean eliminarUsuario(Usuarios usu){
        
        boolean elimino=false;
        try{
           Connection con=Conexion.getConexion();
           CallableStatement cll=con.prepareCall("{call SAH.ELIMINARUSUARIO(?,?)}");
            cll.setString(1, usu.getCedula());
            cll.registerOutParameter(2,OracleTypes.CHAR);
            cll.executeUpdate();
           String res=cll.getString(2);
           int i=Integer.parseInt(res);
           if(i==1){
               elimino=true;
           }else{
           elimino=false;
        }
        }catch(Exception e){
           e.printStackTrace();
        }
        return elimino;
    }

  public static List<Usuarios> login(Usuarios usu){
          
           List<Usuarios> user=new ArrayList<Usuarios>();
        try{
            Connection con=Conexion.getConexion();
            CallableStatement call=con.prepareCall("{call SAH.LOGIN(?,?,?)}");
                call.setString(1, usu.getCedula());
                call.setString(2, usu.getContraseña());
                call.registerOutParameter(3, OracleTypes.CURSOR);
                call.executeUpdate();
           ResultSet rs=(ResultSet)call.getObject(3);
            if(rs.next()){
               Usuarios us=new Usuarios(null, null, null, null, null, null, null, null, null, null);
               us.setNombre(rs.getString(1));
               us.setApellido(rs.getString(2));
               us.setCedula(rs.getString(3));
               us.setContraseña(rs.getString(4));
               user.add(us);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
         return user;
     }
    
    //Acciones del formulario servicios
  public static ArrayList<Servicio> verServicio(){

        ArrayList<Servicio> servicio=new ArrayList<Servicio>();
        try{
           Connection con=Conexion.getConexion();
           CallableStatement cst=con.prepareCall("{call SAH.LISTARSERVICIO(?)}");
            cst.registerOutParameter(1,OracleTypes.CURSOR);
            cst.executeQuery();
           ResultSet res= (ResultSet)cst.getObject(1);
          while(res.next()){
             Servicio ser=new Servicio(null, null, null, null, null, null, null, null, null, null);
                ser.setIdcliente(res.getString(1));
                ser.setNombre(res.getString(2));
                ser.setApellido(res.getString(3));
                ser.setDireccion(res.getString(4));
                ser.setTelefono(res.getString(5));
                ser.setServicio(res.getString(6));
                ser.setFecha(res.getString(7));
                ser.setEstado(res.getString(8));
                ser.setUser(res.getString(9));
                ser.setCedula(res.getString(10));
              servicio.add(ser);
          }

        }catch(Exception e){
           e.printStackTrace();
        }
        return servicio;
    }    
     
  public static boolean modificarServicio(Servicio serv){
        
        boolean servi=false;
        try{
        Connection con=Conexion.getConexion();
        CallableStatement cs=con.prepareCall("{call SAH.ACTUALIZARSERVICIO(?,?,?,?,?,?,?,?,?,?,?)}");
           cs.setString(1, serv.getIdcliente());
           cs.setString(2, serv.getNombre());
           cs.setString(3, serv.getApellido());
           cs.setString(4, serv.getDireccion());
           cs.setString(5, serv.getTelefono());
           cs.setString(6, serv.getServicio());
           cs.setString(7, serv.getFecha());
           cs.setString(8, serv.getEstado());
           cs.setString(9, serv.getUser());
           cs.setString(10,serv.getCedula());
           cs.registerOutParameter(11, OracleTypes.CHAR);
           cs.executeUpdate();
        String resul=cs.getString(11);
        int res=Integer.parseInt(resul);
            if(res==1){
               servi=true;
            }else if(res==0){
               servi=false;
            }
        }catch(NumberFormatException ex){
        ex.printStackTrace();
        }   catch (SQLException ex) {
            ex.printStackTrace();
            }
        return servi;
    }
     
//    public static boolean eliminarServcio(Servicio serv){
//    boolean elimino=false;
//    try{
//       Connection con=Conexion.getConexion();
//       CallableStatement cll=con.prepareCall("{call SAH.ELIMINARSERVICIO(?,?)}");
//       cll.setString(1, serv.getUser());
//       cll.registerOutParameter(2,OracleTypes.CHAR);
//       cll.executeUpdate();
//       String resu=cll.getString(2);
//       int i=Integer.parseInt(resu);
//       if(i==1){
//           elimino=true;
//       }else{
//       elimino=false;
//    }
//    }catch(Exception e){
//       e.printStackTrace();
//    }
//    return elimino;
//    }

  public static List<TipoServicio> verTipoServicio() {
        
         ArrayList<TipoServicio> tpServicio=new ArrayList<TipoServicio>();
         try{
             Connection con=Conexion.getConexion();
             CallableStatement call=con.prepareCall("{call SAH.LISTARTIPOSERVICIO(?)}");
             call.registerOutParameter(1, OracleTypes.CURSOR);
             call.executeQuery();
             ResultSet rs=(ResultSet)call.getObject(1);
             while(rs.next()){
                 TipoServicio tp=new TipoServicio(null, null);
                 tp.setTipoServicio(rs.getString(1));
                 tp.setNombre(rs.getString(2));
                 tpServicio.add(tp);
             }
         }catch(SQLException e){
             e.printStackTrace();
         }
         return tpServicio;
    }
    
  public static List<TipoServicio> verTipoServicios() {
        
         ArrayList<TipoServicio> tpServicio=new ArrayList<TipoServicio>();
         try{
             Connection con=Conexion.getConexion();
             CallableStatement call=con.prepareCall("{call SAH.LISTARTIPOSERVICIO(?)}");
             call.registerOutParameter(1, OracleTypes.CURSOR);
             call.executeQuery();
             ResultSet rs=(ResultSet)call.getObject(1);
             while(rs.next()){
                 TipoServicio tp=new TipoServicio(null, null);
                 tp.setTipoServicio(rs.getString(1));
                 tp.setNombre(rs.getString(2));
                 tpServicio.add(tp);
             }
         }catch(SQLException e){
             e.printStackTrace();
         }
         return tpServicio;
    }
     
  public static List<TipoServicio> verTiServ() {
        
            ArrayList<TipoServicio> tpServicio=new ArrayList<TipoServicio>();
            try{
                Connection con=Conexion.getConexion();
                CallableStatement call=con.prepareCall("{call SAH.LISTARTIPOSERVICIO(?)}");
                call.registerOutParameter(1, OracleTypes.CURSOR);
                call.executeQuery();
                ResultSet rs=(ResultSet)call.getObject(1);
                while(rs.next()){
                    TipoServicio tp=new TipoServicio(null, null);
                    tp.setTipoServicio(rs.getString(1));
                    tp.setNombre(rs.getString(2));
                    tpServicio.add(tp);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return tpServicio;
       }
    
  public static List<TipoEstado> verTiest() {
        
            ArrayList<TipoEstado> teEstado=new ArrayList<TipoEstado>();
            try{
                Connection con=Conexion.getConexion();
                CallableStatement call=con.prepareCall("{call SAH.LISTARTIPOESTADO(?)}");
                call.registerOutParameter(1, OracleTypes.CURSOR);
                call.executeQuery();
                ResultSet rs=(ResultSet)call.getObject(1);
                while(rs.next()){
                    TipoEstado te=new TipoEstado(null, null);
                    te.setIdtipoestado(rs.getString(1));
                    te.setNombre(rs.getString(2));
                    teEstado.add(te);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return teEstado;
       }
    
  public static List<TipoUsuario> verTiUsu() {
        
            ArrayList<TipoUsuario> tr=new ArrayList<TipoUsuario>();
            try{
                Connection con=Conexion.getConexion();
                CallableStatement call=con.prepareCall("{call SAH.LISTARTUS(?)}");
                call.registerOutParameter(1, OracleTypes.CURSOR);
                call.executeQuery();
                ResultSet rs=(ResultSet)call.getObject(1);
                while(rs.next()){
                    TipoUsuario trol=new TipoUsuario(null, null);
                    trol.setIdrol(rs.getString(1));
                    trol.setNombre(rs.getString(2));
                    tr.add(trol);
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return tr;
    }
 
  public static ArrayList<MedicionServicio> vermedservi(){

            ArrayList<MedicionServicio> ms=new ArrayList<MedicionServicio>();
            try{
               Connection con=Conexion.getConexion();
               CallableStatement cst=con.prepareCall("{call SAH.LISTARMEDISERVICIO(?)}");
               cst.registerOutParameter(1,OracleTypes.CURSOR);
               cst.executeQuery();
               ResultSet res= (ResultSet)cst.getObject(1);
              while(res.next()){
                 MedicionServicio mds = new MedicionServicio(null, null, null, null, null);
                  mds.setIdmedserv(res.getString(1));
                  mds.setCedulacliente(res.getString(2));
                  mds.setIdservicio(res.getString(3));
                  mds.setIdtipmedicion(res.getString(4));
                  mds.setObservacion(res.getString(5));
                  ms.add(mds);
              }

            }catch(SQLException e){
               e.printStackTrace();
            }
            return ms;
    }
    
  public static boolean modificarMedServ( MedicionServicio modi){
        
            boolean mediser=false;
            try{
            Connection con=Conexion.getConexion();
            CallableStatement cs=con.prepareCall("{call SAH.ACTUALIZARMEDICIONSERVICIO(?,?,?,?,?,?)}");
               cs.setString(1, modi.getIdmedserv());
               cs.setString(2, modi.getCedulacliente());
               cs.setString(3, modi.getIdservicio());
               cs.setString(4, modi.getIdtipmedicion());
               cs.setString(5, modi.getObservacion());
               cs.registerOutParameter(6, OracleTypes.CHAR);
               cs.executeUpdate();
            String resul=cs.getString(6);
            int res=Integer.parseInt(resul);
            if(res==1){
               mediser=true;
            }else if(res==0){
               mediser=false;
            }
            }catch(NumberFormatException ex){
            ex.printStackTrace();
            }   catch (SQLException ex) {
                ex.printStackTrace();
                }
            return mediser;
    }
     

}
    

