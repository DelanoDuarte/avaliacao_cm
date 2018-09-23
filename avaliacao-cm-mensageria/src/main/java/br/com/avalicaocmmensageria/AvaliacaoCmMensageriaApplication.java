package br.com.avalicaocmmensageria;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.avalicaocmmensageria.service.Receiver;

@SpringBootApplication
public class AvaliacaoCmMensageriaApplication {

	static final String topicExchangeName = "avaliacaocm_mensageria";
	
	static final String queueName = "avaliacaocm_mensageria_queue";
	static final String queueName1 = "avaliacaocm_mensageria_queue";

	@Bean
	public List<Queue> qs() {
		return Arrays.asList(
				new Queue(queueName, false, false, true), 
				new Queue(queueName1, false, false, true)
		);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

    @Bean
    public List<Binding> bs() {
    	return Arrays.asList(
    			new Binding(queueName, DestinationType.QUEUE, topicExchangeName, "avaliacaocm_mensageria.#", null),
    			new Binding(queueName1, DestinationType.QUEUE, topicExchangeName, "", null)
    	);
    }

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoCmMensageriaApplication.class, args);
	}
}
