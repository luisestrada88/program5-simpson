# Process Improvement Proposal (PIP) — Program 5

**Alumno:** Alejandro · **Programa:** 5 — Integración por la regla de Simpson (PSP2)

## Qué funcionó

| # | Observación |
|---|---|
| 1 | Las fases nuevas de PSP2 (**Design Review** y **Code Review**) atraparon 2 de los 3 defectos antes de compilar. 45 minutos de revisión evitaron dos ciclos de compila–prueba–corrige. |
| 2 | **PROBE 4D** dio un error de estimación de solo **+3.2 %** (280 estimados vs. 289 reales) y un **CPI de 1.00**, contra 0.67 en los programas 1 y 3. Estimar el tamaño antes del tiempo sí mejora la estimación. |
| 3 | Reusar `Nodo`, `ListaEnlazada`, `ReadFile` y `OutFile` del Programa 3 ahorró 89 LOC y bajó la fase de Code de 104 min planeados a 70 reales. |
| 4 | Verificar el algoritmo contra la Tabla 1 **antes** de pulir el código evitó depurar y rediseñar al mismo tiempo. |

## Qué mejorar

| # | Problema | Propuesta |
|---|---|---|
| 1 | El único defecto que llegó a Test estaba en el **código de prueba** (un valor esperado mal calculado), no en el de producción. El checklist de revisión de código no cubre las pruebas. | Agregar al Code Review Checklist un punto: *"¿cada valor esperado de la prueba fue calculado de forma independiente al código?"* |
| 2 | La fase de Test siguió siendo la más larga (75 min), casi toda en llegar al 100 % de cobertura al final. | Escribir la prueba junto con cada método, no todas al final. Así la cobertura sale cerca del 100 % sin una pasada extra. |
| 3 | No había registro histórico de tamaños **estimados**, así que no se pudo usar PROBE 4A/4B (regresión). | A partir de este programa, anotar siempre el tamaño estimado en el `size_estimating_template.md` antes de codificar, para poder usar regresión en el Programa 6. |

## Métricas acumuladas

| Programa | Proceso | CPI | LOC | LOC/h | Defectos | % a Test |
|---|---|---|---|---|---|---|
| 1 | PSP0.1 | 0.67 | 116 | 19.3 | 2 | 50 % |
| 2 | PSP0.1 | 0.89 | 276 | 61.3 | 5 | 80 % |
| 3 | PSP1 | 0.67 | 385 | 64.2 | 1 | 0 % |
| **5** | **PSP2** | **1.00** | **378** | **63.0** | **3** | **33 %** |
