package com.box.android.navigation;

import com.box.android.browse.cpl.browse.BrowseReducer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes12.dex */
public final /* synthetic */ class Navigation$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ Navigation f$0;

    public /* synthetic */ Navigation$$ExternalSyntheticLambda5(Navigation navigation) {
        this.f$0 = navigation;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return this.f$0.sendBrowseAction((BrowseReducer.Action) obj);
    }
}
