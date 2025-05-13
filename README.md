# Mundillo

<div align=center>

![](/images/DdC.svg)

</div>

## xQ?

La implementación de `AguasPutridas` viola el principio de Liskov porque añade (aleatoriamente además) una condición extra que no está en el contrato de la clase.

Esta implementación es grave porque:

- Visualmente se confunde con agua normal (`~`), engañando al usuario que esperaría poder navegar en ella.
- La transitabilidad es aleatoria y determinada internamente, sin posibilidad de ser conocida a través de la interfaz de Agua.
- Fortalece severamente la precondición de puedeSerRecorridoPor(BOTE) al añadir un estado interno (navegable) que no está en el contrato de Agua.
- Un cliente que use polimórficamente objetos Agua esperaría confiadamente que cualquier objeto de tipo agua sea navegable con bote, pero al llegar a estas aguas, podría fallar inesperadamente.

Esta violación es especialmente peligrosa porque:

- Es sutil e imposible de detectar visualmente
- "Parece" funcionar a veces (cuando navegable es true)
- Rompe la confianza en el comportamiento polimórfico de Agua
- Introduce un estado interno impredecible que afecta el comportamiento público
