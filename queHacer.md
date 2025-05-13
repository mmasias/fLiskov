# ¿Qué hacer?

## ¿Por qué? (a.k.a. *Identificar el problema fundamental*)

- El problema con `AguasPutridas` es que fortalece precondiciones al añadir una restricción (aleatoria) sobre navegabilidad.
- El problema con `AguasRapidas` es que relaja postcondiciones al permitir cualquier medio de transporte y velocidades superiores a 1.0.

## ¿Qué?

Se ha violado el principio de sustitucion de Liskov

## ¿Para qué (*hicimos eso*)?

- Si necesitamos aguas que permitan distintos medios de transporte, esto debería ser parte del diseño desde el principio.
- Si necesitamos terrenos con velocidades superiores a 1.0, deberíamos rediseñar la escala de velocidades.

## ¿Cómo (resolverlo)?

- Si necesitamos aguas que permitan distintos medios de transporte, esto debería ser parte del diseño desde el principio.
- Si necesitamos terrenos con velocidades superiores a 1.0, deberíamos rediseñar la escala de velocidades.

### Opciones de diseño alternativas

#### Composición en lugar de herencia

- Podríamos usar un patrón Decorator o Strategy para modificar el comportamiento sin violar la jerarquía.
- Cada terreno tendría una "política de transitabilidad" y una "política de velocidad" inyectadas.

#### Interfaces más granulares

- Separar `Terreno` en interfaces más específicas como `Transitable`, `VelocidadVariable`, etc.
- Implementar solo las interfaces que correspondan al comportamiento deseado.

#### Jerarquía rediseñada

- Crear una jerarquía más plana con clases base más específicas.
- Definir claramente en la documentación y código qué garantiza cada nivel de la jerarquía.

#### Parametrización explícita

- Hacer explícitos los comportamientos variables a través de constructores.
- Esto permitiría aguas rápidas, pero como una configuración conocida, no como una sorpresa.

### ¿Una propuesta?

Se podría abordar mediante una combinación enfoques, abordando una **composición con parametrización explícita**.

En lugar de crear subclases para cada variante, crear una clase flexible `TerrenoConfigurable` que recibe por constructor los parámetros que determinan su comportamiento:

```java
TerrenoConfigurable(
    char simbolo,
    String color,
    boolean transitable,
    double factorVelocidad,
    Set<MedioTransporte> mediosPermitidos
)
```

Y luego tener una fábrica que cree instancias predefinidas:

<div align=center>

|||
|-|-|
`TerrenoFactory.crearAguasNormales()`|`~` azul, solo bote, velocidad 1.0
`TerrenoFactory.crearAguasRapidas()`|`≋` violeta, solo bote, velocidad 1.5
`TerrenoFactory.crearTerreno(TipoTerreno.AGUAS_PUTRIDAS)`|Con probabilidad de navegabilidad

</div>

Esto mantendría la flexibilidad pero haría explícitos todos los comportamientos, evitando sorpresas y violaciones de Liskov.
