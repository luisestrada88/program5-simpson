# PSP2 Project Plan Summary — Program 5

**Alumno:** Alejandro · **Fecha:** 2026-10-14 · **Programa:** 5 — Integración por la regla de Simpson
**Instructor:** ______ · **Lenguaje:** Java

## Resumen

| Concepto | Plan | Actual | To Date |
|---|---|---|---|
| LOC/hora | 47.1 | 63.0 | 51.1 |

*To Date acumula los programas 1, 2, 3 y 5: 1,155 LOC en 22.5 horas.*

## Tamaño del programa (LOC)

| Concepto | Plan | Actual | To Date |
|---|---|---|---|
| Base (B) | 89 | 89 | 89 |
| Deleted (D) | 0 | 0 | 0 |
| Modified (M) | 0 | 0 | 41 |
| Added (A) | 280 | 289 | 974 |
| Reused (R) | 89 | 89 | 117 |
| New & Changed (N = A + M) | 280 | 289 | 1,015 |
| **Total LOC (T)** | **369** | **378** | **1,155** |
| New Reusable | 74 | 74 | 123 |

Detalle en `size_estimating_template.md`. Estimación por **PROBE 4D**
(juicio), justificada en `probe_worksheet.md`. Error de estimación: **+3.2 %**.

## Tiempo en fase (minutos)

| Fase | Plan | Actual | To Date | To Date % |
|---|---|---|---|---|
| Planning | 58 | 60 | 220 | 16.3 |
| Design | 35 | 40 | 135 | 10.0 |
| Design Review | 0 | **20** | **20** | 1.5 |
| Code | 104 | 70 | 355 | 26.3 |
| Code Review | 0 | **25** | **25** | 1.9 |
| Compile | 53 | 20 | 165 | 12.2 |
| Test | 71 | 75 | 270 | 20.0 |
| Postmortem | 39 | 50 | 160 | 11.8 |
| **Total** | **360** | **360** | **1,350** | **100** |

> La columna **Plan** aplica el *To Date %* del Programa 3 a la estimación
> global de 6.0 h obtenida con PROBE.

| Indicador | Valor |
|---|---|
| Tiempo estimado | 6.0 h (360 min) |
| Tiempo real | 6.0 h (360 min) |
| **CPI** (estimado / real) | **1.00** |

## Defectos inyectados

| Fase | Plan | Actual | To Date | To Date % |
|---|---|---|---|---|
| Planning | 0 | 0 | 0 | 0 |
| Design | 0 | **1** | 2 | 18.2 |
| Code | 3 | **2** | 9 | 81.8 |
| Compile | 0 | 0 | 0 | 0 |
| Test | 0 | 0 | 0 | 0 |
| **Total** | **3** | **3** | **11** | **100** |

## Defectos removidos

| Fase | Plan | Actual | To Date | To Date % |
|---|---|---|---|---|
| Planning | 0 | 0 | 0 | 0 |
| Design Review | 1 | **1** | 1 | 10.0 |
| Code Review | 1 | **1** | 1 | 10.0 |
| Compile | 0 | 0 | 1 | 10.0 |
| Test | 1 | **1** | 6 | 60.0 |
| Code | 0 | 0 | 1 | 10.0 |
| **Total** | **3** | **3** | **10** | **100** |

> Primer programa con las fases **Design Review** y **Code Review** de PSP2.
> Atraparon 2 de 3 defectos antes de compilar.
