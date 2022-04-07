package mx.uv.t4is.SaludosBd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BorrarSaludoRequest;
import https.t4is_uv_mx.saludos.BorrarSaludoResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.EliminarSaludoRequest;
import https.t4is_uv_mx.saludos.EliminarSaludoResponse;
import https.t4is_uv_mx.saludos.ModificarSaludoRequest;
import https.t4is_uv_mx.saludos.ModificarSaludoResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;



@Endpoint
public class SaludosEndPoint {
    //int contadorId = 1 ;
    //List<BuscarSaludosResponse.Saludos> saludos = new ArrayList<>();

    @Autowired
    Isaludadores isaludadores;

    @PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion) {
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola"+ peticion.getNombre());
        Saludadores saludo = new Saludadores();
        saludo.setNombre(peticion.getNombre());
        //saludo.setId(contadorId);
        //saludos.add(saludo);
        //contadorId ++;
        isaludadores.save(saludo);
        return respuesta;
    }

    @PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarSaludosResponse buscarSaludos(){
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        Iterable<Saludadores> lista = isaludadores.findAll();
        for (Saludadores o : lista) {
            BuscarSaludosResponse.Saludos e = new BuscarSaludosResponse.Saludos();
             e.setNombre(o.getNombre());
             e.setId(o.getId());
             respuesta.getSaludos().add(e);
         }
        return respuesta;
    }

    @PayloadRoot(localPart = "ModificarSaludoRequest" ,namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificarSaludoResponse modificarSaludo(@RequestPayload ModificarSaludoRequest peticion){       
        ModificarSaludoResponse respuesta = new ModificarSaludoResponse(); 
        Saludadores saludo = new Saludadores();
        saludo.setId(peticion.getId());
        saludo.setNombre(peticion.getNombre());
        isaludadores.save(saludo);
        respuesta.setRespuesta("Saludo modificado");        
        return respuesta;
    }

    @PayloadRoot(localPart = "EliminarSaludoRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public EliminarSaludoResponse eliminarSaludo(@RequestPayload EliminarSaludoRequest peticion){
        EliminarSaludoResponse respuesta = new EliminarSaludoResponse();
        isaludadores.deleteById(peticion.getId());
        respuesta.setRespuesta("Saludo eliminado");
        return respuesta;
    }


}

