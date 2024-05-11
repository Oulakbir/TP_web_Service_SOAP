package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "BanqueWS")
public class BanqueService {

    // Convertir un montant de l’euro en DH
    @WebMethod(operationName = "ConversionEuroToDH")
    public double conversion( @WebParam(name = "Montant") double mt){
        return mt*11;
    }

    // tester le web service
    @WebMethod
    public String test(){
        return "Test";
    }

    //Consulter un Compte
    @WebMethod
    public Compte getCompte(int code){
        return new Compte(code,Math.random()*60000,new Date());
    }

    // Consulter une Liste de comptes
    @WebMethod
    public List<Compte> getComptes(){
        List<Compte> cptes=new ArrayList<Compte>();
        cptes.add(new Compte(1,Math.random()*60000,new Date()));
        cptes.add(new Compte(2,Math.random()*60000,new Date()));
        cptes.add(new Compte(3,Math.random()*60000,new Date()));
        return cptes;
    }




}
