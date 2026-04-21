# Mundillo — `propuesta002-ampliada`

El diseño de `propuesta002` afirma respetar OCP: se pueden añadir nuevos terrenos sin modificar el código existente. Esta rama lo pone a prueba.

Se añaden `Lava` y `Pantano` a través de `RegistroTerrenosExtendido`, sin tocar `RegistroTerrenos`, `TerrenosEstandar` ni ningún fichero anterior.

[Propuesta002.md](Propuesta002.md)

## *#2Think*

- ¿Qué ficheros han cambiado en esta rama respecto a `propuesta002`? ¿Alguno de los existentes?
- ¿Por qué `queHacer.md` propone exactamente lo que implementa `propuesta001`... y aun así `propuesta001` es insuficiente?
- ¿Podría `RegistroTerrenos` violar LSP? ¿Bajo qué condiciones?