package com.aaturenko.controller;

import com.aaturenko.model.EmployeeFromClient;
import com.aaturenko.service.DataServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.Set;


/**
 * Created by Anastasia on 12.04.2017.
 */
@Controller
public class DataController extends ExceptionHandlerController {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandlerController.class); //Logger.getLogger(ExceptionHandlerController.class);

    @Autowired
    @Qualifier("dataService")
    private DataServiceImpl dataService;

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public @ResponseBody String getOrgs() throws RestException {
        try {
            Set<String> result = dataService.getOrgs();
            return result.toString();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public @ResponseBody String getPosts() throws RestException {
        try {
            return dataService.getPosts().toString();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public @ResponseBody String getStaff() throws RestException {
        try {
            return dataService.getStaff().toString();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/save_employees", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> saveEmployees(@RequestBody EmployeeFromClient employeeFromClient) throws RestException {
        try {
            LOG.info(employeeFromClient.getMiddleName());
            if (dataService.saveEmployees(employeeFromClient)) {
                return Ajax.emptyResponse();
            }
            else{
                return Ajax.errorResponse("Data error.");
            }
        } catch (Exception e) {
            throw new RestException(e);
        }
    }


}