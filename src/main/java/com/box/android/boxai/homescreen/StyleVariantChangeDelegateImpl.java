package com.box.android.boxai.homescreen;

import com.margelo.nitro.boxcontext.providers.StyleVariant;
import com.margelo.nitro.boxcontext.providers.StyleVariantDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiCenterViewFactory.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/boxai/homescreen/StyleVariantChangeDelegateImpl;", "Lcom/margelo/nitro/boxcontext/providers/StyleVariantDelegate;", "styleVariant", "Lcom/margelo/nitro/boxcontext/providers/StyleVariant;", "<init>", "(Lcom/margelo/nitro/boxcontext/providers/StyleVariant;)V", "onStyleVariantChanged", "Lkotlin/Function0;", "", "callback", "Lkotlin/Function1;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StyleVariantChangeDelegateImpl implements StyleVariantDelegate {
    public static final int $stable = 0;
    private final StyleVariant styleVariant;

    public StyleVariantChangeDelegateImpl(StyleVariant styleVariant) {
        Intrinsics.checkNotNullParameter(styleVariant, "styleVariant");
        this.styleVariant = styleVariant;
    }

    @Override // com.margelo.nitro.boxcontext.providers.StyleVariantDelegate
    public Function0<Unit> onStyleVariantChanged(Function1<? super StyleVariant, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(this.styleVariant);
        return new Function0() { // from class: com.box.android.boxai.homescreen.StyleVariantChangeDelegateImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
    }
}
