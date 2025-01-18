package com.kafka.util;

import java.util.Random;

public class RandomMessageUtil {

    private static final String[] MESSAGES = {
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

    private static final Random RANDOM = new Random();

    public static String getRandomMessage() {
        int index = RANDOM.nextInt(MESSAGES.length);
        return MESSAGES[index];
    }
}

