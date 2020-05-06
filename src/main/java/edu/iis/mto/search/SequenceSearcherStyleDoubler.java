package edu.iis.mto.search;

import java.util.HashMap;

public class SequenceSearcherStyleDoubler implements SequenceSearcher {

  private int methodSearchCallCounter = 0;

  private HashMap<Integer,Integer> resultSeq;

  public void setResultSeq(int[] resultSeq) {
    HashMap<Integer,Integer> fakeSeq = new HashMap<>();
    if(resultSeq != null) {
      for (int i = 0; i < resultSeq.length; i++) {
        fakeSeq.put(resultSeq[i], i);
      }
    }


    this.resultSeq = fakeSeq;
  }

  @Override
  public SearchResult search(int elem, int[] seq) {

    if (seq == null) {
      throw new NullPointerException();
    }

    methodSearchCallCounter++;

    if(this.resultSeq.containsKey(elem)){
      return SearchResult.builder()
          .withFound(true)
          .withPosition(this.resultSeq.get(elem))
          .build();
    }

    return SearchResult.builder()
        .withFound(false)
        .build();

  }

  public int getMethodSearchCallCounter() {
    return methodSearchCallCounter;
  }
}
