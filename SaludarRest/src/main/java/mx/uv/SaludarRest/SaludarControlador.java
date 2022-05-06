package mx.uv.SaludarRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SaludarControlador {

    List<Saludo> listaSaludos = new ArrayList<Saludo>();
    int contador =0;


    @RequestMapping("/")
    public String home(){
        return "Hola mundo home(/)";
    }

    @RequestMapping(value = "/saludar", method = RequestMethod.GET)
    public String saludarGet(){
        return "hola /saludar GET";
    }

    @RequestMapping(value = "/saludar", method = RequestMethod.POST)
    public String saludarPOST(){
        return "hola /saludar POST";
    }

    @GetMapping("/saludar1/{xxx}")
    public Saludador saludarPath1(@PathVariable("xxx") String nombreX){
        return new Saludador(nombreX);
   
    }


    @RequestMapping(value = "/saludar2/{nombre}", method = RequestMethod.GET)
    public String saludarPath2(@PathVariable String nombre){
        return "Hola nombre= "+ nombre;
    }

    @GetMapping("/saludarme1")
    public Saludador saludarme1(@RequestParam String nombreX){
        return new Saludador(nombreX);
   
    }

    @GetMapping("/saludarme2")
    public Saludador saludarme2(@RequestParam(name="xx", defaultValue = "hola") String nombreX){
        return new Saludador(nombreX);
   
    }


    @GetMapping("/saludarTarea")
    public String saludarTarea(@RequestParam(name="nombre",defaultValue="Abel") String nombre){
        Saludo saludo = new Saludo();
        saludo.setNombre(nombre);
        saludo.setId(contador);
        listaSaludos.add(saludo);
        contador++;
        return " Hola " + nombre;
    }

    @GetMapping("/lista")
    public List<Saludo> lista(){
        return listaSaludos;
    } 

    @GetMapping("/modificar")
    public String modificar(@RequestParam(name="id",defaultValue="") int id, @RequestParam(name="nombre",defaultValue="") String nombre){

        Saludo saludo = new Saludo();
        saludo.setId(id);
        saludo.setNombre(nombre);
        listaSaludos.set(id,saludo);
        return "Se ha modificado con exito";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam(name="id",defaultValue="") int id){
        Saludo saludo = new Saludo();
        saludo.setId(id);
        listaSaludos.remove(saludo.getId());
        return "Se ha eliminado con exito";
    }





}
