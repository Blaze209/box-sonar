package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import com.facebook.react.modules.dialog.AlertFragment;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: MotionCarousel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J=\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052&\u0010\u0006\u001a\"\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\b\u000bH&¢\u0006\u0002\u0010\fJ\\\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052E\u0010\u0006\u001aA\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001d\u0012\u001b\u0012\b\u0012\u00060\u0010R\u00020\u00110\u000f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00030\u000e¢\u0006\u0002\b\u000bH&¢\u0006\u0002\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/constraintlayout/compose/MotionCarouselScope;", "", AlertFragment.ARG_ITEMS, "", "count", "", "itemContent", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Landroidx/compose/runtime/Composable;", "(ILkotlin/jvm/functions/Function3;)V", "itemsWithProperties", "Lkotlin/Function2;", "Landroidx/compose/runtime/State;", "Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "Landroidx/constraintlayout/compose/MotionLayoutScope;", "properties", "(ILkotlin/jvm/functions/Function4;)V", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MotionCarouselScope {
    void items(int count, Function3<? super Integer, ? super Composer, ? super Integer, Unit> itemContent);

    void itemsWithProperties(int count, Function4<? super Integer, ? super androidx.compose.runtime.State<MotionLayoutScope.MotionProperties>, ? super Composer, ? super Integer, Unit> itemContent);
}
