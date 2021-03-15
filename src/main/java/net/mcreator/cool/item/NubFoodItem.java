
package net.mcreator.cool.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.Blocks;

import net.mcreator.cool.itemgroup.NubyStuffItemGroup;
import net.mcreator.cool.CoolModElements;

@CoolModElements.ModElement.Tag
public class NubFoodItem extends CoolModElements.ModElement {
	@ObjectHolder("cool:nub_food")
	public static final Item block = null;
	public NubFoodItem(CoolModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(NubyStuffItemGroup.tab).maxStackSize(64).rarity(Rarity.RARE)
					.food((new Food.Builder()).hunger(1).saturation(0.3f).setAlwaysEdible().build()));
			setRegistryName("nub_food");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.SPEAR;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = new ItemStack(Blocks.TNT, (int) (1));
			super.onItemUseFinish(itemstack, world, entity);
			if (itemstack.isEmpty()) {
				return retval;
			} else {
				if (entity instanceof PlayerEntity) {
					PlayerEntity player = (PlayerEntity) entity;
					if (!player.isCreative() && !player.inventory.addItemStackToInventory(retval))
						player.dropItem(retval, false);
				}
				return itemstack;
			}
		}
	}
}
