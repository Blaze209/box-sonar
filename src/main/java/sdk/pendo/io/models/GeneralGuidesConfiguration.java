package sdk.pendo.io.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.configurations.GuideCapping;
import sdk.pendo.io.b0.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lsdk/pendo/io/models/GeneralGuidesConfiguration;", "", "capping", "Lsdk/pendo/io/actions/configurations/GuideCapping;", "(Lsdk/pendo/io/actions/configurations/GuideCapping;)V", "getCapping", "()Lsdk/pendo/io/actions/configurations/GuideCapping;", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class GeneralGuidesConfiguration {

    @c("capping")
    private final GuideCapping capping;

    /* JADX WARN: Multi-variable type inference failed */
    public GeneralGuidesConfiguration() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final GuideCapping getCapping() {
        return this.capping;
    }

    public GeneralGuidesConfiguration(GuideCapping capping) {
        Intrinsics.checkNotNullParameter(capping, "capping");
        this.capping = capping;
    }

    public /* synthetic */ GeneralGuidesConfiguration(GuideCapping guideCapping, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new GuideCapping() : guideCapping);
    }
}
