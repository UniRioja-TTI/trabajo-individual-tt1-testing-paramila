package modelo;

public class Celda {
    private int tiempo;
    private int posY;
    private int posX;
    private String color;

    public Celda(int tiempo, int posY, int posX, String color) {
        this.tiempo = tiempo;
        this.posY = posY;
        this.posX = posX;
        this.color = color;
    }

    public int getTiempo() { return tiempo; }
    public int getPosY() { return posY; }
    public int getPosX() { return posX; }
    public String getColor() { return color; }
}