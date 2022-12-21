/**
 * Name: Eric Petersen
 * Student number: 20071924
 * Date: September 14, 2022
 * Purpose: Check if a given List of Integers is closed under addition for some modulus n. Addition is closed for a list
 * if for each distinct index i and j, k * n + (listInt[i]+listInt[j]) % n is in the list, where k is any integer
 * Input: list of integers to check, modulus n
 */

package additionClosure;

import java.util.List;

public class AdditionClosure {

	/**
	 * Check if a given List of Integers is closed under addition for some modulus n.
	 * @param intList, list of integers to check
	 * @param n, modulus to check for addition closure
	 * @return true if list is closed under addition, false otherwise
	 */
	public static boolean isClosed(List<Integer> intList, Integer n) {
		for (int i = 0; i < intList.size() - 1; i++) {
			for (int j = i + 1; j < intList.size(); j++) {
				if (!checkPair(i, j, n, intList)) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Check if a pair of numbers has a corresponding term in intList
	 * @param i, index of first number in pair being compared
	 * @param j, index of second number in pair being compared
	 * @param n, modulus of comparison
	 * @param intList, list from which to check pairs
	 * @return return true if pair has a corresponding term in intList, false otherwise
	 */
	private static boolean checkPair(int i, int j, Integer n, List<Integer> intList) {

		int modulus = (intList.get(i) + intList.get(j)) % n;

		for (int k: intList) {
			if (k % n == modulus) {
				return true;
			}
		}

		return false;
	}
}