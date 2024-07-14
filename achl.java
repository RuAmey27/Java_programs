import java.util.ArrayList;

class Solution {
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean check = checkExist(nums[i], a);
            if (!check) {
                a.add(nums[i]);
            } else {
                return nums[i];
            }
        }
        return 0;
    }

    public boolean checkExist(int a, ArrayList<Integer> b) {
        return b.contains(a);
    }
}
