
package net.mcreator.cool.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.mcreator.cool.itemgroup.ProStuffItemGroup;
import net.mcreator.cool.CoolModElements;

@CoolModElements.ModElement.Tag
public class ProBodItem extends CoolModElements.ModElement {
	@ObjectHolder("cool:pro_bod_helmet")
	public static final Item helmet = null;
	@ObjectHolder("cool:pro_bod_chestplate")
	public static final Item body = null;
	@ObjectHolder("cool:pro_bod_leggings")
	public static final Item legs = null;
	@ObjectHolder("cool:pro_bod_boots")
	public static final Item boots = null;
	public ProBodItem(CoolModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish"));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.PRISMARINE_CRYSTALS, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "pro_bod";
			}

			public float getToughness() {
				return 5f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ProStuffItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "cool:textures/models/armor/probod_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("pro_bod_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ProStuffItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "cool:textures/models/armor/probod_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("pro_bod_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ProStuffItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "cool:textures/models/armor/probod_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("pro_bod_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ProStuffItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "cool:textures/models/armor/probod_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("pro_bod_boots"));
	}
}
