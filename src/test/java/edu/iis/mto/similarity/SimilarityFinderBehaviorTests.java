package edu.iis.mto.similarity;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.hamcrest.MatcherAssert.assertThat;
import edu.iis.mto.search.SequenceSearcherStyleDoubler;
import org.junit.jupiter.api.Test;

public class SimilarityFinderBehaviorTests {

  private SequenceSearcherStyleDoubler sequenceSearcherStyleDoubler;
  private SimilarityFinder similarityFinder;
  private int[] seq1;
  private int[] seq2;



  @Test
  void firstSequenceIsNull() {
    seq1 = null;
    seq2 = new int[]{1, 5, 4};

    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    sequenceSearcherStyleDoubler.setResultSeq(seq2);
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);

    assertThrows(
        NullPointerException.class,
        () -> this.similarityFinder.calculateJackardSimilarity(seq1, seq2));
  }

  @Test
  void secondSequenceIsNull() {
    seq2 = null;
    seq1 = new int[]{4, 22, 1};

    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    sequenceSearcherStyleDoubler.setResultSeq(seq2);
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);

    assertThrows(
        NullPointerException.class,
        () -> this.similarityFinder.calculateJackardSimilarity(seq1, seq2));
  }

  @Test
  void bothSequencesAreNull() {
    seq2 = null;
    seq1 = null;

    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    sequenceSearcherStyleDoubler.setResultSeq(seq2);
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);

    assertThrows(
        NullPointerException.class,
        () -> this.similarityFinder.calculateJackardSimilarity(seq1, seq2));
  }


  @Test
  void similaritySearcherIsNull() {
    seq1 = new int[]{4, 22, 1};
    seq2 = new int[]{1, 4, 2};


    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    sequenceSearcherStyleDoubler.setResultSeq(seq2);
    this.similarityFinder = null;

    assertThrows(
        NullPointerException.class,
        () -> this.similarityFinder.calculateJackardSimilarity(seq1, seq2));
  }

  @Test
  void checkAmountOfOperatesSequenceSearcher() {
    seq1 = new int[]{2, 22, 1};
    seq2 = new int[]{1, 4, 2};

    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    sequenceSearcherStyleDoubler.setResultSeq(seq2);
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);

    this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertThat(sequenceSearcherStyleDoubler.getMethodSearchCallCounter(), is(3));

  }

}
