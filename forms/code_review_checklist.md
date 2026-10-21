# Code Review Checklist — Program 5 (PSP2)

**Alumno:** Alejandro · **Fecha:** 2026-10-14 · **Programa:** 5 — Integración por la regla de Simpson

> Revisión del código **antes** de compilar. PSP2 agrega esta fase.

| # | Punto a revisar | Resultado | Nota |
|---|---|---|---|
| 1 | **Completo** — ¿el código implementa todo el diseño? | ✅ | 8 clases |
| 2 | **Includes / imports** — ¿están todos y sin sobrantes? | ✅ | Revisado clase por clase |
| 3 | **Inicialización** — ¿toda variable se inicializa antes de usarse? | ✅ | |
| 4 | **Llamadas** — ¿parámetros en el orden correcto? | ✅ | `computeW(numSeg, x)`, `computeFirstBaseTerms(numSeg, totXi, dof)` |
| 5 | **Nombres** — ¿coinciden con el diagrama y con el estándar de Oracle? | ✅ | Única desviación: `Output` con mayúscula, justificada en `decisiones_diseno.md` |
| 6 | **Strings** — ¿comillas y formato correctos? | ✅ | `Locale.US` en todos los `printf` |
| 7 | **Punto y coma / llaves** — ¿balanceadas? | ✅ | Compila sin errores |
| 8 | **Formato** — ¿≤ 80 columnas, indentación de 4 espacios? | ✅ | Verificado con `awk 'length > 80'` |
| 9 | **Javadoc** — ¿toda clase y método público documentado? | ✅ | |
| 10 | **Ciclos** — ¿terminan? ¿índices correctos? | ✅ | Defecto #2 encontrado aquí |

| 11 | **¿Cada valor esperado de la prueba se calculó aparte del código?** | ✅ | **Punto agregado tras el PIP del P5.** Los valores salen de la Tabla 2 del documento, no del programa |

**Defectos encontrados en la revisión de código:** 1 (ver `defect_log.md` #2)
