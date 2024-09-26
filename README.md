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
     - Company A prefers Programmer 2 & 5 over 1, 3, 4.
   - No instability.

## Results - 2nd dataset

Given preferences:

Company Preferences of Programmers:

- IBM: {John, Sara, Zoe, Tim, Ken}
- Toro: {Sara, Tim, John, Zoe, Ken}
- 3M: {Zoe, John, Tim, Sara, Ken}
- Digi-Key: {Tim, Zoe, Sara, John, Ken}
- Polaris: {Sara, Zoe, Tim, John, Ken}

Programmers Preferences of Companies:

- Ken: {IBM, Toro, 3M, Digi-Key, Polaris}
- John: {Digi-Key, IBM, Polaris, Toro, 3M}
- Sara: {3M, Polaris, IBM, Digi-Key, Toro}
- Zoe: {Toro, 3M, Digi-Key, Polaris, IBM}
- Tim: {Polaris, Digi-Key, Toro, IBM, 3M}

The Stable Matching algorithm produced these matches:

- Programmer Ken matched with Company IBM
- Programmer John matched with Company Digi-Key
- Programmer Sara matched with Company 3M
- Programmer Zoe matched with Company Toro
- Programmer Tim matched with Company Polaris

## Verification - 2nd dataset

1. Ken matched with Company IBM:
   - Ken's Preferences: IBM, Toro, 3M, Digi-Key, Polaris
   - IBM's Preferences: John, Sara, Zoe, Tim, Ken
   - Analysis:
     - Ken prefers IBM over all other companies, so no potential instability for Ken.
     - IBM prefers John, Sara, Zoe, and Tim over Ken, but none of them would prefer IBM over their current match.
     - John prefers Digi-Key, which he is matched with.
     - Sara prefers 3M, which she is matched with.
     - Zoe prefers Toro, which she is matched with.
     - Tim prefers Polaris, which he is matched with.
   - Conclusion: No instability for Ken with IBM.

2. John matched with Company Digi-Key:
   - John's Preferences: Digi-Key, IBM, Polaris, Toro, 3M
   - Digi-Key's Preferences: Tim, Zoe, Sara, John, Ken
   - Analysis:
     - John prefers Digi-Key over IBM, so no potential instability for John.
     - Digi-Key prefers Tim, Zoe, and Sara over John, but none of them would prefer Digi-Key over their current match.
     - Tim prefers Polaris, which he is matched with.
     - Zoe prefers Toro, which she is matched with.
     - Sara prefers 3M, which she is matched with.
   - Conclusion: No instability for John with Digi-Key.

3. Sara matched with Company 3M:
   - Sara's Preferences: 3M, Polaris, IBM, Digi-Key, Toro
   - 3M's Preferences: Zoe, John, Tim, Sara, Ken
   - Analysis:
     - Sara prefers 3M over Polaris, so no potential instability for Sara.
     - 3M prefers Zoe, John, and Tim over Sara, but none of them would prefer 3M over their current match.
     - Zoe prefers Toro, which she is matched with.
     - John prefers Digi-Key, which he is matched with.
     - Tim prefers Polaris, which he is matched with.
   - Conclusion: No instability for Sara with 3M.

4. Zoe matched with Company Toro:
   - Zoe's Preferences: Toro, 3M, Digi-Key, Polaris, IBM
   - Toro's Preferences: Sara, Tim, John, Zoe, Ken
   - Analysis:
     - Zoe prefers Toro over all other companies, so no potential instability for Zoe.
     - Toro prefers Sara, Tim, and John over Zoe, but none of them would prefer Toro over their current match.
     - Sara prefers 3M, which she is matched with.
     - Tim prefers Polaris, which he is matched with.
     - John prefers Digi-Key, which he is matched with.
   - Conclusion: No instability for Zoe with Toro.

5. Tim matched with Company Polaris:
   - Tim's Preferences: Polaris, Digi-Key, Toro, IBM, 3M
   - Polaris's Preferences: Sara, Zoe, Tim, John, Ken
   - Analysis:
     - Tim prefers Polaris over all other companies, so no potential instability for Tim.
     - Polaris prefers Sara and Zoe over Tim, but neither of them would prefer Polaris over their current match.
     - Sara prefers 3M, which she is matched with.
     - Zoe prefers Toro, which she is matched with.
   - Conclusion: No instability for Tim with Polaris.

## Algorithm Efficiency

1. Outer Loop:
   - The outer while loop continues until all programmers are matched.
   - Each programmer can apply to every company once. Once a programmer has applied to all companies, they remain matched.
   - Since there are 𝑛 programmers and 𝑛 companies, in the worst case, every programmer may apply to every company.

2. Company Preference Step:
   - Each time a programmer applies to a company, the company checks if they are currently unmatched. If matched, the company compares the new programmer to its current match.
   - This check for preference is 𝑂(1) because the company maintains a fixed preference list and can access the preference order in constant time.

3. Queue:
   - In the worst case, a programmer who is rejected by a company is added back to the queue. Each programmer can only be rejected a maximum of 𝑛−1 times, as they can only apply to 𝑛 companies.

In the worse case: Each programmer applies to each company exactly once. There are 𝑛 programmers and each programmer can make at most 𝑛 proposals. Therefore, the total number of proposals made is 𝑛^2. Each proposal results in the company checking its preference list and possibly updating the match, which takes constant time (𝑂(1)).

Thus, the overall worst-case time complexity is 𝑂(𝑛^2). This matches the time complexity of the Gale-Shapley algorithm which findStableMatches() is based on.
