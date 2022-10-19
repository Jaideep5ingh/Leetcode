package leetcode.problems.medium;

//THE FUNCTION knows() WAS PROVIDED IN THE QUESTION.
public class FindTheCelebrity277 {
    public static void main(String[] args) {
        int numberOfPeople = 3;
        int candidate = 0;
        for (int i = 0; i < numberOfPeople; i++) {
            if (knows(candidate, i)){
                candidate = i;
            }
        }
        if (isCelebrity(candidate, numberOfPeople)) {
            System.out.println(candidate + " is a celebrity");
            System.exit(0);
        }
        System.out.println(candidate + " is not a celebrity");
    }

    private static boolean knows(int candidate, int i) {
    return false;
    }

    private static boolean isCelebrity(int candidate, int n) {
        for (int j = 0; j < n; j++) {
            if(candidate == j) continue;
            if(knows(candidate,j) || !knows(j, candidate)){
                return false;
            }
        }
        return true;
    }
}
