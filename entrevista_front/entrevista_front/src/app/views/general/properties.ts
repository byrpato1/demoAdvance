

export class Properties{
    formatoFechaCalendar: string;
    es: any;
    nuevo="Nuevo";
    guardar="Guardar";
    cancelar="Cancelar";
    seleccione="Seleccione";
    urlReportes: string;
    atras = "Atras";
    constructor() {
        this.formatoFechaCalendar = "dd/mm/yy";
        this.es = {
            firstDayOfWeek: 1,
            dayNames: ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado"],
            dayNamesShort: ["Dom", "Lun", "Mart", "Mier", "Juev", "Vier", "Sáb"],
            dayNamesMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
            monthNames: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
            monthNamesShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"]
        };
    }
}