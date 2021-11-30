/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.facturacion.dao.impl;

import co.edu.udea.facturacion.dao.EnvioMailDAO;
import co.edu.udea.facturacion.dao.ParametroGeneralDAO;
import co.edu.udea.facturacion.dto.ParametroGeneral;
import co.edu.udea.facturacion.dto.ParametroMail;
import co.edu.udea.facturacion.exception.GIDaoException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author jorge.correa
 */
public class EnvioMailDAOimpl implements EnvioMailDAO{
    
    private String mailSMTPServer;
    private String mailSMTPServerPort;
    private String mailSenha;

    @Override
    public void sendMail(ParametroMail parametroMail) throws GIDaoException {
        Properties props = new Properties();      
        String from = null;     
               
        ParametroGeneralDAO parametroGeneralDAO = new ParametroGeneralDAOImpl();
        ParametroGeneral parametroGeneral = parametroGeneralDAO.obtenerParametrosGenerales();
        
        if (parametroGeneral != null){
            mailSMTPServer = parametroGeneral.getNombreServidor();
            mailSMTPServerPort = parametroGeneral.getNumeroPuerto().toString();
            mailSenha = parametroGeneral.getClaveConexion();
            from = parametroGeneral.getUsuarioConexion();
                        
            props.put("mail.transport.protocol","smtp");
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.host",mailSMTPServer);        
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.user",from);
            props.put("mail.smtp.debug","true");       
            props.put("mail.smtp.port",mailSMTPServerPort);                       
            props.put("mail.smtp.socketFactory.port",mailSMTPServerPort);            
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback","false");            

            SimpleAuth auth = new SimpleAuth(from,mailSenha);           

            Session session = Session.getDefaultInstance(props,auth);
            session.setDebug(false);

            Message msg = new MimeMessage(session);

            try{                
                msg.setRecipient(Message.RecipientType.TO, new InternetAddress(parametroMail.getDestinatario()));
                msg.setFrom(new InternetAddress(from));                
                msg.setSubject(parametroMail.getAsunto());                            
                msg.setText(parametroMail.getMensaje());

            }catch(Exception e){
                new GIDaoException("Se generó un error  preparando el objeto Mail.", e);
            }

            Transport tr;
            try{                
                tr = session.getTransport("smtp");
                tr.connect(mailSMTPServer,from,mailSenha);
                msg.saveChanges();
                tr.sendMessage(msg, msg.getAllRecipients());
                tr.close();
            }catch(Exception e){
                new GIDaoException("Se generó un error enviando el Mail al destinatario " + parametroMail.getDestinatario(), e);
            }        
        }
    }    
}

class SimpleAuth extends Authenticator{
    
    public String username = null;
    public String password = null;
    
    public SimpleAuth(String user, String pwd){
        username = user;
        password = pwd;
    }
    
    @Override
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(username,password);
    }
    
}
