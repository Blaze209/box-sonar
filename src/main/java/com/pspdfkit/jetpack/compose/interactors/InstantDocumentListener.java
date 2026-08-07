package com.pspdfkit.jetpack.compose.interactors;

import com.pspdfkit.instant.document.InstantPdfDocument;
import com.pspdfkit.instant.exceptions.InstantException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001Bß\u0001\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\u0004\b\u0011\u0010\u0012R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R%\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/pspdfkit/jetpack/compose/interactors/InstantDocumentListener;", "", "onAuthenticationFailed", "Lkotlin/Function2;", "Lcom/pspdfkit/instant/document/InstantPdfDocument;", "Lcom/pspdfkit/instant/exceptions/InstantException;", "", "onAuthenticationFinished", "", "onSyncStarted", "Lkotlin/Function1;", "onSyncError", "onSyncFinished", "onDocumentStateChanged", "Lcom/pspdfkit/instant/document/InstantDocumentState;", "onDocumentCorrupted", "onDocumentInvalidated", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnAuthenticationFailed", "()Lkotlin/jvm/functions/Function2;", "getOnAuthenticationFinished", "getOnSyncStarted", "()Lkotlin/jvm/functions/Function1;", "getOnSyncError", "getOnSyncFinished", "getOnDocumentStateChanged", "getOnDocumentCorrupted", "getOnDocumentInvalidated", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InstantDocumentListener {
    public static final int $stable = 0;
    private final Function2<InstantPdfDocument, InstantException, Unit> onAuthenticationFailed;
    private final Function2<InstantPdfDocument, String, Unit> onAuthenticationFinished;
    private final Function1<InstantPdfDocument, Unit> onDocumentCorrupted;
    private final Function1<InstantPdfDocument, Unit> onDocumentInvalidated;
    private final Function2<InstantPdfDocument, com.pspdfkit.instant.document.InstantDocumentState, Unit> onDocumentStateChanged;
    private final Function2<InstantPdfDocument, InstantException, Unit> onSyncError;
    private final Function1<InstantPdfDocument, Unit> onSyncFinished;
    private final Function1<InstantPdfDocument, Unit> onSyncStarted;

    public InstantDocumentListener() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final Function2<InstantPdfDocument, InstantException, Unit> getOnAuthenticationFailed() {
        return this.onAuthenticationFailed;
    }

    public final Function2<InstantPdfDocument, String, Unit> getOnAuthenticationFinished() {
        return this.onAuthenticationFinished;
    }

    public final Function1<InstantPdfDocument, Unit> getOnDocumentCorrupted() {
        return this.onDocumentCorrupted;
    }

    public final Function1<InstantPdfDocument, Unit> getOnDocumentInvalidated() {
        return this.onDocumentInvalidated;
    }

    public final Function2<InstantPdfDocument, com.pspdfkit.instant.document.InstantDocumentState, Unit> getOnDocumentStateChanged() {
        return this.onDocumentStateChanged;
    }

    public final Function2<InstantPdfDocument, InstantException, Unit> getOnSyncError() {
        return this.onSyncError;
    }

    public final Function1<InstantPdfDocument, Unit> getOnSyncFinished() {
        return this.onSyncFinished;
    }

    public final Function1<InstantPdfDocument, Unit> getOnSyncStarted() {
        return this.onSyncStarted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InstantDocumentListener(Function2<? super InstantPdfDocument, ? super InstantException, Unit> function2, Function2<? super InstantPdfDocument, ? super String, Unit> function3, Function1<? super InstantPdfDocument, Unit> function1, Function2<? super InstantPdfDocument, ? super InstantException, Unit> function4, Function1<? super InstantPdfDocument, Unit> function5, Function2<? super InstantPdfDocument, ? super com.pspdfkit.instant.document.InstantDocumentState, Unit> function6, Function1<? super InstantPdfDocument, Unit> function7, Function1<? super InstantPdfDocument, Unit> function8) {
        this.onAuthenticationFailed = function2;
        this.onAuthenticationFinished = function3;
        this.onSyncStarted = function1;
        this.onSyncError = function4;
        this.onSyncFinished = function5;
        this.onDocumentStateChanged = function6;
        this.onDocumentCorrupted = function7;
        this.onDocumentInvalidated = function8;
    }

    public /* synthetic */ InstantDocumentListener(Function2 function2, Function2 function3, Function1 function1, Function2 function4, Function1 function5, Function2 function6, Function1 function7, Function1 function8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function2, (i & 2) != 0 ? null : function3, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function4, (i & 16) != 0 ? null : function5, (i & 32) != 0 ? null : function6, (i & 64) != 0 ? null : function7, (i & 128) != 0 ? null : function8);
    }
}
