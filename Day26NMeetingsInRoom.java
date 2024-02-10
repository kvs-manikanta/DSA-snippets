import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Day26NMeetingsInRoom {
    static class pair
    {
        int startTime;
        int endTime;
        
        public pair(int startTime , int endTime)
        {
            this.startTime=startTime;
            this.endTime=endTime;
        }
        
    }
    static class listSort implements Comparator<pair>{
        public int compare(pair p1, pair p2)
        {
            if(p1.endTime!=p2.endTime)
            {
                return p1.endTime-p2.endTime;
            }
            else
            return p1.startTime-p2.startTime;
        }
    }
        
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        List<pair> meetingsPair=new ArrayList<>();
        // add your code here
        for(int i=0;i<start.length;i++)
        {
            pair p=new pair(start[i],end[i]);
            meetingsPair.add(p);
        }
        
        Collections.sort(meetingsPair , new listSort());
        int meeting=1;
        pair prevPair=meetingsPair.get(0);
        for(int i=1;i<meetingsPair.size();i++)
        {
            pair currPair=meetingsPair.get(i);
            if(prevPair.endTime<currPair.startTime)
            {
                meeting++;
                prevPair=meetingsPair.get(i);
            }
            else
            continue;
        }
        return meeting;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length of array :");
        int A[]=new int[sc.nextInt()];
        System.out.println("Enter length of array :");
        int B[]=new int[sc.nextInt()];
        System.out.println("Enter the values of array"+" ");
        for(int i=0;i<A.length;i++)
        {
            A[i]=sc.nextInt();
        }
        System.out.println("Enter the values of array"+" ");
        for(int i=0;i<A.length;i++)
        {
            B[i]=sc.nextInt();
        }
        sc.close();

        int majorityMeetings=maxMeetings(A,B,A.length);

        System.out.println("Majority element is: "+ majorityMeetings);
    }
}
