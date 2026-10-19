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
| Clases nuevas | 4 (`Gamma`, `DistribucionT`, `Simpson`, `Main`) |
| Clases reusadas del P3 | 4 (89 LOC) |
| Clase de pruebas | 1 |
| **N&C estimado** | **280 LOC** |
| **N&C real** | **289 LOC** |
| Error de estimación | +3.2 % |

## Estimación de tiempo

Productividad To Date (programas 1–3): 777 LOC en 16.5 h = **47.1 LOC/h**.

| Concepto | Valor |
|---|---|
| Tiempo estimado (280 ÷ 47.1) | **6.0 h (360 min)** |
| Tiempo real | ver `time_log.md` |
