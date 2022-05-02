package coding.challenge;

import java.util.Comparator;
import java.util.Stack;

public final class Arrays {
    private Arrays() {
        throw new AssertionError("Cannot be instantiated");
    }

    // 실행 시간이 O(n log n)이고 스택에 사용되는 보조 공간이 O(n)
    public static void mergeIntervals(Interval[] intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException("The given array of intervals cannot be null");
        }

        // 1단계: 시작점을 기준으로 주어진 구간을 오름차순 정렬합니다.
        java.util.Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Stack<Interval> stackOfIntervals = new Stack();

        for (Interval interval : intervals) {
            // 3-a단계: 현재 구간이 스택의 톱에 있는 구간과 겹치지 않는다면 현재 구간을 스택에 푸시합니다.
            if (stackOfIntervals.empty() || interval.start > stackOfIntervals.peek().end) {
                stackOfIntervals.push(interval);
            }

            // 3-b딘계: 현재 구간이 스택의 톱에 있는 구간과 겹치고
            // 현재 구간의 끝점이 스택의 톱에 있는 구간의 끝점보다 크다면,
            // 스택의 톱에 있는 구간의 끝점을 현재 구간의 끝점으로 변경합니다.
            if (stackOfIntervals.peek().end < interval.end) {
                stackOfIntervals.peek().end = interval.end;
            }
        }

        // 결과를 출력합니다.
        while (!stackOfIntervals.empty()) {
            System.out.print(stackOfIntervals.pop() + " ");
        }
    }

    // 실행 시간이 O(n log n)이고 공간 복잡도가 O(1)
    public static void mergeIntervalsOptimized(Interval intervals[]) {
        if (intervals == null) {
            throw new IllegalArgumentException("The given array of intervals cannot be null");
        }

        // 1단계: 시작점을 기준으로 주어진 구간을 내림차순 정렬합니다.
        java.util.Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i2.start - i1.start;
            }
        });

        int index = 0;

        for (int i = 0; i < intervals.length; i++) {
            // 2-a단계: 현재 구간이 첫 번째 구간이 아니고 이전 구간과 겹친다면
            // 현재 구간과 이전 구간을 병합합니다. 모든 이전 구간에 대해서 이를 수행합니다.
            if (index != 0 && intervals[index - 1].start <= intervals[i].end) {
                while (index != 0 && intervals[index - 1].start <= intervals[i].end) {

                    // merge the previous interval with the current interval
                    intervals[index - 1].end = Math.max(intervals[index - 1].end, intervals[i].end);
                    intervals[index - 1].start = Math.min(intervals[index - 1].start, intervals[i].start);
                    index--;
                }
            // 2-b단계: 현재 구간이 이전 구간과 겹치지 않는다면 현재 구간을 결과 구간 배열에 추가합니다.
            } else {
                intervals[index] = intervals[i];
            }

            index++;
        }

        // 결과를 출력합니다.
        for (int i = 0; i < index; i++) {
            System.out.print(intervals[i] + " ");
        }
    }
}