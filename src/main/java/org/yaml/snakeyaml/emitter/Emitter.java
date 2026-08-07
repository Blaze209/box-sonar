package org.yaml.snakeyaml.emitter;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.comments.CommentEventsCollector;
import org.yaml.snakeyaml.comments.CommentLine;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CollectionEndEvent;
import org.yaml.snakeyaml.events.CollectionStartEvent;
import org.yaml.snakeyaml.events.CommentEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.scanner.Constant;
import org.yaml.snakeyaml.util.ArrayStack;

/* JADX INFO: loaded from: classes5.dex */
public final class Emitter implements Emitable {
    private static final Map<String, String> DEFAULT_TAG_PREFIXES;
    private static final Map<Character, String> ESCAPE_REPLACEMENTS;
    private static final Pattern HANDLE_FORMAT;
    private static final Set<Character> INVALID_ANCHOR;
    public static final int MAX_INDENT = 10;
    public static final int MIN_INDENT = 1;
    private static final char[] SPACE = {' '};
    private static final Pattern SPACES_PATTERN = Pattern.compile("\\s");
    private final boolean allowUnicode;
    private ScalarAnalysis analysis;
    private int bestIndent;
    private final char[] bestLineBreak;
    private int bestWidth;
    private final CommentEventsCollector blockCommentsCollector;
    private final Boolean canonical;
    private int column;
    private final boolean emitComments;
    private Event event;
    private final Queue<Event> events;
    private int flowLevel;
    private Integer indent;
    private final boolean indentWithIndicator;
    private boolean indention;
    private final ArrayStack<Integer> indents;
    private final int indicatorIndent;
    private final CommentEventsCollector inlineCommentsCollector;
    private boolean mappingContext;
    private final int maxSimpleKeyLength;
    private boolean openEnded;
    private String preparedAnchor;
    private String preparedTag;
    private final Boolean prettyFlow;
    private boolean rootContext;
    private boolean simpleKeyContext;
    private final boolean splitLines;
    private EmitterState state;
    private final ArrayStack<EmitterState> states;
    private final Writer stream;
    private DumperOptions.ScalarStyle style;
    private Map<String, String> tagPrefixes;
    private boolean whitespace;

    void writeStreamStart() {
    }

    static /* synthetic */ int access$2210(Emitter emitter) {
        int i = emitter.flowLevel;
        emitter.flowLevel = i - 1;
        return i;
    }

    static {
        HashSet hashSet = new HashSet();
        INVALID_ANCHOR = hashSet;
        hashSet.add(Character.valueOf(AbstractJsonLexerKt.BEGIN_LIST));
        hashSet.add(Character.valueOf(AbstractJsonLexerKt.END_LIST));
        hashSet.add(Character.valueOf(AbstractJsonLexerKt.BEGIN_OBJ));
        hashSet.add(Character.valueOf(AbstractJsonLexerKt.END_OBJ));
        hashSet.add(Character.valueOf(AbstractJsonLexerKt.COMMA));
        hashSet.add('*');
        hashSet.add(Character.valueOf(Typography.amp));
        HashMap map = new HashMap();
        ESCAPE_REPLACEMENTS = map;
        map.put((char) 0, "0");
        map.put((char) 7, CmcdData.OBJECT_TYPE_AUDIO_ONLY);
        map.put('\b', "b");
        map.put('\t', "t");
        map.put('\n', "n");
        map.put((char) 11, "v");
        map.put('\f', "f");
        map.put('\r', "r");
        map.put((char) 27, "e");
        map.put('\"', "\"");
        map.put('\\', "\\");
        map.put((char) 133, "N");
        map.put(Character.valueOf(Typography.nbsp), "_");
        map.put((char) 8232, "L");
        map.put((char) 8233, "P");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DEFAULT_TAG_PREFIXES = linkedHashMap;
        linkedHashMap.put("!", "!");
        linkedHashMap.put(Tag.PREFIX, "!!");
        HANDLE_FORMAT = Pattern.compile("^![-_\\w]*!$");
    }

    public Emitter(Writer writer, DumperOptions dumperOptions) {
        if (writer == null) {
            throw new NullPointerException("Writer must be provided.");
        }
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must be provided.");
        }
        this.stream = writer;
        this.states = new ArrayStack<>(100);
        this.state = new ExpectStreamStart(this, null);
        ArrayDeque arrayDeque = new ArrayDeque(100);
        this.events = arrayDeque;
        this.event = null;
        this.indents = new ArrayStack<>(10);
        this.indent = null;
        this.flowLevel = 0;
        this.mappingContext = false;
        this.simpleKeyContext = false;
        this.column = 0;
        this.whitespace = true;
        this.indention = true;
        this.openEnded = false;
        this.canonical = Boolean.valueOf(dumperOptions.isCanonical());
        this.prettyFlow = Boolean.valueOf(dumperOptions.isPrettyFlow());
        this.allowUnicode = dumperOptions.isAllowUnicode();
        this.bestIndent = 2;
        if (dumperOptions.getIndent() > 1 && dumperOptions.getIndent() < 10) {
            this.bestIndent = dumperOptions.getIndent();
        }
        this.indicatorIndent = dumperOptions.getIndicatorIndent();
        this.indentWithIndicator = dumperOptions.getIndentWithIndicator();
        this.bestWidth = 80;
        if (dumperOptions.getWidth() > this.bestIndent * 2) {
            this.bestWidth = dumperOptions.getWidth();
        }
        this.bestLineBreak = dumperOptions.getLineBreak().getString().toCharArray();
        this.splitLines = dumperOptions.getSplitLines();
        this.maxSimpleKeyLength = dumperOptions.getMaxSimpleKeyLength();
        this.emitComments = dumperOptions.isProcessComments();
        this.tagPrefixes = new LinkedHashMap();
        this.preparedAnchor = null;
        this.preparedTag = null;
        this.analysis = null;
        this.style = null;
        this.blockCommentsCollector = new CommentEventsCollector(arrayDeque, CommentType.BLANK_LINE, CommentType.BLOCK);
        this.inlineCommentsCollector = new CommentEventsCollector(arrayDeque, CommentType.IN_LINE);
    }

    @Override // org.yaml.snakeyaml.emitter.Emitable
    public void emit(Event event) throws IOException {
        this.events.add(event);
        while (!needMoreEvents()) {
            this.event = this.events.poll();
            this.state.expect();
            this.event = null;
        }
    }

    private boolean needMoreEvents() {
        if (this.events.isEmpty()) {
            return true;
        }
        Iterator<Event> it = this.events.iterator();
        Event next = it.next();
        while (true) {
            Event event = next;
            if (event instanceof CommentEvent) {
                if (!it.hasNext()) {
                    return true;
                }
                next = it.next();
            } else {
                if (event instanceof DocumentStartEvent) {
                    return needEvents(it, 1);
                }
                if (event instanceof SequenceStartEvent) {
                    return needEvents(it, 2);
                }
                if (event instanceof MappingStartEvent) {
                    return needEvents(it, 3);
                }
                if (event instanceof StreamStartEvent) {
                    return needEvents(it, 2);
                }
                if (!(event instanceof StreamEndEvent) && this.emitComments) {
                    return needEvents(it, 1);
                }
                return false;
            }
        }
    }

    private boolean needEvents(Iterator<Event> it, int i) {
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Event next = it.next();
            if (!(next instanceof CommentEvent)) {
                i2++;
                if ((next instanceof DocumentStartEvent) || (next instanceof CollectionStartEvent)) {
                    i3++;
                } else if ((next instanceof DocumentEndEvent) || (next instanceof CollectionEndEvent)) {
                    i3--;
                } else if (next instanceof StreamEndEvent) {
                    i3 = -1;
                }
                if (i3 < 0) {
                    return false;
                }
            }
        }
        return i2 < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void increaseIndent(boolean z, boolean z2) {
        this.indents.push(this.indent);
        Integer num = this.indent;
        if (num != null) {
            if (z2) {
                return;
            }
            this.indent = Integer.valueOf(num.intValue() + this.bestIndent);
        } else if (z) {
            this.indent = Integer.valueOf(this.bestIndent);
        } else {
            this.indent = 0;
        }
    }

    private class ExpectStreamStart implements EmitterState {
        private ExpectStreamStart() {
        }

        /* synthetic */ ExpectStreamStart(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof StreamStartEvent) {
                Emitter.this.writeStreamStart();
                Emitter.this.state = new ExpectFirstDocumentStart(Emitter.this, null);
                return;
            }
            throw new EmitterException("expected StreamStartEvent, but got " + Emitter.this.event);
        }
    }

    private class ExpectNothing implements EmitterState {
        private ExpectNothing() {
        }

        /* synthetic */ ExpectNothing(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            throw new EmitterException("expecting nothing, but got " + Emitter.this.event);
        }
    }

    private class ExpectFirstDocumentStart implements EmitterState {
        private ExpectFirstDocumentStart() {
        }

        /* synthetic */ ExpectFirstDocumentStart(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectDocumentStart(true).expect();
        }
    }

    private class ExpectDocumentStart implements EmitterState {
        private final boolean first;

        public ExpectDocumentStart(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            AnonymousClass1 anonymousClass1 = null;
            if (Emitter.this.event instanceof DocumentStartEvent) {
                DocumentStartEvent documentStartEvent = (DocumentStartEvent) Emitter.this.event;
                if ((documentStartEvent.getVersion() != null || documentStartEvent.getTags() != null) && Emitter.this.openEnded) {
                    Emitter.this.writeIndicator("...", true, false, false);
                    Emitter.this.writeIndent();
                }
                if (documentStartEvent.getVersion() != null) {
                    Emitter.this.writeVersionDirective(Emitter.this.prepareVersion(documentStartEvent.getVersion()));
                }
                Emitter.this.tagPrefixes = new LinkedHashMap(Emitter.DEFAULT_TAG_PREFIXES);
                if (documentStartEvent.getTags() != null) {
                    for (String str : new TreeSet(documentStartEvent.getTags().keySet())) {
                        String str2 = documentStartEvent.getTags().get(str);
                        Emitter.this.tagPrefixes.put(str2, str);
                        Emitter.this.writeTagDirective(Emitter.this.prepareTagHandle(str), Emitter.this.prepareTagPrefix(str2));
                    }
                }
                if (!this.first || documentStartEvent.getExplicit() || Emitter.this.canonical.booleanValue() || documentStartEvent.getVersion() != null || ((documentStartEvent.getTags() != null && !documentStartEvent.getTags().isEmpty()) || Emitter.this.checkEmptyDocument())) {
                    Emitter.this.writeIndent();
                    Emitter.this.writeIndicator("---", true, false, false);
                    if (Emitter.this.canonical.booleanValue()) {
                        Emitter.this.writeIndent();
                    }
                }
                Emitter.this.state = new ExpectDocumentRoot(Emitter.this, anonymousClass1);
                return;
            }
            if (!(Emitter.this.event instanceof StreamEndEvent)) {
                if (Emitter.this.event instanceof CommentEvent) {
                    Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                    Emitter.this.writeBlockComment();
                    return;
                }
                throw new EmitterException("expected DocumentStartEvent, but got " + Emitter.this.event);
            }
            Emitter.this.writeStreamEnd();
            Emitter.this.state = new ExpectNothing(Emitter.this, anonymousClass1);
        }
    }

    private class ExpectDocumentEnd implements EmitterState {
        private ExpectDocumentEnd() {
        }

        /* synthetic */ ExpectDocumentEnd(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (Emitter.this.event instanceof DocumentEndEvent) {
                Emitter.this.writeIndent();
                if (((DocumentEndEvent) Emitter.this.event).getExplicit()) {
                    Emitter.this.writeIndicator("...", true, false, false);
                    Emitter.this.writeIndent();
                }
                Emitter.this.flushStream();
                Emitter.this.state = Emitter.this.new ExpectDocumentStart(false);
                return;
            }
            throw new EmitterException("expected DocumentEndEvent, but got " + Emitter.this.event);
        }
    }

    private class ExpectDocumentRoot implements EmitterState {
        private ExpectDocumentRoot() {
        }

        /* synthetic */ ExpectDocumentRoot(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            AnonymousClass1 anonymousClass1 = null;
            if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                Emitter.this.writeBlockComment();
                if (Emitter.this.event instanceof DocumentEndEvent) {
                    new ExpectDocumentEnd(Emitter.this, anonymousClass1).expect();
                    return;
                }
            }
            Emitter.this.states.push(new ExpectDocumentEnd(Emitter.this, anonymousClass1));
            Emitter.this.expectNode(true, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void expectNode(boolean z, boolean z2, boolean z3) throws IOException {
        this.rootContext = z;
        this.mappingContext = z2;
        this.simpleKeyContext = z3;
        Event event = this.event;
        if (event instanceof AliasEvent) {
            expectAlias();
            return;
        }
        if ((event instanceof ScalarEvent) || (event instanceof CollectionStartEvent)) {
            processAnchor(MsalUtils.QUERY_STRING_DELIMITER);
            processTag();
            Event event2 = this.event;
            if (event2 instanceof ScalarEvent) {
                expectScalar();
                return;
            }
            if (event2 instanceof SequenceStartEvent) {
                if (this.flowLevel != 0 || this.canonical.booleanValue() || ((SequenceStartEvent) this.event).isFlow() || checkEmptySequence()) {
                    expectFlowSequence();
                    return;
                } else {
                    expectBlockSequence();
                    return;
                }
            }
            if (this.flowLevel != 0 || this.canonical.booleanValue() || ((MappingStartEvent) this.event).isFlow() || checkEmptyMapping()) {
                expectFlowMapping();
                return;
            } else {
                expectBlockMapping();
                return;
            }
        }
        throw new EmitterException("expected NodeEvent, but got " + this.event);
    }

    private void expectAlias() throws IOException {
        if (!(this.event instanceof AliasEvent)) {
            throw new EmitterException("Alias must be provided");
        }
        processAnchor("*");
        this.state = this.states.pop();
    }

    private void expectScalar() throws IOException {
        increaseIndent(true, false);
        processScalar();
        this.indent = this.indents.pop();
        this.state = this.states.pop();
    }

    private void expectFlowSequence() throws IOException {
        writeIndicator("[", true, true, false);
        this.flowLevel++;
        increaseIndent(true, false);
        if (this.prettyFlow.booleanValue()) {
            writeIndent();
        }
        this.state = new ExpectFirstFlowSequenceItem(this, null);
    }

    private class ExpectFirstFlowSequenceItem implements EmitterState {
        private ExpectFirstFlowSequenceItem() {
        }

        /* synthetic */ ExpectFirstFlowSequenceItem(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (!(Emitter.this.event instanceof SequenceEndEvent)) {
                if (Emitter.this.event instanceof CommentEvent) {
                    Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                    Emitter.this.writeBlockComment();
                    return;
                }
                if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.states.push(new ExpectFlowSequenceItem(Emitter.this, null));
                Emitter.this.expectNode(false, false, false);
                Emitter emitter = Emitter.this;
                emitter.event = emitter.inlineCommentsCollector.collectEvents(Emitter.this.event);
                Emitter.this.writeInlineComments();
                return;
            }
            Emitter emitter2 = Emitter.this;
            emitter2.indent = (Integer) emitter2.indents.pop();
            Emitter.access$2210(Emitter.this);
            Emitter.this.writeIndicator("]", false, false, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
            Emitter emitter3 = Emitter.this;
            emitter3.state = (EmitterState) emitter3.states.pop();
        }
    }

    private class ExpectFlowSequenceItem implements EmitterState {
        private ExpectFlowSequenceItem() {
        }

        /* synthetic */ ExpectFlowSequenceItem(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (!(Emitter.this.event instanceof SequenceEndEvent)) {
                if (Emitter.this.event instanceof CommentEvent) {
                    Emitter emitter = Emitter.this;
                    emitter.event = emitter.blockCommentsCollector.collectEvents(Emitter.this.event);
                    return;
                }
                Emitter.this.writeIndicator(",", false, false, false);
                Emitter.this.writeBlockComment();
                if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.states.push(Emitter.this.new ExpectFlowSequenceItem());
                Emitter.this.expectNode(false, false, false);
                Emitter emitter2 = Emitter.this;
                emitter2.event = emitter2.inlineCommentsCollector.collectEvents(Emitter.this.event);
                Emitter.this.writeInlineComments();
                return;
            }
            Emitter emitter3 = Emitter.this;
            emitter3.indent = (Integer) emitter3.indents.pop();
            Emitter.access$2210(Emitter.this);
            if (!Emitter.this.canonical.booleanValue()) {
                if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
            } else {
                Emitter.this.writeIndicator(",", false, false, false);
                Emitter.this.writeIndent();
            }
            Emitter.this.writeIndicator("]", false, false, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
            if (Emitter.this.prettyFlow.booleanValue()) {
                Emitter.this.writeIndent();
            }
            Emitter emitter4 = Emitter.this;
            emitter4.state = (EmitterState) emitter4.states.pop();
        }
    }

    private void expectFlowMapping() throws IOException {
        writeIndicator("{", true, true, false);
        this.flowLevel++;
        increaseIndent(true, false);
        if (this.prettyFlow.booleanValue()) {
            writeIndent();
        }
        this.state = new ExpectFirstFlowMappingKey(this, null);
    }

    private class ExpectFirstFlowMappingKey implements EmitterState {
        private ExpectFirstFlowMappingKey() {
        }

        /* synthetic */ ExpectFirstFlowMappingKey(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (!(Emitter.this.event instanceof MappingEndEvent)) {
                if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                    Emitter.this.writeIndent();
                }
                AnonymousClass1 anonymousClass1 = null;
                if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
                    Emitter.this.states.push(new ExpectFlowMappingSimpleValue(Emitter.this, anonymousClass1));
                    Emitter.this.expectNode(false, true, true);
                    return;
                } else {
                    Emitter.this.writeIndicator(MsalUtils.QUERY_STRING_SYMBOL, true, false, false);
                    Emitter.this.states.push(new ExpectFlowMappingValue(Emitter.this, anonymousClass1));
                    Emitter.this.expectNode(false, true, false);
                    return;
                }
            }
            Emitter emitter2 = Emitter.this;
            emitter2.indent = (Integer) emitter2.indents.pop();
            Emitter.access$2210(Emitter.this);
            Emitter.this.writeIndicator("}", false, false, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
            Emitter emitter3 = Emitter.this;
            emitter3.state = (EmitterState) emitter3.states.pop();
        }
    }

    private class ExpectFlowMappingKey implements EmitterState {
        private ExpectFlowMappingKey() {
        }

        /* synthetic */ ExpectFlowMappingKey(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof MappingEndEvent) {
                Emitter emitter = Emitter.this;
                emitter.indent = (Integer) emitter.indents.pop();
                Emitter.access$2210(Emitter.this);
                if (Emitter.this.canonical.booleanValue()) {
                    Emitter.this.writeIndicator(",", false, false, false);
                    Emitter.this.writeIndent();
                }
                if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.writeIndicator("}", false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                Emitter emitter2 = Emitter.this;
                emitter2.state = (EmitterState) emitter2.states.pop();
                return;
            }
            Emitter.this.writeIndicator(",", false, false, false);
            Emitter emitter3 = Emitter.this;
            emitter3.event = emitter3.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                Emitter.this.writeIndent();
            }
            AnonymousClass1 anonymousClass1 = null;
            if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectFlowMappingSimpleValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator(MsalUtils.QUERY_STRING_SYMBOL, true, false, false);
                Emitter.this.states.push(new ExpectFlowMappingValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, false);
            }
        }
    }

    private class ExpectFlowMappingSimpleValue implements EmitterState {
        private ExpectFlowMappingSimpleValue() {
        }

        /* synthetic */ ExpectFlowMappingSimpleValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndicator(":", false, false, false);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter.this.states.push(new ExpectFlowMappingKey(Emitter.this, null));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }
    }

    private class ExpectFlowMappingValue implements EmitterState {
        private ExpectFlowMappingValue() {
        }

        /* synthetic */ ExpectFlowMappingValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
                Emitter.this.writeIndent();
            }
            Emitter.this.writeIndicator(":", true, false, false);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter.this.states.push(new ExpectFlowMappingKey(Emitter.this, null));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }
    }

    private void expectBlockSequence() throws IOException {
        increaseIndent(false, this.mappingContext && !this.indention);
        this.state = new ExpectFirstBlockSequenceItem(this, null);
    }

    private class ExpectFirstBlockSequenceItem implements EmitterState {
        private ExpectFirstBlockSequenceItem() {
        }

        /* synthetic */ ExpectFirstBlockSequenceItem(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectBlockSequenceItem(true).expect();
        }
    }

    private class ExpectBlockSequenceItem implements EmitterState {
        private final boolean first;

        public ExpectBlockSequenceItem(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (this.first || !(Emitter.this.event instanceof SequenceEndEvent)) {
                if (Emitter.this.event instanceof CommentEvent) {
                    Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                    return;
                }
                Emitter.this.writeIndent();
                if (!Emitter.this.indentWithIndicator || this.first) {
                    Emitter emitter = Emitter.this;
                    emitter.writeWhitespace(emitter.indicatorIndent);
                }
                Emitter.this.writeIndicator(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, true, false, true);
                if (Emitter.this.indentWithIndicator && this.first) {
                    Emitter emitter2 = Emitter.this;
                    emitter2.indent = Integer.valueOf(emitter2.indent.intValue() + Emitter.this.indicatorIndent);
                }
                if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                    Emitter.this.increaseIndent(false, false);
                    Emitter.this.writeBlockComment();
                    if (Emitter.this.event instanceof ScalarEvent) {
                        Emitter emitter3 = Emitter.this;
                        emitter3.analysis = emitter3.analyzeScalar(((ScalarEvent) emitter3.event).getValue());
                        if (!Emitter.this.analysis.isEmpty()) {
                            Emitter.this.writeIndent();
                        }
                    }
                    Emitter emitter4 = Emitter.this;
                    emitter4.indent = (Integer) emitter4.indents.pop();
                }
                Emitter.this.states.push(Emitter.this.new ExpectBlockSequenceItem(false));
                Emitter.this.expectNode(false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                return;
            }
            Emitter emitter5 = Emitter.this;
            emitter5.indent = (Integer) emitter5.indents.pop();
            Emitter emitter6 = Emitter.this;
            emitter6.state = (EmitterState) emitter6.states.pop();
        }
    }

    private void expectBlockMapping() throws IOException {
        increaseIndent(false, false);
        this.state = new ExpectFirstBlockMappingKey(this, null);
    }

    private class ExpectFirstBlockMappingKey implements EmitterState {
        private ExpectFirstBlockMappingKey() {
        }

        /* synthetic */ ExpectFirstBlockMappingKey(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.new ExpectBlockMappingKey(true).expect();
        }
    }

    private class ExpectBlockMappingKey implements EmitterState {
        private final boolean first;

        public ExpectBlockMappingKey(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (!this.first && (Emitter.this.event instanceof MappingEndEvent)) {
                Emitter emitter2 = Emitter.this;
                emitter2.indent = (Integer) emitter2.indents.pop();
                Emitter emitter3 = Emitter.this;
                emitter3.state = (EmitterState) emitter3.states.pop();
                return;
            }
            Emitter.this.writeIndent();
            AnonymousClass1 anonymousClass1 = null;
            if (Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectBlockMappingSimpleValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator(MsalUtils.QUERY_STRING_SYMBOL, true, false, true);
                Emitter.this.states.push(new ExpectBlockMappingValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFoldedOrLiteral(Event event) {
        if (!event.is(Event.ID.Scalar)) {
            return false;
        }
        DumperOptions.ScalarStyle scalarStyle = ((ScalarEvent) event).getScalarStyle();
        return scalarStyle == DumperOptions.ScalarStyle.FOLDED || scalarStyle == DumperOptions.ScalarStyle.LITERAL;
    }

    private class ExpectBlockMappingSimpleValue implements EmitterState {
        private ExpectBlockMappingSimpleValue() {
        }

        /* synthetic */ ExpectBlockMappingSimpleValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndicator(":", false, false, false);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter emitter2 = Emitter.this;
            if (!emitter2.isFoldedOrLiteral(emitter2.event) && Emitter.this.writeInlineComments()) {
                Emitter.this.increaseIndent(true, false);
                Emitter.this.writeIndent();
                Emitter emitter3 = Emitter.this;
                emitter3.indent = (Integer) emitter3.indents.pop();
            }
            Emitter emitter4 = Emitter.this;
            emitter4.event = emitter4.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                Emitter.this.increaseIndent(true, false);
                Emitter.this.writeBlockComment();
                Emitter.this.writeIndent();
                Emitter emitter5 = Emitter.this;
                emitter5.indent = (Integer) emitter5.indents.pop();
            }
            Emitter.this.states.push(Emitter.this.new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
        }
    }

    private class ExpectBlockMappingValue implements EmitterState {
        private ExpectBlockMappingValue() {
        }

        /* synthetic */ ExpectBlockMappingValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndent();
            Emitter.this.writeIndicator(":", true, false, true);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter emitter2 = Emitter.this;
            emitter2.event = emitter2.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            Emitter.this.states.push(Emitter.this.new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }
    }

    private boolean checkEmptySequence() {
        return (this.event instanceof SequenceStartEvent) && !this.events.isEmpty() && (this.events.peek() instanceof SequenceEndEvent);
    }

    private boolean checkEmptyMapping() {
        return (this.event instanceof MappingStartEvent) && !this.events.isEmpty() && (this.events.peek() instanceof MappingEndEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkEmptyDocument() {
        if ((this.event instanceof DocumentStartEvent) && !this.events.isEmpty()) {
            Event eventPeek = this.events.peek();
            if (eventPeek instanceof ScalarEvent) {
                ScalarEvent scalarEvent = (ScalarEvent) eventPeek;
                if (scalarEvent.getAnchor() == null && scalarEvent.getTag() == null && scalarEvent.getImplicit() != null && scalarEvent.getValue().length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSimpleKey() {
        int length;
        String tag;
        Event event = this.event;
        if (!(event instanceof NodeEvent) || ((NodeEvent) event).getAnchor() == null) {
            length = 0;
        } else {
            if (this.preparedAnchor == null) {
                this.preparedAnchor = prepareAnchor(((NodeEvent) this.event).getAnchor());
            }
            length = this.preparedAnchor.length();
        }
        Event event2 = this.event;
        if (event2 instanceof ScalarEvent) {
            tag = ((ScalarEvent) event2).getTag();
        } else {
            tag = event2 instanceof CollectionStartEvent ? ((CollectionStartEvent) event2).getTag() : null;
        }
        if (tag != null) {
            if (this.preparedTag == null) {
                this.preparedTag = prepareTag(tag);
            }
            length += this.preparedTag.length();
        }
        Event event3 = this.event;
        if (event3 instanceof ScalarEvent) {
            if (this.analysis == null) {
                this.analysis = analyzeScalar(((ScalarEvent) event3).getValue());
            }
            length += this.analysis.getScalar().length();
        }
        if (length < this.maxSimpleKeyLength) {
            Event event4 = this.event;
            if (event4 instanceof AliasEvent) {
                return true;
            }
            if (((event4 instanceof ScalarEvent) && !this.analysis.isEmpty() && !this.analysis.isMultiline()) || checkEmptySequence() || checkEmptyMapping()) {
                return true;
            }
        }
        return false;
    }

    private void processAnchor(String str) throws IOException {
        NodeEvent nodeEvent = (NodeEvent) this.event;
        if (nodeEvent.getAnchor() == null) {
            this.preparedAnchor = null;
            return;
        }
        if (this.preparedAnchor == null) {
            this.preparedAnchor = prepareAnchor(nodeEvent.getAnchor());
        }
        writeIndicator(str + this.preparedAnchor, true, false, false);
        this.preparedAnchor = null;
    }

    private void processTag() throws IOException {
        String tag;
        Event event = this.event;
        if (event instanceof ScalarEvent) {
            ScalarEvent scalarEvent = (ScalarEvent) event;
            tag = scalarEvent.getTag();
            if (this.style == null) {
                this.style = chooseScalarStyle();
            }
            if ((!this.canonical.booleanValue() || tag == null) && ((this.style == null && scalarEvent.getImplicit().canOmitTagInPlainScalar()) || (this.style != null && scalarEvent.getImplicit().canOmitTagInNonPlainScalar()))) {
                this.preparedTag = null;
                return;
            } else if (scalarEvent.getImplicit().canOmitTagInPlainScalar() && tag == null) {
                this.preparedTag = null;
                tag = "!";
            }
        } else {
            CollectionStartEvent collectionStartEvent = (CollectionStartEvent) event;
            tag = collectionStartEvent.getTag();
            if ((!this.canonical.booleanValue() || tag == null) && collectionStartEvent.getImplicit()) {
                this.preparedTag = null;
                return;
            }
        }
        if (tag == null) {
            throw new EmitterException("tag is not specified");
        }
        if (this.preparedTag == null) {
            this.preparedTag = prepareTag(tag);
        }
        writeIndicator(this.preparedTag, true, false, false);
        this.preparedTag = null;
    }

    private DumperOptions.ScalarStyle chooseScalarStyle() {
        ScalarEvent scalarEvent = (ScalarEvent) this.event;
        if (this.analysis == null) {
            this.analysis = analyzeScalar(scalarEvent.getValue());
        }
        if ((!scalarEvent.isPlain() && scalarEvent.getScalarStyle() == DumperOptions.ScalarStyle.DOUBLE_QUOTED) || this.canonical.booleanValue()) {
            return DumperOptions.ScalarStyle.DOUBLE_QUOTED;
        }
        if (scalarEvent.isPlain() && scalarEvent.getImplicit().canOmitTagInPlainScalar() && (!this.simpleKeyContext || (!this.analysis.isEmpty() && !this.analysis.isMultiline()))) {
            if (this.flowLevel != 0 && this.analysis.isAllowFlowPlain()) {
                return null;
            }
            if (this.flowLevel == 0 && this.analysis.isAllowBlockPlain()) {
                return null;
            }
        }
        if (!scalarEvent.isPlain() && ((scalarEvent.getScalarStyle() == DumperOptions.ScalarStyle.LITERAL || scalarEvent.getScalarStyle() == DumperOptions.ScalarStyle.FOLDED) && this.flowLevel == 0 && !this.simpleKeyContext && this.analysis.isAllowBlock())) {
            return scalarEvent.getScalarStyle();
        }
        if ((scalarEvent.isPlain() || scalarEvent.getScalarStyle() == DumperOptions.ScalarStyle.SINGLE_QUOTED) && this.analysis.isAllowSingleQuoted() && (!this.simpleKeyContext || !this.analysis.isMultiline())) {
            return DumperOptions.ScalarStyle.SINGLE_QUOTED;
        }
        return DumperOptions.ScalarStyle.DOUBLE_QUOTED;
    }

    private void processScalar() throws IOException {
        ScalarEvent scalarEvent = (ScalarEvent) this.event;
        if (this.analysis == null) {
            this.analysis = analyzeScalar(scalarEvent.getValue());
        }
        if (this.style == null) {
            this.style = chooseScalarStyle();
        }
        boolean z = !this.simpleKeyContext && this.splitLines;
        if (this.style == null) {
            writePlain(this.analysis.getScalar(), z);
        } else {
            int i = AnonymousClass1.$SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[this.style.ordinal()];
            if (i == 1) {
                writeDoubleQuoted(this.analysis.getScalar(), z);
            } else if (i == 2) {
                writeSingleQuoted(this.analysis.getScalar(), z);
            } else if (i == 3) {
                writeFolded(this.analysis.getScalar(), z);
            } else if (i == 4) {
                writeLiteral(this.analysis.getScalar());
            } else {
                throw new YAMLException("Unexpected style: " + this.style);
            }
        }
        this.analysis = null;
        this.style = null;
    }

    /* JADX INFO: renamed from: org.yaml.snakeyaml.emitter.Emitter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle;

        static {
            int[] iArr = new int[DumperOptions.ScalarStyle.values().length];
            $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle = iArr;
            try {
                iArr[DumperOptions.ScalarStyle.DOUBLE_QUOTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[DumperOptions.ScalarStyle.SINGLE_QUOTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[DumperOptions.ScalarStyle.FOLDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[DumperOptions.ScalarStyle.LITERAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareVersion(DumperOptions.Version version) {
        if (version.major() != 1) {
            throw new EmitterException("unsupported YAML version: " + version);
        }
        return version.getRepresentation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareTagHandle(String str) {
        if (str.length() == 0) {
            throw new EmitterException("tag handle must not be empty");
        }
        if (str.charAt(0) != '!' || str.charAt(str.length() - 1) != '!') {
            throw new EmitterException("tag handle must start and end with '!': " + str);
        }
        if ("!".equals(str) || HANDLE_FORMAT.matcher(str).matches()) {
            return str;
        }
        throw new EmitterException("invalid character in the tag handle: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareTagPrefix(String str) {
        if (str.length() == 0) {
            throw new EmitterException("tag prefix must not be empty");
        }
        StringBuilder sb = new StringBuilder();
        int i = str.charAt(0) == '!' ? 1 : 0;
        while (i < str.length()) {
            i++;
        }
        if (i > 0) {
            sb.append((CharSequence) str, 0, i);
        }
        return sb.toString();
    }

    private String prepareTag(String str) {
        if (str.length() == 0) {
            throw new EmitterException("tag must not be empty");
        }
        if ("!".equals(str)) {
            return str;
        }
        String str2 = null;
        for (String str3 : this.tagPrefixes.keySet()) {
            if (str.startsWith(str3) && ("!".equals(str3) || str3.length() < str.length())) {
                str2 = str3;
            }
        }
        if (str2 != null) {
            str = str.substring(str2.length());
            str2 = this.tagPrefixes.get(str2);
        }
        int length = str.length();
        String strSubstring = length > 0 ? str.substring(0, length) : "";
        if (str2 != null) {
            return str2 + strSubstring;
        }
        return "!<" + strSubstring + SimpleComparison.GREATER_THAN_OPERATION;
    }

    static String prepareAnchor(String str) {
        if (str.length() == 0) {
            throw new EmitterException("anchor must not be empty");
        }
        for (Character ch : INVALID_ANCHOR) {
            if (str.indexOf(ch.charValue()) > -1) {
                throw new EmitterException("Invalid character '" + ch + "' in the anchor: " + str);
            }
        }
        if (SPACES_PATTERN.matcher(str).find()) {
            throw new EmitterException("Anchor may not contain spaces: " + str);
        }
        return str;
    }

    private static boolean hasLeadingZero(String str) {
        if (str.length() <= 1 || str.charAt(0) != '0') {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && cCharAt != '_') {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:105:0x013e  */
    /* JADX WARN: Code duplicated, block: B:115:0x016b  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:86:0x0103  */
    /* JADX WARN: Code duplicated, block: B:88:0x0107  */
    /* JADX WARN: Code duplicated, block: B:90:0x010e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x0110 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0112  */
    /* JADX WARN: Code duplicated, block: B:95:0x011c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0120  */
    /* JADX WARN: Code duplicated, block: B:99:0x0127  */
    public ScalarAnalysis analyzeScalar(String str) {
        boolean z;
        boolean z2;
        int iCharCount;
        if (str.length() == 0) {
            return new ScalarAnalysis(str, true, false, false, true, true, false);
        }
        boolean zHasLeadingZero = hasLeadingZero(str);
        boolean z3 = false;
        boolean z4 = str.startsWith("---") || str.startsWith("...");
        boolean z5 = z4;
        boolean z6 = str.length() == 1 || Constant.NULL_BL_T_LINEBR.has(str.codePointAt(1));
        int iCharCount2 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = true;
        while (iCharCount2 < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount2);
            boolean z17 = zHasLeadingZero;
            if (iCharCount2 == 0) {
                if ("#,[]{}&*!|>'\"%@`".indexOf(iCodePointAt) != -1) {
                    z4 = true;
                    z5 = true;
                }
                if (iCodePointAt == 63 || iCodePointAt == 58) {
                    if (z6) {
                        z4 = true;
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                }
                if (iCodePointAt == 45 && z6) {
                    z4 = true;
                    z5 = true;
                }
            } else {
                boolean z18 = z4;
                if (",?[]{}".indexOf(iCodePointAt) != -1) {
                    z5 = true;
                }
                if (iCodePointAt != 58) {
                    z4 = z18;
                } else if (z6) {
                    z4 = true;
                    z5 = true;
                } else {
                    z5 = true;
                    z4 = z18;
                }
                if (iCodePointAt == 35 && z16) {
                    z4 = true;
                    z5 = true;
                }
            }
            boolean zHas = Constant.LINEBR.has(iCodePointAt);
            if (zHas) {
                z3 = true;
            }
            int i = 32;
            if (iCodePointAt != 10 && (32 > iCodePointAt || iCodePointAt > 126)) {
                if (iCodePointAt != 133 && ((iCodePointAt < 160 || iCodePointAt > 55295) && ((iCodePointAt < 57344 || iCodePointAt > 65533) && (iCodePointAt < 65536 || iCodePointAt > 1114111)))) {
                    z11 = true;
                } else if (!this.allowUnicode) {
                    z11 = true;
                }
                if (iCodePointAt == i) {
                    if (iCharCount2 == 0) {
                        z7 = true;
                    }
                    if (iCharCount2 == str.length() - 1) {
                        z9 = true;
                    }
                    if (z14) {
                        z12 = true;
                    }
                    z14 = false;
                    z15 = true;
                } else if (zHas) {
                    if (iCharCount2 == 0) {
                        z8 = true;
                    }
                    if (iCharCount2 == str.length() - 1) {
                        z10 = true;
                    }
                    if (z15) {
                        z13 = true;
                    }
                    z15 = false;
                    z14 = true;
                } else {
                    z14 = false;
                    z15 = false;
                }
                iCharCount2 += Character.charCount(iCodePointAt);
                if (!Constant.NULL_BL_T.has(iCodePointAt) || zHas) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (iCharCount2 + 1 < str.length() || (iCharCount = Character.charCount(str.codePointAt(iCharCount2)) + iCharCount2) >= str.length() || Constant.NULL_BL_T.has(str.codePointAt(iCharCount)) || zHas) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z6 = z2;
                zHasLeadingZero = z17;
            }
            i = 32;
            if (iCodePointAt == i) {
                if (iCharCount2 == 0) {
                    z7 = true;
                }
                if (iCharCount2 == str.length() - 1) {
                    z9 = true;
                }
                if (z14) {
                    z12 = true;
                }
                z14 = false;
                z15 = true;
            } else if (zHas) {
                if (iCharCount2 == 0) {
                    z8 = true;
                }
                if (iCharCount2 == str.length() - 1) {
                    z10 = true;
                }
                if (z15) {
                    z13 = true;
                }
                z15 = false;
                z14 = true;
            } else {
                z14 = false;
                z15 = false;
            }
            iCharCount2 += Character.charCount(iCodePointAt);
            if (Constant.NULL_BL_T.has(iCodePointAt)) {
                z16 = true;
            } else {
                z16 = true;
            }
            if (iCharCount2 + 1 < str.length()) {
                z2 = true;
            } else {
                z2 = true;
            }
            z6 = z2;
            zHasLeadingZero = z17;
        }
        boolean z19 = z4;
        boolean z20 = (z7 || z8 || z9 || z10 || zHasLeadingZero) ? false : true;
        boolean z21 = z20;
        boolean z22 = !z9;
        if (z12) {
            z20 = false;
            z21 = false;
        }
        boolean z23 = !z12;
        if (z13 || z11) {
            z20 = false;
            z21 = false;
            z23 = false;
            z = false;
        } else {
            z = z22;
        }
        if (z3) {
            z20 = false;
        }
        return new ScalarAnalysis(str, false, z3, z5 ? false : z20, z19 ? false : z21, z23, z);
    }

    void flushStream() throws IOException {
        this.stream.flush();
    }

    void writeStreamEnd() throws IOException {
        flushStream();
    }

    void writeIndicator(String str, boolean z, boolean z2, boolean z3) throws IOException {
        if (!this.whitespace && z) {
            this.column++;
            this.stream.write(SPACE);
        }
        this.whitespace = z2;
        this.indention = this.indention && z3;
        this.column += str.length();
        this.openEnded = false;
        this.stream.write(str);
    }

    void writeIndent() throws IOException {
        int i;
        Integer num = this.indent;
        int iIntValue = num != null ? num.intValue() : 0;
        if (!this.indention || (i = this.column) > iIntValue || (i == iIntValue && !this.whitespace)) {
            writeLineBreak(null);
        }
        writeWhitespace(iIntValue - this.column);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeWhitespace(int i) throws IOException {
        if (i <= 0) {
            return;
        }
        this.whitespace = true;
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = ' ';
        }
        this.column += i;
        this.stream.write(cArr);
    }

    private void writeLineBreak(String str) throws IOException {
        this.whitespace = true;
        this.indention = true;
        this.column = 0;
        if (str == null) {
            this.stream.write(this.bestLineBreak);
        } else {
            this.stream.write(str);
        }
    }

    void writeVersionDirective(String str) throws IOException {
        this.stream.write("%YAML ");
        this.stream.write(str);
        writeLineBreak(null);
    }

    void writeTagDirective(String str, String str2) throws IOException {
        this.stream.write("%TAG ");
        this.stream.write(str);
        this.stream.write(SPACE);
        this.stream.write(str2);
        writeLineBreak(null);
    }

    private void writeSingleQuoted(String str, boolean z) throws IOException {
        writeIndicator("'", true, false, false);
        int i = 0;
        boolean z2 = false;
        boolean zHas = false;
        int i2 = 0;
        while (i <= str.length()) {
            char cCharAt = i < str.length() ? str.charAt(i) : (char) 0;
            if (z2) {
                if (cCharAt == 0 || cCharAt != ' ') {
                    if (i2 + 1 == i && this.column > this.bestWidth && z && i2 != 0 && i != str.length()) {
                        writeIndent();
                    } else {
                        int i3 = i - i2;
                        this.column += i3;
                        this.stream.write(str, i2, i3);
                    }
                    i2 = i;
                }
            } else if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    if (str.charAt(i2) == '\n') {
                        writeLineBreak(null);
                    }
                    for (char c : str.substring(i2, i).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    writeIndent();
                    i2 = i;
                }
            } else if (Constant.LINEBR.has(cCharAt, "\u0000 '") && i2 < i) {
                int i4 = i - i2;
                this.column += i4;
                this.stream.write(str, i2, i4);
                i2 = i;
            }
            if (cCharAt == '\'') {
                this.column += 2;
                this.stream.write("''");
                i2 = i + 1;
            }
            if (cCharAt != 0) {
                z2 = cCharAt == ' ';
                zHas = Constant.LINEBR.has(cCharAt);
            }
            i++;
        }
        writeIndicator("'", false, false, false);
    }

    private void writeDoubleQuoted(String str, boolean z) throws IOException {
        int iCharValue;
        String str2;
        int i;
        writeIndicator("\"", true, false, false);
        int i2 = 0;
        int i3 = 0;
        while (i2 <= str.length()) {
            Character chValueOf = i2 < str.length() ? Character.valueOf(str.charAt(i2)) : null;
            if (chValueOf == null || "\"\\\u0085\u2028\u2029\ufeff".indexOf(chValueOf.charValue()) != -1 || ' ' > chValueOf.charValue() || chValueOf.charValue() > '~') {
                if (i3 < i2) {
                    int i4 = i2 - i3;
                    this.column += i4;
                    this.stream.write(str, i3, i4);
                    i3 = i2;
                }
                if (chValueOf != null) {
                    Map<Character, String> map = ESCAPE_REPLACEMENTS;
                    if (map.containsKey(chValueOf)) {
                        str2 = "\\" + map.get(chValueOf);
                    } else {
                        if (Character.isHighSurrogate(chValueOf.charValue()) && (i = i2 + 1) < str.length()) {
                            iCharValue = Character.toCodePoint(chValueOf.charValue(), str.charAt(i));
                        } else {
                            iCharValue = chValueOf.charValue();
                        }
                        if (this.allowUnicode && StreamReader.isPrintable(iCharValue)) {
                            String strValueOf = String.valueOf(Character.toChars(iCharValue));
                            if (Character.charCount(iCharValue) == 2) {
                                i2++;
                            }
                            str2 = strValueOf;
                        } else if (chValueOf.charValue() <= 255) {
                            String str3 = "0" + Integer.toString(chValueOf.charValue(), 16);
                            str2 = "\\x" + str3.substring(str3.length() - 2);
                        } else if (Character.charCount(iCharValue) == 2) {
                            i2++;
                            String str4 = "000" + Long.toHexString(iCharValue);
                            str2 = "\\U" + str4.substring(str4.length() - 8);
                        } else {
                            String str5 = "000" + Integer.toString(chValueOf.charValue(), 16);
                            str2 = "\\u" + str5.substring(str5.length() - 4);
                        }
                    }
                    this.column += str2.length();
                    this.stream.write(str2);
                    i3 = i2 + 1;
                }
            }
            if (i2 > 0 && i2 < str.length() - 1 && ((chValueOf.charValue() == ' ' || i3 >= i2) && this.column + (i2 - i3) > this.bestWidth && z)) {
                String str6 = i3 >= i2 ? "\\" : str.substring(i3, i2) + "\\";
                if (i3 < i2) {
                    i3 = i2;
                }
                this.column += str6.length();
                this.stream.write(str6);
                writeIndent();
                this.whitespace = false;
                this.indention = false;
                if (str.charAt(i3) == ' ') {
                    this.column += "\\".length();
                    this.stream.write("\\");
                }
            }
            i2++;
        }
        writeIndicator("\"", false, false, false);
    }

    private boolean writeCommentLines(List<CommentLine> list) throws IOException {
        if (!this.emitComments) {
            return false;
        }
        boolean z = true;
        boolean z2 = false;
        int i = 0;
        for (CommentLine commentLine : list) {
            if (commentLine.getCommentType() != CommentType.BLANK_LINE) {
                if (z) {
                    writeIndicator("#", commentLine.getCommentType() == CommentType.IN_LINE, false, false);
                    int i2 = this.column;
                    i = i2 > 0 ? i2 - 1 : 0;
                    z = false;
                } else {
                    writeWhitespace(i);
                    writeIndicator("#", false, false, false);
                }
                this.stream.write(commentLine.getValue());
                writeLineBreak(null);
            } else {
                writeLineBreak(null);
                writeIndent();
            }
            z2 = true;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeBlockComment() throws IOException {
        if (this.blockCommentsCollector.isEmpty()) {
            return;
        }
        writeIndent();
        writeCommentLines(this.blockCommentsCollector.consume());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean writeInlineComments() throws IOException {
        return writeCommentLines(this.inlineCommentsCollector.consume());
    }

    private String determineBlockHints(String str) {
        StringBuilder sb = new StringBuilder();
        if (Constant.LINEBR.has(str.charAt(0), " ")) {
            sb.append(this.bestIndent);
        }
        if (Constant.LINEBR.hasNo(str.charAt(str.length() - 1))) {
            sb.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        } else if (str.length() == 1 || Constant.LINEBR.has(str.charAt(str.length() - 2))) {
            sb.append(Marker.ANY_NON_NULL_MARKER);
        }
        return sb.toString();
    }

    void writeFolded(String str, boolean z) throws IOException {
        String strDetermineBlockHints = determineBlockHints(str);
        writeIndicator(SimpleComparison.GREATER_THAN_OPERATION + strDetermineBlockHints, true, false, false);
        if (strDetermineBlockHints.length() > 0 && strDetermineBlockHints.charAt(strDetermineBlockHints.length() - 1) == '+') {
            this.openEnded = true;
        }
        if (!writeInlineComments()) {
            writeLineBreak(null);
        }
        boolean zHas = true;
        boolean z2 = true;
        int i = 0;
        boolean z3 = false;
        int i2 = 0;
        while (i <= str.length()) {
            char cCharAt = i < str.length() ? str.charAt(i) : (char) 0;
            if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    if (!z2 && cCharAt != 0 && cCharAt != ' ' && str.charAt(i2) == '\n') {
                        writeLineBreak(null);
                    }
                    z2 = cCharAt == ' ';
                    for (char c : str.substring(i2, i).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    if (cCharAt != 0) {
                        writeIndent();
                    }
                    i2 = i;
                }
            } else if (z3) {
                if (cCharAt != ' ') {
                    if (i2 + 1 == i && this.column > this.bestWidth && z) {
                        writeIndent();
                    } else {
                        int i3 = i - i2;
                        this.column += i3;
                        this.stream.write(str, i2, i3);
                    }
                    i2 = i;
                }
            } else if (Constant.LINEBR.has(cCharAt, "\u0000 ")) {
                int i4 = i - i2;
                this.column += i4;
                this.stream.write(str, i2, i4);
                if (cCharAt == 0) {
                    writeLineBreak(null);
                }
                i2 = i;
            }
            if (cCharAt != 0) {
                zHas = Constant.LINEBR.has(cCharAt);
                z3 = cCharAt == ' ';
            }
            i++;
        }
    }

    void writeLiteral(String str) throws IOException {
        String strDetermineBlockHints = determineBlockHints(str);
        boolean zHas = true;
        writeIndicator("|" + strDetermineBlockHints, true, false, false);
        if (strDetermineBlockHints.length() > 0 && strDetermineBlockHints.charAt(strDetermineBlockHints.length() - 1) == '+') {
            this.openEnded = true;
        }
        if (!writeInlineComments()) {
            writeLineBreak(null);
        }
        int i = 0;
        int i2 = 0;
        while (i <= str.length()) {
            char cCharAt = i < str.length() ? str.charAt(i) : (char) 0;
            if (zHas) {
                if (cCharAt == 0 || Constant.LINEBR.hasNo(cCharAt)) {
                    for (char c : str.substring(i2, i).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    if (cCharAt != 0) {
                        writeIndent();
                    }
                    i2 = i;
                }
            } else if (cCharAt == 0 || Constant.LINEBR.has(cCharAt)) {
                this.stream.write(str, i2, i - i2);
                if (cCharAt == 0) {
                    writeLineBreak(null);
                }
                i2 = i;
            }
            if (cCharAt != 0) {
                zHas = Constant.LINEBR.has(cCharAt);
            }
            i++;
        }
    }

    void writePlain(String str, boolean z) throws IOException {
        if (this.rootContext) {
            this.openEnded = true;
        }
        if (str.length() == 0) {
            return;
        }
        if (!this.whitespace) {
            this.column++;
            this.stream.write(SPACE);
        }
        this.whitespace = false;
        this.indention = false;
        int i = 0;
        boolean z2 = false;
        boolean zHas = false;
        int i2 = 0;
        while (i <= str.length()) {
            char cCharAt = i < str.length() ? str.charAt(i) : (char) 0;
            if (z2) {
                if (cCharAt != ' ') {
                    if (i2 + 1 == i && this.column > this.bestWidth && z) {
                        writeIndent();
                        this.whitespace = false;
                        this.indention = false;
                    } else {
                        int i3 = i - i2;
                        this.column += i3;
                        this.stream.write(str, i2, i3);
                    }
                    i2 = i;
                }
            } else if (zHas) {
                if (Constant.LINEBR.hasNo(cCharAt)) {
                    if (str.charAt(i2) == '\n') {
                        writeLineBreak(null);
                    }
                    for (char c : str.substring(i2, i).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    writeIndent();
                    this.whitespace = false;
                    this.indention = false;
                    i2 = i;
                }
            } else if (Constant.LINEBR.has(cCharAt, "\u0000 ")) {
                int i4 = i - i2;
                this.column += i4;
                this.stream.write(str, i2, i4);
                i2 = i;
            }
            if (cCharAt != 0) {
                z2 = cCharAt == ' ';
                zHas = Constant.LINEBR.has(cCharAt);
            }
            i++;
        }
    }
}
