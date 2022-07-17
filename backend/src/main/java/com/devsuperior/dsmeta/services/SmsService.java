package com.devsuperior.dsmeta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository saleRepository;

	public void notifySms(Long saleId) {
		
		Sale sale =saleRepository.findById(saleId).get();
        StringBuilder mensagem= new StringBuilder();
        mensagem.append("O vendedor ")                
                .append(sale.getSeller_name())
                .append("foi destaque em ")
                .append(sale.getDate().getMonthValue() + "/" + sale.getDate().getYear())
                .append(" com um total de R$ ")
                .append(String.format("%.2f",sale.getAmount()));
		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, mensagem.toString()).create();

		System.out.println(message.getSid());
	}
}
