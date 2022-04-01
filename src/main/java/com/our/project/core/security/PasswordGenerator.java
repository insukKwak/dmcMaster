package com.our.project.core.security;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *
 */
public class PasswordGenerator {
    /** ë¡œê·¸ */
    final static Logger         logger                  = LoggerFactory.getLogger( PasswordGenerator.class );

    /** ?ˆ«?, ?†Œë¬¸ì, ??ë¬¸ì ë¬¸ì ë°°ì—´ */
    private static final String WORDS[]                 = { "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    /** ?ˆ«? ë¬¸ì ë°°ì—´ */
    private static final String WORDS_NO[]              = { "2", "3", "4", "5", "6", "7", "8", "9" };
    /** ?†Œë¬¸ì ë¬¸ì ë°°ì—´ */
    private static final String WORDS_LOWER[]           = { "a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
    /** ??ë¬¸ì ë¬¸ì ë°°ì—´ */
    private static final String WORDS_UPPER[]           = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    /** ??ë¬¸ì AND ?ˆ«? ë¬¸ì ë°°ì—´ */
    private static final String WORDS_UPPERNO[]         = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "2", "3", "4", "5", "6", "7", "8", "9" };

    /** ê¸°ë³¸ ?˜•?‹ ( 8? ) */
    public static final String  PASSTYPE_NORMAL         = "NORMAL";
    /** ?†Œë¬¸ì4? ?ˆ«?4? ?˜•?‹ */
    public static final String  PASSTYPE_LOW4NO4        = "abcd1234";
    /** ??ë¬¸ì4? ?ˆ«?4? ?˜•?‹ */
    public static final String  PASSTYPE_UPP4NO4        = "ABCD1234";
    /** ?†Œë¬¸ì2? ?ˆ«?2? ?†Œë¬¸ì2? ?ˆ«?2? ?˜•?‹ */
    public static final String  PASSTYPE_LOW2NO2LOW2NO2 = "ab12cd34";
    /** ??ë¬¸ì OR ?ˆ«? 10? ?˜•?‹ */
    public static final String  RANDOM10                = "RANDOM10";

    /**
     * ë¹„ë?ë²ˆí˜¸ ?ƒ?„±<br/>
     *
     * @return 8? ê¸¸ì´ ë¹„ë?ë²ˆí˜¸
     */
    public static String getPassword() {
        return getPassword( 8 );
    }

    /**
     * ë¹„ë?ë²ˆí˜¸ ?ƒ?„±<br/>
     *
     * @param length ë¹„ë?ë²ˆí˜¸ ê¸¸ì´
     * @return ë¹„ë?ë²ˆí˜¸
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
     * ë¹„ë?ë²ˆí˜¸ ?ƒ?„±<br/>
     *
     * @param passtype ë¹„ë?ë²ˆí˜¸ ???…
     * @return ë¹„ë?ë²ˆí˜¸
     */
    public static String getPassword(String passtype) {
        String imsiPassword = "";

        // ?†Œë¬¸ì4? ?ˆ«?4? ?˜•?‹
        if ( PASSTYPE_LOW4NO4.equals( passtype ) ) {
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_LOWER );
            }
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_NO );
            }
        }
        // ??ë¬¸ì4? ?ˆ«?4? ?˜•?‹
        else if ( PASSTYPE_UPP4NO4.equals( passtype ) ) {
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_UPPER );
            }
            for ( int i = 0; i < 4; i++ ) {
                imsiPassword = getWord( imsiPassword, WORDS_NO );
            }
        }
        // ?†Œë¬¸ì2? ?ˆ«?2? ?†Œë¬¸ì2? ?ˆ«?2? ?˜•?‹
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
        // ??ë¬¸ì?´ê±°ë‚˜ ?ˆ«??¸ 10? ?˜•?‹
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
     * ì¤‘ë³µ?„ ? œ?™¸?•œ ë¹„ë?ë²ˆí˜¸ ë¬¸ì?—´ ?ƒ?„±<br/>
     *
     * @param imsiPassword ì§?ê¸ˆê¹Œì§? ?ƒ?„±?œ ë¹„ë?ë²ˆí˜¸ ë¬¸ì?—´
     * @param words ?œ?¤?œ¼ë¡? ë½‘ì„ ë¬¸ìë°°ì—´
     * @return ?™„?„±?œ ë¹„ë?ë²ˆí˜¸ ë¬¸ì?—´
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
