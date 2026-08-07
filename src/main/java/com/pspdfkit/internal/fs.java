package com.pspdfkit.internal;

import com.pspdfkit.R;
import java.util.List;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
public interface fs {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.fs$a[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.fs$a[]) from 0x002a: INVOKE (r0v1 com.pspdfkit.internal.fs$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
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
    public static final class a {
        SHARE(R.id.pspdf__note_editor_option_share),
        SET_STATUS(R.id.pspdf__note_editor_option_set_reply_status),
        DELETE(R.id.pspdf__note_editor_option_delete_reply);

        public final int a;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public a(int i) {
            super(str, i);
            this.a = i;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) e.clone();
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.fs$b[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.fs$b[]) from 0x0042: INVOKE (r0v1 com.pspdfkit.internal.fs$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m), WRAPPED]
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
    public static final class b {
        /* JADX INFO: Fake field, exist only in values array */
        ACCEPTED(R.drawable.pspdf__ic_status_accepted, R.string.pspdf__reply_status_accepted),
        /* JADX INFO: Fake field, exist only in values array */
        REJECTED(R.drawable.pspdf__ic_status_rejected, R.string.pspdf__reply_status_rejected),
        /* JADX INFO: Fake field, exist only in values array */
        CANCELLED(R.drawable.pspdf__ic_status_cancelled, R.string.pspdf__reply_status_cancelled),
        /* JADX INFO: Fake field, exist only in values array */
        COMPLETED(R.drawable.pspdf__ic_status_completed, R.string.pspdf__reply_status_completed),
        /* JADX INFO: Fake field, exist only in values array */
        NONE(R.drawable.pspdf__ic_status_clear, R.string.pspdf__reply_status_none);

        public static final /* synthetic */ EnumEntries d;
        public final int a;
        public final int b;

        static {
            d = EnumEntriesKt.enumEntries(bVarArr);
        }

        public b(int i, int i2) {
            super(str, i);
            this.a = i;
            this.b = i2;
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) c.clone();
        }
    }

    void a(List<? extends ds> list, boolean z);

    void b(ds dsVar);

    void c(ds dsVar);

    void d();

    void d(ds dsVar);

    boolean g();

    List<ds> getNoteEditorContentCards();

    void setAddNewReplyBoxDisplayed(boolean z);

    void setStyleBoxDisplayed(boolean z);

    void setStyleBoxExpanded(boolean z);

    void setStyleBoxPickerColors(List<Integer> list);

    void setStyleBoxPickerIcons(List<String> list);

    void setStyleBoxSelectedColor(int i);

    void setStyleBoxSelectedIcon(String str);

    void setStyleBoxText(int i);
}
