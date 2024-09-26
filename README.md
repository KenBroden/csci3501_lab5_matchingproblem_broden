# Algorithm Steps and Results

By Ken Broden

## Steps

1. Initialization:
   1. A queue of free programmers is initialized.
   2. Each programmer starts by applying to their most preferred company that they have not yet applied to.
2. Iterative Matching:
   1. The algorithm iterates through the queue of free programmers.
   2. Each programmer applies to the next company on their preference list.
   3. If the company is free (not currently matched), the company and programmer are matched.
   4. If the company is already matched, the company decides whether to keep its current match or switch to the new applicant based on its preference list.
   5. If the company prefers the new applicant, the current match is added back to the queue of free programmers, and the new applicant is matched with the company.
   6. If the company prefers its current match, the programmer remains free and continues to apply to the next company on their list.
3. Termination:
   1. The algorithm terminates when there are no free programmers left who can apply to a company.

## Algorithm

The algorithm implemented in StableMatching is closely based on the Gale-Shapley algorithm. Gale-Shapley is designed to find a stable match between two equally sized sets of elements given their preferences. More can be found on the Gale-Shapley Algorithm on the wiki page [here.](https://en.wikipedia.org/wiki/Gale%E2%80%93Shapley_algorithm)

## Results

Given preferences:

Company Preferences of Programmers:

- A: {2,5,1,3,4}
- B: {1,2,3,4,5}
- C: {5,3,2,1,4}
- D: {1,3,2,4,5}
- E: {2,3,5,4,1}

Programmers Preferences of Companies:

- 1: {E,A,D,B,C}
- 2: {D,E,B,A,C}
- 3: {D,B,C,E,A}
- 4: {C,B,D,A,E}
- 5: {A,D,B,C,E}

The Stable Matching algorithm produced these matches:

- Programmer 1 matched with Company D
- Programmer 2 matched with Company E
- Programmer 3 matched with Company B
- Programmer 4 matched with Company C
- Programmer 5 matched with Company A

## Verification

1. Programmer 1 matched with Company D:
   - Programmer 1 prefers E, A over D.
   - Company D prefers Programmer 1 over 3, 2, 4, 5.
   - Potential instability: Programmer 1 prefers E and A over D.
     - Company E: Prefers Programmer 2 over 1.
     - Company A: Prefers Programmer 2, 5 over 1.
   - No instability with Company E or A.
  
2. Programmer 2 matched with Company E:
   - Programmer 2 prefers D over E.
   - Company E prefers Programmer 2 over 3, 5, 4, 1.
   - Potential instability: Programmer 2 prefers D over E.
     - Company D: Prefers Programmer 1 over 2.
   - No instability with Company D.

3. Programmer 3 matched with Company B:
   - Programmer 3 prefers D over B.
   - Company B prefers Programmer 1 over 2, 3, 4, 5.
   - Potential instability: Programmer 3 prefers D over B.
     - Company D: Prefers Programmer 1 over 3.
   - No instability with Company D.

4. Programmer 4 matched with Company C:
   - Programmer 4 prefers B over C.
   - Company C prefers Programmer 5 over 3, 2, 1, 4.
   - Potential instability: Programmer 4 prefers B over C.
     - Company B: Prefers Programmer 1 over 2, 3, 4, 5.
   - No instability with Company B.

5. Programmer 5 matched with Company A:
   - Programmer 5 prefers A over D, B, C, E.
     - Company A prefers Programmer 2, 5 over 1, 3, 4.
   - No instability.
