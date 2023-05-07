
#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char** argv) {
    int rank, size, i;
    int sum = 0;
    int* array = NULL;
    int* local_array = NULL;
    int local_sum = 0;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (rank == 0) {
        // Only rank 0 initializes the array
        array = malloc(sizeof(int) * ARRAY_SIZE);
        for (i = 0; i < ARRAY_SIZE; i++) {
            array[i] = rand() % 100; // Generate random numbers between 0 and 99
        }
    }

    // Distribute the array across all processes
    int local_size = ARRAY_SIZE / size;
    local_array = malloc(sizeof(int) * local_size);
    MPI_Scatter(array, local_size, MPI_INT, local_array, local_size, MPI_INT, 0, MPI_COMM_WORLD);
    // Calculate local sum
    for (i = 0; i < local_size; i++) {
        local_sum += local_array[i];
    }

    // Reduce all local sums to get the final sum
    MPI_Reduce(&local_sum, &sum, 1, MPI_INT, MPI_SUM, 0, MPI_COMM_WORLD);

    if (rank == 0) {
        printf("The sum is %d\n", sum);
        free(array);
    }
    free(local_array);

    MPI_Finalize();
    return 0;
}


