class Solution {
    public int numRabbits(int[] answers) {
        int[] seatsTaken = new int[1001]; 
        int total = 0;

        for (int k : answers) {
            if (seatsTaken[k] == 0) {    
                total += k + 1;          
            }
            seatsTaken[k]++;             
            if (seatsTaken[k] == k + 1) {
                seatsTaken[k] = 0;        
            }
        }
        return total;
    }
}