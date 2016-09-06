package br.com.rh.dao;

import javax.persistence.Query;

import br.com.rh.bean.Candidato;

public class CandidatoDao extends JpaDaoBase<Candidato>{
	
	//Especificas para o objeto Candidato
	public Candidato findByNome(String nome) {
		Candidato candidato = null;
		if (nome == null || nome.equals("")) {
			return candidato;
		} else {
			Query query = em.createQuery("SELECT u FROM Candidato u WHERE nome = :nome");
			query.setParameter("nome", nome);
			
			if (query.getResultList().size() > 0) {
				candidato = (Candidato) query.getSingleResult();
			}
		}
		return candidato;
	}
}