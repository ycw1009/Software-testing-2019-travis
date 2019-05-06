public class Deposit {
	public static String deposit(Acount customer, int startYear) {
		float money = customer.depositAmount(); // 存款
		String era = customer.expireEra(); // 年號
		int endYear = customer.expireYear(); // 年份
		if (era.equals("昭和")) {
			endYear += 1926;
		} else if (era.equals("平成")) {
			endYear += 1989;
		} else if (era.equals("令和")) {
			endYear += 2019;
		}
		assert (startYear <= endYear);

		for (int year = startYear; year < endYear; year++) {
			float interest = customer.depositInterest(year); // 利率
			money *= (1 + interest);
		}

		if (endYear >= 2019) {
			era = "令和";
			endYear -= 2019;
		} else if (endYear >= 1989) {
			era = "平成";
			endYear -= 1989;
		} else if (endYear >= 1926) {
			era = "昭和";
			endYear += 1926;
		}
		String result = era + endYear + "年: " + money;
		return result;
	}
}
