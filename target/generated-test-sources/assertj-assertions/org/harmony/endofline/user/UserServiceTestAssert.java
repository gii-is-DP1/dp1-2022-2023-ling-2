package org.harmony.endofline.user;

/**
 * {@link UserServiceTest} specific assertions - Generated by CustomAssertionGenerator.
 *
 * Although this class is not final to allow Soft assertions proxy, if you wish to extend it, 
 * extend {@link AbstractUserServiceTestAssert} instead.
 */
@javax.annotation.Generated(value="assertj-assertions-generator")
public class UserServiceTestAssert extends AbstractUserServiceTestAssert<UserServiceTestAssert, UserServiceTest> {

  /**
   * Creates a new <code>{@link UserServiceTestAssert}</code> to make assertions on actual UserServiceTest.
   * @param actual the UserServiceTest we want to make assertions on.
   */
  public UserServiceTestAssert(UserServiceTest actual) {
    super(actual, UserServiceTestAssert.class);
  }

  /**
   * An entry point for UserServiceTestAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
   * With a static import, one can write directly: <code>assertThat(myUserServiceTest)</code> and get specific assertion with code completion.
   * @param actual the UserServiceTest we want to make assertions on.
   * @return a new <code>{@link UserServiceTestAssert}</code>
   */
  @org.assertj.core.util.CheckReturnValue
  public static UserServiceTestAssert assertThat(UserServiceTest actual) {
    return new UserServiceTestAssert(actual);
  }
}