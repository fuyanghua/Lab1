
public class MERGE_SORT {
	public static void main(String[] args){
		long start=System.nanoTime();
		int array[] = new int[300];
		for(int i = 0;i < 300;i++){
			array[i] = (int)(Math.random()*300);
		}
		for(int i = 0;i < array.length;i++){
			System.out.print(array[i]+",");
		}
		System.out.println();
		merge_sort(array,0,array.length-1);
		long end=System.nanoTime(); 
		System.out.println("Runs "+(end-start)+" ns");
		for(int i = 0;i < array.length;i++){
			System.out.print(array[i]+",");
		}
	}
	
	public static void merge_sort(int array[],int array_begin,int array_over){
		if(array_begin<array_over){
			int array_cut = (array_begin+array_over)/2;
			merge_sort(array,array_begin,array_cut);
			merge_sort(array,array_cut+1,array_over);
			merge_sort(array,array_begin,array_cut,array_over);
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
}
