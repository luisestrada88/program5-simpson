# Size Estimating Template — Program 5

**Alumno:** Alejandro · **Programa:** 5 — Integración por la regla de Simpson

Estándar de conteo: **R2** — una línea lógica por renglón, sin comentarios
ni líneas en blanco.

## Partes

| Parte | Tipo | LOC | Clasificación |
|---|---|---|---|
| `App.java` | nueva | 37 | Added |
| `Logic.java` | nueva | 47 | Added |
| `SimpsonIntegration.java` | nueva | 95 | Added |
| `GammaFunction.java` | nueva | 29 | Added |
| `Output.java` | nueva | 12 | Added |
| `A5Test.java` | nueva | 196 | Added |

## Resumen

| Concepto | LOC |
|---|---|
| Base (B) | 0 |
| Deleted (D) | 0 |
| Modified (M) | 0 |
| Added (A) | 416 |
| Reused (R) | 0 |
| New & Changed (N = A + M) | 416 |
| **Total (T)** | **416** |
| New Reusable | 124 (`GammaFunction`, `SimpsonIntegration`) |

Producción: 220 LOC · Pruebas: 196 LOC.

> **Nota sobre el reuso.** La estimación original contemplaba reusar 89 LOC
> del Programa 3 (`Nodo`, `ListaEnlazada`, `ReadFile`, `OutFile`). Al
> adoptar el diagrama de clases de la diapositiva 46 ese reuso desapareció:
> el diagrama no incluye lista enlazada ni clase de entrada. Todo el código
> de esta versión es nuevo.

## Reuso

| Concepto | Valor |
|---|---|
| LOC reusadas | **0** — el diagrama de clases eliminó el reuso previsto |
| LOC totales | 416 |
| **% de reuso** | **0 %** |
| LOC nuevas reusables | 124 (`GammaFunction`, `SimpsonIntegration`) |
| **% nuevo reusable** | **29.8 %** |

Comparación con los programas anteriores: el 3a reusó 15 LOC y el 5a ninguna.
El reuso previsto de 89 LOC se perdió al adoptar el diagrama.
