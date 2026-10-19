# Process Improvement Proposal (PIP) — Program 5

**Alumno:** Alejandro · **Programa:** 5 — Integración por la regla de Simpson (PSP2)

## Qué funcionó

| # | Observación |
|---|---|
| 1 | Las fases nuevas de PSP2 (**Design Review** y **Code Review**) atraparon 2 defectos antes de compilar. 45 minutos de revisión evitaron dos ciclos de compila–prueba–corrige. |
| 2 | Verificar el algoritmo contra la **Tabla 2** del documento —columna por columna, no solo el resultado final— hizo que el refactor completo del programa no rompiera ni un valor. Esa verificación es lo que convirtió un rediseño en algo seguro. |
| 3 | Tener el `mvn verify` con el check de JaCoCo en 1.00 significó que, al reescribir las clases, el 100 % de cobertura no se perdió sin avisar: el build habría fallado. |

## Qué mejorar

| # | Problema | Propuesta |
|---|---|---|
| 1 | **El defecto más caro del programa (#4): el diseño no seguía el diagrama de clases del profesor.** El `5a.pdf` del SEI no trae diagrama; el diagrama estaba en la diapositiva 46 de la presentación, que solo se había revisado en la sección de GitHub. Costó rediseñar y reescribir las 5 clases y las 26 pruebas. | Antes de diseñar, **inventariar todas las fuentes de requisitos** —PDF del SEI, presentación completa, mensajes del profesor— y listarlas por escrito. Agregado al Design Review Checklist como puntos 1b y 1c. |
| 2 | El único defecto que llegó a Test estaba en el **código de prueba** (un valor esperado mal calculado), no en el de producción. El checklist de código no cubría las pruebas. | Agregado al Code Review Checklist el punto 11: *"¿cada valor esperado se calculó de forma independiente al código?"* |
| 3 | El tamaño se estimó mal: **280 LOC estimadas contra 416 reales (+48.6 %)**. Dos causas: se contaba con reusar 89 LOC del Programa 3, reuso que el diagrama eliminó; y `SimpsonIntegration` quedó mucho más grande que un `Simpson` monolítico, porque el diagrama pide un método por paso del cálculo. | No dar por hecho el reuso hasta confirmar el diseño. Y al estimar a partir de un diagrama, contar **por método**, no por clase. |
| 4 | El tiempo también se estimó mal: 6.0 h contra 9.0 h reales, **CPI 0.67**. La estimación usó la productividad histórica a secas (47.1 LOC/h), pero los programas 2 y 3 eran repetitivos; este tenía matemáticas nuevas y una fase de CI/CD inédita. | Para el Programa 6, partir el estimado en dos ritmos: ~60 LOC/h para código parecido a lo ya hecho y ~30 LOC/h para algoritmos nuevos, y sumar aparte el tiempo de infraestructura. |
| 5 | La fase de Test siguió siendo la más larga (100 min), casi toda en llegar al 100 % de cobertura al final. | Escribir la prueba junto con cada método, no todas al final. |

## Métricas acumuladas

| Programa | Proceso | CPI | LOC | LOC/h | Defectos | % a Test o después |
|---|---|---|---|---|---|---|
| 1 | PSP0.1 | 0.67 | 116 | 19.3 | 2 | 50 % |
| 2 | PSP0.1 | 0.89 | 276 | 61.3 | 5 | 80 % |
| 3 | PSP1 | 0.67 | 385 | 64.2 | 1 | 0 % |
| **5** | **PSP2** | **0.67** | **416** | **46.2** | **4** | **50 %** |

> El 50 % del Programa 5 son 2 de 4 defectos: uno en Test (valor de prueba) y
> uno en Postmortem (el diagrama). La lección no es que el proceso falló, sino
> **dónde** falló: en la entrada al proceso, no en la ejecución. Un checklist
> de diseño no puede encontrar un requisito que nunca se leyó.
