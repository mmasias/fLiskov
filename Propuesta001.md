# Propuesta 001: composición con parametrización explícita

- Se define una interfaz para la estrategia de transitabilidad: [EstrategiaTransitabilidad](EstrategiaTransitabilidad.java)
- Se implementan las estrategias: [TransitabilidadEstandar](TransitabilidadEstandar.java) y [TransitabilidadAleatoria](TransitabilidadAleatoria.java)
- Una única clase base para todos los terrenos: [Terreno](Terreno.java)
- Una fábrica para los diferentes tipos de terreno: [TerrenoFactory](TerrenoFactory.java)
  - Esta fábrica permite crear explícitamente todos los tipos de terreno, incluyendo los especiales sin violar Liskov. De hecho:
    - En aguas pútridas usamos la estategia aleatoria, pero es explícito en la fábrica!
    - En aguas rápidas permitimos todos los medios de transporte para AguasRapidas, pero lo mismo: de modo explícito en la fábrica!
- Hecho esto, ajustamos Mundo para utilizar esta fábrica.

## Con esto

- Se evitan violaciones de LSP: No hay jerarquía de herencia que pueda violar el principio de Liskov.
- Se favorece la composición sobre herencia: Utilizamos composición con la estrategia de transitabilidad, lo que hace el código más flexible.
- Intención explícita: La fábrica muestra claramente qué tipos de terreno existen y sus características.
- Comportamientos especiales documentados: Los tipos "especiales" como aguas pútridas y rápidas están documentados en métodos específicos.
- Mantenibilidad: Es fácil añadir nuevos tipos de terreno sin afectar el código existente.
- Extensibilidad: Podemos crear nuevas estrategias de transitabilidad para implementar comportamientos más complejos sin violar principios de diseño.
- Testabilidad: Es más fácil hacer pruebas unitarias con comportamientos aislados y bien definidos.

Esta solución mantiene la riqueza del dominio (todos los tipos de terreno especiales) pero sin introducir las violaciones del Principio de Sustitución de Liskov que hacían el sistema impredecible.

## Sin embargo

¡No respeta abierto/cerrado! ¿Por qué? Porque tendríamos que modificar la clase TerrenoFactory cada vez que querramos agregar un nuevo tipo de terreno...
