package leetcode_codebase;
import java.util.Scanner;

public class MergeSortedArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) {
            return;
        }
        int last = m + n - 1;
        while(n>0 && m>0) {
            if(nums2[n-1]>=nums1[m-1]) {
                nums1[last] = nums2[n-1];
                n--;
            }else {
                nums1[last] = nums1[m-1];
                m--;
            }
            last--;
        }
        while(n>0) {
            nums1[last] = nums2[n-1];
            n--;
            last--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums1 = new int[m+n];
        int[] nums2 = new int[n];
        for (int i=0;i<m;i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i=0;i<n;i++) {
            nums2[i] = sc.nextInt();
        }
        MergeSortedArray ans = new MergeSortedArray();
        ans.merge(nums1,m,nums2,n);
        System.out.print("Merged array: ");
        for(int num : nums1) {
            System.out.print(num+" ");
        }
    }
}
