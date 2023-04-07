package project2;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] faces = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
        String[] deckOfCardFace = new String[52];
        String[] deckOfCardSuit = new String[52];

        // initial the deckOfCard
        for (int i = 0; i < deckOfCardFace.length; i++) {
            deckOfCardFace[i] = faces[i % 13];
            deckOfCardSuit[i] = suits[i / 13];
        }

        // 第一次 洗牌
        SecureRandom randomNum = new SecureRandom();
        for (int i = 0; i < deckOfCardFace.length; i++) {
            int randNum = randomNum.nextInt(52);
            String tempFace = deckOfCardFace[randNum];
            String tempSuit = deckOfCardSuit[randNum];

            deckOfCardFace[randNum] = deckOfCardFace[i];
            deckOfCardSuit[randNum] = deckOfCardSuit[i];

            deckOfCardFace[i] = tempFace;
            deckOfCardSuit[i] = tempSuit;
        }

        // 第一次 發牌
        int count = 0;
        // deal cards
        int numOfCards = 3;
        for (int i = 0; i < numOfCards; i++) {
            String face = deckOfCardFace[count];
            String suit = deckOfCardSuit[count];
            count++;
            System.out.println(face + '_' + suit);
        }
        System.out.println("=======================");


        // 第二次 洗牌
        for (int i = count; i < deckOfCardFace.length; i++) {
            int randNum = randomNum.nextInt(52 - count) + count;
            String tempFace = deckOfCardFace[randNum];
            String tempSuit = deckOfCardSuit[randNum];

            deckOfCardFace[randNum] = deckOfCardFace[i];
            deckOfCardSuit[randNum] = deckOfCardSuit[i];

            deckOfCardFace[i] = tempFace;
            deckOfCardSuit[i] = tempSuit;
        }

        // 第二次 發牌
        numOfCards = 2;
        for (int i = 0; i < numOfCards; i++) {
            String face = deckOfCardFace[count];
            String suit = deckOfCardSuit[count];
            count++;
            System.out.println(face + '_' + suit);
        }
        System.out.println("=======================");

        
        // 第3次 洗牌
        for (int i = 0; i < count; i++) {
            int randNum = randomNum.nextInt(count);
            String tempFace = deckOfCardFace[randNum];
            String tempSuit = deckOfCardSuit[randNum];

            deckOfCardFace[randNum] = deckOfCardFace[i];
            deckOfCardSuit[randNum] = deckOfCardSuit[i];

            deckOfCardFace[i] = tempFace;
            deckOfCardSuit[i] = tempSuit;
        }

        // 第3次 發牌
        numOfCards = 4;
        for (int i = 0; i < numOfCards; i++) {
            String face = deckOfCardFace[i];
            String suit = deckOfCardSuit[i];
            System.out.println(face + '_' + suit);
        }
        System.out.println("=======================");
    }
}
