package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.facebook.react.modules.dialog.AlertFragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: MotionCarousel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010!\u001a\u00020\u0005H\u0016J \u0010\"\u001a\r\u0012\u0004\u0012\u00020\u000f0#¢\u0006\u0002\b\u00102\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010$J2\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u000f0#¢\u0006\u0002\b\u00102\u0006\u0010\u000e\u001a\u00020\u00052\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0019R\u00020\u001a0\u0018H\u0016¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020'H\u0016J=\u0010(\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00052&\u0010)\u001a\"\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0002\b\u0010H\u0016¢\u0006\u0002\u0010*J\\\u0010+\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00052E\u0010)\u001aA\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u001d\u0012\u001b\u0012\b\u0012\u00060\u0019R\u00020\u001a0\u0018¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000f0\u0017¢\u0006\u0002\b\u0010H\u0016¢\u0006\u0002\u0010,R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR>\u0010\n\u001a$\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b¢\u0006\u0002\b\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R]\u0010\u0016\u001aC\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u001d\u0012\u001b\u0012\b\u0012\u00060\u0019R\u00020\u001a0\u0018¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Landroidx/constraintlayout/compose/MotionCarouselScopeImpl;", "Landroidx/constraintlayout/compose/MotionCarouselScope;", "Landroidx/constraintlayout/compose/MotionItemsProvider;", "()V", "itemsCount", "", "getItemsCount", "()I", "setItemsCount", "(I)V", "itemsProvider", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "", "Landroidx/compose/runtime/Composable;", "getItemsProvider", "()Lkotlin/jvm/functions/Function3;", "setItemsProvider", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "itemsProviderWithProperties", "Lkotlin/Function2;", "Landroidx/compose/runtime/State;", "Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "Landroidx/constraintlayout/compose/MotionLayoutScope;", "properties", "getItemsProviderWithProperties", "()Lkotlin/jvm/functions/Function4;", "setItemsProviderWithProperties", "(Lkotlin/jvm/functions/Function4;)V", "Lkotlin/jvm/functions/Function4;", "count", "getContent", "Lkotlin/Function0;", "(I)Lkotlin/jvm/functions/Function2;", "(ILandroidx/compose/runtime/State;)Lkotlin/jvm/functions/Function2;", "hasItemsWithProperties", "", AlertFragment.ARG_ITEMS, "itemContent", "(ILkotlin/jvm/functions/Function3;)V", "itemsWithProperties", "(ILkotlin/jvm/functions/Function4;)V", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MotionCarouselScopeImpl implements MotionCarouselScope, MotionItemsProvider {
    private int itemsCount;
    private Function3<? super Integer, ? super Composer, ? super Integer, Unit> itemsProvider;
    private Function4<? super Integer, ? super androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>, ? super Composer, ? super Integer, Unit> itemsProviderWithProperties;

    public final int getItemsCount() {
        return this.itemsCount;
    }

    public final void setItemsCount(int i) {
        this.itemsCount = i;
    }

    public final Function3<Integer, Composer, Integer, Unit> getItemsProvider() {
        return this.itemsProvider;
    }

    public final void setItemsProvider(Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3) {
        this.itemsProvider = function3;
    }

    public final Function4<Integer, androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>, Composer, Integer, Unit> getItemsProviderWithProperties() {
        return this.itemsProviderWithProperties;
    }

    public final void setItemsProviderWithProperties(Function4<? super Integer, ? super androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>, ? super Composer, ? super Integer, Unit> function4) {
        this.itemsProviderWithProperties = function4;
    }

    @Override // androidx.constraintlayout.compose.MotionCarouselScope
    public void items(int count, Function3<? super Integer, ? super Composer, ? super Integer, Unit> itemContent) {
        this.itemsCount = count;
        this.itemsProvider = itemContent;
    }

    @Override // androidx.constraintlayout.compose.MotionCarouselScope
    public void itemsWithProperties(int count, Function4<? super Integer, ? super androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>, ? super Composer, ? super Integer, Unit> itemContent) {
        this.itemsCount = count;
        this.itemsProviderWithProperties = itemContent;
    }

    @Override // androidx.constraintlayout.compose.MotionItemsProvider
    public Function2<Composer, Integer, Unit> getContent(final int index) {
        return ComposableLambdaKt.composableLambdaInstance(752436001, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselScopeImpl.getContent.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C354@13725L13:MotionCarousel.kt#fysre8");
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(752436001, i, -1, "androidx.constraintlayout.compose.MotionCarouselScopeImpl.getContent.<anonymous> (MotionCarousel.kt:354)");
                }
                Function3<Integer, Composer, Integer, Unit> itemsProvider = MotionCarouselScopeImpl.this.getItemsProvider();
                if (itemsProvider != null) {
                    itemsProvider.invoke(Integer.valueOf(index), composer, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @Override // androidx.constraintlayout.compose.MotionItemsProvider
    public Function2<Composer, Integer, Unit> getContent(final int index, final androidx.compose.runtime.State<MotionLayoutScope.MotionProperties> properties) {
        return ComposableLambdaKt.composableLambdaInstance(1612828220, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.MotionCarouselScopeImpl.getContent.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C361@13944L25:MotionCarousel.kt#fysre8");
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1612828220, i, -1, "androidx.constraintlayout.compose.MotionCarouselScopeImpl.getContent.<anonymous> (MotionCarousel.kt:361)");
                }
                Function4<Integer, androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>, Composer, Integer, Unit> itemsProviderWithProperties = MotionCarouselScopeImpl.this.getItemsProviderWithProperties();
                if (itemsProviderWithProperties != null) {
                    itemsProviderWithProperties.invoke(Integer.valueOf(index), properties, composer, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @Override // androidx.constraintlayout.compose.MotionItemsProvider
    /* JADX INFO: renamed from: count, reason: from getter */
    public int getItemsCount() {
        return this.itemsCount;
    }

    @Override // androidx.constraintlayout.compose.MotionItemsProvider
    public boolean hasItemsWithProperties() {
        return this.itemsProviderWithProperties != null;
    }
}
