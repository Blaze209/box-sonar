package androidx.constraintlayout.compose;

import androidx.compose.runtime.Composer;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MotionCarousel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\u0003H&¢\u0006\u0002\u0010\tJ2\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\u00032\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\fR\u00020\r0\u000bH&¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/constraintlayout/compose/MotionItemsProvider;", "", "count", "", "getContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", FirebaseAnalytics.Param.INDEX, "(I)Lkotlin/jvm/functions/Function2;", "properties", "Landroidx/compose/runtime/State;", "Landroidx/constraintlayout/compose/MotionLayoutScope$MotionProperties;", "Landroidx/constraintlayout/compose/MotionLayoutScope;", "(ILandroidx/compose/runtime/State;)Lkotlin/jvm/functions/Function2;", "hasItemsWithProperties", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MotionItemsProvider {
    int count();

    Function2<Composer, Integer, Unit> getContent(int index);

    Function2<Composer, Integer, Unit> getContent(int index, androidx.compose.runtime.State<MotionLayoutScope.MotionProperties> properties);

    boolean hasItemsWithProperties();
}
