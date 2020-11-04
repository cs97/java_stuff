public class baum1 {

	public static void main(String[] args) {
		//test
		Node t = new Node(null,4,null);
		t.insert(3);
		t.insert(7);
		t.insert(10);
		System.out.println(t.member(10));
		t.delete(7);
		System.out.println(t.member(10));
		t.print(t);
	}

}

class Node {
	int key;
	Node l,r;
	
	Node(Node l,int key,Node r) {
		this.key = key;
		this.l = l;
		this.r = r;
	}
	int get() {
		return key;
	}
	
	
	void print(Node x) {
		System.out.println(x.get());
		if(x.l != null) print(x.l);
		if(x.r != null) print(x.r);
	}
	
	boolean member(int x) {
		if(x == key) {
			return true;
			}else {
				if(x < key) {
					if(l == null) return false; else return l.member(x);
				} else {
					if(r == null) return false; else return r.member(x);
			}
		}
	}
	
	int deletmin() {
		int result;
		if (l == null ) {
			result = key;
			key = 0;
		
		}else {
			result = l.deletmin();
			if(l.key == 0) l = l.r;
		}
		return result;
	}
	
	Node delete(int x) {
		if(x < key) {
			if(l != null) l = l.delete(x);
			return this;
		}else if (key < x) {
			if(r != null) r = r.delete(x);
			return this;
		} else {
			if((l == null) && (r == null)) return null;
			else if(l == null) return r;
			else if(r == null) return l;
			else {
				key = r.deletmin();
				if(r.key == 0) r = r.r;
				return this;
			}
		}
	}
	
	Node insert(int x) {
		if(x == key) {
			return this;
		} else {
			if(x < key) {
				if(l == null) {
					l = new Node(null,x,null);
					return l;
				} else return l.insert(x);
			
			} else {
				if(r == null) {
					r =new Node(null,x,null);
					return r;
				}else return r.insert(x);
			}
		}	
	}
	
}


	
