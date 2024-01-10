package Model;

import java.util.Objects;

public class Player {
    private String nombre;

    public Player(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(nombre, player.nombre);
    }

    @Override
    public String toString() {
        return "Player{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
