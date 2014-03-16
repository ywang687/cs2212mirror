package ca.uwo.csd.cs2212.team5;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * AVLTree class represents an AVL tree made up of AVL nodes
 */
public class AVLTree implements AVLTreeInterface{

	private Comparator comparator;
	private AVLnode root;

	private int count = 0;

	public AVLTree(Comparator comparator) {
		this.comparator = comparator;
		this.root = new AVLnode(null, null, null, null);
	}

	public boolean external(Position p) {
		AVLnode tmp = (AVLnode)p;

		if(tmp.left()==null || tmp.right()==null){
			return true;
		}
		if (tmp != null) {
			if (tmp.left().getEntry() == null && tmp.right().getEntry() == null)
				return true;
		}

		return false;
	}

	public Position left(Position p) {
		AVLnode tmp = (AVLnode)p;
		AVLnode parent = findNode(tmp.getEntry().key());

		if (parent.getEntry() == null)
			return null;

		return (Position)parent.left();
	}

	public Position right(Position p) {
		AVLnode tmp = (AVLnode)p;
		AVLnode parent = findNode(tmp.getEntry().key());

		if (parent.getEntry() == null)
			return null;

		return parent.right();
	}

	public Position giveRoot() {
		return (Position)root;
	}

	public int size() {
		return count;
	}

	public int treeHeight() {
		return 0;
	}

	public boolean isEmpty() {
		return (size() <= 0);
	}

	public DictEntry find(Object key) {
		AVLnode tmp = findNode(key);

		return tmp.getEntry();
	}

	public void modifyValue(Object key, Object valueNew) throws AVLtreeException{
		AVLnode tmp = findNode(key);

		if (tmp.getEntry() != null)
			tmp.setEntry(new DictEntry(key, valueNew));
		else
			throw new AVLtreeException("Element doesn't exist!");
	}

	public void insertNew(Object key, Object value) {
		DictEntry toAdd = new DictEntry(key, value);

		AVLnode pos = findNode(key);

		if (pos.getEntry() != null)
			throw new AVLtreeException("Element already exists!");

		pos.setEntry(toAdd);
		pos.setLeft(new AVLnode(null, pos, null, null));
		pos.setRight(new AVLnode(null, pos, null, null));
		recalculateHeights(pos);
		count++;
	}

	public DictEntry remove(Object key) throws AVLtreeException{
		AVLnode tmp = findNode(key);

		DictEntry toReturn = tmp.getEntry();

		if (tmp.getEntry() != null){
			AVLnode nLarge = nextLargest(tmp);
			AVLnode nSmall = nextSmallest(tmp);
			if (nLarge == null) {
				if (nSmall == null) {
					int cvalue = comparator.compare(tmp.getEntry().key(), tmp.parent().getEntry().key());

					if (cvalue > 0) {
						tmp.parent().setRight(new AVLnode(null, tmp.parent(), null, null));
					}
					else if (cvalue < 0) {
						tmp.parent().setLeft(new AVLnode(null, tmp.parent(), null, null));
					}
					count--;
					recalculateHeights(tmp.parent());
					return toReturn;
				}
				else{
					remove(nSmall.getEntry().key());
					tmp.setEntry(nSmall.getEntry());
					recalculateHeights(nSmall.parent());
					return toReturn;
				}
			}
			else{
				remove(nLarge.getEntry().key());
				tmp.setEntry(nLarge.getEntry());
				recalculateHeights(nLarge.parent());
				return toReturn;
			}
		}
		else{
			throw new AVLtreeException("Element doesn't exist!");
		}
	}

	public Iterator<DictEntry> inOrder() {
		LinkedList<DictEntry> toReturn = new LinkedList<DictEntry>();

		inOrder(toReturn, root);

		return toReturn.iterator();
	}

	private void inOrder(LinkedList<DictEntry> llist, AVLnode start) {
		if (start.getEntry() != null) {
			inOrder(llist, start.left());
			llist.add(start.getEntry());
			inOrder(llist, start.right());
		}
	}

	public Iterator<DictEntry> findnLargestKeys(int k) {
		LinkedList<DictEntry> toReturn = new LinkedList<DictEntry>();

		findnLargestKeys(toReturn, root, k);

		return toReturn.iterator();
	}

	private void findnLargestKeys(LinkedList<DictEntry> llist, AVLnode start, int k) {
		if (start.getEntry() != null && llist.size() <= k) {
			findnLargestKeys(llist, start.right(), k);
			if (llist.size() <= k){
				llist.add(start.getEntry());
				findnLargestKeys(llist, start.left(), k);
			}
		}
	}

	private AVLnode nextLargest(AVLnode ref) {
		if (external(ref))
			return null;

		AVLnode tmp = ref.right();

		while (tmp.getEntry() != null) {
			tmp = tmp.left();
		}

		return tmp.parent();
	}

	private AVLnode nextSmallest(AVLnode ref) {
		if (external(ref))
			return null;

		AVLnode tmp = ref.left();

		while (tmp.getEntry() != null) {
			tmp = tmp.right();
		}

		return tmp.parent();
	}
	
	private void recalculateHeights(AVLnode ref) {
		AVLnode tmp = ref;
		
		while (tmp != root) {
			tmp.resetHeight();
			tmp = tmp.parent();
		}
		
		tmp.resetHeight();
	}


	private AVLnode findNode(Object key) {
		AVLnode tmp = root;

		while (tmp.getEntry() != null) {
			int cvalue = comparator.compare(tmp.getEntry().key(), key);

			if (cvalue == 0)
				return tmp;

			else if (cvalue > 0)
				tmp = tmp.left();

			else
				tmp = tmp.right();

		}

		return tmp;
	}
}