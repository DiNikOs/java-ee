/**
 * @author Ostrovskiy Dmitriy
 * @created 04.07.2020
 * JmsClient
 * @version v1.0
 */

package ru.dinikos.client;

import ru.geekbrains.entity.Product;
import ru.geekbrains.service.repr.ProductRepr;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;

import static ru.dinikos.client.EjbClient.createInitialContext;

public class JmsClient {

    public static void main(String[] args) throws Exception {
        Context context = createInitialContext();

        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
        JMSContext jmsContext = connectionFactory.createContext("jmsGuestUser", "12345");

        Destination dest = (Destination) context.lookup("jms/queue/toDoQueue");

        JMSProducer producer = jmsContext.createProducer();

        ObjectMessage messageProductCreate = jmsContext.createObjectMessage(new ProductRepr(null,"Product test", "JMS test", bd(100),1L, null, new Date()));

        producer.setProperty("action", "create").send(dest, messageProductCreate);
    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(EjbClient.class.getClassLoader().getResourceAsStream("wildfly-jndi.properties"));
        return new InitialContext(env);
    }

    public static BigDecimal bd (int big){
        BigDecimal bd = new BigDecimal(big);
        return bd;
    }

}
