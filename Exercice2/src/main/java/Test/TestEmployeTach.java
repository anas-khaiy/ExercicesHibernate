package Test;

import classes.EmployeTache;
import services.EmployeService;
import services.EmployeTacheService;
import services.ProjetService;
import services.TacheService;

import java.sql.Date;

public class TestEmployeTach {


    public static void main(String[] args) {

        EmployeService es=new EmployeService();
        TacheService ts=new TacheService();
        EmployeTacheService ets=new EmployeTacheService();
        ProjetService ps=new ProjetService();

        EmployeTache employeTache=new EmployeTache(es.getByID(4),ts.getByID(1), Date.valueOf("2018-10-10"),Date.valueOf("2019-10-10"));
        EmployeTache employeTache2=new EmployeTache(es.getByID(4),ts.getByID(2), Date.valueOf("2013-10-10"),Date.valueOf("2018-10-10"));
        EmployeTache employeTache3=new EmployeTache(es.getByID(5),ts.getByID(1), Date.valueOf("2014-10-10"),Date.valueOf("2015-10-10"));
        EmployeTache employeTache4=new EmployeTache(es.getByID(6),ts.getByID(3), Date.valueOf("2015-10-10"),Date.valueOf("2016-10-10"));

//        ets.create(employeTache);
//        ets.create(employeTache2);
//        ets.create(employeTache3);
//        ets.create(employeTache4);


        ets.afficherInfoTache(4);

    }



}
