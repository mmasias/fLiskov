# Propuesta 002: respetando abierto/cerrado

La propuesta con [TerrenoFactory](TerrenoFactory.java) resolvía el problema de las violaciones del Principio de Sustitución de Liskov mediante la aplicación de composición en lugar de herencia. Sin embargo, aunque funcionalmente correcta, esta solución presentaba una debilidad importante: violaba el principio Abierto/Cerrado (OCP).

- El problema principal de TerrenoFactory es que cada tipo de terreno requiere un método específico en la clase (crearSuelo(), crearAguasNormales(), etc.)
- Esto significa que para cada nuevo tipo de terreno que quisiéramos añadir, necesitaríamos modificar la clase TerrenoFactory agregando un nuevo método, lo que va en contra del principio OCP que establece que 'las entidades de software deben estar abiertas para extensión pero cerradas para modificación'.

Se propone, mediante [RegistroTerrenos](RegistroTerrenos.java), superar esta limitación mediante la implementación de un ***registro dinámico de tipos de terreno***.

En lugar de tener métodos específicos para cada tipo, habrán mecanismos para registrar cualquier cantidad de tipos de terreno mediante proveedores (implementaciones de la interfaz Proveedor<Terreno>).

Esta evolución nos permite pasar de un enfoque estático y cerrado a uno dinámico y abierto, donde diferentes partes del sistema (o incluso módulos externos) pueden registrar sus propios tipos de terreno sin necesidad de modificar el código existente, con lo que  RegistroTerrenos no solo mantiene las ventajas de la composición sobre la herencia para evitar violaciones de LSP, sino que también cumple con el principio Abierto/Cerrado, haciendo el sistema genuinamente extensible.

- [RegistroTerrenos](RegistroTerrenos.java) se encarga solo del mecanismo de registro.
- [TerrenosEstandar](TerrenosEstandar.java) contiene los terrenos básicos del juego.
- [TerrenosEspeciales](TerrenosEspeciales.java) contiene terrenos más experimentales o especiales.
- [RegistroTerrenosExtendido](RegistroTerrenosExtendido.java) carga ahora registros nuevos o premium!!!

## Diferencias clave

|TerrenoFactory|RegistroTerrenos|
|-|-|
|Utiliza métodos estáticos específicos para cada tipo de terreno (crearSuelo(), crearAguasNormales(), etc.)|Utiliza un registro dinámico donde los tipos de terreno se añaden mediante un método genérico (registrarTerreno())|
|Requiere modificar la clase cada vez que se quiere añadir un nuevo tipo de terreno|Permite agregar nuevos tipos de terreno sin modificar la clase existente|
|La lógica de creación está codificada directamente en la clase|La lógica de creación está encapsulada en lambdas/proveedores registrados|
|Sigue el patrón Factory Method, pero con una implementación estática|Combina los patrones Registry y Factory para lograr extensibilidad|
|No respeta el principio Abierto/Cerrado porque está cerrado a extensión sin modificación|Respeta el principio Abierto/Cerrado al estar abierto a extensión sin requerir modificación|
