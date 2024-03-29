package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Sticker_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st;

        int cases = func.apply(br.readLine());
        int flag = 0;
        //입력값 받기
        while (flag < cases) {
            int n = func.apply(br.readLine());
            int[][] stickers = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    stickers[i][j] = func.apply(st.nextToken());
                }
            }

            //dp
//        dp[0][0] = stickers[0][0];
//        dp[1][0] = stickers[1][0];
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];


            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));

            ++flag;
        }





    }
}
