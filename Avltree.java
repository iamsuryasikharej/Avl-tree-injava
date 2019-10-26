
public class Avltree {
	AvlNode root;
	public void insert(int item)
	{
		
			this.root=insertNode(this.root,item);
		
	}
	private AvlNode insertNode(AvlNode root2, int item) 
	{
		if(root2==null)
		{
			
			AvlNode newNode=new AvlNode();
			newNode.data=item;
			newNode.height=1;
			return newNode;
		}
		else if(item>root2.data)
		{
			
			root2.right=insertNode(root2.right,item);
		}
		else if(item<root2.data)
		{
			root2.left=insertNode(root2.left, item);
		}
		root2.height=Math.max(height(root2.right), height(root2.left))+1;
		int bf=balancingFactor(root2);
		if(bf>1 && item<root2.left.data)
		{
			return rightRotate(root2);
		}
		if(bf<1 && item>root2.right.data)
		{
			return leftRotate(root2);
		}
		if (bf > 1 && item > root2.left.data) {
			root2.left = leftRotate(root2.left);
			return rightRotate(root2);
		}

		// RL Case
		if (bf < -1 && item < root2.right.data) {
			root2.right = rightRotate(root2.right);
			return leftRotate(root2);
		}
		
		
		return root2;
	}
	
	
	private AvlNode rightRotate(AvlNode c) {
		AvlNode b=c.left;
		AvlNode t3=b.right;
		b.right=c;
		c.left=t3;
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;
		return b;
	}
	private AvlNode leftRotate(AvlNode c) {

		AvlNode b = c.right;
		AvlNode T2 = b.left;

		// rotate
		b.left = c;
		c.right = T2;

		// ht update
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;

		return b;
	}
	public int balancingFactor(AvlNode node)
	{
		if (node == null) {
			return 0;
		}

		return height(node.left) - height(node.right);
	}
	
	
	
	public int height(AvlNode node)
	{
		if (node==null) {return 0;}
		else
		{return node.height;}
	}
	
	
	public void disp()
	{
		disp(this.root);
	}
	private void disp(AvlNode node) {
		if(node==null)
		{
			return ;
		}
		

		String str="";
		if(node.left==null)
		{
			str+=".";
		}
		else
		{
			str+=node.left.data;
		}
		str+="=>"+node.data+"<=";
		if(node.right==null)
		{
			str+=".";
		}
		else
		{
			str+=node.right.data;
		}
		System.out.println(str);
		disp(node.left);
		disp(node.right);
		
	}
}
