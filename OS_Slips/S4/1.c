#include <stdio.h>

int Avail[30], Max[30][30], Need[30][30], Request[30], Alloc[30][30], n, m;

void accept_matrix(int A[][30])
{
	int i, j;
	for(i=0; i<n; i++)
	{
		for(j=0; j<m; j++)
		{
			scanf("%d", &A[i][j]);
		}
	}
}
void display_matrix(int A[][30])
{
	int i, j;
	for(i=0; i<n; i++)
	{
		for(j=0; j<m; j++)
		{
			printf("%d\t", A[i][j]);
		}
		printf("\n");
	}
}

void accept_array(int A[], int no)
{
	int i, j;
	for(i=0; i<no; i++)
	{
		scanf("%d", &A[i]);
	}
}

void display_array(int A[], int no)
{
	int i, j;
	for(i=0; i<no; i++)
	{
		printf("%d\t", A[i]);
	}
}

void Find_Need()
{
	int i, j;
	for(i=0; i<n; i++)
	{
		for(j=0; j<m; j++)
		{
			Need[i][j] = Max[i][j] - Alloc[i][j]; 
		}
	}
}

void main()
{
	int ch;
	while(ch!=4)
	{
	printf("\nMENU\n1.Accept\n2.Display\n3.Display Need\n4.Exit\n");
	scanf("%d", &ch);
		switch(ch)
		{
			case 1:
				printf("\nEnter the number of processes: \n");
				scanf("%d", &n);
				printf("\nEnter the number of resources: \n");
				scanf("%d", &m);
				printf("\nEnter the available array: \n");
				accept_array(Avail, m);
				printf("\nEnter the allocation matrix: \n");
				accept_matrix(Alloc);
				printf("\nEnter the max matrix: \n");
				accept_matrix(Max);
				break;
			case 2:
				printf("\nThe available array: \n");
				display_array(Avail, m);
				printf("\nThe allocation matrix: \n");
				display_matrix(Alloc);
				printf("\nThe max matrix: \n");
				display_matrix(Max);
				break;
			case 3:
				Find_Need();
				printf("\nNEED MATRIX:\n");
				display_matrix(Need);
				break;
			case 4:
				printf("Exited");
			default:
				printf("\nInvalid Choice\n");
		}
	}
}
