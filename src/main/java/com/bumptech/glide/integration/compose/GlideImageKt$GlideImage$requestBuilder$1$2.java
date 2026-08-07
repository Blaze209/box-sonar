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
/* synthetic */ class GlideImageKt$GlideImage$requestBuilder$1$2 extends FunctionReferenceImpl implements Function1<Drawable, RequestBuilder<Drawable>> {
    GlideImageKt$GlideImage$requestBuilder$1$2(Object obj) {
        super(1, obj, RequestBuilder.class, ReactTextInputShadowNode.PROP_PLACEHOLDER, "placeholder(Landroid/graphics/drawable/Drawable;)Lcom/bumptech/glide/request/BaseRequestOptions;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final RequestBuilder<Drawable> invoke(Drawable drawable) {
        return (RequestBuilder) ((RequestBuilder) this.receiver).placeholder(drawable);
    }
}
