package org.apache.hc.core5.util;

import java.util.BitSet;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Tokenizer$$ExternalSyntheticLambda2 implements Tokenizer.Delimiter {
    public final /* synthetic */ BitSet f$0;

    public /* synthetic */ Tokenizer$$ExternalSyntheticLambda2(BitSet bitSet) {
        this.f$0 = bitSet;
    }

    @Override // org.apache.hc.core5.util.Tokenizer.Delimiter
    public final boolean test(char c) {
        return this.f$0.get(c);
    }
}
