package com.pspdfkit.internal;

import android.net.Uri;
import io.reactivex.rxjava3.subjects.MaybeSubject;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class lc$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ MaybeSubject f$0;
    public final /* synthetic */ Uri f$1;

    public /* synthetic */ lc$$ExternalSyntheticLambda1(MaybeSubject maybeSubject, Uri uri) {
        this.f$0 = maybeSubject;
        this.f$1 = uri;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return lc.a(this.f$0, this.f$1, ((Boolean) obj).booleanValue());
    }
}
