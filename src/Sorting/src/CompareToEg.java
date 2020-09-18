import java.util.Comparator;

/**
 * @author c59785a
 * Created on 2020-09-05 18:11
 **/

import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {

        int retVal = a.score - b.score;
        if(retVal == 0){
            retVal = (b.name).compareToIgnoreCase(a.name);
        }
        if(retVal == 0){
            retVal =  0;
        }else if(retVal > 0){
            retVal =   -1;
        } else {
            retVal =   1;
        }
        return retVal;
    }
}

public class CompareToEg {

    public static void main(String[] args) {

        Player[] player = new Player[5];
        Checker checker = new Checker();
        player[0] = new Player("amy",100);
        player[1] = new Player("david",100);
        player[2] = new Player("heraldo",50);
        player[3] = new Player("aakansha",75);
        player[4] = new Player("aleksa",150);

        Arrays.sort(player, checker);

    }


}

