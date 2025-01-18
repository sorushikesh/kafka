package com.kafka.util;

import java.util.Random;

public class MoodBasedMessageUtil {

    private static final String[] HAPPY_MESSAGES = {
            "Hello, how are you?",        // English
            "Hola, ¿cómo estás?",         // Spanish
            "Bonjour, comment ça va?",    // French
            "Ciao, come stai?",           // Italian
            "Hallo, wie geht's?",         // German
            "Привет, как дела?",          // Russian
            "こんにちは、お元気ですか?",     // Japanese
            "안녕하세요, 어떻게 지내세요?",  // Korean
            "नमस्ते, कैसे हो?",            // Hindi
            "مرحبا، كيف حالك؟",            // Arabic
            "你好，你好吗?",               // Chinese
            "Olá, como vai?",             // Portuguese
            "Hej, hur mår du?",           // Swedish
            "Merhaba, nasılsınız?"        // Turkish
    };

    private static final String[] NEUTRAL_MESSAGES = {
            "Hey, how's everything?",     // English
            "Hola, ¿todo bien?",           // Spanish
            "Salut, ça va ?",              // French
            "Ciao, tutto bene?",           // Italian
            "Hallo, alles gut?",          // German
            "Привет, как дела?",           // Russian
            "お元気ですか？",               // Japanese
            "안녕하세요, 잘 지내세요?",       // Korean
            "नमस्ते, सब ठीक है?",          // Hindi
            "أهلاً، كل شيء على ما يرام؟",  // Arabic
            "你好吗？",                    // Chinese
            "Oi, tudo bem?",              // Portuguese
            "Hej, allt bra?",             // Swedish
            "Merhaba, her şey yolunda mı?" // Turkish
    };

    private static final String[] SAD_MESSAGES = {
            "I'm sorry to hear that.",     // English
            "Lo siento mucho.",           // Spanish
            "Désolé d'entendre cela.",    // French
            "Mi dispiace sentirlo.",      // Italian
            "Es tut mir leid, das zu hören.", // German
            "Сожалею, что слышу это.",    // Russian
            "ごめんなさい、聞いて残念です。", // Japanese
            "미안해요, 그런 일이 있다니.", // Korean
            "मुझे खेद है, ऐसा सुनकर।",    // Hindi
            "أشعر بالأسف لسماع ذلك.",      // Arabic
            "对不起，听到这个我很难过。",    // Chinese
            "Sinto muito por ouvir isso.", // Portuguese
            "Förlåt att höra det.",       // Swedish
            "Üzgünüm, bunu duyduğuma üzüldüm." // Turkish
    };

    private static final Random RANDOM = new Random();

    public static String getRandomMessageByMood(String mood) {
        String[] selectedMessages;

        switch (mood.toLowerCase()) {
            case "happy":
                selectedMessages = HAPPY_MESSAGES;
                break;
            case "neutral":
                selectedMessages = NEUTRAL_MESSAGES;
                break;
            case "sad":
                selectedMessages = SAD_MESSAGES;
                break;
            default:
                return "Mood not recognized. Please choose 'happy', 'neutral', or 'sad'.";
        }

        int index = RANDOM.nextInt(selectedMessages.length);
        return selectedMessages[index];
    }
}
