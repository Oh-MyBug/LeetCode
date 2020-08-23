/**
 * ClassName:   Solution_223
 * Data:        2020/8/24
 * author:      Oh_MyBug
 * version:     V1.0
 */

/*
223. 矩形面积
在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
示例:
输入: -3, 0, 3, 4, 0, -1, 9, 2
输出: 45
 */
public class Solution_223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int first_area = area(A, B, C, D);
        int second_area = area(E, F, G, H);
        int recover_area;
        int I = Math.max(A, E), J = Math.max(B, F), K = Math.min(C, G), L = Math.min(D, H);
        recover_area = I < K && J < L ? area(I, J, K, L) : 0;
        return first_area + second_area - recover_area;
    }

    public int area(int A, int B, int C, int D) {
        int width = C - A;
        int height = D - B;
        return width * height;
    }
}
