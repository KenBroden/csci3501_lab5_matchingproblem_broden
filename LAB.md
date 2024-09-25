# The Lab Task: Matching problem

## Lab Description

Your task is to design and implement an algorithm that finds a solution to the following problem:

N programmers are looking for a job; N companies are looking to hire a programmer. Each programmer has a ranking of the companies based on his/her/their preferences for a workplace. Likewise, each company has a ranking of the N programmers based on whom they would like to hire.

Given a set of rankings, it may be impossible to find a pairing of programmers with companies when everyone gets their first choice (what would be an example of such ranking, among, say, 3 programmers and companies?). However, it is always possible to find a satisfactory pairing. Let's denote programmers as P and companies as C.

A pairing of programmers with companies is called satisfactory if it doesn't have two pairings, (P1, C1) and (P2, C2), such that:

- P1 ranks C2 higher than C1
- C2 ranks P1 higher than P2

(in other words, C2 would want to hire P1 instead of their current programmer P2, and P1 would accept the offer since they rank C2 higher than their current employer C1)

Below is an example of preferences of five companies A, B, C, D, E and five programmers 1, 2, 3, 4, 5 (the preferences decrease from the top row to the bottom row):

Company Preferences of Programmers:
A: {2,5,1,3,4}
B: {1,2,3,4,5}
C: {5,3,2,1,4}
D: {1,3,2,4,5}
E: {2,3,5,4,1}

Programmers Preferences of Companies:
1: {E,A,D,B,C}
2: {D,E,B,A,C}
3: {D,B,C,E,A}
4: {C,B,D,A,E}
5: {A,D,B,C,E}

The pairing A1 B3 C2 D4 E5 is unsatisfactory since A prefers programmer 2 to programmer 1 and programmer 2 prefers company A to company C. Find a satisfactory pairing; you may use it as your test example.

## Tasks

1. Develop an algorithm that, given preferences for N programmers and N companies, finds a satisfactory pairing. If there is more than one satisfactory pairing, you need to find just one.
2. Implement your algorithm and test it on several cases of preferences. It does not matter how your algorithm takes data, but you should clearly explain this in the documentation so that we know how to test it. Also make sure to document all your test cases and results. Check that the pairings found by your program are satisfactory (write a method to do this to save yourself some time).
3. Explain why your algorithm is correct (i.e. it always stops and outputs a satisfactory pairing). You don't need to go into low-level details of your program, but your argument must be precise enough to convince someone who has not seen your program before that it is indeed correct.
4. Find the efficiency of your algorithm in the worst case, justify your answer.
