# Test Report — Program 5

**Alumno:** Alejandro · **Programa:** 5 — Integración por la regla de Simpson

## Pruebas de la Tabla 1 del documento 5a

| Prueba | x | dof | p esperada | p obtenida | Segmentos | Resultado |
|---|---|---|---|---|---|---|
| 1 | 1.1 | 9 | 0.35006 | 0.35005864 | 20 | ✅ |
| 2 | 1.1812 | 10 | 0.36757 | 0.36757341 | 20 | ✅ |
| 3 | 2.750 | 30 | 0.495 | 0.49499986 | 20 | ✅ |

## Verificación contra la Tabla 2 (ejemplo del documento)

El documento trae el detalle del cálculo para x = 1.1 con dof = 9 y
num_seg = 10. Cada columna de esa tabla se comprueba con una prueba
distinta, porque cada columna corresponde a un método del diagrama.

| Columna de la Tabla 2 | Método | Valor del documento | Obtenido |
|---|---|---|---|
| W | `computeW` | 0.11 | 0.11 ✅ |
| x(i) | `computeXi` | 0 … 1.1 | ✅ |
| 1 + x(i)²/dof | `computeFirstBaseTerms` | 1.13444 en i=10 | ✅ |
| exponente | `computeExponent` | −5 | −5 ✅ |
| coeficiente | `computeCoefficient` | 0.38803 | ✅ |
| F(x(i)) | `computeFxi` | 0.38803 / 0.20652 | ✅ |
| Terms | `computeFinalTerms` | 0.01423, 0.05653, 0.02770 | ✅ |
| Result | `computeFinalValue` | 0.3500589 | ✅ |

Con num_seg = 20 el resultado es **0.35005864**, igual que la página 12
del documento.

## Resumen de JUnit

```
Tests run: 28, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

| Grupo | Pruebas |
|---|---|
| Tabla 1 y `Logic` | 7 |
| `SimpsonIntegration` (paso a paso) | 11 |
| `GammaFunction` | 3 |
| `Output` | 2 |
| `App` | 5 |
| **Total** | **28** |

## Cobertura (JaCoCo 0.8.12)

```
[INFO] --- jacoco:0.8.12:check (check-100) @ program5 ---
[INFO] All coverage checks have been met.
```

| Clase | Instrucciones sin cubrir | Ramas sin cubrir |
|---|---|---|
| App | 0 | 0 |
| Logic | 0 | 0 |
| SimpsonIntegration | 0 | 0 |
| GammaFunction | 0 | 0 |
| Output | 0 | 0 |
| **Total** | **0** | **0** |

**100 % de instrucciones y 100 % de ramas.** Reporte HTML en
`target/site/jacoco/index.html`.

## Comandos usados

```bash
mvn test                                   # las 26 juntas
mvn test -Dtest='A5Test#prueba1TablaUno'   # una sola
mvn verify                                 # pruebas + check de 100 %
```

## Verificación contra el prototipo del profesor

El prototipo en hoja de cálculo que dio el profesor integra `F(x) = 2x` de 0 a 4
con `num_seg = 4`, y usa los multiplicadores 1, 4, 2, 4, 1 con `W = 1`.

| Comprobación | Prototipo | Programa | Resultado |
|---|---|---|---|
| Ancho `W = x / num_seg` | 4 / 4 = 1 | 1.0 | ✅ |
| Puntos `x(i)` | 0, 1, 2, 3, 4 | 0, 1, 2, 3, 4 | ✅ |
| Multiplicadores de Simpson | 1, 4, 2, 4, 1 | 1, 4, 2, 4, 1 | ✅ |

Las pruebas `multiplicadoresDeSimpsonSiguenElPatron` y
`anchoYPuntosDelPrototipoDelProfesor` cubren estos tres puntos. Verifican la
mecánica de la regla de Simpson por separado de la distribución t, que es
justo lo que el prototipo ilustra.
