# Test Report — Program 5

**Alumno:** Alejandro · **Programa:** 5 — Integración por la regla de Simpson

## Pruebas de la Tabla 1 del documento 5a

| Prueba | x | dof | p esperada | p obtenida | Segmentos | Resultado |
|---|---|---|---|---|---|---|
| 1 | 1.1 | 9 | 0.35006 | 0.35005864 | 20 | ✅ |
| 2 | 1.1812 | 10 | 0.36757 | 0.36757341 | 20 | ✅ |
| 3 | 2.750 | 30 | 0.495 | 0.49499986 | 20 | ✅ |

## Resumen de JUnit

```
Tests run: 27, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

| Grupo | Pruebas |
|---|---|
| Tabla 1 (valores y segmentos) | 5 |
| `Simpson` | 2 |
| `DistribucionT` | 2 |
| `Gamma` | 4 |
| `Nodo` y `ListaEnlazada` | 4 |
| `ReadFile` | 3 |
| `OutFile` | 2 |
| `Main` | 5 |
| **Total** | **27** |

## Cobertura (JaCoCo 0.8.12)

```
[INFO] --- jacoco:0.8.12:check (check-100) @ program5 ---
[INFO] All coverage checks have been met.
```

| Clase | Instrucciones sin cubrir | Ramas sin cubrir |
|---|---|---|
| Gamma | 0 | 0 |
| DistribucionT | 0 | 0 |
| Simpson | 0 | 0 |
| Nodo | 0 | 0 |
| ListaEnlazada | 0 | 0 |
| ReadFile | 0 | 0 |
| OutFile | 0 | 0 |
| Main | 0 | 0 |
| **Total** | **0** | **0** |

**100 % de instrucciones y 100 % de ramas.** Reporte HTML en
`target/site/jacoco/index.html`.

## Comandos usados

```bash
mvn test                                   # las 27 juntas
mvn test -Dtest='A5Test#prueba1TablaUno'   # una sola
mvn verify                                 # pruebas + check de 100 %
```
