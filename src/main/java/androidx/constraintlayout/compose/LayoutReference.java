package androidx.constraintlayout.compose;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ConstraintLayoutBaseScope.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u001e\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u0007H\u0080\b¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0001X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Landroidx/constraintlayout/compose/LayoutReference;", "", "id", "(Ljava/lang/Object;)V", "helperParamsMap", "", "", "Landroidx/constraintlayout/compose/HelperParams;", "getId$constraintlayout_compose_release", "()Ljava/lang/Object;", "equals", "", "other", "getHelperParams", ExifInterface.GPS_DIRECTION_TRUE, "getHelperParams$constraintlayout_compose_release", "()Landroidx/constraintlayout/compose/HelperParams;", "hashCode", "", "setHelperParams", "", "helperParams", "setHelperParams$constraintlayout_compose_release", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LayoutReference {
    public static final int $stable = 0;
    private final Map<String, HelperParams> helperParamsMap = new LinkedHashMap();
    private final Object id;

    public LayoutReference(Object obj) {
        this.id = obj;
    }

    /* JADX INFO: renamed from: getId$constraintlayout_compose_release, reason: from getter */
    public Object getId() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LayoutReference) && Intrinsics.areEqual(getId(), ((LayoutReference) other).getId());
    }

    public int hashCode() {
        return getId().hashCode();
    }

    public final void setHelperParams$constraintlayout_compose_release(HelperParams helperParams) {
        String simpleName = Reflection.getOrCreateKotlinClass(helperParams.getClass()).getSimpleName();
        if (simpleName != null) {
            this.helperParamsMap.put(simpleName, helperParams);
        }
    }

    public final /* synthetic */ <T extends HelperParams> T getHelperParams$constraintlayout_compose_release() {
        Map map = this.helperParamsMap;
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj = map.get(Reflection.getOrCreateKotlinClass(HelperParams.class).getSimpleName());
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) obj;
    }
}
