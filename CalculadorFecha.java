/*-- ======================================================
--  Proyecto: CalcuadorFecha
--  Autor: [srg-info]
--  Licencia: [MIT]
--  Descripción: Aquí te dejo el Script en Python, sobre una calculadora de fechas
--  con su licencia MIT. Se trabajo con el scrip por la necesidad de determinar los tiempos entre dos  
--  fechas y calcular cuántos días hábiles tienia para cumplir con tareas / me fue util en gestión de proyectos.
-- ======================================================*/
  
## 💻 Código base en Java (con cálculo de días hábiles)

Aquí te dejo un archivo inicial `DateCalculator.java`:

```java
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateCalculator {

    public static int calcularDiasHabiles(LocalDate inicio, LocalDate fin) {
        int diasHabiles = 0;
        LocalDate actual = inicio;

        while (!actual.isAfter(fin)) {
            DayOfWeek dia = actual.getDayOfWeek();
            if (dia != DayOfWeek.SATURDAY && dia != DayOfWeek.SUNDAY) {
                diasHabiles++;
            }
            actual = actual.plusDays(1);
        }

        return diasHabiles;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la fecha inicial (yyyy-MM-dd): ");
        LocalDate fechaInicio = LocalDate.parse(sc.nextLine());

        System.out.print("Ingrese la fecha final (yyyy-MM-dd): ");
        LocalDate fechaFin = LocalDate.parse(sc.nextLine());

        long diferencia = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        int diasHabiles = calcularDiasHabiles(fechaInicio, fechaFin);

        System.out.println("\n✅ Diferencia total: " + diferencia + " días");
        System.out.println("✅ Días hábiles: " + diasHabiles + " días");

        sc.close();
    }
}
