import java.util.ArrayList;
import java.util.List;

public class sort implements AdditionalSort{

    @Override
    public void selectionSort(List<Integer> nums) {
        System.out.println("Selection sort is sorting the items...");
        for(int i = 0; i < nums.size(); i++){
            int pos = i;
            for(int j = i; j < nums.size(); j++){
                if(nums.get(j) < nums.get(pos)){
                    pos = j;
                }
            }
            int min = nums.get(pos);
            nums.set(pos, nums.get(i));
            nums.set(i, min);
        }
    }

    @Override
    public void mergeSort(List<Integer> nums){
        System.out.println("Merge sort is sorting the items...");
        merge_Sort(nums);
    }

    @Override
    public void insertionSort(List<Integer> nums) {
       
        System.out.println("Insertion sort is sorting the items...");
        int length = nums.size();
        for(int i = 1; i < length;i++){
            int k = nums.get(i);
            int j = i - 1;

            while(j >= 0 && nums.get(j) > k){
                nums.set(j + 1, nums.get(j));
                j = j - 1;
            }

            nums.set(j + 1, k);
        }
    }

    private void merge_Sort(List<Integer> nums) {
        
        if (nums.size() <= 1) {
            return;
        }

        int mid = nums.size() / 2;

        List<Integer> left = new ArrayList<>(nums.subList(0, mid));
        List<Integer> right = new ArrayList<>(nums.subList(mid, nums.size()));

        merge_Sort(left);
        merge_Sort(right);

        merge(nums, left, right);
    }
    
    private static void merge(List<Integer> nums, List<Integer> left, List<Integer> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                nums.set(k++, left.get(i++));
            } else {
                nums.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            nums.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            nums.set(k++, right.get(j++));
        }
    }
}