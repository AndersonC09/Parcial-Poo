import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListaEstudiante listaEstudiante = new ListaEstudiante();
        List<InfoCarrera> infoCarreras = new ArrayList<>();


        ListaCarrera listaCarreras = new ListaCarrera();

        for (Carrera carrera : listaCarreras.carreras) {
            double promedioNotas = 0.0;
            double sumaEdades = 0;
            int numEstudiantes = 0;


            for (Estudiante estudiante : listaEstudiante.estudiantes) {
                // Si el estudiante pertenece a la carrera actual
                if (estudiante.getCarrera() == carrera.getCodigo()) {
                    promedioNotas += estudiante.getPromedio();
                    sumaEdades += estudiante.getEdad();
                    numEstudiantes++;
                }
            }


            promedioNotas /= numEstudiantes;
            double promedioEdad = (double) sumaEdades / numEstudiantes;


            infoCarreras.add(new InfoCarrera(carrera, promedioNotas, promedioEdad));
        }

        imprimirReporte(infoCarreras);
    }

    public static void imprimirReporte(List<InfoCarrera> infoCarreras) {
        System.out.println("\nReporte de Carreras:");
        System.out.println("\n");

        double totalPromedioNotas = 0.0;
        double totalPromedioEdades = 0.0;
        int totalEstudiantes = 0;

        for (InfoCarrera infoCarrera : infoCarreras) {
            System.out.println("Carrera: " + infoCarrera.getCarrera().getNombre());
            System.out.println("Promedio de notas: " + infoCarrera.getPromedioNotas());
            System.out.println("Promedio de edad: " + infoCarrera.getPromedioEdad());
            System.out.println();

            totalPromedioNotas += infoCarrera.getPromedioNotas();
            totalPromedioEdades += infoCarrera.getPromedioEdad();
            totalEstudiantes += infoCarrera.getCarrera().getCodigo();
        }


        System.out.println("PROMEDIO DE NOTAS : " + totalPromedioNotas / infoCarreras.size());
        System.out.println("PROMEDIO DE EDADES : " + totalPromedioEdades / infoCarreras.size());
    }
}
