package com.springboot.rest.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.data.CustomerData;
import com.springboot.rest.entity.CustomerEntity;
import com.springboot.rest.entity.QueryConstant;

@Service("csJpaImpl")
@Transactional
public class CustomerServiceJpaImplementation implements CustomerService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomerMapper mapper;

	@Override
	public CustomerData createCustomer(CustomerData customer) {

		CustomerEntity entity = mapper.mapToCustomerEntity(customer);
		em.persist(entity);
		customer.setId(entity.getPk());
		return customer;
	}

	@Override
	public void modifyCustomer(CustomerData customer) {
		CustomerEntity entity = em.find(CustomerEntity.class, customer.getId());
		entity = mapper.mapToCustomerEntity(entity, customer);
		em.persist(entity);

	}

	@Override
	public CustomerData findCustomer(Long id) {
		// TODO Auto-generated method stub
		final CustomerEntity entity = em.find(CustomerEntity.class, id);
		final CustomerData result = mapper.mapToCustomerData(entity);
		return result;
	}

	@Override
	public List<CustomerData> searchCustomer(String name) {
		String search = name + "%";
		final TypedQuery<CustomerEntity> query = em.createNamedQuery(QueryConstant.CUSTOMER_SEARCH,
				CustomerEntity.class);
		query.setParameter("searchStr", search);
		final List<CustomerEntity> results = query.getResultList();
		return mapper.mapToCustomerDataList(results);
	}

	@Override
	public void removeCustomer(Long id) {
		// TODO Auto-generated method stub
		final CustomerEntity entity = em.find(CustomerEntity.class, id);
		em.remove(entity);

	}

}
