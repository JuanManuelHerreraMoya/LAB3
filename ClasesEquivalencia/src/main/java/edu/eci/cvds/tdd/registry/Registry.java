package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;

public class Registry {
    public ArrayList<Person> personasRegistradas = new ArrayList<Person>();
    public int cont ;

    public RegisterResult registerVoter(Person p) {
        if (p.getAge() > 17) {
            if ((p.getName()).length() > 0) {
                if (p.getGender().equals(Gender.MALE) || p.getGender().equals(Gender.FEMALE) || p.getGender().equals(Gender.UNIDENTIFIED)) {
                    if (p.isAlive()) {
                        if (personasRegistradas.size() == 0) {
                            personasRegistradas.add(p);
                            return RegisterResult.VALID;
                        }
                        else{
                            if (estaEnLista(p)) {
                                return RegisterResult.DUPLICATED;
                            }
                        }
                    }
                    return RegisterResult.DEAD;
                }
                return RegisterResult.INVALID;
            }
            return RegisterResult.INVALID;
        }
        return RegisterResult.INVALID_AGE;
        // TODO Validate person and return real result
    }
    public boolean estaEnLista(Person p){
        boolean existe = false;
        for (int i = 0 ;i<personasRegistradas.size();i++){
            if (p.getId() == personasRegistradas.get(i).getId()){
                existe = true;
            }
        }
        return existe;
    }
}