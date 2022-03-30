using System;
using WSDL.mensajes;

namespace WSDL.operaciones
{
    public class Operaciones : Mensajes
    {
        public string Saludar(string nombre)
        {
<<<<<<< HEAD
            string msj = "Hola "+ nombre;
=======
            string msj = "Hola "+ nombre+ "te saluda Justin";
>>>>>>> 935ed2ba14f3492de0aaa861cbccfb7b03aefbbb
            return msj;
        }
        public string Mostrar(int id)
        {
            return "x";
        }
    }
}
