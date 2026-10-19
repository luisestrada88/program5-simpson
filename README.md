# Programa 5 (PSP2) - Integracion numerica por la regla de Simpson

Calcula la integral de la distribucion t de Student de 0 a x usando la
regla de Simpson, duplicando el numero de segmentos hasta que dos
aproximaciones seguidas difieran menos de 0.00001.

La estructura sigue el **diagrama de clases de la diapositiva 46** de la
presentacion del profesor.

## Clases

| Clase | Responsabilidad |
|---|---|
| `App` | `main(args)`: corre los 3 casos o solo el que se le pase |
| `Logic` | `logic1a()`: duplica segmentos hasta alcanzar la precision |
| `SimpsonIntegration` | un metodo por cada columna de la Tabla 2 |
| `GammaFunction` | `computeIntGamma` y `computeDblGamma` |
| `Output` | `writeData(outFile, outText)` |

`SimpsonIntegration` expone los pasos del diagrama: `computeW`,
`computeXi`, `computeFirstBaseTerms`, `computeExponent`,
`computeCoefficient`, `computeFxi`, `computeFinalTerms` y
`computeFinalValue`.

## Como ejecutarlo

```bash
cd PSP/Program5

mvn test                                   # las 26 pruebas juntas
mvn test -Dtest='A5Test#prueba1TablaUno'   # una sola prueba
mvn verify                                 # pruebas + 100% de cobertura

mvn compile
java -cp target/classes App      # las 3 pruebas
java -cp target/classes App 1    # solo la prueba 1
```

El resultado tambien se escribe en `data/out.txt`.

## Resultados (Tabla 1 del documento 5a)

| Prueba | x | dof | p esperada | p obtenida | segmentos |
|---|---|---|---|---|---|
| 1 | 1.1 | 9 | 0.35006 | 0.35005864 | 20 |
| 2 | 1.1812 | 10 | 0.36757 | 0.36757341 | 20 |
| 3 | 2.750 | 30 | 0.495 | 0.49499986 | 20 |

## Pruebas y cobertura

- 26 pruebas JUnit 5, todas pasan.
- JaCoCo: 100% de instrucciones y 100% de ramas (`mvn verify` falla si
  baja de ahi).
- Reporte HTML: `target/site/jacoco/index.html`

## Tamanio

220 LOC de produccion, 196 LOC de pruebas, 416 LOC en total
(sin comentarios ni lineas en blanco, estandar R2).

## Estado del build

[![Java CI](https://github.com/luisestrada88/program5-simpson/actions/workflows/ci.yml/badge.svg)](https://github.com/luisestrada88/program5-simpson/actions/workflows/ci.yml)

Cada push a `master` o `develop` y cada pull request a `master` ejecuta
`mvn --batch-mode verify` con JDK 21. El build falla si la cobertura baja
del 100 % en instrucciones o ramas.
