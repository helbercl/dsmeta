package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service // componente do sistema
public class SaleService {
//Responsavel pela parte de negocio do sistema.

	@Autowired
	private SaleRepository saleRepository;// quem acessa o banco de dados..Utilizamos o repository para acessar o banco
											// de dados.

	public List<Sale> findSales() {
		return saleRepository.findAll();// busca todas vendas
	}

}
