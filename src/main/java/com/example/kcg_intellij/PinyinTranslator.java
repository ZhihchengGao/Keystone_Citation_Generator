package com.example.kcg_intellij;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinTranslator {

    // This method converts a given Chinese text into its corresponding HanYu Pinyin representation.
    public static String textToHanYuPinyin(String text) {
        // Initialize a StringBuilder to store the resulting Pinyin string
        StringBuilder result = new StringBuilder();

        try {
            // Configure the Pinyin output format
            // Set case type to lowercase
            // Set tone type to no tone (numbers or tone marks are omitted)
            // Set 'ü' to be represented as 'v' (commonly used in typing systems)
            HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
            hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);

            // Convert the input text into a character array after trimming any leading/trailing whitespace
            char[] textChar = text.trim().toCharArray();

            // Iterate through each character in the input text
            for (char ch : textChar) {
                // Check if the character is a Chinese character (Unicode range: \u4E00 to \u9FA5)
                if (Character.toString(ch).matches("[\\u4E00-\\u9FA5]+")) {
                    // Convert the Chinese character to its corresponding Pinyin array
                    String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(ch, hanyuPinyinOutputFormat);
                    // Append the first Pinyin option to the result
                    // (Assuming no ambiguity in Pinyin options for the character)
                    result.append(pinyinArray[0]);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            // Handle any exceptions caused by an invalid Pinyin output format
            e.printStackTrace();
        }

        // Return the concatenated Pinyin result as a string
        System.out.println(result.toString());
        return result.toString();
    }


}
