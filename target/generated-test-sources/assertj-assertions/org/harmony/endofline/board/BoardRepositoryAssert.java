package org.harmony.endofline.board;

/**
 * {@link BoardRepository} specific assertions - Generated by CustomAssertionGenerator.
 *
 * Although this class is not final to allow Soft assertions proxy, if you wish to extend it, 
 * extend {@link AbstractBoardRepositoryAssert} instead.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public class BoardRepositoryAssert extends AbstractBoardRepositoryAssert<BoardRepositoryAssert, BoardRepository> {

  /**
   * Creates a new <code>{@link BoardRepositoryAssert}</code> to make assertions on actual BoardRepository.
   * @param actual the BoardRepository we want to make assertions on.
   */
  public BoardRepositoryAssert(BoardRepository actual) {
    super(actual, BoardRepositoryAssert.class);
  }

  /**
   * An entry point for BoardRepositoryAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myBoardRepository)</code> and get specific assertion with code completion.
   * @param actual the BoardRepository we want to make assertions on.
   * @return a new <code>{@link BoardRepositoryAssert}</code>
   */
  @org.assertj.core.util.CheckReturnValue
  public static BoardRepositoryAssert assertThat(BoardRepository actual) {
    return new BoardRepositoryAssert(actual);
  }
}