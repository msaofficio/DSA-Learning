public class Arrays {

    //1D Arrays

    public static void arrayPairs(int numbers[]){
        int len = numbers.length;
        for(int i=0;i<len;i++){
            int current = numbers[i];
            for(int j=i+1;j<len;j++){
                System.out.print("("+current+"," +numbers[j] + ")");
        }
        System.out.println();
    }}
    public static void subArrays(int number[]){
        for(int i=0; i<number.length;i++){
            for(int j=i+1;j<number.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(number[k]+" ");

            }
            System.out.println();
        }}
    }
    public static void maxsubArraysSum(int number[]){
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<number.length;i++){
            for(int j=i+1;j<number.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    System.out.print(number[k]+" ");
                    sum = sum+number[k];
                }
                if (max<sum)
                max = sum;
                System.out.println();
            }
        }    
        System.out.print("Maximum subarray sum is : "+max);
    }
    
    public static void maxsubArraysSumPrefix(int number[]){
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        int prefix_array[]=new int[number.length];
        prefix_array[0]=number[0];
        for(int i=1;i<number.length;i++){
            prefix_array[i]=prefix_array[i-1]+number[i];
        }
        for(int i=0;i<number.length;i++){
            for(int j=0;j<number.length;j++){
                currSum =(i==0)?prefix_array[j]: prefix_array[j]-prefix_array[i-1];
                if (maxSum<currSum){
                maxSum = currSum;}
            }
        }
        System.out.print("Maximum subarray sum is : "+maxSum);
    }

    public static void maxsubArraysSumKadane(int number[]){
        int maxSum = Integer.MIN_VALUE, currentSum=0;
        for(int i=0;i<number.length;i++){
            currentSum+=number[i];
            if (currentSum<0)
            currentSum=0;
            if (maxSum<currentSum)
            maxSum = currentSum;
        }
    System.out.println("Maximum subarray sum is : "+maxSum);
    }

    public static int rainWaterTrapping(int height[]) {
        int len=height.length;
        //left max boundary
        int leftmax[] = new int[len];
        leftmax[0]=height[0];
        for(int i=1;i<len;i++){
            leftmax[i]=Math.max(height[i],leftmax[i-1]);
        }
        //rightmax boundary
        int rightmax[] = new int[len];
        rightmax[len-1]=height[len-1];
        for(int i=len-2;i>=0;i--){
            rightmax[i]=Math.max(height[i],rightmax[i+1]);
        }
        int trappedwater=0;
        //loop
        for(int i=0;i<len;i++){
            //waterlevel = min(leftmax,rightmax)
            // trappedwater = waterlevel - height of bar [i]
            trappedwater+=Math.min(leftmax[i],rightmax[i]) - height[i];
        }
        return trappedwater;
    }

    // public static int buyANDsellSTOCKS(prices[]){
    //     int maxProfit=Integer.MAX_VALUE;
    // }

    // 2D Arrays

    public static void printing(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void maxMin(int arr[][]){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if (arr[i][j]>max)
                max=arr[i][j];
                if (arr[i][j]<min)
                min=arr[i][j];
            }
        }
        System.out.println("Maximum element in Array is "+max+" and Minimum is "+min);
    }

    public static int targetoccurence(int arr2[][],int target){
        int occur=0;
        int sum=0;
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr2[0].length;j++){
                if (arr2[i][j]==target)
                occur++;
                if(i==1){
                    sum+=arr2[i][j];
                }
            }
        }
        System.out.println("Sum of second row is "+sum);
        return occur;
    }
    
    public static void transpose(int arr[][]){
        int row=arr.length,col=arr[0].length;
        int transpose[][] = new int[col][row];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                transpose[j][i]=arr[i][j];
            }
        }
        System.out.println("original Array is :");
        printing(arr);
        System.out.println("Transposed Array is : ");
        printing(transpose);
    }
    
    


    public static void main(String[] args) {
        // int arr[] = {4,2,1,6,3,2,5};
        // arrayPairs(arr);
        // subArrays(arr);
        // maxsubArraysSum(arr); //(BruteForceMethod)(O(n3))
        // maxsubArraysSumPrefix(arr); //(PrefixArrayMethod)(O(n2))
        // maxsubArraysSumKadane(arr); //(KardansAlgorithm)(O(n))
        // System.out.println(rainWaterTrapping(arr));
        // System.out.println(buyANDsellSTOCKS(arr));
        
        // int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        // int arr2[][]={{4,7,8},{3,7,4}};
        // maxMin(arr);
        // System.out.println(targetoccurence(arr2,7));
        // transpose(arr);
    }
}