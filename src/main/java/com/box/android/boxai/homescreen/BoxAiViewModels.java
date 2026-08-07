package com.box.android.boxai.homescreen;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiNavigationCompose.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001a\u0012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiViewModels;", "", "viewModel", "Lkotlin/Function0;", "Lcom/box/android/boxai/homescreen/BoxAiHomeViewModel;", "Landroidx/compose/runtime/Composable;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getViewModel", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiViewModels {
    public static final int $stable = 0;
    private final Function2<Composer, Integer, BoxAiHomeViewModel> viewModel;

    /* JADX WARN: Multi-variable type inference failed */
    public BoxAiViewModels(Function2<? super Composer, ? super Integer, BoxAiHomeViewModel> viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    public final Function2<Composer, Integer, BoxAiHomeViewModel> getViewModel() {
        return this.viewModel;
    }
}
