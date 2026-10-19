# Programa 5 (PSP2) - Integracion numerica por la regla de Simpson

Calcula la integral de la distribucion t de Student de 0 a x usando la
regla de Simpson, duplicando el numero de segmentos hasta que dos
aproximaciones seguidas difieran menos de 0.00001.

## Clases

| Clase | Que hace | Origen |
|---|---|---|
| `Gamma` | funcion gamma para enteros y medios enteros | nueva |
| `DistribucionT` | densidad de la distribucion t | nueva |
| `Simpson` | regla de Simpson y control del error | nueva |
| `Main` | ejecuta una prueba o las tres | nueva |
| `Nodo` | par de valores de la lista | reusada del P3 |
| `ListaEnlazada` | lista enlazada simple | reusada del P3 |
| `ReadFile` | lee `data/in.txt` | reusada del P3 |
| `OutFile` | escribe `data/out.txt` | reusada del P3 |

## Como ejecutarlo

```bash
cd PSP/Program5

mvn test                          # todas las pruebas juntas
mvn test -Dtest='A5Test#prueba1TablaUno'   # una sola prueba
mvn verify                        # pruebas + 100% de cobertura
mvn compile exec:java 2>/dev/null || java -cp target/classes Main 1
```

`java -cp target/classes Main` sin parametro corre las tres pruebas;
con `1`, `2` o `3` corre solo esa.

## Resultados (Tabla 1 del documento 5a)

| Prueba | x | dof | p esperada | p obtenida | segmentos |
|---|---|---|---|---|---|
| 1 | 1.1 | 9 | 0.35006 | 0.35005864 | 20 |
| 2 | 1.1812 | 10 | 0.36757 | 0.36757341 | 20 |
| 3 | 2.750 | 30 | 0.495 | 0.49499986 | 20 |

## Pruebas y cobertura

- 27 pruebas JUnit 5, todas pasan.
- JaCoCo: 100% de instrucciones y 100% de ramas (`mvn verify` pasa el
  check configurado en 1.00).
- Reporte HTML: `target/site/jacoco/index.html`

## Tamanio

208 LOC de produccion, 170 LOC de pruebas, 378 LOC en total
(sin comentarios ni lineas en blanco, estandar R2).

## CI/CD

`.github/workflows/ci.yml` corre `mvn --batch-mode verify` con JDK 21
en cada push a `master`/`develop` y en cada pull request a `master`, y
sube el reporte de JaCoCo como artefacto.
