package algorithm;

/**
 * created by niket.shah on 15/05/20
 */
public class SymmetricDifferenceArray {

    public static void main(String[] args) {
        int[] arr1 = {1,4,5};
        int[] arr2 = {2,4,6,8,9,10};
        symmetricDiff(arr1,arr2);
    }

    public static void symmetricDiff(int[] arr1,int arr2[]){

        int i = 0 ,j = 0;
        while (i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
            }else if(arr2[j] < arr1[i]){
                System.out.print(arr2[j] + " ");
                j++;
            }else{
                i++; j++;
            }
        }

        if(i < arr1.length){
            for(int k=i;k<arr1.length;k++) System.out.print(arr1[k] + " ");
        }

        if(j < arr2.length){
            for(int k=j;k<arr2.length;k++) System.out.print(arr2[k] + " ");
        }
    }
}
