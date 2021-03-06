public class Path {

    int pos;
    int totalCost;
    int lastVisited;
    boolean[] visited;

    public Path(boolean[] visited, int pos, int totalCost) {
        this.visited = visited;
        this.pos = pos;
        this.totalCost = totalCost;
    }

    public Path(int len) {
        this(new boolean[len], 0, 0);
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
        return new Path(visitedCopy, pos, totalCost);
    }

    public Path add(int city, int cost) {
        pos++;
        lastVisited = city;
        visited[city] = true;
        totalCost += cost;
        return this;
    }

    public boolean contains(int city) {
        return visited[city];
    }

}
