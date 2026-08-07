package com.swmansion.rnscreens.bottomsheet;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenStackFragment;
import com.swmansion.rnscreens.ext.FragmentExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SheetUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0000¨\u0006\r"}, d2 = {"isSheetFitToContents", "", "Lcom/swmansion/rnscreens/Screen;", "usesFormSheetPresentation", "requiresEnterTransitionPostponing", "sheetShouldUseDimmingView", "isLaidOutOrHasCachedLayout", "Landroid/view/View;", "resolveClampedHeight", "", "targetHeight", "currentTranslationY", "", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SheetUtilsKt {
    public static final boolean isSheetFitToContents(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return screen.getStackPresentation() == Screen.StackPresentation.FORM_SHEET && screen.getSheetDetents().getCount$react_native_screens_release() == 1 && screen.getSheetDetents().shortest$react_native_screens_release() == -1.0d;
    }

    public static final boolean usesFormSheetPresentation(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return screen.getStackPresentation() == Screen.StackPresentation.FORM_SHEET;
    }

    public static final boolean requiresEnterTransitionPostponing(Screen screen) {
        Intrinsics.checkNotNullParameter(screen, "<this>");
        return !screen.getSheetShouldOverflowTopInset() && usesFormSheetPresentation(screen);
    }

    public static final boolean sheetShouldUseDimmingView(Screen screen) {
        ScreenStackFragment screenStackFragmentAsScreenStackFragment;
        SheetDelegate sheetDelegate;
        Intrinsics.checkNotNullParameter(screen, "<this>");
        Fragment fragment = screen.getFragment();
        return ((fragment == null || (screenStackFragmentAsScreenStackFragment = FragmentExtKt.asScreenStackFragment(fragment)) == null || (sheetDelegate = screenStackFragmentAsScreenStackFragment.getSheetDelegate()) == null) ? screen.getSheetInitialDetentIndex() : sheetDelegate.getLastStableDetentIndex()) > screen.getSheetLargestUndimmedDetentIndex();
    }

    public static final boolean isLaidOutOrHasCachedLayout(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.isLaidOut() || view.getHeight() > 0 || view.getWidth() > 0;
    }

    public static final int resolveClampedHeight(Screen screen, int i, float f) {
        ScreenStackFragment screenStackFragmentAsScreenStackFragment;
        SheetDelegate sheetDelegate;
        Integer numTryResolveMaxFormSheetHeight$react_native_screens_release;
        Intrinsics.checkNotNullParameter(screen, "<this>");
        Fragment fragment = screen.getFragment();
        return (fragment == null || (screenStackFragmentAsScreenStackFragment = FragmentExtKt.asScreenStackFragment(fragment)) == null || (sheetDelegate = screenStackFragmentAsScreenStackFragment.getSheetDelegate()) == null || (numTryResolveMaxFormSheetHeight$react_native_screens_release = sheetDelegate.tryResolveMaxFormSheetHeight$react_native_screens_release()) == null) ? i : RangesKt.coerceAtMost(i, (int) (numTryResolveMaxFormSheetHeight$react_native_screens_release.intValue() + f));
    }
}
