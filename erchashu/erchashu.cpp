#include<iostream>
#include<malloc.h> 
#define STACK_SIZE 100
#define STACKIN 10 
typedef struct BitNode
{
	char data;
	BitNode *lchild,*rchild;//��������� 
}BitNode,*BiTree;
//�����Ž���ջ 
typedef struct
{
	BiTree *base;
	BiTree *top;
}Stack;
//�������жϽ�ջ������ջ 
typedef struct   
{
	int *base;
	int *top; 
	int stacksize;
}intStack;
void stack(Stack &s)//��ʼ��ջ������ 
{
	s.base=new BiTree;
	s.top=s.base;
}
void Push(Stack &s,BiTree e)//��ջ 
{
	*s.top=e;
	s.top++;
}
void Pop(Stack &s,BiTree &e)//��ջ �����ĺ��ȥ 
{ 
	s.top--;
	e=*s.top;
}
	int IStack(intStack &s)//��ʼ������ջ 
	{
		s.base=(int *)malloc(STACK_SIZE*sizeof(int));
		s.top=s.base;
		s.stacksize=STACK_SIZE;
		return 0;
	}
	int tagPush(intStack &s,int e)//����ջ����ջ 
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
	int tagPop(intStack &s)//����ջ�ĳ�ջ 
	{
		if(s.top==s.base)
		{
			std::cout<<"ջ��"<<std::endl;
			return 0;
		}
		int e=*--s.top;
		return e;
	}
	int Emptystack(Stack s) //�ж�ջ�Ƿ�Ϊ�� 
	{
		if(s.top==s.base)
		{
			return 0;
		}
	}
	int CreateBiTree(BiTree &T)//�Զ��������ж��� 
	{
	char ch=getchar();
	if (ch=='#') //ͨ��ʹ��#���ж��Ƿ�Ϊ��ָ�� 
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
		CreateBiTree(T->rchild);//ͨ������ݹ���д��������� 
	}
	return 0;
	}
//����ݹ���� ������
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
//����ݹ����  ����� 
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
//����ݹ���� ���Ҹ� 
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
	std::cout<<"���������������"<<std::endl; 
	CreateBiTree(T);
	std::cout<<"����ݹ飺"<<std::endl;
	pre(T);
	std::cout<<std::endl;
	std::cout<<"����ݹ飺"<<std::endl;
	middle(T);
	std::cout<<std::endl;
	std::cout<<"����ݹ飺"<<std::endl;
	last(T);
	}
