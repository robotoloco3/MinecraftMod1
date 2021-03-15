
package net.mcreator.cool.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.cool.block.NubBlock;
import net.mcreator.cool.CoolModElements;

@CoolModElements.ModElement.Tag
public class NubyStuffItemGroup extends CoolModElements.ModElement {
	public NubyStuffItemGroup(CoolModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabnuby_stuff") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(NubBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
