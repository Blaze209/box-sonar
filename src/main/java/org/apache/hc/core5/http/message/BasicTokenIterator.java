package org.apache.hc.core5.http.message;

import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.util.TextUtils;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
public class BasicTokenIterator extends AbstractHeaderElementIterator<String> {
    private static final Tokenizer.Delimiter COMMA = Tokenizer.delimiters(AbstractJsonLexerKt.COMMA);
    private final Tokenizer tokenizer;

    @Override // org.apache.hc.core5.http.message.AbstractHeaderElementIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ boolean hasNext() {
        return super.hasNext();
    }

    @Override // org.apache.hc.core5.http.message.AbstractHeaderElementIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() throws UnsupportedOperationException {
        super.remove();
    }

    public BasicTokenIterator(Iterator<? extends Header> it) {
        super(it);
        this.tokenizer = Tokenizer.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.hc.core5.http.message.AbstractHeaderElementIterator
    public String parseHeaderElement(CharSequence charSequence, ParserCursor parserCursor) {
        String token = this.tokenizer.parseToken(charSequence, parserCursor, COMMA);
        if (!parserCursor.atEnd()) {
            int pos = parserCursor.getPos();
            if (charSequence.charAt(pos) == ',') {
                parserCursor.updatePos(pos + 1);
            }
        }
        if (TextUtils.isBlank(token)) {
            return null;
        }
        return token;
    }
}
