package com.springboot.rest.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.rest.data.CustomerData;

@Service
public class CustomerServiceInMemoryImpl implements CustomerService {

	private Map<Long, CustomerData> customerDBMap = new HashMap<Long, CustomerData>();

	@Override
	public CustomerData createCustomer(CustomerData customer) {
		// TODO Auto-generated method stub
		if (customer != null) {
			customer.setId(System.currentTimeMillis());
			customerDBMap.put(customer.getId(), customer);
		}
		return customer;
	}

	@Override
	public void modifyCustomer(final CustomerData customer) {
		// TODO Auto-generated method stub
		if (customerDBMap.containsKey(customer.getId())) {
			customerDBMap.put(customer.getId(), customer);
		} else {
			throw new RuntimeException("No customer found in the database");
		}
	}

	@Override
	public CustomerData findCustomer(Long key) {
		// TODO Auto-generated method stub
		return customerDBMap.get(key);
	}

	@Override
	public List<CustomerData> searchCustomer(String name) {
		// TODO Auto-generated method stub
		final List<CustomerData> result = new ArrayList<CustomerData>();
		final Collection<CustomerData> allCustomers = customerDBMap.values();

		for (CustomerData cData : allCustomers) {
			if (cData.getFirstName().toLowerCase().startsWith(name.toLowerCase())
					|| cData.getLastName().toLowerCase().startsWith(name.toLowerCase()))

				result.add(cData);
		}
		return result;
	}

	@Override
	public void removeCustomer(Long key) {
		// TODO Auto-generated method stub
		if (customerDBMap.containsKey(key)) {
			customerDBMap.remove(key);
		} else {
			throw new RuntimeException("No Customer found in the database");
		}

	}

}
