package br.com.bossini.aula08_spring_mvc_boot_hibernate_jpa.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.bossini.aula08_spring_mvc_boot_hibernate_jpa.model.beans.Veiculo;
import br.com.bossini.aula08_spring_mvc_boot_hibernate_jpa.model.repository.JPAUtil;

public class InsereVeiculo {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		
		Veiculo car = new Veiculo();
		car.setMarca("volkswagen");
		car.setModelo("GOL");
		car.setAnoModelo(2021);
		manager.persist(car);
		
		transaction.commit();
		
		manager.close();
		JPAUtil.close();
	}

}
