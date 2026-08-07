package com.pspdfkit.internal;

import com.box.android.common.utilities.BoxCommonConstants;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.annotations.measurements.MeasurementValueConfigurationEditorImpl", f = "MeasurementValueConfigurationEditorImpl.kt", i = {0, 0, 0, 1, 1, 1}, l = {279, 293}, m = "internalRemove", n = {"value", "deleteAssociatedAnnotations", "addToUndo", "value", "deleteAssociatedAnnotations", "addToUndo"}, nl = {280, BoxCommonConstants.REQUEST_OPEN_FILE}, s = {"L$0", "Z$0", "Z$1", "L$0", "Z$0", "Z$1"}, v = 2)
public final class eq extends ContinuationImpl {
    public Object a;
    public boolean b;
    public boolean c;
    public /* synthetic */ Object d;
    public final /* synthetic */ dq e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eq(dq dqVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = dqVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a((MeasurementValueConfiguration) null, false, false, (ContinuationImpl) this);
    }
}
