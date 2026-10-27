/**
 * @author Ostrovskiy Dmitriy
 * @created 05.07.2020
 * JmsProductBean
 * @version v1.0
 */

package ru.geekbrains.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.service.impl.local.ProductServiceLocalInterface;
import ru.geekbrains.service.repr.ProductRepr;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/toDoQueue"),
        @ActivationConfigProperty(propertyValue = "messageSelector", propertyName = "action = 'create'"),
        @ActivationConfigProperty(propertyValue = "messageSelector", propertyName = "action = 'delete'"),
        @ActivationConfigProperty(propertyValue = "messageSelector", propertyName = "action = 'update'"),
        @ActivationConfigProperty(propertyValue = "messageSelector", propertyName = "action = 'getAll'")
}
)
public class JmsProductBean implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(JmsProductBean.class);

    @EJB
    private ProductServiceLocalInterface prodService;

    @Override
    public void onMessage(Message message) {
        logger.info("New JMS msg");

        if (message instanceof ObjectMessage) {
            ObjectMessage om = (ObjectMessage) message;

            try {
                ProductRepr productRepr = (ProductRepr) om.getObject();
                if (om.getPropertyNames().equals("action = 'create'")) {
                    prodService.insertProduct(productRepr);
                }
                if (om.getPropertyNames().equals("action = 'update'")){
                    prodService.updateProduct(productRepr);
                }
                if (om.getPropertyNames().equals("action = 'delete'")){
                    prodService.deleteProduct(productRepr.getId());
                }
                if (om.getPropertyNames().equals("action = 'getAll'")){
                    prodService.findAllProduct();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
