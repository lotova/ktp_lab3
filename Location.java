package ktp_lab3;

import java.util.Objects;

/**
 этот класс представляет конкретное местоположение на 2D-карте. 
 Координаты являются целочисленными значениями
 **/
public class Location
{
    /** X координата  **/
    public int xCoord;

    /** Y координата  **/
    public int yCoord;


    /**КОНСТРУКТОР - Создает новое местоположение с указанными целочисленными координатами. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** КОНСТРУКТОР ПО УМОЛЧАНИЮ **/
    public Location()
    {
        this(0, 0);
    }
/**переопределение класса equals**/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return xCoord == location.xCoord &&
                yCoord == location.yCoord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }
}