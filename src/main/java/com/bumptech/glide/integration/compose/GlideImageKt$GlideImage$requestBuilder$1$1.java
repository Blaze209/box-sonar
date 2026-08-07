package com.bumptech.glide.integration.compose;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.RequestBuilder;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: GlideImage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class GlideImageKt$GlideImage$requestBuilder$1$1 extends FunctionReferenceImpl implements Function1<Integer, RequestBuilder<Drawable>> {
    GlideImageKt$GlideImage$requestBuilder$1$1(Object obj) {
        super(1, obj, RequestBuilder.class, ReactTextInputShadowNode.PROP_PLACEHOLDER, "placeholder(I)Lcom/bumptech/glide/request/BaseRequestOptions;", 0);
    }

    public final RequestBuilder<Drawable> invoke(int i) {
        return (RequestBuilder) ((RequestBuilder) this.receiver).placeholder(i);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ RequestBuilder<Drawable> invoke(Integer num) {
        return invoke(num.intValue());
    }
}
