interface Acount {
    int depositAmount(); // 存款

    double depositInterest(int year); // 利率

    String expireEra(); // 到期年號

    int expireYear(); // 到期年份
}
