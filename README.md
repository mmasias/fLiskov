# Mundillo

<div align=center>

![](/images/DdC.svg)

</div>

## xQ?

### AguasPutridas

La implementación de `AguasPutridas` viola el principio de Liskov porque añade (aleatoriamente además) una condición extra que no está en el contrato de la clase.

Esta implementación es grave porque:

- Visualmente se confunde con agua normal (`~`), engañando al usuario que esperaría poder navegar en ella.
- La transitabilidad es aleatoria y determinada internamente, sin posibilidad de ser conocida a través de la interfaz de Agua.
- Fortalece severamente la precondición de puedeSerRecorridoPor(BOTE) al añadir un estado interno (navegable) que no está en el contrato de Agua.
- No existe ningún método en la interfaz pública que permita consultar si un agua es navegable o no, pues esto no debería ser necesario según el contrato de Agua.
- Un cliente que use polimórficamente objetos Agua esperaría confiadamente que cualquier objeto de tipo agua sea navegable con bote, pero al llegar a estas aguas, podría fallar inesperadamente.

Esta violación es especialmente peligrosa porque:

- Es sutil e imposible de detectar visualmente
- "Parece" funcionar a veces (cuando navegable es true)
- Rompe la confianza en el comportamiento polimórfico de Agua
- Introduce un estado interno impredecible que afecta el comportamiento público

### AguasRapidas

La implementación de aguas rápidas viola el principio de Liskov por relajación de postcondiciones de dos maneras:

|Relajación de la postcondición de `puedeSerRecorridoPor()`|Relajación de la postcondición de `obtenerFactorVelocidad()`|
|-|-|
|La clase base `Agua` garantiza que el método solo devuelve `true` para `BOTE` y `false` para cualquier otro medio.|La clase base `Agua` garantiza que devuelve valores entre 0.0 y 1.0.|
|`AguasRapidas` debilita esta garantía al devolver `true` para cualquier medio de transporte.|`AguasRapidas` debilita esta garantía al devolver 1.5.|
|El código cliente que asuma que "en agua solo puedo usar bote" podría comportarse incorrectamente.|El código cliente que se base en la suposición de que ningún terreno será más rápido que 1.0 (velocidad base) podría calcular incorrectamente tiempos o animaciones.|

Estos tipos de violación son especialmente problemáticos porque:

- No *fallan* inmediatamente sino que producen comportamientos inesperados y a veces difíciles de rastrear.
- Pueden pasar desapercibidos durante mucho tiempo hasta que algún componente falle al encontrar valores fuera de rango.
- Rompen suposiciones fundamentales sobre las que el sistema puede estar construido (como "solo puedo moverme en agua con bote").

## *2Think*

Esta estructura es especialmente problemática porque:

- Cualquier código que asuma que todos los tipos de agua solo son transitables en bote fallará con AguasRapidas.
- Los algoritmos de movimiento del jugador que asuman un factor de velocidad máximo de 1.0 podrían comportarse incorrectamente.
- AguasRapidas podría pasar desapercibida en revisiones de código si solo se verifica la compatibilidad con la clase inmediatamente superior (AguasNormales).
- Al heredar de AguasNormales en lugar de directamente de Agua, el cambio de comportamiento parece más inocente pero es igualmente peligroso.

Esta violación muestra claramente por qué el Principio de Sustitución de Liskov debe considerarse a lo largo de toda la cadena de herencia, no solo en la relación de una clase con su padre inmediato.
