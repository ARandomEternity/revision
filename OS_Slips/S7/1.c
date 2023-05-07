#include<stdio.h> 
#include<stdlib.h>
int max[10][10],need[10][10],allocation[10][10];
int available[10],work[10],finish[10],request[10],Safe[10]; 
int np,nr,i,j,k,l,m,n,pid,pno; 
int ch,cnt=0; 
void accept_matrix(int A[10][10])
{
    int i,j;
    for(i=0;i<np;i++) 
    { 
        for(j=0;j<nr;j++) 
        { 
            scanf("%d",&A[i][j]); 
        } 
    }
}
void Accept_Vector(int A[])
{
    int i;
    for(i=0;i<nr;i++) 
    { 
        scanf("%d",&A[i]); 
    } 
}
void Find_need()
{
    int i, j;
    for(i=0;i<np;i++) 
    { 
        for(j=0;j<nr;j++) 
        { 
            need[i][j]=max[i][j]-allocation[i][j]; 
        } 
    }
    printf("\nNeed Calculated Successfully\n");
}
void Display_matrix()
{
    int i,j;
    printf("\nAllocation\tMax\t\tNeed\n");
    for(i=0; i<np;i++)
    {
    	for(j=0; j<nr;j++)
		printf(" %d",allocation[i][j]) ;
    	printf("\t\t");
	for (j=0; j<nr;j++)
		printf(" %d",max[i][j]) ;
	printf("\t\t");
	for (j=0; j<nr;j++)
		printf(" %d",need[i][j]) ;
	printf("\n");
    }
    printf("\n Available\n");
    for (j=0; j<nr;j++)
        printf(" %d",available[j]);
    printf("\t");
}
int Safety_algo()
{ 
    int over =0, i, j, k,l=0,flag=0,pflag=0;
    //initialize work = available
    for(i=0;i<nr;i++)
    	work[i]=available[i];
    for(i=0;i<np;i++)
    	finish[i]=0;
    while(!over)
    { // check for any not finished process
    	for(i=0;i<np; i++)
    	{
            if(finish[i] == 0)
	    {
	        flag=0;
		for(j=0;j<nr;j++)
		{
		    if(need[i][j]>work[j])
			flag=1;
		}
		if(flag == 0 && finish[i] == 0)
		{
		    for(j=0;j<nr;j++)
			work[j]+=available[j];
		    finish[i]=1;
		    pflag++;
		    Safe[l++]=i;
		}
	    }
	    if(pflag == n)
	    {
		over = 1;
		return 1;
	    }
	}
    }
    return 0;
}
void Bankers_algo()
{
    int i,j;
    j=Safety_algo();
    if(j != 0 )
    {
	printf("\n A safety sequence has been detected.\n");
	for(i=0;i<np;i++)
	     printf(" P%d ",Safe[i]);
    }
    else
    {
    	printf("\n Deadlock has occured.\n");
    }
}
void Resource_request_algo()
{
    int i;
    // check if requesti <= needi
    for(i=0;i<nr;i++)
    {
    	if(request[i]>need[pno][i])
    	{ 
        printf("error.. process exceeds its Max demand");
	exit(1);
	}
    }
    // check if Reuest [i] <= availableable
    for(i=0; i<np; i++)
    { 
    	if(request[i] > available[i])
    	{
        printf("Process must wait , resources not available");
		exit(1);
	}
    }
    // pretend to have allocated requested resources
    for(i=0;i<np;i++)
    {
    	available[i]=available[i]-request[i];
	allocation[pno][i]=allocation[pno][i]+request[i];
	need[pno][i]=need[pno][i]-request[i];
    }
    printf("\nRun Safety\n");
   //run Safety algorithm to check whether safe sequence exists or not
    Bankers_algo();
}

int main() 
{ 
    //clrscr(); 
    int result;
    printf("\n Enter the no of processes:\t"); 
    scanf("%d",&np); 
    printf("\n Enter the no of resources:\t"); 
    scanf("%d",&nr);     
    do 
    { 
        printf("\n\n--------MENU------------"); 
printf("\n\n1.Accept allocation:\n2.Accept Max:\n3.Calculate need\n4.Accept available\n");
printf("5.Display Matrices\n6.Apply Bankers Algorithm\n7.Accept Request and Apply Banker’s Algorithm\n7.exit:"); 
printf("\n\n Enter your choice:"); 
scanf("%d",&ch); 
    switch(ch) 
    {
        case 1: printf("\n Enter the allocation matrix:\n"); 
    	    accept_matrix(allocation); 
            break; 
        case 2: printf("\n Enter the max matrix:\n"); 
    	    accept_matrix(max); 
            break;
	case 3:Find_need();
	    break;
        case 4: printf("\n Enter the available vector:\n"); 
    	    Accept_Vector(available);
    	    break;
    	case 5:Display_matrix();
    	    break;
    	case 6:
            printf("\nApplying Bankers Algorithm\n");
            Bankers_algo();
    	    break;
    	case 7:
    	    printf("\nEnter The Process Number\n");
    	    scanf("%d",&pno);
    	    printf("\nEnter the Request vector\n");
    	    Accept_Vector(request);
    	    Resource_request_algo();
    	    break;
        } 
    }while(ch!=8); 
    return 0; 
}