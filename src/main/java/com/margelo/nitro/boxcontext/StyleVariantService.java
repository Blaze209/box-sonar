package com.margelo.nitro.boxcontext;

import com.margelo.nitro.boxcontext.providers.StyleVariantDelegate;
import com.margelo.nitro.boxcontext.providers.StyleVariantRegistry;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StyleVariantService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nH\u0016J\f\u0010\u000f\u001a\u00020\u000b*\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/margelo/nitro/boxcontext/StyleVariantService;", "Lcom/margelo/nitro/boxcontext/HybridStyleVariantServiceSpec;", "<init>", "()V", "onStyleVariantChanged", "Lkotlin/Function0;", "", "recipientId", "", "callback", "Lkotlin/Function1;", "Lcom/margelo/nitro/boxcontext/StyleVariant;", "Lkotlin/ParameterName;", "name", "styleVariant", "toNitro", "Lcom/margelo/nitro/boxcontext/providers/StyleVariant;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StyleVariantService extends HybridStyleVariantServiceSpec {

    /* JADX INFO: compiled from: StyleVariantService.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.margelo.nitro.boxcontext.providers.StyleVariant.values().length];
            try {
                iArr[com.margelo.nitro.boxcontext.providers.StyleVariant.FULL_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[com.margelo.nitro.boxcontext.providers.StyleVariant.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[com.margelo.nitro.boxcontext.providers.StyleVariant.SIDEBAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.margelo.nitro.boxcontext.HybridStyleVariantServiceSpec
    public Function0<Unit> onStyleVariantChanged(String recipientId, final Function1<? super StyleVariant, Unit> callback) {
        Intrinsics.checkNotNullParameter(recipientId, "recipientId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        StyleVariantDelegate styleVariantDelegateDelegate = StyleVariantRegistry.INSTANCE.delegate(recipientId);
        if (styleVariantDelegateDelegate == null) {
            callback.invoke(StyleVariant.FULL_PAGE);
            return new Function0() { // from class: com.margelo.nitro.boxcontext.StyleVariantService$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        return styleVariantDelegateDelegate.onStyleVariantChanged(new Function1() { // from class: com.margelo.nitro.boxcontext.StyleVariantService$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StyleVariantService.onStyleVariantChanged$lambda$1(callback, this, (com.margelo.nitro.boxcontext.providers.StyleVariant) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStyleVariantChanged$lambda$1(Function1 function1, StyleVariantService styleVariantService, com.margelo.nitro.boxcontext.providers.StyleVariant variant) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        function1.invoke(styleVariantService.toNitro(variant));
        return Unit.INSTANCE;
    }

    private final StyleVariant toNitro(com.margelo.nitro.boxcontext.providers.StyleVariant styleVariant) {
        int i = WhenMappings.$EnumSwitchMapping$0[styleVariant.ordinal()];
        if (i == 1) {
            return StyleVariant.FULL_PAGE;
        }
        if (i == 2) {
            return StyleVariant.MODAL;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return StyleVariant.SIDEBAR;
    }
}
