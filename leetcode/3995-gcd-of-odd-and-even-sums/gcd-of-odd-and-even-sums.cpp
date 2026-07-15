class Solution {
public:
    int gcdOfOddEvenSums(int n) {
        /*
        Let n be the given integer input.

        The sum of the first n positive odd numbers (1+3+5+⋯+(2n−1)) equates to exactly n 
        2
         .
        The sum of the first n positive even numbers (2+4+6+⋯+2n) can be factored as 2×(1+2+3+⋯+n). By the arithmetic progression sum formula, this equates to n(n+1).
        The problem dictates finding the value of GCD(n 
        2
         ,n(n+1)).
        Factoring out the common term n from both arguments gives: GCD(n×n,n×(n+1))=n×GCD(n,n+1).
        Any two consecutive integers, n and n+1, share no common prime factors. Thus, they are perfectly coprime, yielding GCD(n,n+1)=1.
        Substituting this back leaves n×1=n. Therefore, the mathematically correct answer is always guaranteed to be the input n.
        */
        return n;
    }
};