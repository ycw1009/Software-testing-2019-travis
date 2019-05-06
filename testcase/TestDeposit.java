import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.mockito.Mockito.*; // java mock: Mockito
import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.*;

public class TestDeposit {
	Acount userA;

	@Before
	public void setUpMock() {
		userA = mock(Acount.class);
	}

	@Test
	public void test1945To2019() {
		// 從二戰存錢到現在
		when(userA.depositAmount()).thenReturn(10000);
		when(userA.depositInterest(gt(2000))).thenReturn(0.08);
		when(userA.depositInterest(leq(2000))).thenReturn(0.02);
		when(userA.expireEra()).thenReturn("令和");
		when(userA.expireYear()).thenReturn(0);

		Deposit deposit = new Deposit(1945);
		String result = deposit.deposit(userA);
		assertEquals("令和0年: 121125", result);
	}

	//@Test
	public void test1945To1989() {
		// 從二戰結束存錢到昭和63年6月4日, 存178417
		// 利率都是2%

		// when...

		Deposit deposit = new Deposit(1945);
		String result = deposit.deposit(userA);
		assertEquals("平成0年: " + (int) expected, result);
	}

	//@Test
	public void test1974To1994() {
		// 從老師的年代到助教的年代,存一年薪水18000
		// 利率都是5%

		// when...

		Deposit deposit = new Deposit(1945);
		String result = deposit.deposit(userA);
		assertEquals("平成5年: 196583", result);
	}

	//@Test
	public void test1937To1945() {
		// 從二戰期間存40000元
		// 利率都是10%

		// when...

		Deposit deposit = new Deposit(1937);
		String result = deposit.deposit(userA);
		assertEquals("昭和19年: 85743", result);
	}
}
