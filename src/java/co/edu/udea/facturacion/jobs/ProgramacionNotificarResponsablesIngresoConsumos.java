/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.jobs;

import co.edu.udea.facturacion.exception.GIDaoException;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author jorge.correa
 */
public class ProgramacionNotificarResponsablesIngresoConsumos {
    
    public void crearProgramacion(){
        
        Integer intError=0;
        
        try {
            // Creación de una instancia de Scheduler.
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();   
            scheduler.start(); 
            
            intError = 1;
            
            // Creación de una instancia de JobDetail.
            JobDetail jobDetail = new JobDetail("NotificarResponsablesIngresoConsumosJob", Scheduler.DEFAULT_GROUP, NotificarResponsablesIngresoConsumos.class);

             intError = 2;
            
            // Se crea el trigger para ejecución el último día de cada mes a las 22:00.            
            Trigger trigger = new CronTrigger("NotificarResponsablesIngresoConsumosTrigger", Scheduler.DEFAULT_GROUP, "0 0 8 20 * ?");
            
             intError = 3;

            // Registro dentro del Scheduler.
            scheduler.scheduleJob(jobDetail, trigger);
            
             intError = 4;

            // Damos tiempo a que el Trigger registrado termine su periodo de vida dentro del scheduler.
            Thread.sleep(60000);
            
             intError = 5;

            // Detenemos la ejecución de la instancia de Scheduler.
            scheduler.shutdown();
            
             intError = 6;

        } catch(Exception e) {
            new GIDaoException("Se generó un error al ejecutar la tarea NotificarResponsablesIngresoConsumos. Variable error = " +  intError, e);
        }
    }    
}
