/*
 * NumberBaseball
 *
 * ver 1.0
 *
 * 2019/03/28
 *
 * Copyright 2019. Jieun Jeong. All ringts reserved.
 */

package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class NumberBaseball {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();

        // 1~9 서로 다른 세 숫자 선정
        while (numbers.size() != 3) {
            numbers.add((int) (Math.random() * 9 + 1));
        }

        ArrayList<Integer> correctAnswer = new ArrayList<>(numbers);
        Collections.shuffle(correctAnswer);

        System.out.println(correctAnswer);

        // 사용자가 유추한 정답 입력
        String result = "";

        while (!result.equals("3스트라이크")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("숫자를 입력해주세요 : ");
            int input = scanner.nextInt();

            ArrayList<Integer> userAnswer = new ArrayList<>();

            while (input != 0) {
                userAnswer.add(0, input % 10);
                input /= 10;
            }

            // 스트라이크 & 볼 판단
            int ball = 0;
            int strike = 0;
            int index = 0;

            for (int e : userAnswer) {
                if (userAnswer.get(index).equals(correctAnswer.get(index))) {
                    strike++;
                } else if (correctAnswer.contains(e)) {
                    ball++;
                }
                index++;
            }

            if (ball == 0 && strike == 0) {
                result = "낫싱";
            } else if (strike == 0) {
                result = ball + "볼";
            } else if (ball == 0) {
                result = strike + "스트라이크";
            } else {
                result = strike + "스트라이크 " + ball + "볼";
            }

            System.out.println(result);
        }
    }
}
