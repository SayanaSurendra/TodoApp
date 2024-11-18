package se.lexicon.data.sequencers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemIdSequencerTest {
    @BeforeEach
    void setUp() {
        TodoItemIdSequencer.setCurrentId(0);
    }

    @Test
    void nextId() {
        assertEquals(1,TodoItemIdSequencer.nextId());
    }

    @Test
    void getCurrentId() {
        assertEquals(0,TodoItemIdSequencer.getCurrentId());
    }

}