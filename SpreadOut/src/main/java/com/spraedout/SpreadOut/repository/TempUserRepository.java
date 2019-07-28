package com.spraedout.SpreadOut.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spraedout.SpreadOut.modal.TempUser;


public interface TempUserRepository  extends  JpaRepository<TempUser, Long>{
	TempUser findByMobile(String mobile);
}
