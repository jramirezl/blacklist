package com.finereach.test.ipblacklist.jpa;

import com.finereach.test.ipblacklist.entity.IpBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IpBlackListRepository extends JpaRepository<IpBlock, Long> {
    IpBlock findByIp(String ip);
}