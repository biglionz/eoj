package eoj;

import java.util.*;

public class CoveringSegments {

  private static ArrayList<Integer> optimalPoints(ArrayList<Segment> segments) {
    Collections.sort(segments);

    ArrayList<Integer> points = new ArrayList<Integer>();
    int lastPt = segments.get(0).getEnd();
    points.add(lastPt);

    for (int i = 1; i < segments.size(); i++) {
      if(!segments.get(i).inSegment(lastPt)) {
        lastPt = segments.get(i).getEnd();
        points.add(lastPt);
      }
    }
    return points;
  }

  private static class Segment implements Comparable<Segment>{
    int start, end;

    Segment(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public boolean inSegment(int pt) {
      return pt <= this.end && pt >= this.start;
    }

    public int getEnd() {
      return this.end;
    }

    public int compareTo(Segment s){
      if(this.end > s.getEnd())
        return 1;
      else if(this.end < s.getEnd())
        return -1;
      else
        return 0;
    }
  }


  public static void main(String[] args) {
    
    ArrayList<Segment> segments = new ArrayList<Segment>();
//    segments.add(new Segment(-1, 3));
//    segments.add(new Segment(-5, -3));
//    segments.add(new Segment(3, 5));
//    segments.add(new Segment(2, 4));
//    segments.add(new Segment(-3, -2));
//    segments.add(new Segment(-1, 4));
//    segments.add(new Segment(5, 5));
    	segments.add(new Segment(3, 5));
    	segments.add(new Segment(2, 6));
    	segments.add(new Segment(3, 6));
    	segments.add(new Segment(2, 4));
    	segments.add(new Segment(1, 4));
    	segments.add(new Segment(6, 8));
    	segments.add(new Segment(3, 7));
    ArrayList<Integer> points = optimalPoints(segments);
    System.out.println(points.size());
    for (int point : points) {
      System.out.print(point + " ");
    }
  }
}
 
