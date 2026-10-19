# PROBE Estimating Worksheet — Program 5

**Alumno:** Alejandro · **Programa:** 5 — Integración por la regla de Simpson

## Datos históricos

| Programa | N&C LOC estimado | N&C LOC real | Horas estimadas | Horas reales |
|---|---|---|---|---|
| 1 | — | 116 | 4.0 | 6.0 |
| 2 | — | 276 | 4.0 | 4.5 |
| 3 | — | 370 | 4.0 | 6.0 |

## Método usado

**PROBE 4D (juicio).** No hay suficientes pares (estimado, real) de tamaño
para usar regresión (4A/4B) ni para el promedio (4C): en los programas
anteriores no se registró una estimación de tamaño por separado.

## Estimación de tamaño

| Concepto | Valor |
|---|---|
| Clases nuevas previstas | 4 |
| Clases que se pensaba reusar del P3 | 4 (89 LOC) |
| **N&C estimado** | **280 LOC** |
| **N&C real** | **416 LOC** |
| **Error de estimación** | **+48.6 %** |

> La estimación se hizo antes de localizar el diagrama de clases de la
> diapositiva 46. Al seguir el diagrama se perdió el reuso previsto (89 LOC)
> y `SimpsonIntegration` resultó mucho más grande que el `Simpson` original,
> porque el diagrama pide un método por cada paso del cálculo en lugar de
> uno solo. Ahí está casi todo el error.

## Estimación de tiempo

Productividad To Date (programas 1–3): 777 LOC en 16.5 h = **47.1 LOC/h**.

| Concepto | Valor |
|---|---|
| Tiempo estimado (280 ÷ 47.1) | **6.0 h (360 min)** |
| Tiempo real | **9.0 h (540 min)** |
| **CPI** (estimado / real) | **0.67** |
| Productividad real | 416 ÷ 9.0 = **46.2 LOC/h** |

## Intervalo de predicción (paso 6 del PROBE Estimating Script)

> *"If you did not use the regression method or do not know how to calculate the
> prediction interval, calculate the minimum and maximum development time
> estimate limits from your historical maximum and minimum productivity."*

Como se usó el método 4D (juicio) y no regresión, no aplica el intervalo del
70 % que se calcula con la distribución t. Los límites salen de la
productividad histórica máxima y mínima.

| Programa | LOC | Horas | LOC/hora |
|---|---|---|---|
| 1 | 116 | 6.0 | 19.3 ← **mínima** |
| 2 | 276 | 4.5 | 61.3 |
| 3 | 385 | 6.0 | 64.2 ← **máxima** |

Con el tamaño estimado de **280 LOC N&C**:

| Límite | Cálculo | Tiempo |
|---|---|---|
| Mínimo (productividad máxima) | 280 ÷ 64.2 | **4.4 h** |
| **Estimado** | 280 ÷ 47.1 | **6.0 h** |
| Máximo (productividad mínima) | 280 ÷ 19.3 | **14.5 h** |

**El tiempo real de 9.0 h cayó dentro del intervalo**, aunque arriba del
estimado. El intervalo es muy ancho porque el Programa 1 fue atípico:
19.3 LOC/h contra 61–64 de los otros dos.

**Nota:** este es justamente el uso que el documento 5a describe para la
distribución t — *"we also use the t distribution to calculate the prediction
interval when using PROBE methods A and B"*. Cuando haya datos suficientes
para regresión (4A/4B), el programa que acabas de escribir es el que
calculará ese intervalo.
