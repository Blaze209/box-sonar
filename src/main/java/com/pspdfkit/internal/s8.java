package com.pspdfkit.internal;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s8 {

    public static final class a extends s8 {
        public static final a a = new a();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof a);
        }

        public final int hashCode() {
            return -432069555;
        }

        public final String toString() {
            return "FileCreationFailed";
        }
    }

    public static final class b extends s8 {
        public static final b a = new b();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof b);
        }

        public final int hashCode() {
            return 675444283;
        }

        public final String toString() {
            return "NoCamera";
        }
    }

    public static final class c extends s8 {
        public final int a = 67;
        public final Uri b;

        public c(Uri uri) {
            this.b = uri;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && Intrinsics.areEqual(this.b, cVar.b);
        }

        public final int hashCode() {
            return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
        }

        public final String toString() {
            return "Success(intentFlags=" + this.a + ", tempImageUri=" + this.b + ")";
        }
    }
}
