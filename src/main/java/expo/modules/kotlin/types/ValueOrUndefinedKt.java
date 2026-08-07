package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ValueOrUndefined.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aK\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0006\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {"map", "Lexpo/modules/kotlin/types/ValueOrUndefined;", "R", ExifInterface.GPS_DIRECTION_TRUE, ViewProps.TRANSFORM, "Lkotlin/Function1;", "expo-modules-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ValueOrUndefinedKt {
    public static final /* synthetic */ <T, R> ValueOrUndefined<R> map(ValueOrUndefined<T> valueOrUndefined, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(valueOrUndefined, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (valueOrUndefined instanceof ValueOrUndefined.Value) {
            return new ValueOrUndefined.Value(transform.invoke((Object) ((ValueOrUndefined.Value) valueOrUndefined).getValue()));
        }
        if (!(valueOrUndefined instanceof ValueOrUndefined.Undefined)) {
            throw new NoWhenBranchMatchedException();
        }
        ValueOrUndefined.Companion companion = ValueOrUndefined.INSTANCE;
        ValueOrUndefined.Undefined undefined = ValueOrUndefined.Undefined.INSTANCE;
        Intrinsics.checkNotNull(undefined, "null cannot be cast to non-null type expo.modules.kotlin.types.ValueOrUndefined<T of expo.modules.kotlin.types.ValueOrUndefined.Companion.getUndefined>");
        return undefined;
    }
}
