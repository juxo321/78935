package mx.uv.SaludarRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;



@RestController
public class SaludarControlador {
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

    @GetMapping("/saludarTareas")
	public String saludarTareas(@RequestParam(name="nombre", defaultValue = "pablito") Model modelo, String nombre){
		modelo.addAttribute("nombre", nombre);
		return "Saludando";
	}



}
