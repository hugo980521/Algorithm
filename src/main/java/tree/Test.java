package tree;

import tree.interval_tree.IntervalTree;
import tree.kdtree.KdTree;
import tree.segmenttree.SegmentTree;
import tree.suffix.SuffixTree;

import java.util.ArrayList;
import java.util.Collection;

public class Test {


    private static boolean testIntervalTree() {
        int debug = 2;
        {
            //Interval tree
            if (debug > 1) System.out.println("Interval Tree.");
            java.util.List<IntervalTree.IntervalData<String>> intervals = new ArrayList<IntervalTree.IntervalData<String>>();
            intervals.add((new IntervalTree.IntervalData<String>(2, 6, "RED")));
            intervals.add((new IntervalTree.IntervalData<String>(3, 5, "ORANGE")));
            intervals.add((new IntervalTree.IntervalData<String>(4, 11, "GREEN")));
            intervals.add((new IntervalTree.IntervalData<String>(5, 10, "DARK_GREEN")));
            intervals.add((new IntervalTree.IntervalData<String>(8, 12, "BLUE")));
            intervals.add((new IntervalTree.IntervalData<String>(9, 14, "PURPLE")));
            intervals.add((new IntervalTree.IntervalData<String>(13, 15, "BLACK")));
            IntervalTree<String> tree = new IntervalTree<String>(intervals);
            if (debug > 1) System.out.println(tree);

            IntervalTree.IntervalData<String> query = tree.query(2);
            if (debug > 1) System.out.println("2: " + query);

            query = tree.query(4); //Stabbing query
            if (debug > 1) System.out.println("4: " + query);

            query = tree.query(9); //Stabbing query
            if (debug > 1) System.out.println("9: " + query);

            query = tree.query(1, 16); //Range query
            if (debug > 1) System.out.println("1->16: " + query);

            query = tree.query(7, 14); //Range query
            if (debug > 1) System.out.println("7->14: " + query);

            query = tree.query(14, 15); //Range query
            if (debug > 1) System.out.println("14->15: " + query);

            if (debug > 1) System.out.println();
        }
        {
            //Lifespan Interval tree
            if (debug > 1) System.out.println("Lifespan Interval Tree.");
            java.util.List<IntervalTree.IntervalData<String>> intervals = new ArrayList<IntervalTree.IntervalData<String>>();
            intervals.add((new IntervalTree.IntervalData<String>(1888, 1971, "Stravinsky")));
            intervals.add((new IntervalTree.IntervalData<String>(1874, 1951, "Schoenberg")));
            intervals.add((new IntervalTree.IntervalData<String>(1843, 1907, "Grieg")));
            intervals.add((new IntervalTree.IntervalData<String>(1779, 1828, "Schubert")));
            intervals.add((new IntervalTree.IntervalData<String>(1756, 1791, "Mozart")));
            intervals.add((new IntervalTree.IntervalData<String>(1585, 1672, "Schuetz")));
            IntervalTree<String> tree = new IntervalTree<String>(intervals);
            if (debug > 1) System.out.println(tree);

            IntervalTree.IntervalData<String> query = tree.query(1890);
            if (debug > 1) System.out.println("1890: " + query);

            query = tree.query(1909); //Stabbing query
            if (debug > 1) System.out.println("1909: " + query);

            query = tree.query(1792, 1903); //Range query
            if (debug > 1) System.out.println("1792->1903: " + query);

            query = tree.query(1776, 1799); //Range query
            if (debug > 1) System.out.println("1776->1799: " + query);

            if (debug > 1) System.out.println();

        }
        return true;
    }


    private static boolean testKdTree() {
        int debug = 2;
        // K-D TREE
        if (debug > 1) System.out.println("k-d tree with node.");

        java.util.List<KdTree.XYZPoint> points = new ArrayList<KdTree.XYZPoint>();
        KdTree.XYZPoint p1 = new KdTree.XYZPoint(2, 3);
        points.add(p1);
        KdTree.XYZPoint p2 = new KdTree.XYZPoint(5, 4);
        points.add(p2);
        KdTree.XYZPoint p3 = new KdTree.XYZPoint(9, 6);
        points.add(p3);
        KdTree.XYZPoint p4 = new KdTree.XYZPoint(4, 7);
        points.add(p4);
        KdTree.XYZPoint p5 = new KdTree.XYZPoint(8, 1);
        points.add(p5);
        KdTree.XYZPoint p6 = new KdTree.XYZPoint(7, 2);
        points.add(p6);
        KdTree<KdTree.XYZPoint> kdTree = new KdTree<KdTree.XYZPoint>(points);
        if (debug > 1) System.out.println(kdTree.toString());

        Collection<KdTree.XYZPoint> result = kdTree.nearestNeighbourSearch(1, p3);
        if (debug > 1) System.out.println("NNS for " + p3 + " result=" + result + "\n");

        KdTree.XYZPoint search = new KdTree.XYZPoint(1, 4);
        result = kdTree.nearestNeighbourSearch(4, search);
        if (debug > 1) System.out.println("NNS for " + search + " result=" + result + "\n");

        kdTree.remove(p6);
        if (debug > 1) System.out.println("Removed " + p6 + "\n" + kdTree.toString());
        kdTree.remove(p4);
        if (debug > 1) System.out.println("Removed " + p4 + "\n" + kdTree.toString());
        kdTree.remove(p3);
        if (debug > 1) System.out.println("Removed " + p3 + "\n" + kdTree.toString());
        kdTree.remove(p5);
        if (debug > 1) System.out.println("Removed " + p5 + "\n" + kdTree.toString());
        kdTree.remove(p1);
        if (debug > 1) System.out.println("Removed " + p1 + "\n" + kdTree.toString());
        kdTree.remove(p2);
        if (debug > 1) System.out.println("Removed " + p2 + "\n" + kdTree.toString());

        if (debug > 1) System.out.println();


        return true;
    }

    private static boolean testSegmentTree() {
        int debug = 2;
        {


            //Quadrant Segment tree
            if (debug > 1) System.out.println("Quadrant Segment Tree.");
            java.util.List<SegmentTree.Data.QuadrantData> segments = new ArrayList<SegmentTree.Data.QuadrantData>();
            segments.add(new SegmentTree.Data.QuadrantData(0, 1, 0, 0, 0)); //first point in the 0th quadrant
            segments.add(new SegmentTree.Data.QuadrantData(1, 0, 1, 0, 0)); //second point in the 1st quadrant
            segments.add(new SegmentTree.Data.QuadrantData(2, 0, 0, 1, 0)); //third point in the 2nd quadrant
            segments.add(new SegmentTree.Data.QuadrantData(3, 0, 0, 0, 1)); //fourth point in the 3rd quadrant
            SegmentTree.FlatSegmentTree<SegmentTree.Data.QuadrantData> tree = new SegmentTree.FlatSegmentTree<SegmentTree.Data.QuadrantData>(segments);
            if (debug > 1) System.out.println(tree);

            SegmentTree.Data.QuadrantData query = tree.query(0, 3);
            if (debug > 1) System.out.println("0->3: " + query + "\n");

            query = tree.query(2, 3);
            if (debug > 1) System.out.println("2->3: " + query + "\n");

            query = tree.query(0, 2);
            if (debug > 1) System.out.println("0->2: " + query + "\n");

            if (debug > 1) System.out.println();
        }

        {
            //Range Maximum Segment tree
            if (debug > 1) System.out.println("Range Maximum Segment Tree.");
            java.util.List<SegmentTree.Data.RangeMaximumData<Integer>> segments = new ArrayList<SegmentTree.Data.RangeMaximumData<Integer>>();
            segments.add(new SegmentTree.Data.RangeMaximumData<Integer>(0, (Integer) 4));
            segments.add(new SegmentTree.Data.RangeMaximumData<Integer>(1, (Integer) 2));
            segments.add(new SegmentTree.Data.RangeMaximumData<Integer>(2, (Integer) 6));
            segments.add(new SegmentTree.Data.RangeMaximumData<Integer>(3, (Integer) 3));
            segments.add(new SegmentTree.Data.RangeMaximumData<Integer>(4, (Integer) 1));
            segments.add(new SegmentTree.Data.RangeMaximumData<Integer>(5, (Integer) 5));
            segments.add(new SegmentTree.Data.RangeMaximumData<Integer>(6, (Integer) 0));
            segments.add(new SegmentTree.Data.RangeMaximumData<Integer>(7, 17, (Integer) 7));
            segments.add(new SegmentTree.Data.RangeMaximumData<Integer>(21, (Integer) 10));
            SegmentTree.FlatSegmentTree<SegmentTree.Data.RangeMaximumData<Integer>> tree = new SegmentTree.FlatSegmentTree<SegmentTree.Data.RangeMaximumData<Integer>>(segments, 3);
            if (debug > 1) System.out.println(tree);

            SegmentTree.Data.RangeMaximumData<Integer> query = tree.query(0, 7);
            if (debug > 1) System.out.println("0->7: " + query + "\n");

            query = tree.query(0, 21);
            if (debug > 1) System.out.println("0->21: " + query + "\n");

            query = tree.query(2, 5);
            if (debug > 1) System.out.println("2->5: " + query + "\n");

            query = tree.query(7);
            if (debug > 1) System.out.println("7: " + query + "\n");

            if (debug > 1) System.out.println();
        }

        {
            //Range Minimum Segment tree
            if (debug > 1) System.out.println("Range Minimum Segment Tree.");
            java.util.List<SegmentTree.Data.RangeMinimumData<Integer>> segments = new ArrayList<SegmentTree.Data.RangeMinimumData<Integer>>();
            segments.add(new SegmentTree.Data.RangeMinimumData<Integer>(0, (Integer) 4));
            segments.add(new SegmentTree.Data.RangeMinimumData<Integer>(1, (Integer) 2));
            segments.add(new SegmentTree.Data.RangeMinimumData<Integer>(2, (Integer) 6));
            segments.add(new SegmentTree.Data.RangeMinimumData<Integer>(3, (Integer) 3));
            segments.add(new SegmentTree.Data.RangeMinimumData<Integer>(4, (Integer) 1));
            segments.add(new SegmentTree.Data.RangeMinimumData<Integer>(5, (Integer) 5));
            segments.add(new SegmentTree.Data.RangeMinimumData<Integer>(6, (Integer) 0));
            segments.add(new SegmentTree.Data.RangeMinimumData<Integer>(17, (Integer) 7));
            SegmentTree.FlatSegmentTree<SegmentTree.Data.RangeMinimumData<Integer>> tree = new SegmentTree.FlatSegmentTree<SegmentTree.Data.RangeMinimumData<Integer>>(segments, 5);
            if (debug > 1) System.out.println(tree);

            SegmentTree.Data.RangeMinimumData<Integer> query = tree.query(0, 7);
            if (debug > 1) System.out.println("0->7: " + query + "\n");

            query = tree.query(0, 17);
            if (debug > 1) System.out.println("0->17: " + query + "\n");

            query = tree.query(1, 3);
            if (debug > 1) System.out.println("1->3: " + query + "\n");

            query = tree.query(7);
            if (debug > 1) System.out.println("7: " + query + "\n");

            if (debug > 1) System.out.println();
        }

        {
            //Range Sum Segment tree
            if (debug > 1) System.out.println("Range Sum Segment Tree.");
            java.util.List<SegmentTree.Data.RangeSumData<Integer>> segments = new ArrayList<SegmentTree.Data.RangeSumData<Integer>>();
            segments.add(new SegmentTree.Data.RangeSumData<Integer>(0, (Integer) 4));
            segments.add(new SegmentTree.Data.RangeSumData<Integer>(1, (Integer) 2));
            segments.add(new SegmentTree.Data.RangeSumData<Integer>(2, (Integer) 6));
            segments.add(new SegmentTree.Data.RangeSumData<Integer>(3, (Integer) 3));
            segments.add(new SegmentTree.Data.RangeSumData<Integer>(4, (Integer) 1));
            segments.add(new SegmentTree.Data.RangeSumData<Integer>(5, (Integer) 5));
            segments.add(new SegmentTree.Data.RangeSumData<Integer>(6, (Integer) 0));
            segments.add(new SegmentTree.Data.RangeSumData<Integer>(17, (Integer) 7));
            SegmentTree.FlatSegmentTree<SegmentTree.Data.RangeSumData<Integer>> tree = new SegmentTree.FlatSegmentTree<SegmentTree.Data.RangeSumData<Integer>>(segments, 10);
            if (debug > 1) System.out.println(tree);

            SegmentTree.Data.RangeSumData<Integer> query = tree.query(0, 8);
            if (debug > 1) System.out.println("0->8: " + query + "\n");

            query = tree.query(0, 17);
            if (debug > 1) System.out.println("0->17: " + query + "\n");

            query = tree.query(2, 5);
            if (debug > 1) System.out.println("2->5: " + query + "\n");

            query = tree.query(10, 17);
            if (debug > 1) System.out.println("10->17: " + query + "\n");

            query = tree.query(16);
            if (debug > 1) System.out.println("16: " + query + "\n");

            query = tree.query(17);
            if (debug > 1) System.out.println("17: " + query + "\n");

            if (debug > 1) System.out.println();
        }

        {
            //Interval Segment tree
            if (debug > 1) System.out.println("Interval Segment Tree.");
            java.util.List<SegmentTree.Data.IntervalData<String>> segments = new ArrayList<SegmentTree.Data.IntervalData<String>>();
            segments.add((new SegmentTree.Data.IntervalData<String>(2, 6, "RED")));
            segments.add((new SegmentTree.Data.IntervalData<String>(3, 5, "ORANGE")));
            segments.add((new SegmentTree.Data.IntervalData<String>(4, 11, "GREEN")));
            segments.add((new SegmentTree.Data.IntervalData<String>(5, 10, "DARK_GREEN")));
            segments.add((new SegmentTree.Data.IntervalData<String>(8, 12, "BLUE")));
            segments.add((new SegmentTree.Data.IntervalData<String>(9, 14, "PURPLE")));
            segments.add((new SegmentTree.Data.IntervalData<String>(13, 15, "BLACK")));
            SegmentTree.DynamicSegmentTree<SegmentTree.Data.IntervalData<String>> tree = new SegmentTree.DynamicSegmentTree<SegmentTree.Data.IntervalData<String>>(segments);
            if (debug > 1) System.out.println(tree);

            SegmentTree.Data.IntervalData<String> query = tree.query(2);
            if (debug > 1) System.out.println("2: " + query);

            query = tree.query(4); //Stabbing query
            if (debug > 1) System.out.println("4: " + query);

            query = tree.query(9); //Stabbing query
            if (debug > 1) System.out.println("9: " + query);

            query = tree.query(1, 16); //Range query
            if (debug > 1) System.out.println("1->16: " + query);

            query = tree.query(7, 14); //Range query
            if (debug > 1) System.out.println("7->14: " + query);

            query = tree.query(14, 15); //Range query
            if (debug > 1) System.out.println("14->15: " + query);

            if (debug > 1) System.out.println();
        }

        {
            //Lifespan Interval Segment tree
            if (debug > 1) System.out.println("Lifespan Interval Segment Tree.");
            java.util.List<SegmentTree.Data.IntervalData<String>> segments = new ArrayList<SegmentTree.Data.IntervalData<String>>();
            segments.add((new SegmentTree.Data.IntervalData<String>(1888, 1971, "Stravinsky")));
            segments.add((new SegmentTree.Data.IntervalData<String>(1874, 1951, "Schoenberg")));
            segments.add((new SegmentTree.Data.IntervalData<String>(1843, 1907, "Grieg")));
            segments.add((new SegmentTree.Data.IntervalData<String>(1779, 1828, "Schubert")));
            segments.add((new SegmentTree.Data.IntervalData<String>(1756, 1791, "Mozart")));
            segments.add((new SegmentTree.Data.IntervalData<String>(1585, 1672, "Schuetz")));
            SegmentTree.DynamicSegmentTree<SegmentTree.Data.IntervalData<String>> tree = new SegmentTree.DynamicSegmentTree<SegmentTree.Data.IntervalData<String>>(segments, 25);
            if (debug > 1) System.out.println(tree);

            SegmentTree.Data.IntervalData<String> query = tree.query(1890);
            if (debug > 1) System.out.println("1890: " + query);

            query = tree.query(1909); //Stabbing query
            if (debug > 1) System.out.println("1909: " + query);

            query = tree.query(1792, 1903); //Range query
            if (debug > 1) System.out.println("1792->1903: " + query);

            query = tree.query(1776, 1799); //Range query
            if (debug > 1) System.out.println("1776->1799: " + query);

            if (debug > 1) System.out.println();
        }

        return true;
    }


    private static boolean testSuffixTree() {
        int debug = 2;
        {
            //Suffix Tree
            if (debug > 1) System.out.println("Suffix Tree.");
            String bookkeeper = "bookkeeper";
            SuffixTree<String> tree = new SuffixTree<String>(bookkeeper);
            if (debug > 1) System.out.println(tree.toString());
            if (debug > 1) System.out.println(tree.getSuffixes());

            boolean exists = tree.doesSubStringExist(bookkeeper);
            if (!exists) {
                System.err.println("YIKES!! " + bookkeeper + " doesn't exists.");
//                handleError(tree);
                return false;
            }

            String failed = "booker";
            exists = tree.doesSubStringExist(failed);
            if (exists) {
                System.err.println("YIKES!! " + failed + " exists.");
//                handleError(tree);
                return false;
            }

            String pass = "kkee";
            exists = tree.doesSubStringExist(pass);
            if (!exists) {
                System.err.println("YIKES!! " + pass + " doesn't exists.");
//                handleError(tree);
                return false;
            }

            if (debug > 1) System.out.println();
        }

        return true;

    }
}
