import java.security.SecureRandom;
import java.util.Scanner;

public class Main2 {
    // 宣告並初始化全域變數
    static String[] faces = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    static String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
    static String[] deckOfCardFace = new String[52];
    static String[] deckOfCardSuit = new String[52];
    static SecureRandom randomNum = new SecureRandom();

    public static void main(String[] args) {
        // 呼叫初始牌局方法
        initDeckOfCard();
        // 呼叫第一次發牌方法
        dealCards(4);
        // 呼叫第二次發牌方法
        dealCards(3);
        // 呼叫第三次發牌方法
        dealCards(6);
    }

    // 初始牌局方法
    static void initDeckOfCard() {
        for (int i = 0; i < deckOfCardFace.length; i++) {
            deckOfCardFace[i] = faces[i % 13];
            deckOfCardSuit[i] = suits[i / 13];
        }

        // 洗牌
        shuffleDeckOfCard(deckOfCardFace.length);
    }

    // 發牌方法
    public static void dealCards(int numOfCards) {
        int count = 0;
        for (int i = 0; i < numOfCards; i++) {
            String face = deckOfCardFace[count];
            String suit = deckOfCardSuit[count];
            count++;
            System.out.println(face + '_' + suit);
        }
        System.out.println("=======================");

        // 洗牌
        shuffleDeckOfCard(deckOfCardFace.length - count);
    }

    // 洗牌方法
    static void shuffleDeckOfCard(int shuffleTimes) {
        for (int i = 0; i < shuffleTimes; i++) {
            int randNum = randomNum.nextInt(deckOfCardFace.length - i) + i;
            String tempFace = deckOfCardFace[randNum];
            String tempSuit = deckOfCardSuit[randNum];

            deckOfCardFace[randNum] = deckOfCardFace[i];
            deckOfCardSuit[randNum] = deckOfCardSuit[i];

            deckOfCardFace[i] = tempFace;
            deckOfCardSuit[i] = tempSuit;
        }
    }
}