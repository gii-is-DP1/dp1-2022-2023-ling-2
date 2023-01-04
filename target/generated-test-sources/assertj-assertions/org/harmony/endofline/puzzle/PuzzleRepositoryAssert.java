package org.harmony.endofline.puzzle;

/**
 * {@link PuzzleRepository} specific assertions - Generated by CustomAssertionGenerator.
 *
 * Although this class is not final to allow Soft assertions proxy, if you wish to extend it, 
 * extend {@link AbstractPuzzleRepositoryAssert} instead.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public class PuzzleRepositoryAssert extends AbstractPuzzleRepositoryAssert<PuzzleRepositoryAssert, PuzzleRepository> {

  /**
   * Creates a new <code>{@link PuzzleRepositoryAssert}</code> to make assertions on actual PuzzleRepository.
   * @param actual the PuzzleRepository we want to make assertions on.
   */
  public PuzzleRepositoryAssert(PuzzleRepository actual) {
    super(actual, PuzzleRepositoryAssert.class);
  }

  /**
   * An entry point for PuzzleRepositoryAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myPuzzleRepository)</code> and get specific assertion with code completion.
   * @param actual the PuzzleRepository we want to make assertions on.
   * @return a new <code>{@link PuzzleRepositoryAssert}</code>
   */
  @org.assertj.core.util.CheckReturnValue
  public static PuzzleRepositoryAssert assertThat(PuzzleRepository actual) {
    return new PuzzleRepositoryAssert(actual);
  }
}