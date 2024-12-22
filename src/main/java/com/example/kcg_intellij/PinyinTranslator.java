package com.example.kcg_intellij;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinTranslator {

    public static String textToHanYuPinyin(String text) {
        StringBuilder result = new StringBuilder();
        try {
            // Configure the Pinyin output format (lowercase, no tone, 'v' for 'ü')
            HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
            hanyuPinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);

            // Convert the input text character by character
            char[] textChar = text.trim().toCharArray();
            for (char ch : textChar) {
                if (Character.toString(ch).matches("[\\u4E00-\\u9FA5]+")) {
                    // Convert Chinese character to Pinyin
                    String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(ch, hanyuPinyinOutputFormat);
                    result.append(pinyinArray[0]); // Always take the first Pinyin option
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
