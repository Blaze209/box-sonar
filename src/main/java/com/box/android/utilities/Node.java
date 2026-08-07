package com.box.android.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Tree.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u000e\u0010\u000f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\u0015\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0005HÆ\u0003J4\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/box/android/utilities/Node;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "children", "", "(Ljava/lang/Object;Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "add", "", "node", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Object;Ljava/util/List;)Lcom/box/android/utilities/Node;", "equals", "", "other", "hashCode", "", "toString", "", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class Node<T> {
    private final List<Node<T>> children;
    private final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Node copy$default(Node node, Object obj, List list, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = node.value;
        }
        if ((i & 2) != 0) {
            list = node.children;
        }
        return node.copy(obj, list);
    }

    public final T component1() {
        return this.value;
    }

    public final List<Node<T>> component2() {
        return this.children;
    }

    public final Node<T> copy(T value, List<Node<T>> children) {
        Intrinsics.checkNotNullParameter(children, "children");
        return new Node<>(value, children);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Node)) {
            return false;
        }
        Node node = (Node) other;
        return Intrinsics.areEqual(this.value, node.value) && Intrinsics.areEqual(this.children, node.children);
    }

    public int hashCode() {
        T t = this.value;
        return ((t == null ? 0 : t.hashCode()) * 31) + this.children.hashCode();
    }

    public String toString() {
        return "Node(value=" + this.value + ", children=" + this.children + ')';
    }

    public Node(T t, List<Node<T>> children) {
        Intrinsics.checkNotNullParameter(children, "children");
        this.value = t;
        this.children = children;
    }

    public final T getValue() {
        return this.value;
    }

    public /* synthetic */ Node(Object obj, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? new ArrayList() : arrayList);
    }

    public final List<Node<T>> getChildren() {
        return this.children;
    }

    public final void add(Node<T> node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.children.add(node);
    }
}
