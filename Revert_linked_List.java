class Node {
    int value;
    Node nextNode, previousNode;

    public Node(int value) {
        this.value = value;
        this.nextNode = this.previousNode = null;
    }
}

class Main {
    public static Node push(Node head, int value) {
        Node node = new Node(value);
        node.nextNode = head;
        if (head != null) {
            head.previousNode = node;
        }
        head = node;
        return head;
    }

    public static void printResult(String message, Node head) {
        System.out.print(message);
        while (head != null) {
            System.out.printf("%d -> ", head.value);
            head = head.nextNode;
        }

        System.out.println("null");
    }

    public static void swap(Node node) {
        Node previousNode = node.previousNode;
        node.previousNode = node.nextNode;
        node.nextNode = previousNode;
    }

    public static Node reverse(Node head, Node currentNode) {
        if (currentNode.nextNode == null) {
            swap(currentNode);
            head = currentNode;
            return head;
        }
        swap(currentNode);
        head = reverse(head, currentNode.previousNode);
        return head;
    }

    public static Node reverse2WayList(Node head) {
        if (head == null) {
            return head;
        }
        Node currentNode = head;
        head = reverse(head, currentNode);
        return head;
    }

    public static void main(String[] args) {
        int[] my_list = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        Node head = null;
        for (int el : my_list) {
            head = push(head, el);
        }
        printResult("Связанный список исходный: ", head);
        head = reverse2WayList(head);
        printResult("Связанный список после разворота: ", head);
    }
}