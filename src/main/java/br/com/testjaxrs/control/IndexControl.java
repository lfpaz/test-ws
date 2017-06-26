/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.testjaxrs.control;

import br.com.testjaxrs.ejb.EjbService;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lfpaz
 */
@Named
public class IndexControl  implements Serializable{
    
    @Inject
    private EjbService segundo;

    public String sayHello() {
        return segundo.testEjb();
    }
}
