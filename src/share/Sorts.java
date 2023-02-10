package share;

import java.util.Arrays;

public class Sorts {
    /**
     * Selection Sort 选择排序
     * 简介：把最小的排最前面
     */
    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    /**
     * Insertion Sort 插入排序
     * 简介：把当前值插到前面已排好序的相应位置
     */
    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > current) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = current;
        }
        return nums;
    }

    /**
     * Bubble Sort 冒泡排序
     * 简介：比较大小，把最大的放到最后。
     */
    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * Heap Sort 堆排序
     * 简介： 使用大顶堆排序，然后把最大的元素 0 置放到最后 length -1
     */
    public int[] heapSort(int[] nums) {
        int length = nums.length;
        // 从第一个非叶子结点从下至上，从右至左调整结构
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, length, i);
        }
        // 调整堆结构+交换堆顶元素与末尾元素
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
        return nums;
    }

    private void heapify(int[] nums, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < length && nums[left] > nums[largest]) largest = left;
        if (right < length && nums[right] > nums[largest]) largest = right;

        if (i != largest) {
            swap(nums, i, largest);
            heapify(nums, length, largest);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Counting Sort 计算排序
     * 简介：计数排序不是基于比较的排序算法, 而是将输入的数据值转化为键存储在额外开辟的数组空间中.
     * Time: O(n)
     * Space: O(n)
     */
    public int[] countingSort(int[] nums, int max) {
        int[] temp = new int[max + 1];

        for (int num : nums) temp[num]++;

        int n = 0;
        for (int i = 0; i < temp.length; i++) {
            while (temp[i]-- > 0) nums[n++] = i;
        }
        return nums;
    }


    public static void main(String[] args) {
        Sorts sorts = new Sorts();
        int[] nums = {5, 2, 3, 9, 4, 3, 6, 8, 6, 7, 1};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sorts.selectionSort(nums)));
        //System.out.println(Arrays.toString(sorts.insertionSort(nums)));
        //System.out.println(Arrays.toString(sorts.bubbleSort(nums)));
        //System.out.println(Arrays.toString(sorts.heapSort(nums)));
        //System.out.println(Arrays.toString(sorts.countingSort(nums, 9)));
    }
}
