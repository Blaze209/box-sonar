package com.pspdfkit.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.box.android.observability.DiagnosisParams;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.activity.ThumbnailBarMode;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.hu;
import com.pspdfkit.internal.rg;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import com.pspdfkit.ui.drawable.PdfDrawableManager;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import com.pspdfkit.ui.thumbnail.LayoutStyle;
import com.pspdfkit.ui.thumbnail.PdfScrollableThumbnailBarKt;
import com.pspdfkit.ui.thumbnail.PdfStaticThumbnailBarKt;
import com.pspdfkit.ui.thumbnail.PdfThumbnailBarController;
import com.pspdfkit.ui.thumbnail.ThumbnailBarEvent;
import com.pspdfkit.ui.thumbnail.ThumbnailBarStateManager;
import com.pspdfkit.ui.thumbnail.ThumbnailBarTheme;
import com.pspdfkit.ui.thumbnail.ThumbnailBarUiState;
import com.pspdfkit.ui.thumbnail.ThumbnailItem;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001x\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0083\u0001\u0084\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0019\u0010\u0015J\u0017\u0010\u001b\u001a\u00020\f2\b\b\u0001\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001f\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010#\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001cH\u0000¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020\bH\u0007¢\u0006\u0004\b$\u0010\u0015J\u0017\u0010&\u001a\u00020\f2\b\b\u0001\u0010%\u001a\u00020\b¢\u0006\u0004\b&\u0010\u0018J\u000f\u0010'\u001a\u00020\bH\u0007¢\u0006\u0004\b'\u0010\u0015J\u0017\u0010(\u001a\u00020\f2\b\b\u0001\u0010%\u001a\u00020\b¢\u0006\u0004\b(\u0010\u0018J\u0019\u0010*\u001a\u00020\f2\b\b\u0001\u0010)\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010\u0018J\u0011\u0010.\u001a\u0004\u0018\u00010+H\u0000¢\u0006\u0004\b,\u0010-J\u000f\u00100\u001a\u00020/H\u0007¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010+¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u001c2\u0006\u00106\u001a\u000205H\u0015¢\u0006\u0004\b7\u00108J\u001f\u0010=\u001a\u00020\f2\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;H\u0017¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\f2\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\f2\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bC\u0010BJ\u000f\u0010D\u001a\u00020\fH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\fH\u0016¢\u0006\u0004\bF\u0010EJ\u000f\u0010G\u001a\u00020\fH\u0016¢\u0006\u0004\bG\u0010EJ\u000f\u0010H\u001a\u00020\u001cH\u0016¢\u0006\u0004\bH\u0010\u001eJ\u000f\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bJ\u0010KJ\u0015\u0010N\u001a\u00020\f2\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bN\u0010OJ\r\u0010P\u001a\u00020L¢\u0006\u0004\bP\u0010QJ\u0017\u0010T\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\fH\u0014¢\u0006\u0004\bV\u0010EJ\u000f\u0010X\u001a\u00020WH\u0002¢\u0006\u0004\bX\u0010YJ\u000f\u0010Z\u001a\u00020\fH\u0002¢\u0006\u0004\bZ\u0010EJ\u000f\u0010[\u001a\u00020\fH\u0002¢\u0006\u0004\b[\u0010EJ\u000f\u0010\\\u001a\u00020\fH\u0002¢\u0006\u0004\b\\\u0010ER\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\u000f0]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR+\u0010h\u001a\u00020L2\u0006\u0010c\u001a\u00020L8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010Q\"\u0004\bg\u0010OR+\u0010o\u001a\u00020i2\u0006\u0010c\u001a\u00020i8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bj\u0010e\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0018\u00102\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010pR\u0018\u0010q\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010s\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010v\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0011\u0010~\u001a\u00020{8F¢\u0006\u0006\u001a\u0004\b|\u0010}R'\u0010\u0080\u0001\u001a\u00020\u001c2\u0006\u0010\u007f\u001a\u00020\u001c8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010\u001e\"\u0005\b\u0081\u0001\u0010\"R\u0013\u0010\u0082\u0001\u001a\u00020\u001c8F¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u001e¨\u0006\u0085\u0001"}, d2 = {"Lcom/pspdfkit/ui/PdfThumbnailBar;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Lcom/pspdfkit/ui/PSPDFKitViews$PSPDFView;", "Lcom/pspdfkit/ui/drawable/PdfDrawableManager;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "Content", "(Landroidx/compose/runtime/Composer;I)V", "Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;", "drawableProvider", "addDrawableProvider", "(Lcom/pspdfkit/ui/drawable/PdfDrawableProvider;)V", "removeDrawableProvider", "getThumbnailWidth", "()I", "thumbnailWidth", "setThumbnailWidth", "(I)V", "getThumbnailHeight", "thumbnailHeight", "setThumbnailHeight", "", "isUsingPageAspectRatio$sdk_nutrient", "()Z", "isUsingPageAspectRatio", "usePageAspectRatio", "setUsePageAspectRatio$sdk_nutrient", "(Z)V", "setUsePageAspectRatio", "getThumbnailBorderColor", ViewProps.BORDER_COLOR, "setThumbnailBorderColor", "getSelectedThumbnailBorderColor", "setSelectedThumbnailBorderColor", "backgroundColor", "setBackgroundColor", "Lcom/pspdfkit/ui/PdfThumbnailBar$OnPageChangedListener;", "getOnPageChangedListener$sdk_nutrient", "()Lcom/pspdfkit/ui/PdfThumbnailBar$OnPageChangedListener;", "getOnPageChangedListener", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarUiState;", "getUiStateForTesting", "()Lcom/pspdfkit/ui/thumbnail/ThumbnailBarUiState;", "onPageChangedListener", "setOnPageChangedListener", "(Lcom/pspdfkit/ui/PdfThumbnailBar$OnPageChangedListener;)V", "Landroid/graphics/Rect;", "insets", "fitSystemWindows", "(Landroid/graphics/Rect;)Z", "Lcom/pspdfkit/document/PdfDocument;", "document", "Lcom/pspdfkit/configuration/PdfConfiguration;", "configuration", "setDocument", "(Lcom/pspdfkit/document/PdfDocument;Lcom/pspdfkit/configuration/PdfConfiguration;)V", "Lcom/pspdfkit/listeners/OnVisibilityChangedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addOnVisibilityChangedListener", "(Lcom/pspdfkit/listeners/OnVisibilityChangedListener;)V", "removeOnVisibilityChangedListener", "show", "()V", "hide", "clearDocument", "isDisplayed", "Lcom/pspdfkit/ui/PSPDFKitViews$Type;", "getPSPDFViewType", "()Lcom/pspdfkit/ui/PSPDFKitViews$Type;", "Lcom/pspdfkit/configuration/activity/ThumbnailBarMode;", DiagnosisParams.DIAGNOSIS_MODE, "setThumbnailBarMode", "(Lcom/pspdfkit/configuration/activity/ThumbnailBarMode;)V", "getThumbnailBarMode", "()Lcom/pspdfkit/configuration/activity/ThumbnailBarMode;", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onDetachedFromWindow", "Lcom/pspdfkit/ui/thumbnail/PdfThumbnailBarController;", "createControllerForCompose", "()Lcom/pspdfkit/ui/thumbnail/PdfThumbnailBarController;", "subscribeForCustomDrawableUpdates", "setupFloatingModeInsets", "setupPinnedModeInsets", "Lcom/pspdfkit/internal/hu;", "drawableProviderCollection", "Lcom/pspdfkit/internal/hu;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarStateManager;", "stateManager", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarStateManager;", "<set-?>", "_thumbnailBarMode$delegate", "Landroidx/compose/runtime/MutableState;", "get_thumbnailBarMode", "set_thumbnailBarMode", "_thumbnailBarMode", "Lcom/pspdfkit/ui/thumbnail/LayoutStyle;", "layoutStyle$delegate", "getLayoutStyle", "()Lcom/pspdfkit/ui/thumbnail/LayoutStyle;", "setLayoutStyle", "(Lcom/pspdfkit/ui/thumbnail/LayoutStyle;)V", "layoutStyle", "Lcom/pspdfkit/ui/PdfThumbnailBar$OnPageChangedListener;", "currentDocument", "Lcom/pspdfkit/document/PdfDocument;", "currentConfiguration", "Lcom/pspdfkit/configuration/PdfConfiguration;", "Lio/reactivex/rxjava3/disposables/Disposable;", "drawableProviderDisposable", "Lio/reactivex/rxjava3/disposables/Disposable;", "com/pspdfkit/ui/PdfThumbnailBar$composeDocumentListener$1", "composeDocumentListener", "Lcom/pspdfkit/ui/PdfThumbnailBar$composeDocumentListener$1;", "Lcom/pspdfkit/listeners/DocumentListener;", "getDocumentListener", "()Lcom/pspdfkit/listeners/DocumentListener;", "documentListener", "enable", "isRedactionAnnotationPreviewEnabled", "setRedactionAnnotationPreviewEnabled", "isBackgroundTransparent", "OnPageChangedListener", "ConvertToDrawable", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PdfThumbnailBar extends AbstractComposeView implements PSPDFKitViews.PSPDFView, PdfDrawableManager {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: _thumbnailBarMode$delegate, reason: from kotlin metadata */
    private final MutableState _thumbnailBarMode;
    private final PdfThumbnailBar$composeDocumentListener$1 composeDocumentListener;
    private PdfConfiguration currentConfiguration;
    private PdfDocument currentDocument;
    private final hu<PdfDrawableProvider> drawableProviderCollection;
    private Disposable drawableProviderDisposable;

    /* JADX INFO: renamed from: layoutStyle$delegate, reason: from kotlin metadata */
    private final MutableState layoutStyle;
    private OnPageChangedListener onPageChangedListener;
    private final ThumbnailBarStateManager stateManager;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/pspdfkit/ui/PdfThumbnailBar$ConvertToDrawable;", "Lio/reactivex/rxjava3/functions/Function;", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "resources", "Landroid/content/res/Resources;", "crossFade", "", "renderStartTime", "", ReactTextInputShadowNode.PROP_PLACEHOLDER, "<init>", "(Landroid/content/res/Resources;ZJLandroid/graphics/drawable/Drawable;)V", "apply", "bitmap", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ConvertToDrawable implements Function<Bitmap, Drawable> {
        public static final int $stable = 8;
        private final boolean crossFade;
        private final Drawable placeholder;
        private final long renderStartTime;
        private final Resources resources;

        public ConvertToDrawable(Resources resources, boolean z, long j, Drawable drawable) {
            resources.getClass();
            this.resources = resources;
            this.crossFade = z;
            this.renderStartTime = j;
            this.placeholder = drawable;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Drawable apply(Bitmap bitmap) {
            bitmap.getClass();
            if (this.crossFade) {
                return new rg(this.resources, bitmap, this.placeholder, SystemClock.uptimeMillis() - this.renderStartTime > 150);
            }
            return new BitmapDrawable(this.resources, bitmap);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/PdfThumbnailBar$OnPageChangedListener;", "", "onPageChanged", "", "controller", "Lcom/pspdfkit/ui/thumbnail/PdfThumbnailBarController;", "pageIndex", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface OnPageChangedListener {
        void onPageChanged(PdfThumbnailBarController controller, int pageIndex);
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThumbnailBarMode.values().length];
            try {
                iArr[ThumbnailBarMode.THUMBNAIL_BAR_MODE_FLOATING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ThumbnailBarMode.THUMBNAIL_BAR_MODE_PINNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ThumbnailBarMode.THUMBNAIL_BAR_MODE_SCROLLABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PdfThumbnailBar(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0$0(PdfThumbnailBar pdfThumbnailBar, int i) {
        OnPageChangedListener onPageChangedListener = pdfThumbnailBar.onPageChangedListener;
        if (onPageChangedListener != null) {
            onPageChangedListener.onPageChanged(pdfThumbnailBar.createControllerForCompose(), i);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1$0(PdfThumbnailBar pdfThumbnailBar, int i) {
        OnPageChangedListener onPageChangedListener = pdfThumbnailBar.onPageChangedListener;
        if (onPageChangedListener != null) {
            onPageChangedListener.onPageChanged(pdfThumbnailBar.createControllerForCompose(), i);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(PdfThumbnailBar pdfThumbnailBar, int i, Composer composer, int i2) {
        pdfThumbnailBar.Content(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private final PdfThumbnailBarController createControllerForCompose() {
        return new PdfThumbnailBarController() { // from class: com.pspdfkit.ui.PdfThumbnailBar.createControllerForCompose.1
            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void addOnVisibilityChangedListener(OnVisibilityChangedListener listener) {
                listener.getClass();
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void clearDocument() {
                PdfThumbnailBar.this.clearDocument();
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public int getBackgroundColor() {
                return PdfThumbnailBar.this.stateManager.getUiState().getValue().getTheme().getBackgroundColor();
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public DocumentListener getDocumentListener() {
                return PdfThumbnailBar.this.composeDocumentListener;
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public int getSelectedThumbnailBorderColor() {
                return PdfThumbnailBar.this.stateManager.getUiState().getValue().getTheme().getThumbnailSelectedBorderColor();
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public int getThumbnailBorderColor() {
                return PdfThumbnailBar.this.stateManager.getUiState().getValue().getTheme().getThumbnailBorderColor();
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public int getThumbnailHeight() {
                return PdfThumbnailBar.this.stateManager.getUiState().getValue().getTheme().getThumbnailHeight();
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public int getThumbnailWidth() {
                ThumbnailBarUiState value = PdfThumbnailBar.this.stateManager.getUiState().getValue();
                return (!value.getTheme().getUsePageAspectRatio() || value.getThumbnails().isEmpty()) ? value.getTheme().getThumbnailWidth() : (int) ((ThumbnailItem) CollectionsKt.first((List) value.getThumbnails())).getPosition().c.width;
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public boolean isBackgroundTransparent() {
                return PdfThumbnailBar.this.stateManager.getUiState().getValue().getTheme().getBackgroundColor() == 0;
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public boolean isRedactionAnnotationPreviewEnabled() {
                return PdfThumbnailBar.this.stateManager.getUiState().getValue().isRedactionPreviewEnabled();
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public boolean isUsingPageAspectRatio() {
                return PdfThumbnailBar.this.stateManager.getUiState().getValue().getTheme().getUsePageAspectRatio();
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void removeOnVisibilityChangedListener(OnVisibilityChangedListener listener) {
                listener.getClass();
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void setBackgroundColor(int backgroundColor) {
                PdfThumbnailBar.this.stateManager.onEvent(new ThumbnailBarEvent.BackgroundColorChanged(backgroundColor));
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void setDocument(PdfDocument document, PdfConfiguration configuration) {
                document.getClass();
                configuration.getClass();
                PdfThumbnailBar.this.setDocument(document, configuration);
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void setDrawableProviders(List<? extends PdfDrawableProvider> drawableProviders) {
                drawableProviders.getClass();
                PdfThumbnailBar.this.stateManager.onEvent(new ThumbnailBarEvent.DrawableProvidersChanged(drawableProviders));
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void setOnPageChangedListener(OnPageChangedListener onPageChangedListener) {
                PdfThumbnailBar.this.onPageChangedListener = onPageChangedListener;
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void setRedactionAnnotationPreviewEnabled(boolean enable) {
                PdfThumbnailBar.this.stateManager.onEvent(new ThumbnailBarEvent.RedactionPreviewChanged(enable));
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void setSelectedThumbnailBorderColor(int borderColor) {
                PdfThumbnailBar.this.stateManager.onEvent(new ThumbnailBarEvent.ThemeChanged(ThumbnailBarTheme.copy$default(PdfThumbnailBar.this.stateManager.getUiState().getValue().getTheme(), 0, 0, 0, borderColor, 0, 0, false, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 16777207, null)));
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void setThumbnailBorderColor(int borderColor) {
                PdfThumbnailBar.this.stateManager.onEvent(new ThumbnailBarEvent.ThumbnailBorderColorChanged(borderColor));
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void setThumbnailHeight(int thumbnailHeight) {
                PdfThumbnailBar.this.stateManager.onEvent(new ThumbnailBarEvent.ThumbnailSizeChanged(PdfThumbnailBar.this.stateManager.getUiState().getValue().getTheme().getThumbnailWidth(), thumbnailHeight));
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void setThumbnailWidth(int thumbnailWidth) {
                PdfThumbnailBar.this.stateManager.onEvent(new ThumbnailBarEvent.ThumbnailSizeChanged(thumbnailWidth, PdfThumbnailBar.this.stateManager.getUiState().getValue().getTheme().getThumbnailHeight()));
            }

            @Override // com.pspdfkit.ui.thumbnail.PdfThumbnailBarController
            public void setUsePageAspectRatio(boolean usePageAspectRatio) {
                PdfThumbnailBar.this.stateManager.onEvent(new ThumbnailBarEvent.UsePageAspectRatioChanged(usePageAspectRatio));
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LayoutStyle getLayoutStyle() {
        return (LayoutStyle) this.layoutStyle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ThumbnailBarMode get_thumbnailBarMode() {
        return (ThumbnailBarMode) this._thumbnailBarMode.getValue();
    }

    private final void setLayoutStyle(LayoutStyle layoutStyle) {
        this.layoutStyle.setValue(layoutStyle);
    }

    private final void set_thumbnailBarMode(ThumbnailBarMode thumbnailBarMode) {
        this._thumbnailBarMode.setValue(thumbnailBarMode);
    }

    private final void setupFloatingModeInsets() {
        super.setBackgroundColor(0);
        setOnApplyWindowInsetsListener(null);
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    private final void setupPinnedModeInsets() {
        setOnApplyWindowInsetsListener(null);
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    private final void subscribeForCustomDrawableUpdates() {
        hu<PdfDrawableProvider> huVar = this.drawableProviderCollection;
        this.drawableProviderDisposable = huVar.a.toObservable().map(huVar.a()).subscribeOn(huVar.c).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfThumbnailBar.subscribeForCustomDrawableUpdates.1

            /* JADX INFO: renamed from: com.pspdfkit.ui.PdfThumbnailBar$subscribeForCustomDrawableUpdates$1$WhenMappings */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ThumbnailBarMode.values().length];
                    try {
                        iArr[ThumbnailBarMode.THUMBNAIL_BAR_MODE_FLOATING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ThumbnailBarMode.THUMBNAIL_BAR_MODE_PINNED.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ThumbnailBarMode.THUMBNAIL_BAR_MODE_SCROLLABLE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(List<PdfDrawableProvider> list) {
                list.getClass();
                int i = WhenMappings.$EnumSwitchMapping$0[PdfThumbnailBar.this.get_thumbnailBarMode().ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    PdfThumbnailBar.this.stateManager.onEvent(new ThumbnailBarEvent.DrawableProvidersChanged(list));
                } else if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(445421475);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(445421475, i2, -1, "com.pspdfkit.ui.PdfThumbnailBar.Content (PdfThumbnailBar.kt:137)");
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
            if (i3 == 1 || i3 == 2) {
                composerStartRestartGroup.startReplaceGroup(-1897592573);
                ThumbnailBarStateManager thumbnailBarStateManager = this.stateManager;
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(this);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.pspdfkit.ui.PdfThumbnailBar$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PdfThumbnailBar.Content$lambda$0$0(this.f$0, ((Integer) obj).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                PdfStaticThumbnailBarKt.PdfStaticThumbnailBar(thumbnailBarStateManager, (Function1) objRememberedValue, null, composerStartRestartGroup, 0, 4);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i3 == 3) {
                composerStartRestartGroup.startReplaceGroup(-1897152001);
                ThumbnailBarStateManager thumbnailBarStateManager2 = this.stateManager;
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(this);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.pspdfkit.ui.PdfThumbnailBar$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PdfThumbnailBar.Content$lambda$1$0(this.f$0, ((Integer) obj).intValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                PdfScrollableThumbnailBarKt.PdfScrollableThumbnailBar(thumbnailBarStateManager2, (Function1) objRememberedValue2, null, composerStartRestartGroup, 0, 4);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (i3 != 4) {
                    composerStartRestartGroup.startReplaceGroup(-1446690253);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(-1896723829);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.ui.PdfThumbnailBar$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfThumbnailBar.Content$lambda$2(this.f$0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public void addDrawableProvider(PdfDrawableProvider drawableProvider) {
        drawableProvider.getClass();
        hu<PdfDrawableProvider> huVar = this.drawableProviderCollection;
        huVar.getClass();
        huVar.b.a(drawableProvider);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void addOnVisibilityChangedListener(OnVisibilityChangedListener listener) {
        listener.getClass();
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void clearDocument() {
        this.currentDocument = null;
        this.currentConfiguration = null;
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            this.stateManager.onEvent(ThumbnailBarEvent.ClearDocument.INSTANCE);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        ev.getClass();
        if (isEnabled()) {
            return super.dispatchTouchEvent(ev);
        }
        return true;
    }

    @Override // android.view.View
    @Deprecated(message = "Deprecated in API level 20")
    public boolean fitSystemWindows(Rect insets) {
        insets.getClass();
        super.fitSystemWindows(insets);
        return false;
    }

    public final DocumentListener getDocumentListener() {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return this.composeDocumentListener;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        throw new AssertionError("Thumbnail bar mode not set");
    }

    /* JADX INFO: renamed from: getOnPageChangedListener$sdk_nutrient, reason: from getter */
    public final OnPageChangedListener getOnPageChangedListener() {
        return this.onPageChangedListener;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public PSPDFKitViews.Type getPSPDFViewType() {
        return PSPDFKitViews.Type.VIEW_THUMBNAIL_BAR;
    }

    public final int getSelectedThumbnailBorderColor() {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2) {
            return this.stateManager.getUiState().getValue().getTheme().getThumbnailSelectedBorderColor();
        }
        if (i == 3) {
            return this.stateManager.getUiState().getValue().getTheme().getThumbnailSelectedBorderColor();
        }
        if (i == 4) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final ThumbnailBarMode getThumbnailBarMode() {
        return get_thumbnailBarMode();
    }

    public final int getThumbnailBorderColor() {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2) {
            return this.stateManager.getUiState().getValue().getTheme().getThumbnailBorderColor();
        }
        if (i == 3) {
            return this.stateManager.getUiState().getValue().getTheme().getThumbnailBorderColor();
        }
        if (i == 4) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getThumbnailHeight() {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2) {
            return this.stateManager.getUiState().getValue().getTheme().getThumbnailHeight();
        }
        if (i == 3) {
            return this.stateManager.getUiState().getValue().getTheme().getThumbnailHeight();
        }
        if (i == 4) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getThumbnailWidth() {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            ThumbnailBarUiState value = this.stateManager.getUiState().getValue();
            return (!value.getTheme().getUsePageAspectRatio() || value.getThumbnails().isEmpty()) ? value.getTheme().getThumbnailWidth() : (int) ((ThumbnailItem) CollectionsKt.first((List) value.getThumbnails())).getPosition().c.width;
        }
        if (i == 4) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final ThumbnailBarUiState getUiStateForTesting() {
        return this.stateManager.getUiState().getValue();
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void hide() {
    }

    public final boolean isBackgroundTransparent() {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2) {
            return this.stateManager.getUiState().getValue().getTheme().getBackgroundColor() == 0;
        }
        if (i == 3) {
            return this.stateManager.getUiState().getValue().getTheme().getBackgroundColor() == 0;
        }
        if (i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public boolean isDisplayed() {
        return false;
    }

    public final boolean isRedactionAnnotationPreviewEnabled() {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return this.stateManager.getUiState().getValue().isRedactionPreviewEnabled();
        }
        if (i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isUsingPageAspectRatio$sdk_nutrient() {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2) {
            return this.stateManager.getUiState().getValue().getTheme().getUsePageAspectRatio();
        }
        if (i == 3) {
            return this.stateManager.getUiState().getValue().getTheme().getUsePageAspectRatio();
        }
        if (i == 4) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable disposable = this.drawableProviderDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.drawableProviderDisposable = null;
        this.stateManager.dispose();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public void removeDrawableProvider(PdfDrawableProvider drawableProvider) {
        drawableProvider.getClass();
        hu<PdfDrawableProvider> huVar = this.drawableProviderCollection;
        huVar.getClass();
        huVar.b.b(drawableProvider);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void removeOnVisibilityChangedListener(OnVisibilityChangedListener listener) {
        listener.getClass();
    }

    @Override // android.view.View
    public void setBackgroundColor(int backgroundColor) {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            this.stateManager.onEvent(new ThumbnailBarEvent.BackgroundColorChanged(backgroundColor));
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void setDocument(PdfDocument document, PdfConfiguration configuration) {
        document.getClass();
        configuration.getClass();
        if (getVisibility() == 8) {
            return;
        }
        this.currentDocument = document;
        this.currentConfiguration = configuration;
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            this.stateManager.onEvent(new ThumbnailBarEvent.DocumentSet(document, configuration));
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setOnPageChangedListener(OnPageChangedListener onPageChangedListener) {
        this.onPageChangedListener = onPageChangedListener;
    }

    public final void setRedactionAnnotationPreviewEnabled(boolean z) {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            this.stateManager.onEvent(new ThumbnailBarEvent.RedactionPreviewChanged(z));
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setSelectedThumbnailBorderColor(int borderColor) {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            this.stateManager.onEvent(new ThumbnailBarEvent.ThemeChanged(ThumbnailBarTheme.copy$default(this.stateManager.getUiState().getValue().getTheme(), 0, 0, 0, borderColor, 0, 0, false, 0, 0, 0, 0, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 16777207, null)));
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setThumbnailBarMode(ThumbnailBarMode mode) {
        PdfConfiguration pdfConfiguration;
        mode.getClass();
        if (get_thumbnailBarMode() == mode) {
            return;
        }
        set_thumbnailBarMode(mode);
        this.stateManager.onEvent(new ThumbnailBarEvent.ScrollableModeChanged(mode == ThumbnailBarMode.THUMBNAIL_BAR_MODE_SCROLLABLE));
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            LayoutStyle layoutStyle = LayoutStyle.FLOATING;
            setLayoutStyle(layoutStyle);
            this.stateManager.onEvent(new ThumbnailBarEvent.LayoutStyleChanged(layoutStyle));
            setupFloatingModeInsets();
        } else if (i == 2) {
            LayoutStyle layoutStyle2 = LayoutStyle.PINNED;
            setLayoutStyle(layoutStyle2);
            this.stateManager.onEvent(new ThumbnailBarEvent.LayoutStyleChanged(layoutStyle2));
            setupPinnedModeInsets();
        } else if (i == 3) {
            LayoutStyle layoutStyle3 = LayoutStyle.PINNED;
            setLayoutStyle(layoutStyle3);
            Context context = getContext();
            context.getClass();
            context.getClass();
            Resources resources = context.getResources();
            float f = resources.getDisplayMetrics().density;
            Resources.Theme theme = context.getTheme();
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(new int[]{R.attr.pspdf__scrollableThumbnailBarStyle});
            typedArrayObtainStyledAttributes.getClass();
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, R.style.PSPDFKit_ScrollableThumbnailBar);
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(resourceId, R.styleable.pspdf__ScrollableThumbnailBar);
            typedArrayObtainStyledAttributes2.getClass();
            try {
                ThumbnailBarTheme thumbnailBarTheme = new ThumbnailBarTheme(0, 0, typedArrayObtainStyledAttributes2.getColor(R.styleable.pspdf__ScrollableThumbnailBar_pspdf__thumbnailBorderColor, ContextCompat.getColor(context, R.color.pspdf__onBackgroundLight)), typedArrayObtainStyledAttributes2.getColor(R.styleable.pspdf__ScrollableThumbnailBar_pspdf__thumbnailSelectedBorderColor, ContextCompat.getColor(context, R.color.pspdf__primaryLight)), typedArrayObtainStyledAttributes2.getDimensionPixelSize(R.styleable.pspdf__ScrollableThumbnailBar_pspdf__thumbnailWidth, resources.getDimensionPixelSize(R.dimen.pspdf__scrollable_thumbnail_width)), typedArrayObtainStyledAttributes2.getDimensionPixelSize(R.styleable.pspdf__ScrollableThumbnailBar_pspdf__thumbnailHeight, resources.getDimensionPixelSize(R.dimen.pspdf__scrollable_thumbnail_height)), typedArrayObtainStyledAttributes2.getBoolean(R.styleable.pspdf__ScrollableThumbnailBar_pspdf__usePageAspectRatio, true), 0, 0, 0, RangesKt.coerceAtLeast(MathKt.roundToInt(f), 1), typedArrayObtainStyledAttributes2.getDimensionPixelSize(R.styleable.pspdf__ScrollableThumbnailBar_pspdf__thumbnailSelectionBorderWidth, resources.getDimensionPixelSize(R.dimen.pspdf__thumbnail_selection_border_width)) * 2, typedArrayObtainStyledAttributes2.getDimensionPixelSize(R.styleable.pspdf__ScrollableThumbnailBar_pspdf__thumbnailMargin, resources.getDimensionPixelSize(R.dimen.pspdf__thumbnail_margin)), 15.0f, (int) (4 * f), typedArrayObtainStyledAttributes2.getDimension(R.styleable.pspdf__ScrollableThumbnailBar_pspdf__thumbnailWidth, resources.getDimension(R.dimen.pspdf__scrollable_thumbnail_width)) / f, typedArrayObtainStyledAttributes2.getDimension(R.styleable.pspdf__ScrollableThumbnailBar_pspdf__thumbnailHeight, resources.getDimension(R.dimen.pspdf__scrollable_thumbnail_height)) / f, (2 * typedArrayObtainStyledAttributes2.getDimension(R.styleable.pspdf__ScrollableThumbnailBar_pspdf__thumbnailSelectionBorderWidth, resources.getDimension(R.dimen.pspdf__thumbnail_selection_border_width))) / f, typedArrayObtainStyledAttributes2.getDimension(R.styleable.pspdf__ScrollableThumbnailBar_pspdf__thumbnailMargin, resources.getDimension(R.dimen.pspdf__thumbnail_margin)) / f, 4.0f, 1.0f, 15.0f / f, 0.0f, 0.0f, 12582912, null);
                typedArrayObtainStyledAttributes2.recycle();
                this.stateManager.onEvent(new ThumbnailBarEvent.ThemeChanged(thumbnailBarTheme));
                this.stateManager.onEvent(new ThumbnailBarEvent.LayoutStyleChanged(layoutStyle3));
                setupPinnedModeInsets();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes2.recycle();
                throw th;
            }
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        PdfDocument pdfDocument = this.currentDocument;
        if (pdfDocument == null || (pdfConfiguration = this.currentConfiguration) == null) {
            return;
        }
        setDocument(pdfDocument, pdfConfiguration);
    }

    public final void setThumbnailBorderColor(int borderColor) {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2) {
            this.stateManager.onEvent(new ThumbnailBarEvent.ThumbnailBorderColorChanged(borderColor));
        } else if (i == 3) {
            this.stateManager.onEvent(new ThumbnailBarEvent.ThumbnailBorderColorChanged(borderColor));
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void setThumbnailHeight(int thumbnailHeight) {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2) {
            this.stateManager.onEvent(new ThumbnailBarEvent.ThumbnailSizeChanged(this.stateManager.getUiState().getValue().getTheme().getThumbnailWidth(), thumbnailHeight));
        } else if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            this.stateManager.onEvent(new ThumbnailBarEvent.ThumbnailSizeChanged(this.stateManager.getUiState().getValue().getTheme().getThumbnailWidth(), thumbnailHeight));
        }
    }

    public final void setThumbnailWidth(int thumbnailWidth) {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2) {
            this.stateManager.onEvent(new ThumbnailBarEvent.ThumbnailSizeChanged(thumbnailWidth, this.stateManager.getUiState().getValue().getTheme().getThumbnailHeight()));
        } else if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            this.stateManager.onEvent(new ThumbnailBarEvent.ThumbnailSizeChanged(thumbnailWidth, this.stateManager.getUiState().getValue().getTheme().getThumbnailHeight()));
        }
    }

    public final void setUsePageAspectRatio$sdk_nutrient(boolean usePageAspectRatio) {
        int i = WhenMappings.$EnumSwitchMapping$0[get_thumbnailBarMode().ordinal()];
        if (i == 1 || i == 2) {
            this.stateManager.onEvent(new ThumbnailBarEvent.UsePageAspectRatioChanged(usePageAspectRatio));
        } else if (i == 3) {
            this.stateManager.onEvent(new ThumbnailBarEvent.UsePageAspectRatioChanged(usePageAspectRatio));
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void show() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PdfThumbnailBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.pspdfkit.ui.PdfThumbnailBar$composeDocumentListener$1] */
    public PdfThumbnailBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.drawableProviderCollection = new hu<>(Schedulers.computation());
        this.stateManager = new ThumbnailBarStateManager(context);
        this._thumbnailBarMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE, null, 2, null);
        this.layoutStyle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LayoutStyle.FLOATING, null, 2, null);
        setClipToPadding(false);
        setClipChildren(false);
        ViewCompat.setElevation(this, getResources().getDimension(R.dimen.pspdf__floating_thumbnail_bar_elevation));
        subscribeForCustomDrawableUpdates();
        setThumbnailBarMode(ThumbnailBarMode.THUMBNAIL_BAR_MODE_FLOATING);
        this.composeDocumentListener = new DocumentListener() { // from class: com.pspdfkit.ui.PdfThumbnailBar$composeDocumentListener$1
            @Override // com.pspdfkit.listeners.DocumentListener
            public boolean onDocumentClick() {
                return false;
            }

            @Override // com.pspdfkit.listeners.DocumentListener
            public void onDocumentLoadFailed(Throwable exception) {
                exception.getClass();
            }

            @Override // com.pspdfkit.listeners.DocumentListener
            public void onDocumentLoaded(PdfDocument document) {
                document.getClass();
            }

            @Override // com.pspdfkit.listeners.DocumentListener
            public void onDocumentSaveCancelled(PdfDocument document) {
                document.getClass();
            }

            @Override // com.pspdfkit.listeners.DocumentListener
            public void onDocumentSaveFailed(PdfDocument document, Throwable exception) {
                document.getClass();
                exception.getClass();
            }

            @Override // com.pspdfkit.listeners.DocumentListener
            public void onDocumentSaved(PdfDocument document) {
                document.getClass();
            }

            @Override // com.pspdfkit.listeners.DocumentListener
            public void onPageChanged(PdfDocument document, int pageIndex) {
                document.getClass();
                this.this$0.stateManager.onEvent(new ThumbnailBarEvent.PageChanged(pageIndex));
            }

            @Override // com.pspdfkit.listeners.DocumentListener
            public boolean onPageClick(PdfDocument document, int pageIndex, MotionEvent event, PointF pagePosition, Annotation clickedAnnotation) {
                document.getClass();
                return false;
            }

            @Override // com.pspdfkit.listeners.DocumentListener
            public void onPageUpdated(PdfDocument document, int pageIndex) {
                document.getClass();
                this.this$0.stateManager.onEvent(new ThumbnailBarEvent.PageUpdated(pageIndex));
            }
        };
    }

    public /* synthetic */ PdfThumbnailBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.pspdf__thumbnailBarStyle : i);
    }
}
