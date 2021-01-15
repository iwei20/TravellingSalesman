private class Path {

    int pos;
    int totalCost;
    int lastVisited;
    bool[] visited;

    public Path(int[] visited, int pos) {
        this.visited = visited;
        this.pos = pos;
        totalCost = 0;
    }

    public Path(int len) {
        this(new int[len], 0);
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
        int[] visitedCopy = new int[visited.length];
        for(int i = 0; i < visited.length; ++i) {
            visitedCopy[i] = visited[i];
        }
        return new Path(visitedCopy, pos);
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
