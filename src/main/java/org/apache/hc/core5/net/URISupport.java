package org.apache.hc.core5.net;

import java.net.URISyntaxException;
import java.util.BitSet;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.hc.core5.util.Tokenizer;

/* JADX INFO: loaded from: classes5.dex */
final class URISupport {
    static final Tokenizer.Delimiter DELIMITERS;
    static final Tokenizer.Delimiter HOST_DELIMITERS;
    private static final BitSet HOST_SEPARATORS;
    static final Tokenizer.Delimiter IPV6_HOST_DELIMITERS;
    static final Tokenizer.Delimiter PORT_DELIMITERS;
    private static final BitSet PORT_SEPARATORS;
    private static final BitSet TERMINATORS;

    URISupport() {
    }

    static {
        BitSet bitSet = new BitSet(256);
        HOST_SEPARATORS = bitSet;
        BitSet bitSet2 = new BitSet(256);
        PORT_SEPARATORS = bitSet2;
        BitSet bitSet3 = new BitSet(256);
        TERMINATORS = bitSet3;
        bitSet3.set(47);
        bitSet3.set(35);
        bitSet3.set(63);
        bitSet.or(bitSet3);
        bitSet.set(64);
        bitSet2.or(bitSet3);
        bitSet2.set(58);
        DELIMITERS = Tokenizer.delimiters(bitSet3);
        HOST_DELIMITERS = Tokenizer.delimiters(bitSet);
        IPV6_HOST_DELIMITERS = Tokenizer.delimiters(AbstractJsonLexerKt.END_LIST);
        PORT_DELIMITERS = Tokenizer.delimiters(bitSet2);
    }

    static URISyntaxException createException(CharSequence charSequence, Tokenizer.Cursor cursor, String str) {
        return new URISyntaxException(charSequence.subSequence(cursor.getLowerBound(), cursor.getUpperBound()).toString(), str, cursor.getPos());
    }
}
