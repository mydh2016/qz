package com.qazit.hospital.web.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.qazit.hospital.web.model.SMSParamModel;

@WebService
public interface SMSInterfaceService {
	@WebMethod
	public String sendMessage(@WebParam(name = "paramModel") SMSParamModel paramModel);

}
