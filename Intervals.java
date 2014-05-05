import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, 
 * Given [1,3],[2,6],[8,10],[15,18], 
 * return [1,6],[8,10],[15,18].
 * 
 */
public class Intervals {
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		
		if (intervals.size() == 0)
			return new ArrayList<Interval>();
		
		Interval[] intvs = new Interval[intervals.size()];
		
		intervals.toArray(intvs);
		Arrays.sort(intvs, new IntervalComparator());
		intervals.clear();
		
		Interval last = intvs[0];
		
		for (int i = 1; i < intvs.length; i++) {
			Interval current = intvs[i];
			if (last.end >= current.start) {
				current = new Interval(last.start, Math.max(last.end,
						current.end));
			} else {
				intervals.add(last);
			}
			last = current;
		}
		intervals.add(last);
		return intervals;
	}

	public static void main(String[] args) {
		ArrayList<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(4, 5));
		input.add(new Interval(5, 6));
		input.add(new Interval(7, 8));
		input.add(new Interval(1, 10));
		System.out.println(merge(input));

	}

	static class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval i1, Interval i2) {
			// TODO Auto-generated method stub
			if (i1.start < i2.start)
				return -1;
			else if (i2.start < i1.start)
				return 1;
			else {
				if (i1.end < i2.end)
					return -1;
				else if (i2.end < i1.end)
					return 1;
				else
					return 0;
			}
		}
	}

	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		public String toString() {
			return "(" + start + ", " + end + ")";
		}
	}
}
