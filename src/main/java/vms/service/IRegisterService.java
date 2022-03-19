package vms.service;

import vms.entity.RegisterTrack;

public interface IRegisterService {
	
	Boolean save(RegisterTrack registerTrack);
	RegisterTrack find(RegisterTrack registerTrack);
	Boolean update(RegisterTrack registerTrack);
}
