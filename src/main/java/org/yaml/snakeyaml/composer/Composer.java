package org.yaml.snakeyaml.composer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.comments.CommentEventsCollector;
import org.yaml.snakeyaml.comments.CommentLine;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.parser.Parser;
import org.yaml.snakeyaml.resolver.Resolver;

/* JADX INFO: loaded from: classes5.dex */
public class Composer {
    private final Map<String, Node> anchors;
    private final CommentEventsCollector blockCommentsCollector;
    private final CommentEventsCollector inlineCommentsCollector;
    private final LoaderOptions loadingConfig;
    private final int nestingDepthLimit;
    protected final Parser parser;
    private final Set<Node> recursiveNodes;
    private final Resolver resolver;
    private int nonScalarAliasesCount = 0;
    private int nestingDepth = 0;

    public Composer(Parser parser, Resolver resolver, LoaderOptions loaderOptions) {
        if (parser == null) {
            throw new NullPointerException("Parser must be provided");
        }
        if (resolver == null) {
            throw new NullPointerException("Resolver must be provided");
        }
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided");
        }
        this.parser = parser;
        this.resolver = resolver;
        this.anchors = new HashMap();
        this.recursiveNodes = new HashSet();
        this.loadingConfig = loaderOptions;
        this.blockCommentsCollector = new CommentEventsCollector(parser, CommentType.BLANK_LINE, CommentType.BLOCK);
        this.inlineCommentsCollector = new CommentEventsCollector(parser, CommentType.IN_LINE);
        this.nestingDepthLimit = loaderOptions.getNestingDepthLimit();
    }

    public boolean checkNode() {
        if (this.parser.checkEvent(Event.ID.StreamStart)) {
            this.parser.getEvent();
        }
        return !this.parser.checkEvent(Event.ID.StreamEnd);
    }

    public Node getNode() {
        this.blockCommentsCollector.collectEvents();
        if (this.parser.checkEvent(Event.ID.StreamEnd)) {
            List<CommentLine> listConsume = this.blockCommentsCollector.consume();
            Mark startMark = listConsume.get(0).getStartMark();
            MappingNode mappingNode = new MappingNode(Tag.COMMENT, false, Collections.emptyList(), startMark, null, DumperOptions.FlowStyle.BLOCK);
            mappingNode.setBlockComments(listConsume);
            return mappingNode;
        }
        this.parser.getEvent();
        Node nodeComposeNode = composeNode(null);
        this.blockCommentsCollector.collectEvents();
        if (!this.blockCommentsCollector.isEmpty()) {
            nodeComposeNode.setEndComments(this.blockCommentsCollector.consume());
        }
        this.parser.getEvent();
        this.anchors.clear();
        this.recursiveNodes.clear();
        return nodeComposeNode;
    }

    public Node getSingleNode() {
        this.parser.getEvent();
        Node node = !this.parser.checkEvent(Event.ID.StreamEnd) ? getNode() : null;
        if (!this.parser.checkEvent(Event.ID.StreamEnd)) {
            throw new ComposerException("expected a single document in the stream", node != null ? node.getStartMark() : null, "but found another document", this.parser.getEvent().getStartMark());
        }
        this.parser.getEvent();
        return node;
    }

    private Node composeNode(Node node) {
        Node nodeComposeMappingNode;
        this.blockCommentsCollector.collectEvents();
        if (node != null) {
            this.recursiveNodes.add(node);
        }
        if (this.parser.checkEvent(Event.ID.Alias)) {
            AliasEvent aliasEvent = (AliasEvent) this.parser.getEvent();
            String anchor = aliasEvent.getAnchor();
            if (!this.anchors.containsKey(anchor)) {
                throw new ComposerException(null, null, "found undefined alias " + anchor, aliasEvent.getStartMark());
            }
            nodeComposeMappingNode = this.anchors.get(anchor);
            if (!(nodeComposeMappingNode instanceof ScalarNode)) {
                int i = this.nonScalarAliasesCount + 1;
                this.nonScalarAliasesCount = i;
                if (i > this.loadingConfig.getMaxAliasesForCollections()) {
                    throw new YAMLException("Number of aliases for non-scalar nodes exceeds the specified max=" + this.loadingConfig.getMaxAliasesForCollections());
                }
            }
            if (this.recursiveNodes.remove(nodeComposeMappingNode)) {
                nodeComposeMappingNode.setTwoStepsConstruction(true);
            }
            this.blockCommentsCollector.consume();
            this.inlineCommentsCollector.collectEvents().consume();
        } else {
            String anchor2 = ((NodeEvent) this.parser.peekEvent()).getAnchor();
            increaseNestingDepth();
            if (this.parser.checkEvent(Event.ID.Scalar)) {
                nodeComposeMappingNode = composeScalarNode(anchor2, this.blockCommentsCollector.consume());
            } else if (this.parser.checkEvent(Event.ID.SequenceStart)) {
                nodeComposeMappingNode = composeSequenceNode(anchor2);
            } else {
                nodeComposeMappingNode = composeMappingNode(anchor2);
            }
            decreaseNestingDepth();
        }
        this.recursiveNodes.remove(node);
        return nodeComposeMappingNode;
    }

    protected Node composeScalarNode(String str, List<CommentLine> list) {
        Tag tagResolve;
        boolean z;
        ScalarEvent scalarEvent = (ScalarEvent) this.parser.getEvent();
        String tag = scalarEvent.getTag();
        if (tag == null || tag.equals("!")) {
            tagResolve = this.resolver.resolve(NodeId.scalar, scalarEvent.getValue(), scalarEvent.getImplicit().canOmitTagInPlainScalar());
            z = true;
        } else {
            tagResolve = new Tag(tag);
            if (tagResolve.isCustomGlobal() && !this.loadingConfig.getTagInspector().isGlobalTagAllowed(tagResolve)) {
                throw new ComposerException(null, null, "Global tag is not allowed: " + tag, scalarEvent.getStartMark());
            }
            z = false;
        }
        ScalarNode scalarNode = new ScalarNode(tagResolve, z, scalarEvent.getValue(), scalarEvent.getStartMark(), scalarEvent.getEndMark(), scalarEvent.getScalarStyle());
        if (str != null) {
            scalarNode.setAnchor(str);
            this.anchors.put(str, scalarNode);
        }
        scalarNode.setBlockComments(list);
        scalarNode.setInLineComments(this.inlineCommentsCollector.collectEvents().consume());
        return scalarNode;
    }

    protected Node composeSequenceNode(String str) {
        Tag tagResolve;
        boolean z;
        SequenceStartEvent sequenceStartEvent = (SequenceStartEvent) this.parser.getEvent();
        String tag = sequenceStartEvent.getTag();
        if (tag == null || tag.equals("!")) {
            tagResolve = this.resolver.resolve(NodeId.sequence, null, sequenceStartEvent.getImplicit());
            z = true;
        } else {
            tagResolve = new Tag(tag);
            if (tagResolve.isCustomGlobal() && !this.loadingConfig.getTagInspector().isGlobalTagAllowed(tagResolve)) {
                throw new ComposerException(null, null, "Global tag is not allowed: " + tag, sequenceStartEvent.getStartMark());
            }
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        SequenceNode sequenceNode = new SequenceNode(tagResolve, z, arrayList, sequenceStartEvent.getStartMark(), null, sequenceStartEvent.getFlowStyle());
        if (sequenceStartEvent.isFlow()) {
            sequenceNode.setBlockComments(this.blockCommentsCollector.consume());
        }
        if (str != null) {
            sequenceNode.setAnchor(str);
            this.anchors.put(str, sequenceNode);
        }
        while (!this.parser.checkEvent(Event.ID.SequenceEnd)) {
            this.blockCommentsCollector.collectEvents();
            if (this.parser.checkEvent(Event.ID.SequenceEnd)) {
                break;
            }
            arrayList.add(composeNode(sequenceNode));
        }
        if (sequenceStartEvent.isFlow()) {
            sequenceNode.setInLineComments(this.inlineCommentsCollector.collectEvents().consume());
        }
        sequenceNode.setEndMark(this.parser.getEvent().getEndMark());
        this.inlineCommentsCollector.collectEvents();
        if (!this.inlineCommentsCollector.isEmpty()) {
            sequenceNode.setInLineComments(this.inlineCommentsCollector.consume());
        }
        return sequenceNode;
    }

    protected Node composeMappingNode(String str) {
        Tag tagResolve;
        boolean z;
        MappingStartEvent mappingStartEvent = (MappingStartEvent) this.parser.getEvent();
        String tag = mappingStartEvent.getTag();
        if (tag == null || tag.equals("!")) {
            tagResolve = this.resolver.resolve(NodeId.mapping, null, mappingStartEvent.getImplicit());
            z = true;
        } else {
            tagResolve = new Tag(tag);
            if (tagResolve.isCustomGlobal() && !this.loadingConfig.getTagInspector().isGlobalTagAllowed(tagResolve)) {
                throw new ComposerException(null, null, "Global tag is not allowed: " + tag, mappingStartEvent.getStartMark());
            }
            z = false;
        }
        ArrayList arrayList = new ArrayList();
        MappingNode mappingNode = new MappingNode(tagResolve, z, arrayList, mappingStartEvent.getStartMark(), null, mappingStartEvent.getFlowStyle());
        if (mappingStartEvent.isFlow()) {
            mappingNode.setBlockComments(this.blockCommentsCollector.consume());
        }
        if (str != null) {
            mappingNode.setAnchor(str);
            this.anchors.put(str, mappingNode);
        }
        while (!this.parser.checkEvent(Event.ID.MappingEnd)) {
            this.blockCommentsCollector.collectEvents();
            if (this.parser.checkEvent(Event.ID.MappingEnd)) {
                break;
            }
            composeMappingChildren(arrayList, mappingNode);
        }
        if (mappingStartEvent.isFlow()) {
            mappingNode.setInLineComments(this.inlineCommentsCollector.collectEvents().consume());
        }
        mappingNode.setEndMark(this.parser.getEvent().getEndMark());
        this.inlineCommentsCollector.collectEvents();
        if (!this.inlineCommentsCollector.isEmpty()) {
            mappingNode.setInLineComments(this.inlineCommentsCollector.consume());
        }
        return mappingNode;
    }

    protected void composeMappingChildren(List<NodeTuple> list, MappingNode mappingNode) {
        Node nodeComposeKeyNode = composeKeyNode(mappingNode);
        if (nodeComposeKeyNode.getTag().equals(Tag.MERGE)) {
            mappingNode.setMerged(true);
        }
        list.add(new NodeTuple(nodeComposeKeyNode, composeValueNode(mappingNode)));
    }

    protected Node composeKeyNode(MappingNode mappingNode) {
        return composeNode(mappingNode);
    }

    protected Node composeValueNode(MappingNode mappingNode) {
        return composeNode(mappingNode);
    }

    private void increaseNestingDepth() {
        int i = this.nestingDepth;
        if (i > this.nestingDepthLimit) {
            throw new YAMLException("Nesting Depth exceeded max " + this.nestingDepthLimit);
        }
        this.nestingDepth = i + 1;
    }

    private void decreaseNestingDepth() {
        int i = this.nestingDepth;
        if (i > 0) {
            this.nestingDepth = i - 1;
            return;
        }
        throw new YAMLException("Nesting Depth cannot be negative");
    }
}
