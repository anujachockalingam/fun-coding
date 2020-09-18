package HackerRank.Search;

/**
 * @author c59785a
 * Created on 2020-09-16 16:44
 * https://www.hackerrank.com/challenges/making-candies/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 *
 *
 **/
public class MakingCandies {

    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {

        long numCandies = 0;
        int passNum = 0;

        while (numCandies < n){
            //maximize  spliting numCandies/p between m & w such tht m*w is max;
            //reduce (1 to numCandies)to numbers div by p
            long max =0;
            long numCandiesM = 0;
            long numCandiesW =0;
            for(int i=1; i<= numCandies; i++){
                //check the max 'm*'w
                if(i%p ==0 && (numCandies-i)%p ==0) {
                    max = Math.max(max, (m + i / p) * (m + (numCandies - i) / p));
                }
            }

            numCandies = max;
            passNum++;
        }
        return 0;
    }

}
