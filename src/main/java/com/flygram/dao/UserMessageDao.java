package com.flygram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.AccountMessages;

public interface UserMessageDao extends CrudRepository<AccountMessages, Long> {

}
