package com.box.android.preview.gallery;

import android.content.Intent;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.FragmentActivity;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: GalleryItemsActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/gallery/GalleryActivityContent;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$State;", "Lcom/box/android/preview/gallery/GalleryItemsReducer$Action;", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/box/android/cpl/Store;)V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GalleryActivityContent {
    public static final int $stable = 0;

    public GalleryActivityContent(final FragmentActivity activity, final Store<GalleryItemsReducer.State, GalleryItemsReducer.Action> store) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(store, "store");
        StoreKt.observe$default(store, new PropertyReference1Impl() { // from class: com.box.android.preview.gallery.GalleryActivityContent.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((GalleryItemsReducer.State) obj).getCloseRoute();
            }
        }, null, new Function1() { // from class: com.box.android.preview.gallery.GalleryActivityContent$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GalleryActivityContent._init_$lambda$0(activity, (GalleryItemsReducer.Close) obj);
            }
        }, 2, null);
        ComponentActivityKt.setContent$default(activity, null, ComposableLambdaKt.composableLambdaInstance(104918723, true, new Function2() { // from class: com.box.android.preview.gallery.GalleryActivityContent$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GalleryActivityContent._init_$lambda$1(store, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
        store.send(GalleryItemsReducer.Action.Fetch.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(FragmentActivity fragmentActivity, GalleryItemsReducer.Close close) {
        Intent intent;
        if (close != null) {
            ItemModel itemModel = close.getItemModel();
            if (itemModel != null) {
                intent = new Intent();
                intent.putExtra(GalleryItemsActivity.RESULT_SELECTED_ITEM_MODEL, itemModel);
            } else {
                intent = null;
            }
            fragmentActivity.setResult(-1, intent);
            fragmentActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(final Store store, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C64@2649L57,64@2640L66:GalleryItemsActivity.kt#thyhyb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(104918723, i, -1, "com.box.android.preview.gallery.GalleryActivityContent.<anonymous> (GalleryItemsActivity.kt:64)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(187696974, true, new Function2() { // from class: com.box.android.preview.gallery.GalleryActivityContent$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GalleryActivityContent.lambda$1$0(store, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda$1$0(Store store, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C65@2667L25:GalleryItemsActivity.kt#thyhyb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(187696974, i, -1, "com.box.android.preview.gallery.GalleryActivityContent.<anonymous>.<anonymous> (GalleryItemsActivity.kt:65)");
            }
            GalleryItemsScreenKt.GalleryItemsScreen(store, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
