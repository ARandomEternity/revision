
#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char** argv) {
    int rank, size;
    int array[ARRAY_SIZE], max = 0, local_max = 0;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    srand(rank + 1); // Initialize random number generator

    // Generate random array
    for (int i = 0; i < ARRAY_SIZE; i++) {
        array[i] = rand() % 1000;
    }

    // Find local max
    for (int i = 0; i < ARRAY_SIZE; i++) {
        if (array[i] > local_max) {
            local_max = array[i];
        }
    }

    // Reduce to find global max
    MPI_Reduce(&local_max, &max, 1, MPI_INT, MPI_MAX, 0, MPI_COMM_WORLD);

    if (rank == 0) {
        printf("The maximum number in the array is %d.\n", max);
    }

    MPI_Finalize();
    return 0;
}

