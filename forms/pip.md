# Process Improvement Proposal (PIP) — Program 5

**Alumno:** Alejandro · **Programa:** 5 — Integración por la regla de Simpson (PSP2)

## Qué funcionó

| # | Observación |
|---|---|
| 1 | Las fases nuevas de PSP2 (**Design Review** y **Code Review**) atraparon 2 de los 3 defectos antes de compilar. 45 minutos de revisión evitaron dos ciclos de compila–prueba–corrige. |
| 2 | **PROBE 4D** dio un error de estimación de tamaño de solo **+3.2 %** (280 estimados vs. 289 reales). Estimar el tamaño antes del tiempo sí funcionó para el tamaño. |
| 3 | Reusar `Nodo`, `ListaEnlazada`, `ReadFile` y `OutFile` del Programa 3 ahorró 89 LOC y bajó la fase de Code de 104 min planeados a 93 reales. |
| 4 | Verificar el algoritmo contra la Tabla 1 **antes** de pulir el código evitó depurar y rediseñar al mismo tiempo. |

## Qué mejorar

| # | Problema | Propuesta |
|---|---|---|
| 1 | El único defecto que llegó a Test estaba en el **código de prueba** (un valor esperado mal calculado), no en el de producción. El checklist de revisión de código no cubre las pruebas. | Agregar al Code Review Checklist un punto: *"¿cada valor esperado de la prueba fue calculado de forma independiente al código?"* |
| 2 | La fase de Test siguió siendo la más larga (75 min), casi toda en llegar al 100 % de cobertura al final. | Escribir la prueba junto con cada método, no todas al final. Así la cobertura sale cerca del 100 % sin una pasada extra. |
| 3 | No había registro histórico de tamaños **estimados**, así que no se pudo usar PROBE 4A/4B (regresión). | A partir de este programa, anotar siempre el tamaño estimado en el `size_estimating_template.md` antes de codificar, para poder usar regresión en el Programa 6. |
| 4 | El tamaño se estimó bien (+3.2 %) pero el **tiempo no**: 6.0 h estimadas contra 8.0 h reales, **CPI 0.75**. La productividad real fue de 47.3 LOC/h, no los 63 que daban los programas 2 y 3 — esos dos fueron más repetitivos; este tuvo matemáticas nuevas (gamma, densidad t) y una fase de CI/CD que no existía antes. | No usar la productividad histórica a secas. Para el Programa 6, partir el estimado en dos: LOC parecidas a lo ya hecho (usar 60 LOC/h) y LOC con algoritmo nuevo (usar 30 LOC/h), y sumar aparte el tiempo de infraestructura (repositorio, workflow). |

## Métricas acumuladas

| Programa | Proceso | CPI | LOC | LOC/h | Defectos | % a Test |
|---|---|---|---|---|---|---|
| 1 | PSP0.1 | 0.67 | 116 | 19.3 | 2 | 50 % |
| 2 | PSP0.1 | 0.89 | 276 | 61.3 | 5 | 80 % |
| 3 | PSP1 | 0.67 | 385 | 64.2 | 1 | 0 % |
| **5** | **PSP2** | **0.75** | **378** | **47.3** | **3** | **33 %** |
