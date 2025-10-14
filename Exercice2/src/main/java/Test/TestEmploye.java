package Test;

import classes.Employe;
import services.EmployeService;

public class TestEmploye {



    public static void main(String[] args) {
        EmployeService es=new EmployeService();



        Employe employe=new Employe("employe1","employe1","09533433");
        Employe employe2=new Employe("employe2","employe2","0873433");
        Employe employe3=new Employe("employe3","employe3","021533433");
        es.create(employe);
        es.create(employe2);
        es.create(employe3);
    }
}
