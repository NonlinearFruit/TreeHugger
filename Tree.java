class Tree{
	Tree parent;
	Tree leftChild;
	Tree rightChild;
	long value;

	public Tree(Tree origin)
	{
		parent = origin;
		value = 0;
	}

	public void setLeft(Tree n)
	{
		leftChild = n;
	}

	public void setRight(Tree n)
	{
		rightChild = n;
	}

	public Tree getParent()
	{
		return parent;
	}

	public Tree getLeft()
	{
		if(leftChild==null)
			leftChild = new Tree(this);
		return leftChild;
	}

	public Tree getRight()
	{
		if(rightChild==null)
			rightChild = new Tree(this);
		return rightChild;
	}

	public void increment(){ value++;      }
	public void decrement(){ value--;      }
	public long getValue() { return value; }
}