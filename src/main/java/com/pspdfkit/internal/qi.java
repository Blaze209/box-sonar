package com.pspdfkit.internal;

import androidx.collection.LruCache;

/* JADX INFO: loaded from: classes3.dex */
public final class qi extends LruCache<String, q8> {
    public qi() {
        super(10);
    }

    @Override // androidx.collection.LruCache
    public final void entryRemoved(boolean z, String str, q8 q8Var, q8 q8Var2) {
        String str2 = str;
        q8 q8Var3 = q8Var;
        str2.getClass();
        q8Var3.getClass();
        super.entryRemoved(z, str2, q8Var3, q8Var2);
        q8Var3.a.b();
    }
}
