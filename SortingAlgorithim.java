import java.util.*;
public class SortingAlgorithim
{
	public static void main(String[] args) {
	int[] arr = {7,8,2,3,5,9,1,0};
	print_arr(arr);
	selection_sort(arr);
	bubble_sort(arr);
	selection_sort(arr);
	merge_sort(arr);
	}
	public static void selection_sort(int arr[])//Selection sort
	{
	    //creating a int var to store the length of array
	    int len = arr.length;
	    //two interator were needed to sort the array
	    //first interator starts with index pos 0
	    for(int i =0;i<len-1;i++)
	    {
	        //index pos saved in min_pos
	        int min_pos = i;
	        //Second interator starts from first interator + 1
	        for(int j =i+1;j<len;j++)
	        {
	            //updating the smallest int  index pos in min_pos
	            if(arr[min_pos]>arr[j])
	            {
	                min_pos=j;
	            }
	        }
	        //swapping the variables
	        int temp = arr[min_pos];
	        arr[min_pos] = arr[i];
	        arr[i]= temp;
	    }
	    //printing the array
	    print_arr(arr);
	    
	}
	public static void bubble_sort(int arr[])//Bubble sort
	{
	    //creating a int var to store the length of array
	    int temp =0,len = arr.length;
	    //main iterator 
	    for(int i=0;i<len;i++)
	    {
	        //secondary iterator to swap the values 
	        for(int j=0;j<len-1;j++)
	        {
	            //sorting the values through swapping
	            if(arr[j]>arr[j+1])
	            {
	                temp = arr[j];
	                arr[j] = arr[j+1];
	                arr[j+1]= temp;
	            }
	        }
	    }
	    //printing the values
	    print_arr(arr);
	}
	public static void insertion_sort(int arr[])
	{
	    //creating a int var to store the length of array
	    int len = arr.length;
	    //main iterator (starts from index 1)unsorted array
	    for(int i=1;i<len;i++)
	    {
	        //declaring the index of the sorted array
	        int j = i-1;
	        //storing the unsorted array value to a veraible for easy swapping
	        int current = arr[i];
	        //iterator for sorted arrays 
	        while(j>=0 && arr[j]>current);
	        {
	            arr[i] = arr[j];
	            j--;
	        }
	        //copying the value on new sorted array
	        arr[j+1] = current;
	    }
	    //printing the array
	    print_arr(arr);
	}
	public static void merge_sort(int arr[])
	{
	    
	    //mothod will be called recursively
	    int len = arr.length;
	    if(len<2)
	    {
	        return;
	    }
	    //find the mid_index or mid_pos
	    int mid_ind = len/2;
	    //create left arr and Right arr(left array size and right array size will varies)
	    int[] left_arr = new int[mid_ind];//Creating left arr
	    int[] right_arr = new int[len - mid_ind];//Creating right arr
	    //Storing elements in left arr
	    for(int i =0;i<mid_ind;i++)
	    {
	        left_arr[i] = arr[i];
	    }
	    //Storing elements in Right arr
	    for(int i =mid_ind;i<len;i++)
	    {
	       right_arr[i - mid_ind] = arr[i];
	    }
	    merge_sort(left_arr);
	    merge_sort(right_arr);
	    merge(arr,left_arr,right_arr);
	    print_arr(arr);
	    
	}
	public static void merge(int arr[],int left_arr[],int right_arr[])
	{
	    //Store length of left and Right Arrays
	    int left_size = left_arr.length;
	    int right_size = right_arr.length;
	    //Three iterating elemsnts were needed
	    int i=0,j=0,k=0;
	    //Iteration have to be done until completing left and right array
	    while(i<left_size && j< right_size)
	    {
	        //comparing left and right side elements if left side has the smallest eleement then adding to main array
	        if(left_arr[i]<=right_arr[j])
	        {
	            arr[k] = left_arr[i];
	            i++;
	        }
	         //comparing left and right side elements if Right side has the smallest eleement then adding to main array
	        else{
	            arr[k] = right_arr[j];
	            j++;
	        }
	        //Iterating main array
	        k++;
	    }
	    //to add rest of the elements from left array(if it is present)
	    while(i<left_size)
	    {
	        arr[k] = left_arr[i];
	        i++;
	        k++;
	  }
	  //to add rest of the elements from rightt array(if it is present)
	  while(j < right_size)
	    {
	        arr[k] = right_arr[j];
	        j++;
	        k++;
	  }
	}
	//function to print array
	public static void print_arr(int arr[])
	{
	    System.out.println();
	  System.out.print("[ ");
	    for(int a:arr)
	    {
	        System.out.print(a+" ");
	    }
	    System.out.print("]");
	}
}
