package com.finereach.test.ipblacklist.service;

import com.finereach.test.ipblacklist.entity.IpBlock;
import com.finereach.test.ipblacklist.jpa.IpBlackListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlacklListServiceImpl implements BlacklListService {


    @Autowired
    private IpBlackListRepository ipBlackListRepository;


    @Override
    public IpBlock addIpBlacklist(IpBlock ipBlock) {
        return ipBlackListRepository.save(ipBlock);
    }

    @Override
    public void deleteIpBlacklist(String ip) {
        ipBlackListRepository.delete(ipBlackListRepository.findByIp(ip));
    }

    @Override
    public List<IpBlock> getBlacklist() {
        return ipBlackListRepository.findAll();
    }

    @Override
    public IpBlock getIpBlacklist(String ip) {
        return ipBlackListRepository.findByIp(ip);
    }
}
