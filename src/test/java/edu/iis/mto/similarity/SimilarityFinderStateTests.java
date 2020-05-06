package edu.iis.mto.similarity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.iis.mto.search.SequenceSearcherStyleDoubler;
import org.junit.jupiter.api.Test;

class SimilarityFinderStateTests {

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


}
