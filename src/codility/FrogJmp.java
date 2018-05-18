class Solution {
    public int solution(int X, int Y, int D) {
        int sub = Y-X;
        if (X == Y) return 0;
        else if (sub <= D) return 1;
        int r = sub / D;
        return sub % D == 0? r : r+1;
    }
}
