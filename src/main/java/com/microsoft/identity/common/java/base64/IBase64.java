package com.microsoft.identity.common.java.base64;

import kotlin.Metadata;

/* JADX INFO: compiled from: IBase64.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H&¢\u0006\u0002\u0010\bJ)\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H&¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/microsoft/identity/common/java/base64/IBase64;", "", "decode", "", "input", "flags", "", "Lcom/microsoft/identity/common/java/base64/Base64Flags;", "([B[Lcom/microsoft/identity/common/java/base64/Base64Flags;)[B", "encode", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IBase64 {
    byte[] decode(byte[] input, Base64Flags... flags);

    byte[] encode(byte[] input, Base64Flags... flags);
}
