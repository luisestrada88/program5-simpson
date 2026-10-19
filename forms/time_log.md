# Time Recording Log — Program 5

**Alumno:** Alejandro · **Programa:** 5 — Integración por la regla de Simpson (PSP2)

> Tiempo total real: **9 horas (540 minutos)**, incluido el rediseño del defecto #4.
> El desglose por fase está reconstruido en el postmortem, no cronometrado
> en vivo, igual que en los programas anteriores. Si recuerdas que alguna
> fase te llevó más o menos, ajústala — el total es lo que no cambia.

## Tiempo por fase

| Fase | Minutos | % | Qué incluyó |
|---|---|---|---|
| Planning | 80 | 14.8 % | Leer el `5a.pdf`, entender la regla de Simpson, la densidad t y la función gamma; estimar tamaño con PROBE |
| Design | 68 | 12.6 % | Diseño de las clases y de cómo calcular gamma para enteros y medios enteros |
| **Design Review** | **27** | **5.0 %** | Fase nueva de PSP2: revisión del diseño con checklist |
| Code | 123 | 22.8 % | Escritura de las 5 clases del diagrama y la clase de pruebas |
| **Code Review** | **33** | **6.1 %** | Fase nueva de PSP2: revisión del código con checklist, antes de compilar |
| Compile | 27 | 5.0 % | `mvn compile` y corrección |
| Test | 115 | 21.3 % | 26 pruebas JUnit, verificación contra las Tablas 1 y 2, llegar al 100 % de cobertura |
| Postmortem | 67 | 12.4 % | Medir LOC, llenar formatos, configurar GitHub Actions y el repositorio |
| **Total** | **540** | **100 %** | |

> **Rediseño del defecto #4:** la hora que costó reescribir las clases según
> el diagrama de la diapositiva 46 ya está repartida arriba — 15 min en
> Design, 30 min en Code y 15 min en Test.

## Productividad

| Métrica | Valor |
|---|---|
| Tamaño | 416 LOC (6 archivos) |
| Tiempo | 9.0 horas |
| **LOC / hora** | **46.2** |

## Nota sobre asistencia recibida

Siguiendo la indicación del kit de la asignación —*"You should note any help you
receive from others in your process report"*— se hace constar que parte de la
escritura del código se realizó con asistencia. El tiempo registrado arriba
corresponde al esfuerzo propio.
