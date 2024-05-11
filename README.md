
# Web-Service-SOAP --- Réalisé par : Meriame ZAOUIA

Ce Web service permet de : 
   
    • Convertir un montant de l’euro en DH
    • Consulter un Compte
    • Consulter une Liste de comptes




## Banque Web Service


```bash
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

```






## le Web service est déployé avec un Serveur JaxWS

```bash

package ws;

import jakarta.xml.ws.Endpoint;

public class ServerJWS {
    public static void main(String[] args) {

        String url= "http://0.0.0.0:8787/";
        Endpoint.publish(url,new BanqueService());
        System.out.println("Web service deploye sur "+url);

    }
}
```






## Le WSDL consulté via un Browser HTTP

![image](https://github.com/MeriameZaouia/Web-Service-SOAP/assets/92438936/dd4f90ec-32c7-433d-a3c0-bb6c91dad524)



## Test des opérations du web service avec SoapUI

ConversionEuroToDH()
![image](https://github.com/MeriameZaouia/Web-Service-SOAP/assets/92438936/f774ac39-6d1a-4d82-8d94-d284200c4e8d)

getCompte()
![image](https://github.com/MeriameZaouia/Web-Service-SOAP/assets/92438936/4cbceee3-c290-45f5-ad04-6c31cebc5f48)

getComptes()
![image](https://github.com/MeriameZaouia/Web-Service-SOAP/assets/92438936/97bf6b8f-5ae7-45b9-bbd1-03ced1a731fd)
## Création d'un client SOAP Java


Pour intégrer le service dans une application Java, les étapes suivantes sont nécessaires :

### Générer le stub(proxy coté client) à partir du WSDL.


<img width="701" alt="image" src="https://github.com/MeriameZaouia/Web-Service-SOAP/assets/92438936/7773e67c-d2ea-4bb2-9474-4e2da410280a">

<img width="356" alt="image" src="https://github.com/MeriameZaouia/Web-Service-SOAP/assets/92438936/9f349231-20be-4e20-9c2b-18d898f1d907">


### Créer un client SOAP pour interagir avec le web service.

```bash
public class ClientWS {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueWS().getBanqueServicePort();
        System.out.println(proxy.conversionEuroToDH(80));}}
```






