/**
 * Lógica de cálculos para Facturación - TechPro
 */
document.addEventListener("DOMContentLoaded", () => {
    // Referencias a los IDs que definimos en el HTML de Registro Factura
    const cantidadInput = document.getElementById("cantidad");
    const precioInput = document.getElementById("precio");
    const subtotalInput = document.getElementById("subtotal");
    const totalInput = document.getElementById("total");

    const calcularTotales = () => {
        // Limpiamos el precio por si contiene caracteres no numéricos (como $)
        const precioLimpio = precioInput.value.replace(/[^0-9.]/g, '');

        const cantidad = parseInt(cantidadInput.value) || 0;
        const precio = parseFloat(precioLimpio) || 0;

        // Cálculo de Subtotal
        const subtotal = cantidad * precio;

        // Cálculo de Total (Aplicando IVA del 15% - Ajustado a estándar actual)
        // Si en tu país es 12%, cambia 1.15 por 1.12
        const total = subtotal * 1.15;

        // Asignación de valores con 2 decimales
        subtotalInput.value = subtotal.toFixed(2);
        totalInput.value = total.toFixed(2);
    };

    // Escuchar cuando el usuario escribe en la cantidad
    cantidadInput.addEventListener("input", calcularTotales);

    // Ejecutar al cargar por si es una edición de factura existente
    if (cantidadInput.value) {
        calcularTotales();
    }
});