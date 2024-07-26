package br.com.alurafood.pedidos.ampq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.alurafood.pedidos.dto.PagamentoDto;

@Component
public class PagamentoListener {
	
	@RabbitListener(queues = "pagamento.concluido")
	public void recebeMensagem(PagamentoDto pagamento) {
		String mensagem = """
				Dados do pagamento: %s
				Número do pedido: %s
				Valor R$: %s
				Status: %s
				""".formatted(pagamento.getId(), pagamento.getPedidoId(), pagamento.getValor(), pagamento.getStatus());
		
		System.out.println("Recebi a mensagem "+ mensagem);
	}

}