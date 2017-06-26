package br.com.testjaxrs.ejb;

import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author lfpaz
 */
@Stateless
public class EjbService implements Serializable{
    
    public String testEjb(){
        return "THE POWER IS THE SOURCE CODE";
    }
}
