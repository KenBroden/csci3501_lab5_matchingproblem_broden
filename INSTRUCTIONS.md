# Instructions for Running the Stable Matching Algorithm

## Overview

This guide provides instructions on how to input data into the [`Main`] class and run the Stable Matching algorithm. The algorithm matches programmers to companies based on their preferences and ensures that the matches are stable.

## Prerequisites

- Ensure you have Java installed on your system.
- Ensure you have the following files in your workspace:
  - [`Main.java`]
  - [`Company.java`]
  - [`Programmer.java`]
  - [`StableMatching.java`]

## Input Data

### Programmers and Companies

The [`Main`] class contains two sets of data for programmers and companies. Each set includes a list of programmers and companies with their respective preferences.

### Example Data

#### First Dataset

**Programmers Preferences of Companies:**

- Programmer 1: {E, A, D, B, C}
- Programmer 2: {D, E, B, A, C}
- Programmer 3: {D, B, C, E, A}
- Programmer 4: {C, B, D, A, E}
- Programmer 5: {A, D, B, C, E}

**Company Preferences of Programmers:**

- Company A: {2, 5, 1, 3, 4}
- Company B: {1, 2, 3, 4, 5}
- Company C: {5, 3, 2, 1, 4}
- Company D: {1, 3, 2, 4, 5}
- Company E: {2, 3, 5, 4, 1}

#### Second Dataset

**Programmers Preferences of Companies:**

- Ken: {IBM, Toro, 3M, Digi-Key, Polaris}
- John: {Digi-Key, IBM, Polaris, Toro, 3M}
- Sara: {3M, Polaris, IBM, Digi-Key, Toro}
- Zoe: {Toro, 3M, Digi-Key, Polaris, IBM}
- Tim: {Polaris, Digi-Key, Toro, IBM, 3M}

**Company Preferences of Programmers:**

- IBM: {John, Sara, Zoe, Tim, Ken}
- Toro: {Sara, Tim, John, Zoe, Ken}
- 3M: {Zoe, John, Tim, Sara, Ken}
- Digi-Key: {Tim, Zoe, Sara, John, Ken}
- Polaris: {Sara, Zoe, Tim, John, Ken}

## Running the Algorithm

1. **Open [`Main.java`]: Ensure the [`Main`] class is correctly set up with the input data for programmers and companies.

2. **Compile the Code**: Open a terminal and navigate to the directory containing your Java files. Compile the code using the following command:
   ```sh
   javac Main.java Company.java Programmer.java StableMatching.java
   ```

3. **Run the Program**: Execute the compiled [`Main`] class:
   ```sh
   java Main
   ```

4. **View the Output**: The program will print the matches for each dataset and test for stability. The output will look like this:
   ```
   Programmer 1 matched with Company D
   Programmer 2 matched with Company E
   Programmer 3 matched with Company B
   Programmer 4 matched with Company C
   Programmer 5 matched with Company A

   Stability: true

   Programmer Ken matched with Company IBM
   Programmer John matched with Company Digi-Key
   Programmer Sara matched with Company 3M
   Programmer Zoe matched with Company Toro
   Programmer Tim matched with Company Polaris

   Stability: true
   ```

## Conclusion

By following these instructions, you can input data into the [`Main`] class and run the Stable Matching algorithm to find stable matches between programmers and companies.
