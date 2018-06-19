package com.example.jiaqi.notepad.entity;

/**
 * Created by JiaQi on 2018/6/12.
 * 密码bean
 */

public class PassWord {
    private int num1;//第一位密码
    private int num2;
    private int num3;
    private int num4;

    private int nownumber = 0;//当前数值

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum3() {
        return num3;
    }

    public void setNum3(int num3) {
        this.num3 = num3;
    }

    public int getNum4() {
        return num4;
    }

    public void setNum4(int num4) {
        this.num4 = num4;
    }

    public int getNownumber() {
        return nownumber;
    }

    public void setNownumber(int nownumber) {
        this.nownumber = nownumber;
    }

    /**
     * 添加一位密码
     * 成功返回 ture
     * 失败 返回 flase
     * @return
     */
    public boolean addNumber(int number){
        switch (nownumber){
            case 0:
                num1 = number;
                nownumber = 1;
                break;
            case 1:
                num2 = number;
                nownumber = 2;
                break;
            case 2:
                num3 = number;
                nownumber = 3;
                break;
            case 3:
                num4 = number;
                nownumber = 4;
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * 删除一位数字
     */
    public boolean delNumber(){
        switch (nownumber){
            case 1:
                nownumber = 0;
                break;
            case 2:
                nownumber = 1;
                break;
            case 3:
                nownumber = 2;
                break;
            case 4:
                nownumber = 3;
                break;
            default:
                return false;
        }
        return true;
    }


    /**
     * 判断是否完成四位数字
     */
    public boolean isDoen(){
        if(nownumber == 4){
            return true;
        }
        return false;
    }
}
