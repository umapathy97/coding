class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int result=0;
        int j=0;
        int i=people.length-1;
        while(j<=i){
          
            if(people[j]+people[i]<=limit){
                result++;i--;j++;
            }/* As after sorted person at last index will be always travel individually.
            else if(people[i]<=limit){
                result++;
            i--;}
            else if(people[j]==limit){
                result++;
            j++;}
        }
        return result;
    }
}
/*
time complexity:O(nlogn)
space complexity:O(1)
beats 36.6% time and 100% space
*/
// better solution
class Solution {
     public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i, j;
        for (i = 0, j = people.length - 1; i <= j; --j)
            if (people[i] + people[j] <= limit) ++i;
        return people.length - 1 - j;
    }
}
/*
time complexity:O(nlogn)
space complexity:O(1)
beats 97.9% time and 100% space 
*/
