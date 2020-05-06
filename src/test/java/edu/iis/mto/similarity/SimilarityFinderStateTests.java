package edu.iis.mto.similarity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.iis.mto.search.SequenceSearcherStyleDoubler;
import org.junit.jupiter.api.Test;

class SimilarityFinderTests {

  private SequenceSearcherStyleDoubler sequenceSearcherStyleDoubler;
  private SimilarityFinder similarityFinder;
  private int[] seq1;
  private int[] seq2;
  private double expectedSimilarity;
  private double calculatedSimilarity;


  @Test
  void calculateIfSequencesNoCommonValues() {
    seq1 = new int[]{-1, 24, 8};
    seq2 = new int[]{1, 5, 4};
    expectedSimilarity = 0;

    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    sequenceSearcherStyleDoubler.setResultSeq(seq2);
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }

  @Test
  void calculateIfTwoSequencesAllCommonValues() {
    seq1 = new int[]{2, 51, 1};
    seq2 = new int[]{2, 51, 1};
    expectedSimilarity = 1.0;

    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    sequenceSearcherStyleDoubler.setResultSeq(seq2);
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }

  @Test
  void calculateIfFirstSequenceIsEmpty() {
    seq1 = new int[]{};
    seq2 = new int[]{1, 22, 3};
    expectedSimilarity = 0.0;

    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    sequenceSearcherStyleDoubler.setResultSeq(seq2);
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }

  @Test
  void calculateIfSecondSequenceIsEmpty() {
    seq1 = new int[]{12, 3, 5};
    seq2 = new int[]{};
    expectedSimilarity = 0.0;

    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    sequenceSearcherStyleDoubler.setResultSeq(seq2);
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }

  @Test
  void calculateIfSequencesHaveOneDifferentValue() {
    seq1 = new int[]{4, 2, 1};
    seq2 = new int[]{5, 2, 1};
    expectedSimilarity = 0.5;

    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    sequenceSearcherStyleDoubler.setResultSeq(seq2);
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }

  @Test
  void calculateIfSequencesHaveTwoDifferentValues() {
    seq1 = new int[]{4, 3, 1};
    seq2 = new int[]{5, 6, 1};
    expectedSimilarity = 0.2;

    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    sequenceSearcherStyleDoubler.setResultSeq(seq2);
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }



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
