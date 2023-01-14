// Number of Pairs satisfying Inequality

public class NumberOfPairsSatisfyingInequality {
    long count = 0;

    void checkCount(List<Integer> nums, int start, int mid, int end, int diff) {
        int l = start, r = mid + 1;
        while (l <= mid && r <= end) {
            if (nums.get(l) <= (nums.get(r) + diff)) {
                count += (end - r + 1);
                l++;
            } else {
                r++;

            }
        }
        List<Integer> sub = new ArrayList<>();
        for (int i = start; i < end + 1; i++) {
            sub.add(nums.get(i));

        }
        Collections.sort(sub);
        for (int i = start; i < end + 1; i++) {
            nums.set(i, sub.get(i - start));
        }
        return;
    }

    void mergeSort(List<Integer> nums, int start, int end, int diff) {
        if (start == end)
            return;

        int mid = (start + end) / 2;
        mergeSort(nums, start, mid, diff);
        mergeSort(nums, mid + 1, end, diff);

        checkCount(nums, start, mid, end, diff);
        return;
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        count = 0;
        int n = nums1.length;
        List<Integer> diffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            diffList.add(nums1[i] - nums2[i]);
        }
        mergeSort(diffList, 0, n - 1, diff);
        return count;

    }
}
