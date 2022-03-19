package vms.dao;

import vms.entity.RegisterTrack;

public interface IRegisterDao {
	public Boolean saveRegister(RegisterTrack registerTrack);
	public RegisterTrack findRegister(RegisterTrack registerTrack);
	public Boolean updateRegister(RegisterTrack registerTrack);
}
