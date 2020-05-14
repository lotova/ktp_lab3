package ktp_lab3;

import java.util.*;

/**
 *Этот класс хранит базовое состояние, необходимое алгоритму A * для вычисления пути по карте. 
 *Это состояние включает в себя коллекцию «открытых путевых точек» и другую коллекцию «закрытых путевых точек». 
 *Кроме того, этот класс предоставляет основные операции,
 * необходимые алгоритму поиска пути A * для его обработки.
 **/
public class AStarState
{
    /** Это ссылка на карту, по которой движется алгоритм A * **/
    private Map2D map;
    /**Создание HashMap**/
    private Map<Location, Waypoint> Opened = new java.util.HashMap<Location, Waypoint>();
    private Map<Location, Waypoint> Closed = new java.util.HashMap<Location, Waypoint>();


    /**
     * Инициализация нового объекта состояния для алгоритма поиска пути A *.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");
        this.map = map;
    }

    /** Возвращает карту, по которой перемещается указатель пути A* **/
    public Map2D getMap()
    {
        return map;
    }

    /**
     *Этот метод просматривает все открытые путевые точки и 
     *возвращает путевую точку с минимальной общей стоимостью.
     * Если открытых путевых точек нет, этот метод возвращает <code> null </ code>.
     **/
    public Waypoint getMinOpenWaypoint()
    {
        if (Opened.size() == 0) return null;
        ArrayList<Waypoint> waypoints = new ArrayList<Waypoint>(Opened.values());
        float mincost = waypoints.get(0).getTotalCost();
        Waypoint min = waypoints.get(0);
        for (int i = 1; i < waypoints.size(); i++) {
            if (waypoints.get(i).getTotalCost() < mincost) {
                min = waypoints.get(i);
                mincost = min.getTotalCost();
            }
        }
        return min;
    }

    /**
     * Этот метод добавляет путевую точку (или потенциально обновляет путевую точку, уже находящуюся в) 
     * в коллекцию «открытых путевых точек». Если там уже нет открытого,
     * путевая точка в местоположении новой путевой точки, тогда новая путевая точка просто
     * добавлен в коллекцию. Однако, если уже есть путевая точка на
     * местоположение новой путевой точки, новая путевая точка заменяет только старую <em>
     * если </ em> значение "предыдущей стоимости" новой путевой точки меньше текущей
     * значение «предыдущей стоимости» путевой точки.
     **/
    public boolean addOpenWaypoint(Waypoint newWP)
    {
    	/**Если в наборе «открытых вершин» в настоящее время нет вершины
    	 * для данного местоположения, то необходимо просто добавить новую вершину.**/
        if (Opened.get(newWP.getLocation()) == null ) {
            Opened.put(newWP.getLocation(), newWP);
            return true;
        }
        else
        {
        /**если путь через  вершину короче, чем путь через текущую вершину, замените текущую вершинуна новую **/
            if (Opened.get(newWP.getLocation()).getPreviousCost() >
            newWP.getPreviousCost()) {
                Opened.put(newWP.getLocation(), newWP); //замените предыдущую точку на новую, используя метод HashMap.put(), который заменит старое значение на новое.
                return true;
            }
        }
        return false;
    }


    /** Возвращает текущее количество открытых путевых точек. **/
    public int numOpenWaypoints()
    {
        return Opened.size();
    }


    /**
     *  Этот метод перемещает путевую точку 
     * в указанном месте из открытого списка в закрытый список.
     **/
    public void closeWaypoint(Location loc)
    {
        Closed.put(loc, Opened.remove(loc));
    }

    /**
     * Возвращает true, если коллекция закрытых путевых точек содержит путевую точку
     * для указанного места.
     **/
    public boolean isLocationClosed(Location loc)
    {
        if (Closed.containsKey(loc)) return true;
        return false;
    }
}