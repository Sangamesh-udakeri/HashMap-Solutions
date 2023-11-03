package hashmap;

import java.util.HashMap;

public class Practice {

	public int[] twoSum(int a[], int target) {

		int b[] = new int[2];
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < a.length; i++) {

			if (!hashMap.isEmpty() && hashMap.containsKey(a[i])) {

				b[0] = hashMap.get(a[i]);
				b[1] = i;

				return b;
			} else {

				hashMap.put(target - a[i], i);
			}

		}
		return b;
	}

	public int longestSubstringWithoutRepeatingCharacters(String s) {

		HashMap<Character, Integer> hashMap = new HashMap<>();
		int j = 0;
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {

			Character ch = s.charAt(i);

			while (!hashMap.isEmpty() && hashMap.containsKey(ch) && hashMap.get(ch) > 0) {

				hashMap.put(s.charAt(j), hashMap.getOrDefault(s.charAt(j), 0) - 1);
				if (hashMap.get(s.charAt(j)) == 0) {

					hashMap.remove(s.charAt(j));
				}
				j++;
			}
			hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
			ans = Math.max(ans, hashMap.size());
		}
		return ans;
	}

	public int minimumWindowSubString(String s, String t) {

		int min = Integer.MAX_VALUE;
		int j = 0;
		int c = t.length();
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {

			while (hashMap.containsKey(s.charAt(i)) && c > 0) {

				if (hashMap.get(s.charAt(i)) == 1) {

					hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) - 1);
					c--;
				} else if (hashMap.get(s.charAt(i)) > 1) {
					hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) - 1);

				}

			}
			if (c == 0) {

				min = Math.min(min, i - j + 1);
			}
		}

		return min;
	}

	
	public int longestSubstringWithUniqueCharacter(String s) {

		int j = 0;
		int max = 0;
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {

			hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1); 

			if ( hashMap.get(s.charAt(i)) > 1) {
			
				max = Math.max(max, (i - j) + 1);
				while (hashMap.get(s.charAt(i)) > 1) {
					hashMap.put(s.charAt(j), hashMap.getOrDefault(s.charAt(j), 0) - 1);
					j++;
				}
			}

		}
		return max;
	}

}
