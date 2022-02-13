package leetcode.problems.medium;
//Implemented this to detect a single cycle and
//missed the part where the question said : " repeats them forever."

public class RobotBoundedInCircle1041_singleCycle {
    public static void main(String[] args) {
        String instructions = "GG";
        int[] currentPosition= {0,0};
        Node head = new Node("North");
        Node east = new Node("East");
        Node west = new Node("West");
        Node south = new Node("South");

        head.rightNode = east;head.leftNode = west;
        west.rightNode = head;west.leftNode = south;
        east.rightNode = south;east.leftNode = head;
        south.rightNode = west;south.leftNode = east;

        Node currentDirection = head;
        for(char c: instructions.toCharArray()){
            if (c!='G'){
                currentDirection = direction(currentDirection,c);
            }else{
                currentPosition = move(currentDirection,currentPosition);
            }
            if(currentPosition[0]==0 & currentPosition[1]==0){
                System.out.println("Circle exists");
                break;
            }
        }
    }

    public static Node direction(Node current, char instruction){
        return instruction=='L' ? current.leftNode : current.rightNode;
    }

    public static int[] move(Node currentDirection, int[] currentPosition){
        if (currentDirection.value == "North"){
            currentPosition[1]++;
        } else if (currentDirection.value == "West") {
            currentPosition[0]--;
        } else if (currentDirection.value == "East") {
            currentPosition[0]++;
        } else if (currentDirection.value == "South") {
            currentPosition[1]--;
        }
        return currentPosition;
    }
}

class Node{
    String value;
    Node rightNode;
    Node leftNode;

    public Node(String value) {
        this.value = value;
    }
}