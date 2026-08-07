package expo.modules.kotlin.records.formatters;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: ValueSelector.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/kotlin/records/formatters/OnNull;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lexpo/modules/kotlin/records/formatters/ValueSelector;", "<init>", "()V", "invoke", "", "value", "(Ljava/lang/Object;)Z", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnNull<T> implements ValueSelector<T> {
    public static final int $stable = 0;

    @Override // expo.modules.kotlin.records.formatters.ValueSelector
    public boolean invoke(T value) {
        return value == null;
    }
}
