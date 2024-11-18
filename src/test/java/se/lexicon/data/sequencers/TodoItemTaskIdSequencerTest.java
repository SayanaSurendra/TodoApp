package se.lexicon.data.sequencers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskIdSequencerTest {


    @BeforeEach
    void setUp() {
        TodoItemTaskIdSequencer.setCurrentId(0);
    }

    @Test
    void nextId() {
        assertEquals(1,TodoItemTaskIdSequencer.nextId());
    }

    @Test
    void getCurrentId() {
        assertEquals(0,TodoItemTaskIdSequencer.getCurrentId());
    }

}