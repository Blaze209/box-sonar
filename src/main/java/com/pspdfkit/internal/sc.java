package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeContentEditingCommand;
import com.pspdfkit.utils.Size;

/* JADX INFO: loaded from: classes3.dex */
public final class sc extends zi {
    public final NativeContentEditingCommand e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sc(int i, Size size) {
        super(i, size);
        size.getClass();
        this.e = NativeContentEditingCommand.DETECT_PARAGRAPHS;
    }

    @Override // com.pspdfkit.internal.ga
    public final NativeContentEditingCommand d() {
        return this.e;
    }
}
