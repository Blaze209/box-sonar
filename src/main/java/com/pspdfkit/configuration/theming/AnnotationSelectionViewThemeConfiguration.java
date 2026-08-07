package com.pspdfkit.configuration.theming;

import android.graphics.drawable.Drawable;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u00002\u00020\u0001:\u0001?B\u008b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0012\u0012\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0004\b\u001d\u0010!R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b&\u0010#R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b'\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b-\u0010#R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b.\u0010#R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b/\u0010#R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b0\u0010#R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b1\u0010#R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b2\u0010#R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b3\u0010#R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010$\u001a\u0004\b4\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010)R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010)R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010)R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010)R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010)R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010)¨\u0006@"}, d2 = {"Lcom/pspdfkit/configuration/theming/AnnotationSelectionViewThemeConfiguration;", "", "selectionBorderWidth", "", "selectionBorderColor", "selectionScaleHandleColor", "selectionEditHandleColor", "editHandleDrawable", "Landroid/graphics/drawable/Drawable;", "handleTouchFeedbackAnimationEnabled", "", "selectionPadding", "guideLineWidth", "guideLineColor", "guideLineIncrease", "linkAnnotationBackgroundColor", "linkAnnotationBorderColor", "linkAnnotationHighlightBackgroundColor", "linkAnnotationHighlightBorderColor", "topLeftScaleHandleDrawable", "topCenterScaleHandleDrawable", "topRightScaleHandleDrawable", "centerLeftScaleHandleDrawable", "centerRightScaleHandleDrawable", "bottomLeftScaleHandleDrawable", "bottomCenterScaleHandleDrawable", "bottomRightScaleHandleDrawable", "rotationHandleDrawable", "backgroundDrawable", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "builder", "Lcom/pspdfkit/configuration/theming/AnnotationSelectionViewThemeConfiguration$Builder;", "(Lcom/pspdfkit/configuration/theming/AnnotationSelectionViewThemeConfiguration$Builder;)V", "getSelectionBorderWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSelectionBorderColor", "getSelectionScaleHandleColor", "getSelectionEditHandleColor", "getEditHandleDrawable", "()Landroid/graphics/drawable/Drawable;", "getHandleTouchFeedbackAnimationEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSelectionPadding", "getGuideLineWidth", "getGuideLineColor", "getGuideLineIncrease", "getLinkAnnotationBackgroundColor", "getLinkAnnotationBorderColor", "getLinkAnnotationHighlightBackgroundColor", "getLinkAnnotationHighlightBorderColor", "getTopLeftScaleHandleDrawable", "getTopCenterScaleHandleDrawable", "getTopRightScaleHandleDrawable", "getCenterLeftScaleHandleDrawable", "getCenterRightScaleHandleDrawable", "getBottomLeftScaleHandleDrawable", "getBottomCenterScaleHandleDrawable", "getBottomRightScaleHandleDrawable", "getRotationHandleDrawable", "getBackgroundDrawable", "Builder", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AnnotationSelectionViewThemeConfiguration {
    public static final int $stable = 8;
    private final Drawable backgroundDrawable;
    private final Drawable bottomCenterScaleHandleDrawable;
    private final Drawable bottomLeftScaleHandleDrawable;
    private final Drawable bottomRightScaleHandleDrawable;
    private final Drawable centerLeftScaleHandleDrawable;
    private final Drawable centerRightScaleHandleDrawable;
    private final Drawable editHandleDrawable;
    private final Integer guideLineColor;
    private final Integer guideLineIncrease;
    private final Integer guideLineWidth;
    private final Boolean handleTouchFeedbackAnimationEnabled;
    private final Integer linkAnnotationBackgroundColor;
    private final Integer linkAnnotationBorderColor;
    private final Integer linkAnnotationHighlightBackgroundColor;
    private final Integer linkAnnotationHighlightBorderColor;
    private final Drawable rotationHandleDrawable;
    private final Integer selectionBorderColor;
    private final Integer selectionBorderWidth;
    private final Integer selectionEditHandleColor;
    private final Integer selectionPadding;
    private final Integer selectionScaleHandleColor;
    private final Drawable topCenterScaleHandleDrawable;
    private final Drawable topLeftScaleHandleDrawable;
    private final Drawable topRightScaleHandleDrawable;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b@\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001fJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\bJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010/\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\bJ\u000e\u00106\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u00109\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010<\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010B\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u0010\u0010E\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u0010\u0010H\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u0010\u0010K\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u0010\u0010N\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u0010\u0010Q\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u0010\u0010T\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u0010\u0010W\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u0010\u0010Z\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u0010\u0010]\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019J\u0006\u0010^\u001a\u00020\u0005R$\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR&\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@BX\u0087\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR&\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@BX\u0087\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000bR&\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@BX\u0087\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0017\u0010\u000bR\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001f@BX\u0086\u000e¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R$\u0010&\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b'\u0010\u000bR&\u0010*\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@BX\u0087\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b+\u0010\u000bR&\u0010-\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@BX\u0087\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b.\u0010\u000bR&\u00100\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@BX\u0087\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b1\u0010\u000bR&\u00104\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@BX\u0087\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b5\u0010\u000bR&\u00107\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@BX\u0087\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b8\u0010\u000bR&\u0010:\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@BX\u0087\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b;\u0010\u000bR&\u0010=\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@BX\u0087\u000e¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b>\u0010\u000bR\"\u0010@\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001cR\"\u0010C\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u001cR\"\u0010F\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u001cR\"\u0010I\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u001cR\"\u0010L\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u001cR\"\u0010O\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u001cR\"\u0010R\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u001cR\"\u0010U\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u001cR\"\u0010X\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u001cR\"\u0010[\u001a\u0004\u0018\u00010\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u001c¨\u0006_"}, d2 = {"Lcom/pspdfkit/configuration/theming/AnnotationSelectionViewThemeConfiguration$Builder;", "", "<init>", "()V", "configuration", "Lcom/pspdfkit/configuration/theming/AnnotationSelectionViewThemeConfiguration;", "(Lcom/pspdfkit/configuration/theming/AnnotationSelectionViewThemeConfiguration;)V", "value", "", "selectionBorderWidth", "getSelectionBorderWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "setSelectionBorderWidth", "width", "selectionBorderColor", "getSelectionBorderColor", "setSelectionBorderColor", "color", "selectionScaleHandleColor", "getSelectionScaleHandleColor", "setSelectionScaleHandleColor", "selectionEditHandleColor", "getSelectionEditHandleColor", "setSelectionEditHandleColor", "Landroid/graphics/drawable/Drawable;", "editHandleDrawable", "getEditHandleDrawable", "()Landroid/graphics/drawable/Drawable;", "setEditHandleDrawable", "drawable", "", "handleTouchFeedbackAnimationEnabled", "getHandleTouchFeedbackAnimationEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "setHandleTouchFeedbackAnimationEnabled", "enabled", "selectionPadding", "getSelectionPadding", "setSelectionPadding", ViewProps.PADDING, "guideLineWidth", "getGuideLineWidth", "setGuideLineWidth", "guideLineColor", "getGuideLineColor", "setGuideLineColor", "guideLineIncrease", "getGuideLineIncrease", "setGuideLineIncrease", "increase", "linkAnnotationBackgroundColor", "getLinkAnnotationBackgroundColor", "setLinkAnnotationBackgroundColor", "linkAnnotationBorderColor", "getLinkAnnotationBorderColor", "setLinkAnnotationBorderColor", "linkAnnotationHighlightBackgroundColor", "getLinkAnnotationHighlightBackgroundColor", "setLinkAnnotationHighlightBackgroundColor", "linkAnnotationHighlightBorderColor", "getLinkAnnotationHighlightBorderColor", "setLinkAnnotationHighlightBorderColor", "topLeftScaleHandleDrawable", "getTopLeftScaleHandleDrawable", "setTopLeftScaleHandleDrawable", "topCenterScaleHandleDrawable", "getTopCenterScaleHandleDrawable", "setTopCenterScaleHandleDrawable", "topRightScaleHandleDrawable", "getTopRightScaleHandleDrawable", "setTopRightScaleHandleDrawable", "centerLeftScaleHandleDrawable", "getCenterLeftScaleHandleDrawable", "setCenterLeftScaleHandleDrawable", "centerRightScaleHandleDrawable", "getCenterRightScaleHandleDrawable", "setCenterRightScaleHandleDrawable", "bottomLeftScaleHandleDrawable", "getBottomLeftScaleHandleDrawable", "setBottomLeftScaleHandleDrawable", "bottomCenterScaleHandleDrawable", "getBottomCenterScaleHandleDrawable", "setBottomCenterScaleHandleDrawable", "bottomRightScaleHandleDrawable", "getBottomRightScaleHandleDrawable", "setBottomRightScaleHandleDrawable", "rotationHandleDrawable", "getRotationHandleDrawable", "setRotationHandleDrawable", "backgroundDrawable", "getBackgroundDrawable", "setBackgroundDrawable", "build", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private Drawable backgroundDrawable;
        private Drawable bottomCenterScaleHandleDrawable;
        private Drawable bottomLeftScaleHandleDrawable;
        private Drawable bottomRightScaleHandleDrawable;
        private Drawable centerLeftScaleHandleDrawable;
        private Drawable centerRightScaleHandleDrawable;
        private Drawable editHandleDrawable;
        private Integer guideLineColor;
        private Integer guideLineIncrease;
        private Integer guideLineWidth;
        private Boolean handleTouchFeedbackAnimationEnabled;
        private Integer linkAnnotationBackgroundColor;
        private Integer linkAnnotationBorderColor;
        private Integer linkAnnotationHighlightBackgroundColor;
        private Integer linkAnnotationHighlightBorderColor;
        private Drawable rotationHandleDrawable;
        private Integer selectionBorderColor;
        private Integer selectionBorderWidth;
        private Integer selectionEditHandleColor;
        private Integer selectionPadding;
        private Integer selectionScaleHandleColor;
        private Drawable topCenterScaleHandleDrawable;
        private Drawable topLeftScaleHandleDrawable;
        private Drawable topRightScaleHandleDrawable;

        public Builder() {
        }

        public final AnnotationSelectionViewThemeConfiguration build() {
            return new AnnotationSelectionViewThemeConfiguration(this, null);
        }

        public final Drawable getBackgroundDrawable() {
            return this.backgroundDrawable;
        }

        public final Drawable getBottomCenterScaleHandleDrawable() {
            return this.bottomCenterScaleHandleDrawable;
        }

        public final Drawable getBottomLeftScaleHandleDrawable() {
            return this.bottomLeftScaleHandleDrawable;
        }

        public final Drawable getBottomRightScaleHandleDrawable() {
            return this.bottomRightScaleHandleDrawable;
        }

        public final Drawable getCenterLeftScaleHandleDrawable() {
            return this.centerLeftScaleHandleDrawable;
        }

        public final Drawable getCenterRightScaleHandleDrawable() {
            return this.centerRightScaleHandleDrawable;
        }

        public final Drawable getEditHandleDrawable() {
            return this.editHandleDrawable;
        }

        public final Integer getGuideLineColor() {
            return this.guideLineColor;
        }

        public final Integer getGuideLineIncrease() {
            return this.guideLineIncrease;
        }

        public final Integer getGuideLineWidth() {
            return this.guideLineWidth;
        }

        public final Boolean getHandleTouchFeedbackAnimationEnabled() {
            return this.handleTouchFeedbackAnimationEnabled;
        }

        public final Integer getLinkAnnotationBackgroundColor() {
            return this.linkAnnotationBackgroundColor;
        }

        public final Integer getLinkAnnotationBorderColor() {
            return this.linkAnnotationBorderColor;
        }

        public final Integer getLinkAnnotationHighlightBackgroundColor() {
            return this.linkAnnotationHighlightBackgroundColor;
        }

        public final Integer getLinkAnnotationHighlightBorderColor() {
            return this.linkAnnotationHighlightBorderColor;
        }

        public final Drawable getRotationHandleDrawable() {
            return this.rotationHandleDrawable;
        }

        public final Integer getSelectionBorderColor() {
            return this.selectionBorderColor;
        }

        public final Integer getSelectionBorderWidth() {
            return this.selectionBorderWidth;
        }

        public final Integer getSelectionEditHandleColor() {
            return this.selectionEditHandleColor;
        }

        public final Integer getSelectionPadding() {
            return this.selectionPadding;
        }

        public final Integer getSelectionScaleHandleColor() {
            return this.selectionScaleHandleColor;
        }

        public final Drawable getTopCenterScaleHandleDrawable() {
            return this.topCenterScaleHandleDrawable;
        }

        public final Drawable getTopLeftScaleHandleDrawable() {
            return this.topLeftScaleHandleDrawable;
        }

        public final Drawable getTopRightScaleHandleDrawable() {
            return this.topRightScaleHandleDrawable;
        }

        public final Builder setBackgroundDrawable(Drawable drawable) {
            this.backgroundDrawable = drawable;
            return this;
        }

        public final Builder setBottomCenterScaleHandleDrawable(Drawable drawable) {
            this.bottomCenterScaleHandleDrawable = drawable;
            return this;
        }

        public final Builder setBottomLeftScaleHandleDrawable(Drawable drawable) {
            this.bottomLeftScaleHandleDrawable = drawable;
            return this;
        }

        public final Builder setBottomRightScaleHandleDrawable(Drawable drawable) {
            this.bottomRightScaleHandleDrawable = drawable;
            return this;
        }

        public final Builder setCenterLeftScaleHandleDrawable(Drawable drawable) {
            this.centerLeftScaleHandleDrawable = drawable;
            return this;
        }

        public final Builder setCenterRightScaleHandleDrawable(Drawable drawable) {
            this.centerRightScaleHandleDrawable = drawable;
            return this;
        }

        public final Builder setEditHandleDrawable(Drawable drawable) {
            this.editHandleDrawable = drawable;
            return this;
        }

        public final Builder setGuideLineColor(int color) {
            this.guideLineColor = Integer.valueOf(color);
            return this;
        }

        public final Builder setGuideLineIncrease(int increase) {
            this.guideLineIncrease = Integer.valueOf(increase);
            return this;
        }

        public final Builder setGuideLineWidth(int width) {
            this.guideLineWidth = Integer.valueOf(width);
            return this;
        }

        public final Builder setHandleTouchFeedbackAnimationEnabled(boolean enabled) {
            this.handleTouchFeedbackAnimationEnabled = Boolean.valueOf(enabled);
            return this;
        }

        public final Builder setLinkAnnotationBackgroundColor(int color) {
            this.linkAnnotationBackgroundColor = Integer.valueOf(color);
            return this;
        }

        public final Builder setLinkAnnotationBorderColor(int color) {
            this.linkAnnotationBorderColor = Integer.valueOf(color);
            return this;
        }

        public final Builder setLinkAnnotationHighlightBackgroundColor(int color) {
            this.linkAnnotationHighlightBackgroundColor = Integer.valueOf(color);
            return this;
        }

        public final Builder setLinkAnnotationHighlightBorderColor(int color) {
            this.linkAnnotationHighlightBorderColor = Integer.valueOf(color);
            return this;
        }

        public final Builder setRotationHandleDrawable(Drawable drawable) {
            this.rotationHandleDrawable = drawable;
            return this;
        }

        public final Builder setSelectionBorderColor(int color) {
            this.selectionBorderColor = Integer.valueOf(color);
            return this;
        }

        public final Builder setSelectionBorderWidth(int width) {
            this.selectionBorderWidth = Integer.valueOf(width);
            return this;
        }

        public final Builder setSelectionEditHandleColor(int color) {
            this.selectionEditHandleColor = Integer.valueOf(color);
            return this;
        }

        public final Builder setSelectionPadding(int padding) {
            this.selectionPadding = Integer.valueOf(padding);
            return this;
        }

        public final Builder setSelectionScaleHandleColor(int color) {
            this.selectionScaleHandleColor = Integer.valueOf(color);
            return this;
        }

        public final Builder setTopCenterScaleHandleDrawable(Drawable drawable) {
            this.topCenterScaleHandleDrawable = drawable;
            return this;
        }

        public final Builder setTopLeftScaleHandleDrawable(Drawable drawable) {
            this.topLeftScaleHandleDrawable = drawable;
            return this;
        }

        public final Builder setTopRightScaleHandleDrawable(Drawable drawable) {
            this.topRightScaleHandleDrawable = drawable;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(AnnotationSelectionViewThemeConfiguration annotationSelectionViewThemeConfiguration) {
            this();
            annotationSelectionViewThemeConfiguration.getClass();
            this.selectionBorderWidth = annotationSelectionViewThemeConfiguration.getSelectionBorderWidth();
            this.selectionBorderColor = annotationSelectionViewThemeConfiguration.getSelectionBorderColor();
            this.selectionScaleHandleColor = annotationSelectionViewThemeConfiguration.getSelectionScaleHandleColor();
            this.selectionEditHandleColor = annotationSelectionViewThemeConfiguration.getSelectionEditHandleColor();
            this.editHandleDrawable = annotationSelectionViewThemeConfiguration.getEditHandleDrawable();
            this.handleTouchFeedbackAnimationEnabled = annotationSelectionViewThemeConfiguration.getHandleTouchFeedbackAnimationEnabled();
            this.selectionPadding = annotationSelectionViewThemeConfiguration.getSelectionPadding();
            this.guideLineWidth = annotationSelectionViewThemeConfiguration.getGuideLineWidth();
            this.guideLineColor = annotationSelectionViewThemeConfiguration.getGuideLineColor();
            this.guideLineIncrease = annotationSelectionViewThemeConfiguration.getGuideLineIncrease();
            this.linkAnnotationBackgroundColor = annotationSelectionViewThemeConfiguration.getLinkAnnotationBackgroundColor();
            this.linkAnnotationBorderColor = annotationSelectionViewThemeConfiguration.getLinkAnnotationBorderColor();
            this.linkAnnotationHighlightBackgroundColor = annotationSelectionViewThemeConfiguration.getLinkAnnotationHighlightBackgroundColor();
            this.linkAnnotationHighlightBorderColor = annotationSelectionViewThemeConfiguration.getLinkAnnotationHighlightBorderColor();
            this.topLeftScaleHandleDrawable = annotationSelectionViewThemeConfiguration.getTopLeftScaleHandleDrawable();
            this.topCenterScaleHandleDrawable = annotationSelectionViewThemeConfiguration.getTopCenterScaleHandleDrawable();
            this.topRightScaleHandleDrawable = annotationSelectionViewThemeConfiguration.getTopRightScaleHandleDrawable();
            this.centerLeftScaleHandleDrawable = annotationSelectionViewThemeConfiguration.getCenterLeftScaleHandleDrawable();
            this.centerRightScaleHandleDrawable = annotationSelectionViewThemeConfiguration.getCenterRightScaleHandleDrawable();
            this.bottomLeftScaleHandleDrawable = annotationSelectionViewThemeConfiguration.getBottomLeftScaleHandleDrawable();
            this.bottomCenterScaleHandleDrawable = annotationSelectionViewThemeConfiguration.getBottomCenterScaleHandleDrawable();
            this.bottomRightScaleHandleDrawable = annotationSelectionViewThemeConfiguration.getBottomRightScaleHandleDrawable();
            this.rotationHandleDrawable = annotationSelectionViewThemeConfiguration.getRotationHandleDrawable();
            this.backgroundDrawable = annotationSelectionViewThemeConfiguration.getBackgroundDrawable();
        }
    }

    public /* synthetic */ AnnotationSelectionViewThemeConfiguration(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public final Drawable getBottomCenterScaleHandleDrawable() {
        return this.bottomCenterScaleHandleDrawable;
    }

    public final Drawable getBottomLeftScaleHandleDrawable() {
        return this.bottomLeftScaleHandleDrawable;
    }

    public final Drawable getBottomRightScaleHandleDrawable() {
        return this.bottomRightScaleHandleDrawable;
    }

    public final Drawable getCenterLeftScaleHandleDrawable() {
        return this.centerLeftScaleHandleDrawable;
    }

    public final Drawable getCenterRightScaleHandleDrawable() {
        return this.centerRightScaleHandleDrawable;
    }

    public final Drawable getEditHandleDrawable() {
        return this.editHandleDrawable;
    }

    public final Integer getGuideLineColor() {
        return this.guideLineColor;
    }

    public final Integer getGuideLineIncrease() {
        return this.guideLineIncrease;
    }

    public final Integer getGuideLineWidth() {
        return this.guideLineWidth;
    }

    public final Boolean getHandleTouchFeedbackAnimationEnabled() {
        return this.handleTouchFeedbackAnimationEnabled;
    }

    public final Integer getLinkAnnotationBackgroundColor() {
        return this.linkAnnotationBackgroundColor;
    }

    public final Integer getLinkAnnotationBorderColor() {
        return this.linkAnnotationBorderColor;
    }

    public final Integer getLinkAnnotationHighlightBackgroundColor() {
        return this.linkAnnotationHighlightBackgroundColor;
    }

    public final Integer getLinkAnnotationHighlightBorderColor() {
        return this.linkAnnotationHighlightBorderColor;
    }

    public final Drawable getRotationHandleDrawable() {
        return this.rotationHandleDrawable;
    }

    public final Integer getSelectionBorderColor() {
        return this.selectionBorderColor;
    }

    public final Integer getSelectionBorderWidth() {
        return this.selectionBorderWidth;
    }

    public final Integer getSelectionEditHandleColor() {
        return this.selectionEditHandleColor;
    }

    public final Integer getSelectionPadding() {
        return this.selectionPadding;
    }

    public final Integer getSelectionScaleHandleColor() {
        return this.selectionScaleHandleColor;
    }

    public final Drawable getTopCenterScaleHandleDrawable() {
        return this.topCenterScaleHandleDrawable;
    }

    public final Drawable getTopLeftScaleHandleDrawable() {
        return this.topLeftScaleHandleDrawable;
    }

    public final Drawable getTopRightScaleHandleDrawable() {
        return this.topRightScaleHandleDrawable;
    }

    public AnnotationSelectionViewThemeConfiguration(Integer num, Integer num2, Integer num3, Integer num4, Drawable drawable, Boolean bool, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6, Drawable drawable7, Drawable drawable8, Drawable drawable9, Drawable drawable10, Drawable drawable11) {
        this.selectionBorderWidth = num;
        this.selectionBorderColor = num2;
        this.selectionScaleHandleColor = num3;
        this.selectionEditHandleColor = num4;
        this.editHandleDrawable = drawable;
        this.handleTouchFeedbackAnimationEnabled = bool;
        this.selectionPadding = num5;
        this.guideLineWidth = num6;
        this.guideLineColor = num7;
        this.guideLineIncrease = num8;
        this.linkAnnotationBackgroundColor = num9;
        this.linkAnnotationBorderColor = num10;
        this.linkAnnotationHighlightBackgroundColor = num11;
        this.linkAnnotationHighlightBorderColor = num12;
        this.topLeftScaleHandleDrawable = drawable2;
        this.topCenterScaleHandleDrawable = drawable3;
        this.topRightScaleHandleDrawable = drawable4;
        this.centerLeftScaleHandleDrawable = drawable5;
        this.centerRightScaleHandleDrawable = drawable6;
        this.bottomLeftScaleHandleDrawable = drawable7;
        this.bottomCenterScaleHandleDrawable = drawable8;
        this.bottomRightScaleHandleDrawable = drawable9;
        this.rotationHandleDrawable = drawable10;
        this.backgroundDrawable = drawable11;
    }

    private AnnotationSelectionViewThemeConfiguration(Builder builder) {
        this(builder.getSelectionBorderWidth(), builder.getSelectionBorderColor(), builder.getSelectionScaleHandleColor(), builder.getSelectionEditHandleColor(), builder.getEditHandleDrawable(), builder.getHandleTouchFeedbackAnimationEnabled(), builder.getSelectionPadding(), builder.getGuideLineWidth(), builder.getGuideLineColor(), builder.getGuideLineIncrease(), builder.getLinkAnnotationBackgroundColor(), builder.getLinkAnnotationBorderColor(), builder.getLinkAnnotationHighlightBackgroundColor(), builder.getLinkAnnotationHighlightBorderColor(), builder.getTopLeftScaleHandleDrawable(), builder.getTopCenterScaleHandleDrawable(), builder.getTopRightScaleHandleDrawable(), builder.getCenterLeftScaleHandleDrawable(), builder.getCenterRightScaleHandleDrawable(), builder.getBottomLeftScaleHandleDrawable(), builder.getBottomCenterScaleHandleDrawable(), builder.getBottomRightScaleHandleDrawable(), builder.getRotationHandleDrawable(), builder.getBackgroundDrawable());
    }
}
