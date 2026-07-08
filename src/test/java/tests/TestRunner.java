package tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({

	RegisterTest.class,
	CreateUserTest.class,
    LoginTest.class,
    BillPayTest.class,
    FindTransactionTest.class,
    RequestLoanTest.class,
    TransferFundsTest.class,
    UpdateContactInfoTest.class,
    EndToEndTest.class,
    DataDrivenRegisterTest.class

})
public class TestRunner {
}