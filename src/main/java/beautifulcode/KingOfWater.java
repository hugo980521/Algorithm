package beautifulcode;

public class KingOfWater {
    public static void main(String[] args) {
        int a[] = {3, 3, 3, 5, 3, 3, 2, 3, 2, 3, 3, 3, 0, 9, 0, 8, 4};
        int b[] = {3, 5, 3, 2, 4, 3, 6, 8, 3, 6, 3, 2, 3, 6, 2, 8, 3, 6, 2, 3, 4, 6, 2, 2, 6};
        int candidate[] = new int[3];

        Find(a, a.length);
        Find3(b, b.length, candidate);

//1/3水王----可推广
        for (int i = 0; i < candidate.length; i++) {
            System.out.println(candidate[i]);
        }
    }

    static int Find(int[] ID, int N) {
        int candidate = 0;
        int nTimes = 0, i;
        for (i = 0; i < N; i++) {
            if (candidate == ID[i]) {
                nTimes++;
            } else if (nTimes == 0) {
                candidate = ID[i];
                nTimes = 1;
            } else
                nTimes--;
        }
        return candidate;
    }

    static int[] Find3(int[] ID, int N, int candidate[]) {
        int nTimes[] = new int[3], i;
        nTimes[0] = 0;
        nTimes[1] = 0;
        nTimes[2] = 0;
        candidate[0] = 0;
        candidate[1] = 0;
        candidate[2] = 0;
        for (i = 0; i < N; i++) {
            if (candidate[0] == ID[i]) {
                nTimes[0]++;
            } else if (candidate[1] == ID[i]) {
                nTimes[1]++;
            } else if (candidate[2] == ID[i]) {
                nTimes[2]++;
            } else if (nTimes[0] == 0) {
                candidate[0] = ID[i];
                nTimes[0] = 1;
            } else if (nTimes[1] == 0) {
                candidate[1] = ID[i];
                nTimes[1] = 1;
            } else if (nTimes[2] == 0) {
                candidate[2] = ID[i];
                nTimes[2] = 1;
            } else {
                nTimes[0]--;
                nTimes[1]--;
                nTimes[2]--;
            }
        }
        return candidate;
    }
}

