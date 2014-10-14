/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antTasks;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 *
 * @author eslem
 */
public class MyAntTask extends Task{
    
    @Override
    public void execute() throws BuildException {
        System.out.println("testing own ant task");
    }
}
