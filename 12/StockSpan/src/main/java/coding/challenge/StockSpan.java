package coding.challenge;

import java.util.Stack;

public class StockSpan {
    private StockSpan() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int[] stockSpan(int[] stockPrices) {
        if (stockPrices == null) {
            throw new IllegalArgumentException("Prices array cannot be null");
        }

        Stack<Integer> dayStack = new Stack();
        int[] spanResult = new int[stockPrices.length];

        spanResult[0] = 1; // 첫 번째 날의 주가 스팬은 1입니다.
        dayStack.push(0);

        for (int i = 1; i < stockPrices.length; i++) {
            // 스택에서 현재 가격보다 큰 가격을 찾거나 남은 날짜가 없을 때까지 팝합니다.
            while (!dayStack.empty() && stockPrices[i] > stockPrices[dayStack.peek()]) {
                dayStack.pop();
            }

            // 현재 날짜의 가격보다 큰 가격이 없는 경우 주가 스팬은 날짜의 수입니다.
            if (dayStack.empty()) {
                spanResult[i] = i + 1;
            } else {
                // 현재 날짜의 가격보다 큰 가격이 있는 경우
                // 주가 스팬은 해당 날짜와 현재 날짜의 차이입니다.
                spanResult[i] = i - dayStack.peek();
            }

            // 현재 날짜를 스택의 톱에 푸시합니다.
            dayStack.push(i);
        }

        return spanResult;
    }
}