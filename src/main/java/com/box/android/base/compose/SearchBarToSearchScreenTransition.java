package com.box.android.base.compose;

import androidx.compose.animation.BoundsTransform;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComposeAnimationUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000fR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/base/compose/SearchBarToSearchScreenTransition;", "", "<init>", "()V", "SearchBarCapsuleCornerRadius", "Landroidx/compose/ui/unit/Dp;", "getSearchBarCapsuleCornerRadius-D9Ej5fM", "()F", "F", "SearchBoundsTransform", "Landroidx/compose/animation/BoundsTransform;", "getSearchBoundsTransform", "()Landroidx/compose/animation/BoundsTransform;", "animationSpec", "Landroidx/compose/animation/core/TweenSpec;", ExifInterface.GPS_DIRECTION_TRUE, "SEARCH_SCREEN_BOUNDS_KEY", "", "SEARCH_SCREEN_PLACEHOLDER_TEXT_KEY", "SEARCH_SCREEN_INPUT_ROW_CONTENT_KEY", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchBarToSearchScreenTransition {
    public static final String SEARCH_SCREEN_BOUNDS_KEY = "SEARCH_SCREEN_BOUNDS";
    public static final String SEARCH_SCREEN_INPUT_ROW_CONTENT_KEY = "SEARCH_SCREEN_INPUT_ROW_CONTENT";
    public static final String SEARCH_SCREEN_PLACEHOLDER_TEXT_KEY = "SEARCH_SCREEN_PLACEHOLDER_TEXT";
    public static final SearchBarToSearchScreenTransition INSTANCE = new SearchBarToSearchScreenTransition();
    private static final float SearchBarCapsuleCornerRadius = Dp.m9687constructorimpl(28);
    private static final BoundsTransform SearchBoundsTransform = new BoundsTransform() { // from class: com.box.android.base.compose.SearchBarToSearchScreenTransition$$ExternalSyntheticLambda0
        @Override // androidx.compose.animation.BoundsTransform
        public final FiniteAnimationSpec createAnimationSpec(Rect rect, Rect rect2) {
            return SearchBarToSearchScreenTransition.SearchBoundsTransform$lambda$0(rect, rect2);
        }
    };
    public static final int $stable = 8;

    private SearchBarToSearchScreenTransition() {
    }

    /* JADX INFO: renamed from: getSearchBarCapsuleCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m11663getSearchBarCapsuleCornerRadiusD9Ej5fM() {
        return SearchBarCapsuleCornerRadius;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec SearchBoundsTransform$lambda$0(Rect rect, Rect rect2) {
        Intrinsics.checkNotNullParameter(rect, "<unused var>");
        Intrinsics.checkNotNullParameter(rect2, "<unused var>");
        return INSTANCE.animationSpec();
    }

    public final BoundsTransform getSearchBoundsTransform() {
        return SearchBoundsTransform;
    }

    public final <T> TweenSpec<T> animationSpec() {
        return AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    }
}
