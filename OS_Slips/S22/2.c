#include <stdio.h>
#include <string.h>
#include <conio.h> 
#include <malloc.h>
struct dir
{
	char filename[20];
	int start;
	int len;
	struct dir *next;
};
struct dir *d,*newNode,*lastNode,*temp;
int Bit[100],n;
void Generate_BitVector()
{
	int i,num;
	for(i=0;i<=n;i++)
    {  
    	num=rand();
    	Bit[i]=num%2;
    }
}
void Show_BitVector()
{
	int i;
	printf("\nGiven Bit Array is\n");
	for(i=0;i<=n;i++)
    {   
		printf(" %d ",Bit[i]);   
    }
}
void ShowDirectory()
{
	printf("\nFilename\tStart\tLength\n");
	temp=d;
	while(temp)
	{
     printf("%s\t\t%d\t%d\n",temp->filename,temp->start,temp->len);
	    temp=temp->next;
	}
}
void CreateFile()
{
	char filename[20];
	int i,l,j,k,n1,start,flag;;
	printf("\nEnter The File Name\n");
	scanf("%s",filename);
	printf("\nEnter The Length of File\n");
	scanf("%d",&l);
	for(i=0;i<=n;i++)
        {
    	if(Bit[i]==1)
    	{
    		start=i;
    		flag=1;
    		k=i;
    		for(j=0;j<l;j++)
    		{
    			if(Bit[k]==0)
    			{
    				flag=0;
    				start=-1;
					break;	
				}	
				k++;
			}
		}
		if(flag==1)
		{
			break;
		}
	}
	if(start>=0)
	{
		i=start;
		n1=0;
		while(n1<l)
		{
			Bit[i]=0;
			i++;
			n1++;
		}
		Show_BitVector();
	    newNode=(struct dir *)malloc(sizeof(struct dir));
		strcpy(newNode->filename,filename);
		newNode->len=l;
		newNode->start=start;
		if(d==NULL)
		{
			lastNode=d=newNode;
		}
		else
		{
			lastNode->next=newNode;
			lastNode=lastNode->next;
		}
		printf("\nFile Allocation is Successfull\n");
	}
	else
		printf("\nFile Allocation Failed\n");
}
void DeleteFile()
{
	struct dir *temp1;
	int start, len,i,j;
	char filename[20];
	printf("\nEnter The Filename to delete");
	scanf("%s",filename);
	temp=d;
	if(d==NULL)
	{
		printf("\nError...!Directory Is Empty\n");
	}
	else
	{
		if(strcmp(temp->filename,filename))
		{
			temp1=temp->next;
			d=temp1;
			temp=NULL;
		}
		else
		{
			while(temp)
			{
		if(strcmp(temp->next->filename,filename))
					break;
				temp=temp->next;
			}
			temp1=temp->next;
		}
	}
	start=temp1->start;
	len=temp1->len;
	i=start;
	j=0;
	while(j<len)
	{
		Bit[i]=1;
		i++;
		j++;
	}
	Show_BitVector();
	if(temp!=NULL)
	{
		temp->next=temp1->next;
		temp1->next=NULL;
		free(temp1);
	}
}
int main()
{
    int Bit[100],i,j,k,start,flag,ch;
    d=NULL;
    printf("\nEnter The Number Of Blocks!\n");
    scanf("%d",&n);
    Generate_BitVector();
    do 
    { 
        printf("\n\n--------MENU------------"); 
     printf("\n\n1.ShowBitVector:\n2.Create New File:\n3.Show Directory\n4.Delete File\n5.exit:"); 
        printf("\n\n Enter your choice:"); 
        scanf("%d",&ch); 
        switch(ch) 
        { 
            case 1: Show_BitVector();
                break; 
            case 2: CreateFile(d); 
                break;
	    case 3: ShowDirectory(d);
		break;
	    case 4: DeleteFile();
    		break;
    	} 
    }while(ch!=5);
    return 0;
}
