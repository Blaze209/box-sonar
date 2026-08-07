package com.box.android.preview.annotations.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import com.box.android.preview.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EraserToolView.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/annotations/ui/views/EraserToolView;", "Lcom/box/android/preview/annotations/ui/views/InkToolView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EraserToolView extends InkToolView {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EraserToolView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        setTopResourceId(Integer.valueOf(R.drawable.annotations_tool_eraser_top));
        setBottomResourceId(Integer.valueOf(R.drawable.annotationstool_eraser_bottom));
        setupImages();
        setContentDescription(context.getString(R.string.use_eraser_talkback_label));
    }
}
