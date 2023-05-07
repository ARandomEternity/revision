

#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char **argv) {
    int rank, size, i, sum = 0;
    int a[ARRAY_SIZE];
    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    srand(rank);

    // Generate random numbers
    for (i = 0; i < ARRAY_SIZE; i++) {
        a[i] = rand() % 100;
    }

    // Calculate local sum of odd numbers
    for (i = 0; i < ARRAY_SIZE; i++) {
        if (a[i] % 2 == 1) {
            sum += a[i];
        }
    }

    // Reduce to get global sum of odd numbers
    int global_sum;
    MPI_Reduce(&sum, &global_sum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    if (rank == 0) {
        printf("Global sum of odd numbers: %d\n", global_sum);
    }

    MPI_Finalize();
    return 0;
}