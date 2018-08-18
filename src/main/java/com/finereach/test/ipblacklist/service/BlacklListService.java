package com.finereach.test.ipblacklist.service;

import com.finereach.test.ipblacklist.entity.IpBlock;

import java.util.List;

public interface BlacklListService {
    public IpBlock addIpBlacklist(String ip);
    public void deleteIpBlacklist(String ip);
    public List<IpBlock> getBlacklist();
    public IpBlock getIpBlacklist(String ip);
}
