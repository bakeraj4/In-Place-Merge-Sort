/**
 *This is my version of an in place merge sort. 
 * @author Aaron Baker
 *
 */
public class mergeMain {
	/**
	 * This main creates a random array size from [2,16] with random integers from [0,1000]. Then prints the data as an initial 
	 * permutation, in place merge the integers, then finally prints the final data of the array. 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr=new int[((int)(14*Math.random()))+2];//at least 2 elements with a maximum of 16 elements
		for(int i=0;i<arr.length-1;i++){
			arr[i]=((int)(1000*Math.random()));
		}
		printAllElements(arr);//before
		mergeSort(arr,0,arr.length-1);
		printAllElements(arr);//after
	}
	/**
	 * The actual merge sort algorithm.
	 * @param ints The integer array being sorted.
	 * @param min The minimum index to be sorted.
	 * @param max The maximum index to be sorted.
	 */
	static void mergeSort(int[] ints,int min,int max){
		if(max-min==0){//only one element.
			//no swap
		}
		else if(max-min==1){//only two elements and swaps them
			if(ints[min]>ints[max])
				swap(ints,min,max);
		}
		else{
			int mid=((int) Math.floor((min+max)/2));//The midpoint
			
			mergeSort(ints,min,mid);//sort the left side
			mergeSort(ints,mid+1,max);//sort the right side
			merge(ints,min,max,mid);//combines them
		}
	}
	/**
	 * The merge method combines the two sorted portions of the game.
	 * @param ints The integer array being merged.
	 * @param min The minimum index to be merged.
	 * @param max The maximum index to be merged.
	 * @param mid The mid point in the section of the array to be merged. It's also the last index of the left portion of the array
	 * and mid+1 is the first index in the right portion.
	 */
	static void merge(int[]ints,int min,int max,int mid){
		int i=min;
		while(i<=mid){
			if(ints[i]>ints[mid+1]){
				swap(ints,i,mid+1);
				push(ints,mid+1,max);
			}			
			i++;
		}		
	}
	/**
	 * Swaps two elements in the given array.
	 * @param ints The integer array that will have the elements to swap.
	 * @param loc1 The index of an integer to swap.
	 * @param loc2 The index of an integer to swap.
	 */
	static void swap(int[] ints,int loc1,int loc2){
		//cool way of swapping integers from http://ideone.com/x81fUl
		/*
		 * a=a^b;
		 * b=a^b;
		 * a=a^b;
		 */
		ints[loc1]=ints[loc1]^ints[loc2];
		ints[loc2]=ints[loc1]^ints[loc2];
		ints[loc1]=ints[loc1]^ints[loc2];
	}
	/**
	 * Prints all of the elements in the integer array passed in.
	 * @param ints The integer array passed in.
	 */
	static void printAllElements(int[] ints){
		for(int i=0;i<ints.length;i++){
			System.out.print(ints[i]+", ");
		}
		System.out.print("\n");
	}
	/**
	 * Puts the largest value at the end of the array. Used in the merge method after a swap of sorted array portions. An example
	 * would be {5,6,7,8,1,2,3,4} left {5,6,7,8} and right {1,2,3,4} and 1<5 so they will swap. Left {1,6,7,8} and right {5,2,3,4}
	 * and push will allow it to be {1,6,7,8} left and {2,3,4,5} right.
	 * @param ints The array of integers that will be pushed.
	 * @param s The start index of the push.
	 * @param e The end index of the push.
	 */
	static void push(int[] ints,int s,int e){
		for(int i=s;i<e;i++){
			if(ints[i]>ints[i+1])
				swap(ints,i,i+1);
		}
	}
}