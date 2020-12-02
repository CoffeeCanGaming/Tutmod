package coffee.ccg.tutmod.util.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class PlayerCapabilities implements IEnergyStorage{

	
	
	public static void addCapabilty(AttachCapabilitiesEvent<Entity> event) {
		
		if(event.getObject() instanceof PlayerEntity) {
			
		}
	}
	
	@Override
	public int receiveEnergy(int maxReceive, boolean simulate) {
		
		return 0;
	}

	@Override
	public int extractEnergy(int maxExtract, boolean simulate) {
		
		return 0;
	}

	@Override
	public int getEnergyStored() {
		
		return 0;
	}

	@Override
	public int getMaxEnergyStored() {
		
		return 0;
	}

	@Override
	public boolean canExtract() {
		
		return false;
	}

	@Override
	public boolean canReceive() {
		
		return false;
	}

}
