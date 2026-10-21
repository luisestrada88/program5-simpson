# Design Review Checklist — Program 5 (PSP2)

**Alumno:** Alejandro · **Fecha:** 2026-10-14 · **Programa:** 5 — Integración por la regla de Simpson

> Revisión del diseño **antes** de escribir el código. PSP2 agrega esta fase.

| # | Punto a revisar | Resultado | Nota |
|---|---|---|---|
| 1 | **Completo** — ¿el diseño cubre todos los requisitos del `5a.pdf`? | ✅ | Gamma, densidad t, Simpson con duplicación de segmentos, reporte |
| 1b | **¿Se revisaron TODAS las fuentes de requisitos?** (PDF del SEI **y** presentación del profesor) | ❌ → ✅ | **Punto agregado tras el defecto #4.** En la primera pasada solo se revisó el PDF; el diagrama de clases estaba en la diapositiva 46 |
| 1c | **¿El diseño corresponde al diagrama de clases dado?** | ✅ | `App`, `Logic`, `SimpsonIntegration`, `GammaFunction`, `Output` |
| 2 | **Funciones** — ¿cada clase tiene una sola responsabilidad? | ✅ | Las 5 clases del diagrama |
| 3 | **Lógica** — ¿la condición de paro es la que pide el documento? | ✅ | `|actual − anterior| < 0.00001` |
| 4 | **Casos especiales** — ¿segmentos pares? ¿x = 0? | ✅ | Segmentos inician en 10 y se duplican, siempre pares |
| 5 | **Nombres** — ¿siguen el estándar Oracle? | ✅ | Clases en PascalCase, métodos y variables en camelCase |
| 6 | **Reuso** — ¿se reusa lo que ya existe? | ❌ | El diagrama no incluye lista enlazada ni clase de entrada; no hay reuso posible del Programa 3 |
| 7 | **Pruebas** — ¿hay una prueba por cada caso de la Tabla 1 y por cada columna de la Tabla 2? | ✅ | 3 de Tabla 1, 8 de Tabla 2, 15 de cobertura |
| 8 | **Interfaz** — ¿se puede correr una prueba a la vez? | ✅ | `App` acepta el número de prueba como parámetro |

**Defectos encontrados en la revisión de diseño:** 1 (ver `defect_log.md` #1)

> El defecto #4 **no** lo encontró esta revisión. El punto 1 preguntaba por el
> `5a.pdf` y la respuesta era correcta; el diagrama estaba en la presentación.
> Por eso se agregaron los puntos 1b y 1c, que es la mejora #1 del PIP.
