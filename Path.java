import java.util.ArrayList;

public class Path {

    int pos;
    int totalCost;
    int lastVisited;
    ArrayList<Integer> parts;
    boolean[] visited;

    public Path(ArrayList<Integer> parts, boolean[] visited, int pos, int totalCost) {
        this.parts = parts;
        this.visited = visited;
        this.pos = pos;
        this.totalCost = totalCost;
    }

    public Path(int len) {
        this(new ArrayList<Integer>(), new boolean[len], 0, 0);
    }

    public int getCost() {
        return totalCost;
    }

    public int getLastVisited() {
        return lastVisited;
    }

    public boolean finished() {
        return pos == visited.length;
    }

    public Path clone() {
        boolean[] visitedCopy = new boolean[visited.length];
        for(int i = 0; i < visited.length; ++i) {
            visitedCopy[i] = visited[i];
        }
        return new Path(new ArrayList<Integer>(parts), visitedCopy, pos, totalCost);
    }

    public Path add(int city, int cost) {
        pos++;
        parts.add(city);
        lastVisited = city;
        visited[city] = true;
        totalCost += cost;
        return this;
    }

    public boolean contains(int city) {
        return visited[city];
    }

    public ArrayList<Integer> fullPath() {
        return parts;
    }
}
