package com.box.android.hubs.hubDetails.presentation;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubDetailsWebViewLoader.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001f\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsWebCallbacks;", "", "onHubLoaded", "Lkotlin/Function1;", "", "", "onShouldOverrideUrlLoading", "Landroid/net/Uri;", "", "onLoadError", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnHubLoaded", "()Lkotlin/jvm/functions/Function1;", "getOnShouldOverrideUrlLoading", "getOnLoadError", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubDetailsWebCallbacks {
    public static final int $stable = 0;
    private final Function1<String, Unit> onHubLoaded;
    private final Function1<String, Unit> onLoadError;
    private final Function1<Uri, Boolean> onShouldOverrideUrlLoading;

    /* JADX WARN: Multi-variable type inference failed */
    public HubDetailsWebCallbacks(Function1<? super String, Unit> onHubLoaded, Function1<? super Uri, Boolean> onShouldOverrideUrlLoading, Function1<? super String, Unit> onLoadError) {
        Intrinsics.checkNotNullParameter(onHubLoaded, "onHubLoaded");
        Intrinsics.checkNotNullParameter(onShouldOverrideUrlLoading, "onShouldOverrideUrlLoading");
        Intrinsics.checkNotNullParameter(onLoadError, "onLoadError");
        this.onHubLoaded = onHubLoaded;
        this.onShouldOverrideUrlLoading = onShouldOverrideUrlLoading;
        this.onLoadError = onLoadError;
    }

    public final Function1<String, Unit> getOnHubLoaded() {
        return this.onHubLoaded;
    }

    public final Function1<Uri, Boolean> getOnShouldOverrideUrlLoading() {
        return this.onShouldOverrideUrlLoading;
    }

    public final Function1<String, Unit> getOnLoadError() {
        return this.onLoadError;
    }
}
