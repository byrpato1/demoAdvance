package com.entrevista.demo.od.filtros;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.entrevista.demo.od.modelos.Catalogo;

public class FiltroCatalogo implements Specification<Catalogo> {
 
    private Long catalogoPadreId;
    private Boolean soloPadres;
    private Long[] ids;

	public FiltroCatalogo(Long catalogoPadreId, Boolean soloPadres) {
		super();
		this.catalogoPadreId = catalogoPadreId;
		this.soloPadres = soloPadres;
	}

	public FiltroCatalogo(Long[] ids) {
		super();
		this.ids = ids;
	}

	@Override
	public Predicate toPredicate(Root<Catalogo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		query.orderBy(cb.asc(root.get("valor")));
		if(catalogoPadreId!=null) {
			return cb.equal(root.get("catalogoPadreId"), catalogoPadreId);
		}
		if(soloPadres!=null) {
			return cb.isNull(root.get("catalogoPadreId"));
		}
		
		if (ids!=null && ids.length>0) {
			
			return cb.and(cb.equal(root.get("estado"), true), root.get("catalogoPadreId").in(ids));
		}
		return null;
	}
}
