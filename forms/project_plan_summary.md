# PSP2 Project Plan Summary — Program 5

**Alumno:** Alejandro · **Fecha:** 2026-10-14 · **Programa:** 5 — Integración por la regla de Simpson
**Instructor:** ______ · **Lenguaje:** Java

## Resumen

| Concepto | Plan | Actual | To Date |
|---|---|---|---|
| LOC/hora | 47.1 | 46.2 | 46.8 |

*To Date acumula los programas 1, 2, 3 y 5: 1,193 LOC en 25.5 horas.*

## Tamaño del programa (LOC)

| Concepto | Plan | Actual | To Date |
|---|---|---|---|
| Base (B) | 89 | 0 | 0 |
| Deleted (D) | 0 | 0 | 0 |
| Modified (M) | 0 | 0 | 41 |
| Added (A) | 280 | 416 | 1,101 |
| Reused (R) | 89 | 0 | 28 |
| New & Changed (N = A + M) | 280 | 416 | 1,142 |
| **Total LOC (T)** | **369** | **416** | **1,193** |
| New Reusable | 74 | 124 | 173 |

Detalle en `size_estimating_template.md`. Estimación por **PROBE 4D**
(juicio), justificada en `probe_worksheet.md`. Error de estimación: **+48.6 %**.
El reuso planeado de 89 LOC del Programa 3 no se materializó: al adoptar el
diagrama de clases de la diapositiva 46, todo el código resultó nuevo.

## Tiempo en fase (minutos)

| Fase | Plan | Actual | To Date | To Date % |
|---|---|---|---|---|
| Planning | 58 | 80 | 240 | 15.7 |
| Design | 35 | 68 | 163 | 10.7 |
| Design Review | 0 | **27** | **27** | 1.8 |
| Code | 104 | 123 | 408 | 26.7 |
| Code Review | 0 | **33** | **33** | 2.1 |
| Compile | 53 | 27 | 172 | 11.2 |
| Test | 71 | 115 | 310 | 20.3 |
| Postmortem | 39 | 67 | 177 | 11.5 |
| **Total** | **360** | **540** | **1,530** | **100** |

> La columna **Plan** aplica el *To Date %* del Programa 3 a la estimación
> global de 6.0 h obtenida con PROBE.

| Indicador | Valor |
|---|---|
| Tiempo estimado | 6.0 h (360 min) |
| Tiempo real | 9.0 h (540 min) |
| **CPI** (estimado / real) | **0.67** |

## Defectos inyectados

| Fase | Plan | Actual | To Date | To Date % |
|---|---|---|---|---|
| Planning | 0 | 0 | 0 | 0 |
| Design | 0 | **2** | 3 | 25.0 |
| Code | 3 | **2** | 9 | 75.0 |
| Compile | 0 | 0 | 0 | 0 |
| Test | 0 | 0 | 0 | 0 |
| **Total** | **3** | **4** | **12** | **100** |

## Defectos removidos

| Fase | Plan | Actual | To Date | To Date % |
|---|---|---|---|---|
| Planning | 0 | 0 | 0 | 0 |
| Design Review | 1 | **1** | 1 | 9.1 |
| Code Review | 1 | **1** | 1 | 9.1 |
| Compile | 0 | 0 | 1 | 9.1 |
| Test | 1 | **1** | 6 | 54.5 |
| Code | 0 | 0 | 1 | 9.1 |
| Postmortem | 0 | **1** | 1 | 9.1 |
| **Total** | **3** | **4** | **11** | **100** |

> Primer programa con las fases **Design Review** y **Code Review** de PSP2.
> Atraparon 2 de 4 defectos antes de compilar. El cuarto —el diseño no seguía
> el diagrama de clases del profesor— se detectó hasta el postmortem, al
> revisar la presentación completa contra el código.
