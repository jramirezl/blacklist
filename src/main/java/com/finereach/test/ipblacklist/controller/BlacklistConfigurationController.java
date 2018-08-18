package com.finereach.test.ipblacklist.controller;

import com.finereach.test.ipblacklist.entity.IpBlock;
import com.finereach.test.ipblacklist.service.BlacklListService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class BlacklistConfigurationController {

    final BlacklListService blacklListService;

    @Autowired
    BlacklistConfigurationController( BlacklListService blacklListService) {
        this.blacklListService = blacklListService;
    }


    @ApiOperation(
            value = "Get the list of a blacklist",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get BatchId returned Batch Object in the response body"),
            @ApiResponse(code = 404, message = "Batch not found"),
            @ApiResponse(code = 422, message = "Unable to get dash batch job response data for BatchId:")})
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<IpBlock> findAll() {
        return blacklListService.getBlacklist();
    }

    @RequestMapping(value = "/{ip}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public IpBlock findOne(@PathVariable("ip") String ip) {
        return blacklListService.getIpBlacklist( ip );
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public IpBlock create(@RequestBody String ip) {
        return blacklListService.addIpBlacklist(ip);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) String ip, @RequestBody IpBlock resource) {
        //Preconditions.checkNotNull(resource);
        //RestPreconditions.checkNotNull(service.getById( resource.getId()));
        //blacklListService.update(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("ip") String ip) {
        blacklListService.deleteIpBlacklist(ip);
    }
    
}
