import java.util.ArrayList;

public class Sort {
	private ArrayList<WebTree> WebTreeArray;
	
	public Sort(ArrayList<WebTree> WebTreeArray){
		this.WebTreeArray = WebTreeArray;
    }
	public void sort(){
		if(WebTreeArray.size() == 0)
		{
			System.out.println("InvalidOperation");
		}
		else 
		{
			sort(0, WebTreeArray.size()-1);
		}
	}
	
	public ArrayList<WebTree> getSort(){
		return WebTreeArray;
	}
	
	private void sort(int left, int right) {
	    if(left < right) { 
	       int q = partition(left,right); 
	       sort(left, q-1); 
	       sort(q+1, right); 
	    } 

	}

	private int partition(int left, int right) {  
	    int i = left - 1; 
	    for(int j = left; j < right; j++) { 
	    	if(WebTreeArray.get(j).getTreeScore()<= WebTreeArray.get(right).getTreeScore()) { 
	    		i++; 
	            swap(i, j); 
	        } 
	    } 
	    swap(i+1, right); 
	    return i+1; 
	    } 
	
	private void swap(int aIndex, int bIndex){
		WebTree temp = WebTreeArray.get(aIndex);
		WebTreeArray.set(aIndex, WebTreeArray.get(bIndex));
		WebTreeArray.set(bIndex, temp);
	}
}
