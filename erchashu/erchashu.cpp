#include<iostream>
#include<malloc.h> 
#define STACK_SIZE 100
#define STACKIN 10 
typedef struct BitNode
{
	char data;
	BitNode *lchild,*rchild;//定义二叉树 
}BitNode,*BiTree;
//定义存放结点的栈 
typedef struct
{
	BiTree *base;
	BiTree *top;
}Stack;
//定义存放判断进栈次数的栈 
typedef struct   
{
	int *base;
	int *top; 
	int stacksize;
}intStack;
void stack(Stack &s)//初始化栈。引用 
{
	s.base=new BiTree;
	s.top=s.base;
}
void Push(Stack &s,BiTree e)//入栈 
{
	*s.top=e;
	s.top++;
}
void Pop(Stack &s,BiTree &e)//出栈 先来的后出去 
{ 
	s.top--;
	e=*s.top;
}
	int IStack(intStack &s)//初始化数字栈 
	{
		s.base=(int *)malloc(STACK_SIZE*sizeof(int));
		s.top=s.base;
		s.stacksize=STACK_SIZE;
		return 0;
	}
	int tagPush(intStack &s,int e)//数字栈的入栈 
	{
		if(s.top-s.base>=s.stacksize)
		{
			s.base=(int *)realloc(s.base,(s.stacksize+STACKIN)*sizeof(int));
			s.top=s.base+s.stacksize;
			s.stacksize+=STACKIN;
		}
		*s.top++=e;
		return 0;
	}
	int tagPop(intStack &s)//数字栈的出栈 
	{
		if(s.top==s.base)
		{
			std::cout<<"栈空"<<std::endl;
			return 0;
		}
		int e=*--s.top;
		return e;
	}
	int Emptystack(Stack s) //判断栈是否为空 
	{
		if(s.top==s.base)
		{
			return 0;
		}
	}
	int CreateBiTree(BiTree &T)//对二叉树进行定义 
	{
	char ch=getchar();
	if (ch=='#') //通过使用#来判断是否为空指针 
		{
		T=NULL;}
	else
	{
		T=new BitNode;
		if (T==NULL) 
		{
		std::cout<<"OVER"<<std::endl;
		return 0;
		}
		T->data=ch;
		CreateBiTree(T->lchild);
		CreateBiTree(T->rchild);//通过先序递归进行创建二叉树 
	}
	return 0;
	}
//先序递归遍历 根左右
int pre(BiTree T)
{
	if (T==NULL) return 0;
	else
	{
		std::cout<<T->data<<" ";
		pre(T->lchild);
		pre(T->rchild);
	}
}
//中序递归遍历  左根右 
int middle(BiTree T)
{
	if (T==NULL) return 0;
	else
	{
		middle(T->lchild);
		std::cout<<T->data<<" ";
		middle(T->rchild);
	}
}
//后序递归遍历 左右根 
int last(BiTree T)
{
	if (T==NULL) return 0;
	else
	{
		last(T->lchild);
		last(T->rchild);
		std::cout<<T->data<<" ";
	}
}
int main()
{
	BiTree T;
	std::cout<<"先序输入二叉树："<<std::endl; 
	CreateBiTree(T);
	std::cout<<"先序递归："<<std::endl;
	pre(T);
	std::cout<<std::endl;
	std::cout<<"中序递归："<<std::endl;
	middle(T);
	std::cout<<std::endl;
	std::cout<<"后序递归："<<std::endl;
	last(T);
	}
