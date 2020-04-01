package edu.iis.mto.search;

public class SequenceSearcherStyleDoubler implements SequenceSearcher {

  private int methodSearchCallCounter = 0;

  @Override
  public SearchResult search(int elem, int[] seq) {

    if (seq == null) {
      throw new NullPointerException();
    }
    methodSearchCallCounter++;
    for (int i = 0; i < seq.length; i++) {
      if (elem == seq[i]) {
        return SearchResult.builder()
            .withFound(true)
            .withPosition(i)
            .build();
      }
    }
    return SearchResult.builder()
        .build();

  }

  public int getMethodSearchCallCounter() {
    return methodSearchCallCounter;
  }
}
