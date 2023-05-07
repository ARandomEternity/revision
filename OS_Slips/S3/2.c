

#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char *argv[]) {
    int rank, size;
    double local_sum = 0, global_sum = 0, average = 0;
    int array[ARRAY_SIZE];

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    srand(rank * 1000);  // Seed the random number generator

    // Initialize array with random values
    for (int i = 0; i < ARRAY_SIZE; i++) {
        array[i] = rand() % 100;
    }

    // Calculate local sum
    for (int i = 0; i < ARRAY_SIZE; i++) {
        local_sum += array[i];
    }

    // Calculate global sum
    MPI_Reduce(&local_sum, &global_sum, 1, MPI_DOUBLE, MPI_SUM, 0, MPI_COMM_WORLD);
    // Calculate average
    if (rank == 0) {
        average = global_sum / (ARRAY_SIZE * size);
        printf("Sum: %lf, Average: %lf\n", global_sum, average);
    }

    MPI_Finalize();
    return 0;
}

