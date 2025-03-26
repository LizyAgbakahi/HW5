/******************************************************************
 *
 *   YOUR NAME / SECTION NUMBER
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // Create a HashSet to store elements of list1 for O(1) lookup
        HashSet<Integer> set = new HashSet<>();
        for (int num : list1) {
            set.add(num);
        }

        // Verify if each element in list2 exists in the set
        for (int num : list2) {
            if (!set.contains(num)) {
                return false;
            }
        }

        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // Create a PriorityQueue with a max heap configuration
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements from the array into the max heap
        for (int num : array) {
            maxHeap.offer(num);
        }

        // Remove k-1 largest elements from the max heap (top 3)
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        // Return the root element of the max heap which is the k-th largest element
        return maxHeap.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // Create a PriorityQueue (min-heap) to store all elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all elements from the first array to the priority queue
        for (int num : array1) {
            pq.add(num);
        }

        // Add all elements from the second array to the priority queue
        for (int num : array2) {
            pq.add(num);
        }

        // Create a new array to store the sorted values
        int[] result = new int[array1.length + array2.length];
        int index = 0;

        // Remove elements from the priority queue and fill the result array
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }

        // Return the fully merged and sorted array
        return result;
    }

}