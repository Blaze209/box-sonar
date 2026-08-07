package com.box.android.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.observability.DiagnosisParams;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Tree.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u001b\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J/\u0010\u0012\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J/\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u00002\u001a\b\u0002\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\t0\u0019¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/box/android/utilities/Tree;", ExifInterface.GPS_DIRECTION_TRUE, "", "root", "Lcom/box/android/utilities/Node;", "(Lcom/box/android/utilities/Node;)V", "getRoot", "()Lcom/box/android/utilities/Node;", DiagnosisParams.CLEAR_ON_LOGOUT, "", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "find", "value", "(Ljava/lang/Object;)Lcom/box/android/utilities/Node;", "findParent", "Lkotlin/Pair;", "(Ljava/lang/Object;)Lkotlin/Pair;", "hashCode", "", "remove", "actionOnEachRemovedNode", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "toString", "", "cpl-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class Tree<T> {
    private final Node<T> root;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tree copy$default(Tree tree, Node node, int i, Object obj) {
        if ((i & 1) != 0) {
            node = tree.root;
        }
        return tree.copy(node);
    }

    public final Node<T> component1() {
        return this.root;
    }

    public final Tree<T> copy(Node<T> root) {
        Intrinsics.checkNotNullParameter(root, "root");
        return new Tree<>(root);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Tree) && Intrinsics.areEqual(this.root, ((Tree) other).root);
    }

    public int hashCode() {
        return this.root.hashCode();
    }

    public String toString() {
        return "Tree(root=" + this.root + ')';
    }

    public Tree(Node<T> root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
    }

    public final Node<T> getRoot() {
        return this.root;
    }

    public final Node<T> find(T value) {
        List mutableList = CollectionsKt.toMutableList((Collection) this.root.getChildren());
        while (!mutableList.isEmpty()) {
            Node<T> node = (Node) mutableList.remove(0);
            if (Intrinsics.areEqual(node.getValue(), value)) {
                return node;
            }
            mutableList.addAll(node.getChildren());
        }
        return null;
    }

    private final Pair<Node<T>, Node<T>> findParent(T value) {
        List listMutableListOf = CollectionsKt.mutableListOf(this.root);
        while (true) {
            Node node = null;
            if (listMutableListOf.isEmpty()) {
                return null;
            }
            Node node2 = (Node) listMutableListOf.remove(0);
            for (T t : node2.getChildren()) {
                if (Intrinsics.areEqual(((Node) t).getValue(), value)) {
                    node = t;
                    break;
                }
            }
            Node node3 = node;
            if (node3 != null) {
                return new Pair<>(node2, node3);
            }
            listMutableListOf.addAll(node2.getChildren());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void remove$default(Tree tree, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = new Function1<Node<T>, Unit>() { // from class: com.box.android.utilities.Tree.remove.1
                public final void invoke(Node<T> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj3) {
                    invoke((Node) obj3);
                    return Unit.INSTANCE;
                }
            };
        }
        tree.remove(obj, function1);
    }

    public final void remove(T value, Function1<? super Node<T>, Unit> actionOnEachRemovedNode) {
        Intrinsics.checkNotNullParameter(actionOnEachRemovedNode, "actionOnEachRemovedNode");
        if (Intrinsics.areEqual(value, this.root.getValue())) {
            throw new IllegalArgumentException("Cannot uproot the tree!");
        }
        Pair<Node<T>, Node<T>> pairFindParent = findParent(value);
        if (pairFindParent == null) {
            return;
        }
        Node<T> nodeComponent1 = pairFindParent.component1();
        Node<T> nodeComponent2 = pairFindParent.component2();
        List mutableList = CollectionsKt.toMutableList((Collection) nodeComponent2.getChildren());
        while (!mutableList.isEmpty()) {
            Node node = (Node) mutableList.remove(0);
            actionOnEachRemovedNode.invoke(node);
            mutableList.addAll(node.getChildren());
        }
        nodeComponent1.getChildren().remove(nodeComponent2);
        actionOnEachRemovedNode.invoke(nodeComponent2);
    }

    public final void clear() {
        this.root.getChildren().clear();
    }
}
