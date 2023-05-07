
#include<stdio.h>
int MAX[10][10], Avail[10], Alloc[10][10],Need[10][10],Req[10],Work[10],m,n;
int Finish[10]={0};
int Safe[10]={0};

void accept_matrix(int A[10][10]){
    for(int i =0;i<n;i++){
        for(int j=0;j<m;j++){
            scanf("%d",&A[i][j]);
        }
    }
}

void accept_arr(int A[10],int n){
    for(int i =0;i<n;i++){
            scanf("%d",&A[i]);
    }
}

void display_arr(int A[], int n){
    for(int i =0;i<n;i++){
            printf("%d\t",A[i]);
    }
}

void find_need(){
    int i,j;
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            Need[i][j]=MAX[i][j]-Alloc[i][j];
        }
    }
}

void display_matrix(int A[][10]){
    int i,j;
    for(i =0;i<n;i++){
        for(j=0;j<m;j++){
        printf("%d",A[i][j]);
        }
    printf("\n");
    }
}

void main(){
    int option;
    while (option!=4){
    printf("\nMenu\n1.Accept\n2.Display\n3.Display Need\n4.Exit\n");
    scanf("%d",&option);
    switch(option){
    case 1:
        printf("\nEnter the no.of processes\n");
        scanf("%d",&n);
        printf("\nno of resources:\n");
        scanf("%d",&m);
        printf("\nAllocation:\n");
        accept_matrix(Alloc);
        printf("\nMAX\n");
        accept_matrix(MAX);
        printf("\nAvailable\n");
        accept_arr(Avail,m);
    case 2:
        printf("\nDisplay available\n");
        display_arr(Avail,n);
        printf("\nDisplay ALLOCATION\n");
        display_matrix(Alloc);
        printf("\nDisplay MAX\n");
        display_matrix(MAX);
       break;
    case 3:
        find_need();
        printf("\nDisplay Need\n");
        display_matrix(Need);
    case 4:
        break;
    _:
        printf("\nInvalid\n");
    }
}
}