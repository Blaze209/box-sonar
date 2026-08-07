package com.box.androidsdk.content.utils.logging;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.builder.ToStringStyle;

/* JADX INFO: compiled from: RecursivePIIMaskingToStringStyle.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rH\u0014J\u0014\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002¨\u0006\u0012"}, d2 = {"Lcom/box/androidsdk/content/utils/logging/RecursivePIIMaskingToStringStyle;", "Lorg/apache/commons/lang3/builder/ToStringStyle;", "<init>", "()V", "appendDetail", "", "buffer", "Ljava/lang/StringBuffer;", "fieldName", "", "value", "", "coll", "", "accept", "", "clazz", "Ljava/lang/Class;", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecursivePIIMaskingToStringStyle extends ToStringStyle {
    public static final RecursivePIIMaskingToStringStyle INSTANCE;

    private RecursivePIIMaskingToStringStyle() {
    }

    static {
        RecursivePIIMaskingToStringStyle recursivePIIMaskingToStringStyle = new RecursivePIIMaskingToStringStyle();
        INSTANCE = recursivePIIMaskingToStringStyle;
        recursivePIIMaskingToStringStyle.setUseClassName(true);
        recursivePIIMaskingToStringStyle.setUseShortClassName(true);
        recursivePIIMaskingToStringStyle.setUseIdentityHashCode(false);
        recursivePIIMaskingToStringStyle.setUseFieldNames(true);
        recursivePIIMaskingToStringStyle.setFieldSeparator(", ");
        recursivePIIMaskingToStringStyle.setContentStart("(");
        recursivePIIMaskingToStringStyle.setContentEnd(")");
        recursivePIIMaskingToStringStyle.setArrayStart("[");
        recursivePIIMaskingToStringStyle.setArrayEnd("]");
        recursivePIIMaskingToStringStyle.setArraySeparator(", ");
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer buffer, String fieldName, Object value) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNull(value);
        if (!ClassUtils.isPrimitiveWrapper(value.getClass()) && !Intrinsics.areEqual(String.class, value.getClass()) && accept(value.getClass())) {
            buffer.append(new PIIMaskingToStringBuilder(value, this));
        } else {
            super.appendDetail(buffer, fieldName, value);
        }
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    protected void appendDetail(StringBuffer buffer, String fieldName, Collection<?> coll) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        appendClassName(buffer, coll);
        appendIdentityHashCode(buffer, coll);
        Intrinsics.checkNotNull(coll);
        appendDetail(buffer, fieldName, coll.toArray(new Object[0]));
    }

    private final boolean accept(Class<?> clazz) {
        return Configuration.INSTANCE.accept(clazz);
    }
}
