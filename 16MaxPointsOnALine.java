class Solution {
    int[][] points;
    int n;
    HashMap<Double, Integer> lines = new HashMap<Double, Integer>();
    int horizontal_lines;

    public int maxPoints(int[][] points) {
        this.points = points;
        n = points.length;
        if (n < 3)
            return n;

        int max_count = 1;
        for (int i = 0; i < n - 1; i++) {
            max_count = Math.max(max_points_on_a_line_containing_point_i(i), max_count);
        }
        return max_count;
    }

    public int max_points_on_a_line_containing_point_i(int i) {
        lines.clear();
        horizontal_lines = 1;
        int count = 1;
        int duplicates = 0;

        for (int j = i + 1; j < n; j++) {
            Pair<Integer, Integer> p = add_line(i, j, count, duplicates);
            count = p.getKey();
            duplicates = p.getValue();
        }
        return count + duplicates;
    }

    public Pair<Integer, Integer> add_line(int i, int j, int count, int duplicates) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        if (x1 == x2 && y1 == y2) {
            duplicates++;
        } else if (y1 == y2) {
            horizontal_lines += 1;
            count = Math.max(horizontal_lines, count);
        } else {
            double slope = 1.0 * (x1 - x2) / (y1 - y2) + 0.0;
            lines.put(slope, lines.getOrDefault(slope, 1) + 1);
            count = Math.max(lines.get(slope), count);
        }
        return new Pair(count, duplicates);
    }
}