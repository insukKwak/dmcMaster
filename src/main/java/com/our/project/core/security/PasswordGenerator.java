package com.our.project.core.security;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 */
public class PasswordGenerator {
    /** λ‘κ·Έ */
    final static Logger         logger                  = LoggerFactory.getLogger( PasswordGenerator.class );

    /** ?«?, ?λ¬Έμ, ??λ¬Έμ λ¬Έμ λ°°μ΄ */
    private static final String WORDS[]                 = { "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    /** ?«? λ¬Έμ λ°°μ΄ */
    private static final String WORDS_NO[]              = { "2", "3", "4", "5", "6", "7", "8", "9" };
    /** ?λ¬Έμ λ¬Έμ λ°°μ΄ */
    private static final String WORDS_LOWER[]           = { "a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
    /** ??λ¬Έμ λ¬Έμ λ°°μ΄ */
    private static final String WORDS_UPPER[]           = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    /** ??λ¬Έμ AND ?«? λ¬Έμ λ°°μ΄ */
    private static final String WORDS_UPPERNO[]         = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "2", "3", "4", "5", "6", "7", "8", "9" };

    /** κΈ°λ³Έ ?? ( 8? ) */
    public static final String  PASSTYPE_NORMAL         = "NORMAL";
    /** ?λ¬Έμ4? ?«?4? ?? */
    public static final String  PASSTYPE_LOW4NO4        = "abcd1234";
    /** ??λ¬Έμ4? ?«?4? ?? */
    public static final String  PASSTYPE_UPP4NO4        = "ABCD1234";
    /** ?λ¬Έμ2? ?«?2? ?λ¬Έμ2? ?«?2? ?? */
    public static final String  PASSTYPE_LOW2NO2LOW2NO2 = "ab12cd34";
    /** ??λ¬Έμ OR ?«? 10? ?? */
    public static final String  RANDOM10                = "RANDOM10";

    /**
     * λΉλ?λ²νΈ ??±<br/>
     *
     * @return 8? κΈΈμ΄ λΉλ?λ²νΈ
     */
    public static String getPassword() {
        return getPassword( 8 );
    }

    /**
     * λΉλ?λ²νΈ ??±<br/>
     *
     * @param length λΉλ?λ²νΈ κΈΈμ΄
     * @return λΉλ?λ²νΈ
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
     * λΉλ?λ²νΈ ??±<br/>
     *
     * @param passtype λΉλ?λ²νΈ ???
     * @return λΉλ?λ²νΈ
     */
    public static String getPassword(String passtype) {
        String imsiPassword = "";

        // ?λ¬Έμ4? ?«?4? ??
        if ( PASSTYPE_LOW4NO4.equals( passtype ) ) {
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_LOWER );
            }
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_NO );
            }
        }
        // ??λ¬Έμ4? ?«?4? ??
        else if ( PASSTYPE_UPP4NO4.equals( passtype ) ) {
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_UPPER );
            }
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_NO );
            }
        }
        // ?λ¬Έμ2? ?«?2? ?λ¬Έμ2? ?«?2? ??
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
        // ??λ¬Έμ?΄κ±°λ ?«??Έ 10? ??
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
     * μ€λ³΅? ? ?Έ? λΉλ?λ²νΈ λ¬Έμ?΄ ??±<br/>
     *
     * @param imsiPassword μ§?κΈκΉμ§? ??±? λΉλ?λ²νΈ λ¬Έμ?΄
     * @param words ??€?Όλ‘? λ½μ λ¬Έμλ°°μ΄
     * @return ??±? λΉλ?λ²νΈ λ¬Έμ?΄
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
