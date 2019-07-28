package com.spraedout.SpreadOut.services;

import com.spraedout.SpreadOut.modal.TempUser;

public interface TempUserService {

	void save(TempUser tempUser);

	TempUser getTempUserByMobile(String mobile);

	boolean verifyOtp(TempUser user, TempUser tempUser);

	

}
