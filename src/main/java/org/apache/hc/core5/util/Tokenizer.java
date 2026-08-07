package org.apache.hc.core5.util;

import java.util.BitSet;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
public class Tokenizer {
    public static final int CR = 13;
    public static final char DQUOTE = '\"';
    public static final char ESCAPE = '\\';
    public static final int HT = 9;
    public static final Tokenizer INSTANCE = new Tokenizer();
    public static final int LF = 10;
    public static final int SP = 32;

    @FunctionalInterface
    public interface Delimiter {
        boolean test(char c);
    }

    public static boolean isWhitespace(char c) {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n';
    }

    static /* synthetic */ boolean lambda$delimiters$1(char c, char c2) {
        return c2 == c;
    }

    static /* synthetic */ boolean lambda$delimiters$2(char c, char c2, char c3) {
        return c3 == c || c3 == c2;
    }

    static /* synthetic */ boolean lambda$delimiters$3(char c, char c2, char c3, char c4) {
        return c4 == c || c4 == c2 || c4 == c3;
    }

    public static class Cursor {
        private final int lowerBound;
        private int pos;
        private final int upperBound;

        public Cursor(int i, int i2) {
            Args.notNegative(i, "lowerBound");
            Args.check(i <= i2, "lowerBound cannot be greater than upperBound");
            this.lowerBound = i;
            this.upperBound = i2;
            this.pos = i;
        }

        public int getLowerBound() {
            return this.lowerBound;
        }

        public int getUpperBound() {
            return this.upperBound;
        }

        public int getPos() {
            return this.pos;
        }

        public void updatePos(int i) {
            Args.check(i >= this.lowerBound, "pos: %s < lowerBound: %s", Integer.valueOf(i), Integer.valueOf(this.lowerBound));
            Args.check(i <= this.upperBound, "pos: %s > upperBound: %s", Integer.valueOf(i), Integer.valueOf(this.upperBound));
            this.pos = i;
        }

        public boolean atEnd() {
            return this.pos >= this.upperBound;
        }

        public String toString() {
            return "[" + this.lowerBound + Typography.greater + this.pos + Typography.greater + this.upperBound + AbstractJsonLexerKt.END_LIST;
        }
    }

    @Deprecated
    public static BitSet INIT_BITSET(int... iArr) {
        BitSet bitSet = new BitSet();
        for (int i : iArr) {
            bitSet.set(i);
        }
        return bitSet;
    }

    public static Delimiter delimiters(BitSet bitSet) {
        bitSet.getClass();
        return new Tokenizer$$ExternalSyntheticLambda2(bitSet);
    }

    public static Delimiter delimiters(final char... cArr) {
        return new Delimiter() { // from class: org.apache.hc.core5.util.Tokenizer$$ExternalSyntheticLambda4
            @Override // org.apache.hc.core5.util.Tokenizer.Delimiter
            public final boolean test(char c) {
                return Tokenizer.lambda$delimiters$0(cArr, c);
            }
        };
    }

    static /* synthetic */ boolean lambda$delimiters$0(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public static Delimiter delimiters(final char c) {
        return new Delimiter() { // from class: org.apache.hc.core5.util.Tokenizer$$ExternalSyntheticLambda3
            @Override // org.apache.hc.core5.util.Tokenizer.Delimiter
            public final boolean test(char c2) {
                return Tokenizer.lambda$delimiters$1(c, c2);
            }
        };
    }

    public static Delimiter delimiters(final char c, final char c2) {
        return new Delimiter() { // from class: org.apache.hc.core5.util.Tokenizer$$ExternalSyntheticLambda1
            @Override // org.apache.hc.core5.util.Tokenizer.Delimiter
            public final boolean test(char c3) {
                return Tokenizer.lambda$delimiters$2(c, c2, c3);
            }
        };
    }

    public static Delimiter delimiters(final char c, final char c2, final char c3) {
        return new Delimiter() { // from class: org.apache.hc.core5.util.Tokenizer$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.util.Tokenizer.Delimiter
            public final boolean test(char c4) {
                return Tokenizer.lambda$delimiters$3(c, c2, c3, c4);
            }
        };
    }

    public String parseContent(CharSequence charSequence, Cursor cursor, Delimiter delimiter) {
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(cursor, "Parser cursor");
        StringBuilder sb = new StringBuilder();
        copyContent(charSequence, cursor, delimiter, sb);
        return sb.toString();
    }

    @Deprecated
    public String parseContent(CharSequence charSequence, Cursor cursor, BitSet bitSet) {
        Tokenizer$$ExternalSyntheticLambda2 tokenizer$$ExternalSyntheticLambda2;
        if (bitSet != null) {
            bitSet.getClass();
            tokenizer$$ExternalSyntheticLambda2 = new Tokenizer$$ExternalSyntheticLambda2(bitSet);
        } else {
            tokenizer$$ExternalSyntheticLambda2 = null;
        }
        return parseContent(charSequence, cursor, tokenizer$$ExternalSyntheticLambda2);
    }

    public String parseToken(CharSequence charSequence, Cursor cursor, Delimiter delimiter) {
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(cursor, "Parser cursor");
        StringBuilder sb = new StringBuilder();
        loop0: while (true) {
            boolean z = false;
            while (true) {
                if (!cursor.atEnd()) {
                    char cCharAt = charSequence.charAt(cursor.getPos());
                    if (delimiter != null && delimiter.test(cCharAt)) {
                        break loop0;
                    }
                    if (isWhitespace(cCharAt)) {
                        skipWhiteSpace(charSequence, cursor);
                        z = true;
                    }
                } else {
                    break loop0;
                }
            }
            if (z && sb.length() > 0) {
                sb.append(' ');
            }
            copyContent(charSequence, cursor, delimiter, sb);
        }
        return sb.toString();
    }

    @Deprecated
    public String parseToken(CharSequence charSequence, Cursor cursor, BitSet bitSet) {
        Tokenizer$$ExternalSyntheticLambda2 tokenizer$$ExternalSyntheticLambda2;
        if (bitSet != null) {
            bitSet.getClass();
            tokenizer$$ExternalSyntheticLambda2 = new Tokenizer$$ExternalSyntheticLambda2(bitSet);
        } else {
            tokenizer$$ExternalSyntheticLambda2 = null;
        }
        return parseToken(charSequence, cursor, tokenizer$$ExternalSyntheticLambda2);
    }

    public String parseValue(CharSequence charSequence, Cursor cursor, Delimiter delimiter) {
        char cCharAt;
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(cursor, "Parser cursor");
        StringBuilder sb = new StringBuilder();
        loop0: while (true) {
            boolean z = false;
            while (true) {
                if (!cursor.atEnd()) {
                    cCharAt = charSequence.charAt(cursor.getPos());
                    if (delimiter != null && delimiter.test(cCharAt)) {
                        break loop0;
                    }
                    if (isWhitespace(cCharAt)) {
                        skipWhiteSpace(charSequence, cursor);
                        z = true;
                    }
                } else {
                    break loop0;
                }
            }
            if (cCharAt == '\"') {
                if (z && sb.length() > 0) {
                    sb.append(' ');
                }
                copyQuotedContent(charSequence, cursor, sb);
            } else {
                if (z && sb.length() > 0) {
                    sb.append(' ');
                }
                copyUnquotedContent(charSequence, cursor, delimiter, sb);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public String parseValue(CharSequence charSequence, Cursor cursor, BitSet bitSet) {
        Tokenizer$$ExternalSyntheticLambda2 tokenizer$$ExternalSyntheticLambda2;
        if (bitSet != null) {
            bitSet.getClass();
            tokenizer$$ExternalSyntheticLambda2 = new Tokenizer$$ExternalSyntheticLambda2(bitSet);
        } else {
            tokenizer$$ExternalSyntheticLambda2 = null;
        }
        return parseValue(charSequence, cursor, tokenizer$$ExternalSyntheticLambda2);
    }

    public void skipWhiteSpace(CharSequence charSequence, Cursor cursor) {
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(cursor, "Parser cursor");
        int pos = cursor.getPos();
        int upperBound = cursor.getUpperBound();
        for (int pos2 = cursor.getPos(); pos2 < upperBound && isWhitespace(charSequence.charAt(pos2)); pos2++) {
            pos++;
        }
        cursor.updatePos(pos);
    }

    public void copyContent(CharSequence charSequence, Cursor cursor, Delimiter delimiter, StringBuilder sb) {
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(cursor, "Parser cursor");
        Args.notNull(sb, "String builder");
        int pos = cursor.getPos();
        int upperBound = cursor.getUpperBound();
        for (int pos2 = cursor.getPos(); pos2 < upperBound; pos2++) {
            char cCharAt = charSequence.charAt(pos2);
            if ((delimiter != null && delimiter.test(cCharAt)) || isWhitespace(cCharAt)) {
                break;
            }
            pos++;
            sb.append(cCharAt);
        }
        cursor.updatePos(pos);
    }

    @Deprecated
    public void copyContent(CharSequence charSequence, Cursor cursor, BitSet bitSet, StringBuilder sb) {
        Tokenizer$$ExternalSyntheticLambda2 tokenizer$$ExternalSyntheticLambda2;
        if (bitSet != null) {
            bitSet.getClass();
            tokenizer$$ExternalSyntheticLambda2 = new Tokenizer$$ExternalSyntheticLambda2(bitSet);
        } else {
            tokenizer$$ExternalSyntheticLambda2 = null;
        }
        copyContent(charSequence, cursor, tokenizer$$ExternalSyntheticLambda2, sb);
    }

    public void copyUnquotedContent(CharSequence charSequence, Cursor cursor, Delimiter delimiter, StringBuilder sb) {
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(cursor, "Parser cursor");
        Args.notNull(sb, "String builder");
        int pos = cursor.getPos();
        int upperBound = cursor.getUpperBound();
        for (int pos2 = cursor.getPos(); pos2 < upperBound; pos2++) {
            char cCharAt = charSequence.charAt(pos2);
            if ((delimiter != null && delimiter.test(cCharAt)) || isWhitespace(cCharAt) || cCharAt == '\"') {
                break;
            }
            pos++;
            sb.append(cCharAt);
        }
        cursor.updatePos(pos);
    }

    @Deprecated
    public void copyUnquotedContent(CharSequence charSequence, Cursor cursor, BitSet bitSet, StringBuilder sb) {
        Tokenizer$$ExternalSyntheticLambda2 tokenizer$$ExternalSyntheticLambda2;
        if (bitSet != null) {
            bitSet.getClass();
            tokenizer$$ExternalSyntheticLambda2 = new Tokenizer$$ExternalSyntheticLambda2(bitSet);
        } else {
            tokenizer$$ExternalSyntheticLambda2 = null;
        }
        copyUnquotedContent(charSequence, cursor, tokenizer$$ExternalSyntheticLambda2, sb);
    }

    public void copyQuotedContent(CharSequence charSequence, Cursor cursor, StringBuilder sb) {
        Args.notNull(charSequence, "Char sequence");
        Args.notNull(cursor, "Parser cursor");
        Args.notNull(sb, "String builder");
        if (cursor.atEnd()) {
            return;
        }
        int pos = cursor.getPos();
        int pos2 = cursor.getPos();
        int upperBound = cursor.getUpperBound();
        if (charSequence.charAt(pos) != '\"') {
            return;
        }
        int i = pos + 1;
        int i2 = pos2 + 1;
        boolean z = false;
        while (i2 < upperBound) {
            char cCharAt = charSequence.charAt(i2);
            if (z) {
                if (cCharAt != '\"' && cCharAt != '\\') {
                    sb.append('\\');
                }
                sb.append(cCharAt);
                z = false;
            } else if (cCharAt == '\"') {
                i++;
                break;
            } else if (cCharAt == '\\') {
                z = true;
            } else if (cCharAt != '\r' && cCharAt != '\n') {
                sb.append(cCharAt);
            }
            i2++;
            i++;
        }
        cursor.updatePos(i);
    }
}
