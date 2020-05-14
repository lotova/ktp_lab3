package ktp_lab3;

import java.util.Objects;

/**
 ���� ����� ������������ ���������� �������������� �� 2D-�����. 
 ���������� �������� �������������� ����������
 **/
public class Location
{
    /** X ����������  **/
    public int xCoord;

    /** Y ����������  **/
    public int yCoord;


    /**����������� - ������� ����� �������������� � ���������� �������������� ������������. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** ����������� �� ��������� **/
    public Location()
    {
        this(0, 0);
    }
/**��������������� ������ equals**/
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