package com.artezio.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StringHelperTesting.class,
        ParameterizedTesting.class,
        StubAndMockTesting.class,
        RepositoryTesting.class
})
public class FeatureTestSuite {
}
