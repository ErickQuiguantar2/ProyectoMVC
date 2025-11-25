/*
 * Autor: Erick Sanguña
 * Descripción: Clase modelo Rectangulo que representa un rectángulo
 * con base y altura, e incluye métodos para obtener y modificar
 * sus valores, así como calcular su área.
 */

package Modelos;

public class Rectangulo {

    // Atributos privados del rectángulo
    private int base;
    private int altura;

    // Constructor vacío (necesario para JavaBeans)
    public Rectangulo() {
    }

    // Constructor con parámetros para inicializar el objeto
    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    // Getter: devuelve la base del rectángulo
    public int getBase() {
        return base;
    }

    // Setter: asigna un valor a la base
    public void setBase(int base) {
        this.base = base;
    }

    // Getter: devuelve la altura del rectángulo
    public int getAltura() {
        return altura;
    }

    // Setter: asigna un valor a la altura
    public void setAltura(int altura) {
        this.altura = altura;
    }

    // Método para calcular el área del rectángulo
    public double getArea() {
        double area = this.base * this.altura;
        return area;
    }
}


