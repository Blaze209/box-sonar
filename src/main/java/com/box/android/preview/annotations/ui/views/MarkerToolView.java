package com.box.android.preview.annotations.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.res.ResourcesCompat;
import com.box.android.preview.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MarkerToolView.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/box/android/preview/annotations/ui/views/MarkerToolView;", "Lcom/box/android/preview/annotations/ui/views/InkToolView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MarkerToolView extends InkToolView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final int MARKER_DEFAULT_COLOR = R.color.color_picker_red;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkerToolView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        setTipResourceId(Integer.valueOf(R.drawable.annotations_tool_marker_tip));
        setTopResourceId(Integer.valueOf(R.drawable.annotations_tool_marker_top));
        setBottomResourceId(Integer.valueOf(R.drawable.annotationstool_marker_bottom));
        setupImages();
        setColor(ResourcesCompat.getColor(context.getResources(), MARKER_DEFAULT_COLOR, null));
        setContentDescription(context.getString(R.string.use_marker_talkback_label));
    }

    /* JADX INFO: compiled from: MarkerToolView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/annotations/ui/views/MarkerToolView$Companion;", "", "<init>", "()V", "MARKER_DEFAULT_COLOR", "", "getMARKER_DEFAULT_COLOR", "()I", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getMARKER_DEFAULT_COLOR() {
            return MarkerToolView.MARKER_DEFAULT_COLOR;
        }
    }
}
