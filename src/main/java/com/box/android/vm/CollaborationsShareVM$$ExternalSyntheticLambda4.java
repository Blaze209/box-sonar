package com.box.android.vm;

import com.box.android.utilities.ShareSDKTransformer;
import com.box.androidsdk.content.requests.BoxResponse;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes13.dex */
public final /* synthetic */ class CollaborationsShareVM$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ ShareSDKTransformer f$0;

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return this.f$0.getFetchRolesItemPresenterData((BoxResponse) obj);
    }
}
