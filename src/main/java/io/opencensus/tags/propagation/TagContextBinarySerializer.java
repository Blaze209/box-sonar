package io.opencensus.tags.propagation;

import io.opencensus.tags.TagContext;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TagContextBinarySerializer {
    public abstract TagContext fromByteArray(byte[] bArr) throws TagContextDeserializationException;

    public abstract byte[] toByteArray(TagContext tagContext) throws TagContextSerializationException;
}
