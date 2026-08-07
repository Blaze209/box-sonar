package com.pspdfkit.jetpack.compose.interactors;

import com.pspdfkit.listeners.scrolling.ScrollState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/pspdfkit/jetpack/compose/interactors/UiListener;", "", "onUiVisible", "Lkotlin/Function1;", "", "", "onDocumentScroll", "Lcom/pspdfkit/listeners/scrolling/ScrollState;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnUiVisible", "()Lkotlin/jvm/functions/Function1;", "getOnDocumentScroll", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UiListener {
    public static final int $stable = 0;
    private final Function1<ScrollState, Unit> onDocumentScroll;
    private final Function1<Boolean, Unit> onUiVisible;

    /* JADX WARN: Multi-variable type inference failed */
    public UiListener() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final Function1<ScrollState, Unit> getOnDocumentScroll() {
        return this.onDocumentScroll;
    }

    public final Function1<Boolean, Unit> getOnUiVisible() {
        return this.onUiVisible;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UiListener(Function1<? super Boolean, Unit> function1, Function1<? super ScrollState, Unit> function2) {
        this.onUiVisible = function1;
        this.onDocumentScroll = function2;
    }

    public /* synthetic */ UiListener(Function1 function1, Function1 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1, (i & 2) != 0 ? null : function2);
    }
}
