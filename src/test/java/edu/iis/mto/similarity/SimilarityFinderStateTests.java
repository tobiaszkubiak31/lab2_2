package edu.iis.mto.similarity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.iis.mto.search.SequenceSearcherStyleDoubler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimilarityFinderStateTests {
  private SequenceSearcherStyleDoubler sequenceSearcherStyleDoubler;
  private SimilarityFinder similarityFinder;
  private int[] seq1;
  private int[] seq2;
  private double expectedSimilarity;
  private double calculatedSimilarity;

  @BeforeEach
  void setUpVariables() {
    sequenceSearcherStyleDoubler = new SequenceSearcherStyleDoubler();
    similarityFinder = new SimilarityFinder(sequenceSearcherStyleDoubler);
  }

  @Test
  void calculateIfSequencesNoCommonValues() {
    seq1 = new int[]{-1, 24, 8};
    seq2 = new int[]{1, 5, 4};
    expectedSimilarity = 0;

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }
  @Test
  void calculateIfTwoSequencesAllCommonValues() {
    seq1 = new int[]{2, 51, 1};
    seq2 = new int[]{2, 51, 1};
    expectedSimilarity = 1.0;

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }

  @Test
  void calculateIfFirstSequenceIsEmpty() {
    seq1 = new int[]{};
    seq2 = new int[]{1, 22, 3};
    expectedSimilarity = 0.0;

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }

  @Test
  void calculateIfSecondSequenceIsEmpty() {
    seq1 = new int[]{12, 3, 5};
    seq2 = new int[]{};
    expectedSimilarity = 0.0;

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }

  @Test
  void calculateIfSequencesHaveOneDifferentValue() {
    seq1 = new int[]{ 4,2,1};
    seq2 = new int[]{ 5,2,1};
    expectedSimilarity = 0.5;

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }
  @Test
  void calculateIfSequencesHaveTwoDifferentValues() {
    seq1 = new int[]{ 4,3,1};
    seq2 = new int[]{ 5,6,1};
    expectedSimilarity = 0.2;

    calculatedSimilarity = this.similarityFinder.calculateJackardSimilarity(seq1, seq2);
    assertEquals(expectedSimilarity, calculatedSimilarity);
  }


}
