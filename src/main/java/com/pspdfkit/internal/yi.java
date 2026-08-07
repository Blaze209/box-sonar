package com.pspdfkit.internal;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface yi {

    public static class a implements yi {
        public final List<xi> a;

        public a(xi... xiVarArr) {
            this.a = Arrays.asList(xiVarArr);
        }

        @Override // com.pspdfkit.internal.yi
        public final List<xi> a() {
            return this.a;
        }
    }

    List<xi> a();
}
