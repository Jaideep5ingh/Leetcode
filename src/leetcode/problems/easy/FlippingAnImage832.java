package leetcode.problems.easy;

public class FlippingAnImage832 {
    public static void main(String[] args) {
        int[][] image =
                {
                        {1,1,0},
                        {1,0,1},
                        {0,0,0}
                };

        int rows = image.length;

        for(int i = 0 ; i<rows; ++i){
            int j = 0;
            int k = rows-1;
            int temp =0;

            while(j<k){
                temp = image[i][j];
                image[i][j] = image[i][k];
                image[i][k] = temp;

                image[i][j] = image[i][j] ==1? 0:1;
                image[i][k] = image[i][k] ==1? 0:1;

                ++j;
                --k;
            }
            if(rows%2!=0){
                image[i][j] = image[i][j] ==1? 0:1;
            }
        }

  for (int i = 0; i < rows; i++) {
   for (int j = 0; j < rows; j++) {
    System.out.print(image[i][j]);
    System.out.print(" ");
   }
   System.out.println();
  }
    }
}
