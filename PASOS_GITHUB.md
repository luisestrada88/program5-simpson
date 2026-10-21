# GitHub y CI/CD del Programa 5 — COMPLETADO

Repositorio: **https://github.com/luisestrada88/program5-simpson**

| # | Paso (diapositivas 37–42) | Estado |
|---|---|---|
| 1 | Crear el repositorio | ✅ `luisestrada88/program5-simpson`, publico |
| 2 | Subir el proyecto al branch `master` | ✅ |
| 3 | Workflow de GitHub Actions en verde | ✅ |
| 4 | Proteger el branch `master` | ✅ |
| 5 | Merge por pull request | ✅ PR #1, #2 y #3 |

## Contenido actual de `master`

Las 5 clases del **diagrama de la diapositiva 46**: `App`, `Logic`,
`SimpsonIntegration`, `GammaFunction` y `Output`, mas `A5Test` con 26
pruebas. Verificado con `mvn verify`: 26 pruebas, 0 fallos, 100 % de
instrucciones y 100 % de ramas.

## Proteccion de `master`

- Require a pull request before merging ✅
- Require status checks to pass before merging ✅, con `ci-cd` obligatorio
- Require approvals: **desactivado** a proposito (eres el unico en el repo y
  no podrias aprobar tu propio PR)

## Nota sobre el historial de Actions

Entre los commits #15 y #19 hay **5 runs en rojo** en el branch `develop`.
Son de los commits intermedios en los que se iban borrando una por una las
clases de la primera version: durante esos commits el proyecto no compilaba
porque `A5Test` ya referenciaba las clases nuevas y todavia quedaban clases
viejas sin borrar.

No son un problema del codigo: el run del pull request (#22) y el del merge
a `master` (#23) estan **en verde**. Si el profesor pregunta, es la historia
real del rediseno del defecto #4.

## Los 3 pull requests

| PR | Que hizo | Resultado |
|---|---|---|
| #1 | README con badge del build | ✅ mergeado |
| #2 | Postmortem: 8.0 h, CPI 0.75 | ✅ mergeado |
| #3 | Rediseno segun el diagrama (defecto #4) | ✅ mergeado |

## Que enseñarle al profesor

1. **Actions** — el run mas reciente de `master` en verde, con el log de
   `mvn --batch-mode verify`.
2. El artefacto **jacoco-report** descargado (100 % de cobertura).
3. **Settings → Branches** — la regla de `master` activa.
4. **Pull requests** — los 3 mergeados, con "All checks have passed".
5. El archivo **.github/workflows/ci.yml**.
6. **Code** — las 5 clases del diagrama en `src/main/java`.
