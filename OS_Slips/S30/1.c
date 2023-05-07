

#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

#define ARRAY_SIZE 1000

int main(int argc, char *argv[]) {
    int rank, size;
    int array[ARRAY_SIZE];
    int local_min, global_min;
    int i;
    int offset;

    // Initialize MPI
    MPI_Init(&argc, &argv);

    // Get rank and size
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Generate random array
    srand(rank);
    for (i = 0; i < ARRAY_SIZE; i++) {
        array[i] = rand() % 1000;
    }

    // Calculate offset for each process
    offset = ARRAY_SIZE / size;

    // Calculate local min
    local_min = array[offset * rank];
    for (i = 1; i < offset; i++) {
        if (array[offset * rank + i] < local_min) {
            local_min = array[offset * rank + i];
        }
    }

    // Reduce to get global min
    MPI_Reduce(&local_min, &global_min, 1, MPI_INT, MPI_MIN, 0, MPI_COMM_WORLD);

    // Print result
    if (rank == 0) {
        printf("The minimum number is %d\n", global_min);
    }

    // Finalize MPI
    MPI_Finalize();

    return 0;
}

