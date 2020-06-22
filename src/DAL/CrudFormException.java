/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Lenovo
 */
public class CrudFormException extends Exception{
    public CrudFormException(){
    }
    
    public CrudFormException(String msg){
        super(msg);
}
    
}