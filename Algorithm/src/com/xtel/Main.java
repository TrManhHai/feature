package com.xtel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi chữ cái Latin: ");
        String input = scanner.nextLine();
        int count = countVietnameseLetters(input);
        System.out.println("Số lượng chữ cái Tiếng Việt có thể được tạo thành: " + count);
    }

    public static int countVietnameseLetters(String input) {
        int count = 0;
        String vietnameseLetters = "ăâđêôơư";
        String telexMapping = "awaaadeeooow";

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (vietnameseLetters.contains(String.valueOf(letter))) {
                count++;
            } else if (telexMapping.contains(String.valueOf(letter))) {
                // Check if the previous letter is a valid Telex letter
                if (i > 0 && vietnameseLetters.contains(String.valueOf(input.charAt(i - 1)))) {
                    count++;
                }
            }
        }

        return count;
    }
}
