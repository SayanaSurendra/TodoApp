package se.lexicon.data.sequencers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PersonIdSequencerTest {


    @BeforeEach
    void setUp() {
        PersonIdSequencer.setCurrentId(0);
    }

    @Test
    void nextId() {
        assertEquals(1,PersonIdSequencer.nextId());
    }

    @Test
    void getCurrentId() {
        assertEquals(0,PersonIdSequencer.getCurrentId());
    }


}