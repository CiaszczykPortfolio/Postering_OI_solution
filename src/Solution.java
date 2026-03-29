import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static int naiveSolve(BufferedReader br) throws IOException {
        class Node {
            int value;
            Node Next;

            public Node(int value, Node Next){
                this.value = value;
                this.Next = Next;
            }
        }

        int n = Integer.parseInt(br. readLine());
        Node head = null;

        int posters = 0;

        for(int i=0;i<n;i++){
            String line = br.readLine();
            StringTokenizer lineToken = new StringTokenizer(line);
            lineToken.nextToken();
            int val = Integer.parseInt(lineToken.nextToken());
            while(head != null && head.value>val){
                head = head.Next;
            }
            if(head == null || head.value != val){
                head = new Node(val, head);
                posters++;
            }
        }
        return posters;        
    }

    public static int binarySearchSolve(BufferedReader br) throws IOException {
        class BinarySearch{
            static int binarySearch(int[] list, int Size, int searched){
                int left = 1;
                int right = Size;
                while(left!=right){
                    int checked = (left + right)/2;
                    if(list[checked]<searched)
                        left = checked+1;
                    else right = checked;
                }
                return left;
            }
        }

        int n = Integer.parseInt(br. readLine());
        int[] list = new int[n+1];

        int posters = 0;
        int listSize = 0;

        for(int i=0;i<n;i++){
            String line = br.readLine();
            StringTokenizer lineToken = new StringTokenizer(line);
            lineToken.nextToken();
            int val = Integer.parseInt(lineToken.nextToken());
            if( val > list[listSize]){
                list[++listSize]=val;
                posters++;
            } else {
                listSize = BinarySearch.binarySearch(list, listSize, val);
                if(list[listSize] != val){
                    list[listSize]=val;
                    posters++;
                }
            }
        }

        return posters;  

    }

    public static int exponentialSearchSolve(BufferedReader br) throws IOException {
        class ExponentialSearch{
            static int binarySearch(int[] list, int left, int right, int searched){
                while(left!=right){
                    int checked = (left + right)/2;
                    if(list[checked]<searched)
                        left = checked+1;
                    else right = checked;
                }
                return left;
            }

            static int exponentialSearch(int[] list, int size, int searched){
                int index=1;
                int last=0;
                while(index <= size && list[index]<searched){
                    last=index;
                    index*=2;
                }
                if(index>size)
                    index=size;
                index = binarySearch(list, last, index, searched);

                return index;
            }
        }

        int n = Integer.parseInt(br. readLine());
        int[] list = new int[n+1];

        int posters = 0;
        int listSize = 0;

        for(int i=0;i<n;i++){
            String line = br.readLine();
            StringTokenizer lineToken = new StringTokenizer(line);
            lineToken.nextToken();
            int val = Integer.parseInt(lineToken.nextToken());
            if( val > list[listSize]){
                list[++listSize]=val;
                posters++;
            } else {
                listSize = ExponentialSearch.exponentialSearch(list, listSize, val);
                if(list[listSize] != val){
                    list[listSize]=val;
                    posters++;
                }
            }
        }

        return posters;  

    }

}