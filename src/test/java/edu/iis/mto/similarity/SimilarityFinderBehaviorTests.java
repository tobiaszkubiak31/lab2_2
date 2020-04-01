package edu.iis.mto.similarity;

import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.iis.mto.search.SequenceSearcherStyleDoubler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimilarityFinderBehaviorTests {

  private SequenceSearcherStyleDoubler sequenceSearcherStyleDoubler;
  private SimilarityFinder similarityFinder;
  private int[] seq1;
  private int[] seq2;

  @BeforeEach
  void setUpVariables() {
    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);

  }

  @Test
  void FirstSequenceIsNull() {
    seq1 = null;
    seq2 = new int[]{1, 5, 4};

    assertThrows(
        NullPointerException.class,
        () -> this.similarityFinder.calculateJackardSimilarity(seq1, seq2));
  }

  @Test
  void SecondSequenceIsNull() {
    seq2 = null;
    seq1 = new int[]{4, 22, 1};

    assertThrows(
        NullPointerException.class,
        () -> this.similarityFinder.calculateJackardSimilarity(seq1, seq2));
  }

  @Test
  void BothSequencesAreNull() {
    seq2 = null;
    seq1 = null;

    assertThrows(
        NullPointerException.class,
        () -> this.similarityFinder.calculateJackardSimilarity(seq1, seq2));
  }


  @Test
  void similaritySearcherIsNull() {
    seq1 = new int[]{4, 22, 1};
    seq2 = new int[]{1, 4, 2};
    this.similarityFinder = null;

    assertThrows(
        NullPointerException.class,
        () -> this.similarityFinder.calculateJackardSimilarity(seq1, seq2));
  }

  @Test
  void checkAmountOfOperatesSequenceSearcher() {

  }

}
