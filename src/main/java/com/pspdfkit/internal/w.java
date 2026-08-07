package com.pspdfkit.internal;

import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import io.nutrient.data.models.DocumentIdentifiers;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "io.nutrient.internal.data.core.AiAssistantImpl", f = "AiAssistantImpl.kt", i = {0, 0, 0}, l = {382}, m = "doOnError", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "localIdentifiers", "responses"}, nl = {383}, s = {"L$0", "L$1", "L$2"}, v = 2)
public final class w extends ContinuationImpl {
    public Object a;
    public DocumentIdentifiers b;
    public List c;
    public /* synthetic */ Object d;
    public final /* synthetic */ x e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(x xVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = xVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return x.a(this.e, null, null, null, this);
    }
}
