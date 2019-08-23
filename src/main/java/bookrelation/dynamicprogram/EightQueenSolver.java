package bookrelation.dynamicprogram;

/**
 * Created by lcm on 2018/7/2 0002.
 */
public class EightQueenSolver {

    private int QUEEN_COUNT = 0; // 皇后的默认数量

    private int[][] Queencount;// 分配8X8的数组，充当棋盘，存放皇后

    private int resultCount = 0;// 记录皇后的放置方法的总数

    private int[] Queenplace;// 对于索引n, Queenplace[n]表示第n行的皇后放置位置是第Queenplace[n]列

    public EightQueenSolver(int n) {
        this.QUEEN_COUNT = n;
        this.resultCount = 0;
        this.Queencount = new int[QUEEN_COUNT][QUEEN_COUNT];
        Queenplace = new int[QUEEN_COUNT];
    }

    public void putQueen() {
        putQueen(0);
    }

    private void putQueen(int row) {

        if (row == QUEEN_COUNT) {
            resultCount++;
            printQueen(resultCount);
            return;
        }

        for (int i = 0; i < QUEEN_COUNT; i++) {
            Queenplace[row] = i;
            if (isOk(row)) {
                putQueen(row + 1);
            }
        }

        if (row == 0) {
            System.out.println(QUEEN_COUNT + "皇后问题共有" + resultCount + "个解.");
        }
    }


    private boolean isOk(int n) {
        for (int i = 0; i < n; i++) {
            if (Queenplace[i] == Queenplace[n] || Math.abs(n - i) == Math.abs(Queenplace[n] - Queenplace[i])) {
                return false;
            }
        }
        return true;
    }

    private void print()  {
        for (int i = 0; i < Queenplace.length; i++) {
            System.out.print(Queenplace[i] + 1 + " ");
        }
        System.out.println();
    }
    private void printQueen(int size)// 打印皇后布局
    {
        System.out.println(QUEEN_COUNT + "皇后的第" + size + "个解是:");
        System.out.println();

        print();

        System.out.println();
        for (int row = 0; row < QUEEN_COUNT; row++) {
            for (int column = 0; column < QUEEN_COUNT; column++) {
                System.out.print(Queenplace[row] == column ? " * " : " - ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueenSolver eq = new EightQueenSolver(5);
        eq.putQueen();
    }
}
