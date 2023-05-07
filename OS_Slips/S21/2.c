

#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char** argv) {
    int rank, size;
    int i, sum = 0;
    int array[ARRAY_SIZE];
    int local_sum = 0;
    MPI_Status status;

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    if (rank == 0) {
        // Generate random numbers for array
        for (i = 0; i < ARRAY_SIZE; i++) {
            array[i] = rand() % 100;
        }
    }

    // Scatter the array to all processes
    MPI_Scatter(array, ARRAY_SIZE/size, MPI_INT, array+(rank*ARRAY_SIZE/size), ARRAY_SIZE/size, MPI_INT, 0, MPI_COMM_WORLD);

    // Calculate the sum of even numbers in local array
    for (i = 0; i < ARRAY_SIZE/size; i++) {
        if (array[(rank*ARRAY_SIZE/size) + i] % 2 == 0) {
            local_sum += array[(rank*ARRAY_SIZE/size) + i];
        }
    }

    // Reduce the local sums to the global sum
    MPI_Reduce(&local_sum, &sum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    if (rank == 0) {
        printf("Sum of all even numbers in array: %d\n", sum);
    }

    MPI_Finalize();

    return 0;
}

