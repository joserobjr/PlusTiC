package landmaster.plustic.traits;

import landmaster.plustic.api.*;
import landmaster.plustic.net.*;
import landmaster.plustic.proxy.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.common.*;
import slimeknights.tconstruct.library.traits.*;

public class BrownMagic extends AbstractTrait {
	public static final BrownMagic brownmagic = new BrownMagic();
	
	public BrownMagic() {
		super("brownmagic", 0x3A1B00);
		Portal.portalable.add(identifier);
	}
	
	@Override
	public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (isSelected && FMLCommonHandler.instance().getSide().isClient()) {
			if (CommonProxy.keyBindings.get(3).isPressed()) {
				PacketHandler.INSTANCE.sendToServer(new PacketBrownAbracadabra());
			}
		}
	}
}
