public class Braket

{

    public static void main(String[] args) {


        //30, 10, 1, 3, 8, 9
        int []arr={30,10,1,3,8,9};

        for (int i=0;i<arr.length;i++){
            for(int j=0; j<arr.length -i -1;j++){

                if(arr[i] > arr[j+1]){
                    int temp= arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
     }
        for(int s :arr){
            System.out.println("Sorted are"+s);
        }
    }




























}
