
package net.mcreator.cool.painting;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.entity.item.PaintingType;

import net.mcreator.cool.CoolModElements;

@CoolModElements.ModElement.Tag
public class ProPicPainting extends CoolModElements.ModElement {
	public ProPicPainting(CoolModElements instance) {
		super(instance, 10);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(32, 60).setRegistryName("pro_pic"));
	}
}
