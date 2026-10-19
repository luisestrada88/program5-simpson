# Decisiones de diseno - Programa 5

## El diagrama de clases manda

La estructura del programa es la del **diagrama de la diapositiva 46**:
`App`, `Logic`, `SimpsonIntegration`, `GammaFunction` y `Output`, con los
nombres de metodos y atributos que ahi aparecen.

Una primera version se escribio antes de localizar ese diagrama, con otra
estructura (Main, Gamma, DistribucionT, Simpson, mas una lista enlazada
reusada del Programa 3). Calculaba bien, pero se descarto por no
corresponder al diseno pedido. Se conserva en `_version_anterior/`.

## Decisiones puntuales

1. **`Output` en lugar de `output`.** El diagrama muestra la clase con
   minuscula inicial, porque fue generado por ingenieria inversa desde el
   codigo original. Se escribe `Output` para cumplir el estandar de
   codificacion de Oracle, que tambien pide el profesor y que exige
   mayuscula inicial en los nombres de clase. Es la unica desviacion
   respecto al diagrama.

2. **Un metodo por columna de la Tabla 2.** `computeFirstBaseTerms`,
   `computeFxi` y `computeFinalTerms` devuelven arreglos que corresponden
   exactamente a las columnas del ejemplo del documento, para poder
   comparar valor por valor.

3. **`computeGamma` como metodo auxiliar.** El diagrama define
   `computeIntGamma` y `computeDblGamma` por separado, pero no dice quien
   decide cual usar. Se agrego `computeGamma(value)` que revisa si el
   valor es entero y delega. Los dos metodos del diagrama siguen
   existiendo y son publicos.

4. **Getters.** El diagrama no los lista, pero `logic1a()` devuelve
   `void`, asi que se agregaron accesores para poder probar el resultado
   desde JUnit.

5. **Sin lectura de archivo.** El diagrama no incluye una clase de
   entrada: los tres casos de la Tabla 1 son constantes en `App`. La
   salida si se escribe, con `Output.writeData`, como indica el diagrama.

6. **Segmentos iniciales = 10 y se duplican.** Tal como lo pide el
   documento: se repite hasta que la diferencia entre dos corridas sea
   menor que 0.00001. Con 20 segmentos se alcanza en los tres casos.

7. **`Locale.US` en los printf.** Defecto ya conocido del Programa 1: en
   una Mac en espanol `%.4f` imprime coma decimal.
