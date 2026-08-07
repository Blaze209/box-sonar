package expo.modules.ui;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SwitchView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/ui/ValueChangeEvent;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "value", "", "<init>", "(Z)V", "getValue$annotations", "()V", "getValue", "()Z", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ValueChangeEvent implements Record, Serializable {
    public static final int $stable = 0;
    private final boolean value;

    public ValueChangeEvent() {
        this(false, 1, null);
    }

    @Field
    public static /* synthetic */ void getValue$annotations() {
    }

    public ValueChangeEvent(boolean z) {
        this.value = z;
    }

    public /* synthetic */ ValueChangeEvent(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public boolean getValue() {
        return this.value;
    }
}
