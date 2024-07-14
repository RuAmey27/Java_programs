/**
 * Node
 */
class Node {
    int left;
    int right;
    int[] array_state;
    Node next;

    Node(int L, int R, int[] arr) {
        this.left = L;
        this.right = R;
        this.array_state = arr.clone();
        this.next = null;
    }

} // Represents the state variable used in loops

/**
 * LinkedList
 */
class LinkedList {
    Node head;

    void addNode(int L, int R, int[] arr) {
        Node newNode = new Node(L, R, arr);
        if (head == null) {
            head = newNode;
        } else {
            // head.next=newNode; use of direct this can cause error as it replace only head
            // next pointer with newnode pointer but we need to find position where next is
            // null and we can add next node
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    void printlist() {
        Node currentPointer = head;
        while (currentPointer != null) {
            System.out.println("Left index=" + currentPointer.left + " Right index=" + currentPointer.right
                    + "the current arraystate=" + currentPointer.array_state.toString());
            currentPointer = currentPointer.next;
        }
    }

}

/**
 * segeregate01s
 */
class segeregate01s {
        LinkedList tracer=new LinkedList();

        void segregate0and1(int[] input){
            int Left=0;
            int Right=input.length-1;


            //add initial state
            tracer.addNode(Left, Right, input);


            while (Left<Right) {
                while (input[Left] == 0 && Left < Right) {
                    Left++;
                    tracer.addNode(Left, Right, input);
                }

                while (input[Right] == 1 && Left < Right) {
                    Right--;
                    tracer.addNode(Left, Right, input);
                }

                if(Left<Right){
                    input[Left]=0;
                    input[Right]=1;
                    tracer.addNode(Left, Right, input);//state
                    Left++;
                    Right--;
                    tracer.addNode(Left, Right, input);//state after swap
                }
            }
        }
}



class Main {
    public static void main(String[] args) {
        // int[] arr = {0, 1, 0, 1, 1, 0, 0, 1, 1, 0};
        int[] arr = {0, 0, 1, 1, 0};
        segeregate01s solution = new segeregate01s();
        solution.segregate0and1(arr);

        // Print the linked list trace
        solution.tracer.printlist();
    }
}

