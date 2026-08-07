package org.yaml.snakeyaml.nodes;

import java.util.List;
import org.yaml.snakeyaml.comments.CommentLine;
import org.yaml.snakeyaml.error.Mark;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Node {
    private String anchor;
    private List<CommentLine> blockComments;
    private List<CommentLine> endComments;
    protected Mark endMark;
    private List<CommentLine> inLineComments;
    protected boolean resolved;
    private final Mark startMark;
    private Tag tag;
    private boolean twoStepsConstruction;
    private Class<? extends Object> type;
    protected Boolean useClassConstructor;

    public abstract NodeId getNodeId();

    public Node(Tag tag, Mark mark, Mark mark2) {
        setTag(tag);
        this.startMark = mark;
        this.endMark = mark2;
        this.type = Object.class;
        this.twoStepsConstruction = false;
        this.resolved = true;
        this.useClassConstructor = null;
        this.inLineComments = null;
        this.blockComments = null;
        this.endComments = null;
    }

    public Tag getTag() {
        return this.tag;
    }

    public Mark getEndMark() {
        return this.endMark;
    }

    public Mark getStartMark() {
        return this.startMark;
    }

    public void setTag(Tag tag) {
        if (tag == null) {
            throw new NullPointerException("tag in a Node is required.");
        }
        this.tag = tag;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Class<? extends Object> getType() {
        return this.type;
    }

    public void setType(Class<? extends Object> cls) {
        if (cls.isAssignableFrom(this.type)) {
            return;
        }
        this.type = cls;
    }

    public void setTwoStepsConstruction(boolean z) {
        this.twoStepsConstruction = z;
    }

    public boolean isTwoStepsConstruction() {
        return this.twoStepsConstruction;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public boolean useClassConstructor() {
        Boolean bool = this.useClassConstructor;
        if (bool == null) {
            if (this.tag.isSecondary() || !this.resolved || Object.class.equals(this.type) || this.tag.equals(Tag.NULL)) {
                return this.tag.isCompatible(getType());
            }
            return true;
        }
        return bool.booleanValue();
    }

    public void setUseClassConstructor(Boolean bool) {
        this.useClassConstructor = bool;
    }

    public String getAnchor() {
        return this.anchor;
    }

    public void setAnchor(String str) {
        this.anchor = str;
    }

    public List<CommentLine> getInLineComments() {
        return this.inLineComments;
    }

    public void setInLineComments(List<CommentLine> list) {
        this.inLineComments = list;
    }

    public List<CommentLine> getBlockComments() {
        return this.blockComments;
    }

    public void setBlockComments(List<CommentLine> list) {
        this.blockComments = list;
    }

    public List<CommentLine> getEndComments() {
        return this.endComments;
    }

    public void setEndComments(List<CommentLine> list) {
        this.endComments = list;
    }
}
