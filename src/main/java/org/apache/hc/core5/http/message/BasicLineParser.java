package org.apache.hc.core5.http.message;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.ProtocolVersionParser;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;
import org.apache.hc.core5.util.TextUtils;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class BasicLineParser implements LineParser {
    private final ProtocolVersion protocol;
    private final Tokenizer tokenizer;
    public static final BasicLineParser INSTANCE = new BasicLineParser();
    private static final Tokenizer.Delimiter BLANKS = Tokenizer.delimiters(' ', '\t');
    private static final Tokenizer.Delimiter COLON = Tokenizer.delimiters(AbstractJsonLexerKt.COLON);

    public BasicLineParser(ProtocolVersion protocolVersion) {
        this.protocol = protocolVersion == null ? HttpVersion.HTTP_1_1 : protocolVersion;
        this.tokenizer = Tokenizer.INSTANCE;
    }

    public BasicLineParser() {
        this(null);
    }

    ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        String protocol = this.protocol.getProtocol();
        int length = protocol.length();
        this.tokenizer.skipWhiteSpace(charArrayBuffer, parserCursor);
        int pos = parserCursor.getPos();
        int i = pos + length;
        if (i + 4 > parserCursor.getUpperBound()) {
            throw new ParseException("Invalid protocol version", charArrayBuffer, parserCursor.getLowerBound(), parserCursor.getUpperBound(), parserCursor.getPos());
        }
        boolean z = true;
        for (int i2 = 0; z && i2 < length; i2++) {
            z = charArrayBuffer.charAt(pos + i2) == protocol.charAt(i2);
        }
        if (z) {
            z = charArrayBuffer.charAt(i) == '/';
        }
        if (!z) {
            throw new ParseException("Invalid protocol version", charArrayBuffer, parserCursor.getLowerBound(), parserCursor.getUpperBound(), parserCursor.getPos());
        }
        parserCursor.updatePos(i + 1);
        return ProtocolVersionParser.INSTANCE.parse(protocol, new ProtocolVersionParser.Factory() { // from class: org.apache.hc.core5.http.message.BasicLineParser$$ExternalSyntheticLambda0
            @Override // org.apache.hc.core5.http.ProtocolVersionParser.Factory
            public final ProtocolVersion create(int i3, int i4) {
                return HttpVersion.get(i3, i4);
            }
        }, charArrayBuffer, parserCursor, null);
    }

    @Override // org.apache.hc.core5.http.message.LineParser
    public RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        ParserCursor parserCursor = new ParserCursor(0, charArrayBuffer.length());
        this.tokenizer.skipWhiteSpace(charArrayBuffer, parserCursor);
        Tokenizer tokenizer = this.tokenizer;
        Tokenizer.Delimiter delimiter = BLANKS;
        String token = tokenizer.parseToken(charArrayBuffer, parserCursor, delimiter);
        if (TextUtils.isEmpty(token)) {
            throw new ParseException("Invalid request line", charArrayBuffer, parserCursor.getLowerBound(), parserCursor.getUpperBound(), parserCursor.getPos());
        }
        this.tokenizer.skipWhiteSpace(charArrayBuffer, parserCursor);
        String token2 = this.tokenizer.parseToken(charArrayBuffer, parserCursor, delimiter);
        if (TextUtils.isEmpty(token2)) {
            throw new ParseException("Invalid request line", charArrayBuffer, parserCursor.getLowerBound(), parserCursor.getUpperBound(), parserCursor.getPos());
        }
        ProtocolVersion protocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
        this.tokenizer.skipWhiteSpace(charArrayBuffer, parserCursor);
        if (!parserCursor.atEnd()) {
            throw new ParseException("Invalid request line", charArrayBuffer, parserCursor.getLowerBound(), parserCursor.getUpperBound(), parserCursor.getPos());
        }
        return new RequestLine(token, token2, protocolVersion);
    }

    @Override // org.apache.hc.core5.http.message.LineParser
    public StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        int i = 0;
        ParserCursor parserCursor = new ParserCursor(0, charArrayBuffer.length());
        this.tokenizer.skipWhiteSpace(charArrayBuffer, parserCursor);
        ProtocolVersion protocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
        this.tokenizer.skipWhiteSpace(charArrayBuffer, parserCursor);
        for (int i2 = 1; i2 <= 3; i2++) {
            if (parserCursor.atEnd()) {
                throw new ParseException("Status line contains invalid status code", charArrayBuffer, parserCursor.getLowerBound(), parserCursor.getUpperBound(), parserCursor.getPos());
            }
            char cCharAt = charArrayBuffer.charAt(parserCursor.getPos());
            if (cCharAt < '0' || cCharAt > '9') {
                throw new ParseException("Status line contains invalid status code", charArrayBuffer, parserCursor.getLowerBound(), parserCursor.getUpperBound(), parserCursor.getPos());
            }
            i = (i * 10) + (cCharAt - '0');
            parserCursor.updatePos(parserCursor.getPos() + 1);
        }
        if (!parserCursor.atEnd()) {
            if (Tokenizer.isWhitespace(charArrayBuffer.charAt(parserCursor.getPos()))) {
                parserCursor.updatePos(parserCursor.getPos() + 1);
            } else {
                throw new ParseException("Status line contains invalid status code", charArrayBuffer, parserCursor.getLowerBound(), parserCursor.getUpperBound(), parserCursor.getPos());
            }
        }
        this.tokenizer.skipWhiteSpace(charArrayBuffer, parserCursor);
        return new StatusLine(protocolVersion, i, charArrayBuffer.substringTrimmed(parserCursor.getPos(), parserCursor.getUpperBound()));
    }

    @Override // org.apache.hc.core5.http.message.LineParser
    public Header parseHeader(CharArrayBuffer charArrayBuffer) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        ParserCursor parserCursor = new ParserCursor(0, charArrayBuffer.length());
        this.tokenizer.skipWhiteSpace(charArrayBuffer, parserCursor);
        String token = this.tokenizer.parseToken(charArrayBuffer, parserCursor, COLON);
        if (parserCursor.getPos() == parserCursor.getLowerBound() || parserCursor.getPos() == parserCursor.getUpperBound() || charArrayBuffer.charAt(parserCursor.getPos()) != ':' || TextUtils.isEmpty(token) || Tokenizer.isWhitespace(charArrayBuffer.charAt(parserCursor.getPos() - 1))) {
            throw new ParseException("Invalid header", charArrayBuffer, parserCursor.getLowerBound(), parserCursor.getUpperBound(), parserCursor.getPos());
        }
        return new BasicHeader(token, charArrayBuffer.substringTrimmed(parserCursor.getPos() + 1, parserCursor.getUpperBound()));
    }
}
