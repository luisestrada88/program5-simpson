# Decisiones de diseno - Programa 5

1. **Gamma solo para multiplos de 1/2.** La distribucion t solo necesita
   gamma en `(dof+1)/2` y `dof/2`, con dof entero. Por eso se usan las
   dos identidades del documento: `gamma(n) = (n-1)!` y
   `gamma(z+1) = z*gamma(z)` partiendo de `gamma(1/2) = raiz(pi)`.
   No se implemento una gamma general (Lanczos) porque no hace falta.

2. **Segmentos iniciales = 10 y se duplican.** El documento pide
   duplicar hasta que la diferencia entre dos corridas sea menor que
   0.00001. Con 20 segmentos ya se alcanza en los tres casos.

3. **Reuso del P3.** `Nodo`, `ListaEnlazada`, `ReadFile` y `OutFile` se
   reusaron sin cambios de logica; solo se actualizo el encabezado.

4. **Un parametro en `Main`.** El profesor pidio poder probar una prueba
   a la vez pasando cual por parametro; `Main` acepta 1, 2 o 3 y sin
   parametro corre las tres.

5. **`Locale.US` en los printf.** Defecto ya conocido del Programa 1:
   en una Mac en espanol `%.4f` imprime coma decimal.
