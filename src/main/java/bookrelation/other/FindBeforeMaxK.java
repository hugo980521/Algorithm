package bookrelation.other;

/**
 * 两个有序数组的第k大的数
 */
public class FindBeforeMaxK {



    public int find(int[] a,int aLeft, int aRight,int[] b, int bLeft, int bRight, int k) {
        int aMid = (aLeft + aRight) / 2;
        int bMid = (bLeft + bRight) / 2;

        if (aLeft > aRight)
            return b[bLeft+k-1];
        if (bLeft > bRight)
            return a[aLeft+k-1];

        if (a[aMid] <= b[bMid]) {
            if (k <= (aMid-aLeft) + (bMid-bLeft) + 1)
                return find(a,aLeft, aRight, b,bLeft, bMid-1, k);
            else
                return find(a,aMid+1, aRight, b,bLeft, bRight, k-(aMid-aLeft)-1);
        } else {
            if (k <= (aMid-aLeft) + (bMid-bLeft) + 1)
                return find(a,aLeft, aMid-1,b, bLeft, bRight, k);
            else
                return find(a,aLeft, aRight,b, bMid+1, bRight, k-(bMid-bLeft)-1);
        }
    }

    public static void main(String[] args) {
        FindBeforeMaxK n = new FindBeforeMaxK();
        int[] a = new int[] {1, 4, 6};
        int[] b= new int[] {5, 8, 9};
        System.out.println(n.find(a,0, 2,b, 0, 2, 3));
    }
}
