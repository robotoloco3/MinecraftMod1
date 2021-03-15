
package net.mcreator.cool.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.cool.CoolModElements;

@CoolModElements.ModElement.Tag
public class ProStuffItemGroup extends CoolModElements.ModElement {
	public ProStuffItemGroup(CoolModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabpro_stuff") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.DRAGON_HEAD, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
