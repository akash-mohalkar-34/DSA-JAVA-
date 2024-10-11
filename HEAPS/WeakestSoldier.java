import java.util.PriorityQueue;

public class WeakestSoldier {

    public static class Row implements Comparable <Row>{
        int soldier ;
        int idx;

        public Row(int soldier , int idx ){
            this.soldier = soldier;
            this.idx = idx;
        }

        public int compareTo(Row s2){
            if(this.soldier == s2.soldier){
                return this.idx - s2.idx;
            }
            else{
                return this.soldier - s2.soldier;
            }
        }
    }
    public static void main(String args[]){
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0} };

                        int k = 2;
        PriorityQueue < Row > pq = new PriorityQueue<>();
        for(int i = 0 ; i < army.length ; i ++){
            int count = 0;
            for(int j = 0 ; j < army[0].length ; j++){
                count += army[i][j] == 1 ? 1 : 0;
            }

            pq.add(new Row(count, i));
        }                
       
        System.out.println();

        for(int i = 0 ; i < k; i++){
             System.out.println("R "+pq.remove().idx);  
        }

    }
}
