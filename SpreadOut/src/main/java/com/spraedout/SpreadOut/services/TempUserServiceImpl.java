package com.spraedout.SpreadOut.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spraedout.SpreadOut.modal.TempUser;
import com.spraedout.SpreadOut.repository.TempUserRepository;

@Service
public class TempUserServiceImpl implements TempUserService{
	@Autowired
	TempUserRepository tempUserRepository;
	@Override
	public void save(TempUser tempUser) {
		// TODO Auto-generated method stub
		tempUserRepository.save(tempUser);
		
	}
	@Override
	public TempUser getTempUserByMobile(String mobile) {
		// TODO Auto-generated method stub
		return tempUserRepository.findByMobile(mobile);
	}
	
	@Override
	public boolean verifyOtp(TempUser user, TempUser tempUser) {
		// TODO Auto-generated method stub
		if(user.getVerificationCode().equals(tempUser.getVerificationCode())){
			return true;
		}
		return false;
	}

}
