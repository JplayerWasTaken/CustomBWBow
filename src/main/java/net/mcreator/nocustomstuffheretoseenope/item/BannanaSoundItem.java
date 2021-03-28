
package net.mcreator.nocustomstuffheretoseenope.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.nocustomstuffheretoseenope.NocustomstuffheretoseenopeModElements;

@NocustomstuffheretoseenopeModElements.ModElement.Tag
public class BannanaSoundItem extends NocustomstuffheretoseenopeModElements.ModElement {
	@ObjectHolder("nocustomstuffheretoseenope:bannana_sound")
	public static final Item block = null;
	public BannanaSoundItem(NocustomstuffheretoseenopeModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, NocustomstuffheretoseenopeModElements.sounds.get(new ResourceLocation("nocustomstuffheretoseenope:bannana")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("bannana_sound");
		}
	}
}
