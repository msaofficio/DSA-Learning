
public class Sorting {

    public static void BubbleSort(int arr[],int len){
        for(int i=0;i<=len-2;i++){
            for(int j=i+1;j<=len-1;j++){
                if (arr[i]>arr[j]){
                    arr[i]=arr[i]+arr[j];
                    arr[j]=arr[i]-arr[j];
                    arr[i]=arr[i]-arr[j];
                }
            }
        }
    }
    
    public static void SelectionSort(int arr[],int len){
        for(int i=0;i<=len-2;i++){
            int minPosition = i;
            for(int j=i+1;j<=len-1;j++){
                if(arr[j]<arr[minPosition])
                minPosition=j;
            }
            //swaping for the ith position (not swapping everytime//only when the smallest element is found)
            int temp = arr[minPosition];
            arr[minPosition]=arr[i];
            arr[i]=temp;
        }
    }

    public static void InsertionSort(int arr[], int len) {
        for (int i = 1; i < len; i++) {
            int current = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > current) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = current;
        }
    }
    

    public static void main(String[] args) {
    int arr[] = {3,5,1,2,6,4};
    int len=arr.length;
    // BubbleSort(arr,len);   
    // SelectionSort(arr,len);
    // InsertionSort(arr, len);
    // MergeSort(arr,len);
    // QuickSort(arr,len);
    

    // printing 
    for(int i=0;i<len;i++){
        System.out.print(arr[i]+" ");
    }
    }

}