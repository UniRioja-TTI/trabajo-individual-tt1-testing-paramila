package modelo;

import java.util.ArrayList;
import java.util.List;

public class DatosSimulation {
    private int anchoMatriz;
    private List<Celda> celdas = new ArrayList<>();

    public int getAnchoMatriz() { return anchoMatriz; }
    public void setAnchoMatriz(int anchoMatriz) { this.anchoMatriz = anchoMatriz; }

    public List<Celda> getCeldas() { return celdas; }
    public void addCelda(Celda celda) { this.celdas.add(celda); }
}