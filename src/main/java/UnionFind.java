import java.util.HashMap;
import java.util.Map;

class UnionFind {
	Map<Integer, Integer> father = new HashMap<>();
	public UnionFind(int n) {
		for (int i = 0; i < n; i++) {
			father.put(i, i);
		}
	}

	int find2(int x) {
		int parent = father.get(x);
		while (parent != father.get(parent)) {
			parent = father.get(parent);
		}

		int temp = -1;
		int fa = father.get(x);
		while (fa != father.get(fa)) {
			temp = father.get(fa);
			father.put(fa, temp);
			fa = temp;
		}
		return parent;
	}

	void union(int x, int y) {
		int fax = find2(x);
		int fay = find2(y);
		if (fax != fay) {
			father.put(fax, fay);
		}
	}
}