interface Acount {
    int depositAmount(); // 存款

    float depositInterest(int year); // 利率

    String expireEra(); // 到期年號

    String expireYear(); // 到期年份
}