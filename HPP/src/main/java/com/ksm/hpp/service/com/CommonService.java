package com.ksm.hpp.service.com;

import org.springframework.stereotype.Service;

@Service("CommonService")
public class CommonService {
	public String test(String test) {
		System.out.println(test);
		return test;
	}
}
