package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.LocationSourceInformation;
import androidx.compose.runtime.tooling.ParameterSourceInformation;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SlotTree.jvm.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001BY\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/ui/tooling/data/SourceInformationContext;", "", "name", "", "sourceFile", "packageHash", "", "locations", "", "Landroidx/compose/runtime/tooling/LocationSourceInformation;", "repeatOffset", "parameters", "Landroidx/compose/runtime/tooling/ParameterSourceInformation;", "isCall", "", "isInline", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILjava/util/List;ZZ)V", "getName", "()Ljava/lang/String;", "getSourceFile", "getPackageHash", "()I", "getLocations", "()Ljava/util/List;", "getRepeatOffset", "getParameters", "()Z", "nextLocation", "nextSourceLocation", "Landroidx/compose/ui/tooling/data/SourceLocation;", "sourceLocation", "callIndex", "parentContext", "ui-tooling-data"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SourceInformationContext {
    private final boolean isCall;
    private final boolean isInline;
    private final List<LocationSourceInformation> locations;
    private final String name;
    private int nextLocation;
    private final int packageHash;
    private final List<ParameterSourceInformation> parameters;
    private final int repeatOffset;
    private final String sourceFile;

    public SourceInformationContext(String str, String str2, int i, List<LocationSourceInformation> list, int i2, List<ParameterSourceInformation> list2, boolean z, boolean z2) {
        this.name = str;
        this.sourceFile = str2;
        this.packageHash = i;
        this.locations = list;
        this.repeatOffset = i2;
        this.parameters = list2;
        this.isCall = z;
        this.isInline = z2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSourceFile() {
        return this.sourceFile;
    }

    public final int getPackageHash() {
        return this.packageHash;
    }

    public final List<LocationSourceInformation> getLocations() {
        return this.locations;
    }

    public final int getRepeatOffset() {
        return this.repeatOffset;
    }

    public final List<ParameterSourceInformation> getParameters() {
        return this.parameters;
    }

    /* JADX INFO: renamed from: isCall, reason: from getter */
    public final boolean getIsCall() {
        return this.isCall;
    }

    /* JADX INFO: renamed from: isInline, reason: from getter */
    public final boolean getIsInline() {
        return this.isInline;
    }

    public final SourceLocation nextSourceLocation() {
        int i;
        if (this.nextLocation >= this.locations.size() && (i = this.repeatOffset) >= 0) {
            this.nextLocation = i;
        }
        if (this.nextLocation >= this.locations.size()) {
            return null;
        }
        List<LocationSourceInformation> list = this.locations;
        int i2 = this.nextLocation;
        this.nextLocation = i2 + 1;
        LocationSourceInformation locationSourceInformation = list.get(i2);
        return new SourceLocation(locationSourceInformation.getLineNumber(), locationSourceInformation.getOffset(), locationSourceInformation.getLength(), this.sourceFile, this.packageHash);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0062  */
    public final SourceLocation sourceLocation(int callIndex, SourceInformationContext parentContext) {
        String str;
        int i;
        int iIntValue;
        int i2;
        if (callIndex >= this.locations.size() && (i2 = this.repeatOffset) >= 0 && i2 < this.locations.size()) {
            int i3 = callIndex - this.repeatOffset;
            int size = this.locations.size();
            int i4 = this.repeatOffset;
            callIndex = (i3 % (size - i4)) + i4;
        }
        Integer numValueOf = null;
        if (callIndex >= this.locations.size()) {
            return null;
        }
        LocationSourceInformation locationSourceInformation = this.locations.get(callIndex);
        int lineNumber = locationSourceInformation.getLineNumber();
        int offset = locationSourceInformation.getOffset();
        int length = locationSourceInformation.getLength();
        String str2 = this.sourceFile;
        if (str2 == null) {
            str = parentContext != null ? parentContext.sourceFile : null;
        } else {
            str = str2;
        }
        if (str2 == null) {
            if (parentContext != null) {
                i = parentContext.packageHash;
            }
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            } else {
                iIntValue = -1;
            }
            return new SourceLocation(lineNumber, offset, length, str, iIntValue);
        }
        i = this.packageHash;
        numValueOf = Integer.valueOf(i);
        if (numValueOf != null) {
            iIntValue = numValueOf.intValue();
        } else {
            iIntValue = -1;
        }
        return new SourceLocation(lineNumber, offset, length, str, iIntValue);
    }
}
