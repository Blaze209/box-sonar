package com.pspdfkit.internal;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class l5 {
    public final ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();

    public static abstract class a {

        /* JADX INFO: renamed from: com.pspdfkit.internal.l5$a$a, reason: collision with other inner class name */
        public static final class C0277a extends a {
            public static final C0277a a = new C0277a();

            public final boolean equals(Object obj) {
                return this == obj || (obj instanceof C0277a);
            }

            public final int hashCode() {
                return -713277065;
            }

            public final String toString() {
                return "Pending";
            }
        }

        public static final class b extends a {
            public final boolean a;

            public b(boolean z) {
                this.a = z;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && this.a == ((b) obj).a;
            }

            public final int hashCode() {
                return Boolean.hashCode(this.a);
            }

            public final String toString() {
                return "Resolved(hasApStream=" + this.a + ")";
            }
        }
    }
}
