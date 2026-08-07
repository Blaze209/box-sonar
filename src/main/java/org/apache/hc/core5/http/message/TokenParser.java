package org.apache.hc.core5.http.message;

import java.util.BitSet;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class TokenParser extends Tokenizer {
    public static final char DQUOTE = '\"';
    public static final char ESCAPE = '\\';
    public static final TokenParser INSTANCE = new TokenParser();

    public String parseToken(CharSequence charSequence, ParserCursor parserCursor, BitSet bitSet) {
        return super.parseToken(charSequence, (Tokenizer.Cursor) parserCursor, bitSet);
    }

    public String parseValue(CharSequence charSequence, ParserCursor parserCursor, BitSet bitSet) {
        return super.parseValue(charSequence, (Tokenizer.Cursor) parserCursor, bitSet);
    }

    public void skipWhiteSpace(CharSequence charSequence, ParserCursor parserCursor) {
        super.skipWhiteSpace(charSequence, (Tokenizer.Cursor) parserCursor);
    }

    public void copyContent(CharSequence charSequence, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb) {
        super.copyContent(charSequence, (Tokenizer.Cursor) parserCursor, bitSet, sb);
    }

    @Override // org.apache.hc.core5.util.Tokenizer
    public void copyContent(CharSequence charSequence, Tokenizer.Cursor cursor, BitSet bitSet, StringBuilder sb) {
        ParserCursor parserCursor = new ParserCursor(cursor.getLowerBound(), cursor.getUpperBound());
        parserCursor.updatePos(cursor.getPos());
        copyContent(charSequence, parserCursor, bitSet, sb);
        cursor.updatePos(parserCursor.getPos());
    }

    public void copyUnquotedContent(CharSequence charSequence, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb) {
        super.copyUnquotedContent(charSequence, (Tokenizer.Cursor) parserCursor, bitSet, sb);
    }

    @Override // org.apache.hc.core5.util.Tokenizer
    public void copyUnquotedContent(CharSequence charSequence, Tokenizer.Cursor cursor, BitSet bitSet, StringBuilder sb) {
        ParserCursor parserCursor = new ParserCursor(cursor.getLowerBound(), cursor.getUpperBound());
        parserCursor.updatePos(cursor.getPos());
        copyUnquotedContent(charSequence, parserCursor, bitSet, sb);
        cursor.updatePos(parserCursor.getPos());
    }

    public void copyQuotedContent(CharSequence charSequence, ParserCursor parserCursor, StringBuilder sb) {
        super.copyQuotedContent(charSequence, (Tokenizer.Cursor) parserCursor, sb);
    }

    @Override // org.apache.hc.core5.util.Tokenizer
    public void copyQuotedContent(CharSequence charSequence, Tokenizer.Cursor cursor, StringBuilder sb) {
        ParserCursor parserCursor = new ParserCursor(cursor.getLowerBound(), cursor.getUpperBound());
        parserCursor.updatePos(cursor.getPos());
        copyQuotedContent(charSequence, parserCursor, sb);
        cursor.updatePos(parserCursor.getPos());
    }
}
