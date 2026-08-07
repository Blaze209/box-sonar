package org.yaml.snakeyaml.parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CommentEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.scanner.Scanner;
import org.yaml.snakeyaml.scanner.ScannerImpl;
import org.yaml.snakeyaml.tokens.AliasToken;
import org.yaml.snakeyaml.tokens.AnchorToken;
import org.yaml.snakeyaml.tokens.BlockEntryToken;
import org.yaml.snakeyaml.tokens.CommentToken;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import org.yaml.snakeyaml.tokens.ScalarToken;
import org.yaml.snakeyaml.tokens.StreamEndToken;
import org.yaml.snakeyaml.tokens.StreamStartToken;
import org.yaml.snakeyaml.tokens.TagToken;
import org.yaml.snakeyaml.tokens.TagTuple;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.util.ArrayStack;

/* JADX INFO: loaded from: classes5.dex */
public class ParserImpl implements Parser {
    private static final Map<String, String> DEFAULT_TAGS;
    private Event currentEvent;
    private VersionTagsTuple directives;
    private final ArrayStack<Mark> marks;
    protected final Scanner scanner;
    private Production state;
    private final ArrayStack<Production> states;

    static {
        HashMap map = new HashMap();
        DEFAULT_TAGS = map;
        map.put("!", "!");
        map.put("!!", Tag.PREFIX);
    }

    public ParserImpl(StreamReader streamReader, LoaderOptions loaderOptions) {
        this(new ScannerImpl(streamReader, loaderOptions));
    }

    public ParserImpl(Scanner scanner) {
        this.scanner = scanner;
        this.currentEvent = null;
        this.directives = new VersionTagsTuple(null, new HashMap(DEFAULT_TAGS));
        this.states = new ArrayStack<>(100);
        this.marks = new ArrayStack<>(10);
        this.state = new ParseStreamStart();
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public boolean checkEvent(Event.ID id) {
        peekEvent();
        Event event = this.currentEvent;
        return event != null && event.is(id);
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public Event peekEvent() {
        Production production;
        if (this.currentEvent == null && (production = this.state) != null) {
            this.currentEvent = production.produce();
        }
        return this.currentEvent;
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public Event getEvent() {
        peekEvent();
        Event event = this.currentEvent;
        this.currentEvent = null;
        return event;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CommentEvent produceCommentEvent(CommentToken commentToken) {
        Mark startMark = commentToken.getStartMark();
        Mark endMark = commentToken.getEndMark();
        return new CommentEvent(commentToken.getCommentType(), commentToken.getValue(), startMark, endMark);
    }

    private class ParseStreamStart implements Production {
        private ParseStreamStart() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            StreamStartToken streamStartToken = (StreamStartToken) ParserImpl.this.scanner.getToken();
            StreamStartEvent streamStartEvent = new StreamStartEvent(streamStartToken.getStartMark(), streamStartToken.getEndMark());
            ParserImpl.this.state = new ParseImplicitDocumentStart();
            return streamStartEvent;
        }
    }

    private class ParseImplicitDocumentStart implements Production {
        private ParseImplicitDocumentStart() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = parserImpl.new ParseImplicitDocumentStart();
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.StreamEnd)) {
                Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
                DocumentStartEvent documentStartEvent = new DocumentStartEvent(startMark, startMark, false, null, null);
                ParserImpl.this.states.push(new ParseDocumentEnd());
                ParserImpl.this.state = new ParseBlockNode();
                return documentStartEvent;
            }
            return new ParseDocumentStart().produce();
        }
    }

    private class ParseDocumentStart implements Production {
        private ParseDocumentStart() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            while (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                ParserImpl.this.scanner.getToken();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                ParserImpl.this.scanner.resetDocumentIndex();
                Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
                VersionTagsTuple versionTagsTupleProcessDirectives = ParserImpl.this.processDirectives();
                while (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                    ParserImpl.this.scanner.getToken();
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.StreamEnd)) {
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.DocumentStart)) {
                        throw new ParserException(null, null, "expected '<document start>', but found '" + ParserImpl.this.scanner.peekToken().getTokenId() + "'", ParserImpl.this.scanner.peekToken().getStartMark());
                    }
                    DocumentStartEvent documentStartEvent = new DocumentStartEvent(startMark, ParserImpl.this.scanner.getToken().getEndMark(), true, versionTagsTupleProcessDirectives.getVersion(), versionTagsTupleProcessDirectives.getTags());
                    ParserImpl.this.states.push(new ParseDocumentEnd());
                    ParserImpl.this.state = new ParseDocumentContent();
                    return documentStartEvent;
                }
            }
            StreamEndToken streamEndToken = (StreamEndToken) ParserImpl.this.scanner.getToken();
            StreamEndEvent streamEndEvent = new StreamEndEvent(streamEndToken.getStartMark(), streamEndToken.getEndMark());
            if (ParserImpl.this.states.isEmpty()) {
                if (ParserImpl.this.marks.isEmpty()) {
                    ParserImpl.this.state = null;
                    return streamEndEvent;
                }
                throw new YAMLException("Unexpected end of stream. Marks left: " + ParserImpl.this.marks);
            }
            throw new YAMLException("Unexpected end of stream. States left: " + ParserImpl.this.states);
        }
    }

    private class ParseDocumentEnd implements Production {
        private ParseDocumentEnd() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            Mark endMark;
            Mark startMark = ParserImpl.this.scanner.peekToken().getStartMark();
            boolean z = true;
            if (ParserImpl.this.scanner.checkToken(Token.ID.DocumentEnd)) {
                endMark = ParserImpl.this.scanner.getToken().getEndMark();
            } else {
                endMark = startMark;
                z = false;
            }
            DocumentEndEvent documentEndEvent = new DocumentEndEvent(startMark, endMark, z);
            ParserImpl.this.state = new ParseDocumentStart();
            return documentEndEvent;
        }
    }

    private class ParseDocumentContent implements Production {
        private ParseDocumentContent() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = parserImpl.new ParseDocumentContent();
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.DocumentEnd, Token.ID.StreamEnd)) {
                ParserImpl parserImpl3 = ParserImpl.this;
                Event eventProcessEmptyScalar = parserImpl3.processEmptyScalar(parserImpl3.scanner.peekToken().getStartMark());
                ParserImpl parserImpl4 = ParserImpl.this;
                parserImpl4.state = (Production) parserImpl4.states.pop();
                return eventProcessEmptyScalar;
            }
            return new ParseBlockNode().produce();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VersionTagsTuple processDirectives() {
        HashMap map = new HashMap(this.directives.getTags());
        Iterator<String> it = DEFAULT_TAGS.keySet().iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        this.directives = new VersionTagsTuple(null, map);
        while (this.scanner.checkToken(Token.ID.Directive)) {
            DirectiveToken directiveToken = (DirectiveToken) this.scanner.getToken();
            if (directiveToken.getName().equals("YAML")) {
                if (this.directives.getVersion() != null) {
                    throw new ParserException(null, null, "found duplicate YAML directive", directiveToken.getStartMark());
                }
                List value = directiveToken.getValue();
                if (((Integer) value.get(0)).intValue() != 1) {
                    throw new ParserException(null, null, "found incompatible YAML document (version 1.* is required)", directiveToken.getStartMark());
                }
                if (((Integer) value.get(1)).intValue() == 0) {
                    this.directives = new VersionTagsTuple(DumperOptions.Version.V1_0, map);
                } else {
                    this.directives = new VersionTagsTuple(DumperOptions.Version.V1_1, map);
                }
            } else if (directiveToken.getName().equals("TAG")) {
                List value2 = directiveToken.getValue();
                String str = (String) value2.get(0);
                String str2 = (String) value2.get(1);
                if (map.containsKey(str)) {
                    throw new ParserException(null, null, "duplicate tag handle " + str, directiveToken.getStartMark());
                }
                map.put(str, str2);
            } else {
                continue;
            }
        }
        HashMap map2 = new HashMap();
        if (!map.isEmpty()) {
            map2 = new HashMap(map);
        }
        for (String str3 : DEFAULT_TAGS.keySet()) {
            if (!map.containsKey(str3)) {
                map.put(str3, DEFAULT_TAGS.get(str3));
            }
        }
        return new VersionTagsTuple(this.directives.getVersion(), map2);
    }

    private class ParseBlockNode implements Production {
        private ParseBlockNode() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            return ParserImpl.this.parseNode(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseFlowNode() {
        return parseNode(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseBlockNodeOrIndentlessSequence() {
        return parseNode(true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event parseNode(boolean z, boolean z2) {
        Mark startMark;
        TagTuple value;
        Mark startMark2;
        Mark endMark;
        String value2;
        String str;
        Mark startMark3;
        Mark mark;
        ImplicitTuple implicitTuple;
        if (this.scanner.checkToken(Token.ID.Alias)) {
            AliasToken aliasToken = (AliasToken) this.scanner.getToken();
            AliasEvent aliasEvent = new AliasEvent(aliasToken.getValue(), aliasToken.getStartMark(), aliasToken.getEndMark());
            this.state = this.states.pop();
            return aliasEvent;
        }
        if (this.scanner.checkToken(Token.ID.Anchor)) {
            AnchorToken anchorToken = (AnchorToken) this.scanner.getToken();
            startMark = anchorToken.getStartMark();
            Mark endMark2 = anchorToken.getEndMark();
            String value3 = anchorToken.getValue();
            if (this.scanner.checkToken(Token.ID.Tag)) {
                TagToken tagToken = (TagToken) this.scanner.getToken();
                startMark2 = tagToken.getStartMark();
                endMark = tagToken.getEndMark();
                value = tagToken.getValue();
            } else {
                startMark2 = null;
                endMark = endMark2;
                value = null;
            }
            value2 = value3;
        } else if (this.scanner.checkToken(Token.ID.Tag)) {
            TagToken tagToken2 = (TagToken) this.scanner.getToken();
            startMark = tagToken2.getStartMark();
            endMark = tagToken2.getEndMark();
            value = tagToken2.getValue();
            if (this.scanner.checkToken(Token.ID.Anchor)) {
                AnchorToken anchorToken2 = (AnchorToken) this.scanner.getToken();
                endMark = anchorToken2.getEndMark();
                value2 = anchorToken2.getValue();
            } else {
                value2 = null;
            }
            startMark2 = startMark;
        } else {
            startMark = null;
            value = null;
            startMark2 = null;
            endMark = null;
            value2 = null;
        }
        if (value != null) {
            String handle = value.getHandle();
            String suffix = value.getSuffix();
            if (handle != null) {
                if (!this.directives.getTags().containsKey(handle)) {
                    throw new ParserException("while parsing a node", startMark, "found undefined tag handle " + handle, startMark2);
                }
                suffix = this.directives.getTags().get(handle) + suffix;
            }
            str = suffix;
        } else {
            str = null;
        }
        if (startMark == null) {
            startMark3 = this.scanner.peekToken().getStartMark();
            mark = startMark3;
        } else {
            startMark3 = startMark;
            mark = endMark;
        }
        boolean z3 = str == null || str.equals("!");
        if (z2 && this.scanner.checkToken(Token.ID.BlockEntry)) {
            SequenceStartEvent sequenceStartEvent = new SequenceStartEvent(value2, str, z3, startMark3, this.scanner.peekToken().getEndMark(), DumperOptions.FlowStyle.BLOCK);
            this.state = new ParseIndentlessSequenceEntryKey();
            return sequenceStartEvent;
        }
        if (this.scanner.checkToken(Token.ID.Scalar)) {
            ScalarToken scalarToken = (ScalarToken) this.scanner.getToken();
            Mark endMark3 = scalarToken.getEndMark();
            if ((scalarToken.getPlain() && str == null) || "!".equals(str)) {
                implicitTuple = new ImplicitTuple(true, false);
            } else if (str == null) {
                implicitTuple = new ImplicitTuple(false, true);
            } else {
                implicitTuple = new ImplicitTuple(false, false);
            }
            ScalarEvent scalarEvent = new ScalarEvent(value2, str, implicitTuple, scalarToken.getValue(), startMark3, endMark3, scalarToken.getStyle());
            this.state = this.states.pop();
            return scalarEvent;
        }
        if (this.scanner.checkToken(Token.ID.FlowSequenceStart)) {
            SequenceStartEvent sequenceStartEvent2 = new SequenceStartEvent(value2, str, z3, startMark3, this.scanner.peekToken().getEndMark(), DumperOptions.FlowStyle.FLOW);
            this.state = new ParseFlowSequenceFirstEntry();
            return sequenceStartEvent2;
        }
        if (this.scanner.checkToken(Token.ID.FlowMappingStart)) {
            MappingStartEvent mappingStartEvent = new MappingStartEvent(value2, str, z3, startMark3, this.scanner.peekToken().getEndMark(), DumperOptions.FlowStyle.FLOW);
            this.state = new ParseFlowMappingFirstKey();
            return mappingStartEvent;
        }
        if (z && this.scanner.checkToken(Token.ID.BlockSequenceStart)) {
            SequenceStartEvent sequenceStartEvent3 = new SequenceStartEvent(value2, str, z3, startMark3, this.scanner.peekToken().getStartMark(), DumperOptions.FlowStyle.BLOCK);
            this.state = new ParseBlockSequenceFirstEntry();
            return sequenceStartEvent3;
        }
        if (z && this.scanner.checkToken(Token.ID.BlockMappingStart)) {
            MappingStartEvent mappingStartEvent2 = new MappingStartEvent(value2, str, z3, startMark3, this.scanner.peekToken().getStartMark(), DumperOptions.FlowStyle.BLOCK);
            this.state = new ParseBlockMappingFirstKey();
            return mappingStartEvent2;
        }
        if (value2 != null || str != null) {
            ScalarEvent scalarEvent2 = new ScalarEvent(value2, str, new ImplicitTuple(z3, false), "", startMark3, mark, DumperOptions.ScalarStyle.PLAIN);
            this.state = this.states.pop();
            return scalarEvent2;
        }
        Token tokenPeekToken = this.scanner.peekToken();
        throw new ParserException("while parsing a " + (z ? "block" : "flow") + " node", startMark3, "expected the node content, but found '" + tokenPeekToken.getTokenId() + "'", tokenPeekToken.getStartMark());
    }

    private class ParseBlockSequenceFirstEntry implements Production {
        private ParseBlockSequenceFirstEntry() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return new ParseBlockSequenceEntryKey().produce();
        }
    }

    private class ParseBlockSequenceEntryKey implements Production {
        private ParseBlockSequenceEntryKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = parserImpl.new ParseBlockSequenceEntryKey();
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                return ParserImpl.this.new ParseBlockSequenceEntryValue((BlockEntryToken) ParserImpl.this.scanner.getToken()).produce();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
                throw new ParserException("while parsing a block collection", (Mark) ParserImpl.this.marks.pop(), "expected <block end>, but found '" + tokenPeekToken.getTokenId() + "'", tokenPeekToken.getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
            ParserImpl parserImpl3 = ParserImpl.this;
            parserImpl3.state = (Production) parserImpl3.states.pop();
            ParserImpl.this.marks.pop();
            return sequenceEndEvent;
        }
    }

    private class ParseBlockSequenceEntryValue implements Production {
        BlockEntryToken token;

        public ParseBlockSequenceEntryValue(BlockEntryToken blockEntryToken) {
            this.token = blockEntryToken;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = parserImpl.new ParseBlockSequenceEntryValue(this.token);
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseBlockSequenceEntryKey());
                return new ParseBlockNode().produce();
            }
            ParserImpl.this.state = new ParseBlockSequenceEntryKey();
            return ParserImpl.this.processEmptyScalar(this.token.getEndMark());
        }
    }

    private class ParseIndentlessSequenceEntryKey implements Production {
        private ParseIndentlessSequenceEntryKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = parserImpl.new ParseIndentlessSequenceEntryKey();
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry)) {
                return ParserImpl.this.new ParseIndentlessSequenceEntryValue((BlockEntryToken) ParserImpl.this.scanner.getToken()).produce();
            }
            Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(tokenPeekToken.getStartMark(), tokenPeekToken.getEndMark());
            ParserImpl parserImpl3 = ParserImpl.this;
            parserImpl3.state = (Production) parserImpl3.states.pop();
            return sequenceEndEvent;
        }
    }

    private class ParseIndentlessSequenceEntryValue implements Production {
        BlockEntryToken token;

        public ParseIndentlessSequenceEntryValue(BlockEntryToken blockEntryToken) {
            this.token = blockEntryToken;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = parserImpl.new ParseIndentlessSequenceEntryValue(this.token);
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEntry, Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseIndentlessSequenceEntryKey());
                return new ParseBlockNode().produce();
            }
            ParserImpl.this.state = new ParseIndentlessSequenceEntryKey();
            return ParserImpl.this.processEmptyScalar(this.token.getEndMark());
        }
    }

    private class ParseBlockMappingFirstKey implements Production {
        private ParseBlockMappingFirstKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return new ParseBlockMappingKey().produce();
        }
    }

    private class ParseBlockMappingKey implements Production {
        private ParseBlockMappingKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = parserImpl.new ParseBlockMappingKey();
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                Token token = ParserImpl.this.scanner.getToken();
                if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.states.push(new ParseBlockMappingValue());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingValue();
                return ParserImpl.this.processEmptyScalar(token.getEndMark());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.BlockEnd)) {
                Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
                throw new ParserException("while parsing a block mapping", (Mark) ParserImpl.this.marks.pop(), "expected <block end>, but found '" + tokenPeekToken.getTokenId() + "'", tokenPeekToken.getStartMark());
            }
            Token token2 = ParserImpl.this.scanner.getToken();
            MappingEndEvent mappingEndEvent = new MappingEndEvent(token2.getStartMark(), token2.getEndMark());
            ParserImpl parserImpl3 = ParserImpl.this;
            parserImpl3.state = (Production) parserImpl3.states.pop();
            ParserImpl.this.marks.pop();
            return mappingEndEvent;
        }
    }

    private class ParseBlockMappingValue implements Production {
        private ParseBlockMappingValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                if (ParserImpl.this.scanner.checkToken(Token.ID.Scalar)) {
                    ParserImpl.this.states.push(new ParseBlockMappingKey());
                    return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
                }
                ParserImpl.this.state = new ParseBlockMappingKey();
                return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseBlockMappingValueComment();
                return ParserImpl.this.state.produce();
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.states.push(new ParseBlockMappingKey());
                return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
            }
            ParserImpl.this.state = new ParseBlockMappingKey();
            return ParserImpl.this.processEmptyScalar(token.getEndMark());
        }
    }

    private class ParseBlockMappingValueComment implements Production {
        List<CommentToken> tokens;

        private ParseBlockMappingValueComment() {
            this.tokens = new LinkedList();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                this.tokens.add((CommentToken) ParserImpl.this.scanner.getToken());
                return produce();
            }
            if (ParserImpl.this.scanner.checkToken(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.state = ParserImpl.this.new ParseBlockMappingValueCommentList(this.tokens);
                ParserImpl parserImpl = ParserImpl.this;
                return parserImpl.processEmptyScalar(parserImpl.scanner.peekToken().getStartMark());
            }
            if (!this.tokens.isEmpty()) {
                return ParserImpl.this.produceCommentEvent(this.tokens.remove(0));
            }
            ParserImpl.this.states.push(new ParseBlockMappingKey());
            return ParserImpl.this.parseBlockNodeOrIndentlessSequence();
        }
    }

    private class ParseBlockMappingValueCommentList implements Production {
        List<CommentToken> tokens;

        public ParseBlockMappingValueCommentList(List<CommentToken> list) {
            this.tokens = list;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (!this.tokens.isEmpty()) {
                return ParserImpl.this.produceCommentEvent(this.tokens.remove(0));
            }
            return new ParseBlockMappingKey().produce();
        }
    }

    private class ParseFlowSequenceFirstEntry implements Production {
        private ParseFlowSequenceFirstEntry() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return ParserImpl.this.new ParseFlowSequenceEntry(true).produce();
        }
    }

    private class ParseFlowSequenceEntry implements Production {
        private final boolean first;

        public ParseFlowSequenceEntry(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = parserImpl.new ParseFlowSequenceEntry(this.first);
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                if (!this.first) {
                    if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        ParserImpl.this.scanner.getToken();
                        if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                            ParserImpl parserImpl3 = ParserImpl.this;
                            parserImpl3.state = parserImpl3.new ParseFlowSequenceEntry(true);
                            ParserImpl parserImpl4 = ParserImpl.this;
                            return parserImpl4.produceCommentEvent((CommentToken) parserImpl4.scanner.getToken());
                        }
                    } else {
                        Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow sequence", (Mark) ParserImpl.this.marks.pop(), "expected ',' or ']', but got " + tokenPeekToken.getTokenId(), tokenPeekToken.getStartMark());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token tokenPeekToken2 = ParserImpl.this.scanner.peekToken();
                    MappingStartEvent mappingStartEvent = new MappingStartEvent(null, null, true, tokenPeekToken2.getStartMark(), tokenPeekToken2.getEndMark(), DumperOptions.FlowStyle.FLOW);
                    ParserImpl.this.state = new ParseFlowSequenceEntryMappingKey();
                    return mappingStartEvent;
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.states.push(ParserImpl.this.new ParseFlowSequenceEntry(false));
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token = ParserImpl.this.scanner.getToken();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(token.getStartMark(), token.getEndMark());
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseFlowEndComment();
            } else {
                ParserImpl parserImpl5 = ParserImpl.this;
                parserImpl5.state = (Production) parserImpl5.states.pop();
            }
            ParserImpl.this.marks.pop();
            return sequenceEndEvent;
        }
    }

    private class ParseFlowEndComment implements Production {
        private ParseFlowEndComment() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl parserImpl = ParserImpl.this;
            CommentEvent commentEventProduceCommentEvent = parserImpl.produceCommentEvent((CommentToken) parserImpl.scanner.getToken());
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl2 = ParserImpl.this;
                parserImpl2.state = (Production) parserImpl2.states.pop();
            }
            return commentEventProduceCommentEvent;
        }
    }

    private class ParseFlowSequenceEntryMappingKey implements Production {
        private ParseFlowSequenceEntryMappingKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            Token token = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingValue());
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingValue();
            return ParserImpl.this.processEmptyScalar(token.getEndMark());
        }
    }

    private class ParseFlowSequenceEntryMappingValue implements Production {
        private ParseFlowSequenceEntryMappingValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
                return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.states.push(new ParseFlowSequenceEntryMappingEnd());
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = new ParseFlowSequenceEntryMappingEnd();
            return ParserImpl.this.processEmptyScalar(token.getEndMark());
        }
    }

    private class ParseFlowSequenceEntryMappingEnd implements Production {
        private ParseFlowSequenceEntryMappingEnd() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.state = ParserImpl.this.new ParseFlowSequenceEntry(false);
            Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
            return new MappingEndEvent(tokenPeekToken.getStartMark(), tokenPeekToken.getEndMark());
        }
    }

    private class ParseFlowMappingFirstKey implements Production {
        private ParseFlowMappingFirstKey() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.marks.push(ParserImpl.this.scanner.getToken().getStartMark());
            return ParserImpl.this.new ParseFlowMappingKey(true).produce();
        }
    }

    private class ParseFlowMappingKey implements Production {
        private final boolean first;

        public ParseFlowMappingKey(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.state = parserImpl.new ParseFlowMappingKey(this.first);
                ParserImpl parserImpl2 = ParserImpl.this;
                return parserImpl2.produceCommentEvent((CommentToken) parserImpl2.scanner.getToken());
            }
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                if (!this.first) {
                    if (ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry)) {
                        ParserImpl.this.scanner.getToken();
                        if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                            ParserImpl parserImpl3 = ParserImpl.this;
                            parserImpl3.state = parserImpl3.new ParseFlowMappingKey(true);
                            ParserImpl parserImpl4 = ParserImpl.this;
                            return parserImpl4.produceCommentEvent((CommentToken) parserImpl4.scanner.getToken());
                        }
                    } else {
                        Token tokenPeekToken = ParserImpl.this.scanner.peekToken();
                        throw new ParserException("while parsing a flow mapping", (Mark) ParserImpl.this.marks.pop(), "expected ',' or '}', but got " + tokenPeekToken.getTokenId(), tokenPeekToken.getStartMark());
                    }
                }
                if (ParserImpl.this.scanner.checkToken(Token.ID.Key)) {
                    Token token = ParserImpl.this.scanner.getToken();
                    if (!ParserImpl.this.scanner.checkToken(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                        ParserImpl.this.states.push(new ParseFlowMappingValue());
                        return ParserImpl.this.parseFlowNode();
                    }
                    ParserImpl.this.state = new ParseFlowMappingValue();
                    return ParserImpl.this.processEmptyScalar(token.getEndMark());
                }
                if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.states.push(new ParseFlowMappingEmptyValue());
                    return ParserImpl.this.parseFlowNode();
                }
            }
            Token token2 = ParserImpl.this.scanner.getToken();
            MappingEndEvent mappingEndEvent = new MappingEndEvent(token2.getStartMark(), token2.getEndMark());
            ParserImpl.this.marks.pop();
            if (ParserImpl.this.scanner.checkToken(Token.ID.Comment)) {
                ParserImpl.this.state = new ParseFlowEndComment();
                return mappingEndEvent;
            }
            ParserImpl parserImpl5 = ParserImpl.this;
            parserImpl5.state = (Production) parserImpl5.states.pop();
            return mappingEndEvent;
        }
    }

    private class ParseFlowMappingValue implements Production {
        private ParseFlowMappingValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            if (!ParserImpl.this.scanner.checkToken(Token.ID.Value)) {
                ParserImpl.this.state = ParserImpl.this.new ParseFlowMappingKey(false);
                return ParserImpl.this.processEmptyScalar(ParserImpl.this.scanner.peekToken().getStartMark());
            }
            Token token = ParserImpl.this.scanner.getToken();
            if (!ParserImpl.this.scanner.checkToken(Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                ParserImpl.this.states.push(ParserImpl.this.new ParseFlowMappingKey(false));
                return ParserImpl.this.parseFlowNode();
            }
            ParserImpl.this.state = ParserImpl.this.new ParseFlowMappingKey(false);
            return ParserImpl.this.processEmptyScalar(token.getEndMark());
        }
    }

    private class ParseFlowMappingEmptyValue implements Production {
        private ParseFlowMappingEmptyValue() {
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public Event produce() {
            ParserImpl.this.state = ParserImpl.this.new ParseFlowMappingKey(false);
            ParserImpl parserImpl = ParserImpl.this;
            return parserImpl.processEmptyScalar(parserImpl.scanner.peekToken().getStartMark());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Event processEmptyScalar(Mark mark) {
        return new ScalarEvent(null, null, new ImplicitTuple(true, false), "", mark, mark, DumperOptions.ScalarStyle.PLAIN);
    }
}
