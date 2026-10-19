# Defect Recording Log — Program 5

**Alumno:** Alejandro · **Programa:** 5 — Integración por la regla de Simpson (PSP2)

| # | Fecha | Tipo | Inyectado | Removido | Tiempo fix | Descripción |
|---|---|---|---|---|---|---|
| 1 | 2026-10-14 | 10 Documentation | Design | **Design** | 5 | El diseño inicial no definía qué hacer con grados de libertad pares vs. impares en `Gamma`: para dof par, `(dof+1)/2` es medio entero y para dof impar es entero. Detectado en la **revisión de diseño**; se resolvió con un solo método `calcular(z)` que distingue los dos casos con `esEntero(z)`. |
| 2 | 2026-10-14 | 20 Syntax | Code | **Code** | 2 | En `Simpson.integrar` el multiplicador de Simpson estaba al revés (4 en los índices pares y 2 en los impares). Detectado en la **revisión de código**, antes de compilar, al comparar con la fórmula del documento. |
| 3 | 2026-10-14 | 40 Assignment | Code | **Test** | 4 | La prueba `densidadEnCero` esperaba 0.3800 cuando el valor real de la densidad t en 0 con dof = 9 es 0.38803. Defecto en la prueba, no en el código; detectado al correr `mvn test`. |

## Resumen por fase

| Fase | Inyectados | Removidos |
|---|---|---|
| Planning | 0 | 0 |
| Design | 1 | **1** |
| Code | 2 | **1** |
| Compile | 0 | 0 |
| Test | 0 | 1 |
| **Total** | **3** | **3** |

## Observación para el postmortem

Las dos fases nuevas de PSP2 (Design Review y Code Review) atraparon **2 de 3
defectos antes de compilar**. Solo uno llegó a Test, y ese estaba en el código
de prueba, no en el de producción.

| Programa | Proceso | Defectos | Llegaron a Test | % |
|---|---|---|---|---|
| 1 | PSP0.1 | 2 | 1 | 50 % |
| 2 | PSP0.1 | 5 | 4 | 80 % |
| 3 | PSP1 | 1 | 0 | 0 % |
| **5** | **PSP2** | **3** | **1** | **33 %** |
