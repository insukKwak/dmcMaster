package com.our.project.core.security;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 */
public class PasswordGenerator {
    /** 로그 */
    final static Logger         logger                  = LoggerFactory.getLogger( PasswordGenerator.class );

    /** ?��?��, ?��문자, ??문자 문자 배열 */
    private static final String WORDS[]                 = { "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    /** ?��?�� 문자 배열 */
    private static final String WORDS_NO[]              = { "2", "3", "4", "5", "6", "7", "8", "9" };
    /** ?��문자 문자 배열 */
    private static final String WORDS_LOWER[]           = { "a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
    /** ??문자 문자 배열 */
    private static final String WORDS_UPPER[]           = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    /** ??문자 AND ?��?�� 문자 배열 */
    private static final String WORDS_UPPERNO[]         = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "2", "3", "4", "5", "6", "7", "8", "9" };

    /** 기본 ?��?�� ( 8?�� ) */
    public static final String  PASSTYPE_NORMAL         = "NORMAL";
    /** ?��문자4?�� ?��?��4?�� ?��?�� */
    public static final String  PASSTYPE_LOW4NO4        = "abcd1234";
    /** ??문자4?�� ?��?��4?�� ?��?�� */
    public static final String  PASSTYPE_UPP4NO4        = "ABCD1234";
    /** ?��문자2?�� ?��?��2?�� ?��문자2?�� ?��?��2?�� ?��?�� */
    public static final String  PASSTYPE_LOW2NO2LOW2NO2 = "ab12cd34";
    /** ??문자 OR ?��?�� 10?�� ?��?�� */
    public static final String  RANDOM10                = "RANDOM10";

    /**
     * 비�?번호 ?��?��<br/>
     *
     * @return 8?�� 길이 비�?번호
     */
    public static String getPassword() {
        return getPassword( 8 );
    }

    /**
     * 비�?번호 ?��?��<br/>
     *
     * @param length 비�?번호 길이
     * @return 비�?번호
     */
    public static String getPassword(int length) {
        if ( length < 1 || length > 10 ) {
            length = 10;
        }

        String imsiPassword = "";

        for ( int i = 0; i < length; i++ ) {
            imsiPassword = getWord( imsiPassword, WORDS );
        }

        return imsiPassword;
    }

    /**
     * 비�?번호 ?��?��<br/>
     *
     * @param passtype 비�?번호 ???��
     * @return 비�?번호
     */
    public static String getPassword(String passtype) {
        String imsiPassword = "";

        // ?��문자4?�� ?��?��4?�� ?��?��
        if ( PASSTYPE_LOW4NO4.equals( passtype ) ) {
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_LOWER );
            }
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_NO );
            }
        }
        // ??문자4?�� ?��?��4?�� ?��?��
        else if ( PASSTYPE_UPP4NO4.equals( passtype ) ) {
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_UPPER );
            }
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_NO );
            }
        }
        // ?��문자2?�� ?��?��2?�� ?��문자2?�� ?��?��2?�� ?��?��
        else if ( PASSTYPE_LOW2NO2LOW2NO2.equals( passtype ) ) {
            for ( int i = 0; i < 2; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_LOWER );
            }
            for ( int i = 0; i < 2; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_NO );
            }
            for ( int i = 0; i < 2; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_LOWER );
            }
            for ( int i = 0; i < 2; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_NO );
            }
        }
        // ??문자?��거나 ?��?��?�� 10?�� ?��?��
        else if ( RANDOM10.equals( passtype ) ) {
            for ( int i = 0; i < 10; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_UPPERNO );
            }
        }
        else {
            imsiPassword = getPassword( 8 );
        }

        return imsiPassword;
    }

    /**
     * 중복?�� ?��?��?�� 비�?번호 문자?�� ?��?��<br/>
     *
     * @param imsiPassword �?금까�? ?��?��?�� 비�?번호 문자?��
     * @param words ?��?��?���? 뽑을 문자배열
     * @return ?��?��?�� 비�?번호 문자?��
     */
    private static String getWord(String imsiPassword, String words[]) {
        Random random = new Random();

        String word = words[random.nextInt( words.length )];
        while ( imsiPassword.indexOf( word ) > -1 ) {
            word = words[random.nextInt( words.length )];
        }

        imsiPassword += word;

        return imsiPassword;
    }
}
