package com.pspdfkit.forms;

import com.pspdfkit.internal.fm;
import com.pspdfkit.internal.lm;

/* JADX INFO: loaded from: classes3.dex */
public class FormProviderFactory {
    public static fm createFromInternalDocument(lm lmVar) {
        return new FormProviderImpl(lmVar);
    }
}
