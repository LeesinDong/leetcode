package gupao;

public class WoodCut {
	public static void main(String[] args) {
		int[] L = {232,124,456};
		System.out.println(new WoodCut().woodCut(L, 7));
	}
	public int woodCut(int[] L, int k) {
		if (L == null || L.length == 0) {
			return 0;
		}
		int start = 1;
		int end = getMax(L);
		int mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			int pieces = getPieces(L, mid);
			// 木头的个数 >= k 即满足条件，就让它变得大一点
			if (pieces >= k) {
				start = mid;
			} else  {
				end = mid;
			}
			// 我认为这么写也对
			//	if (getSize(wood, mid) == target) {
			//                 return mid;
			//             } else if (getSize(wood, mid) < target) {
			//                 end = mid;
			//             } else {
			//                 start = mid;
			//             }
		}

		// 最后start >= end 了，哪个满足用哪个
		// >= ? 因为可以 > x 块
		if (getPieces(L, end) >= k) {
			return end;
		}
		if (getPieces(L, start) >= k) {
			return start;
		}
		return 0;
	}

	// 最大的木头
	public int getMax(int[] L) {
		int max = L[0];
		for (int i = 1; i < L.length; i++) {
			if (max < L[i]) {
				max = L[i];
			}
		}
		return max;
	}

	// 当前长度，能得到几块木头
	public int getPieces(int[] L, int woodLength) {
		int pieces = 0;
		for (int wood: L) {
			pieces += wood/woodLength;
		}
		return pieces;
	}
}
