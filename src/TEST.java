
public class TEST {
	public static void main(String[] args){
		for(int n = 1;n < 500;n++){
			long time = Integer.MAX_VALUE;
			long thistime = Integer.MAX_VALUE;
			int thisk = 0;
			for(int k = 1;k < n;k++){
				thistime = combine_sort(n,k);
				if(time > thistime){
					time = thistime;
					thisk = k;
				}
			}
			System.out.println("while n is "+n+" ,k should be "+thisk);
		}
	}
	
	public static long combine_sort(int n,int k){
		long start=System.nanoTime();
		int array[] = new int[n];
		for(int i = 0;i < n;i++){
			array[i] = (int)(Math.random()*n);
		}
		merge(array,0,array.length-1,k);
		long end=System.nanoTime(); 
		return (end-start);
	}
	
	public static void merge(int array[],int array_begin,int array_over,int k){
		if(array_over - array_begin - k >= 0){
			int array_cut = (array_begin+array_over)/2;
			merge(array,array_begin,array_cut,k);
			merge(array,array_cut+1,array_over,k);
			merge_sort(array,array_begin,array_cut,array_over);
		}
		else{
			insertion_sort(array);
		}
	}
	
	public static void merge_sort(int array[],int array_begin,int array_cut,int array_over){	
		int first_line_length = array_cut - array_begin + 1;
		int second_line_length = array_over - array_cut;
		int first_line[] = new int[first_line_length+1];
		int second_line[] = new int[second_line_length+1];
		for(int i = 0;i < first_line_length;i++){
			first_line[i] = array[array_begin+i];
		}
		for(int i = 0;i < second_line_length;i++){
			second_line[i] = array[array_cut+i+1];
		}
		first_line[first_line_length] = Integer.MAX_VALUE;
		second_line[second_line_length] = Integer.MAX_VALUE;
		int first_line_number = 0;
		int second_line_number = 0;
		for(int k = array_begin;k <= array_over;k++){
			if(first_line[first_line_number] <= second_line[second_line_number]){
				array[k] = first_line[first_line_number];
				first_line_number++;
			}
			else{
				array[k] = second_line[second_line_number];
				second_line_number++;
			}
		}
	}
	
	public static void insertion_sort(int array[]){
		for(int j = 1;j < array.length;j++){
			int key = array[j];
			int i = j-1;
			while((i >= 0)&&(array[i]>key)){
				array[i+1] = array[i];
				i--;
			}
			array[i+1] = key;
		}
	}
}
