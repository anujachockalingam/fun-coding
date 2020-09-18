package HackerRank.Stack;

import java.util.Stack;

/**
 * @author c59785a
 * Created on 2020-09-17 16:14
 * https://tech.pic-collage.com/algorithm-largest-area-in-histogram-84cc70500f0c
 **/
public class LargestRect {

    // 0(n2)
    //https://www.hackerrank.com/challenges/largest-rectangle/forum/comments/750162
    public static int largestRectanglularAreaInHistogram1(int[] hist) {
        int maxArea = 0;

        // Iterate through the histogram.
        for (int i = 0; i < hist.length; ++i) {
            int h = hist[i];

            maxArea = Math.max(maxArea, h);

            for (int j = i - 1; j >= 0; --j) {
                final int w = (i - j + 1);

                h = Math.min(h, hist[j]);

                maxArea = Math.max(maxArea, h * w);
            }
        }

        return maxArea;
    }

    //o(n) with stack
    public static  int largestRectanglularAreaInHistogram2(int[] hist) {
        final Stack<Integer> s = new Stack<>();

        int maxArea = 0;
        int tp;
        int areaWithTop;

        int i = 0;
        while (i < hist.length) {
            if (s.empty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            } else {
                tp = s.pop();
                int w = s.empty() ? i : i - s.peek() - 1;
                areaWithTop = hist[tp] * w;

                if (maxArea < areaWithTop)
                    maxArea = areaWithTop;
            }
        }

        while (!s.empty()) {
            tp = s.pop();
            int w = s.empty() ? i : i - s.peek() - 1;
            areaWithTop = hist[tp] * w;

            if (maxArea < areaWithTop)
                maxArea = areaWithTop;
        }

        return maxArea;
    }


    public static void main(String[] args) {
        int []hist= new int [] {2,3,1,4,5,4,2};
        //System.out.println(largestRectanglularAreaInHistogram1(hist));
        System.out.println(largestRectanglularAreaInHistogram2(hist));

    }
}
