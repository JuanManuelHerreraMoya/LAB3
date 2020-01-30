package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person("Juan",100240030,19,Gender.MALE,true);

        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);//esta bien


        Person person2 = new Person("Santiago",100240030,20,Gender.MALE,true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);


        Person person3 = new Person("Mauro",100240031,19,Gender.MALE,false);

        RegisterResult result3 = registry.registerVoter(person3);
        Assert.assertEquals(RegisterResult.DEAD, result3);


        //Person person4 = new Person("David",900240030,19,null,true);

        //RegisterResult result4 = registry.registerVoter(person4);
        //Assert.assertEquals(RegisterResult.INVALID, result4);


        //Person person5 = new Person("",35478922,35,Gender.FEMALE,true);

        //RegisterResult result5 = registry.registerVoter(person5);
        //Assert.assertEquals(RegisterResult.INVALID, result5);


        Person person6 = new Person("Carlos",1154240030,40,Gender.UNIDENTIFIED,true);

        RegisterResult result6 = registry.registerVoter(person6);
        Assert.assertEquals(RegisterResult.INVALID, result6);


    }


    // TODO Complete with more test cases
}