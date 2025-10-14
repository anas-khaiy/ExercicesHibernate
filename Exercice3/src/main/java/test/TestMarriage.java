package test;

import classes.Marriage;
import classes.MarriagePK;
import services.FemmeService;
import services.HommeService;
import services.MarriageService;

import java.sql.Date;

public class TestMarriage {

    public static void main(String[] args) {


        MarriageService ms=new MarriageService();
        FemmeService fs=new FemmeService();
        HommeService hs=new HommeService();


        Marriage m1=new Marriage(Date.valueOf("1999-10-10"),null,1,hs.getByID(4),fs.getByID(10));
        Marriage m2=new Marriage(Date.valueOf("1993-10-10"),null,2,hs.getByID(4),fs.getByID(11));
        Marriage m3=new Marriage(Date.valueOf("1994-10-10"),Date.valueOf("2023-10-10"),1,hs.getByID(4),fs.getByID(12));


        ms.create(m1);
        ms.create(m2);
        ms.create(m3);



    }
}
