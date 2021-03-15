package net.mcreator.cool.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cool.item.NubFoodItem;
import net.mcreator.cool.CoolModElements;

import java.util.function.Supplier;
import java.util.Map;

@CoolModElements.ModElement.Tag
public class GivetonubProcedure extends CoolModElements.ModElement {
	public GivetonubProcedure(CoolModElements instance) {
		super(instance, 1);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Givetonub!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((0 != (new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
							if (stack != null)
								return stack.getCount();
						}
					}
				}
				return 0;
			}
		}.getAmount((int) (182))))) {
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) (182))).decrStackSize((int) (1));
							_current.detectAndSendChanges();
						}
					}
				}
			}
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) (183))).decrStackSize((int) (1));
							_current.detectAndSendChanges();
						}
					}
				}
			}
			System.out.println("the nub thanks you");
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(NubFoodItem.block, (int) (1));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (182))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).giveExperiencePoints((int) 5);
		}
	}
}
