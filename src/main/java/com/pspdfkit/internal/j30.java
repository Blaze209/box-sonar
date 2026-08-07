package com.pspdfkit.internal;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.j30[], still in use, count: 1, list:
  (r0v1 com.pspdfkit.internal.j30[]) from 0x0038: INVOKE (r0v1 com.pspdfkit.internal.j30[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class j30 {
    STOPPED,
    RECORDING,
    RECORDING_PAUSED,
    PLAYING,
    PLAYING_PAUSED;

    static {
        EnumEntriesKt.enumEntries(j30VarArr);
    }

    public j30() {
        super(str, i);
    }

    public static j30 valueOf(String str) {
        return (j30) Enum.valueOf(j30.class, str);
    }

    public static j30[] values() {
        return (j30[]) f.clone();
    }
}
