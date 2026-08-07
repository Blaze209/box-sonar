package com.box.android.collections.presentation.navigationmodernization;

import androidx.compose.runtime.Composer;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionsScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005\u0012\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsScreenViewModels;", "", "collectionsViewModel", "Lkotlin/Function0;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsViewModel;", "Landroidx/compose/runtime/Composable;", "userAvatarViewModel", "Lcom/box/android/base/presentation/components/topbar/component/settings/UserAvatarViewModel;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getCollectionsViewModel", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getUserAvatarViewModel", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsScreenViewModels {
    public static final int $stable = 0;
    private final Function2<Composer, Integer, CollectionsViewModel> collectionsViewModel;
    private final Function2<Composer, Integer, UserAvatarViewModel> userAvatarViewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsScreenViewModels(Function2<? super Composer, ? super Integer, CollectionsViewModel> collectionsViewModel, Function2<? super Composer, ? super Integer, UserAvatarViewModel> userAvatarViewModel) {
        Intrinsics.checkNotNullParameter(collectionsViewModel, "collectionsViewModel");
        Intrinsics.checkNotNullParameter(userAvatarViewModel, "userAvatarViewModel");
        this.collectionsViewModel = collectionsViewModel;
        this.userAvatarViewModel = userAvatarViewModel;
    }

    public final Function2<Composer, Integer, CollectionsViewModel> getCollectionsViewModel() {
        return this.collectionsViewModel;
    }

    public final Function2<Composer, Integer, UserAvatarViewModel> getUserAvatarViewModel() {
        return this.userAvatarViewModel;
    }
}
