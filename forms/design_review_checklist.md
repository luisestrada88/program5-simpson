# Design Review Checklist — Program 5 (PSP2)

**Alumno:** Alejandro · **Fecha:** 2026-10-14 · **Programa:** 5 — Integración por la regla de Simpson

> Revisión del diseño **antes** de escribir el código. PSP2 agrega esta fase.

| # | Punto a revisar | Resultado | Nota |
|---|---|---|---|
| 1 | **Completo** — ¿el diseño cubre todos los requisitos del `5a.pdf`? | ✅ | Gamma, densidad t, Simpson con duplicación de segmentos, lectura de archivo, reporte |
| 2 | **Funciones** — ¿cada clase tiene una sola responsabilidad? | ✅ | `Gamma` / `DistribucionT` / `Simpson` / `Main` separadas |
| 3 | **Lógica** — ¿la condición de paro es la que pide el documento? | ✅ | `|actual − anterior| < 0.00001` |
| 4 | **Casos especiales** — ¿segmentos pares? ¿x = 0? | ✅ | Segmentos inician en 10 y se duplican, siempre pares |
| 5 | **Nombres** — ¿siguen el estándar Oracle? | ✅ | Clases en PascalCase, métodos y variables en camelCase |
| 6 | **Reuso** — ¿se reusa lo que ya existe? | ✅ | `Nodo`, `ListaEnlazada`, `ReadFile`, `OutFile` del Programa 3 |
| 7 | **Pruebas** — ¿hay una prueba por cada caso de la Tabla 1? | ✅ | 3 pruebas de Tabla 1 + 24 de cobertura |
| 8 | **Interfaz** — ¿se puede correr una prueba a la vez? | ✅ | `Main` acepta el número de prueba como parámetro |

**Defectos encontrados en la revisión de diseño:** 1 (ver `defect_log.md` #1)
