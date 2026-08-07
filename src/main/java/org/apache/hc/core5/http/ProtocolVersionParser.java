package org.apache.hc.core5.http;

import org.apache.hc.core5.util.TextUtils;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class ProtocolVersionParser {
    private static final char FULL_STOP = '.';
    private static final char SLASH = '/';
    private final Tokenizer tokenizer = Tokenizer.INSTANCE;
    public static final ProtocolVersionParser INSTANCE = new ProtocolVersionParser();
    private static final Tokenizer.Delimiter PROTO_DELIMITER = Tokenizer.delimiters('/');
    private static final Tokenizer.Delimiter FULL_STOP_OR_BLANK = Tokenizer.delimiters('.', ' ', '\t');
    private static final Tokenizer.Delimiter BLANK = Tokenizer.delimiters(' ', '\t');

    @FunctionalInterface
    public interface Factory {
        ProtocolVersion create(int i, int i2);
    }

    public ProtocolVersion parse(String str, Factory factory, CharSequence charSequence, Tokenizer.Cursor cursor, final Tokenizer.Delimiter delimiter) throws ParseException {
        int lowerBound = cursor.getLowerBound();
        int upperBound = cursor.getUpperBound();
        try {
            int i = Integer.parseInt(this.tokenizer.parseToken(charSequence, cursor, delimiter != null ? new Tokenizer.Delimiter() { // from class: org.apache.hc.core5.http.ProtocolVersionParser$$ExternalSyntheticLambda0
                @Override // org.apache.hc.core5.util.Tokenizer.Delimiter
                public final boolean test(char c) {
                    return ProtocolVersionParser.lambda$parse$0(delimiter, c);
                }
            } : FULL_STOP_OR_BLANK));
            if (cursor.atEnd()) {
                return factory != null ? factory.create(i, i) : new ProtocolVersion(str, i, 0);
            }
            if (charSequence.charAt(cursor.getPos()) != '.') {
                return factory != null ? factory.create(i, i) : new ProtocolVersion(str, i, 0);
            }
            cursor.updatePos(cursor.getPos() + 1);
            try {
                int i2 = Integer.parseInt(this.tokenizer.parseToken(charSequence, cursor, delimiter != null ? new Tokenizer.Delimiter() { // from class: org.apache.hc.core5.http.ProtocolVersionParser$$ExternalSyntheticLambda1
                    @Override // org.apache.hc.core5.util.Tokenizer.Delimiter
                    public final boolean test(char c) {
                        return ProtocolVersionParser.lambda$parse$1(delimiter, c);
                    }
                } : BLANK));
                return factory != null ? factory.create(i, i2) : new ProtocolVersion(str, i, i2);
            } catch (NumberFormatException unused) {
                throw new ParseException("Invalid " + str + " minor version number", charSequence, lowerBound, upperBound, cursor.getPos());
            }
        } catch (NumberFormatException unused2) {
            throw new ParseException("Invalid " + str + " major version number", charSequence, lowerBound, upperBound, cursor.getPos());
        }
    }

    static /* synthetic */ boolean lambda$parse$0(Tokenizer.Delimiter delimiter, char c) {
        return delimiter.test(c) || FULL_STOP_OR_BLANK.test(c);
    }

    static /* synthetic */ boolean lambda$parse$1(Tokenizer.Delimiter delimiter, char c) {
        return delimiter.test(c) || BLANK.test(c);
    }

    public ProtocolVersion parse(String str, CharSequence charSequence, Tokenizer.Cursor cursor, Tokenizer.Delimiter delimiter) throws ParseException {
        return parse(str, null, charSequence, cursor, delimiter);
    }

    public ProtocolVersion parse(String str, CharSequence charSequence, Tokenizer.Cursor cursor) throws ParseException {
        return parse(str, null, charSequence, cursor, null);
    }

    public ProtocolVersion parse(CharSequence charSequence, Tokenizer.Cursor cursor, Tokenizer.Delimiter delimiter) throws ParseException {
        this.tokenizer.skipWhiteSpace(charSequence, cursor);
        String token = this.tokenizer.parseToken(charSequence, cursor, PROTO_DELIMITER);
        if (TextUtils.isBlank(token)) {
            throw new ParseException("Invalid protocol name");
        }
        if (!cursor.atEnd() && charSequence.charAt(cursor.getPos()) == '/') {
            cursor.updatePos(cursor.getPos() + 1);
            return parse(token, null, charSequence, cursor, delimiter);
        }
        throw new ParseException("Invalid protocol name");
    }
}
