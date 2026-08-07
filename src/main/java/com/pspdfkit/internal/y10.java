package com.pspdfkit.internal;

import com.pspdfkit.signatures.Signature;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface y10 {

    public static final class a implements y10 {
        public final List<Signature> a;

        public a(List<Signature> list) {
            list.getClass();
            this.a = list;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OnCheckedItemsChanged(signatures=" + this.a + ")";
        }
    }

    public static final class b implements y10 {
        public static final b a = new b();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public final int hashCode() {
            return 1538273468;
        }

        public final String toString() {
            return "OnCheckedItemsCleared";
        }
    }

    public static final class c implements y10 {
        public final Signature a;

        public c(Signature signature) {
            signature.getClass();
            this.a = signature;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.areEqual(this.a, ((c) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OnSignaturePicked(signature=" + this.a + ")";
        }
    }
}
