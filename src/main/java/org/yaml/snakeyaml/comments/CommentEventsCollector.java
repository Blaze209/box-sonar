package org.yaml.snakeyaml.comments;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import org.yaml.snakeyaml.events.CommentEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.parser.Parser;

/* JADX INFO: loaded from: classes5.dex */
public class CommentEventsCollector {
    private List<CommentLine> commentLineList = new ArrayList();
    private final Queue<Event> eventSource;
    private final CommentType[] expectedCommentTypes;

    public CommentEventsCollector(final Parser parser, CommentType... commentTypeArr) {
        this.eventSource = new AbstractQueue<Event>() { // from class: org.yaml.snakeyaml.comments.CommentEventsCollector.1
            @Override // java.util.Queue
            public boolean offer(Event event) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Queue
            public Event poll() {
                return parser.getEvent();
            }

            @Override // java.util.Queue
            public Event peek() {
                return parser.peekEvent();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator<Event> iterator() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                throw new UnsupportedOperationException();
            }
        };
        this.expectedCommentTypes = commentTypeArr;
    }

    public CommentEventsCollector(Queue<Event> queue, CommentType... commentTypeArr) {
        this.eventSource = queue;
        this.expectedCommentTypes = commentTypeArr;
    }

    private boolean isEventExpected(Event event) {
        if (event != null && event.is(Event.ID.Comment)) {
            CommentEvent commentEvent = (CommentEvent) event;
            for (CommentType commentType : this.expectedCommentTypes) {
                if (commentEvent.getCommentType() == commentType) {
                    return true;
                }
            }
        }
        return false;
    }

    public CommentEventsCollector collectEvents() {
        collectEvents(null);
        return this;
    }

    public Event collectEvents(Event event) {
        if (event != null) {
            if (!isEventExpected(event)) {
                return event;
            }
            this.commentLineList.add(new CommentLine((CommentEvent) event));
        }
        while (isEventExpected(this.eventSource.peek())) {
            this.commentLineList.add(new CommentLine((CommentEvent) this.eventSource.poll()));
        }
        return null;
    }

    public Event collectEventsAndPoll(Event event) {
        Event eventCollectEvents = collectEvents(event);
        return eventCollectEvents != null ? eventCollectEvents : this.eventSource.poll();
    }

    public List<CommentLine> consume() {
        try {
            return this.commentLineList;
        } finally {
            this.commentLineList = new ArrayList();
        }
    }

    public boolean isEmpty() {
        return this.commentLineList.isEmpty();
    }
}
